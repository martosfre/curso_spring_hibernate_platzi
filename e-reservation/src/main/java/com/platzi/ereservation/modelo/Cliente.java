/**
 * 
 */
package com.platzi.ereservation.modelo;

import java.util.Set;

import lombok.Data;

/**
 * Clase que representa la tabla Cliente
 * @author martosfre
 *
 */
@Data
public class Cliente {
	private String idCli;
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
	
	private Set<Reserva> reservas;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
}
