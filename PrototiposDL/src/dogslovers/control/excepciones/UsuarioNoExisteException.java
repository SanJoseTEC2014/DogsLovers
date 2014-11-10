package dogslovers.control.excepciones;

/**	 Clase UsuarioNoExisteException: 
 * 	 Excepci�n en  caso de que un usuario no exista en el sistema.
 *   
 *	 Fecha de creaci�n: 29/10/2014
 * 
 *	@author Isaac Antonio Campos Mes�n 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa Mar�a Molina Corrales 2013006074
 *	@author Luis Andr�s Pe�a Castillo 2014057250 
 *  
 */

public class UsuarioNoExisteException extends Exception {
	public UsuarioNoExisteException(String pString) {
		super(pString);
	}
}
