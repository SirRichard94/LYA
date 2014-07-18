
<%@page import="utez.app.model.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">
  <head>
	  <%@include file="incl_headmeta.html" %>

    <title>Perfil </title>


  </head>

  <body>

    <!-- Static navbar -->
    <%@include file="incl_navbar.jsp" %>

    
<% 
if (usuario == null){
		request.setAttribute("warning", "Sesion expirada");
		getServletConfig().getServletContext().
			getRequestDispatcher("/index.jsp").forward(request, response);
	}
%>
	<!-- +++++ Welcome Section +++++ -->
	
	<div id="ww">
	    <div class="container">
		    <% if (login){ %>
			<div class="row">
                             <div class="col-lg-8 col-lg-push-8">
				     
				     
				     
				     Penalizaciones:  <b> <%=usuario.getDeuda()%></b>
                                        </div>
				<div class="col-lg-8 col-lg-offset-2 centered">
                                    
                                        
					<img src="assets/img/user.png" alt="Perfil">
                                       
					<h1>(<%=usuario.getNombre() %>)</h1>
                                        <p>(<%=usuario.getCorreo() %>)</p>  
                                       
					Prestamos:
					<table>
						<thead>
						<th>Libro</th>
						<th>Fecha de entrega</th>
						</thead>
						<tbody>
							<%for(int i = 0; i<0; i++){%>
							<tr>
								<td> </td>
							</tr>
							<%}%>
						</tbody>
					</table>
					
				</div><!-- /col-lg-8 -->
			</div><!-- /row -->
	    </div> <!-- /container -->
	    <% }%>
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