package com.cmancode.project;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmancode.project.model.Usuario;
import com.cmancode.project.service.IUsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ModelAndView cargarUsuarios(ModelAndView model){
		List<Usuario> usuarios = usuarioService.listaUsuaios();
		model.addObject("listUsuarios", usuarios);
		model.setViewName("usuario");
		return model;
	}
	
}
