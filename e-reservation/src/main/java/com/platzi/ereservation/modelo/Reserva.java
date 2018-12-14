/**
 * 
 */
package com.platzi.ereservation.modelo;

import java.util.Date;

import lombok.Data;

/**
 * Clase que representa la tabla reserva
 * @author martosfre
 *
 */
@Data
public class Reserva {
	private String idRes;
	private Date fechaIngresoRes;
	private Date fechaSalidaRes;
	private int cantidadPersonasRes;
	private String descripcionRes;
	private Cliente cliente;
}
