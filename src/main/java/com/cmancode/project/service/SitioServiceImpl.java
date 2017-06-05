package com.cmancode.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmancode.project.dao.ISitioDAO;
import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Bicicleta;
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
	
	@Override
	public List<Sitio> listaBusquedaSitios(String sitio)  {
		List<Sitio> sitios = null;
		
		try {
			sitios = sitioDao.busquedaSitios(sitio);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sitios;
		
	}
	

	public Sitio sitio(String sit){
		Sitio sitio = null;
		
		try {
			sitio = sitioDao.sitio(sit);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		
		return sitio;
	}

	public boolean sitioExisteNombre(Sitio sitio){
		boolean valor = true;
		String nombre = sitio.getNombre();
		try{
			valor = sitioDao.sitioExiste(nombre);
		} catch (InstanceNotFoundException e){
			e.printStackTrace();			
		}
		return valor;
	}

	@Override
	public List<Object> bicicletasDeSitios(Long idSitio) {
		List<Object> bicicletas = null;
		try {
			bicicletas = sitioDao.bicicletasDeSitio(idSitio);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return bicicletas;
	}
	
}
