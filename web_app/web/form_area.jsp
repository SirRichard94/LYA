
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="alert-area"></div>

<form class="form-horizontal" id="form-area" accept-charset="ISO-8859-1">
	<fieldset>
	<legend>Agregar Area</legend>
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Nombre" name="n" required=""> 
	</div>
	<br>
	<div class="form-group">
		<button class="btn btn-primary pull-right" >Crear</button>
	</div>
	</fieldset>
</form>

<script type="text/javascript">
	
	$(document).ready(function (){
		$("#form-area").submit(function (){
			var form = $(this);
			$.ajaxSetup({
				scriptCharset:"ISO-8859-1"
			});
			$.get("AgregarArea", form.serialize(),
			function(data){
				$("#alert-area").html(data);
				
			});
			return false;
		});
	});
</script>