
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="alert-prestamo"></div>

<form class="form-horizontal" id="form-area">
	<fieldset>
	<legend>Agregar Prestamo</legend>
	
	<div class="form-group">
		<label class="col-md-4 control-label" for="usuario-select"><small>Usuario</small></label>
		<div class="col-md-8">
			<select id="usuario-select" name="usuario" class="form-control">
				<option value="1">Option one</option>
				<option value="2">Option two</option>
			</select>
		</div>
	</div>
	
	
	<div class="form-group">
		<label class="col-md-4 control-label" for="libro-select"><small>Libro</small></label>
		<div class="col-md-8">
			<select id="libro-select" name="libro" class="form-control">
				<option value="1">Option one</option>
				<option value="2">Option two</option>
			</select>
		</div>
	</div>
	<br>
	<div class="form-group">
		<button class="btn btn-primary pull-right">Agregar</button>
	</div>
	</fieldset>
</form>

<script type="text/javascript">
	
	$(document).ready(function (){
		$("#form-area").submit(function (){
			var form = $(this);
			$.get("CrearPrestamo", form.serialize(),
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