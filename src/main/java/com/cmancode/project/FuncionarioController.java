package com.cmancode.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmancode.project.model.TipoBicicleta;
import com.cmancode.project.service.ITipoBiciService;

@Controller
public class FuncionarioController {

	@Autowired
	private ITipoBiciService tipoBiciService;
	
	@RequestMapping(value = "/funcionario", method = RequestMethod.GET)
	public ModelAndView funcionario(ModelAndView model){
		List<TipoBicicleta> tipos = tipoBiciService.listaTipos();

		model.addObject("tiposbicicleta", tipos);
		model.setViewName("funcionario-bicicleta");
		return model;
	}
	
}
