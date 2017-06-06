<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
  	<div id ="container-menu">
	    <ul id="slide-out" class="side-nav fixed indigo darken-2">
	    	<li id="li-container-logo" class="center-align">
	        	<a  href="/project/" class=""><h5 id="logo">SM - Bike <i class="fa fa-bicycle" aria-hidden="true"></i></h5></a>
	        </li>
	        <li class="sub-menu"><a href="#"  class=""><i class="fa fa-bicycle" aria-hidden="true"></i> Bicicletas</a>
	       		<ul>
	       			<a href="bicicletas-prestadas" class="">Bicicletas Prestadas</a>
	       		</ul>
	       		<ul>
	       			<a href="bicicletas-disponibles" class="">Bicicletas Disponibles</a>
	       		</ul>
	        </li>
	        <li class="sub-menu"><a href="#"  class=""><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> Gestión</a>
	       		<ul>
	       			<a href="bicicleta-tramite" class="">Prestar Bicicleta</a>
	       		</ul>
	       		<ul>
	       			<a href="#" class="">Situación</a>
	       		</ul>
	        </li>
	        <li class="sub-menu"><a href="#" class=""><i class="fa fa-user" aria-hidden="true"></i> Usuarios</a>
	       		<ul>
	       			<a href="/project" class="">Administrar Usuarios</a>
	       		</ul>
	    	</li>
		</ul>
  	</div>
</header>