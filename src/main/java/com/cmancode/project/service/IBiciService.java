package com.cmancode.project.service;

import java.util.List;

import com.cmancode.project.model.Bicicleta;

public interface IBiciService {
	
	public void guardarBici(Bicicleta bici);
	public List<Bicicleta> listaBicis();
	public Bicicleta buscarPorId(String placa);
	public void eliminar(String placa);
	public void editarBici(Bicicleta bici);
	public boolean existeBici(Bicicleta bici);

}
