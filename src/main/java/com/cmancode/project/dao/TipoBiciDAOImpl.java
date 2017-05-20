package com.cmancode.project.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Bicicleta;
import com.cmancode.project.model.TipoBicicleta;

@Repository
public class TipoBiciDAOImpl extends GenericDAOImpl<TipoBicicleta, Long> implements ITipoBiciDAO {

	@Override
	public List<TipoBicicleta> tiposBici(Long id) throws InstanceNotFoundException {
		List<TipoBicicleta> tiposBici = (List<TipoBicicleta>) getSession().createSQLQuery("select tipo from TipoBicicleta tipo where tipo.idTipoBici = :id")
				.setParameter("id", id).list();
		
		if(tiposBici == null){
			throw new InstanceNotFoundException(id, TipoBicicleta.class.getName());
		}else{
			return tiposBici;
		}
	}

}
