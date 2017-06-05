package com.cmancode.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmancode.project.dao.IBicicletaDAO;
import com.cmancode.project.model.Bicicleta;
import com.cmancode.project.model.Reserva;
import com.cmancode.project.model.Sitio;
import com.cmancode.project.model.Usuario;
import com.cmancode.project.service.IBiciService;
import com.cmancode.project.service.IReservaService;
import com.cmancode.project.service.ISitioService;
import com.cmancode.project.service.IUsuarioService;

@Controller
public class ReservaController {

	@Autowired
	private IReservaService reservaService;
	@Autowired
	private ISitioService sitioService;
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IBiciService bicicletaService;
	
	@RequestMapping(value = "realizar-prestamos", method = RequestMethod.GET)
	public ModelAndView realizarPrestamo(ModelAndView model){
		List<Sitio> sitios = sitioService.listSitios();
		model.addObject("sities", sitios);
		model.setViewName("create-reserva");
		return model;
	}
	@RequestMapping(value = "list-reservas", method = RequestMethod.GET)
	public ModelAndView reservas(ModelAndView model){
		List<Reserva> reservas = reservaService.listReserva();
		model.addObject("reser", reservas);
		model.setViewName("reservas");
		return model;
	}
	@RequestMapping(value="/bicicletas-sitios/{idSitio}", method = RequestMethod.GET)
	public ResponseEntity< List<Object> > bicicletasDeSitios(@PathVariable("idSitio") Long idSitio){
		List<Object> bicicletas = sitioService.bicicletasDeSitios(idSitio);
		if(bicicletas == null){
			return new ResponseEntity< List<Object> >(HttpStatus.CONFLICT);
		}
		return new ResponseEntity< List<Object> > ( bicicletas, HttpStatus.OK);
	}
	@RequestMapping(value = "/verificar-user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> consultarPorId(@PathVariable("id") String id){
		Usuario usuario = null;
		usuario = usuarioService.buscarPorId(id);
		if(usuario == null){
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	@RequestMapping(value = "radicar-reserva", method = RequestMethod.POST)
	public ResponseEntity<Reserva> radicarReserva(@RequestBody Reserva reserva){
		Bicicleta bicicleta = bicicletaService.buscarPorId(reserva.getBicicleta().getPlaca());
		bicicleta.setEstado("NO DISPONIBLE");
		reservaService.reservar(reserva);
		bicicletaService.editarBici(bicicleta);
		return new ResponseEntity<Reserva>(reserva, HttpStatus.OK);
	}
}
