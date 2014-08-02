<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : header
    Created on : Jul 3, 2014, 10:12:46 PM
    Author     : ricardo
--%>

<%@page import="utez.app.model.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

	boolean login = false;
	
	try{
	login = (Boolean) session.getAttribute("login");
	
	}catch (NullPointerException ex){
	}
	
	boolean admin = false;
	try{
	admin = (Boolean) session.getAttribute("admin");
	
	}catch (NullPointerException ex){
		
	}
	 UsuarioBean usuario = null;
	 
	 try{
		usuario = (UsuarioBean) session.getAttribute("usuario");
	 } catch (NullPointerException ex){
		 
	 }
	 
	  if (usuario == null || !login){
		login = false;
		admin = false;
		usuario = null;
		session.setAttribute("admin", false);
		session.setAttribute("login", false);
		session.setAttribute("usuario", null);
	  }
	  
	  if (login){
		  response.setHeader("Cache-Control", "no-cache");

//Forces caches to obtain a new copy of the page from the origin server
		response.setHeader("Cache-Control", "no-store");

//Directs caches not to store the page under any circumstance
		response.setDateHeader("Expires", 0);

//Causes the proxy cache to see the page as "stale"
		response.setHeader("Pragma", "no-cache");
//HTTP 1.0 backward enter code here
	  }
%>

<nav class="navbar navbar-fixed-top navbar-inverse " role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		  <span class="sr-only">Toggle</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp">LYA</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
		  
		  
		 <% if (login){
		 %>
		 <li ><p class="navbar-text"><%=usuario.getNombre() %></p></li>
			<% if ( admin ){ %>
		<li><a href="Admin">Administrador</a></li>
		<li><a href="admin_prestamos.jsp">Préstamos</a></li>
			<% } else { %>
				
		<li><a href="PerfilUsuario">Perfil</a></li>
			<%  }
		 }%>
		
		<li><a href="Busqueda">Catálogo</a></li>
		
		<% if (login){
		 %>
		<li><a id="logout" href="index.jsp">Cerrar Sesión</a></li>
		  <% } else{ %>
		<li><a  data-toggle="modal" data-target="#LoginMod" href="#login">Inicar Sesión</a></li>
		 <% } %>
	    
	    
          </ul>
        </div><!--/.nav-collapse -->
      </div>
   </nav>

		 <% try { %>
		 <% if (request.getAttribute("warning") != null){%>
			<div class="alert alert-warning">
			 <%=request.getAttribute("warning") %>
			</div> 
		 
		 
		 <%}} catch(Exception ex){} %>
		 
		 
		 <% try { %>
		 <% if (request.getAttribute("info") != null){%>
			<div class="alert alert-info">
			 <%=request.getAttribute("info") %>
			</div> 
		 
		 
		 <%}} catch(Exception ex){} %>
		 
<%@include file="modal_login.jsp" %>
<script type="text/javascript">
	$(document).ready(function (){
		$("#logout").click(function (){
			$.ajax({
			type: "POST",
			url: "Logout",
			data: "",
			success: function(data){
			}
			});
		});
	});
</script>
	