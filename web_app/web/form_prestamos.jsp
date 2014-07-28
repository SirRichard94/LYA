
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="alert-prestamo"></div>

<form class="form-horizontal" id="form-prestamo">
	<fieldset>
	<legend>Agregar Préstamo</legend>
	
	<div class="form-group">
		<label class="col-md-4 control-label" for="usuario-select">Usuario</label>
		<div class="col-md-8">
			<select id="usuario-select" name="usuario" class="form-control">
				
			</select>
		</div>
	</div>
	
	
	<div class="form-group">
		<label class="col-md-4 control-label" for="libro-select">Libro</label>
		<div class="col-md-8">
			<select id="libro-select" name="libro" class="form-control">
				
			</select>
		</div>
	</div>
	<br>
	<div class="form-group">
		<button type="submit" class="btn btn-primary pull-right">Agregar</button>
	</div>
	</fieldset>
</form>

<script type="text/javascript">
	
	$(document).ready(function (){
		$("#form-prestamo").submit(function (){
			var form = $(this);
			$.get("AgregarPrestamo", form.serialize(),
			function(data){
				$("#alert-prestamo").html(data);
				
			});
			
			return false;
		});
	});
</script>

<script type="text/javascript">
	//listar usuarios
	$(document).ready(function (){
		$.get("ServletOptionListUsuario",
		function(data){
			$("#usuario-select").html(data);
		});
	});
	//listar libro
	$(document).ready(function (){
		$.get("ServletOptionListLibro",
		function(data){
			$("#libro-select").html(data);
		});
	});
</script>