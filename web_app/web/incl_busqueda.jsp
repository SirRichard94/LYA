<%-- 
    Document   : incl_busqueda
    Created on : Jul 4, 2014, 2:57:36 AM
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form class="form-horizontal" action="Busqueda">
<fieldset>

<!-- Form Name -->
<legend>Busqueda</legend>

<!-- Search input-->
<div class="form-group" >
    <div class="col-md-10">
	    <div class="input-group">
    <input id="search" name="search" placeholder="busqueda de libro" class="form-control input-md" type="search">
    <span class="input-group-btn">
    <button id="enviar" name="enviar" class="btn btn-success" data-toggle="tooltip" data-placement="right" title="Buscar libro">
	    buscar
    </button>
    </span>
	    </div>
    </div>
  
  <div class="col-md-4">
    
  </div>
</div>

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <div class="col-md-12"> 
    <label class="radio-inline" for="categoria-0">
      <input name="categoria" id="categoria-0" value="titulo" checked="checked" type="radio">
      Titulo
    </label> 
    <label class="radio-inline" for="categoria-1">
      <input name="categoria" id="categoria-1" value="autor" type="radio">
      Autor
    </label> 
    <label class="radio-inline" for="categoria-2">
      <input name="categoria" id="categoria-2" value="editorial" type="radio">
      Editorial
    </label> 
    <label class="radio-inline" for="categoria-3">
      <input name="categoria" id="categoria-3" value="area" type="radio">
      Area
    </label>
  </div>
</div>

</fieldset>
</form>