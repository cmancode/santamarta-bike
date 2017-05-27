<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	 <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	 <link rel="stylesheet" href="resources/css/style.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	 <script src="https://use.fontawesome.com/72fa6900c1.js"></script>
     <script src="resources/js/menu.js"></script>
</head>

<header>
	<nav class="top-nav white">
    	<div class="row">
        	<div class="col s12 right-align">
            	<a href="#" class="black-text">Usuario</a>
            </div>
        </div>
        <div class="">
        	<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons cyan-text">menu</i></a>
        </div>
    </nav>
    <ul id="slide-out" class="side-nav fixed indigo darken-2">
    	<li class="center-align">
        	<a  href="/project/" class=""><h5 id="logo">SM - Bike <i class="fa fa-bicycle" aria-hidden="true"></i></h5></a>
        </li>
        <li class="sub-menu"><a href="#" class="">Tipos de Bicicletas</a>
       		<ul class="">
       			<a href="tipobici" class="">Administrar Tipos</a>
       		</ul>
        </li>
        <li class="sub-menu"><a href="#"  class="">Bicicletas</a>
       		<ul>
       			<a href="new-bici" class="">Administrar Bicicletas</a>
       		</ul>
        </li>
        <li class="sub-menu"><a href="#"  class="">Multas</a>
       		<ul>
       			<a href="multas" class="">Administrar Multas</a>
       		</ul>
        </li>
        <li class="sub-menu"><a href="#" class="">Usuarios</a>
       		<ul>
       			<a href="usuarios" class="">Administrar Uauarios</a>
       		</ul>
    	</li>
        <li class="sub-menu"><a href="#" class="">Puntos de Retorno</a>
       		<ul>
       			<a href="sitios" class="">Gestión puntos de retorno</a>
       		</ul>
    	</li>
	</ul>
</header>
</html>