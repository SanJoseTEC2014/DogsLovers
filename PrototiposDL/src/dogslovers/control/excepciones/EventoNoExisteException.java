package dogslovers.control.excepciones;

/**	 Clase EventoNoExisteException: 
 *  Excepci�n en caso de que un evento en la m�quina de estados de las mascotas
 *  no exista.
 *   
 *	 Fecha de creaci�n: 29/10/2014
 * 
 *	@author Isaac Antonio Campos Mes�n 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa Mar�a Molina Corrales 2013006074
 *	@author Luis Andr�s Pe�a Castillo 2014057250 
 *  
 */

public class EventoNoExisteException extends IllegalArgumentException {
	public EventoNoExisteException(String pString) {
		super(pString);
	}
}