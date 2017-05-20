$(function(){
	buscarBici();
	seleccionarTipoBici();
	guardarBicicleta();
	seleccionarTipoBiciEnBusqueda();
	guardarEdicion();
});

seleccionarTipoBici = function (){
	$('#table-modal').on('click', '#btn-select', function(event){
		event.preventDefault();
		var tr = $(this).closest('tr');
		var tdIdentificador = tr.children("td:nth-child(2)");
		var tdNombreTipoBici = tr.children("td:nth-child(3)");
		var tdDescripcion = tr.children("td:nth-child(4)");
		
		var txtNombreTipoBici = $('#name-tipo-bici');
		
		var txtIdTipoBici = $('#txtIdTipoBici');
		var txtTipoBici = $('#txtTipoBici');
		var txtDescripcion = $('#txtDescripcion');
		
		var varlorTdIdentificador = tdIdentificador.html();
		txtNombreTipoBici.val(tdNombreTipoBici.html());
		txtIdTipoBici.attr("value",varlorTdIdentificador );
		
		txtIdTipoBici.attr("value", tdIdentificador.html());
		txtTipoBici.attr("value", tdNombreTipoBici.html());
		txtDescripcion.attr("value", tdDescripcion.html());
		
		$('#myModal').modal('hide');
	});
}

guardarBicicleta = function(){
	$('#guardar-bici').on('click', function(event){
		event.preventDefault();
		
		/*---Variables para tipo de bicicleta---*/
		var txtIdTipoBici = $('#txtIdTipoBici');
		var txtTipoBici = $('#txtTipoBici');
		var txtDescripcion = $('#txtDescripcion');
		
		var lblResultadoInset = $('#resultado-insert');
		var divContanerResultadoGuardar = $('#container-resultado-guardar');
		
		/*---Variables para bicicleta---*/
		var txtPlaca = $('#placa');
		var txtColor = $('#color');
		var txtEstado = $('#estado');
		
		var tipobici = {
				idTipoBici: parseInt(txtIdTipoBici.val()),
				tipo: txtTipoBici.val(),
				descripcion: txtDescripcion.val()
				
		};
		
		var bicicleta = {placa: txtPlaca.val(),
						 color: txtColor.val(),
						 estado: txtEstado.val(),
						 idTipoBici: tipobici
		};
		
		var solicitud = $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "new-bici",
			data : JSON.stringify(bicicleta), 
			dataType : 'json'
		});
		
		solicitud.done(function(datos){
			$('#table-bicicletas').append(
					"<tr data-id='"+datos.placa+"'>"+
						 "<td>"+datos.placa+"</td>"+ 
						 "<td>"+datos.idTipoBici.tipo+"</td>"+ 
						 "<td>"+datos.color+"</td>"+ 
						 "<td>"+datos.estado+"</td>"+
						 "<td id='td-editar'><a href='#' class='btn btn-warning btn-xs'><i class='glyphicon glyphicon-edit'></i> Editar</a></th>"+
					"</td>"
			);
			divContanerResultadoGuardar.css("display","flex");
			divContanerResultadoGuardar.css("justify-content","center");
			lblResultadoInset.css("color", "#447542");
			lblResultadoInset.html("Informaci&oacute;n registrada exitosamente!");
			
			txtPlaca.val('');
			txtColor.val('');
			txtEstado.val('');
		});
		
		solicitud.fail(function( jqXHR, textStatus ) {
			//alert( "Request failed: " + textStatus );
			divContanerResultadoGuardar.css("display","flex");
			divContanerResultadoGuardar.css("justify-content","center");
			lblResultadoInset.css("color", "#F02727");
			lblResultadoInset.html("Ya existe una bicicleta con la informaci&oacute;n que desea ingresar.");  
		});
	});
}

seleccionarTipoBiciEnBusqueda = function (){
	$('#table-modal-busqueda').on('click', '#btn-select', function(event){
		event.preventDefault();
		var tr = $(this).closest('tr');
		var tdIdentificador = tr.children("td:nth-child(2)");
		var tdNombreTipoBici = tr.children("td:nth-child(3)");
		var tdDescripcion = tr.children("td:nth-child(4)");
		
		
		var txtIdTipoBici = $('#txt-id-tipo');
		var txtTipoBici = $('#txt-tipo-bici');
		var txtDescripcion = $('#txt-descripcion');
		
		
		txtIdTipoBici.attr("value", tdIdentificador.html());
		txtTipoBici.val(tdNombreTipoBici.html());
		txtDescripcion.attr("value", tdDescripcion.html());
		
		$('#myModal').modal('hide');
	});
}

buscarBici = function(){
	$('#btn-bucar-bici').on('click', function(event){
		event.preventDefault();
		
		var txtPlaca = $('#txt-id-placa');
		var placaData = txtPlaca.val();
		
		var txtColor = $('#txt-color-bici');
		var txtEstado = $('#txt-estado-bici');
		var txtTipoBici = $('#txt-tipo-bici');
		
		//Los input ocultos
		var txtIdTipo = $('#txt-id-tipo');
		var txtDescripcion = $('#txt-descripcion');
		
		var solicitud = $.ajax({
					type : "GET",
					contentType : "application/json",
					url : 'buscar-bici/'+placaData
		});
		
		solicitud.done(function(respuesta){
			$('body .form-resultado').css("display", "block");
			txtColor.val(respuesta.color);
			txtEstado.val(respuesta.estado);
			txtTipoBici.val(respuesta.idTipoBici.tipo);
			txtIdTipo.attr("value", respuesta.idTipoBici.idTipoBici);
			txtDescripcion.attr("value", respuesta.idTipoBici.descripcion);
		});
		
		solicitud.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
		});
		
	});
}

guardarEdicion = function(){
	$('#guardar-cambios').on('click', function(event){
		event.preventDefault();

		var txtPlaca = $('#txt-id-placa');
		var PLACA = txtPlaca.val();
		var txtColor = $('#txt-color-bici');
		var txtEstado = $('#txt-estado-bici');
		//Los input ocultos
		var txtIdTipo = $('#txt-id-tipo');
		var txtTipoBici = $('#txt-tipo-bici');
		var txtDescripcion = $('#txt-descripcion');
		
		var jsonTipoBici = {
				idTipoBici: txtIdTipo.val(),
				tipo: txtTipoBici.val(),
				descripcion: txtDescripcion.val()
		}

		var jsonBicicleta = {
				placa: txtPlaca.val(),
				color: txtColor.val(),
				estado: txtEstado.val(),
				idTipoBici: jsonTipoBici
		}

		var solicitud = $.ajax({
			type : "PUT",
			contentType : "application/json",
			url : "bicicleta/"+PLACA,
			data : JSON.stringify(jsonBicicleta), 
			dataType : 'json'
		});
		
		solicitud.done(function(resultado){
			console.log(resultado);
		});
		
		solicitud.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
		});
		
	});
}
