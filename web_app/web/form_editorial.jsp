
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div id ="alert-editorial"></div>

<form class="form-horizontal" id = "form-editorial">
	<fieldset>
	<legend>Agregar Editorial</legend>
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Nombre" name="nom" required=""> 
	</div>
	<div class="form-group">
		<textarea class="form-control" placeholder="Dirección" name="dir" rows="4"></textarea>
	</div>
	<br>
	<div class="form-group">
		<button type="submit" class="btn btn-primary pull-right" >Crear</button>
	</div>
	</fieldset>
</form>


<script type="text/javascript">
	
	$(document).ready(function (){
		$("#form-editorial").submit(function (){
			var form = $(this);
			$.get("AgregarEditorial", form.serialize(),
			function(data){
				$("#alert-editorial").html(data);
				form.trigger("submited");
			});
			$(this).find("input[type=text], textarea, input[type=number]").val("");

			return false;
		});
	});
</script>