package com.cmancode.project.service;

import java.util.List;

import com.cmancode.project.model.Usuario;

public interface IUsuarioService {
	
	public void guardarUsuario(Usuario usuario);
	public void ActualizarUsuario(Usuario usuario);
	public Usuario buscarPorId(Long id);
	public List<Usuario> listaUsuaios();
	public boolean existencia(Usuario usuario);
	
}