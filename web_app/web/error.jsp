<%-- 
 
    Document   : error
    Created on : Jul 7, 2014, 1:22:12 AM
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="incl_headmeta.html" %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Biblioteca Lee y Aprende: D-oh!</title>
	</head>
<body>
	<%
		if (exception.getMessage().contains("Acceso denegado")){
			request.setAttribute("warning", "No tienes acceso, inicie sesion");
			getServletConfig().
				getServletContext().
				getRequestDispatcher("/index.jsp").
				forward(request, response);
		}
	%>
		<div class="ww">
			<div class="container">
				<div class="row">
					<div class="alert alert-danger">
						<h1>ERROR <%=response.getStatus() %>: 
							<small>Algo terrible ha pasado... <%=exception.getMessage()%></small> </h1>
						</div>
					
					<div class="col-md-6">

						<p>
							Oh! el horror!! algo no está funcionando!
							<strong>Si eres un usuario</strong>, no temas! nuestros técnicos ninja trabajan para solucionar esto; <a href="index.jsp">Has click aquí</a> para regresar a la pagina principal. Probablemente esté más calmado ahí.
						</p>
						
						<p>
							Por otro lado, <strong>si eres un maestro</strong>: cierra los ojos, olvida que ésto paso, y escribe <strong>DE</strong> en la calificacion de los alumnos
						</p>
						
					</div>
					<div class="col-md-6">
						<p>
							Si eres el encargado de esta página, Apura y lee esto, te podria ayudar a comprender que pasó!.
						</p>
						<pre class="pre-scrollable">Error <%=response.getStatus() %>: <%=exception.getMessage() %>:<br><% exception.printStackTrace(); %></pre>
					</div>
				</div> <!-- row -->
			</div>
		</div>
		<script src="assets/js/bootstrap.min.js"></script>
	</body>
</html>
