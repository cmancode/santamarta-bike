package com.cmancode.project.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cmancode.project.model.Usuario;

@Repository
public class UsuarioImplDAO extends GenericDAOImpl<Usuario, String> implements IUsuarioDAO{
	// Se implementaran los metodos diferentes al CRUD de la entidad Usuario	
	@Override
	public List<Usuario> usuariosLikeList(String cedula) {
		List<Usuario> usuarios = (List<Usuario>) getSession().createQuery("from Usuario u where u.idCedula like :idCedula ")
				.setParameter("idCedula", "%"+cedula+"%").list();
		return usuarios;
	}
}
