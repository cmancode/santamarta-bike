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

import com.cmancode.project.model.Bicicleta;
import com.cmancode.project.model.TipoBicicleta;
import com.cmancode.project.service.ITipoBiciService;

@Controller
public class TipoBicicletaController {
	
	@Autowired
	private ITipoBiciService tipoBiciService;
	
	@RequestMapping(value = "/tipobici", method = RequestMethod.GET)
	public ModelAndView listaTiposBici(ModelAndView model){
		List<TipoBicicleta> tipos = tipoBiciService.listaTipos();
		model.addObject("tiposbici", tipos);
		model.setViewName("tipoBicicleta");
		return model;
	}

	@RequestMapping(value = "/tipobici-ba", method = RequestMethod.GET)
	public ModelAndView buscarActualizarTipoBici(ModelAndView model){
		model.setViewName("buscar-tipobici");
		return model;
	}
	
	@RequestMapping(value = "/tipobici/{idTipoBici}", method = RequestMethod.GET)
	public ResponseEntity<TipoBicicleta> typeBiciById (@PathVariable("idTipoBici") Long id){
		
		TipoBicicleta tipoBici = tipoBiciService.tipoById(id);
		if(tipoBici == null){
			return new ResponseEntity<TipoBicicleta> (HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TipoBicicleta> (tipoBici, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/tipobici", method = RequestMethod.POST)
	public ResponseEntity<TipoBicicleta> crearTipoBici (@RequestBody TipoBicicleta nuevoTipo){
		
//		if(tipoBiciService.existenciaTipoBici(nuevoTipo) == true){
//			return new ResponseEntity<TipoBicicleta> (HttpStatus.NOT_FOUND);
//		}
		tipoBiciService.crearTipoBici(nuevoTipo);
		
		return new ResponseEntity<TipoBicicleta> (nuevoTipo, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/tipobici/{idTipoBici}", method = RequestMethod.PUT)
	public ResponseEntity<TipoBicicleta> editarTipoBici (@PathVariable("idTipoBici") Long id, @RequestBody TipoBicicleta tipoBicicleta){

		TipoBicicleta tipoAeditar = tipoBiciService.tipoById(id);

		if(tipoAeditar == null){
			return new ResponseEntity<TipoBicicleta>(HttpStatus.NOT_FOUND);
		}
		tipoAeditar.setTipo(tipoBicicleta.getTipo());
		tipoAeditar.setDescripcion(tipoBicicleta.getDescripcion());
		tipoBiciService.editarTipo(tipoAeditar);
		return new ResponseEntity<TipoBicicleta> (tipoAeditar, HttpStatus.CREATED);
	}
}
