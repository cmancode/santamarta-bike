package com.cmancode.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmancode.project.dao.ITipoBiciDAO;
import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.TipoBicicleta;

@Service("tiposBicicletaService")
@Transactional
public class TipoBiciServiceImpl implements ITipoBiciService {
	
	@Autowired
	private ITipoBiciDAO tipoDao;
	
	@Override
	@Transactional
	public void crearTipoBici(TipoBicicleta tipoBici) {
		tipoDao.save(tipoBici);
	}

	@Override
	@Transactional
	public List<TipoBicicleta> listaTipos() {
		List<TipoBicicleta> tipos = null;
		
		try{
			tipos = tipoDao.findAll();
		}catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		
		return tipos;
	}
	

	@Override
	public TipoBicicleta tipoById(Long id) {
		TipoBicicleta tipoBici = null;
		
		try {
			tipoBici = tipoDao.find(id);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return tipoBici;
	}
	
	@Override
	@Transactional
	public void editarTipo(TipoBicicleta tipoBici) {
		tipoDao.save(tipoBici);
	}

	@Override
	@Transactional
	public void eliminarTipo(Long idTipo) {
		try{
			tipoDao.remove(idTipo);
		}catch(InstanceNotFoundException e){
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional
	public boolean existenciaTipoBici(TipoBicicleta tipoBici) {
		
		Long id = new Long(tipoBici.getIdTipoBici());
		
		return tipoDao.exists(id);
	}

	
	@Override
	public List<TipoBicicleta> listaBusquedaTiposBicicletas(String tipo)  {
		List<TipoBicicleta> tiposBicicletas = null;
		
		try {
			tiposBicicletas = tipoDao.busquedaTiposBicicletas(tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tiposBicicletas;
		
	}
	

	public TipoBicicleta tipoBicicleta(String tipo){
		TipoBicicleta tipoBici = null;
		
		try {
			tipoBici = tipoDao.tipoBicicleta(tipo);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		
		return tipoBici;
	}
	
	public boolean tipoBicicletaExisteNombre(TipoBicicleta tipoBicicleta){
		boolean valor = true;
		String tipo = tipoBicicleta.getTipo();
		try{
			valor = tipoDao.tipoBicicletaExiste(tipo);
		} catch (InstanceNotFoundException e){
			e.printStackTrace();			
		}
		return valor;
	}

}
