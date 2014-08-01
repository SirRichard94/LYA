
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<ul id="tab-libro-ejemplar" class="nav nav-tabs" role="tablist">
	<li class="active"><a data-toggle="tab" role="tab" href="#libro-tab">Libro</a></li>
	<li><a data-toggle="tab" role="tab" href="#ejemplar-tab">Ejemplar</a></li>
</ul>

<div id="alert-form-libro">
		
</div>

<div id="tab-libro-ejemplar-content" class="tab-content">
	<div id="libro-tab" class="tab-pane active" >
		<div id="extra"></div>
		
		<%-- FORM LIBRO--%>
		<form class="form-horizontal" action="#InsertarLibro" method="get" id="agregar-libro">
	<fieldset>
	<legend>Agregar Libro</legend>
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Nombre" name="nombre" required=""> 
	</div>
	<div class="form-group">
		<input type="number" class="form-control" placeholder="ISBN" name="isbn" required>
	</div>
	<div class="form-group">
		<input type="number" class="form-control" placeholder="Núm de Paginas" name="pags">
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="editorial-select"><small>Editorial</small></label>
		<div class="col-md-8">
			<select id="editorial-select" name="editorial" class="form-control">
				<option value="1">Option one</option>
				<option value="2">Option two</option>
			</select>
			<button id="new-editorial" type=button class="btn-sm btn btn-link">
				Nueva Editorial</button>
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="area-select"><small>Área</small></label>
		<div class="col-md-8">
			<select id="area-select" name="area" class="form-control">
				
			</select>
			<button id="new-area" type=button class="btn-sm btn btn-link">
				Nueva Area</button>
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="autor-select"><small>Autores</small></label>
		<div class="col-md-8">
			<select multiple id="autor-select" name="autores" class="form-control">
				<option value="1">Option one</option>
				<option value="2">Option two</option>
			</select>
			<button id="new-autor" type=button class="btn-sm btn btn-link">
				Nuevo Autor</button>
		</div>
	</div>
	
	
	<div class="form-group">
		<button  type="submit" class="btn btn-primary pull-right" >Crear</button>
	</div>
	</fieldset>
</form>	
		</div> <!-- tab pane -->
<div class="divider">
</div>

<%-- Agregar ejemplares --%>
<div id = "ejemplar-tab" class="tab-pane" >
	<form id="agregar-ejemplar" class="form-horizontal" action="AgregarEjemplares">
	<fieldset>
	<legend>Agregar Ejemplares</legend>
	<div class="form-group">
		<select class="form-control" name="libro" id="libro-select">
			
		</select>
	</div>
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Localización" name="l" required>
	</div>
	<div class="form-group">
		<input type="number" class="form-control" placeholder="Núm de Ejemplares" name="n">
	</div>
	
	<div class="form-group">
		<button type="submit" class="btn btn-primary pull-right">Agregar</button>
	</div>
	</fieldset>
</form>
</div>
</div> <!-- tab content -->

<script type="text/javascript">
	//agregar Ejemplar
	$(document).ready(function (){
		$("#agregar-ejemplar").submit(function (){
			var form = $(this);			
			$.get(
				'AgregarEjemplares', 
				form.serialize(), function (data){
					 $( "#alert-form-libro" ).html( data );
					 form.trigger("submited");
				});
			
			$(this).find("input[type=text], textarea, input[type=number]").val("");
			return false;
		});
		
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

<script type="text/javascript">
	//script insertar opciones
	function loadAreaSelect(){
		$("#area-select").load("ServletOptionListArea");
	}
	function loadAutorSelect(){
		$("#autor-select").load("ServletOptionListAutor");
	}
	function loadEditorialSelect(){
		$("#editorial-select").load("ServletOptionListEditorial");
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
		
	});
</script>
