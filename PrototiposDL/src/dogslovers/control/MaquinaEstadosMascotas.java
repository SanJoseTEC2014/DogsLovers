package dogslovers.control;

import dogslovers.control.excepciones.EstadoNoExisteException;
import dogslovers.modelo.Suceso;
import dogslovers.modelo.Usuario;
import dogslovers.modelo.Mascota;

public class MaquinaEstadosMascotas {
	
	//Constantes que representan los eventos
	
	public static final int eventoPERDIDA = 1;
	public static final int eventoENCUENTRO = 2;
	public static final int eventoLOCALIZADA = 3;
	public static final int eventoREFUGIO = 4;
	public static final int eventoADOPCION = 5;
	public static final int eventoMUERTE = 6;
	public static final int eventoSOLICITUD_REFUGIO = 7;
	public static final int eventoSOLICITUD_ADOPCION = 8;
	public static final int eventoRECHAZO_SOLICITUD_REFUGIO = 9;
	public static final int eventoRECHAZO_SOLICITUD_ADOPCION = 10;
	public static final int eventoCONFIRMACION_ADOPCION = 11;
	public static final int eventoCONFIRMACION_REFUGIO = 12;
	public static final int eventoNOTIFICACION_DE_LOCALIZACION = 13;
	public static final int eventoCONFIRMACION_LOCALIZADA = 14;
	public static final int eventoRECHAZO_LOCALIZADA = 15;
	
	//Constantes que representan los estados
	
	public static final int estadoPERDIDA = 1;
	public static final int estadoENCONTRADA= 2;
	public static final int estadoLOCALIZADA = 3;
	public static final int estadoREFUGIADA = 4;
	public static final int estadoADOPTADA = 5;
	public static final int estadoMUERTA= 6;
	public static final int estadoEN_ESPERA_DE_REFUGIO = 7;
	public static final int estadoEN_ESPERA_DE_ADOPCION = 8;
	public static final int estadoRECHAZADA_REFUGIADA = 9;
	public static final int estadoRECHAZADA_ADOPTADA = 10;
	public static final int estadoACEPTADA_ADOPTADA= 11;
	public static final int estadoACEPTADA_REFUGIADA = 12;
	public static final int estadoEN_ESPERA_DE_LOCALIZACION = 13;
	public static final int estadoACEPTADA_LOCALIZADA = 14;
	public static final int estadoRECHAZADA_LOCALIZADA = 15;
	
	//Atributo que representa el estado actual de la mascota
	
	private int estado = estadoPERDIDA;
	
	public MaquinaEstadosMascotas(int estado){
		this.estado = estado;
	}
	
	public int getEstado(){
		return estado;
	}
	
	//Metodo para disparar eventos(cambiar el estado de la mascota)
	
	public void CapturarReporte(int evento, Suceso pSuceso){
		switch(estado){
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
				throw new EstadoNoExisteException("El estado no existe");
		}		
	}
}


	//Metodos que cambian el estado según el evento en un estado particular.





	


