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
	    <%@ include file="principal.jsp" %>
	    <main>
	    	<div class="row contenido">
	        	<div class="col s12 white">
	            	<div class="col s12 separador-contenido-top">
	            	<h5>Administración - Bicicletas</h5>
	            	<hr>
	                	<div class="col  s12 m6 l6  margin-bottom">
	                    	<input type="text" name="" value="" class="input-buscar" placeholder="Placa">
	                        <button type="button" name="button" class="boton-buscar ">Buscar</button>
	                    </div>
	                    <div class="col s12.left m6 l6 margin-bottom">
	                    	<div class="right">
	                        	<button id="btn-nueva-bici" type="button" name="button" class="botton-agregar" data-target="modal-bicicleta">Agregar Bicicleta</button>
	                        </div>
	                    </div>
	                </div>
	                <div class="col s12 separador-contenido-top">
	                	<div class="col s12">
	                    	<div class="contendenor-tabla separador-contenido-botton">
	                        	<table id="table-biclicleta">
	                            	<thead>
	                                	<tr>
	                                    	<th>Placa</th>
	                                        <th>Tipo</th>
	                                        <th>Color</th>
	                                        <th>Sítio Asignado</th>
	                                        <th>Estado</th>
	                                        <th>Acción</th>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                    <c:forEach var = "bicicleta" items="${bicis}">
	                                    <tr>
	                                    	<td>${bicicleta.placa}</td>
	                                    	<td>${bicicleta.idTipoBici.tipo}</td>
	                                    	<td>${bicicleta.color}</td>
	                                    	<td>${bicicleta.idSitio.nombre}</td>
	                                    	<td>${bicicleta.estado}</td>
	                                        <td><input type="button" name="actualizar" class="btn-actualizar btn-accion btn-editar" data-target="modal-bicicleta" value="Editar"></td>
	                                    </tr>
	                                    </c:forEach>
	                                </tbody>
	                          	</table>
	                   			<div class="contenedor-total-res">
	                            	<p>Total <span>3</span> Registros </p>
	                            </div>
	                     	</div>
	                  	</div>
	               	</div>
	          	</div>
	       	</div>
	    </main> 
	    <%@ include file="modal-bicicleta.jsp" %>
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
        <script src="resources/js/logicaBicicleta.js"></script>
        <script src="resources/js/index.js"></script>
        <script src="resources/js/menu.js"></script>
	</body>	      	
</html>