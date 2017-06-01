$(function(){
	reiniciar();
	guardarUsuario();
});


reiniciar = function(){
	$('#call-modal').on('click', function(events){
		events.preventDefault();
		var inputAll = $('input[type=text]');
		var selectAll = $('select');
		inputAll.val("");
		selectAll.val(-1);
$('#container-buttons-user').html(
		"<button class='modal-action modal-close waves-effect waves-green btn-cancelar'>Cancelar</button>"+
		"<button id='guardar-user' class='modal-action modal-close waves-effect waves-green btn-ok'><i class='fa fa-floppy-o' aria-hidden='true'></i> Guardar Registro</button>");
	});
}

guardarUsuario = function(){
	$('#container-buttons-user').on('click', '#guardar-user', function(events){
		events.preventDefault();
		
		var txtTipoDoc = $('#txt-tipo-doc').val();
		//var txtDescrpTipoDoc = $('#txt-tipo-doc option:selected').text();
		
		var txtNumDocum = $('#txt-num-doc').val();
		var txtNombres = $('#txt-nombres').val();
		var txtPapellido = $('#txt-papellido').val();
		var txtSapellido = $('#txt-sapellido').val();
		var txtPass = $('#txt-passw').val();
		
		var txtEstadoUser = $('#txt-estado-user').val();
		//var txtDescripEstadoUser = $('#txt-estado-user option:selected').text();
		
		var txtCiudadResid = $('#txt-ciudad').val();
		var txtDirResidencia = $('#txt-direccion').val();
		var txtEmail = $('#txt-email').val();
		var txtConfirmarEmail = $('#confirmar-email').val();
		var txtTelfContacto = $('#txt-telefono').val();
		var txtConfContrasenia = $('#txt-confirmar-pss').val();
		
		var txtFunciones = $('#txt-funciones').val();
		var txtDescripFunciones = $('#txt-funciones option:selected').text();
		
		var jsonRoles = {
				id: txtFunciones,
				rol: txtDescripFunciones
		}
		var jsonUsuario = {
				cedula: txtNumDocum,
				tipoDoc: txtTipoDoc,
				nombres: txtNombres,
				pApellido: txtPapellido,
				sApellido: txtSapellido,
				email: txtEmail,
				telf: txtTelfContacto,
				ciudadResidencia: txtCiudadResid,
				dirResidencia: txtDirResidencia,
				password: txtPass,
				rol: [jsonRoles],
				estado: txtEstadoUser
		}
		console.log(jsonUsuario);
		var solicitud = $.ajax({
						type: "POST",
						contentType: "application/json",
						url: "new-user",
						data: JSON.stringify(jsonUsuario),
						dataType : 'json'
					});
			solicitud.done(function(datosRecibidos){
				console.log(datosRecibidos);
			});
			solicitud.fail(function(jqXHR, textStatus) {
				alert(jqXHR.status);
			});
	});
}