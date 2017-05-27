package com.cmancode.project;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.cmancode.project.model.Bicicleta;
import com.cmancode.project.model.Sitio;
import com.cmancode.project.model.TipoBicicleta;
import com.cmancode.project.service.IBiciService;
import com.cmancode.project.service.ISitioService;
import com.cmancode.project.service.ITipoBiciService;



@Controller
public class BicicletaController {

	private static final Logger logger = LoggerFactory.getLogger(BicicletaController.class);
	
	@Autowired
	private IBiciService biciService;
	@Autowired
	private ITipoBiciService tipobiciService;
	@Autowired
	private ISitioService sitioService;
	
	
	@RequestMapping(value = "/new-bici", method = RequestMethod.GET)
	public ModelAndView nuevaBici (ModelAndView model){
		List<Bicicleta> bicicletas = biciService.listaBicis();
		List<TipoBicicleta> tipos = tipobiciService.listaTipos();
		List<Sitio> sitios = sitioService.listSitios();
		model.addObject("sities", sitios);
		model.addObject("bicis", bicicletas);
		model.addObject("tiposbici", tipos);
		model.setViewName("bicicleta");
		return model;
	}
	
	@RequestMapping(value = "/new-bici", method = RequestMethod.POST)
	public ResponseEntity<Bicicleta> crearBici (@RequestBody Bicicleta bicicleta, UriComponentsBuilder ucBuilder){		
		
		if(bicicleta.getPlaca() != null && biciService.existeBici(bicicleta)){
			return new ResponseEntity<Bicicleta>(HttpStatus.CONFLICT);
		}
		
		biciService.guardarBici(bicicleta);
		
		return new ResponseEntity<Bicicleta>(bicicleta, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/buscar-bici", method = RequestMethod.GET)
	public ModelAndView formBuscarBici (ModelAndView model){
		List<TipoBicicleta> tipos = tipobiciService.listaTipos();
		model.addObject("tiposbici", tipos);
		model.setViewName("buscar-editar-bici");
		return model;
	}
	
	@RequestMapping(value = "/buscar-bici/{placa}", method = RequestMethod.GET)
	public ResponseEntity<Bicicleta> buscarBici(@PathVariable("placa") String placa){

		Bicicleta bicicleta = biciService.buscarPorId(placa);
		if(bicicleta == null){
			return new ResponseEntity<Bicicleta>(HttpStatus.NOT_FOUND);
		}
		System.out.println("Resultado Ok");
		return new ResponseEntity<Bicicleta>(bicicleta, HttpStatus.OK);
	}

	@RequestMapping(value = "/bicicleta/{idPlaca}", method = RequestMethod.PUT)
	public ResponseEntity<Bicicleta> actualizarBicicleta (@PathVariable("idPlaca") String placa, @RequestBody Bicicleta bicicleta){
		
		Bicicleta datosAactualizar = biciService.buscarPorId(placa);
		System.out.println(datosAactualizar.getEstado());
		if(datosAactualizar == null){
			return new ResponseEntity<Bicicleta>(HttpStatus.NOT_FOUND);
		}
		datosAactualizar.setPlaca(bicicleta.getPlaca());
		datosAactualizar.setColor(bicicleta.getColor());
		datosAactualizar.setEstado(bicicleta.getEstado());
		datosAactualizar.setIdTipoBici(bicicleta.getIdTipoBici());
		datosAactualizar.setIdSitio(bicicleta.getIdSitio());
		biciService.editarBici(datosAactualizar);	
		return new ResponseEntity<Bicicleta>(datosAactualizar, HttpStatus.OK);
	}
	
}
