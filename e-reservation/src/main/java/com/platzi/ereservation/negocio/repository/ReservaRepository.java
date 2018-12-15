/**
 * 
 */
package com.platzi.ereservation.negocio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.modelo.Reserva;

/**
 * @author martosfre
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva, String> {

	/**
	 * Método para consultar las reservas por cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Query("Select r from Reserva r where r.cliente =:cliente")
	public List<Reserva> findByCliente(Cliente cliente);
	
	/**
	 * Definición de método para consultar las reservas por la fecha de ingreso en
	 * base a un rango de fechas
	 * 
	 * @param fechaInicio
	 * @param fechaSalida
	 * @return
	 */
	@Query("Select r from Reserva r where r.fechaIngresoRes =:fechaInicio  and r.fechaSalidaRes =:fechaSalida")
	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio, @Param("fechaSalida") Date fechaSalida);

	/**
	 * Definición de método para buscar una reserva por su código
	 * @param codigoReserva
	 * @return
	 */
	public Reserva findByCodigoRes(String codigoReserva);
}
