package com.cmancode.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ModelAndView nuevoUsuario(ModelAndView model){
		model.setViewName("usuario");
		return model;
	}
	
}
