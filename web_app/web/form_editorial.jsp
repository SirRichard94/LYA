
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<form class="form-horizontal">
	<fieldset>
	<legend>Agregar Editorial</legend>
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Nombre" name="nombre" required=""> 
	</div>
	<div class="form-group">
		<textarea class="form-control" placeholder="Direccion" name="dir" rows="4"></textarea>
	</div>
	<br>
	<div class="form-group">
		<button class="btn btn-primary pull-right" >Crear</button>
	</div>
	</fieldset>
</form>