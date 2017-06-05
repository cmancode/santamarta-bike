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
import org.springframework.web.util.UriComponentsBuilder;

import com.cmancode.project.model.Bicicleta;
import com.cmancode.project.model.Novedad;
import com.cmancode.project.service.INovedadService;

@Controller
public class NovedadController {

	@Autowired
	private INovedadService novedadService;
	
	@RequestMapping(value = "/multas", method = RequestMethod.GET)
	public ModelAndView indexMultas(ModelAndView model){
		List<Novedad> novedad = novedadService.listNovedades();
		model.addObject("novedad", novedad);
		model.setViewName("multa");
		return model;
	}
	
	// Crear Multa
	@RequestMapping (value ="/multas", method = RequestMethod.POST)
	public ResponseEntity<Novedad> crearMulta(@RequestBody Novedad novedad){
		
		if(novedad.getId() != null && novedadService.existeNovedad(novedad)){
			return new ResponseEntity<Novedad>(HttpStatus.CONFLICT);
		}
		novedadService.guardarNovedad(novedad);
		return new ResponseEntity<Novedad>(novedad, HttpStatus.CREATED);
	}
	
	// Buscar Por ID
	@RequestMapping(value = "/buscar-multas/{idM}", method = RequestMethod.GET)
	public ResponseEntity<Novedad> buscarMulta(@PathVariable("idM") Long id){
		
		Novedad novedad = novedadService.buscarPorId(id);
		if( novedad == null){
			System.out.println("Resultado Mal");
			return new ResponseEntity<Novedad>(HttpStatus.NOT_FOUND);
		}
		System.out.println("Resultado Ok");
		return new ResponseEntity<Novedad>(novedad, HttpStatus.OK);
	}
	
	@RequestMapping (value = "/multas-editar/{idMulta}", method = RequestMethod.PUT)
	public ResponseEntity<Novedad> actualizarMulta(@PathVariable("idMulta") Long id, @RequestBody Novedad multa){
		Novedad novedadActualizar = novedadService.buscarPorId(id);
		if( novedadActualizar == null){
			System.out.println("NO EDITO");
			return new ResponseEntity<Novedad>(HttpStatus.NOT_FOUND);
		}
		novedadActualizar.setCosto(multa.getCosto());
		novedadActualizar.setDescripcion(multa.getDescripcion());
		novedadActualizar.setEntrega(multa.getEntrega());
		novedadActualizar.setEstado(multa.getEstado());
		
		novedadService.actualizaNovedad(multa);
		System.out.println("SI EDITO");
		return new ResponseEntity<Novedad>(novedadActualizar, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminMultas(ModelAndView model){
		model.setViewName("admin-multas");
		return model;
	}
}
