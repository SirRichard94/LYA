
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
		<input type="number" class="form-control" placeholder="Num de Paginas" name="pags">
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="editorial-select"><small>Editorial</small></label>
		<div class="col-md-8">
			<select id="editorial-select" name="editorial" class="form-control">
				<option value="1">Option one</option>
				<option value="2">Option two</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="area-select"><small>Area</small></label>
		<div class="col-md-8">
			<select id="area-select" name="area" class="form-control">
				
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="autor-select"><small>Autores</small></label>
		<div class="col-md-8">
			<select multiple id="autor-select" name="autores" class="form-control">
				<option value="1">Option one</option>
				<option value="2">Option two</option>
			</select>
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
		<input type="number" class="form-control" placeholder="Lbro ISBN" name="i" required=""> 
	</div>
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Localización" name="l" required>
	</div>
	<div class="form-group">
		<input type="number" class="form-control" placeholder="Num de Ejemplares" name="n">
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
						
			$.get(
				'AgregarEjemplares', 
				$("#agregar-ejemplar").serialize(), function (data){
					 $( "#alert-form-libro" ).html( data );
				});
			
			$(this).find("input[type=text], textarea, input[type=number]").val("");
			
			return false;
		});
		
		//agregar Libro
		
		$("#agregar-libro").submit(function (){	
			alert("Libro");
			
			$.get(
				'AgregarLibro', 
				$("#agregar-libro").serialize(), function (data){
					 $( "#alert-form-libro" ).html( data );
				});
			
			$(this).find("input[type=text], textarea, input[type=number]").val("");
			
			return false;
		});
	});
</script>

<script type="text/javascript">
	//script insertar opciones
	//area
	$(document).ready(function (){
		$.get("ServletOptionListArea",
		function(data){
			$("#area-select").html(data);
		});
	// editorial
		$.get("ServletOptionListEditorial",
		function(data){
			$("#editorial-select").html(data);
		});
	//autor
		$.get("ServletOptionListAutor",
		function(data){
			$("#autor-select").html(data);
		});
	});
</script>