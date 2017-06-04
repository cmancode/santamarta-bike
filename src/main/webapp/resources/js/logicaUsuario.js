$(function(){
	reiniciar();
	guardarUsuario();
	buscarPorId();
	seleccionarUsuario();
	actualizar();
	buscarLikeDocument();
});
var selectTr; // variable para poder saber cuál es el tr seleccionado
reiniciar = function(){
	$('#call-modal').on('click', function(events){
		events.preventDefault();
		$('.container-pass').css("display","flex");
		var inputAll = $('input[type=text]');
		var inputAllmail = $('input[type=email]');
		var selectAll = $('select');
		inputAll.val("");
		inputAllmail.val("");
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
		
		var txtNumDocum = $('#txt-num-doc').val();
		var txtNombres = $('#txt-nombres').val();
		var txtPapellido = $('#txt-papellido').val();
		var txtSapellido = $('#txt-sapellido').val();
		var txtPass = $('#txt-passw').val();
		var txtEstadoUser = $('#txt-estado-user').val();
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
				idCedula: txtNumDocum,
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
							 "<td>"+datosRecibidos.idCedula+"</td>"+
							 "<td>"+datosRecibidos.nombres+"</td>"+
							 "<td>"+datosRecibidos.pApellido+"</td>"+
							 "<td>"+datosRecibidos.sApellido+"</td>"+
							 "<td>"+datosRecibidos.email+"</td>"+
							 "<td>"+roles+"</td>"+
							 "<td><input id='btn-editar' type='button' name='actualizar' class='btn-actualizar btn-accion' value='Edtiar'></td>"+
						"</tr>" );
			});
			solicitud.fail(function(jqXHR, textStatus) {
				alert(jqXHR.status);
			});
	});
}
buscarPorId = function(){
	$('#btn-buscar-id').on('click', function(events){
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
			lblNumDoc.text(datosRecibidos.idCedula);
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
seleccionarUsuario = function(){
	$('#table-usuarios').on('click', '#btn-editar', function(events){
		events.preventDefault();
		$('.container-pass').css("display","none");
		$('#container-buttons-user').html(
		"<button class='modal-action modal-close waves-effect waves-green btn-cancelar'>Cancelar</button>"+
		"<button id='btn-actualizar' class='modal-action modal-close waves-effect waves-green btn-ok'><i class='fa fa-floppy-o' aria-hidden='true'></i> Actualizar Registro</button>");		
		selectTr = $(this).closest('tr');
		var cedularSelected = selectTr.children('td:nth-child(2)').text();		
		var txtTipoDoc = $('#txt-tipo-doc');		
		var txtNumDocum = $('#txt-num-doc');
		var txtNombres = $('#txt-nombres');
		var txtPapellido = $('#txt-papellido');
		var txtSapellido = $('#txt-sapellido');
		var txtEstadoUser = $('#txt-estado-user');
		var txtCiudadResid = $('#txt-ciudad');
		var txtDirResidencia = $('#txt-direccion');
		var txtEmail = $('#txt-email');
		var txtConfirmarEmail = $('#txt-confir-email');
		var txtpassActualizar = $('#pass-actualizar'); // inpuy oculto para poder actualizar la contraseña
		var txtTelfContacto = $('#txt-telefono');
		var txtFunciones = $('#txt-funciones');
		var solicitud = $.ajax({
						type : "GET",
						contentType: "application/json",
						url: "usuario/"+cedularSelected,
		});
		solicitud.done(function(datosRecibidos){
			console.log(datosRecibidos);
			jQuery.each(datosRecibidos.rol, function(i, rol){
				txtFunciones.val(rol.idRol);
			});
			txtTipoDoc.val(datosRecibidos.tipoDoc);
			txtNumDocum.val(datosRecibidos.idCedula);
			txtNombres.val(datosRecibidos.nombres);
			txtPapellido.val(datosRecibidos.pApellido);
			txtSapellido.val(datosRecibidos.sApellido);
			txtEmail.val(datosRecibidos.email);
			txtConfirmarEmail.val(datosRecibidos.email);
			txtCiudadResid.val(datosRecibidos.ciudadResidencia);
			txtDirResidencia.val(datosRecibidos.dirResidencia);
			txtTelfContacto.val(datosRecibidos.telf);
			txtEstadoUser.val(datosRecibidos.estado);
			txtpassActualizar.val(datosRecibidos.password); // actualizar contraseña solo el administrador
		});
		solicitud.fail(function(jqXHR, textStatus){
			alert("error "+ jqXHR.status);
		});
		
	});
}
actualizar = function() {
	$('#container-buttons-user').on('click', '#btn-actualizar', function(events){
		events.preventDefault();
		var trActualizar = selectTr;		
		var tdTipo = trActualizar.children('td:nth-child(1)');
		var tdDocumento = trActualizar.children('td:nth-child(2)');
		var tdNombres = trActualizar.children('td:nth-child(3)');
		var tdPapellido = trActualizar.children('td:nth-child(4)');
		var tdSapellido = trActualizar.children('td:nth-child(5)');
		var tdEmail = trActualizar.children('td:nth-child(6)');
		var tdRol = trActualizar.children('td:nth-child(7)');
		var txtTipoDoc = $('#txt-tipo-doc').val();
		var txtNumDocum = $('#txt-num-doc').val();
		var txtNombres = $('#txt-nombres').val();
		var txtPapellido = $('#txt-papellido').val();
		var txtSapellido = $('#txt-sapellido').val();
		var txtEstadoUser = $('#txt-estado-user').val();
		var txtCiudadResid = $('#txt-ciudad').val();
		var txtDirResidencia = $('#txt-direccion').val();
		var txtEmail = $('#txt-email').val();
		var txtTelfContacto = $('#txt-telefono').val();
		var txtpassActualizar = $('#pass-actualizar').val();
		var txtFunciones = $('#txt-funciones').val();
		var txtDescripFunciones = $('#txt-funciones option:selected').text();	
		var jsonRoles = {
				id: txtFunciones,
				rol: txtDescripFunciones
		}
		var jsonUsuario = {
				idCedula: txtNumDocum,
				tipoDoc: txtTipoDoc,
				nombres: txtNombres,
				pApellido: txtPapellido,
				sApellido: txtSapellido,
				email: txtEmail,
				telf: txtTelfContacto,
				ciudadResidencia: txtCiudadResid,
				dirResidencia: txtDirResidencia,
				password: txtpassActualizar,
				rol: [jsonRoles],
				estado: txtEstadoUser
		}
		var solicitud = $.ajax({
			type: "PUT",
			contentType: "application/json",
			url: "usuario/"+txtNumDocum,
			data: JSON.stringify(jsonUsuario),
			dataType : 'json'
		});
		solicitud.done(function(datosRecibidos) {
			jQuery.each(datosRecibidos.rol, function(i, rol){
				tdRol.text(rol.rol);
			});
			tdTipo.text(datosRecibidos.tipoDoc);
			tdDocumento.text(datosRecibidos.idCedula);
			tdNombres.text(datosRecibidos.nombres);
			tdPapellido.text(datosRecibidos.pApellido);
			tdSapellido.text(datosRecibidos.sApellido);
			tdEmail.text(datosRecibidos.email);
		});
		solicitud.fail(function(jqXHR, textStatus){
			alert("error "+ jqXHR.status);
		});		
	});
}
buscarLikeDocument = function() {
	$('#btn-buscar').on('click', function(events) {
		events.preventDefault();
		$('#table-body-user>tr').remove();
		
		var txtBuscar = $('.input-buscar').val();
		
		var solicitud = $.ajax({
						type:'GET',
						contentType:'application/json',
						url:'usuario-like/'+txtBuscar
				});
			solicitud.done(function(datosRecibidos){
				var roles;
				for(var i = 0; i < datosRecibidos.length; i++){
					jQuery.each(datosRecibidos[i].rol, function(i, rol){
						roles = rol.rol;
					});
					$('#table-usuarios').append(
							"<tr>"+
								 "<td>"+datosRecibidos[i].tipoDoc+"</td>"+
								 "<td>"+datosRecibidos[i].idCedula+"</td>"+
								 "<td>"+datosRecibidos[i].nombres+"</td>"+
								 "<td>"+datosRecibidos[i].pApellido+"</td>"+
								 "<td>"+datosRecibidos[i].sApellido+"</td>"+
								 "<td>"+datosRecibidos[i].email+"</td>"+
								 "<td>"+roles+"</td>"+
								 "<td><input id='btn-editar' type='button' name='actualizar' class='btn-actualizar btn-accion' value='Edtiar'></td>"+
							"</tr>" );
				}
				//$('#datos-usuario').css("display", "block");
			});
			solicitud.fail(function(jqXHR, textStatus){
				alert("error "+ jqXHR.status);
			});
	});
}