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
	    <div class="container-fluid">
			<div class="row">
			<div class="col-md-3">
				<div id="form-prestamos" class="well">
						<%@include file="form_prestamos.jsp" %>
					</div>	
			</div>
				
				<div class="col-md-8">
					
					<div id="tabla-prestamos">
						Tabla de prestamos
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
		
		$("form").on("submited", function (){
			
			$("#tabla-prestamos").load("TablaPrestamo");
		
		});
		
	    });
    </script>
    
  </body>
</html >
