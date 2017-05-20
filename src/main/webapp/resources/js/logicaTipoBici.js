$(function(){
	resultadoTipoBici();
	guardarTipoBicicleta();
});

resultadoTipoBici = function(){
	$('#btn-bucar-tipobici').on('click', function(event){
		event.preventDefault();
		
		var txtIdTipoBici = $('#txt-idTipoBici');
		var IDTIPO = txtIdTipoBici.val();
		var txtTipo = $('#txt-tipoBici');
		var txtDescripcion = $('#txt-descripcion');
		var lblNoEncontrado = $('#no-encontrado');		
		
		var formAndNote = $('body .mostrar-resultado-tipo');
		
		var solicitud = $.ajax({
			type : "GET",
			contentType : "application/json",
			url : "tipobici/"+IDTIPO
		});
		solicitud.done(function(datos){
			lblNoEncontrado.html("");
			formAndNote.css("display", "block");
			txtTipo.val(datos.tipo);
			txtDescripcion.val(datos.descripcion);
		});
		solicitud.fail(function(jqXHR, textStatus ) {
			  //alert( "Request failed: " + textStatus );
			  formAndNote.css("display", "none");
			  lblNoEncontrado.css("color", "#447542");
			  lblNoEncontrado.html("Error! El identificador ingresado no corresponde a un tipo de bicicleta");
		});
	});
}


guardarTipoBicicleta = function(){
	$('#guardar-tipo-bici').on('click', function(event){
		event.preventDefault();
		
		var txtTipoBici = $('#txt-tipoBici');
		var txtDescripcion = $('#txt-descripcion');
		
		var tipoBici = {
				tipo : txtTipoBici.val(),
				descripcion : txtDescripcion.val()
		}

		var solicitud = $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "tipobici",
			data : JSON.stringify(tipoBici), 
			dataType : 'json'
		});
		
		solicitud.done(function(datos){
			$('#table-tipo-bicicleta').append(
					"<tr data-id='"+datos.idTipoBici+"'>"+
					 "<td>"+datos.idTipoBici+"</td>"+ 
					 "<td>"+datos.tipo+"</td>"+ 
					 "<td>"+datos.descripcion+"</td>"+ 
					 "<td id='td-editar'><a href='#' class='btn btn-warning btn-xs'><i class='glyphicon glyphicon-edit'></i> Editar</a></th>"+
				"</td>"
				);
			console.log(datos);
		});
		
		solicitud.fail(function(jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			
		});
		
	});
	
}


