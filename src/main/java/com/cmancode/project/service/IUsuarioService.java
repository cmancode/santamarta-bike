package com.cmancode.project.service;

import java.util.List;

import com.cmancode.project.model.Usuario;

public interface IUsuarioService {
	
	public void guardarUsuario(Usuario usuario);
	public void ActualizarUsuario(Usuario usuario);
	public Usuario buscarPorId(String id);
	public List<Usuario> listaUsuaios();
	public List<Usuario> listLikeUsuarios(String cedula);
	public boolean existencia(Usuario usuario);
}
