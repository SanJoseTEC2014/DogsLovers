/**
 * Controlador : Emparejador
 * Se encarga de realizar el match correspondiente en un lapso definido por el usuario
 * con todas las mascotas reportadas como propias con las mascotas que estén reportadas en 
 * el sistema como: "encontradas","perdidas","refugiadas", "adoptadas", "localizadas" o "muertas".
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
 *
 *	Fecha de creación: 28/10/2014
 */
package dogslovers.control;

import java.util.ArrayList;

import javax.mail.*;
import javax.swing.*;

import dogslovers.modelo.ColeccionMascotas;
import dogslovers.modelo.CondicionesRefugio;
import dogslovers.modelo.Usuario;
import dogslovers.modelo.Mascota;
import dogslovers.control.Principal;

public class Emparejador {


	public static void rutinaMatch(Usuario pUsuario){
		// Esta función es invocada cada vez que "transcurre un día". 
		// La rutina de emparejamiento escoge la lista de mascotas perdidas de pUsuario.
		// Se intenta enviar un correo al usuario en el lapso de tiempo definido por este.
		
		switch (pUsuario.getLapsoEmparejamiento()){
			case "diario" : {
				for (Mascota mascota : ColeccionMascotas.getPerdidas(pUsuario)){
					emparejarAutomatico(mascota, pUsuario);
				}
			}
			break;
			case "semanal": {
				if (pUsuario.getDiasUltimoEmparejamiento() == 7){
					for (Mascota mascota : ColeccionMascotas.getPerdidas(pUsuario)){
						emparejarAutomatico(mascota, pUsuario);
					}
				} else {
					pUsuario.addDiasTranscurridos();
				}
			}
			break;
			case "mensual": {
				if (pUsuario.getDiasUltimoEmparejamiento() == 30){
					for (Mascota mascota : ColeccionMascotas.getPerdidas(pUsuario)){
						emparejarAutomatico(mascota, pUsuario);
					}
				} else {
					pUsuario.addDiasTranscurridos();
				}
			}
			break;
			default : {
				JOptionPane.showMessageDialog(null, "Error inesperado",
					"Este usuario debería tener un lapso definido para sus emparejamientos pre-programados.",
				JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
	private static void emparejarAutomatico(Mascota pMascota, Usuario pUsuario){
		
		ArrayList<Mascota> coincidencias = new ArrayList<Mascota>();
		coincidencias = emparejarBajoDemanda(pMascota);
		try {
            Correo.enviarCoincidencias(coincidencias, pMascota,  pUsuario);
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "Error",
                "Estimado Usuario " + pUsuario.getNombre() +
            	"\nHubo un error al enviarle el correo con la lista de coincidencias para" +
                "\nsu Mascota: " + pMascota.getNombre() +
                "\nPor favor, para obtener la lista de resultados sobre esta mascota," +
                "\nejecute un emparejamiento bajo demanda." +
                "\nCausa del error: " + ex.getMessage(),
            JOptionPane.WARNING_MESSAGE);
        }
		
	}
		
	public static ArrayList<Mascota> emparejarBajoDemanda(Mascota pMascotaEscogida) {
		
		// Empareja una mascota escogida por pUsuario con todas
		// las mascotas reportadas en el sistema como:
		// "encontradas", "perdidas", "refugiadas", "adoptadas", "localizadas" o "muertas",
		// según el estado actual de la mascota.
				
		ArrayList<Mascota> coincidencias = new ArrayList<Mascota>();
				
		switch (pMascotaEscogida.getEstadoActual()){
			// En éste caso debería buscar en las tres listas.
			case MaquinaEstadosMascotas.estadoPERDIDA:
				coincidencias = getListaCoincidencias(pMascotaEscogida, "encontradas");
				coincidencias.addAll(getListaCoincidencias(pMascotaEscogida, "adoptadas"));
				coincidencias.addAll(getListaCoincidencias(pMascotaEscogida, "refugiadas"));
				break;
			// Se cumple igual en cualquiera de éstos casos. 
			case MaquinaEstadosMascotas.estadoENCONTRADA:
			case MaquinaEstadosMascotas.estadoADOPTABLE:
			case MaquinaEstadosMascotas.estadoREFUGIADA:
				coincidencias = getListaCoincidencias(pMascotaEscogida, "perdidas");
				break;
			default : {
				JOptionPane.showMessageDialog(null, "Error inesperado",
					"No se ha podido realizar el emparejamiento correspondiente.",
				JOptionPane.ERROR_MESSAGE);
			}
		}
		
		return coincidencias;
		
    }

	private static ArrayList<Mascota> getListaCoincidencias(Mascota perdidaAComparar, String pListaMascotasDondeBuscar){
		// Empareja una de las mascotas reportadas por pUsuario,
		// con las mascotas que estén reportadas (a nivel de sistema)
		// como : "encontradas", "perdidas","refugiadas", "adoptadas", "adoptables",
		// "localizadas" o "muertas".
		
		 ArrayList<Mascota> mascotasPorFiltrar = new ArrayList<Mascota>();
		 ArrayList<Mascota> resultados = new ArrayList<Mascota>();
		
		// Resumen del emparejamiento
			switch (pListaMascotasDondeBuscar) {
				case "encontradas": {
					mascotasPorFiltrar = Principal.encontradas;
				}
					break;
		
				case "perdidas": {
					mascotasPorFiltrar = Principal.perdidas;
				}
					break;
		
				case "refugiadas": {
					mascotasPorFiltrar = Principal.refugiadas;
				}
					break;
		
				case "adoptadas": {
					mascotasPorFiltrar = Principal.adoptadas;
				}
					break;
		
				case "enAdopcion": {
					mascotasPorFiltrar = Principal.enAdopcion;
				}
					break;
		
				case "localizadas": {
					mascotasPorFiltrar = Principal.localizadas;
				}
					break;
		
				case "muertas": {
					mascotasPorFiltrar = Principal.muertas;
				}
					break;
		
				default: {
				JOptionPane.showMessageDialog(null, "Error inesperado",
						"No se han encontrado coincidencias.",
					JOptionPane.ERROR_MESSAGE);	
				}
			}
			
			for (Mascota mascota : mascotasPorFiltrar) {
				if (perdidaAComparar.getNumeroChip() == mascota.getNumeroChip()) {
					resultados.add(mascota);
				}
				else if (perdidaAComparar.getRaza().equals(mascota.getRaza())
						&& perdidaAComparar.getEspecie().equals(
								mascota.getEspecie())
						&& perdidaAComparar.getColor().equals(mascota.getColor())) {
					resultados.add(mascota);
				}
			}
			
			return resultados;
	}
	
	public static ArrayList<Usuario> getListaRefugiantes(Mascota pMascotaAComparar){
		// Busca los usuarios que tengan condiciones de refugio similares a las características
		// de la mascota reportada.

		ArrayList<Usuario> refugiantes =  new ArrayList<Usuario>();

		for (Usuario usuario : Principal.blanca) {
			CondicionesRefugio pCondiciones = usuario.getCondicionesRefugio();
			
			if (pMascotaAComparar.isVacunada() == pCondiciones.isSoloVacunada()
					 && pMascotaAComparar.isCastrada() == pCondiciones.isSoloCastrada()
					 && pMascotaAComparar.isDesparacitada() == pCondiciones.isSoloDesparacitada()) {
						refugiantes.add(usuario);
			}
		}

		return refugiantes;
	}
}



