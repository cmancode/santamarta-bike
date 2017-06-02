package com.cmancode.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmancode.project.model.Sitio;
import com.cmancode.project.model.TipoBicicleta;
import com.cmancode.project.service.ISitioService;

@Controller
public class SitioController {
	
	@Autowired
	private ISitioService sitioService;
	
	@RequestMapping(value = "/sitios", method = RequestMethod.GET)
	public ModelAndView listaSitios (ModelAndView model){
		List<Sitio> sitios = sitioService.listSitios();
		model.addObject("sitios", sitios);
		model.setViewName("sitios");
		return model;
	}
	
	@RequestMapping(value="/sitios/{sitio}", method = RequestMethod.GET)
	public ResponseEntity< List<Sitio> > buscarSitio(@PathVariable("sitio") String sitio){
		List<Sitio> sitios = sitioService.listaBusquedaSitios(sitio);
		if(sitios == null){
			return new ResponseEntity< List<Sitio> >(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity< List<Sitio> > ( sitios, HttpStatus.OK);
	}

	@RequestMapping(value = "/sitios", method = RequestMethod.POST)
	public ResponseEntity<Sitio> crearSitio (@RequestBody Sitio nuevoSitio){
		
		if( sitioService.sitioExisteNombre(nuevoSitio) == true){
			return new ResponseEntity<Sitio> (HttpStatus.NOT_ACCEPTABLE);
		}
		sitioService.guardarSitio(nuevoSitio);
		
		return new ResponseEntity<Sitio> (nuevoSitio, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/sitios/{idSitio}", method = RequestMethod.PUT)
	public ResponseEntity<Sitio> editarSitio (@PathVariable("idSitio") Long id, @RequestBody Sitio sitio){

		Sitio sitioEditar = sitioService.buscarPorId(id);

		if(sitioEditar == null){
			return new ResponseEntity<Sitio>(HttpStatus.NOT_FOUND);
		}
		
		sitioEditar.setNombre(sitio.getNombre());
		sitioEditar.setFoto(sitio.getFoto());
		sitioEditar.setLat(sitio.getLat());
		sitioEditar.setLng(sitio.getLng());
		sitioEditar.setDireccion(sitio.getDireccion());
		
		sitioService.editarSitio(sitioEditar);
	
		return new ResponseEntity<Sitio> (sitioEditar, HttpStatus.CREATED);
	}
	
}
