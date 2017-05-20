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
@Table(name = "BICICLETAS")
public class Bicicleta {

	@Id
	@Column(length = 20)
	private String placa;
	
	@Column(nullable = false, length = 15)
	private  String color;
	
	@Column(nullable = false, length = 15)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "idTipoBici")
	private TipoBicicleta idTipoBici;
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public TipoBicicleta getIdTipoBici() {
		return idTipoBici;
	}
	public void setIdTipoBici(TipoBicicleta idTipoBici) {
		this.idTipoBici = idTipoBici;
	}
	
}
