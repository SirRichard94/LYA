
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<ul id="tab-libro-ejemplar" class="nav nav-tabs" role="tablist">
	<li class="active"><a data-toggle="tab" role="tab" href="#libro-tab">Libro</a></li>
	<li><a data-toggle="tab" role="tab" href="#ejemplar-tab">Ejemplar</a></li>
</ul>

<div id="alert-libro">
		
</div>

<div id="tab-libro-ejemplar-content" class="tab-content">
	<div id="libro-tab" class="tab-pane active" >
<form class="form-horizontal">
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
		<label class="col-md-4 control-label" for="editorial"><small>Editorial</small></label>
		<div class="col-md-8">
			<select id="editorial" name="editorial" class="form-control">
				<option value="1">Option one</option>
				<option value="2">Option two</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="area"><small>Area</small></label>
		<div class="col-md-8">
			<select id="area" name="area" class="form-control">
				<option value="1">Option one</option>
				<option value="2">Option two</option>
			</select>
		</div>
	</div>
	
	
	<div class="form-group">
		<button class="btn btn-primary pull-right" >Crear</button>
	</div>
	</fieldset>
</form>
		</div> <!-- tab pane -->
<div class="divider">
</div>

<%-- Agregar ejemplares --%>
<div id = "ejemplar-tab" class="tab-pane" >
<form id="agregar-ejemplar" class="form-horizontal">
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
		<button class="btn btn-primary pull-right" >Agregar</button>
	</div>
	</fieldset>
</form>
</div>
</div> <!-- tab content -->


<script type="text/javascript">
	$(document).ready(function (){
		$("#agregar-ejemplar").submit(function (){
			
			$.ajax({
			type: "POST",
			url: "AgregarEjemplares",
			data: $("#login-form").serialize(), // serializes the form's elements.
			success: function(data)
			{
				$("#alert-libro").html(data);
			}
			});
			
			return false;
		});
	});
</script>