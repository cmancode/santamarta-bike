package com.cmancode.project.dao;

import java.util.List;

import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.TipoBicicleta;

public interface ITipoBiciDAO extends IGenericDAO<TipoBicicleta, Long>{
	
	public List<TipoBicicleta> busquedaTiposBicicletas(String tipo) throws InstanceNotFoundException;
	
	public TipoBicicleta tipoBicicleta(String tipo) throws InstanceNotFoundException;
	
	public boolean tipoBicicletaExiste(String tipo) throws InstanceNotFoundException;
	
}
