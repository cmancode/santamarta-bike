$(function(){
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
});

