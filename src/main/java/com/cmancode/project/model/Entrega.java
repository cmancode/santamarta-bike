package com.cmancode.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ENTREGAS")
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEntrega;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "idPlaca", nullable = false)
	private Bicicleta bicicleta;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "idNovedad", nullable = false)
	private Novedades novedad;
	
	@Column(nullable = false, length = 10)
	private String hora;
	
	@DateTimeFormat(pattern = "dd/MM/yyy")
	private Date fecha;

	
	public Long getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(Long idEntrega) {
		this.idEntrega = idEntrega;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Novedades getNovedad() {
		return novedad;
	}

	public void setNovedad(Novedades novedad) {
		this.novedad = novedad;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}

