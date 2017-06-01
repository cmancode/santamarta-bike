$(function(){
	guardarBici();
	seleccionar();
	limpiar();
	actualizarDatos();
});

var tr;

limpiar = function(){
	$('#btn-nueva-bici').on('click', function(event){
		event.preventDefault();
		
		$('#cambiar-btns').html("<button class='modal-action modal-close waves-effect waves-green btn-cancelar'>Cancelar</button>"+
		"<button id='guardar-bici' class='modal-action modal-close waves-effect waves-green btn-ok'><i class='fa fa-floppy-o' aria-hidden='true'></i> Guardar Registro</button>");
		
		$('#txt-placa').val("");
		$('#txt-color').val("");
		$('#txt-tipobici').val(-1);
		$('#txt-sitio').val(-1);
		$('#txt-estado').val(-1);
		
	});
}

guardarBici = function(){
	$('#cambiar-btns').on('click', '#guardar-bici', function(e){
		e.preventDefault();
		var txtPlaca = $('#txt-placa').val();
		var txtColor = $('#txt-color').val();
		var txtEstado = $('#txt-estado').val();
		
		var txtIdTipoBici = $('#txt-tipobici').val();
		var txtNombreTipo = $('#txt-tipobici option:selected').text();
		
		var txtIdSitio = $('#txt-sitio').val();
		var txtNombre = $('#txt-sitio option:selected').text();
		
		var jsonTipoBici = {
				idTipoBici: txtIdTipoBici,
				tipo: txtNombreTipo
		}
		
		var jsonSitio = {
				idSitio: txtIdSitio,
				nombre : txtNombre
		}
		
		var jsonBicicleta = {
				placa: txtPlaca,
				color: txtColor,
				estado: txtEstado,
				idTipoBici: jsonTipoBici,
				idSitio: 	jsonSitio			
		}

		var solicitud = $.ajax({
			type: "POST",
			contentType : "application/json",
			url: "new-bici",
			data : JSON.stringify(jsonBicicleta), 
			dataType : 'json'
		});
		
		solicitud.done(function(datosRespuesta){
			$('#table-biclicleta').append(
				"<tr>"+
					"<td>"+datosRespuesta.placa+"</td>"+
					"<td>"+datosRespuesta.idTipoBici.tipo+"</td>"+
					"<td>"+datosRespuesta.color+"</td>"+
					"<td data-id='"+datosRespuesta.idSitio.idSitio+"'>"+datosRespuesta.idSitio.nombre+"</td>"+
					"<td>"+datosRespuesta.estado+"</td>"+
					"<td><input type='button' name='actualizar' class='btn-actualizar btn-accion btn-editar' data-id='"+datosRespuesta.idTipoBici.idTipoBici+"' data-target='modal-bicicleta' value='Editar'></td>"+
				"<tr>");
		});
		
		solicitud.fail(function(jqXHR, textStatus){
			console.clear(); //Limpiar consola
			console.log("Ya éxiste una bicicleta con la información que sea ingresar");
		});
	});
}


seleccionar = function(){
	$('#table-biclicleta').on('click', '.btn-editar', function(event){
		event.preventDefault();
		$('#cambiar-btns').html("<button class='modal-action modal-close waves-effect waves-green btn-cancelar'>Cancelar</button>"+
		"<button class='modal-action modal-close waves-effect waves-green btn-ok editar-bici'>Actualizar Registro</button>");
		tr = $(this).closest('tr');

		var tdPlaca = tr.children('td:nth-child(1)').text();
		
		var solicitud = $.ajax({
			type : "GET",
			contentType : "application/json",
			url : "buscar-bici/"+tdPlaca
		});
		solicitud.done(function(datosRecibidos){
			$('#txt-placa').val(datosRecibidos.placa);
			$('#txt-color').val(datosRecibidos.color);
			$('#txt-tipobici').val(datosRecibidos.idTipoBici.idTipoBici);
			$('#txt-sitio').val(datosRecibidos.idSitio.idSitio);
			$('#txt-estado').val(datosRecibidos.estado);
		});
		solicitud.fail(function(jqXHR, textStatus){
			alert(jqXHR.status);
		});
	});
}

