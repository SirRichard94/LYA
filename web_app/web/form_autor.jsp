
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="alert-autor"></div>
<form class="form-horizontal" id="form-autor" accept-charset="utf-8" enctype="multipart/form-data">
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
			
			$(this).find("input[type=text], textarea, input[type=number]").val("");
			$(this).trigger("submited");
			return false;
		});
	});
</script>