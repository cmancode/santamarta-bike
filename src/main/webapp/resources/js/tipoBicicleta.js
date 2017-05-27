/*
 * variable opcion definida para las opciones del usuario en la peticion sea editar o guardar
 */
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
	buscarTipoBicicleta();
});

function accion(){
	$('#tabla-tipoBicicleta').on('click', '.btn-actualizar', function(e){
		e.preventDefault();
		tr =  $(this).parents('tr');
		cambiarEditarModal();
	});
	
	$('#agregar').on('click', function(e){
		e.preventDefault();
		cambiarGuardarModal();
	});
	
	$('#cambiar-btns-modal').on('click', '.editarTipoBicicleta', function(e){
		e.preventDefault();
		console.log("actualiza ");
		actualizarTipoBicicleta();
	});
	
	$('#cambiar-btns-modal').on('click', '.guardarTipoBicicleta', function(e){
		e.preventDefault();
		console.log("crear");
		crearTipoBicicleta();
	});
}

function cambiarEditarModal(){
	//llenar los campos del modal con los datos encontrados en la tabla 
	
	vTipoBicicleta = $('#tipoBici');
	vDescripcion   = $('#descripcion');
	tdTipo = tr.children('td:nth-child(1)');
	tdDescripcion = tr.children('td:nth-child(2)');
	vTipoBicicleta.val(tdTipo[0].innerText);
	vDescripcion.val(tdDescripcion[0].innerText);
	$('#cambiar-btns-modal').html(
			"<button class='modal-action modal-close waves-effect waves-green btn-cancelar'>Cancelar</button>"+
			"<button class='modal-action modal-close waves-effect waves-green btn-ok editarTipoBicicleta'>Actualizar Registro</button>"
	);
}

function cambiarGuardarModal(){
	$('#cambiar-btns-modal').html(
			"<button class='modal-action modal-close waves-effect waves-green btn-cancelar'>Cancelar</button>"+
			"<button class='modal-action modal-close waves-effect waves-green btn-ok guardarTipoBicicleta'>Guardar Registro</button>"
	);
}

function actualizarTipoBicicleta(){
	console.log("actualizando tipoB");
	var vTipoBicicleta = $('#tipoBici');
	var vDescripcion   = $('#descripcion');
	
	var tipoBicicleta = {
		tipo: vTipoBicicleta.val() ,
		descripcion: vDescripcion.val()
	}
	
	var id = tr.data().id;
	var solicitud = $.ajax({
		type 		: 'PUT',
		contentType : 'application/json',
		url			: 'tipoBicicleta/'+id,
		data		: JSON.stringify(tipoBicicleta),
		dataType	: 'json'
	});
	
	solicitud.done(function(datos){
		
		tdTipo = tr.children('td:nth-child(1)');
		tdDescripcion = tr.children('td:nth-child(2)');
		
		tdTipo.text(datos.tipo);
		tdDescripcion.text(datos.descripcion);
	});
	
	solicitud.fail(function(jqXHR, textStatus){
		 alert( "Request failed: " + textStatus  + jqXHR);
	});
	
}

	

function crearTipoBicicleta(){
	console.log("creando tipoB");
	vTipoBicicleta = $('#tipoBici');
	vDescripcion   = $('#descripcion');
	
	var tipoBicicleta = {
		tipo: vTipoBicicleta.val() ,
		descripcion: vDescripcion.val()
	}
	
	var solicitud = $.ajax({
		type 		: 'POST',
		contentType : 'application/json',
		url			: 'tipoBicicleta',
		data		: JSON.stringify(tipoBicicleta),
		dataType	: 'json'
	});
	
	solicitud.done(function(datos){
		$('#cuerpoTabla').append(
			'<tr data-id='  + datos.idTipoBici + '>'+ 
				'<td>' + datos.tipo + '</td>' +
				'<td>' + datos.descripcion + '</td>' +
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

function buscarTipoBicicleta(){
	$('#buscarTipoBicicleta').on('click', function(e){
		e.preventDefault();
		var text = $('#textTipoBicicleta').val();
		
		var solicitud = $.ajax({
			type 		: 'GET',
			contentType : 'application/json',
			url			: 'tipoBicicleta/'+text
		});
		
		solicitud.done(function(datos){
			$("#cuerpoTabla>tr").remove();
			for (var i = 0; i < datos.length; i++) {
				console.log(datos[i].idTipoBici);
				$('#cuerpoTabla').append(
						"<tr data-id=' " + datos[i].idTipoBici + "'>"+ 
							"<td>" + datos[i].tipo + "</td>" +
							"<td>" + datos[i].descripcion + "</td>" +
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
	
	vTipoBicicleta = $('#tipoBici');
	vDescripcion   = $('#descripcion');
	
	vTipoBicicleta.val(' ');
	vDescripcion.val(' ');
}
	
	
	
	
