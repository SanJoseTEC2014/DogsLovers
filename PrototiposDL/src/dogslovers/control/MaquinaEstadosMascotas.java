package dogslovers.control;

import javax.swing.JOptionPane;

import dogslovers.control.excepciones.EstadoNoExisteException;
import dogslovers.modelo.Suceso;


public class MaquinaEstadosMascotas {
	// Constantes que representan los estados
	public static final String estadoPERDIDA = "Perdida";
	public static final String estadoENCONTRADA = "Encontrada";
	public static final String estadoLOCALIZADA = "Localizada";
	public static final String estadoREFUGIADA = "Refugiada";
	public static final String estadoADOPTADA = "Adoptada";
	public static final String estadoADOPTABLE = "Adoptable";
	public static final String estadoMUERTA = "Muerta";
	public static final String estadoEN_ESPERA_DE_REFUGIO = "En espera de ser Refugiada";
	public static final String estadoEN_ESPERA_DE_ADOPCION = "En espera de ser Adoptada";
	public static final String estadoRECHAZADA_REFUGIADA = "Solicitud de Refugio Rechazada";
	public static final String estadoRECHAZADA_ADOPTADA = "Solicitud de Adopción Rechazada";
	public static final String estadoACEPTADA_REFUGIADA = "Solicitud de Refugio Aceptada";
	public static final String estadoACEPTADA_ADOPTADA = "Solicitud de Adopción Aceptada";
	public static final String estadoEN_ESPERA_CONFIRMACION_LOCALIZADA = "En espera de Confirmación de haber sido Localizada";
	
	//Constantes que representan los eventos
	public static final int eventoPERDIDA = 1;
	public static final int eventoENCUENTRO = 2;
	public static final int eventoLOCALIZADA = 3;
	public static final int eventoREFUGIO = 4;
	public static final int eventoADOPCION = 5;
	public static final int eventoENADOPCION = 6;
	public static final int eventoMUERTE = 7;
	public static final int eventoSOLICITUD_REFUGIO = 8;
	public static final int eventoSOLICITUD_ADOPCION = 9;
	public static final int eventoRECHAZO_SOLICITUD_REFUGIO = 10;
	public static final int eventoRECHAZO_SOLICITUD_ADOPCION = 11;
	public static final int eventoCONFIRMACION_REFUGIO = 12;
	public static final int eventoCONFIRMACION_ADOPCION = 13;
	public static final int eventoCONFIRMACION_LOCALIZADA = 14;
	public static final int eventoRECHAZO_LOCALIZADA = 15;
	
	private static MaquinaEstadosMascotas instanciaSingleton;
	
	private String estadoActualMascota;
	
	// El constructor de la clase es privado para que ningún otro objeto 
	// fuera de la clase le invoque, sólo el método inicializarMaquina
	private MaquinaEstadosMascotas(){
	}
		
	// Evita referencias a null de la instancia Singleton
	private static void inicializarMaquina(){
		instanciaSingleton = new MaquinaEstadosMascotas();
	}
	
	// Obtiene siempre la misma instancia de la Máquina
	public static MaquinaEstadosMascotas getMaquina(){
		if (instanciaSingleton == null){
			inicializarMaquina();
		}
		return instanciaSingleton;
	}
	
	public void setEstadoActual(String pEstado){
		estadoActualMascota = pEstado;
	}
	
	public String getEstadoActual(){
		return estadoActualMascota;
	}
	
	// Método para disparar cambios de estado de la mascota
	public void capturarReporte(int pEvento, Suceso pSuceso){
		switch(pEvento)
		{
			case eventoPERDIDA:
				reportarPerdida(pSuceso);
				break;
				
			case eventoENCUENTRO:
				reportarEncuentro(pSuceso);
				break;
						
			case eventoLOCALIZADA:
				reportarLocalizacion(pSuceso);
				break;
			
			case eventoREFUGIO:
				reportarRefugio(pSuceso);
				break;
			
			case eventoADOPCION:
				reportarAdopcion(pSuceso);
				break;
				
			case eventoENADOPCION:
				reportarEnAdopcion(pSuceso);
				break;
			
			case eventoMUERTE:
				reportarMuerte(pSuceso);
				break;
				
			case eventoSOLICITUD_REFUGIO:
				reportarSolicitudRefugio(pSuceso);
				break;
				
			case eventoSOLICITUD_ADOPCION :
				reportarSolicitudAdopcion(pSuceso);
				break;
				
			case eventoRECHAZO_SOLICITUD_REFUGIO:
				reportarRechazoSolicitudRefugio(pSuceso);
				break;
				
			case eventoRECHAZO_SOLICITUD_ADOPCION:
				reportarRechazoSolicitudAdopcion(pSuceso);
				break;
				
			case eventoCONFIRMACION_ADOPCION:
				reportarConfirmacionSolicitudAdopcion(pSuceso);
				break;
			
			case eventoCONFIRMACION_REFUGIO:
				reportarConfirmacionSolicitudRefugio(pSuceso);
				break;
			
			case eventoCONFIRMACION_LOCALIZADA:
				reportarConfirmacionLocalizada(pSuceso);
				break;
			
			case eventoRECHAZO_LOCALIZADA :
				reportarRechazoLocalizada(pSuceso);
				break;
			
			default:
				throw new EstadoNoExisteException("El evento no existe.");
		}		
	}

