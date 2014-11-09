package dogslovers.control;

import dogslovers.control.excepciones.UsuarioNoExisteException;
import dogslovers.modelo.Mensaje;


public class MediadorMensajes {
	
	public static void recibirMensaje(Mensaje pMensaje) throws UsuarioNoExisteException{
		pMensaje.getMascotaAsociada().notificar();
		Principal.getUsuarioListaBlanca(pMensaje.getNickDestinario()).recibirMensaje(pMensaje);
	}
		
}