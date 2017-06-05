$(function() {
	cargarBicisPorSitios();
	verificarUsuario();
	guardarReservar();
});

guardarReservar = function() {
	$('#guardar-reserva').on('click', function(events) {
		events.preventDefault();
		var txtBicicleta = $('#txt-bici-sitios').val();
		var txtUsuario = $('#txt-num-doc-reserva').val();
		var estadoReserva = "PENDIENTE";
		
		var jsonBicicleta = {
				placa: txtBicicleta
		}
		var jsonUsuario = {
				idCedula: txtUsuario
		}
		var jsonReserva = {
				estado: estadoReserva,
				bicicleta: jsonBicicleta,
				usuario: jsonUsuario
		}
		console.log(jsonReserva);
		
		var solicitud = $.ajax({
				type: "POST",
				contentType : "application/json",
				url: "radicar-reserva",
				data : JSON.stringify(jsonReserva), 
				dataType : 'json'
		});
			solicitud.done(function(resultadoServer) {
				alert("Señor(a) ha generado una solicitud de prestamo de bicicleta con radicado numero "+resultadoServer.id+". Conserve el numero de radicado para hacer el reclamo de la bicicleta en el centro solicitado.");
				$('#guardar-reserva').attr('disabled','disabled');
			});
			solicitud.fail(function(jqXHR, textStatus) {
				alert(jqXHR.status);
			});
	});
}

cargarBicisPorSitios = function() {
	$('#txt-tipobici-reserva').change(function() {
		var idTipo = $('#txt-tipobici-reserva').val();
		var biciSitios = $('#txt-bici-sitios');
		var nameBiciSitio = $('#txt-bici-sitios option:selected').text("hola");;
		var solicitud = $.ajax({
					type: "GET",
					contentType: 'application/json',
					url: 'bicicletas-sitios/'+idTipo
		});
		solicitud.done(function(datosRecibidos) {
			biciSitios.html("");
			console.log(datosRecibidos);
				for (var j = 0; j < 2; j++) {
					biciSitios.append("<option value="+datosRecibidos[j][0]+">"+datosRecibidos[j][1]+" - "+datosRecibidos[j][2]+"</option>");			
				}
		});
		solicitud.fail(function(codesEstados, status) {
			alert("error "+ docesEstados.status);
		});
	});
}
verificarUsuario = function() {
	$('#verificar-usuario').on('click',function(events) {
		var numDocumento = $('#txt-num-doc-reserva').val();
		events.preventDefault();
		var solicitud = $.ajax({
					type: "GET",
					contentType: "application/json",
					url: "verificar-user/"+numDocumento
		});
			solicitud.done(function(datosRecibidos) {
				$('#txt-num-doc-reserva').attr('disabled','disabled');
			});
			solicitud.fail(function(estadosError, status) {
				alert("Usuario incorrecto, por favor digita un número de documento correcto.");
			});
	});
}