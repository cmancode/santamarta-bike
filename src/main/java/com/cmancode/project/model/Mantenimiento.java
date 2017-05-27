package com.cmancode.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MANTENIMIENTOS")
public class Mantenimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMnto;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "idBicicleta", nullable = false)
	private Bicicleta bicicleta;
	
	@Column(nullable = false, length = 200)
	private String observacion;
	
	public Long getIdMnto() {
		return idMnto;
	}

	public void setIdMnto(Long idMnto) {
		this.idMnto = idMnto;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
}
