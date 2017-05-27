package com.cmancode.project.dao;

import org.springframework.stereotype.Repository;

import com.cmancode.project.model.Sitio;

@Repository
public class SitioDAOImpl extends GenericDAOImpl<Sitio, Long> implements ISitioDAO{
	
	//Se utilizará en caso de que se deba implemetar otro método de la interface implementada 
	//que no corresponda al CRUD generico
}
