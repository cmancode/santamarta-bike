package com.cmancode.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MULTAS")
public class Multa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMulta;
	@Column(nullable = false, length = 60)
	private String descripcion;
	@Column(nullable = false, length = 15)
	private String estado;
	
	public Long getIdMulta() {
		return idMulta;
	}
	public void setIdMulta(Long idMulta) {
		this.idMulta = idMulta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
