package com.cmancode.project.service;

import java.util.List;

import com.cmancode.project.model.TipoBicicleta;

public interface ITipoBiciService {
	
	public void crearTipoBici(TipoBicicleta tipoBici);
	public List<TipoBicicleta> listaTipos();
	public TipoBicicleta tipoById(Long id);
	public void editarTipo(TipoBicicleta tipoBici);
	public void eliminarTipo(Long idTipo);
	public boolean existenciaTipoBici(TipoBicicleta tipoBici);
	
}
