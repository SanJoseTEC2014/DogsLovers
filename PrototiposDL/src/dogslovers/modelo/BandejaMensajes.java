package dogslovers.modelo;

import java.util.LinkedList;

public class BandejaMensajes {
	private LinkedList<Mensaje> entradaNotificacionesLocalizacion;
	private LinkedList<Mensaje> entradaConfirmacionesLocalizacion;
	private LinkedList<Mensaje> entradaRechazosLocalizacion;
	private LinkedList<Mensaje> entradaSolicitudesRefugio;
	private LinkedList<Mensaje> entradaConfirmacionesRefugio;
	private LinkedList<Mensaje> entradaRechazosRefugio;
	private LinkedList<Mensaje> entradaSolicitudesAdopcion;
	private LinkedList<Mensaje> entradaConfirmacionesAdopcion;
	private LinkedList<Mensaje> entradaRechazosAdopcion;
	private LinkedList<Mensaje> entradaErroresMediador;
	public BandejaMensajes() {
		entradaNotificacionesLocalizacion 	= new LinkedList<Mensaje>();
		entradaConfirmacionesLocalizacion 	= new LinkedList<Mensaje>();
		entradaRechazosLocalizacion 		= new LinkedList<Mensaje>();
		entradaSolicitudesRefugio 			= new LinkedList<Mensaje>();
		entradaConfirmacionesRefugio 		= new LinkedList<Mensaje>();
		entradaRechazosRefugio 				= new LinkedList<Mensaje>();
		entradaSolicitudesAdopcion 			= new LinkedList<Mensaje>();
		entradaConfirmacionesAdopcion 		= new LinkedList<Mensaje>();
		entradaRechazosAdopcion 			= new LinkedList<Mensaje>();
		entradaErroresMediador 				= new LinkedList<Mensaje>();
	}
	
	
	
	public void recibirSolicitudRefugio(Mensaje pSolicitud){
		entradaSolicitudesRefugio.add(pSolicitud);
	}
	
	public void recibirConfirmacionRefugio(Mensaje pSolicitud){
		entradaConfirmacionesRefugio.add(pSolicitud);
	}
	
	public void recibirRechazoRefugio(Mensaje pSolicitud){
		entradaRechazosRefugio.add(pSolicitud);
	}
	
	public void recibirSolicitudAdopcion(Mensaje pSolicitud){
		entradaSolicitudesAdopcion.add(pSolicitud);
	}
	
	public void recibirConfirmacionAdopcion(Mensaje pSolicitud){
		entradaConfirmacionesAdopcion.add(pSolicitud);
	}
	
	public void recibirRechazoAdopcion(Mensaje pSolicitud){
		entradaRechazosAdopcion.add(pSolicitud);
	}
	
	public void recibirMensajeError(Mensaje pError){
		entradaErroresMediador.add(pError);
	}
	
}