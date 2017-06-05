<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
	<head>
        <title>Bicicletas Prestadas</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/materialize.css">
        <link rel="stylesheet" href="resources/css/style.css">
    </head>
    <body>
	    <%@ include file="funcionario-principal.jsp" %>
	    <main>
	    	<div class="row contenido">
	        	<div class="col s12 white">
	                <div class="col s12 separador-contenido-top">
	                	<h5>Bicicletas - Prestadas</h5>
	            		<hr>
	                	<div class="col s12">
	                    	<div class="contendenor-tabla separador-contenido-botton">
	                        	<table id="tabla-tipoBicicleta">
	                            	<thead>
	                                	<tr >
	                                    	<th>Tipo Bicicleta</th>
	                                        <th>Placa</th>
	                                        <th>Sitio</th>
	                                        <th>Estado</th>
	                                    </tr>
	                                </thead>
	                                <tbody id="cuerpoTabla">
	                                	<%! int i = 0;%>
	                                	<c:forEach var="reserva" items="${reservas}">
	                            
	                                			<tr data-id="${reserva.id}"> 
	                                				<td>${reserva.estado}</td>
	                                				<td>${reserva.idBicicleta}</td>
	                                				<td>${reserva.idSitio.nombre}</td>
	                                				<td class='btn-actualizar'>${reserva.idUsuario.nombres} </td>
	                                			</tr>
	                                			<% i = i + 1; %>
	                                		
	                                	</c:forEach>
	                                	
	                                </tbody>
	                          	</table>
	                   			<div class="contenedor-total-res">
	                            	<p>Total <span id="cantidadElementos"><%=i%></span> Registros </p>
	                            	<% i = 0; %>
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
        <script src="resources/js/menu.js"></script>
	</body>	      	
</html>