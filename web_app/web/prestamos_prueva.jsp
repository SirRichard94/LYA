<%-- 
    Document   : prestamos
    Created on : Jul 21, 2014, 11:48:58 AM
    Author     : ricardo
--%>

<%@page import="java.sql.Connection"%>
<%@page import="utez.app.daos.DaoPrestamo"%>
<%@page import="utez.app.web.eq4.util.DbConnection"%>
<%@page import="utez.app.daos.DaoArea"%>
<%@page import="utez.app.model.PrestamoBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang=es>
	<head>
		<%@include file="incl_headmeta.html" %>
		<title>Prueva Prestamos</title>
	</head>
	
	<body>
		<%@include file="incl_navbar.jsp" %>
		<div class="container" >
			<div class="row">
				<div class="col-lg-8">
		<h1>Hello World!</h1>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Usuario</th>
					<th>Libro</th>
					<th>Ejemplar</th>
					<th>Fecha de salida</th>
					<th>Fecha de entrega</th>
				</tr>
			</thead>
			<tbody>
			<%
				Connection con = DbConnection.getConnection();
				DaoPrestamo dao = new DaoPrestamo(con);
				if (con != null){
				
				for (PrestamoBean prestamo : 
					dao.getAll()){
			%>
			<tr>
				<td><%=prestamo.getUsuario().getNombre()%></td>
				<% try{ %>
				<td><%=prestamo.getEjemplar().getLibro().getNombre()%></td>
				<% }catch (NullPointerException e){} %>
				<td><%=prestamo.getEjemplar().getEjemplar_id()%></td>
				<td><%=prestamo.getFecha_salida()%></td>
				<td><%=prestamo.getFecha_entrega()%></td>
			</tr>
			<%	}
				}%>
			</tbody>
		</table>
				</div>
			<div class="col-lg-4" >
				<form>
					
				</form>
			</div>
			</div>
		</div> 
			<%@include file="incl_footer.jsp" %>
	<script src="assets/js/bootstrap.min.js"></script>
	
	</body>	
</html>
