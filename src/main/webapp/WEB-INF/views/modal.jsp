<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- modal tipo bicicleta -->
<div id="modal1" class="modal">
	<div class="modal-header">
    	<span>Crear Tipo De Bicicleta</span>
    </div>
    <div class="modal-section separador-contenido-top separador-contenido-botton">
    	<div class="input-informacion margin-bottom">
        	<div class="contenedor-label-form ">
            	<label for="tipoBici" class="label-form" >Tipo De Bicicleta:</label>
            </div>
            <div class="contenedor-input-form ">
            	<input type="text" name="tipoBicicleta" id="tipoBici" class="input-form">
            </div>
        </div>
        <div class="input-informacion margin-bottom ">
        	<div class="contenedor-label-form">
            	<label for="descripcion" class="label-form" >Descripci�n:</label>
            </div>
            <div class="contenedor-input-form">
            	<input type="text" name="descripcion" id="descripcion" class="input-form" >
            </div>
        </div>
    </div>
      <div class="modal-foter">
      	<div class="contenido-botones-foter">
        	<button class="modal-action modal-close waves-effect waves-green btn-cancelar">Cancelar</button>
            <button  class="modal-action modal-close waves-effect waves-green btn-ok">Ok</button>
        </div>
      </div>
 </div>
