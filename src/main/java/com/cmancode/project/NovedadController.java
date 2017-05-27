package com.cmancode.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmancode.project.service.INovedadService;

@Controller
public class NovedadController {

	@Autowired
	private INovedadService novedadService;
	
	@RequestMapping(value = "/multas", method = RequestMethod.GET)
	public ModelAndView indexMultas(ModelAndView model){
		model.setViewName("multa");
		return model;
	}

	@RequestMapping(value = "/multas-bu", method = RequestMethod.GET)
	public ModelAndView buscarMulta(ModelAndView model){
		model.setViewName("buscar-multas");
		return model;
	}
	

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminMultas(ModelAndView model){
		model.setViewName("admin-multas");
		return model;
	}
}