package com.cmancode.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "SITIOS")
public class Sitio {

	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "localizacion"))
	private Long idSitio;
	@Column(nullable = false, length = 30)
	private String nombre;
	@Column(nullable =  true)
	private String foto;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "localizacoin")
	private Localizacion localizacion;
	
	
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
