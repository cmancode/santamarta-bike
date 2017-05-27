package com.cmancode.project.service;

import java.util.List;

import com.cmancode.project.model.Sitio;

public interface ISitioService {
	
	public void guardarSitio(Sitio sitio);
	public List<Sitio> listSitios();
	public Sitio buscarPorId(Long id);
	public void editarSitio (Sitio sitio);
	public boolean existeSitio(Sitio sitio);
	
}
