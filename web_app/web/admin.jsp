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
			request.setAttribute("warning", "sesion expirada");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}catch (NullPointerException e){
		throw new ServletException("Acceso denegado");
	}
	String seccion;
	if(request.getAttribute("seccion") != null){
		seccion = (String) request.getAttribute("seccion");
	}else{
		seccion = "usuario";
	}
    %>
    

	<!-- +++++ Welcome Section +++++ -->
	
	<div id="ww" >
		<div class="container">
		    <div class="row">
		    <div class="col-md-8 ">
			    <div class="page-header">
			    <h1>Administrador de LYA</h1>
			    </div>
		    </div>
		    </div>
			<div class="row">
		    <div class="col-md-9" >	
			    <ul class="nav nav-pills" id="selectPill">
				    <li id="selectUsr">
					    <a href="#"> 
						    Usuario 
					    </a>
				    </li>
				    <li id ="selectLib">
					 <a href="#"> Libro </a>   
				    </li>
				    <li id="selectAutor">
					 <a href="#"> Autor </a>   
				    </li>
				    <li id="selectEdito">
					 <a href="#"> Editorial </a>   
				    </li>
				    <li id="selectArea">
					 <a href="#"> Area </a>
				    </li>
			    </ul>
			    <script type="text/javascript">
				   //default
				   <% 
					String tab = null;
					String servlet = null;
					String form = null;					
					if(seccion.equals("usuario")){
						tab = "#selectUsr";
						servlet = "ServletTablaUsuario";
						form = "form_usuario.jsp";
					}else if(seccion.equals("libro")){
						tab = "#selectLib";
						servlet = "ServletTablaLibro";
						form = "form_libro.jsp";
					}else if(seccion.equals("autor")){
						tab = "#selectAutor";
						servlet = "ServletTablaAutor";
						form = "form_autor.jsp";
					}else if(seccion.equals("editorial")){
						tab = "#selectEdito";
						servlet = "ServletTablaEditorial";
						form = "form_editorial.jsp";
					}else{
						tab = "#selectArea";
						servlet = "ServletTablaArea";
						form = "form_area.jsp";
					}
				   %>
					   $(document).ready(function(){
				$("<%=tab%>").addClass("active");
				$.get("<%=servlet%>", function (responseText){
					$("#tbl").html(responseText);
				});
				$.get("<%=form%>", function (data){
					$("#agregar").html(data);
				});
			});
			    </script>
			    
			    <br>
			    <%--
			    <form class="form-horizontal">
				    <div class="col-md-6">
				<div class="input-group">
				    <input class="input-sm form-control" type="search"
					   placeholder="Busqueda" />
				    <span class="input-group-btn">
				    <button type="submit" class="btn btn-success btn-sm" >
				    Busqueda
				    </button>
				   </span>
				</div>
				    </div>
			    </form>
			    
			    <br><br>
			    --%>
			    <div id="tbl" style="overflow: auto; width: 100%">
				    <!-- Tabla -->
				    Elija una opción
			    </div>
			    
			    
		    </div>  <!-- col -->
		    
		    <div class="col-md-3 pull-right">
			    <!-- Agregar  -->
			    <div class="well" >
				    <div id="agregar">
					   <!-- form -->
				    </div>   
			    </div>
		    </div>
		    
		    
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
    
    <!-- my scripts -->
    <script type="text/javascript">	
	    $(document).ready(function(){  

		//seleccion
		$("#selectPill li").click(function(){
			$("ul li").removeClass("active");
			$(this).addClass("active");
		});
		//LIBRO
		$("#selectLib").click(function (){
			$.get("ServletTablaLibro", function (responseText){
				$("#tbl").html(responseText);
			});
		$("#agregar").load("form_libro.jsp");
		});
		//USUARIO
		$("#selectUsr").click(function (){
		$.get("ServletTablaUsuario", function (responseText){
			$("#tbl").html(responseText);
		});
		$("#agregar").load("form_usuario.jsp");
		});
		//AUTOR
		$("#selectAutor").click(function (){
		$.get("ServletTablaAutor", function (responseText){
			$("#tbl").html(responseText);
		});
		$("#agregar").load("form_autor.jsp");
		});
		//EDITORIAL
		$("#selectEdito").click(function (){
			$.get("ServletTablaEditorial", function (responseText){
				$("#tbl").html(responseText);
			});
			$("#agregar").load("form_editorial.jsp");
		});
		$("#selectArea").click(function (){
			$.get("ServletTablaArea", function (responseText){
				$("#tbl").html(responseText);
			});
			$("#agregar").load("form_area.jsp");
		});
		
		
	}); 
	
    </script>
    
    <script src="assets/js/keepAlive.js"></script>
  </body>
</html>