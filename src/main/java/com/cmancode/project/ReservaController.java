package com.cmancode.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmancode.project.model.Reserva;
import com.cmancode.project.service.IReservaService;

@Controller
public class ReservaController {

	@Autowired
	private IReservaService reservaService;	
	
	@RequestMapping(value = "list-reservas", method = RequestMethod.GET)
	public ModelAndView reservas(ModelAndView model){
		List<Reserva> reservas = reservaService.listReserva();
		model.addObject("reser", reservas);
		
		model.setViewName("reservas");
		return model;
	}
}
