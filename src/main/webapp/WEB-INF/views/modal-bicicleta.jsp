<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- modal tipo bicicleta -->
<div id="modal-bicicleta" class="modal">
	<div class="modal-header">
    	<h5>Bicicleta</h5>
    </div>
    <div class="modal-section separador-contenido-top separador-contenido-botton">
    	<div class="input-informacion margin-bottom">
        	<div class="contenedor-label-form ">
            	<label for="placa" class="label-form" >Placa </label>
            </div>
            <div class="contenedor-input-form ">
            	<input type="text" name="placa" id="txt-placa" class="input-form">
            </div>
        </div>
        <div class="input-informacion margin-bottom ">
        	<div class="contenedor-label-form">
            	<label for="color" class="label-form" >Color </label>
            </div>
            <div class="contenedor-input-form">
            	<input type="text" name="color" id="txt-color" class="input-form" >
            </div>
        </div>
        <div class="input-informacion margin-bottom ">
        	<div class="contenedor-label-form">
            	<label for="tipo-bici" class="label-form" >Tipo Bicicleta </label>
            </div>
            <div class="contenedor-input-form">
            	<select class="input-form" id="txt-tipobici">
            		<option value = "-1">Seleccionar...</option>     	
	            	<c:forEach var = "tipos" items="${tiposbici}">
	            		<option value = "${tipos.idTipoBici}">${tipos.tipo}</option>
	            	</c:forEach>
            	</select>
            </div>
        </div>
        <div class="input-informacion margin-bottom ">
        	<div class="contenedor-label-form">
            	<label for="sitio" class="label-form" >Sítio </label>
            </div>
            <div class="contenedor-input-form">
            	<select class="input-form" id="txt-sitio">
            		<option value = "-1">Seleccionar...</option>
            		<option value = "1">Sítio 1</option>
            		<option value = "2">Sítio 2</option>
            		<option value = "3">Sítio 3</option>
            		<option value = "4">Sítio 4</option>
            	</select>
            </div>
        </div>
        <div class="input-informacion margin-bottom ">
        	<div class="contenedor-label-form">
            	<label for="estado" class="label-form" >Estado </label>
            </div>
            <div class="contenedor-input-form">
            	<select class="input-form" id="txt-estado">
            		<option value = "-1">Seleccionar...</option>
            		<option value = "DISPONIBLE">DISPONIBLE</option>
            		<option value = "NO DISPONIBLE">NO DISPONIBLE</option>
            	</select>
            </div>
        </div>
    </div>
      <div class="modal-foter">
      	<div class="contenido-botones-foter">
        	<button class="modal-action modal-close waves-effect waves-green btn-cancelar">Cancelar</button>
            <button  class="modal-action modal-close waves-effect waves-green btn-ok">Guardar</button>
        </div>
      </div>
 </div>
