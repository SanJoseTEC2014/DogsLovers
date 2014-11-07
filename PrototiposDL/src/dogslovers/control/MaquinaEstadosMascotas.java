package dogslovers.control;

import javax.swing.JOptionPane;

import dogslovers.control.excepciones.EventoNoExisteException;

public class MaquinaEstadosMascotas {
	// Constantes que representan los estados
	public static final String estadoPERDIDA = "Perdida";
	public static final String estadoENCONTRADA = "Encontrada";
	
	public static final String estadoEN_ESPERA_DE_REFUGIO = "En espera de ser Refugiada";
	public static final String estadoREFUGIADA = "Refugiada";
	
	public static final String estadoADOPTABLE = "Adoptable";
	public static final String estadoEN_ESPERA_DE_ADOPCION = "En espera de ser Adoptada";
	public static final String estadoADOPTADA = "Adoptada";
		
	public static final String estadoLOCALIZADA = "Localizada";
	public static final String estadoEN_ESPERA_CONFIRMACION_LOCALIZADA = "En espera de Confirmación de haber sido Localizada";
	
	public static final String estadoMUERTA = "Muerta";
	
	//Constantes que representan los eventos
	public static final int eventoLOCALIZACION = 1;
	public static final int eventoEN_ADOPCION = 2;
	public static final int eventoREFUGIO = 3;
	public static final int eventoADOPCION = 4;
	public static final int eventoMUERTE = 5;
	
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
	
	public void setEstadoPorValidar(String pEstado){
		estadoActualMascota = pEstado;
	}
	
	public String getEstadoValidado(){
		return estadoActualMascota;
	}
	
	// Método para disparar cambios de estado de la mascota
	public void capturarReporte(int pEvento){
		switch(pEvento)
		{
			case eventoLOCALIZACION:
				reportarLocalizada();
				break;
			
			case eventoEN_ADOPCION:
				reportarAdoptable();
				break;
				
			case eventoREFUGIO:
				reportarRefugiada();
				break;
				
			case eventoADOPCION:
				reportarAdoptada();
				break;
			
			case eventoMUERTE:
				reportarMuerta();
				break;
				
			default:
				throw new EventoNoExisteException("El evento no existe.");
		}		
	}

	// Métodos que cambian el estado según el evento en el estado actual de la mascota.

	private void reportarLocalizada() {
		switch (estadoActualMascota) {
			case estadoPERDIDA:
				estadoActualMascota = estadoLOCALIZADA;
				break;
			case estadoENCONTRADA:
				estadoActualMascota = estadoEN_ESPERA_CONFIRMACION_LOCALIZADA;
				break;
			case estadoEN_ESPERA_CONFIRMACION_LOCALIZADA:
				estadoActualMascota = estadoLOCALIZADA;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
				"\nCaso no contemplado en el diseño.");
				break;
		}
	}

	private void reportarRefugiada() {
		switch (estadoActualMascota) {
		
		case estadoENCONTRADA:
			estadoActualMascota = estadoREFUGIADA;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;
		}
	}
	
	private void reportarAdoptada() {
		switch (estadoActualMascota) {
		
		case estadoADOPTABLE:
			estadoActualMascota = estadoADOPTADA;
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;		
		}
	}
	
	private void reportarAdoptable(){
		switch (estadoActualMascota) {
		
		case estadoENCONTRADA:
			estadoActualMascota = estadoADOPTABLE;
		
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;	
		}
	}

	private void reportarMuerta() {
		switch (estadoActualMascota) {
		case estadoENCONTRADA:
		case estadoADOPTADA:
		case estadoREFUGIADA:
			estadoActualMascota = estadoMUERTA;
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Contacte al equipo de desarrollo."+
			"\nCaso no contemplado en el diseño.");
			break;		
	  }	
	}

	/**
	 * TODO Existe un dilema con éstos métodos, por lo que se requiere analizar
	 * con mayor detalle si los eventos asociados a estos reportes son necesarios. 
	 */
	/*
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
	*/


}
	


