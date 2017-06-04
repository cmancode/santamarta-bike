package com.cmancode.project.service;

import java.util.List;

import com.cmancode.project.model.Rol;

public interface IRolService {
	
	public void guardarRol(Rol rol);
	public void actualizarRol(Rol rol);
	public Rol buscarRolId(Long id);
	public List<Rol> listaRoles();
	public boolean existencia(Rol rol);
	
}
