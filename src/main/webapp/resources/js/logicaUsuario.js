$(function(){
	reiniciar();
	guardarUsuario();
	buscarPorId();
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
				var roles;
				jQuery.each(datosRecibidos.rol, function(i, rol){
					roles = rol.rol;
				});
				console.log(roles);
				$('#table-usuarios').append(
						"<tr>"+
							 "<td>"+datosRecibidos.tipoDoc+"</td>"+
							 "<td>"+datosRecibidos.cedula+"</td>"+
							 "<td>"+datosRecibidos.nombres+"</td>"+
							 "<td>"+datosRecibidos.pApellido+"</td>"+
							 "<td>"+datosRecibidos.sApellido+"</td>"-
							 "<td>"+datosRecibidos.email+"</td>"+
							 "<td>"+roles+"</td>"+
							 "<td><input type='button' name='actualizar' class='btn-actualizar btn-accion' value='Actualizar'></td>"+
						"</tr>" );
			});
			solicitud.fail(function(jqXHR, textStatus) {
				alert(jqXHR.status);
			});
	});
}

buscarPorId = function(){
	$('.boton-buscar').on('click', function(events){
		events.preventDefault();
		
		var txtId = $('#txt-id').val();
		var lblRoles = $('#lbl-roles');
		var lblTipoDoc = $('#lbl-tipo-doc');
		var lblNumDoc = $('#lbl-identificacion');
		var lblNombres = $('#lbl-nombres');
		var lblPapellido = $('#lbl-papellido');
		var lblSapellido = $('#lbl-sapellido');
		var lblCorreo = $('#lbl-correo');
		var lblCiudad = $('#lbl-ciudad');
		var lblDireccion = $('#lbl-direccion');
		var lblTelefono = $('#lbl-telefono');
		var lblEstado = $('#lbl-estado');
		
		console.log(txtId);
		var solicitud = $.ajax({
			type: "GET",
			contentType: "application/json",
			url: "usuario/"+txtId,
		});
		solicitud.done(function(datosRecibidos){
			jQuery.each(datosRecibidos.rol, function(i, rol){
				lblRoles.text(rol.rol+",");
			});
			lblTipoDoc.text(datosRecibidos.tipoDoc);
			lblNumDoc.text(datosRecibidos.cedula);
			lblNombres.text(datosRecibidos.nombres);
			lblPapellido.text(datosRecibidos.pApellido);
			lblSapellido.text(datosRecibidos.sApellido);
			lblCorreo.text(datosRecibidos.email);
			lblCiudad.text(datosRecibidos.ciudadResidencia);
			lblDireccion.text(datosRecibidos.dirResidencia);
			lblTelefono.text(datosRecibidos.telf);
			lblEstado.text(datosRecibidos.estado);
		});
		solicitud.fail(function(jqXHR, textStatus){
			alert("error "+ jqXHR.status);
		});
	});
}