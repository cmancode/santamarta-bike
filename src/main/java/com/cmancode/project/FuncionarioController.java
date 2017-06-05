package com.cmancode.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmancode.project.model.Bicicleta;
import com.cmancode.project.model.TipoBicicleta;
import com.cmancode.project.service.IBiciService;
import com.cmancode.project.service.ITipoBiciService;

@Controller
public class FuncionarioController {

	@Autowired
	private ITipoBiciService tipoBiciService;
	
	@Autowired
	private IBiciService biciService;
	
	
	
	@RequestMapping(value = "/funcionario", method = RequestMethod.GET)
	public ModelAndView funcionario(ModelAndView model){
		List<TipoBicicleta> tipos = tipoBiciService.listaTipos();

		model.addObject("tiposbicicleta", tipos);
		model.setViewName("funcionario-index");
		return model;
	}
	/*
	@RequestMapping(value = "/bicicletas-prestadas", method = RequestMethod.GET)
	public ModelAndView funcionarioPrestadas(ModelAndView model){
		List<Reserva> reserva = reservaService.listaReserva();
		model.addObject("reservas", reserva);
		
		model.setViewName("funcionario-bicicleta-prestada");
		return model;
	}*/
	
	@RequestMapping(value = "/bicicletas-disponibles", method = RequestMethod.GET)
	public ModelAndView funcionarioDisponibles(ModelAndView model){
		List<Bicicleta> bici = biciService.listaBicis();
		model.addObject("bicicletas", bici);
		model.setViewName("funcionario-bicicleta-disponible");
		return model;
	}
	
	
	
}
