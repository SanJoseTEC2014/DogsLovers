package dogslovers.control;

/**	 Controlador MediadorMensajes: 
 * 	 Este controlador se encarga de las solicitudes
 *   que los usuarios mandan a otros usuarios para adoptar
 *   las mascotas o para ser casa cuna.
 * 
 *	 Fecha de creación: 9/11/2014
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
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