	// Métodos que cambian el estado según el evento en el estado actual de la mascota.
	private void reportarPerdida(Suceso pSuceso){
		estadoActualMascota = estadoPERDIDA;	
	}

	private void reportarEncuentro(Suceso pSuceso) {
		estadoActualMascota = estadoENCONTRADA;	
	}

	private void reportarLocalizacion(Suceso pSuceso) {
		switch (estadoActualMascota) {
			case estadoPERDIDA:
				estadoActualMascota = estadoLOCALIZADA;
				break;
			case estadoENCONTRADA:
				estadoActualMascota = estadoEN_ESPERA_CONFIRMACION_LOCALIZADA;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
				"\nCaso no contemplado en el diseño.");
				break;
		}
	}

	private void reportarRefugio(Suceso pSuceso) {
		switch (estadoActualMascota) {
		case estadoENCONTRADA:
			estadoActualMascota = estadoEN_ESPERA_DE_REFUGIO;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;
		
	}
}
	private void reportarAdopcion(Suceso pSuceso) {
		switch (estadoActualMascota) {
		case estadoENCONTRADA:
			estadoActualMascota = estadoEN_ESPERA_DE_ADOPCION;
			break;
		case estadoREFUGIADA:
			estadoActualMascota = estadoEN_ESPERA_DE_ADOPCION;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;		
	  }
	}
	
	private void reportarEnAdopcion(Suceso pSuceso){
		switch (estadoActualMascota) {
		case estadoENCONTRADA:
			estadoActualMascota = estadoADOPTABLE;
		
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;	
		}
	}

	private void reportarMuerte(Suceso pSuceso) {
		switch (estadoActualMascota) {
		case estadoENCONTRADA:
			estadoActualMascota = estadoMUERTA;
			break;
		case estadoADOPTADA:
			estadoActualMascota = estadoMUERTA;
			break;
		case estadoREFUGIADA:
			estadoActualMascota = estadoMUERTA;
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;		
	  }	
	}

	private void reportarSolicitudRefugio(Suceso pSuceso) {
		switch (estadoActualMascota) {
		case estadoENCONTRADA:
			estadoActualMascota = estadoEN_ESPERA_DE_REFUGIO;
			break;
		
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;	
		}	
	}

	private void reportarSolicitudAdopcion(Suceso pSuceso) {
		switch (estadoActualMascota) {
		case estadoENCONTRADA:
			estadoActualMascota = estadoEN_ESPERA_DE_ADOPCION;
			break;
		
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;	
		}		
	}

	private void reportarRechazoSolicitudRefugio(Suceso pSuceso) {
		switch (estadoActualMascota) {
		case  estadoEN_ESPERA_DE_REFUGIO:
			estadoActualMascota = estadoENCONTRADA;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;
	}	
}

	private void reportarRechazoSolicitudAdopcion(Suceso pSuceso) {
		switch (estadoActualMascota) {
		case  estadoEN_ESPERA_DE_ADOPCION:
			estadoActualMascota = estadoADOPTABLE;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;
	}		
}

	private void reportarConfirmacionSolicitudRefugio(Suceso pSuceso) {
		switch (estadoActualMascota) {
		case estadoEN_ESPERA_DE_REFUGIO:
			estadoActualMascota = estadoREFUGIADA;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;		
	  }
	}

	private void reportarConfirmacionSolicitudAdopcion(Suceso pSuceso) {
		switch (estadoActualMascota) {
		case estadoEN_ESPERA_DE_ADOPCION:
			estadoActualMascota = estadoADOPTADA;
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;		
	  }
			
	}
	private void reportarConfirmacionLocalizada(Suceso pSuceso) {
		switch (estadoActualMascota) {
		case estadoEN_ESPERA_CONFIRMACION_LOCALIZADA:
			estadoActualMascota = estadoLOCALIZADA;
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;		
	  }
	}

	private void reportarRechazoLocalizada(Suceso pSuceso) {
		switch (estadoActualMascota) {
			case estadoEN_ESPERA_CONFIRMACION_LOCALIZADA:
				estadoActualMascota = estadoENCONTRADA; 
				break;
			default:
				JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
				"\nCaso no contemplado en el diseño.");
				break;
		}
	}



}
	


