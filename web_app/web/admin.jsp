<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">
  <head>
    
	  <%@include file="incl_headmeta.html" %>
	   
    <title> LYA Menu de Administrador </title>
    
    
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
	String seccion;
	if(request.getAttribute("seccion") != null){
		seccion = (String) request.getAttribute("seccion");
	}else{
		seccion = "usuario";
	}
    %>
    

	<!-- +++++ Welcome Section +++++ -->
	
	<div id="ww" style="padding-top: 10px;">
		<div class="container-fluid" >
		    <div class="row row-offcanvas row-offcanvas-left">
			    <div class="col-md-3 sidebar">
				   
				    
					    <div id="form"
						 class="well">
						    Formulario
					    </div>
				   
			    </div>


		    <div class="col-md-9 col-md-offset-3 main" >	
			    <div class="page-header">
			    <h1>Administrador de LYA</h1>
			    </div>
			    
			    <ul class="nav nav-pills" id="nav-admin">
				    <li id="selectUsuario"
					class="categoria">
					    <a href="#"> 
						    Usuario 
					    </a>
				    </li>
				    <li id ="selectLibro"
					class="categoria">
					    <a href="#"> Libro </a>   
				    </li>
				    <li id="selectAutor"
					class="categoria">
					    <a href="#"> Autor </a>   
				    </li>
				    <li id="selectEditorial"
					class="categoria">
					    <a href="#"> Editorial </a>   
				    </li>

				    <li id="selectArea"
					class="categoria">

					    <a href="#"> Área </a>
				    </li>
			    </ul>
			    <br/>
			   
			    <div id="tbl" >
				    <!-- Tabla -->
				    Elija una opción
			    </div>
			    
			    
		    </div>  <!-- col -->
		    
		    
		    
		    
		    </div> <!-- row -->
			   
	    </div> <!-- /container -->
	    
	</div><!-- /ww -->
	
	
	<!-- +++++ Information Section +++++ -->
	


	<!-- +++++ Footer Section +++++ -->
	
	<div class="col-md-offset-3">
	<%@include file="incl_footer.jsp" %>
	</div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/bootstrap.min.js"></script>
    
    <!-- my scripts -->
    <script type="text/javascript">
	    
	   
	    LIBRO = 1;
	    USUARIO = 2;
	    AUTOR = 3;
	    EDITORIAL = 4;
	    AREA = 5;
	    lastLoad = USUARIO;
	     
	    function loadLibro(){
		$(".page-header").html(
			"<h1>Administrador: Libro</h1>");
		$("#tbl").load("ServletTablaLibro");
		$("#form").load("form_libro.jsp");
		lastLoad = LIBRO;
	    } 
	    function loadUsuario(){
		    $(".page-header").html(
			"<h1>Administrador: Usuario</h1>");
		$("#tbl").load("ServletTablaUsuario");
		$("#form").load("form_usuario.jsp");
		lastLoad=USUARIO;
	    } 
	    function loadAutor(){
		    $(".page-header").html(
			"<h1>Administrador: Autor</h1>");
		$("#tbl").load("ServletTablaAutor");
		$("#form").load("form_autor.jsp");
		lastLoad = AUTOR;
	    } 
	    function loadEditorial(){
		    $(".page-header").html(
			"<h1>Administrador: Editorial</h1>");
		$("#tbl").load("ServletTablaEditorial");
		$("#form").load("form_editorial.jsp");
		lastLoad=EDITORIAL;
	    } 
	    function loadArea(){
		    $(".page-header").html(
			"<h1>Administrador: Área</h1>");
		$("#tbl").load("ServletTablaArea");
		$("#form").load("form_area.jsp");
		lastLoad = AREA;
	    }
	    
	    function reloadTable(){
		    
		    switch(lastLoad){
			    case USUARIO:
				    $("#tbl").load("ServletTablaUsuario");
				    break;
			    case LIBRO:
				    $("#tbl").load("ServletTablaLibro");
				    break;
			    case EDITORIAL:
				    $("#tbl").load("ServletTablaEditorial");
				    break;
			    case AREA:
				    $("#tbl").load("ServletTablaArea");
				    break;
			    case AUTOR:
				    $("#tbl").load("ServletTablaAutor");
				    break;
			
		    }
	    }
	    
	    
	    $(document).ready(function(){  
		    
		
	
		//seleccion
		$(".nav li.categoria").click(function(){
			$(".nav > li.categoria").removeClass("active");
			$(this).addClass("active");
		});
		
		//LIBRO
		$("#selectLibro").click(function (){
			loadLibro();
		});
		//USUARIO
		$("#selectUsuario").click(function (){
			loadUsuario();
		});
		//AUTOR
		$("#selectAutor").click(function (){
			loadAutor();
		});
		//EDITORIAL
		$("#selectEditorial").click(function (){
			loadEditorial();
		});
		//AREA
		$("#selectArea").click(function (){
			loadArea();
		});
		
		$("#form").on("submited", function (){
			reloadTable();
		});
		
		
		//scriplet Java
	    <%
		//cargar default
		    String js;
		    if (seccion.equals("usuario")) {
			    js="$('#selectUsuario').trigger('click');";
				   
		    } else if (seccion.equals("libro")) {
				js="$('#selectLibro').trigger('click');";
		    } else if (seccion.equals("autor")) {
			   js="$('#selectAutor').trigger('click');";
		    } else if (seccion.equals("editorial")) {
			   js="$('#selectEditorial').trigger('click');";
		    } else {
			    js="$('#selectArea').trigger('click');";
		    }
		    out.print(js);
	    %>
			    
	}); 
	
    </script>
    
    <script src="assets/js/keepAlive.js" type="text/javascript"></script>
  </body>
</html>