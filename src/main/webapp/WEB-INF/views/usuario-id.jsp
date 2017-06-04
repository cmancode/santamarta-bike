<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
	    <head>
        <title>Bicicletas</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/materialize.css">
        <link rel="stylesheet" href="resources/css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Arimo|Old+Standard+TT|Playfair+Display|Roboto" rel="stylesheet">
    </head>
    <body>
	    <%@ include file="principal.jsp" %>
	    <main>
	    	<div class="row contenido">
	        	<div class="col s12 white">
	            	<div class="col s12 separador-contenido-top">
	            	<h5>Información del Usuario</h5>
	            	<hr>
	                	<div class="col  s12 m6 l6  margin-bottom">
	                    	<input id="txt-id" type="text" name="" value="" class="input-buscar" placeholder="Placa">
	                        <button id="btn-buscar-id" type="button" name="button" class="boton-buscar ">Buscar</button>
	                    </div>
	                </div>
	                <div class="col s12 separador-contenido-top">
	                	<div id="datos-usuario" class="col s12">
		                    <div class="col s12">
						        <div class="input-informacion margin-bottom">
						        	<div class="contenedor-label-form ">
						            	<label for="num-doc" class="label-form1" >Roles </label>
						            </div>
						            <div class="contenedor-input-form ">
						            	<label id="lbl-roles" class="label-form1" ></label>
						            </div>
						        </div>
						        <div class="input-informacion margin-bottom">
						        	<div class="contenedor-label-form ">
						            	<label for="num-doc" class="label-form1" >Tipo de Documento</label>
						            </div>
						            <div class="contenedor-input-form ">
						            	<label id="lbl-tipo-doc" class="label-form1" ></label>
						            </div>
						        </div>
						        <div class="input-informacion margin-bottom">
						        	<div class="contenedor-label-form ">
						            	<label for="num-doc" class="label-form1" >Número de Identificación</label>
						            </div>
						            <div class="contenedor-input-form ">
						            	<label id="lbl-identificacion" class="label-form1" ></label>
						            </div>
						        </div>
						        <div class="input-informacion margin-bottom">
						        	<div class="contenedor-label-form ">
						            	<label for="num-doc" class="label-form1" >Nombres</label>
						            </div>
						            <div class="contenedor-input-form ">
						            	<label id="lbl-nombres" class="label-form1" ></label>
						            </div>
						        </div>
						        <div class="input-informacion margin-bottom">
						        	<div class="contenedor-label-form ">
						            	<label for="num-doc" class="label-form1" >Primer Apellido</label>
						            </div>
						            <div class="contenedor-input-form ">
						            	<label id="lbl-papellido" class="label-form1" ></label>
						            </div>
						        </div>
						        <div class="input-informacion margin-bottom">
						        	<div class="contenedor-label-form ">
						            	<label for="num-doc" class="label-form1" >Segundo Apellido</label>
						            </div>
						            <div class="contenedor-input-form ">
						            	<label id="lbl-sapellido" class="label-form1" ></label>
						            </div>
						        </div>
						        <div class="input-informacion margin-bottom">
						        	<div class="contenedor-label-form ">
						            	<label for="num-doc" class="label-form1" >Correo</label>
						            </div>
						            <div class="contenedor-input-form ">
						            	<label id="lbl-correo" class="label-form1" ></label>
						            </div>
						        </div>
						        <div class="input-informacion margin-bottom">
						        	<div class="contenedor-label-form ">
						            	<label for="num-doc" class="label-form1" >Ciudad de Resirencia</label>
						            </div>
						            <div class="contenedor-input-form ">
						            	<label id="lbl-ciudad" class="label-form1" ></label>
						            </div>
						        </div>
						        <div class="input-informacion margin-bottom">
						        	<div class="contenedor-label-form ">
						            	<label for="num-doc" class="label-form1" >Dirección Residencia</label>
						            </div>
						            <div class="contenedor-input-form ">
						            	<label id="lbl-direccion" class="label-form1" ></label>
						            </div>
						        </div>
						        <div class="input-informacion margin-bottom">
						        	<div class="contenedor-label-form ">
						            	<label for="num-doc" class="label-form1" >Teléfono de Contacto</label>
						            </div>
						            <div class="contenedor-input-form ">
						            	<label id="lbl-telefono" class="label-form1" ></label>
						            </div>
						        </div>
						        <div class="input-informacion margin-bottom">
						        	<div class="contenedor-label-form ">
						            	<label for="num-doc" class="label-form1" >Estado</label>
						            </div>
						            <div class="contenedor-input-form ">
						            	<label id="lbl-estado" class="label-form1" ></label>
						            </div>
						        </div>
		                  	</div>
	                  	</div>
	               	</div>
	          	</div>
	       	<div class="card-panel datos-usuario">
		      <span class="blue-text text-darken-2">
					¡NOTA! La información aquí suministrada es solo para fines informativos.
					Si desea actualizar algún tipo de información del usuario digijase al módulo Administrar Usuarios
			  </span>
		    </div>
	       	</div>
	    </main> 
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
        <script src="https://use.fontawesome.com/72fa6900c1.js"></script>
        <script src="resources/js/logicaUsuario.js"></script>
        <script src="resources/js/menu.js"></script>
        <script src="resources/js/index.js"></script>
	</body>	      	
</html>