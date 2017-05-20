<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Administraci&oacute;n</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilos.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilos2.css"/>">	
<body>

	<header>
		<a href="/project/"><h1>Santa Marta Bike</h1></a>		
	</header>
	
	<div id="raya"></div>
	
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="/project/">Inicio</a>
		    </div>
		<!-- **************************************** -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Tipos de Bicicleta <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="tipobici">Crear Tipo de Bicicleta</a></li>
		            <li><a href="tipobici-ba">Consultar Tipo de Bicicleta</a></li>
		            <li><a href="#">Actualizar Tipo de Bicicleta</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#">Gestionar Tipo de Bicicleta</a></li>
		          </ul>
		        </li>
				<!-- **************************************** -->
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Bicicletas<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="new-bici">Nueva Bicicleta</a></li>
		            <li><a href="buscar-bici">Consultar Bicicleta</a></li>
		            <li><a href="#">Listado de Bicicletas</a></li>
		            <li role="#" class="divider"></li>
		            <li><a href="#">Gestión de Bicicletas</a></li>
		          </ul>
		        </li>
				<!-- **************************************** -->
				<li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Multas<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="multas">Nueva Multas</a></li>
		            <li><a href="multas-bu">Consultar Info Multas</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="admin">Administrar Multas</a></li>
		          </ul>
		        </li>
		        <!-- **************************************** -->
		        
				<li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuarios<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="usuario">Nuevo Usuario</a></li>
		            <li><a href="#">Consultar Usuario</a></li>
		            <li><a href="#">Lista de Usuarios</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#">Gestionar Usuarios</a>
		            	<ul class="dropdown-menu">
		            		<li><a href="#">Prueba</a></li>
		            	</ul>
		            </li>
		          </ul>
		        </li>
		        <!-- **************************************** -->

		      </ul>
		      
		      <ul class="nav navbar-nav navbar-right">
       			 <li><a href="#">Cerrar Sesi&oacute;n</a></li>
       		  </ul>
       		  
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>

		<div class="container-fluid">
			<div class="row">
			<h3>Registro - Nueva Multa</h3>
			<hr>
				<div class="col-md-2"></div>
				<div class="col-md-6">
					<form class="form-horizontal">

					  <div class="form-group">
					    <label for="descripcion" class="col-sm-3 control-label">Descripci&oacute;n</label>
					    <div class="col-sm-8">
					      <textarea id="txt-descripcion" name="descripcion" rows="4" class="form-control"></textarea>
					    </div>
					  </div>
	
					  <div class="form-group">
					    <label for="precio" class="col-sm-3 control-label">Precio Multa</label>
					    <div class="col-sm-8">
					      <input id="txt-precio" name="precio" type="text" class="form-control" placeholder="Precio de la Multa">
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10" id="container-actualizar-bici">
					      <button type="submit" id="actualizar-bici" class="btn btn-default btn-action-bici"><span class="glyphicon glyphicon-floppy-saved"></span> Guardar Registro</button>
					    </div>
					  </div>
	
					</form>
				</div>
				<div class="col-md-4"></div>
	   		</div>
		</div>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>