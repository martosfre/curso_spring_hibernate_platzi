/**
 * 
 */
package com.platzi.ereservation.vista.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.modelo.Reserva;
import com.platzi.ereservation.negocio.services.ClienteService;
import com.platzi.ereservation.negocio.services.ReservaService;
import com.platzi.ereservation.vista.resources.vo.ReservaVO;

/**
 * Clase que representa el servicio web de Reserva
 * @author martosfre
 *
 */
@RestController
@RequestMapping("/api/reserva")
public class ReservaResource {

	private final ReservaService reservaService;
	private final ClienteService clienteService;
	
	public ReservaResource(ReservaService reservaService, ClienteService clienteService) {
		this.reservaService = reservaService;
		this.clienteService = clienteService;
	}
	
	@PostMapping
	public ResponseEntity<Reserva> createReserva(@RequestBody ReservaVO reservaVO){
		Cliente cliente = clienteService.findByIdentificacion(reservaVO.getCliente().getIdentificacionCli());
		Reserva reserva = new Reserva();
		reserva.setCliente(cliente);
		reserva.setCodigoRes(reservaVO.getCodigoRes());
		reserva.setFechaIngresoRes(reservaVO.getFechaIngresoRes());
		reserva.setFechaSalidaRes(reservaVO.getFechaSalidaRes());
		reserva.setCantidadPersonasRes(reservaVO.getCantidadPersonasRes());
		reserva.setDescripcionRes(reservaVO.getDescripcionRes());
		
		return new ResponseEntity<>(this.reservaService.create(reserva), HttpStatus.CREATED);
	}
	
	@PutMapping("/{codigoReserva}")
	public ResponseEntity<Reserva> updateReserva(@PathVariable("codigoReserva") String codigoReserva,
			ReservaVO reservaVO) {

		Reserva reserva = this.reservaService.findByCodigoRes(codigoReserva);
		if (reserva == null) {
			return new ResponseEntity<Reserva>(HttpStatus.NOT_FOUND);
		} else {
			Cliente cliente = clienteService.findByIdentificacion(reservaVO.getCliente().getIdentificacionCli());
			reserva.setCliente(cliente);
			reserva.setFechaIngresoRes(reservaVO.getFechaIngresoRes());
			reserva.setFechaSalidaRes(reservaVO.getFechaSalidaRes());
			reserva.setCantidadPersonasRes(reservaVO.getCantidadPersonasRes());
			reserva.setDescripcionRes(reservaVO.getDescripcionRes());
		}
		return new ResponseEntity<>(this.reservaService.update(reserva), HttpStatus.OK);
	}

	@DeleteMapping("/{codigoReserva}")
	public void removeCliente(@PathVariable("codigoReserva") String codigoReserva) {
		Reserva reserva = this.reservaService.findByCodigoRes(codigoReserva);
		if (reserva != null) {
			this.reservaService.delete(reserva);
		}
	}

	@GetMapping
	public ResponseEntity<List<Reserva>> findAll() {
		return ResponseEntity.ok(this.reservaService.findAll());
	}
}
