package com.cmancode.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Bicicleta;
import com.cmancode.project.model.Sitio;

@Repository
public class SitioDAOImpl extends GenericDAOImpl<Sitio, Long> implements ISitioDAO{
	

	public List<Sitio> busquedaSitios(String sitio) throws InstanceNotFoundException {
		                                             
		List<Sitio> list = (List<Sitio>) getSession().createQuery("from Sitio t where t.nombre like :sit ")
				.setString("sit", "%" + sitio + "%").list();                   
		List<Sitio> sitios = list;
		return sitios;
		
	}
	public Sitio sitio(String sitio) throws InstanceNotFoundException {
		Sitio tipoBici = (Sitio) getSession().createQuery("from Sitio t where t.nombre = :sit")
				.setParameter("sit", sitio).uniqueResult();		
		return 	tipoBici;
	}
	public boolean sitioExiste(String sitio) throws InstanceNotFoundException {	
		Sitio sitioe = sitio(sitio);
		if(sitioe == null){
			return false;
		}else{
			return true;
		}
	}
	@Override
	public List<Object> bicicletasDeSitio(Long idSitio) throws InstanceNotFoundException {
		List<Object> listBici = null;
		SQLQuery datos = getSession().createSQLQuery("SELECT b.placa, t.tipo, b.color FROM BICICLETAS as b"+
													 " INNER JOIN SITIOS"+
													 " ON b.idSitio = SITIOS.idSitio"+
													 " INNER JOIN TIPOS_BICICLETA as t ON b.idTipoBici = t.idTipoBici"+
													 " WHERE SITIOS.idSitio = :id");
		datos.setParameter("id", idSitio);
		listBici = datos.list();
		return listBici;
	}
	
	
}
