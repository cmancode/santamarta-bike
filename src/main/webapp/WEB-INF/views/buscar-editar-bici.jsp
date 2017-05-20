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
		            <li><a href="#">Gestionar Usuarios</a></li>
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
	
				<div class="col-md-8">
	
					<form class="form-horizontal">
					
						<h3>Gesti&oacute;n - Informaci&oacute;n Bicicleta</h3>
						<hr>
						  <div class="form-group">
						    <label for="placa" class="col-sm-2 control-label">Placa</label>
						    <div class="col-sm-5">
						      <input type="text" class="form-control" id="txt-id-placa" placeholder="Placa">
						    </div>
							<button class="btn btn-default" id="btn-bucar-bici"><li class="glyphicon glyphicon-search"></li></button>
						  </div>
						
						</form>
						
						</br></br>
		
						<form class="form-horizontal form-resultado">
					
						  <div class="form-group">
						    <label for="color" class="col-sm-2 control-label">Color</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" id="txt-color-bici">
						    </div>
						  </div>
		
						  <div class="form-group">
						    <label for="estado" class="col-sm-2 control-label">Estado</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" id="txt-estado-bici">
						    </div>
						  </div>
		
						  <div class="form-group">
						    <label for="tipobici" class="col-sm-2 control-label">T. Bicicleta</label>
						    <div class="col-sm-4">
						      <input type="hidden" id="txt-id-tipo"/>
						      <input type="hidden" id="txt-descripcion"/>
						      <input type="text" class="form-control" id="txt-tipo-bici" disabled="disabled">
						    </div>
						    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal"><li class="glyphicon glyphicon-plus"></li></button>
						  </div>
	
					</form>
					
				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4 form-resultado" id="container-btn-update">
					<button class="btn btn-default" id="guardar-cambios"><li class="glyphicon glyphicon-floppy-saved"></li> Guardar cambios</button>
				</div>
			</div>
		</div>
	
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		    <div class="modal-dialog" role="document">
			    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">Seleccionar Tipo de Bicicletas</h4>
				      </div>
				      <div class="modal-body">
			      		<table class="table table-bordered" id="table-modal-busqueda">
			      			<tr>
			      				<th>Selección</th>
			      				<th>Identificador</th>
			      				<th>Nombre</th>
			      				<th>Descripcion</th>
			      			</tr>
			      			
			      			<c:forEach var="tipos" items="${tiposbici}">
								<tr>
									<td id="td-select"><a class="btn btn-default" id="btn-select"><li class="glyphicon glyphicon-check"></li></a></td>
					      			<td>${tipos.idTipoBici}</td>
					      			<td>${tipos.tipo}</td>
					      			<td>${tipos.descripcion}</td>		
								</tr>
							</c:forEach> 
			      		</table>
				      </div>
			    <!--  <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary">Save changes</button>
			      </div>
			    </div> -->
			  </div>
		    </div>
		</div>
		
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/js/logicaBicicleta.js"/>"></script>
</body>
</html>