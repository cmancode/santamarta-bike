package com.cmancode.project.dao;

import java.util.List;

import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.TipoBicicleta;

public interface ITipoBiciDAO extends GenericDAO<TipoBicicleta, Long>{
	
	public List<TipoBicicleta> tiposBici(Long id) throws InstanceNotFoundException;
}
