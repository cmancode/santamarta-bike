package com.cmancode.project.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Bicicleta;

@Repository
public class BicicletaDAOImpl extends GenericDAOImpl<Bicicleta, String> implements IBicicletaDAO{

	@Override
	public List<Bicicleta> listaBici(String placa) throws InstanceNotFoundException {
		List<Bicicleta> bicicletas = (List<Bicicleta>) getSession().createQuery("SELECT b FROM Bicicleta b WHERE b.placa = :placa")
									.setParameter("placa", placa).list();
		
		if(bicicletas.isEmpty()){
			throw new InstanceNotFoundException(placa, Bicicleta.class.getName());
		}else{
			return bicicletas;
		}
	}

}
