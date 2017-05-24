package com.cmancode.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TIPOS_BICICLETA")
public class TipoBicicleta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTipoBici;
	
	@Column(nullable = false, length = 25)
	private String tipo;
	
	@Column(nullable = false, length = 200)
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "idTipoBici")
	private Set<Bicicleta> bicicleta;
	
	
	public Set<Bicicleta> getBicicleta() {
		return bicicleta;
	}
	public void setBicicleta(Set<Bicicleta> bicicleta) {
		this.bicicleta = bicicleta;
	}
	public Long getIdTipoBici() {
		return idTipoBici;
	}
	public void setIdTipoBici(Long idTipoBici) {
		this.idTipoBici = idTipoBici;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
