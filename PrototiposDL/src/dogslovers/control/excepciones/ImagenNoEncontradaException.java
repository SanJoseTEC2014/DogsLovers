package dogslovers.control.excepciones;

/**	 Clase ImagenNoEncontradaException: 
 * 	 Excepci�n en caso de que una imagen no exista o no pueda ser
 *   encontrada.
 *   
 *	 Fecha de creaci�n: 29/10/2014
 * 
 *	@author Isaac Antonio Campos Mes�n 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa Mar�a Molina Corrales 2013006074
 *	@author Luis Andr�s Pe�a Castillo 2014057250 
 *  
 */

import java.io.IOException;

public class ImagenNoEncontradaException extends IOException {
	public ImagenNoEncontradaException(String msg){
		super(msg);
	}
}
