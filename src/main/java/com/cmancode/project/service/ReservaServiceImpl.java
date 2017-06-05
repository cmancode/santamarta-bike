package com.cmancode.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmancode.project.dao.IReservaDAO;
import com.cmancode.project.exceptions.InstanceNotFoundException;
import com.cmancode.project.model.Reserva;

@Service("serviceReserva")
@Transactional
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	private IReservaDAO reservaDao;
	
	@Override
	@Transactional
	public void reservar(Reserva reserva) {
		reservaDao.save(reserva);
	}
	@Override
	@Transactional
	public void actualizarReserva(Reserva reserva) {
		reservaDao.save(reserva);
	}
	@Override
	@Transactional
	public Reserva buscarPorId(Long id) {
		Reserva reserva = null;
		try {
			reserva = reservaDao.find(id);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return reserva;
	}
	@Override
	@Transactional
	public List<Reserva> listReserva() {
		List<Reserva> reservas = null;
		try {
			reservas = reservaDao.findAll();
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	@Override
	@Transactional
	public boolean existeReserva(Reserva reserva) {
		boolean existio;
		Long id = new Long(reserva.getId());
		existio = reservaDao.exists(id);
		return existio;
	}
}
