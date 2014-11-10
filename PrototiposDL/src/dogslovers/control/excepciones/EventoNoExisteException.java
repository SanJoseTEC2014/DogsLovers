package dogslovers.control.excepciones;

/**	 Clase EventoNoExisteException: 
 *  Excepción en caso de que un evento en la máquina de estados de las mascotas
 *  no exista.
 *   
 *	 Fecha de creación: 29/10/2014
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
 *  
 */

public class EventoNoExisteException extends IllegalArgumentException {
	public EventoNoExisteException(String pString) {
		super(pString);
	}
}