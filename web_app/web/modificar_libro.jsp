<%@page import="utez.app.model.LibroBean"%>
<%@page import="utez.app.model.AreaBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">
  <head>
    
	  <%@include file="incl_headmeta.html" %>

    <title> LYA Menu de Administrador </title>
    
    
  </head>

  <body>

    <!-- Static navbar -->
    <%@include file="incl_navbar.jsp" %>

    <%
	try{
		if (!(Boolean) session.getAttribute("admin")){
			throw new ServletException("Acceso denegado");
		}
	}catch (NullPointerException e){
		throw new ServletException("Acceso denegado");
	}
	LibroBean objetivo = new LibroBean();
	try{
		if (request.getAttribute("objetivo") == null){
			throw new ServletException("Objetivo no encontrado");
		}else{
			objetivo =(LibroBean) request.getAttribute("objetivo");
		}
	}catch (NullPointerException e){
		throw new ServletException("Objetivo no encontrado");
	}
	
	
    %>
    

	<!-- +++++ Welcome Section +++++ -->
	
	<div id="ww">
	    <div class="container">
		    <div class="row">
		    <div class="col-md-6 ">
			    <div class="page-header">
			    <h1>Administrador de LYA</h1>
			    </div>
		    </div>
		    </div>
			<div class="row">
		    
		    <div class="col-md-8 centered">
			    <!-- Agregar  -->
			    <div class="well" >
<form class="form-horizontal" 
      action="#" method="get" id="modificar-libro">
	<input type="hidden" name='id' value="<%=objetivo.getLibro_id()%>" />
	<input type="hidden" name='guardar' value="true" />
	<fieldset>
		<legend>Modificar Libro</legend>
		<div class="form-group">
			<input type="text" 
			       class="form-control" 
			       placeholder="Nombre"
			       name="nombre" 
			       required=""
			       value =
			       "<%=objetivo.getNombre()%>"
			       > 
		</div>

		<div class="form-group">
			<input type="number" 
			       class="form-control" 
			       placeholder="ISBN" 
			       name="isbn" 
			       required
			       value ="<%=objetivo.getIsbn()%>"
			       >
		</div>
		<div class="form-group">
			<input type="number" 
			       class="form-control" 
			       placeholder="Núm de Paginas" 
			       name="pags"
			       value=
			       "<%=objetivo.getPaginas()%>"
			       >
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label"
			       for="editorial-select">
				<small>Editorial</small>
			</label>

			<div class="col-md-8">
				<select id="editorial-select"
					name="editorial" 
					class="form-control">
					
				</select>
				<button id="new-editorial" 
					type=button 
					class="btn-sm btn btn-link">
					Nueva Editorial</button>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" 
			       for="area-select"><small>Area</small></label>
			<div class="col-md-8">
				<select id="area-select" name="area" class="form-control">
					
				</select>
				<button id='new-area' type=button class="btn-sm btn btn-link">
					Nueva Area</button>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="autor-select"><small>Autores</small></label>
			<div class="col-md-8">
				<select multiple id="autor-select" name="autores" class="form-control" required="">
					
				</select>
				<button id="new-autor" type=button class="btn-sm btn btn-link">
					Nuevo Autor</button>
			</div>
		</div>


		<div class="form-group">
			
			<button  type="submit" class="btn btn-primary pull-right" >Guardar</button>
			<a  class="btn btn-warning pull-right" href='Admin?sec=libro'>Cancelar</a>
		</div>
	</fieldset>
</form>	

			    </div>
		    </div > <!-- div -->


			</div> <!-- row -->

	    </div> <!-- /container -->
	    
	</div><!-- /ww -->
	
	
	<!-- +++++ Information Section +++++ -->
	


	<!-- +++++ Footer Section +++++ -->
	
	<%@include file="incl_footer.jsp" %>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/keepAlive.js"></script>
    
    
<script type="text/javascript">
	//script insertar opciones
	function loadAreaSelect(){
		$("#area-select").load("ServletOptionListArea?id=<%=objetivo.getArea().getArea_id()%>");
	}
	function loadAutorSelect(){
		<%int autorId = objetivo.getAutores().isEmpty()? -1 
			: objetivo.getAutores().get(0).getAutor_id();%>
		$("#autor-select").load("ServletOptionListAutor?id=<%=autorId%>");
	}
	function loadEditorialSelect(){
		$("#editorial-select").load("ServletOptionListEditorial?id=<%=objetivo.getEditorial().getEditorial_id()%>");
	}
	function loadLibroSelect(){
		$("#libro-select").load("ServletOptionListLibro");
	}
	function loadAll(){
		loadAreaSelect();
		loadAutorSelect();
		loadEditorialSelect();
		loadLibroSelect();
	}
	
	$(document).ready(function (){
		//cargar los select
		loadAll();
		
		//nuevos ingresos
		$("#new-editorial").click(function(){
			$("#extra").load("form_editorial.jsp");
		});
		$("#new-area").click(function(){
			$("#extra").load("form_area.jsp");
		});
		$("#new-autor").click(function(){
			$("#extra").load("form_autor.jsp");
		});
		
		$("#extra").on("submited", function(e){
			e.stopPropagation();
			loadAll();
			$("#extra form").hide();
			//$("#extra").html('<div class="alert alert-info"> Formulario enviado </div>');
			
		});
		
		$("#tab-libro-ejemplar").click(function (){
			loadLibroSelect();
		});
	});
</script>

<script type="text/javascript">
	
	$(document).ready(function (){
		
		//agregar Libro
		
		$("#agregar-libro").submit(function (){	
			var form = $(this);
			$.get(
				'AgregarLibro', 
				form.serialize(), function (data){
					 $( "#alert-form-libro" ).html( data );
					 form.trigger("submited");
				});
			
			$(this).find("input[type=text], textarea, input[type=number]").val("");
			
			return false;
		});
	});
</script>
    
  </body>
</html>