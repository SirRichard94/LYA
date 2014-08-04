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
		"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "Todos"]],
		"language": {
            "lengthMenu": "_MENU_ Filas por página",
            "search": "Filtro",
            "zeroRecords": "No se encontro informacion",
            "info": "Mostrando página _PAGE_ de _PAGES_",
            "infoEmpty": "No hay informacion disponible",
            "infoFiltered": "(filtrados de _MAX_ filas)",
	    "paginate": {
			"first": "Primero",
			"last": "Ultimo",
			"next": "Siguiente",
			"previous": "anterior"
			
		}
		}
		
	});
	
});
</script>


<% 
	List<PrestamoBean> lista = (List) request.getAttribute("lista");
	List<Integer> diasRetraso = (List) request.getAttribute("dias");
%>

	<table class="table table-condensed table-bordered" id="tabla-libro">
            <thead>
              <tr>
                 <th>Usuario</th>
		 <th>Libro</th>
		 <th>Id Ejemplar</th>
		 <th>Fecha Salida</th>
		 <th>Fecha Entrega</th>
		 <th>Acción</th>
		 
              </tr>
            </thead>
	    
            <tbody>
                <% for(int i = 0; i< lista.size(); i++){ %>
		<% PrestamoBean row = lista.get(i); %>
		<tr class="<%=diasRetraso.get(i) > 0 
			? "danger" : "" %>">
				    <td><%=row.getUsuario().getNombre()%></td>
				    <td><%=row.getEjemplar().getLibro().getNombre()%> </td>
				    <td><%=row.getEjemplar().getEjemplar_id() %> </td>
				    <td><%=row.getFecha_salida() %></td>
				    <td><%=row.getFecha_entrega()%></td>
				    <td><a href="EntregarPrestamo?p_id=<%=row.getPrestamo_id()%>"><span class="glyphicon glyphicon-book"></span>
						    Entregado</a></td>
			    </tr>
		    <%}%>
            </tbody>
          </table>
	    <small>*Marcados en rojo, usuarios atrasados</small>
