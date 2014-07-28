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
	List<AutorBean> lista = (List) request.getAttribute("lista");
	List<Integer> listaLibros = (List) request.getAttribute("listaLibros");
%>


	<table class="table table-striped table-condensed table-bordered" id="tabla-autor">
            <thead>
              <tr>
		 <th class="centered">Nombre</th>
		 <th class="centered">Núm. Libros</th>
		 <th class="centered">Acciones</th>
              </tr>
            </thead>
            <tbody>
		    
               <% for(int i = 0; i< lista.size(); i++){ 
		       int id = lista.get(i).getAutor_id();
	       %>
			    <tr>
				    <td>
				    <%=lista.get(i).getNombre()%> 
				    <%=lista.get(i).getApellido() != null ? 
					lista.get(i).getApellido() : ""%>
				    </td>
				    <%-- num de libros --%>
				    <td class="centered"><%=listaLibros.get(i)%></td> 
				     <%-- accciones --%>
				     <td class="centered">

					     <a Href="ModificarAutor?guardar=false&AMP;id=<%=id%>" 
						title="Modificar" >
						     <span class="glyphicon glyphicon-pencil"></span>
					     </a>
					     <a href="EliminarAutor?id=<%=id%>" title="Eliminar"
						class="eliminar">
						     <span class="glyphicon glyphicon-trash"></span>
					     </a>

				     </td>
			    </tr>
		<% } %>
            </tbody>
          </table>

	    <script type="text/javascript">
		    $(document).ready(function (){
			    $(".eliminar").click(function(){
				if(!confirm("Seguro que desea eliminarlo?")){
					return false;
				}
			    });
		    });
	    </script>