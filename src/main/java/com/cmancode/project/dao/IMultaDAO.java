package com.cmancode.project.dao;

import java.util.List;

import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Multa;

public interface IMultaDAO {
	
	public List<Multa> multas (Long id) throws InstanceNotFoundException;

}
