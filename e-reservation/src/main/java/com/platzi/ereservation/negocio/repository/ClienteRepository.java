/**
 * 
 */
package com.platzi.ereservation.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.ereservation.modelo.Cliente;

/**
 * Interface para definir las operaciones de bdd relacionadas con cliente
 * @author martosfre
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
}
