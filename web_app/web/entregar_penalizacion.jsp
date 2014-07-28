<%-- 
    Document   : index
    Created on : 03-jul-2014, 16:43:43
    Author     : Koffo
--%>

<%@page import="utez.app.model.PrestamoBean"%>
<%@page import="utez.app.daos.DaoUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
	  <%@include file="incl_headmeta.html" %>
    <title>Biblioteca Lee y Aprende </title>
  </head>

  <body>

    <!-- Static navbar -->
    <%@include file="incl_navbar.jsp" %>
    <% 
    PrestamoBean prestamo = (PrestamoBean) request.getAttribute("prestamo");
    if(prestamo == null){
	    response.sendRedirect("admin_prestamos.jsp");
    }
    Double monto = (Double) request.getAttribute("monto");
    %>
    
	<!-- +++++ Welcome Section +++++ -->
	<div id="ww">
	    <div class="container">
			<div class="row">
				<div class="col-md-5 ">
					<header><h1>Pagar Penalización</h1></header>
					<div class="jumbotron">
	Libro: <%=prestamo.getEjemplar().getLibro().getNombre() %><br>
	Ejemplar ID: <%=prestamo.getEjemplar().getEjemplar_id() %><br>
	Monto: <b class="text-danger">$<%=monto%></b>
	
	<%int u=prestamo.getUsuario().getUsuario_id();
	int p=prestamo.getPrestamo_id();%>
	<a href="ServletPago?u=<%=u%>&p=<%=p%>" id="btn-pagar"
		   class="btn btn-success pull-right">Pagar
	</a>
	<a href="admin_prestamos.jsp" 
		   class="btn btn-warning pull-right">Cancelar
	</a>
					</div>		
				</div>
			</div><!-- /row -->
			
	    </div> <!-- /container -->
	</div><!-- /ww -->
	
	
	<!-- +++++ Projects Section +++++ -->
	
	
	
	
	<!-- +++++ Footer Section +++++ -->
	
	<%@include file="incl_footer.jsp" %>
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html >
