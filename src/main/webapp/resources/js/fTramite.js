$(function(){
	menus();
	accion();
	
});

function menus(){
	$('.sub-menu').on('click', function(event){
		event.preventDefault();
		
		if($(this).hasClass('activado')){
			$(this).removeClass('activado');
			$(this).children('ul').slideUp();;
		}else{
			$('#slide-out li ul').slideUp();
			$('#slide-out li').removeClass('activado');
			$(this).addClass('activado');
			$(this).children('ul').slideDown();
		}
		
	});
	
	$('ul').on('click', function(event){
		event.stopPropagation();
	});
	
	$('.button-collapse').sideNav({
	    menuWidth: 220,
	    edge: 'left',
	    draggable: true
	  }
	);

	$(document).ready(function(){
	  $('.modal').modal();
	});	
}

function accion(){
	$('#aprobar').on('click', function(e){
		var idReserva = $(this).parents("tr").data("id");
		tr = $(this).parents("tr");
		var solicitud = $.ajax({
			type 		: 'GET',
			contentType : 'application/json',
			url			: 'tramite-D/'+idReserva
		});
		
		solicitud.done(function(){
			tr.remove();
			vcantidad = $('#cantidadElementos');
			valor	  = parseInt(vcantidad.text());
			valor-=1;
			vcantidad.text(valor);
		});
	});
	
	$('#rechazar').on('click', function(e){
		console.log("rechazar");
		var idReserva = $(this).parents("tr").data("id");
		tr = $(this).parents("tr").remove();
		var solicitud = $.ajax({
			type 		: 'GET',
			contentType : 'application/json',
			url			: 'tramite-R/'+idReserva
		});
		
		solicitud.done(function(){
			tr.remove();
			vcantidad = $('#cantidadElementos');
			valor	  = parseInt(vcantidad.text());
			valor-=1;
			vcantidad.text(valor);
		});
	});
}




