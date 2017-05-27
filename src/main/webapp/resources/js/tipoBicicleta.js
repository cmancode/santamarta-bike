/*
 * variable opcion definida para las opciones del usuario en la peticion sea editar o guardar
 */
var opcion = 0;
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
	optenerTipoBicicleta();
	buscarTipoBicicleta();
});

function accion(){
	$('.btn-actualizar').on('click', function(e){
		e.preventDefault();
		console.log("sasa");
		opcion = 2;
		vTipoBicicleta = $('#tipoBici');
		vDescripcion   = $('#descripcion');
		tr =  $(this).parents('tr');
		tdTipo = tr.children('td:nth-child(1)');
		tdDescripcion = tr.children('td:nth-child(2)');
		vTipoBicicleta.val(tdTipo[0].innerText)
		vDescripcion.val(tdDescripcion[0].innerText);
	});
	
	$('#agregar').on('click', function(e){
		e.preventDefault();
		opcion = 1;	
	});	
	
	$('.btn-cancelar').on('click', function(e){
		e.preventDefault();
		borradoFormulario();
	});
	
	$('.prueba').on('click', function(e){
		alert("sasas");
	});

}

function optenerTipoBicicleta(){
	$('#ok').on('click', function(e){
		e.preventDefault();
		vTipoBicicleta = $('#tipoBici');
		vDescripcion   = $('#descripcion');
		
		var tipoBicicleta = {
			tipo: vTipoBicicleta.val() ,
			descripcion: vDescripcion.val()
		}
		
		if (opcion == 1) {
			guardarTipoBicicleta(tipoBicicleta);		
		}else if(opcion == 2){
			editarTipoBicicleta(tipoBicicleta);
		}
	});
	opcion = 0;
}

function guardarTipoBicicleta(json){
	console.log("ajax guardar");
	var solicitud = $.ajax({
		type 		: 'POST',
		contentType : 'application/json',
		url			: 'tipoBicicleta',
		data		: JSON.stringify(json),
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
	
	solicitud.fail(function(jqXHR, textStatus ) {
		  alert( "Request failed: " + textStatus + jqXHR);
		
	});
	
	borradoFormulario();
}

function editarTipoBicicleta(json, id){
	console.log("editar");
	
	var id = tr.data().id;
	var solicitud = $.ajax({
		type 		: 'PUT',
		contentType : 'application/json',
		url			: 'tipoBicicleta/'+id,
		data		: JSON.stringify(json),
		dataType	: 'json'
	});
	
	solicitud.done(function(datos){
		console.log(datos);
		
		tdTipo = tr.children('td:nth-child(1)');
		tdDescripcion = tr.children('td:nth-child(2)');
		
		tdTipo.text(datos.tipo);
		tdDescripcion.text(datos.descripcion);
	});
	
	solicitud.fail(function(jqXHR, textStatus){
		 alert( "Request failed: " + textStatus  + jqXHR);
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

function normal() {
	alert("ddsds");
}

function borradoFormulario(){
	
	vTipoBicicleta = $('#tipoBici');
	vDescripcion   = $('#descripcion');
	
	vTipoBicicleta.val(' ');
	vDescripcion.val(' ');
}

