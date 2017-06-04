$(function(){
	guardarMulta();
	limpiar();
	seleccionar();
	cambiarEstado();
});

cambiarEstado = function(){
	
	
	
}


seleccionar = function(){
	limpiar();
	$('#tabla-multas').on('click', '.btn-actualizar', function(event){
		event.preventDefault();
		
		var tdId = $(this).data("id");
		
		var solicitud = $.ajax({
			type : "GET",
			contentType : "application/json",
			url : "buscar-multas/"+tdId
		});
		
		solicitud.done(function(respuesta){
			 console.log(respuesta.id);
			 $('#txt-id').val(respuesta.id);
			 $('#txt-descripcion').val(respuesta.descripcion);
			 $('#text-costo').val(respuesta.costo);
			 $('#txt-estado').val(respuesta.estado);
		});
		
		
	});
}

limpiar = function(){
	$('#btn-nueva-multa').on('click', function(event){
		event.preventDefault();
		
		$('#contenido-botones-foter').html("<<button class='modal-action modal-close waves-effect waves-green btn-cancelar'>Cancelar</button>"
           +"<button id='guardar-multa' class='modal-action modal-close waves-effect waves-green btn-ok'>Guardar</button>");
		$('#txt-id').val("");
		$('#txt-descripcion').val("");
		$('#text-costo').val("");
		$('#txt-estado').val("-1");
		
	});
}

guardarMulta = function(){
	
	$('.contenido-botones-foter').on('click', '#guardar-multa', function(e){
		e.preventDefault();
		var idMultas =  $('#txt-id').val() ;
		var descripcion = $('#txt-descripcion').val();
		var costo =  $('#text-costo').val();
		var estado = $('#txt-estado').val();
		
		var jsonMulta = {
				id :  idMultas,
				descripcion: descripcion,
				costo: parseInt(costo),
				estado: estado
						
		}
		if(idMultas == null || idMultas == ""){ // CREAR
			var solicitud = $.ajax({
				type: "POST",
				contentType : "application/json",
				url: "multas",
				data : JSON.stringify(jsonMulta), 
				dataType : 'json'
			});
			
			solicitud.done(function(datosRespuesta){
				$('#tabla-multas').append(
						"<tr id='idmulta"+datosRespuesta.id+"'>"+
							"<input type='hidden' id='idmulta' value="+datosRespuesta.id+" />"+
							"<td>"+datosRespuesta.descripcion+"</td>"+
							"<td>"+datosRespuesta.costo+"</td>"+
							"<td>"+datosRespuesta.estado+"</td>"+
							"<td><input data-id='"+datosRespuesta.id+"' type='button' name='actualizar' class='btn-actualizar btn-accion btn-editar' data-target='modal-multa' value='Editar'></td>"+
	         
						"<tr>");
			});
		}
		else{
			var solicitud = $.ajax({
				type: "PUT",
				contentType : "application/json",
				url: "multas-editar/"+idMultas,
				data : JSON.stringify(jsonMulta), 
				dataType : 'json'
			});
			
			solicitud.done(function(datosRespuesta){
				var tr = $('#idmulta'+idMultas);
				
				tr.html("<input type='hidden' id='idmulta' value="+datosRespuesta.id+" />"+
							"<td>"+datosRespuesta.descripcion+"</td>"+
							"<td>"+datosRespuesta.costo+"</td>"+
							"<td>"+datosRespuesta.estado+"</td>"+
							"<td><input type='button' name='actualizar' class='btn-actualizar btn-accion btn-editar' data-target='modal-multa' value='Editar'></td>");
			});
		}
		
	});
	
	
}