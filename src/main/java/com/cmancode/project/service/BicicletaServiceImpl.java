package com.cmancode.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmancode.project.dao.IBicicletaDAO;
import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Bicicleta;

@Service("bicicletaService")
@Transactional
public class BicicletaServiceImpl implements IBiciService {
	
	@Autowired
	private IBicicletaDAO biciDao;
	
	@Override
	@Transactional
	public void guardarBici(Bicicleta bici) {
		biciDao.save(bici);
	}

	@Override
	@Transactional
	public List<Bicicleta> listaBicis() {
		
		List<Bicicleta> bicicletas = null;
		
		try{
			bicicletas =  biciDao.findAll();
		}catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return bicicletas;
	}

	@Override
	@Transactional
	public void eliminar(String placa) {
		try {
			biciDao.remove(placa);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void editarBici(Bicicleta bici) {
		biciDao.save(bici);
	}

	@Override
	@Transactional
	public boolean existeBici(Bicicleta bici) {
		String placa = new String(bici.getPlaca());
		
		return biciDao.exists(placa);
	}

	@Override
	public Bicicleta buscarPorId(String placa) {
		Bicicleta bicicleta = null;
		try{
			bicicleta = biciDao.find(placa);
		}catch(InstanceNotFoundException e){
			e.printStackTrace();
		}
		return bicicleta;
	}

}
