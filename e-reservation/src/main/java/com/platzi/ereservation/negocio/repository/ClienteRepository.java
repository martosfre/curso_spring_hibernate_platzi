/**
 * 
 */
package com.platzi.ereservation.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platzi.ereservation.modelo.Cliente;

/**
 * Interface para definir las operaciones de bdd relacionadas con cliente
 * @author martosfre
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String>{

	/**
	 * Definición de método para buscar los clientes por su apellido
	 * @param apellidoCli
	 * @return
	 */
	public List<Cliente> findByApellidoCli(String apellidoCli);
	
	/**
	 * Definición de método para buscar un cliente por su identificación
	 * @param identificacionCli
	 * @return
	 */
	public Cliente findByIdentificacion(String identificacionCli);
	
	/**
	 * Definición de método para buscar un cliente por su cuenta de email
	 * @param email
	 * @return
	 */
	@Query("Select c from Cliente c where c.emailCli like %:email")
	public Cliente findByEmailAccount(@Param("email") String email);
	
}
