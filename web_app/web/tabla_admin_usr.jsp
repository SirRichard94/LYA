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
		 <th>Teléfono</th>
		 <th>Dirección</th>
		 <th>Préstamos</th>
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
<a href="ModificarUsuario?guardar=false&AMP;u=<%=id%>" 
   title="modificar">
	<span class="glyphicon glyphicon-pencil"></span>
</a>
	<a class="eliminar"
		href="EliminarUsuario?u=<%=id%>" 
	   title="eliminar">
		<span class="glyphicon glyphicon-trash"></span>
	</a>
					   
				    </td>
			    </tr>
		    <%}%>
            </tbody>
          </table>
	    
	       <small>*Marcados en color rojo, los usuarios con penalización</small>
	   
<script type="text/javascript">
		    $(document).ready(function (){
			    $(".eliminar").click(function(){
				if(!confirm("Seguro que desea eliminarlo?")){
					return false;
				}
			    });
		    });
	    </script>