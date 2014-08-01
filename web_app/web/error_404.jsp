<%-- 
    Document   : error_404
    Created on : Jul 5, 2014, 9:15:00 PM
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="incl_headmeta.html" %>
		<title>Biblioteca Lee y Aprende: Ups</title>
	</head>
	<body>
	
		<div class="ww">
			<div class="container">
				<div class="row">
					<div class="alert alert-danger">
						<h1>ERROR 404: <small>Si ves esto, no estas donde quieres estar</small></h1>
						</div>
					
					<div class="col-md-6">
						
						
						<p>
							La página no existe, podrías estar aquí por varias causas
						</p>
						<ul>
							<li>Nunca existió</li>
							<li>Algo muy malo paso</li>
							<li>Ecrsibiste algo mal</li>
							<li>Te gusta nuestra página 404</li>
						</ul>
					</div>
					<div class="col-md-6">
						<p>
							Podrias intentar:
						</p>
						<ol>
							<li>Hacer click en el boton de regresar de tu navegador</li>
							<li>Revisar que la dirección sea correcta</li>
							<li><a href="index.jsp">Hacer click aquí</a></li>
							<li>Dar vueltas en círculos</li>
						</ol>
					</div>
				</div> <!-- row -->
			</div>
		</div>
		<script src="assets/js/bootstrap.min.js"></script>
	</body>
</html>
