
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<form id="form-usuario" class="form-horizontal" action="AgregarUsuario" method="POST">
	<fieldset>
	<legend>Agregar Usuario</legend>
	
	<div id="alert-usuario" class="">
	</div>

	
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Nombre" name="nombre" required=""> 
	</div>
	<div class="form-group">
		<input type="email" class="form-control" placeholder="email" name="email" required="">
	</div>
	<div class="form-group">
		<input type="password" class="form-control" placeholder="contaseña" name="pass" required=""> 
	</div>
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Telefono" name="tel">
	</div>
	<div class="form-group">
		<textarea class="form-control" placeholder="direccion" name="dir" rows="2" ></textarea>
	</div>
	<div class="form-group">
		<button class="btn btn-primary pull-right" >Crear</button>
	</div>
	</fieldset>
</form>

<script type="text/javascript">
	
	$(document).ready(function (){
		$("#form-usuario").submit(function (){
			
			$.ajax({
			type: "POST",
			url: "AgregarUsuario",
			data: $("#form-usuario").serialize(), // serializes the form's elements.
			success: function(data)
			{
				$("#alert-usuario").html(data);
				
			}
			});
			
			return false;
		});
	});
</script>