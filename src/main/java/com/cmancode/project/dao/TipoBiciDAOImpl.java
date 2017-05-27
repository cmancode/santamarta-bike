package com.cmancode.project.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.TipoBicicleta;

@Repository
public class TipoBiciDAOImpl extends GenericDAOImpl<TipoBicicleta, Long> implements ITipoBiciDAO {

	@Override
	public List<TipoBicicleta> busquedaTiposBicicletas(String tipo) throws InstanceNotFoundException {
		
		System.out.println(tipo);                                             
		List<TipoBicicleta> list = (List<TipoBicicleta>) getSession().createQuery("from TipoBicicleta t where t.tipo like :tipB ")
				.setString("tipB", "%" + tipo + "%").list();
;                      
		List<TipoBicicleta> tiposBici = list;
		return tiposBici;
		
	}


	@Override
	public TipoBicicleta tipoBicicleta(String tipov) throws InstanceNotFoundException {
		 TipoBicicleta tipoBici = (TipoBicicleta) getSession().createQuery("from TipoBicicleta t where t.tipo = :tip")
				.setParameter("tip", tipov).uniqueResult();		
		return 	tipoBici;
	}
	
	@Override
	public boolean tipoBicicletaExiste(String tipo) throws InstanceNotFoundException {	
		TipoBicicleta tipoBici = tipoBicicleta(tipo);
		if(tipoBici == null){
			return false;
		}else{
			return true;
		}
	}
	
}
