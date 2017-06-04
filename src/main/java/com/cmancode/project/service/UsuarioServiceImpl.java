package com.cmancode.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmancode.project.dao.IUsuarioDAO;
import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Usuario;

@Service("servicioUsuario")
@Transactional
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	@Transactional
	public void guardarUsuario(Usuario usuario) {
		usuarioDAO.save(usuario);
	}
	@Override
	@Transactional
	public void ActualizarUsuario(Usuario usuario) {
		usuarioDAO.save(usuario);
	}
	@Override
	@Transactional
	public Usuario buscarPorId(String id) {
		Usuario usuario = null;
		try {
			usuario = usuarioDAO.find(id);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	@Override
	public List<Usuario> listLikeUsuarios(String cedula) {
		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioDAO.usuariosLikeList(cedula);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	@Override
	@Transactional
	public List<Usuario> listaUsuaios() {
	    List<Usuario> usuarios = null;
	    try {
			usuarios = usuarioDAO.findAll();
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	@Override
	@Transactional
	public boolean existencia(Usuario usuario) {
		String id = new String(usuario.getIdCedula());
		boolean existio;
		existio = usuarioDAO.exists(id);		
		return existio;
	}
}