
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div id="alert-area"></div>

<form class="form-horizontal" id="form-area" accept-charset="UTF-8" action="#">
	<fieldset>
	<legend>Agregar Área</legend>
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
			$.get("AgregarArea", form.serialize(),
			function(data){
				$("#alert-area").html(data);
				form.trigger("submited");
			});
			$(this).find("input[type=text], textarea, input[type=number]").val("");
			return false;
		});
	});
</script>