actualizarDatos = function(){
	$('#cambiar-btns').on('click','.editar-bici', function(e){
		e.preventDefault();
		
		var trSeleccionado = tr;
		
		var paramBusqueda = trSeleccionado.children('td:nth-child(1)').text();
		
		/*var tdPlaca = trSeleccionado.children('td:nth-child(1)');
		$('#txt-placa').val(tdPlaca.text("hola"));
		$('#txt-color').val("hola");
		$('#txt-tipobici').val(-1);
		$('#txt-sitio').val(-1);
		$('#txt-estado').val(-1);
		*/
		
		var tdPlaca = trSeleccionado.children('td:nth-child(1)');
		var tdTipo = trSeleccionado.children('td:nth-child(2)');
		var tdColor = trSeleccionado.children('td:nth-child(3)');
		var tdSitio = trSeleccionado.children('td:nth-child(4)');
		var tdEstado = trSeleccionado.children('td:nth-child(5)');
		
		var txtPlaca = $('#txt-placa').val();
		var txtColor = $('#txt-color').val();
		var txtEstado = $('#txt-estado').val();
		
		var txtIdTipoBici = $('#txt-tipobici').val();
		var txtNombreTipo = $('#txt-tipobici option:selected').text();
		
		var txtIdSitio = $('#txt-sitio').val();
		var txtNombre = $('#txt-sitio option:selected').text();
		
		var jsonTipoBici = {
				idTipoBici: txtIdTipoBici,
				tipo: txtNombreTipo
		}
		
		var jsonSitio = {
				idSitio: txtIdSitio,
				nombre : txtNombre
		}
		console.log(jsonSitio.idSitio+" "+jsonSitio.nombre);
		var jsonBicicleta = {
				placa: txtPlaca,
				color: txtColor,
				estado: txtEstado,
				idTipoBici: jsonTipoBici,
				idSitio: 	jsonSitio			
		}
		
		var solicitud = $.ajax({
			type: "PUT",
			contentType: "application/json",
			url: "bicicleta/"+paramBusqueda,
			data : JSON.stringify(jsonBicicleta), 
			dataType : 'json'
		});
		solicitud.done(function(datosRecibidos){
			console.log(datosRecibidos);
			tdPlaca.text(datosRecibidos.placa);
			tdTipo.text(datosRecibidos.idTipoBici.tipo);
			tdColor.text(datosRecibidos.color);
			tdSitio.text(datosRecibidos.idSitio.nombre);
			tdEstado.text(datosRecibidos.estado);
		});
		solicitud.fail(function(jqXHR, textStatus){
			alert("Error: "+jqXHR.status+" "+textStatus);
		});
	});
}

/*
guardarBici = function(){
	$('#guardar-bici').on('click', function(e){
		e.preventDefault();
		var txtPlaca = $('#txt-placa').val();
		var txtColor = $('#txt-color').val();
		var txtEstado = $('#txt-estado').val();
		
		var txtIdTipoBici = $('#txt-tipobici').val();
		var txtNombreTipo = $('#txt-tipobici option:selected').text();
		
		var txtIdSitio = $('#txt-sitio').val();
		var txtNombre = $('#txt-sitio option:selected').text();
		
		var jsonTipoBici = {
				idTipoBici: txtIdTipoBici,
				tipo: txtNombreTipo
		}
		
		var jsonSitio = {
				idSitio: txtIdSitio,
				nombre : txtNombre
		}
		
		var jsonBicicleta = {
				placa: txtPlaca,
				color: txtColor,
				estado: txtEstado,
				idTipoBici: jsonTipoBici,
				idSitio: 	jsonSitio			
		}

		var solicitud = $.ajax({
			type: "POST",
			contentType : "application/json",
			url: "new-bici",
			data : JSON.stringify(jsonBicicleta), 
			dataType : 'json'
		});
		
		solicitud.done(function(datosRespuesta){
			$('#table-biclicleta').append(
				"<tr>"+
					"<td>"+datosRespuesta.placa+"</td>"+
					"<td>"+datosRespuesta.idTipoBici.tipo+"</td>"+
					"<td>"+datosRespuesta.color+"</td>"+
					"<td data-id='"+datosRespuesta.idSitio.idSitio+"'>"+datosRespuesta.idSitio.nombre+"</td>"+
					"<td>"+datosRespuesta.estado+"</td>"+
					"<td><input type='button' name='actualizar' class='btn-actualizar btn-accion btn-editar' data-id='"+datosRespuesta.idTipoBici.idTipoBici+"' data-target='modal-bicicleta' value='Editar'></td>"+
				"<tr>");
		});
		
		solicitud.fail(function(jqXHR, textStatus){
			console.clear(); //Limpiar consola
			console.log("Ya éxiste una bicicleta con la información que sea ingresar");
		});
	});
}
*/


