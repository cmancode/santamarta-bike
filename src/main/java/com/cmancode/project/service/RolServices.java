package com.cmancode.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmancode.project.dao.IRolDAO;
import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Rol;

@Service("rolService")
@Transactional
public class RolServices implements IRolService {

	@Autowired
	private IRolDAO rolDao;
	
	@Override
	@Transactional
	public void guardarRol(Rol rol) {
		rolDao.save(rol);
	}

	@Override
	@Transactional
	public void actualizarRol(Rol rol) {
		rolDao.save(rol);
	}

	@Override
	@Transactional
	public Rol buscarRolId(Long id) {
		Rol rol = null;
		try {
			rol = rolDao.find(id);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rol;
	}

	@Override
	@Transactional
	public List<Rol> listaRoles() {
		List<Rol> roles = null;
		try {
			roles = rolDao.findAll();
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return roles;
	}

	@Override
	@Transactional
	public boolean existencia(Rol rol) {
		Long id = new Long(rol.getIdRol());
		boolean existio = false;
		existio = rolDao.exists(id);
		return existio;
	}

}
