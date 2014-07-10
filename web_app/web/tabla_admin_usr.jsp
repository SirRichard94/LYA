<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="utez.app.web.eq4.util.DbConnection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@page import="utez.app.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<script type="text/javascript">
$(document).ready(function (){ 
	$("#tabla-usuario").dataTable({
		"lengthMenu": [[5, 10, 25, -1], [5, 10, 25, "All"]],
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
	  List<UsuarioBean> lista = new ArrayList();
	  try{
		  lista = (List) request.getAttribute("lista");
	  }catch (NullPointerException e){
	  }
	  
	  List<Integer> prestamos = new ArrayList();
	  try{
		  prestamos = (List) request.getAttribute("prestamos");
	  }catch (NullPointerException e){
	  }
	  %>
	  
	  <div id="notif-tab-usuario">
		  
	  </div>

	<table class="table table-condensed table-bordered" id="tabla-usuario">
            <thead>
              <tr>
                 <th>Nombre</th>
		 <th>E-Mail</th>
		 <th>Telefono</th>
		 <th>Direccion</th>
		 <th>Prestamos</th>
		 <th>Deuda</th>
		 <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
               <%for (int i = 0; i < lista.size(); i++ ){
		       UsuarioBean row = lista.get(i);
		       int id = row.getUsuario_id();
	       %>		       
			    <tr class="<%=(row.getDeuda() > 0) ? "danger": ""%>">
				    <td><%=row.getNombre()%></td>
				    <td><%=row.getCorreo()%></td>
				    <td><%=row.getTelefono()%></td>
				    <td><%=row.getDireccion()%></td>
				    <td ><%=prestamos.get(i)%></td>
				    <td>$<%=row.getDeuda()%></td>
				    <td class="">
<a href="ModificarUsuario?guardar=false&AMP;u=<%=id%>" title="modificar"><span class="glyphicon glyphicon-pencil"></span></a>
	<a href="EliminarUsuario?u=<%=id%>" title="eliminar"><span class="glyphicon glyphicon-trash"></span></a>
					   
				    </td>
			    </tr>
		    <%}%>
            </tbody>
          </table>
	   
