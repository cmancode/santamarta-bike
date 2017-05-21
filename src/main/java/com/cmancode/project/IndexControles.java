package com.cmancode.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexControles {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex (Model model){
		return "index";
	}
	
}
