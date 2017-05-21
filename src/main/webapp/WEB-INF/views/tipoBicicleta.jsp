<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
	    <head>
        <title>Tipos De Bicicletas</title>
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
	                	<div class="col  s12 m6 l6  margin-bottom">
	                    	<input type="text" name="" value="" class="input-buscar" placeholder="Tipo De Bicicleta">
	                        <button type="button" name="button" class="boton-buscar ">Buscar</button>
	                    </div>
	                    <div class="col s12.left m6 l6 margin-bottom">
	                    	<div class="right">
	                        	<button type="button" name="button" class="botton-agregar" data-target="modal1">Agregar Tipo Bicicleta</button>
	                        </div>
	                    </div>
	                </div>
	                <div class="col s12 separador-contenido-top">
	                	<div class="col s12">
	                    	<div class="contendenor-tabla separador-contenido-botton">
	                        	<table>
	                            	<thead>
	                                	<tr>
	                                    	<th>Tipo Bicicleta</th>
	                                        <th>Descripción</th>
	                                        <th>Acción</th>
	                                        <th>Acción</th>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                	<tr>
	                                    	<td>Alvin</td>
	                                        <td>Eclair</td>
	                                        <td><input type="button" name="actualizar" class="btn-actualizar btn-accion" value="Actualizar"></td>
	                                        <td><input type="button" name="eliminar" class="btn-eliminar btn-accion"  value="Eliminar"></td>
	                                    </tr>
	                                    <tr>
	                                    	<td>Alan</td>
	                                       	<td>Jellybean</td>
	                                        <td><input type="button" name="actualizar" class="btn-actualizar btn-accion" value="Actualizar"></td>
	                                        <td><input type="button" name="eliminar" class="btn-eliminar btn-accion"  value="Eliminar"></td>
	                                    </tr>
	                                    <tr>
	                                    	<td>Jonathan</td>
	                                        <td>Lollipop</td>
	                                        <td><input type="button" name="actualizar" class="btn-actualizar btn-accion" value="Actualizar"></td>
	                                        <td><input type="button" name="eliminar" class="btn-eliminar btn-accion"  value="Eliminar"></td>
	                                    </tr>
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
	    <%@ include file="modal.jsp" %>
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
        <script src="resources/js/index.js"></script>
	</body>	      	
</html>