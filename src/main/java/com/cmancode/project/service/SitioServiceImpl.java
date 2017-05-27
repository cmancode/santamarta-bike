package com.cmancode.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmancode.project.dao.ISitioDAO;
import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Sitio;

@Service("sitioService")
@Transactional
public class SitioServiceImpl implements ISitioService{

	@Autowired
	public ISitioDAO sitioDao;
	
	@Override
	@Transactional
	public void guardarSitio(Sitio sitio) {
		sitioDao.save(sitio);
	}

	@Override
	@Transactional
	public List<Sitio> listSitios() {
		List<Sitio> sitios = null;
		try {
			sitios = sitioDao.findAll();
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sitios;
	}

	@Override
	@Transactional
	public Sitio buscarPorId(Long id) {
		Sitio sitio = null;
		try {
			sitio = sitioDao.find(id);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sitio;
	}

	@Override
	@Transactional
	public void editarSitio(Sitio sitio) {
		sitioDao.save(sitio);
	}

	@Override
	@Transactional
	public boolean existeSitio(Sitio sitio) {
		Long id = new Long(sitio.getIdSitio());
		boolean existio = false;
		existio = sitioDao.exists(id);
		return existio;
	}
	
	
	
}
