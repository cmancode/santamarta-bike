package com.cmancode.project.service;

import java.util.List;

import com.cmancode.project.model.Reserva;

public interface IReservaService {
	
	public void reservar(Reserva reserva);
	public void actualizarReserva(Reserva reserva);
	public Reserva buscarPorId(Long id);
	public List<Reserva> listReserva();
	public boolean existeReserva(Reserva novedad);
	
}
