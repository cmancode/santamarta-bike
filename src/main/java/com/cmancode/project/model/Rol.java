package com.cmancode.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ROLES")
public class Rol {
	
	@Id
	@GeneratedValue
	private Long idRol;
	@Column(nullable = false, length = 30)
	private String rol;
	@JsonIgnore
	@ManyToMany(mappedBy = "rol")
	private Set<Usuario> usuario = new HashSet<Usuario>();
	
	public Set<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}	
}
