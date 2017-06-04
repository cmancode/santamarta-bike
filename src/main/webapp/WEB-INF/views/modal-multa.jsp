<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- modal tipo bicicleta -->
<div id="modal-multa" class="modal">
	<div class="modal-header">
    	<h5>Multa</h5>
    </div>
    <div class="modal-section separador-contenido-top separador-contenido-botton">
    	<div class="input-informacion margin-bottom">
        	<div class="contenedor-label-form ">
        	<input type="hidden" id="txt-id" value="" >
            	<label for="descripcion" class="label-form" >Descripción </label>
            </div>
            <div class="contenedor-input-form ">
            	<textarea id ="txt-descripcion" rows="4" cols="50"></textarea>
            </div>
        </div>
        <div class="input-informacion margin-bottom ">
        	<div class="contenedor-label-form">
            	<label for="costo" class="label-form" >Costo </label>
            </div>
            <div class="contenedor-input-form">
            	<input type="text" name="descripcion" id="text-costo" class="input-form" >
            </div>
        </div>
        <div class="input-informacion margin-bottom ">
        	<div class="contenedor-label-form">
            	<label for="costo" class="label-form" >Estado </label>
            </div>
            <div class="contenedor-input-form">
            	<select id="txt-estado" class="input-form">
            		<option value="-1">Seleccionar...</option>
            		<option value="Activa">Activa</option>
            		<option value="Inactiva">Inactiva</option>
            	</select>
            </div>
        </div>
    </div>
      <div class="modal-foter">
      	<div class="contenido-botones-foter">
        	<button class="modal-action modal-close waves-effect waves-green btn-cancelar">Cancelar</button>
            <button id="guardar-multa" class="modal-action modal-close waves-effect waves-green btn-ok">Guardar</button>
        </div>
      </div>
 </div>
