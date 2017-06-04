$(function(){
	initMap();
});

initMap = function(){
	var map;
	var marker;
	var	lat2 = 11.2143886;
	var	lng2 = -74.1883065;
	var controlLatLng = 0;
	
	var start = new google.maps.LatLng( lat2, lng2 );
	map = new google.maps.Map(document.getElementById('map'), {
	  	center: start,
	  	zoom: 14
	});
	
	var txtLatOrige = $('#txt-lat-origen');
	var txtLngOrigen = $('#txt-lng-origen');
	var txtLatDestino = $('#txt-lat-destino');
	var txtLngDestino = $('#txt-lng-destino');
	
	var solicitud = $.ajax({
		type: "GET",
		contentType : "application/json",
		url: "list-sitios"
	});
	solicitud.done(function(datosRecibidos) {		
		jQuery.each(datosRecibidos, function(i, datos){
			var posicion = new google.maps.LatLng( datos.lat, datos.lng );
			 marker = new google.maps.Marker({
			     position: posicion,
			     map: map,
			     animation: google.maps.Animation.DROP,
			     title: datos.nombre
			  });
			 marker.addListener('click', function() {
				 if(controlLatLng == 0){
					 txtLatOrige.val(this.getPosition().lat());
					 txtLngOrigen.val(this.getPosition().lng()); 
					 controlLatLng++;
				 }else if(controlLatLng == 1){
					 txtLatDestino.val(this.getPosition().lat());
					 txtLngDestino.val(this.getPosition().lng());
					 controlLatLng = 0;
				 }
				});
		});
	});
	solicitud.fail(function(jqXHR, textStatus) {
		alert("Error "+ jqXHR.status);
	});

	trazarRuta(map); // se envía el mapa para poder trabajarlo en la función
}

trazarRuta = function(map) {
	$('#como-llegar').on('click', function(events) {
		events.preventDefault();
		
		var txtLatOrige = $('#txt-lat-origen');
		var txtLngOrigen = $('#txt-lng-origen');
		var txtLatDestino = $('#txt-lat-destino');
		var txtLngDestino = $('#txt-lng-destino');
		
		var posicionOrigen = new google.maps.LatLng( txtLatOrige.val(), txtLngOrigen.val() );
		var posicionDestino = new google.maps.LatLng( txtLatDestino.val(), txtLngDestino.val() );
		
		var objConfigDr = {
				map: map
			}
		var objConfigDs = {
				origin: posicionOrigen,
				destination: posicionDestino,
				travelMode: google.maps.TravelMode.DRIVING
			}
		var directionsService = new google.maps.DirectionsService();
		var directionsDisplay = new google.maps.DirectionsRenderer( objConfigDr );
		
		fnRutear = function ( resultados, status ){
			if ( status == 'OK' ) {
				directionsDisplay.setDirections( resultados );
			}else{
				elert("Error "+status);
			}
		}

		directionsService.route( objConfigDs, fnRutear );		
	});
}
