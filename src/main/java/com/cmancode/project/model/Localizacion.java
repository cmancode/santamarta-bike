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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "LOCALIZACIONES")
public class Localizacion {

	@Id
	@Column(name="idLocalizacion", unique=true, nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="sitio"))
	private Long id;

	@Column(nullable = false)
	private Long lat;

	@Column(nullable = false)
	private Long lng;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Sitio sitio;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLat() {
		return lat;
	}
	public void setLat(Long lat) {
		this.lat = lat;
	}
	public Long getLng() {
		return lng;
	}
	public void setLng(Long lng) {
		this.lng = lng;
	}
	public Sitio getSitio() {
		return sitio;
	}
	public void setSitio(Sitio sitio) {
		this.sitio = sitio;
	}
	
	
	
	
}
