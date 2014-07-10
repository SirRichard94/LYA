
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<!-- Modal -->

<div class="modal fade" id="LoginMod" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title" id="myModalLabel">Inicio de Sesión</h4>
			</div>
			
<form id="login-form" class="form-horizontal" action="Login" method="POST">			
			<div class="modal-body">

<fieldset>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="correo">Correo:</label>  
  <div class="col-md-5">
	  <input id="correo" name="correo" placeholder="correo@ejemplo.com" class="form-control input-md" required="" 
		 type="email">
    
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Contraseña</label>
  <div class="col-md-5">
    <input id="password" name="password" placeholder="contraseña" class="form-control input-md" required="" type="password">
    
  </div>
</div>



</fieldset>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<button id ="login-submit" type="submit" class="btn btn-primary">Enviar</button>
			</div>
			
</form>			
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function (){
		$("#login-form").submit(function (){
			
			$.ajax({
			type: "POST",
			url: "Login",
			data: $("#login-form").serialize(), // serializes the form's elements.
			success: function(data)
			{
				$("#LoginMod").modal('hide');
				location.href = location.pathname;
			}
			});
			
			return false;
		});
	});
</script>