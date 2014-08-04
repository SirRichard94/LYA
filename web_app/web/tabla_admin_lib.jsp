<%@page import="utez.app.utilidades.Biblioteca"%>
<%@page import="utez.app.daos.DaoLibro"%>
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
	List<LibroBean> lista = (List) request.getAttribute("lista");
	List<Integer> ejemplares = (List) request.getAttribute("ej");
	List<Integer> ejemplaresDisponibles = (List) request.getAttribute("ejDisp");
%>

	<table class="table table-condensed table-bordered" id="tabla-libro">
            <thead>
              <tr>
                 <th>Título</th>
		 <th>ISBN</th>
		 <th>Págs</th>
		 <th>Autores</th>
		 <th>Editorial</th>
		 <th>Área</th>
		 <th><small>Ejemplares</small></th>
		 <th><small>Prestados</small></th>
		 <th>Acciones</th>
              </tr>
            </thead>
	    
            <tbody>
                <% for(int i = 0; i< lista.size(); i++){ %>
		<% LibroBean row = lista.get(i); %>
		<tr class="<%=(ejemplaresDisponibles.get(i) <= 4) ? "warning": ""%>">
				    <td><%=row.getNombre()%></td>
				    <td><%=row.getIsbn()%></td>
				    <td><%=row.getPaginas()%></td>
				    
				    <td><%
				    for(AutorBean autor : row.getAutores() ){
					    out.print(
						    autor.getNombre()+" "+autor.getApellido()+" ");
					    
				    }%></td>
				    
				    <td><%=row.getEditorial().getNombre()%></td>
				    <td><%=row.getArea().getNombre()%></td>
				    <td><%=ejemplares.get(i) %></td>
				    <td>
					    <%=new DaoLibro(new Biblioteca(true)
					    .getConection()).countPrestamos(row)%>
					    <%-- mysql, temporal --%>
				    </td>
				    <td class="centered">
					    <a href='ModificarLibro?id=<%=row.getLibro_id()%>'>
					    <span class="glyphicon glyphicon-pencil"></span>Modificar <br>
					    </a>
					    <a href="EliminarLibro?id=<%=row.getLibro_id()%>">
					    <span class="glyphicon glyphicon-trash"></span>Eliminar
					    </a>
				    </td>
			    </tr>
		    <%}%>
            </tbody>
          </table>

	       <small>*Marcados en amarillo, libros con 4 o menos ejemplares en existencia</small>