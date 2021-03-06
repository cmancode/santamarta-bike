<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
	    <head>
        <title>Multas </title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/materialize.css">
        <link rel="stylesheet" href="resources/css/style.css">
    </head>
    <body>
	    <%@ include file="principal.jsp" %>
	    <main>
	    	<div class="row contenido">
	        	<div class="col s12 white">
	            	<div class="col s12 separador-contenido-top">
	            	<h5>Administración - Multas</h5>
	            	<hr>
	                	<div class="col  s12 m6 l6  margin-bottom">
	                    	<input type="text" name="" value="" class="input-buscar" placeholder="Palabra clave">
	                        <button type="button" name="button" class="boton-buscar ">Buscar</button>
	                    </div>
	                    <div class="col s12.left m6 l6 margin-bottom">
	                    	<div class="right">
	                        	<button id="btn-nueva-multa" type="button" name="button" class="botton-agregar" data-target="modal-multa">Agregar Multas</button>
	                        </div>
	                    </div>
	                </div>
	                <div class="col s12 separador-contenido-top">
	                	<div class="col s12">
	                    	<div class="contendenor-tabla separador-contenido-botton">
	                        	<table id="tabla-multas">
	                            	<thead>
	                                	<tr>
	                                    	<th>Descripción</th>
	                                        <th>Costo</th>
	                                        <th>Estado</th>
	                                        <th>Acción</th>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                <c:forEach var = "multa" items="${novedad}">
	                                    <tr id="idmulta${multa.id}">
	                                     	 <input type="hidden" id="idmulta" value="${multa.id}" />
	                                    	<td>${multa.descripcion}</td>
	                                    	<td>${multa.costo}</td>
	                                    	<td>${multa.estado}</td>
	                                        <td><input data-id="${multa.id}" type="button" name="actualizar" data-target="modal-multa" class="btn-actualizar btn-accion" value="Editar"></td>
	                                    	
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
	
	    <%@ include file="modal-multa.jsp" %>
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
        <script src="resources/js/logicaMultas.js"></script>
         <script src="resources/js/index.js"></script>
        <script src="https://use.fontawesome.com/72fa6900c1.js"></script>
        <script src="resources/js/index.js"></script>
        <script src="resources/js/menu.js"></script>
	</body>	      	
</html>