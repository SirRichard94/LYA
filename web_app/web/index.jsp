<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<!-- +++++ Welcome Section +++++ -->
	<div id="ww">
	    <div class="container">
		   
		    
			<div class="row">
				<div class="col-md-5 ">
                                   
				   <img src="assets/img/logo1.jpg" alt="Logo" class="img-responsive hidden-xs hidden-sm" >
				
				</div><!-- /col-lg-8 -->
				<div class="col-md-7">
					<!-- Buusqueda -->
					<h1>Biblioteca Lee Y Aprende</h1> 
					<%@include file="incl_busqueda.jsp" %>
					
					
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
    
  </body>
</html >
