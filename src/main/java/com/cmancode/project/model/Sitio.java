package com.cmancode.project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SITIOS")
public class Sitio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSitio;
	
	@Column(nullable = false, length = 30)
	private String nombre;
	
	@Column(nullable =  true)
	private String foto;
	
	@OneToOne(mappedBy = "sitio")
	private Localizacion localizacion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "idSitio", cascade = CascadeType.ALL)
	private Set<Sitio> sitio;
	
	
	public Set<Sitio> getSitio() {
		return sitio;
	}
	public void setSitio(Set<Sitio> sitio) {
		this.sitio = sitio;
	}
	public Long getIdSitio() {
		return idSitio;
	}
	public void setIdSitio(Long idSitio) {
		this.idSitio = idSitio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Localizacion getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(Localizacion localizacion) {
		this.localizacion = localizacion;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}
