package com.cmancode.project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idTipoBici", nullable = false)
	private TipoBicicleta idTipoBici;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "idSitio", nullable = false)
	private Sitio idSitio;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bicicleta", cascade = CascadeType.ALL)
	private Set<Mantenimiento> manetenimiento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bicicleta", cascade = CascadeType.ALL)
	private Set<Entrega> entrega;
	
	
	
	public Set<Mantenimiento> getManetenimiento() {
		return manetenimiento;
	}
	public void setManetenimiento(Set<Mantenimiento> manetenimiento) {
		this.manetenimiento = manetenimiento;
	}
	public Set<Entrega> getEntrega() {
		return entrega;
	}
	public void setEntrega(Set<Entrega> entrega) {
		this.entrega = entrega;
	}
	public Sitio getIdSitio() {
		return idSitio;
	}
	public void setIdSitio(Sitio idSitio) {
		this.idSitio = idSitio;
	}
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
