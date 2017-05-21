package com.cmancode.project.dao;

import java.util.List;

import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Multa;

public class MultaDAOImp extends GenericDAOImpl<Multa, Long> implements IMultaDAO{

	@Override
	public List<Multa> multas(Long id) throws InstanceNotFoundException {
		List<Multa> multas = (List<Multa>) getSession().createQuery("select m from Multa m where m.idMulta = :id")
							.setParameter("id", id).list();
		if(multas.isEmpty()){
			throw new InstanceNotFoundException(id, Multa.class.getName());
		}else{
			return multas;
		}
	}
	
	
}
