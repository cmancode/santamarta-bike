<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
	    <head>
        <title>Admin Usuarios</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/materialize.css">
        <link rel="stylesheet" href="resources/css/style.css">
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    </head>
    <body>
	    <%@ include file="principal.jsp" %>
	    <main>
	    	<div class="row contenido">
	        	<div class="col s12 white">
	            	<div class="col s12 separador-contenido-top">
	            	<h5>Administración - Usuarios</h5>
	            	<hr>
	                	<div class="col  s12 m6 l6  margin-bottom">
	                    	<input type="text" name="" value="" class="input-buscar" placeholder="Núm Documento">
	                        <button type="button" name="button" class="boton-buscar ">Buscar</button>
	                    </div>
	                    <div class="col s12.left m6 l6 margin-bottom">
	                    	<div class="right">
	                        	<button id="call-modal" type="button" name="button" class="botton-agregar" data-target="modal-usuario">Agregar Nuevo Usuario</button>
	                        </div>
	                    </div>
	                </div>
	                <div class="col s12 separador-contenido-top">
	                	<div class="col s12">
	                    	<div class="contendenor-tabla separador-contenido-botton">
	                        	<table id="table-usuarios">
	                            	<thead>
	                                	<tr>
	                                    	<th>Tipo Documento</th>
	                                        <th>Número Documento</th>
	                                        <th>Nombres</th>
	                                        <th>Primer Apellido</th>
	                                        <th>Segundo Apellido</th>
	                                        <th>E-Mail</th>
	                                        <th>Rol</th>
	                                        <th>Acción</th>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                               	<c:forEach var="lUsuarios" items="${listUsuarios}"> 
	                               		<tr>
	                                    	<td>${lUsuarios.tipoDoc}</td>
	                                        <td>${lUsuarios.cedula}</td>
	                                        <td>${lUsuarios.nombres}</td>
	                                        <td>${lUsuarios.pApellido}</td>
	                                        <td>${lUsuarios.sApellido}</td>
	                                        <td>${lUsuarios.email}</td>
	                                        <td>
	                                        <c:forEach var="roles" items="${lUsuarios.rol.toArray()}">
	                                        	${roles.rol}
	                                        </c:forEach>
	                                        </td>
	                                        <td><input type="button" name="actualizar" class="btn-actualizar btn-accion" value="Actualizar"></td>
	                                    </tr>
	                               	</c:forEach>
	                                </tbody>
	                          	</table>
	                   			<div class="contenedor-total-res">
	                            	<p>Total <span>1</span> Registros </p>
	                            </div>
	                     	</div>
	                  	</div>
	               	</div>
	          	</div>
	       	</div>
	    </main> 
	 
	    <%@ include file="modal-usuario.jsp" %>
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
        <script src="resources/js/index.js"></script>
        <script src="resources/js/logicaUsuario.js"></script>
	</body>	      	
</html>