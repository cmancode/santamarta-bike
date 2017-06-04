package com.cmancode.project.dao;

import java.util.List;

import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Sitio;

public interface ISitioDAO extends IGenericDAO<Sitio, Long> {
	
	public List<Sitio> busquedaSitios(String sitio) throws InstanceNotFoundException;
	
	public Sitio sitio(String sitio) throws InstanceNotFoundException;
	
	public boolean sitioExiste(String sitio) throws InstanceNotFoundException; 
	
}
