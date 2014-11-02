package dogslovers.control;

import dogslovers.control.excepciones.EstadoNoExisteException;
import dogslovers.modelo.Suceso;
import dogslovers.modelo.Usuario;
import dogslovers.modelo.Mascota;

public class MaquinaEstadosMascotas {
	
	//Constantes que representan los eventos
	
	public static final Integer eventoPERDIDA = 1;
	public static final Integer eventoENCUENTRO = 2;
	public static final Integer eventoLOCALIZADA = 3;
	public static final Integer eventoREFUGIO = 4;
	public static final Integer eventoADOPCION = 5;
	public static final Integer eventoMUERTE = 6;
	public static final Integer eventoSOLICITUD_REFUGIO = 7;
	public static final Integer eventoSOLICITUD_ADOPCION = 8;
	public static final Integer eventoRECHAZO_SOLICITUD_REFUGIO = 9;
	public static final Integer eventoRECHAZO_SOLICITUD_ADOPCION = 10;
	public static final Integer eventoCONFIRMACION_ADOPCION = 11;
	public static final Integer eventoCONFIRMACION_REFUGIO = 12;
	public static final Integer eventoNOTIFICACION_DE_LOCALIZACION = 13;
	public static final Integer eventoCONFIRMACION_LOCALIZADA = 14;
	public static final Integer eventoRECHAZO_LOCALIZADA = 15;
	
	// Constantes que representan los estados
	public static final String estadoPERDIDA = "Perdida";
	public static final String estadoENCONTRADA = "Encontrada";
	public static final String estadoLOCALIZADA = "Localizada";
	public static final String estadoREFUGIADA = "Refugiada";
	public static final String estadoADOPTADA = "Adoptada";
	public static final String estadoMUERTA = "Muerta";
	public static final String estadoEN_ESPERA_DE_REFUGIO = "En espera de ser Refugiada";
	public static final String estadoEN_ESPERA_DE_ADOPCION = "En espera de ser Adoptada";
	public static final String estadoRECHAZADA_REFUGIADA = "Solicitud de Refugio Rechazada";
	public static final String estadoRECHAZADA_ADOPTADA = "Solicitud de Adopci�n Rechazada";
	public static final String estadoACEPTADA_REFUGIADA = "Solicitud de Refugio Aceptada";
	public static final String estadoACEPTADA_ADOPTADA = "Solicitud de Adopci�n Aceptada";
	public static final String estadoEN_ESPERA_DE_LOCALIZACION = "En espera de ser Localizada";
	public static final String estadoACEPTADA_LOCALIZADA = "Confirmaci�n de Localizaci�n Aprobada";
	public static final String estadoRECHAZADA_LOCALIZADA = "Confirmaci�n de Localizaci�n Rechazada";
	
	private static MaquinaEstadosMascotas instanciaSingleton;
	
	private Integer estadoActualMascota;
	
	// El constructor de la clase es privado para que ning�n otro objeto 
	// fuera de la clase le invoque, s�lo el m�todo inicializarMaquina
	private MaquinaEstadosMascotas(){
	}
		
	// Evita referencias a null de la instancia Singleton
	private static void inicializarMaquina(){
		instanciaSingleton = new MaquinaEstadosMascotas();
	}
	
	// Obtiene siempre la misma instancia de la M�quina
	public static MaquinaEstadosMascotas getMaquina(){
		if (instanciaSingleton == null){
			inicializarMaquina();
		}
		return instanciaSingleton;
	}
	
	public void setEstadoActual(Integer pEstado){
		estadoActualMascota = pEstado;
	}
	
	public Integer getEstadoActual(){
		return estadoActualMascota;
	}
	
	// M�todo para disparar cambios de estado de la mascota
	public void CapturarReporte(int evento, Suceso pSuceso){
		switch(estadoActualMascota){
			case estadoPERDIDA:
				reportarPerdida(evento);
				break;
				
			case estadoENCONTRADA:
				reportarEncuentro(evento);
				break;
			
			case estadoLOCALIZADA:
				reportarLocalizacion(evento);
				break;
			
			case estadoREFUGIADA:
				reportarRefugio(evento);
				break;
			
			case estadoADOPTADA:
				reportarAdopcion(evento);
				break;
			
			case estadoMUERTA:
				reportarMuerte(evento);
				break;
				
			case estadoEN_ESPERA_DE_REFUGIO:
				reportarSolicitudRefugio(evento);
				break;
				
			case estadoEN_ESPERA_DE_ADOPCION :
				reportarSolicitudAdopcion(evento);
				break;
				
			case estadoRECHAZADA_REFUGIADA:
				reportarRechazoSolicitudRefugio(evento);
				break;
				
			case estadoRECHAZADA_ADOPTADA:
				reportarRechazoSolicitudAdopcion(evento);
				break;
				
			case estadoACEPTADA_ADOPTADA:
				reportarConfirmacionAdopcion(evento);
				break;
			
			case estadoACEPTADA_REFUGIADA:
				reportarConfirmacionRefugio(evento);
				break;
				
			case  estadoEN_ESPERA_DE_LOCALIZACION :
				reportarRechazoLocalizada(evento);
				break;
			
			case estadoACEPTADA_LOCALIZADA:
				reportarConfirmacionLocalizada(evento);
				break;
			
			case  estadoRECHAZADA_LOCALIZADA :
				reportarRechazoLocalizada(evento);
				break;
			
			default:
				throw new EstadoNoExisteException("El estado no existe.");
		}		
	}

	// M�todos que cambian el estado seg�n el evento en el estado actual de la mascota.
	



}
	


