<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- modal tipo bicicleta -->
<div id="modal-reserva" class="modal">
	<div class="modal-header">
    	<h5>Reserva</h5>
    </div>
    <div class="modal-section separador-contenido-top separador-contenido-botton">
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
      <div class="modal-foter">
      	<div id="cambiar-btns" class="contenido-botones-foter">
        	<button class="modal-action modal-close waves-effect waves-green btn-cancelar">Cancelar</button>
            <button id="guardar-bici" class="modal-action modal-close waves-effect waves-green btn-ok">Guardar Registro</button>
        </div>
      </div>
 </div>
