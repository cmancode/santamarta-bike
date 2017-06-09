package com.cmancode.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmancode.project.model.Bicicleta;
import com.cmancode.project.model.Reserva;
import com.cmancode.project.model.TipoBicicleta;
import com.cmancode.project.service.IBiciService;
import com.cmancode.project.service.IReservaService;
import com.cmancode.project.service.ITipoBiciService;

@Controller
public class FuncionarioController {

	@Autowired
	private ITipoBiciService tipoBiciService;
	
	@Autowired
	private IBiciService biciService;
	
	@Autowired
	private IReservaService reservaService;
	
	
	@RequestMapping(value = "/funcionario", method = RequestMethod.GET)
	public ModelAndView funcionario(ModelAndView model){
		List<TipoBicicleta> tipos = tipoBiciService.listaTipos();

		model.addObject("tiposbicicleta", tipos);
		model.setViewName("funcionario-index");
		return model;
	}
	
	@RequestMapping(value = "/bicicletas-prestadas", method = RequestMethod.GET)
	public ModelAndView funcionarioPrestadas(ModelAndView model){
		List<Reserva> reserva = reservaService.listReserva();
		model.addObject("reservas", reserva);
		
		model.setViewName("funcionario-bicicleta-prestada");
		return model;
	}
	
	@RequestMapping(value = "/bicicletas-disponibles", method = RequestMethod.GET)
	public ModelAndView funcionarioDisponibles(ModelAndView model){
		List<Bicicleta> bici = biciService.listaBicis();
		model.addObject("bicicletas", bici);
		model.setViewName("funcionario-bicicleta-disponible");
		return model;
	}
	
	@RequestMapping(value="/bicicleta-tramite", method = RequestMethod.GET)
	public ModelAndView funcionarioTramite(ModelAndView model){
		List<Reserva> reserva = reservaService.listReserva();
		model.addObject("reservas", reserva);
		
		model.setViewName("funcionario-bicicleta-tramite");
		return model;
	}
	
	@RequestMapping(value="/tramite-D/{idTramite}", method = RequestMethod.GET)
	public ResponseEntity<Reserva> tramiteAprovar(@PathVariable("idTramite") Long idTramite){
		Reserva reserva = null;
		reserva = reservaService.buscarPorId(idTramite);
	
		reserva.setEstado("APROBADA");
		System.out.println(reserva.getId());
		reservaService.actualizarReserva(reserva);
		return new ResponseEntity<Reserva>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/tramite-R/{idTramite}", method = RequestMethod.GET)
	public ResponseEntity<Reserva> tramiteDenegado(@PathVariable("idTramite") Long idTramite){
		Reserva reserva = null;
		Bicicleta bicicleta = null;
		String placa = null;
		reserva = reservaService.buscarPorId(idTramite);
		placa = reserva.getBicicleta().getPlaca();
		bicicleta = biciService.buscarPorId(placa);
		
		bicicleta.setEstado("DISPONIBLE");
		reserva.setEstado("RECHAZADA");
		biciService.editarBici(bicicleta);
		reservaService.actualizarReserva(reserva);
		return new ResponseEntity<Reserva>(HttpStatus.OK);
	}
}
