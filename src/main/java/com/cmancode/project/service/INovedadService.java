package com.cmancode.project.service;

import java.util.List;

import com.cmancode.project.model.Novedad;

public interface INovedadService {
	
	public void guardarNovedad(Novedad novedad);
	public void actualizaNovedad(Novedad novedad);
	public Novedad buscarPorId(Long id);
	public List<Novedad> listNovedades();
	public boolean existeNovedad(Novedad novedad);
	
}
