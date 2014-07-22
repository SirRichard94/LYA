<%@page import="utez.app.model.EditorialBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">
  <head>
    
	  <%@include file="incl_headmeta.html" %>

    <title> LYA Menu de Administrador </title>
    
    
  </head>

  <body>

    <!-- Static navbar -->
    <%@include file="incl_navbar.jsp" %>

    <%
	try{
		if (!(Boolean) session.getAttribute("admin")){
			throw new ServletException("Acceso denegado");
		}
	}catch (NullPointerException e){
		throw new ServletException("Acceso denegado");
	}
	EditorialBean objetivo = new EditorialBean();
	try{
		if (request.getAttribute("objetivo") == null){
			throw new ServletException("Objetivo no encontrado");
		}else{
			objetivo =(EditorialBean) request.getAttribute("objetivo");
		}
	}catch (NullPointerException e){
		throw new ServletException("Objetivo no encontrado");
	}
	
	
    %>
    

	<!-- +++++ Welcome Section +++++ -->
	
	<div id="ww">
	    <div class="container">
		    <div class="row">
		    <div class="col-md-6 ">
			    <div class="page-header">
			    <h1>Administrador de LYA</h1>
			    </div>
		    </div>
		    </div>
			<div class="row">
		    
		    <div class="col-md-8 centered">
			    <!-- Agregar  -->
			    <div class="well" >
<form class="form-horizontal" action="ModificarEditorial" method="POST">
	<fieldset>
	<legend>Modificar Editorial</legend>
	<input type="hidden" name="guardar" value="true">
	<input type="hidden" name="i" value="<%=objetivo.getEditorial_id()%>">
	<div class="row">
	<div class="col-md-6">
	<div class="form-group">		
		<label class="col-md-3" for="nombre">Nombre</label>
		<div class="col-md-9">
	<input id="nombre" type="text" class="form-control" placeholder="Nombre" name="nombre" required value="<%=objetivo.getNombre() %>"> 
		</div>
		
	</div>
	
	<div class="form-group">
		<label for="dir" class="col-md-3">Dirección</label>
		<div class="col-md-9">
		<textarea class="form-control" placeholder="Dirección" name="dir" rows="3"  ><%=objetivo.getDireccion()%></textarea>
		</div>
	</div>
</div>
	
	<div class="form-group">
		<a class="btn btn-warning" href="admin.jsp">Cancelar</a>
		<button type="submit" class="btn btn-success" >Guardar</button>
	</div>
	</fieldset>
</form>  
			    </div>
		    </div > <!-- div -->
		    
		    
		    </div> <!-- row -->
			   
	    </div> <!-- /container -->
	    
	</div><!-- /ww -->
	
	
	<!-- +++++ Information Section +++++ -->
	


	<!-- +++++ Footer Section +++++ -->
	
	<%@include file="incl_footer.jsp" %>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/keepAlive.js"></script>
    
  </body>
</html>