<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- modal tipo bicicleta -->
<div id="modal-usuario" class="modal">
	<div class="modal-header">
    	<h5>Usuario</h5>
    </div>
    <div class="modal-content modal-section separador-contenido-top separador-contenido-botton">
		<div class="row">
			<div class="col s6">
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="tipo-doc" class="label-form" >Tipo Documento </label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<select class="input-form">
		            		<option value = "-1">Seleccionar...</option>
		            		<option value = "Cédula Ciudadanía">Cédula Ciudadanía</option>
		            		<option value = "Tarjeta de Identidad">Tarjeta de Identidad</option>
		            	</select>
		            </div>
		        </div>
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="num-doc" class="label-form" >Nún Documento</label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<input type="text" name="num-doc" id="txt-num-doc" class="input-form">
		            </div>
		        </div>
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="nombres" class="label-form" >Nombres </label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<input type="text" name="nombres" id="txt-numbres" class="input-form">
		            </div>
		        </div>
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="p-apellido" class="label-form" >Primer Apellido </label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<input type="text" name="p-apellido" id="txt-papellido" class="input-form">
		            </div>
		        </div>
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="s-apellido" class="label-form" >Seg. Apellido </label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<input type="text" name="s-apellido" id="txt-sapellido" class="input-form">
		            </div>
		        </div>
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="pass" class="label-form" >Contraseña </label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<input type="password" name="pass" id="txt-passw" class="input-form">
		            </div>
		        </div>
			</div>
			<div class="col s6">
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="ciudad" class="label-form" >Ciudad Resid. </label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<input type="text" name="ciudad" id="txt-ciudad" class="input-form">
		            </div>
		        </div>
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="direccion" class="label-form" >Dirección Resid.</label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<input type="text" name="direccion" id="txt-direccion" class="input-form">
		            </div>
		        </div>
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="email" class="label-form" >E-Mail</label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<input type="email" name="email" id="txt-email" class="input-form">
		            </div>
		        </div>
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="confirmar-email" class="label-form" >Confirmar E-Mail</label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<input type="email" name="confirmar-email" id="txt-confir-email" class="input-form">
		            </div>
		        </div>
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="telefono" class="label-form" >Telf Contacto</label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<input type="text" name="telefono" id="txt-telefono" class="input-form">
		            </div>
		        </div>
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="pass" class="label-form" >Confirmar Contraseña </label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<input type="password" name="pass2" id="txt-confirmar-pss" class="input-form">
		            </div>
		        </div>
			</div>
		</div>
		<div class="row">
			<div class ="col s6">
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="esat" class="label-form" >Estado </label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<select class="input-form">
		            		<option value = "-1">Seleccionar...</option>
		            		<option value = "Cédula Ciudadanía">ACTIVO</option>
		            		<option value = "Tarjeta de Identidad">INACTIVO</option>
		            	</select>
		            </div>
		        </div>
			</div>
			<div class ="col s6">
		    	<div class="input-informacion margin-bottom">
		        	<div class="contenedor-label-form ">
		            	<label for="esat" class="label-form" >Funciones </label>
		            </div>
		            <div class="contenedor-input-form ">
		            	<select class="input-form">
		            		<option value = "-1">Seleccionar...</option>
		            		<option value = "Cédula Ciudadanía">ADMINISTRADOR</option>
		            		<option value = "Tarjeta de Identidad">FUNCIONARIO</option>
		            		<option value = "Tarjeta de Identidad">USUARIO</option>
		            	</select>
		            </div>
		        </div>
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
