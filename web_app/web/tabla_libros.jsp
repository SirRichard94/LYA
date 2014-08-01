
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@page import="utez.app.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">
  <head>
	  <%@include file="incl_headmeta.html" %>

    <title>Catálogo de Libros</title>

    <script type="text/javascript">
	    $(document).ready(function (){
		$("#tabla-libros").dataTable({
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
  </head>

  <body>
	  
	  <% 
	  List<LibroBean> lista = new ArrayList();
	  String busqueda = "";
	  try{
		  lista = (List) request.getAttribute("lista");
		  busqueda = (String) request.getAttribute("busqueda");
		  
		  if (busqueda == null){
			  busqueda = "";
		  }
	  }catch (NullPointerException e){
	  }
	  %>
    <!-- Static navbar -->
    <%@include file="incl_navbar.jsp" %>


	<!-- +++++ Welcome Section +++++ -->
	
	<div id="ww">
	    <div class="container">
		    <div class="row">
		    
		    <div class="col-md-8">
			    <h1>Catálogo de libros
				    <%=busqueda != ""
					    ? ": resultados de '"+ busqueda +"'" 
					    : ""%></h1>
			    
			     <table class="table table-striped" id="tabla-libros">
            <thead>
              <tr>
                 <th>Título</th>
		 <th>ISBN</th>
		 <th>Autores</th>
		 <th>Area</th>
		 <th>Editorial</th>
              </tr>
            </thead>
            <tbody>
               <% for (int i = 0; i < lista.size() ; i++){ %>
			    <tr>
				    <td><%=lista.get(i).getNombre() %></td>
				    <td><%=lista.get(i).getIsbn()%></td>
				    <td><%
				    for(AutorBean autor : lista.get(i).getAutores() ){
					    out.print(
						    autor.getNombre()+" "+autor.getApellido()+" ");
					    
				    }%></td>
				    <td><%=lista.get(i).getArea().getNombre()%></td>
				    <td><%=lista.get(i).getEditorial().getNombre()%></td>
			    </tr>
		<% } %>
            </tbody>
          </table>
		    </div>
			    <div class="col-md-4">
				    <%@include file="incl_busqueda.jsp" %>
			    </div>
			    
		    </div>
	    </div> <!-- /container -->
	    
	</div><!-- /ww -->
	
	
	<!-- +++++ Information Section +++++ -->
	


	<!-- +++++ Footer Section +++++ -->
	
	<%@include file="incl_footer.jsp" %>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>