var tr;

$(function(){
	$('.button-collapse').sideNav({
	    menuWidth: 220,
	    edge: 'left',
	    draggable: true
	  }
	);

	$(document).ready(function(){
	  $('.modal').modal();
	});
	
	accion();
	buscarSitio();
	urlAvatar();
});

function accion(){
	$('#tabla-sitio').on('click', '.btn-actualizar', function(e){
		e.preventDefault();
		tr =  $(this).parents('tr');
		borradoFormulario();
		cambiarEditarModal();
	});
	
	$('#agregar').on('click', function(e){
		e.preventDefault();
		borradoFormulario();
		cambiarGuardarModal();
	});
	
	$('#cambiar-btns-modal').on('click', '.editarSitio', function(e){
		e.preventDefault();
		console.log("actualiza ");
		actualizarSitio();
	});
	
	$('#cambiar-btns-modal').on('click', '.guardarSitio', function(e){
		e.preventDefault();
		console.log("crear");
		crearSitio();
	});
}

function cambiarEditarModal(){
	//llenar los campos del modal con los datos encontrados en la tabla 
	
	vSitio     = $('#sitio');
	vLatitud   = $('#latitud');
	vLongitud  = $('#longitud');
	vDireccion = $('#direccion');
	
	tdSitio     = tr.children('td:nth-child(1)');
	tdLatitud   = tr.children('td:nth-child(3)');
	tdLongitud  = tr.children('td:nth-child(4)');
	tdDireccion = tr.children('td:nth-child(5)');
	
	
	vSitio.val(tdSitio[0].innerText);
	vLatitud.val(tdLatitud[0].innerText);
	vLongitud.val(tdLongitud[0].innerText);
	vDireccion.val(tdDireccion[0].innerText);
	
	$('#cambiar-btns-modal').html(
			"<button class='modal-action modal-close waves-effect waves-green btn-cancelar'>Cancelar</button>"+
			"<button class='modal-action modal-close waves-effect waves-green btn-ok editarSitio'>Actualizar Registro</button>"
	);
}

function cambiarGuardarModal(){
	$('#cambiar-btns-modal').html(
			"<button class='modal-action modal-close waves-effect waves-green btn-cancelar'>Cancelar</button>"+
			"<button class='modal-action modal-close waves-effect waves-green btn-ok guardarSitio'>Guardar Registro</button>"
	);
}

function actualizarSitio(){
	console.log("actualizando tipoB");
	vSitio     = $('#sitio');
	vFoto	   = $('#file_1');
	vlatitud   = $('#latitud');
	vlongitud  = $('#longitud');
	vDireccion = $('#direccion');
	
	var sitio = {
		nombre  : vSitio.val(),
		foto	: vFoto.val(),
		lat		: vlatitud.val(),
		lng		: vlongitud.val(),
		direccion : vDireccion.val()
	}
	
	var id = tr.data().id;
	var solicitud = $.ajax({
		type 		: 'PUT',
		contentType : 'application/json',
		url			: 'sitios/'+id,
		data		: JSON.stringify(sitio),
		dataType	: 'json'
	});
	
	solicitud.done(function(datos){
		
		tdSitio = tr.children('td:nth-child(1)');
		tdAvatar = tr.children('td:nth-child(2)');;
		tdLatitud = tr.children('td:nth-child(3)');; 
		tdLongitud = tr.children('td:nth-child(4)');;
		tdDireccion = tr.children('td:nth-child(5)');;
		
		tdSitio.text(datos.nombre);
		tdAvatar.text(datos.foto);
		tdLatitud.text(datos.lat);
		tdLongitud.text(datos.lng);
		tdDireccion.text(datos.direccion);
		
	});
	
	solicitud.fail(function(jqXHR, textStatus){
		 alert( "Request failed: " + textStatus  + jqXHR);
	});
	
}

	

function crearSitio(){
	vSitio     = $('#sitio');
	vFoto	   = $('#file_1');
	vLatitud   = $('#latitud');
	vLongitud  = $('#longitud');
	vDireccion = $('#direccion');
	
	
	var sitio = {
		nombre  : vSitio.val() ,
		foto    : vFoto.val(),
		lat		: vLatitud.val(),
		lng		: vLongitud.val(),
		direccion : vDireccion.val()
	}
	console.log(sitio);
	var solicitud = $.ajax({
		type 		: 'POST',
		contentType : 'application/json',
		url			: 'sitios',
		data		: JSON.stringify(sitio),
		dataType	: 'json'
	});
	
	solicitud.done(function(datos){
		$('#cuerpoTabla').append(
			'<tr data-id='  + datos.idSitio + '>'+ 
				'<td>' + datos.nombre + '</td>' +
				'<td>' + datos.foto + '</td>' +
				'<td>' + datos.lat + '</td>' +
				'<td>' + datos.lng + '</td>' +
				'<td>' + datos.direccion + '</td>' +
				'<td> <input type="button" name="editar" class="btn-actualizar btn-accion" value="Editar" data-target="modal1" ></td>' +
                '<td> <input type="button" name="eliminar" class="btn-eliminar btn-accion" value="Eliminar"></td>' +
			'</tr>'
		);
		
		vcantidad = $('#cantidadElementos');
		valor	  = parseInt(vcantidad.text());
		valor+=1;
		vcantidad.text(valor);
	});

	
}

function buscarSitio(){
	$('#buscarSitio').on('click', function(e){
		e.preventDefault();
		var text = $('#textSitio').val();
		
		var solicitud = $.ajax({
			type 		: 'GET',
			contentType : 'application/json',
			url			: 'sitios/'+text
		});
		
		solicitud.done(function(datos){
			$("#cuerpoTabla>tr").remove();
			for (var i = 0; i < datos.length; i++) {
				$('#cuerpoTabla').append(
						"<tr data-id=' " + datos[i].idSitio + "'>"+ 
							"<td>" + datos[i].nombre + "</td>" +
							"<td>" + datos[i].foto + "</td>" +
							"<td>" + datos[i].lat + "</td>" +
							"<td>" + datos[i].lng + "</td>" +
							"<td>" + datos[i].direccion + "</td>" +
							"<td> <input type='button' name='actualizar' class='btn-actualizar btn-accion' data-target='modal1' value='Editar'></td>" +
			                "<td> <input type='button' name='eliminar' class='btn-eliminar btn-accion'  value='Eliminar'></td>" +
						"</tr>"
					);  
			}
			
			vcantidad = $('#cantidadElementos');
			vcantidad.text(datos.length);
		});

	});
}


function borradoFormulario(){
	
	console.log("creando tipoB");
	vSitio     = $('#sitio');
	vLatitud   = $('#latitud');
	vLongitud  = $('#longitud');
	vDireccion = $('#direccion');
	
	vSitio.val(' ');
	vLatitud.val(' ');
	vLongitud.val(' ');
	vDireccion.val(' ');
	$('#inputval').text(' ');
}

function urlAvatar(){
	 $('#file_1').on('change',function(){
		 $('#inputval').text( $(this).val());
	 });
	 
}
	
	