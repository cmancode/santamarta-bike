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
    </head>
    <body>
	    <%@ include file="principal-rol-usuario.jsp" %>
	    <main>
	    <!-- style="display: none;" -->
	    	<div id="contenido-map" class="row contenido">
		    	<div class="col s6 col6-map">
		    		<div class="input-informacion margin-bottom">
			            <div class="contenedor-input-form txt-maps">
			            	<input type="text" name="num-doc" id="txt-lat-origen" class="input-form" placeholder="Latitud">
			            </div>
		        	</div>
		    		<div class="input-informacion margin-bottom">
			            <div class="contenedor-input-form txt-maps">
			            	<input type="text" name="num-doc" id="txt-lng-origen" class="input-form" placeholder="Longitud">
			            </div>
		        	</div>
		    	</div>
		    	<div class="col s6 col6-map">
		    		<div class="input-informacion margin-bottom">
			            <div class="contenedor-input-form txt-maps">
			            	<input type="text" name="num-doc" id="txt-lat-destino" class="input-form" placeholder="Latitud">
			            </div>
		        	</div>
		    		<div class="input-informacion margin-bottom">
			            <div class="contenedor-input-form txt-maps">
			            	<input type="text" name="num-doc" id="txt-lng-destino" class="input-form" placeholder="Longitud">
			            </div>
		        	</div>
		    	</div>
		      	<div id="container-buttons-user" class="contenido-botones-foter">
		            <button id="como-llegar"  class="waves-effect waves-green btn-ok">¿Cómo llegar?</button>
		        </div>
	       	</div>
	    	<div id="map" class="row contenido">
	       	</div>
	    </main> 
	 
	    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAJXxNUdQD3fPlr4_8aui8CSVZvVaIbyVk"> </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
        <script src="https://use.fontawesome.com/72fa6900c1.js"></script>
        <script src="resources/js/logicaMap.js"></script>
        <script src="resources/js/index.js"></script>
        <script src="resources/js/menu.js"></script>
	</body>	      	
</html>