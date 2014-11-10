package dogslovers.control.excepciones;

/**	 Clase FechaInvalidaException: 
 * 	 Excepci�n en caso de que una fecha sea inv�lida.
 *   
 *	 Fecha de creaci�n: 29/10/2014
 * 
 *	@author Isaac Antonio Campos Mes�n 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa Mar�a Molina Corrales 2013006074
 *	@author Luis Andr�s Pe�a Castillo 2014057250 
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
