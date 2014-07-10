
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>LOGIN </title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="assets/css/main.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="assets/js/hover.zoom.js"></script>
    <script src="assets/js/hover.zoom.conf.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
	  <%@include file="incl_navbar.jsp" %>

<div style="padding: 100px 0 0 250px;">


<form class="form-horizontal" action="Login" method = "POST">
<fieldset>

<!-- Form Name -->
<legend><b>Login</b><br/>Bienvenido a LYA</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="correo">Correo:</label>  
  <div class="col-md-5">
	  <input id="correo" name="correo" placeholder="correo@ejemplo.com" class="form-control input-md" required="" 
		 type="email">
    
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Contraseña</label>
  <div class="col-md-5">
    <input id="password" name="password" placeholder="contraseña" class="form-control input-md" required="" type="password">
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" class="btn btn-primary">Enviar</button>
  </div>
</div>

</fieldset>
</form>
</div>
          


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/bootstrap.min.js"></script>
      
</body>
</html>