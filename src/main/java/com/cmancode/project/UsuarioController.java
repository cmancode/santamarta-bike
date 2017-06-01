package com.cmancode.project;

import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "/usuarios-id", method = RequestMethod.GET)
	public ModelAndView consultarUsuarioId(ModelAndView model){
		model.setViewName("usuario-id");
		return model;
	}
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> consultarPorId(@PathVariable("id") String id){
		Usuario usuario = null;
		usuario = usuarioService.buscarPorId(id);
		if(usuario == null){
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	@RequestMapping(value = "/new-user", method = RequestMethod.POST)
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
		System.out.println("entro");
		if(usuario.getCedula() != null && usuarioService.existencia(usuario)){
			System.out.println("conflicto");
			return new ResponseEntity<Usuario>(HttpStatus.CONFLICT);
		}
		usuarioService.guardarUsuario(usuario);
		System.out.println("guardado");
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
}
