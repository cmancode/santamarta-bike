<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
	    <head>
        <title>Bicicletas</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/materialize.css">
        <link rel="stylesheet" href="resources/css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Arimo|Old+Standard+TT|Playfair+Display|Roboto" rel="stylesheet">
    </head>
    <body>
	    <%@ include file="principal-rol-usuario.jsp" %>
	    <main>
	    	<div class="row contenido">
	        	<div class="col s12 white">
	            	<div class="col s12 separador-contenido-top">
	            	<h5>Reservas realizadas</h5>
	            	<hr>
	                </div>
	                <div class="col s12 separador-contenido-top">
	                	<div class="col s12">
					    	<div class="input-informacion margin-bottom">
					        	<div class="contenedor-label-form ">
					            	<label for="placa" class="label-form" >Sítio </label>
					            </div>
					            <div class="contenedor-input-form ">
					            	<select class="input-form" id="txt-tipobici-reserva">
					            		<option value = "-1">Seleccionar...</option>     	
						            	<c:forEach var = "sitios" items="${sities}">
						            		<option value="${sitios.idSitio}">${sitios.nombre}</option>
						            	</c:forEach>
					            	</select>
					            </div>
					        </div>
					        <div class="input-informacion margin-bottom">
					        	<div class="contenedor-label-form ">
					            	<label for="placa" class="label-form" >Bicicletas </label>
					            </div>
					            <div class="contenedor-input-form ">
					            	<select id="txt-bici-sitios" class="input-form" id="txt-tipobici-reserva">  	
						            		<option value=""></option>
					            	</select>
					            </div>
					        </div>
					        <div class="input-informacion margin-bottom ">
					        	<div class="contenedor-label-form">
					            	<label for="usuario" class="label-form" >Usuario </label>
					            </div>
					            <div class="contenedor-input-form">
					            	<input type="text" name="num-doc" id="txt-num-doc-reserva" class="input-form">
					            	<button id="verificar-usuario" class="waves-effect waves-green btn-ok"><i class="fa fa-check-circle" aria-hidden="true"></i></button>
					            </div>
					        </div>
	                  	</div>
	               	</div>
                  	<div id="container-btn-reserva" class="contenido-botones-foter">
			            <button id="guardar-reserva" class="modal-action modal-close waves-effect waves-green btn-ok">Guardar Registro</button>
			        </div>
	          	</div>
	       	</div>
	    </main> 
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
        <script src="https://use.fontawesome.com/72fa6900c1.js"></script>
        <script src="resources/js/logicaBicicleta.js"></script>
        <script src="resources/js/logicaReserva.js"></script>
        <script src="resources/js/menu.js"></script>
        <script src="resources/js/index.js"></script>
	</body>	      	
</html>