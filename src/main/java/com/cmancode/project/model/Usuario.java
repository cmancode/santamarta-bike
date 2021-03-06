package com.cmancode.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USUARIOS")
public class Usuario {
	
	@Id
	@Column(unique = true, nullable = false, length = 12)
	private String idCedula;
	
	@Column(name = "tiopo_documento", nullable = false, length = 20)
	private String tipoDoc;
	
	@Column(name = "nombres", nullable = false, length = 40)
	private String nombres;
	
	@Column(name = "p_apellido", nullable = false, length = 25)
	private String pApellido;
	
	@Column(name = "s_apellido", nullable = false, length = 25)
	private String sApellido;
	
	@Column(name = "email", nullable = false, length = 40)
	private String email;
	
	@Column(name = "telf", nullable = false, length = 12)
	private String telf;
	
	@Column(name = "ciudad_residencia", nullable = false, length = 30)
	private String ciudadResidencia;
	
	@Column(name = "dir_residencia", nullable = false, length = 30)
	private String dirResidencia;
	
	@Column(name = "pass", nullable = false, length = 25)
	private String password;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name = "ROLES_USUARIOS",
			joinColumns = {@JoinColumn(name = "id_usuario")},
			inverseJoinColumns = {@JoinColumn(name = "id_rol")})
	private Set<Rol> rol = new HashSet<Rol>();
		
	@Column(nullable = false, length = 10)
	private String estado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<Entrega> entraga;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<Reserva> reserva;
	
	
	public String getIdCedula() {
		return idCedula;
	}
	public void setIdCedula(String idCedula) {
		this.idCedula = idCedula;
	}
	public Set<Entrega> getEntraga() {
		return entraga;
	}
	public void setEntraga(Set<Entrega> entraga) {
		this.entraga = entraga;
	}
	public Set<Reserva> getReserva() {
		return reserva;
	}
	public void setReserva(Set<Reserva> reserva) {
		this.reserva = reserva;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getpApellido() {
		return pApellido;
	}
	public void setpApellido(String pApellido) {
		this.pApellido = pApellido;
	}
	public String getsApellido() {
		return sApellido;
	}
	public void setsApellido(String sApellido) {
		this.sApellido = sApellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelf() {
		return telf;
	}
	public void setTelf(String telf) {
		this.telf = telf;
	}
	public String getCiudadResidencia() {
		return ciudadResidencia;
	}
	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}
	public String getDirResidencia() {
		return dirResidencia;
	}
	public void setDirResidencia(String dirResidencia) {
		this.dirResidencia = dirResidencia;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Rol> getRol() {
		return rol;
	}
	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
