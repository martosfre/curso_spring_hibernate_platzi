/**
 * 
 */
package com.platzi.ereservation.vista.resources.vo;

import lombok.Data;

/**
 * Clase que representa la tabla Cliente
 * @author martosfre
 *
 */
@Data
public class ClienteVO {
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
		
}
