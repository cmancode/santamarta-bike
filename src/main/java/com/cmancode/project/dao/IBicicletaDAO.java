package com.cmancode.project.dao;

import java.util.List;

import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Bicicleta;


public interface IBicicletaDAO extends GenericDAO<Bicicleta, String>{
	List<Bicicleta> listaBici(String placa) throws InstanceNotFoundException;
}
