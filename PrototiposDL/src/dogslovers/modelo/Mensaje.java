package dogslovers.modelo;

import dogslovers.control.Principal;

public class Mensaje {
	// TODO Redactar descripciones de los tipos de Mensaje
	public static final String notificacion_SOLICITUD_REFUGIO = "wat1";
	public static final String notificacion_CONFIRMACION_SOLICITUD_REFUGIO = "wat2";
	public static final String notificacion_RECHAZO_SOLICITUD_REFUGIO = "wat3";
	
	public static final String notificacion_SOLICITUD_ADOPCION = "wat4";
	public static final String notificacion_CONFIRMACION_SOLICITUD_ADOPCION = "wat5";
	public static final String notificacion_RECHAZO_SOLICITUD_ADOPCION = "wat6";
	
	public static final String notificacion_POSIBLE_LOCALIZACION =
		" notificarle que posiblemente localizó a ";
	public static final String notificacion_CONFIRMACION_LOCALIZACION = 
		" confirmarle que localizó a ";
	public static final String notificacion_RECHAZO_LOCALIZACION = 
		" informarle que se rechazó su notificación de localización de ";	
	
	private Mascota mascotaAsociada;
	private Suceso suceso;
	private String nickDestinario;
	
	public Mensaje(Mascota pReferencia, Suceso pSuceso, String pNickDestinatario){
		mascotaAsociada = pReferencia;
		suceso = pSuceso; 
		nickDestinario = pNickDestinatario;
	}
	
	public Mascota getMascotaAsociada() {
		return mascotaAsociada;
	}
	public Suceso getSuceso() {
		return suceso;
	}
	public String getNickDestinario() {
		return nickDestinario;
	}
	public String toString(){
		return "El usuario " + suceso.getNick()
			+ " desea" + suceso.getDescripcion()
			+ " la siguiente mascota: \n" + mascotaAsociada.toString()
			+ "Puede contactarle al "; 
	}
}
