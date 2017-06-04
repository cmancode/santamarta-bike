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

import com.cmancode.project.model.Rol;
import com.cmancode.project.model.Usuario;
import com.cmancode.project.service.IRolService;
import com.cmancode.project.service.IUsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IRolService rolService;
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ModelAndView cargarUsuarios(ModelAndView model){
		List<Usuario> usuarios = usuarioService.listaUsuaios();
		List<Rol> rols = rolService.listaRoles();
		model.addObject("listRoles", rols);
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
	@RequestMapping(value = "/usuario-like/{cedula}", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> consultarLikeId(@PathVariable("cedula") String cedula){
		List<Usuario> usuario = null;
		usuario = usuarioService.listLikeUsuarios(cedula);
		if(usuario == null){
			return new ResponseEntity<List<Usuario>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	}
	@RequestMapping(value = "/new-user", method = RequestMethod.POST)
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
		if(usuario.getIdCedula() != null && usuarioService.existencia(usuario)){
			System.out.println("conflicto");
			return new ResponseEntity<Usuario>(HttpStatus.CONFLICT);
		}
		usuarioService.guardarUsuario(usuario);
		System.out.println("guardado");
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	@RequestMapping(value = "/usuario/{cedula}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> actualizar(@PathVariable("cedula") String cecula, @RequestBody Usuario usuario){
		Usuario usuarioAactualizar = usuarioService.buscarPorId(cecula);
		if(usuarioAactualizar == null){
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		usuarioAactualizar.setIdCedula(usuario.getIdCedula());
		usuarioAactualizar.setTipoDoc(usuario.getTipoDoc());
		usuarioAactualizar.setNombres(usuario.getNombres());
		usuarioAactualizar.setpApellido(usuario.getpApellido());
		usuarioAactualizar.setsApellido(usuario.getsApellido());
		usuarioAactualizar.setEmail(usuario.getEmail());
		usuarioAactualizar.setTelf(usuario.getTelf());
		usuarioAactualizar.setCiudadResidencia(usuario.getCiudadResidencia());
		usuarioAactualizar.setDirResidencia(usuario.getDirResidencia());
		usuarioAactualizar.setPassword(usuario.getPassword());
		usuarioAactualizar.setRol(usuario.getRol());
		usuarioService.ActualizarUsuario(usuarioAactualizar);
		return new ResponseEntity<Usuario>(usuarioAactualizar, HttpStatus.OK);
	}
}
