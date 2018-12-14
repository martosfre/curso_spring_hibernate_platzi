/**
 * 
 */
package com.platzi.ereservation.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.ereservation.modelo.Reserva;

/**
 * @author martosfre
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva, String> {
}
