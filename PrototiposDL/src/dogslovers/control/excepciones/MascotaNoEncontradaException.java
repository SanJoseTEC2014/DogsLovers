package dogslovers.control.excepciones;

/**	 Clase MascotaNoEncontradaException: 
 * 	 Excepción en caso de que una mascota no exista en el sistema.
 *   
 *	 Fecha de creación: 29/10/2014
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
 *  
 */
public class MascotaNoEncontradaException extends Exception {

	public MascotaNoEncontradaException(String string){
		super (string);
	}

}
