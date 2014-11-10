package dogslovers.control.excepciones;

/**	 Clase UsuarioNoExisteException: 
 * 	 Excepción en  caso de que un usuario no exista en el sistema.
 *   
 *	 Fecha de creación: 29/10/2014
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
 *  
 */

public class UsuarioNoExisteException extends Exception {
	public UsuarioNoExisteException(String pString) {
		super(pString);
	}
}
