
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="alert-autor"></div>
<form class="form-horizontal" id="form-autor">
	<fieldset>
	<legend>Agregar Autor</legend>
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Nombre" name="n" required=""> 
	</div>
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Apellido" name="a">
	</div>
	<br>
	<div class="form-group">
		<button type="submit" class="btn btn-primary pull-right" >Crear</button>
	</div>
	</fieldset>
</form>

<script type="text/javascript">
	
	$(document).ready(function (){
		$("#form-autor").submit(function (){
			
			$.get("AgregarAutor", $("#form-autor").serialize(),
			function(data){
				$("#alert-autor").html(data);
				
			});
			
			return false;
		});
	});
</script>