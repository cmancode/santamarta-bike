package com.cmancode.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmancode.project.dao.INovedadDAO;
import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Novedad;

@Service("servicioNovedad")
@Transactional
public class NovedadServiceImpl implements INovedadService{

	@Autowired
	private INovedadDAO novedadDao;
	
	@Override
	@Transactional
	public void guardarNovedad(Novedad novedad) {
			novedadDao.save(novedad);
	}

	@Override
	@Transactional
	public void actualizaNovedad(Novedad novedad) {
		novedadDao.save(novedad);
	}

	@Override
	@Transactional
	public Novedad buscarPorId(Long id) {
		Novedad novedad = null;
		try {
			novedadDao.find(id);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return novedad;
	}

	@Override
	@Transactional
	public List<Novedad> listNovedades() {
		List<Novedad> novedades = null;
		try {
			novedades = novedadDao.findAll();
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return novedades;
	}

	@Override
	@Transactional
	public boolean existeNovedad(Novedad novedad) {
		boolean encontrado;
		Long id = new Long(novedad.getId());
		encontrado = novedadDao.exists(id);
		return encontrado;
	}
	
	
}
