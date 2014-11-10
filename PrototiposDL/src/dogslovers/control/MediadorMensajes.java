package dogslovers.control;

/**	 Controlador MediadorMensajes: 
 * 	 Este controlador se encarga de las solicitudes
 *   que los usuarios mandan a otros usuarios para adoptar
 *   las mascotas o para ser casa cuna.
 * 
 *	 Fecha de creaci�n: 9/11/2014
 * 
 *	@author Isaac Antonio Campos Mes�n 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa Mar�a Molina Corrales 2013006074
 *	@author Luis Andr�s Pe�a Castillo 2014057250 
 *  
 */

import dogslovers.control.excepciones.UsuarioNoExisteException;
import dogslovers.modelo.Mensaje;


public class MediadorMensajes {
	
	public static void recibirMensaje(Mensaje pMensaje) throws UsuarioNoExisteException{
		pMensaje.getMascotaAsociada().notificar();
		Principal.getUsuarioListaBlanca(pMensaje.getNickDestinario()).recibirMensaje(pMensaje);
	}
		
}