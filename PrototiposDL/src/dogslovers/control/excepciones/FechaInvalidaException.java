package dogslovers.control.excepciones;

/**	 Clase FechaInvalidaException: 
 * 	 Excepción en caso de que una fecha sea inválida.
 *   
 *	 Fecha de creación: 29/10/2014
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
 *  
 */

public class FechaInvalidaException extends Exception {
	public FechaInvalidaException(String msg){
		super(msg);
	}
	public FechaInvalidaException(String msg, Throwable cause){
		super(msg, cause);
	}
}
