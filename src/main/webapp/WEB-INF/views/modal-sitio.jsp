<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- modal sitio -->
<div id="modal1" class="modal">
	<div class="modal-header">
    	<span>Crear Sitios</span>
    </div>
    <div class="modal-section separador-contenido-top separador-contenido-botton">
    	<div class="input-informacion margin-bottom">
        	<div class="contenedor-label-form ">
            	<label for="sitio" class="label-form" >Sitio </label>
            </div>
            <div class="contenedor-input-form ">
            	<input type="text" name="sitio" id="sitio" class="input-form">
            </div>
        </div>
           	<div class="input-informacion margin-bottom">
        	<div class="contenedor-label-form ">
            	<label for="avatar" class="label-form" >Avatar </label>
            </div>
            <div class="contenedor-input-form ">
            	<div class="input__row uploader">
   					 <div id="inputval" class="input-value"></div>
    				 <label for="file_1"></label>
   					 <input id="file_1" class="upload" type="file">
				</div>
            </div>
        </div>
           	<div class="input-informacion margin-bottom">
        	<div class="contenedor-label-form ">
            	<label for="latitud" class="label-form" >Latitud </label>
            </div>
            <div class="contenedor-input-form ">
            	<input type="text" name="latitud" id="latitud" class="input-form">
            </div>
        </div>
           	<div class="input-informacion margin-bottom">
        	<div class="contenedor-label-form ">
            	<label for="longitud" class="label-form" >Longuitud </label>
            </div>
            <div class="contenedor-input-form ">
            	<input type="text" name="longitud" id="longitud" class="input-form">
            </div>
        </div>
           	<div class="input-informacion margin-bottom">
        	<div class="contenedor-label-form ">
            	<label for="direccion" class="label-form" >Dirección </label>
            </div>
            <div class="contenedor-input-form ">
            	<input type="text" name="direccion" id="direccion" class="input-form">
            </div>
        </div>
    </div>
      <div class="modal-foter">
      	<div id="cambiar-btns-modal" class="contenido-botones-foter">

        </div>
      </div>
 </div>