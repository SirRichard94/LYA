<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@page import="utez.app.web.eq4.util.DbConnection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@page import="utez.app.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<script type="text/javascript">
$(document).ready(function (){ 
	$("#tabla-libro").dataTable({
		"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
		"language": {
            "lengthMenu": "_MENU_ filas por página",
            "search": "Busqueda",
            "zeroRecords": "No se encontro informacion",
            "info": "Mostrando página _PAGE_ de _PAGES_",
            "infoEmpty": "No hay informacion disponible",
            "infoFiltered": "(filtrados de _MAX_ filas)"
		}
	});
	
});
</script>


<% 
	List<PrestamoBean> lista = (List) request.getAttribute("lista");
%>

	<table class="table table-condensed table-bordered" id="tabla-libro">
            <thead>
              <tr>
                 <th>Usuario</th>
		 <th>Libro</th>
		 <th>Id Ejempar</th>
		 <th>Fecha Salida</th>
		 <th>Fecha Entrega</th>
		 
              </tr>
            </thead>
	    
            <tbody>
                <% for(int i = 0; i< lista.size(); i++){ %>
		<% PrestamoBean row = lista.get(i); %>
		<tr>
				    <td><%=row.getUsuario().getNombre()%></td>
				    <td><%=row.getEjemplar().getLibro().getNombre()%> </td>
				    <td><%=row.getEjemplar().getEjemplar_id() %> </td>
				    <td><%=row.getFecha_salida() %></td>
				    <td><%=row.getFecha_entrega()%></td>
				   
			    </tr>
		    <%}%>
            </tbody>
          </table>