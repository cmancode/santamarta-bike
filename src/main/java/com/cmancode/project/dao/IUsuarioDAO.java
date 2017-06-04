package com.cmancode.project.dao;

import java.util.List;

import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Usuario;

public interface IUsuarioDAO extends IGenericDAO<Usuario, String>{

	//En caso de ser requerido un nuevo método para acceder a los datos se debe relacionar aquí
	//Métodos diferentes a la entidad
	public List<Usuario> usuariosLikeList(String cedula) throws InstanceNotFoundException;
	
}
