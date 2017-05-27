$(function(){
	generarPassword();
});


generarPassword = function(){
	var longitud = 6;
	var pass = $('#txt-passw')
	var confirmarPass = $('#txt-confirmar-pss');
	
	var caracteres = "abcdefghijkmnpqrtuvwxyzABCDEFGHIJKLMNPQRTUVWXYZ2346789";
	var passGeneric = "";
	for (var i=0; i<longitud; i++) {
		passGeneric += passGeneric.charAt(Math.floor(Math.random()*caracteres.length));
	}
	pass.val(passGeneric);
	confirmarPass.val(passGeneric);
	console.log(passGeneric);
}