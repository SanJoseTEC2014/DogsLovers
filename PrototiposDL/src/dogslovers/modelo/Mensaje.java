package dogslovers.modelo;

public class Mensaje {
	// Tipos de Mensaje
	public static final int notificacion_SOLICITUD_REFUGIO = 8;
	public static final int notificacion_CONFIRMACION_SOLICITUD_REFUGIO = 12;
	public static final int notificacion_RECHAZO_SOLICITUD_REFUGIO = 10;
	
	public static final int notificacion_SOLICITUD_ADOPCION = 9;
	public static final int notificacion_CONFIRMACION_SOLICITUD_ADOPCION = 13;
	public static final int notificacion_RECHAZO_SOLICITUD_ADOPCION = 11;
	
	public static final int notificacion_LOCALIZACION = 3;
	public static final int notificacion_CONFIRMACION_LOCALIZACION = 14;
	public static final int notificacion_RECHAZO_LOCALIZACION = 15;
	
	private int tipo;
	private Mascota mascotaAsociada;
	private String nickDestinario;
	public Mensaje(int pTipo, Mascota pReferencia, String pNick){
		tipo = pTipo;
		mascotaAsociada = pReferencia;
		nickDestinario = pNick;
	}
	public int getTipo() {
		return tipo;
	}
	public Mascota getMascotaAsociada() {
		return mascotaAsociada;
	}
	public String getNickDestinario() {
		return nickDestinario;
	}
}
