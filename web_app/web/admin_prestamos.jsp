<%-- 
    Document   : index
    Created on : 03-jul-2014, 16:43:43
    Author     : Koffo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
	  <%@include file="incl_headmeta.html" %>
    <title>Biblioteca Lee y Aprende </title>
  </head>

  <body>

    <!-- Static navbar -->
    <%@include file="incl_navbar.jsp" %>
    
     <%
	try{
		if (!(Boolean) session.getAttribute("admin")){
			request.setAttribute("warning", "sesion expirada");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}catch (NullPointerException e){
		throw new ServletException("Acceso denegado");
	}
    %>

	<!-- +++++ Welcome Section +++++ -->
	<div id="ww">
	    <div class="container">
			<div class="row">
				<div class="col-md-8 ">
					<button type="button" class="btn btn-xs refresh-button"> 
						<small>
						<span class="glyphicon glyphicon-refresh"></span>
						</small>
					</button>
					
					<div id="tabla-prestamos">
						Tabla de prestamos
					</div>
					
				</div>
				
				<div class="col-md-4 ">
                                   
					<div id="form-prestamos">
						<%@include file="form_prestamos.jsp" %>
					</div>
					
				</div>
			</div><!-- /row -->
			
	    </div> <!-- /container -->
	</div><!-- /ww -->
	
	
	<!-- +++++ Projects Section +++++ -->
	
	
	
	
	<!-- +++++ Footer Section +++++ -->
	
	<%@include file="incl_footer.jsp" %>
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript">
	    $(document).ready(function (){
		    
		$.get("TablaPrestamo", function (responseText){
			$("#tabla-prestamos").html(responseText);
		});
		$("#agregar").load("form_usuario.jsp");
		
		$(".refresh-button").click(function (){
			$.get("TablaPrestamo", function (responseText){
			$("#tabla-prestamos").html(responseText);
		});
		});
		
	    });
    </script>
    
  </body>
</html >
