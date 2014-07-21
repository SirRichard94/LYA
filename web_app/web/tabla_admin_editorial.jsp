<%@page import="java.util.List"%>
<%@page import="utez.app.web.eq4.util.DbConnection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@page import="utez.app.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script type="text/javascript">
$(document).ready(function (){ 
	$("#tabla-autor").dataTable({
		"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "Todo"]],
		"language": {
            "lengthMenu": "_MENU_ filas por página",
            "search": "Busqueda",
            "zeroRecords": "No se encontró informacion",
            "info": "Mostrando página _PAGE_ de _PAGES_",
            "infoEmpty": "No hay informacion disponible",
            "infoFiltered": "(Filtrados de _MAX_ filas)"
		}
	});
	
});
</script>


<% 
	List<EditorialBean> lista = (List) request.getAttribute("lista");
	List<Integer> listaLibros = (List) request.getAttribute("listaLibros");
%>


	<table class="table table-striped table-condensed table-bordered" id="tabla-autor">
            <thead>
              <tr>
		 <th class="centered">Nombre</th>
		 <th class="centered">Direccion</th>
		 <th class="centered">Num. Libros</th>
		 <th class="centered">Accciones</th>
              </tr>
            </thead>
            <tbody>
		    
               <% for(int i = 0; i< lista.size(); i++){ %>
	       <%int id = lista.get(i).getEditorial_id();%>
			    <tr>
				    <td><%=lista.get(i).getNombre()%></td>
				    <td><%=lista.get(i).getDireccion()%></td>
				    <td class="centered"><%=listaLibros.get(i)%></td>
				    <td class="centered">
					    <a href="#ModificarEditorial?guardar=false&AMP;u=<%=id%>" 
					       title="modificar">
						    <span class="glyphicon glyphicon-pencil"></span>
					    </a>
					    <a href="#EliminarEditorial?e=<%=id%>" 
					       title="eliminar">
						    <span class="glyphicon glyphicon-trash"></span>
					    </a>
				    </td>
			    </tr>
		<% } %>
            </tbody>
          </table>
