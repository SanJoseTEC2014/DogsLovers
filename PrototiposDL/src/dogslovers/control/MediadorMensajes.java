package dogslovers.control;

import javax.swing.JOptionPane;

import dogslovers.modelo.Mensaje;
import dogslovers.modelo.Mascota;
import dogslovers.modelo.BandejaMensajes;


public class MediadorMensajes {

	private static BandejaMensajes bandeja;
	
	public static void recibirMensajeUsuario(Mensaje pMensaje){
		notificarMaquinaEstados(pMensaje);
		
			
	}
	public static void enviarMensajeUsuario(Mensaje pMensaje){
		
		switch(pMensaje.getTipo()){
		case 8:
			bandeja.recibirSolicitudRefugio(pMensaje);
			break;
		case 12:
			bandeja.recibirConfirmacionRefugio(pMensaje);
			break;
		case 10:
			bandeja.recibirRechazoRefugio(pMensaje);
			break;
		case 9:
			bandeja.recibirSolicitudAdopcion(pMensaje);
			break;
		case 13:
			bandeja.recibirConfirmacionAdopcion(pMensaje);
			break;
		case 11:
			bandeja.recibirRechazoAdopcion(pMensaje);
			break;
		case 3:
			bandeja.recibirNotificacionLocalizacion(pMensaje);
			break;
		case 14:
			bandeja.recibirConfirmacionesLocalizacion(pMensaje);
			break;
		case 15:
			bandeja.recibirRechazosLocalizacion(pMensaje);
			break;
		default:
			bandeja.recibirMensajeError(pMensaje);
			break;							
		}
		
	}
	
	public static void notificarMaquinaEstados(Mensaje pMensaje){
		pMensaje.getMascotaAsociada().notificar();
			
	}
		
}