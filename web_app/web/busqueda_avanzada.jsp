<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
	  <%@include file="incl_headmeta.html" %>

    <title>Biblioteca Lee y aprende: Busqueda </title>


  </head>

  <body>
	  
    <!-- Static navbar -->
   <%@include file="incl_navbar.jsp" %>
	<!-- +++++ Welcome Section +++++ -->
	
	<div id ="ww">
	<div class="row mt">	
			<div class="col-lg-4 col-lg-offset-2 col-md-8">
				<form class="form-horizontal" action="#BusquedaAv">
				  <div class="form-group" >
					  <input type="search" class="form-control" name="titulo" placeholder="Titulo">
				    <br>
				  </div>
				  <div class="form-group">
					  <input type="search" class="form-control" name="autor" placeholder="Autor">
				    <br>
				  </div>
				  <div class="form-group">
					  <input type="search" class="form-control" name="editorial" placeholder="Editorial">
				    <br>
				  </div>
				    <div class="form-group">
					  <input type="search" class="form-control" name="area" placeholder="Area">
				    <br>
				  </div>
				    <button type="submit" class="btn btn-success btn-block">Busqueda</button>
				</form>    			
			</div>
		
		<div class="col-md-4">
			<img class="img-responsive" src="images/busqueda avanzada.jpg" alt="">
		</div>
		</div><!-- /row -->
	</div><!-- /ww -->
	
	
	<!-- +++++ Projects Section +++++ -->
	
	
	
	
	<!-- +++++ Footer Section +++++ -->
	<%@include file="incl_footer.jsp" %>
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>