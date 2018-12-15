package com.platzi.ereservation.negocio.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.modelo.Reserva;
import com.platzi.ereservation.negocio.repository.ReservaRepository;

/**
 * Clase para definir los servicios de reserva
 * @author martosfre
 *
 */
@Service
@Transactional(readOnly = true)
public class ReservaService {

	private final ReservaRepository reservaRepository;
	
	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	/**
	 * Método para realizar la operación de guardar una reserva
	 * 
	 * @param reserva
	 * @return
	 */
	@Transactional
	public Reserva create(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}

	/**
	 * Método para realizar la operación de actualizar una reserva
	 * 
	 * @param reserva
	 * @return
	 */
	@Transactional
	public Reserva update(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}

	/**
	 * Método para realizar la operación de eliminar una reserva
	 * 
	 * @param reserva
	 */
	@Transactional
	public void delete(Reserva reserva) {
		this.reservaRepository.delete(reserva);
	}

	
	/**
	 * Método para consultar todos las reservas
	 * @return
	 */
	public List<Reserva> findAll(){
		return this.reservaRepository.findAll();
	}
	
	/**
	 * Método para consultar las reservas por un cliente en específico
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Reserva> findByCliente(Cliente cliente){
		return this.reservaRepository.findByCliente(cliente);
	}
	
	/**
	 * Método para consultar las reservas por la fecha de ingreso en
	 * base a un rango de fechas
	 * 
	 * @param fechaInicio
	 * @param fechaSalida
	 * @return
	 */
	public List<Reserva> find(Date fechaInicio, Date fechaSalida){
		return this.reservaRepository.find(fechaInicio, fechaSalida);
	}
	
}
