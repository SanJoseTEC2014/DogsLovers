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

import javax.mail.MessagingException;
import javax.swing.JOptionPane;

import dogslovers.modelo.Usuario;
import dogslovers.modelo.Mascota;
import dogslovers.control.Principal;

public class Emparejador {


	public static void rutinaMatch(Usuario pUsuario, String pListaMascotas){
		// Envia un emparejamiento de mascotas al usuario en el lapso de tiempo
		// definido por este.

		switch (pUsuario.getLapsoEmparejamiento()){
			case "diario" : {
				emparejarBajoDemanda(pUsuario, pListaMascotas);
			}
			break;
			case "semanal": {
				if (pUsuario.getDiasUltimoEmparejamiento() == 7){
					emparejarBajoDemanda(pUsuario, pListaMascotas);
				} else {
					pUsuario.addDiasTranscurridos();
				}
			}
			break;
			case "mensual": {
				if (pUsuario.getDiasUltimoEmparejamiento() == 30){
					emparejarBajoDemanda(pUsuario, pListaMascotas);
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

	private static void emparejarBajoDemanda(Usuario pUsuario, String pListaMascotas) {
		// Empareja todas las mascotas reportadas como propias por pUsuario con todas
		// las mascotas reportadas en el sistema como: "encontradas", "perdidas",
		// "refugiadas", "adoptadas", "localizadas" o "muertas".
		
		ArrayList<Mascota> coincidencias;

		switch(pListaMascotas){
            case "encontradas":{

                for (int i = 0; i < Principal.encontradas.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.encontradas.get(i), "encontradas");
                    try {
                        Correo.enviarCoincidencias(coincidencias, Principal.encontradas.get(i),  pUsuario);
                    } catch (MessagingException ex) {
                        JOptionPane.showMessageDialog(null, "Error",
                            "Error al enviar el correo con la lista de coincidencias de" +
                            "\nMascota: " + Principal.encontradas.get(i).getNombre() +
                            "\nDueño: " + pUsuario.getNombre() +
                            "\nPor favor, para obtener la lista de resultados sobre esta mascota," +
                            "\nejecute un emparejamiento bajo demanda." +
                            "\nCausa del error: " + ex.getMessage(),
                        JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            break;

            case "perdidas":{

                for (int i = 0; i < Principal.perdidas.size(); i++) {
                    coincidencias =getListaCoincidencias(Principal.perdidas.get(i), "perdidas");
                    try {
                        Correo.enviarCoincidencias(coincidencias, Principal.perdidas.get(i),  pUsuario);
                    } catch (MessagingException ex) {
                        JOptionPane.showMessageDialog(null, "Error",
                            "Error al enviar el correo con la lista de coincidencias de" +
                            "\nMascota: " + Principal.perdidas.get(i).getNombre() +
                            "\nDueño: " + pUsuario.getNombre() +
                            "\nPor favor, para obtener la lista de resultados sobre esta mascota," +
                            "\nejecute un emparejamiento bajo demanda." +
                            "\nCausa del error: " + ex.getMessage(),
                        JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            break;

            case "refugiadas":{
            	
                for (int i = 0; i < Principal.refugiadas.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.refugiadas.get(i), "refugiadas");
                    try {
                        Correo.enviarCoincidencias(coincidencias, Principal.refugiadas.get(i),  pUsuario);
                    } catch (MessagingException ex) {
                        JOptionPane.showMessageDialog(null, "Error",
                            "Error al enviar el correo con la lista de coincidencias de" +
                            "\nMascota: " + Principal.refugiadas.get(i).getNombre() +
                            "\nDueño: " + pUsuario.getNombre() +
                            "\nPor favor, para obtener la lista de resultados sobre esta mascota," +
                            "\nejecute un emparejamiento bajo demanda." +
                            "\nCausa del error: " + ex.getMessage(),
                        JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            break;

            case "adoptadas":{

                for (int i = 0; i < Principal.adoptadas.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.adoptadas.get(i), "adoptadas");
                    try {
                        Correo.enviarCoincidencias(coincidencias, Principal.adoptadas.get(i),  pUsuario);
                    } catch (MessagingException ex) {
                        JOptionPane.showMessageDialog(null, "Error",
                            "Error al enviar el correo con la lista de coincidencias de" +
                            "\nMascota: " + Principal.adoptadas.get(i).getNombre() +
                            "\nDueño: " + pUsuario.getNombre() +
                            "\nPor favor, para obtener la lista de resultados sobre esta mascota," +
                            "\nejecute un emparejamiento bajo demanda." +
                            "\nCausa del error: " + ex.getMessage(),
                        JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            break;
            
            case "enAdopcion":{

                for (int i = 0; i < Principal.enAdopcion.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.enAdopcion.get(i), "enAdopcion");
                    try {
                        Correo.enviarCoincidencias(coincidencias, Principal.enAdopcion.get(i),  pUsuario);
                    } catch (MessagingException ex) {
                        JOptionPane.showMessageDialog(null, "Error",
                            "Error al enviar el correo con la lista de coincidencias de" +
                            "\nMascota: " + Principal.enAdopcion.get(i).getNombre() +
                            "\nDueño: " + pUsuario.getNombre() +
                            "\nPor favor, para obtener la lista de resultados sobre esta mascota," +
                            "\nejecute un emparejamiento bajo demanda." +
                            "\nCausa del error: " + ex.getMessage(),
                        JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            break;

            case "localizadas":{

                for (int i = 0; i < Principal.localizadas.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.localizadas.get(i), "localizadas");
                    try {
                        Correo.enviarCoincidencias(coincidencias, Principal.localizadas.get(i),  pUsuario);
                    } catch (MessagingException ex) {
                        JOptionPane.showMessageDialog(null, "Error",
                            "Error al enviar el correo con la lista de coincidencias de" +
                            "\nMascota: " + Principal.localizadas.get(i).getNombre() +
                            "\nDueño: " + pUsuario.getNombre() +
                            "\nPor favor, para obtener la lista de resultados sobre esta mascota," +
                            "\nejecute un emparejamiento bajo demanda." +
                            "\nCausa del error: " + ex.getMessage(),
                        JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            break;

            case "muertas":{

                for (int i = 0; i < Principal.muertas.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.muertas.get(i), "muertas");
                    try {
                        Correo.enviarCoincidencias(coincidencias, Principal.muertas.get(i),  pUsuario);
                    } catch (MessagingException ex) {
                        JOptionPane.showMessageDialog(null, "Error",
                            "Error al enviar el correo con la lista de coincidencias de" +
                            "\nMascota: " + Principal.muertas.get(i).getNombre() +
                            "\nDueño: " + pUsuario.getNombre() +
                            "\nPor favor, para obtener la lista de resultados sobre esta mascota," +
                            "\nejecute un emparejamiento bajo demanda." +
                            "\nCausa del error: " + ex.getMessage(),
                        JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            break;

            default : {
				JOptionPane.showMessageDialog(null, "Error inesperado",
					"No se ha podido realizar el emparejamiento correspondiente.",
				JOptionPane.ERROR_MESSAGE);
			}
		}
    }

	public static ArrayList<Mascota> getListaCoincidencias(Mascota perdidaAComparar, String pEstadoMascota ){
		// Busca las posibles coincidencias con respecto a la mascota reportada, con las mascotas
		// que estén reportadas como : "encontradas", "perdidas","refugiadas", "adoptadas", "adoptables",
		// "localizadas" o "muertas".
		
		 ArrayList<Mascota> coincidencias = new ArrayList<Mascota>();
		 ArrayList<Mascota> resultados = new ArrayList<Mascota>();
		
		 switch(pEstadoMascota){
			case "encontradas":{
				for (Mascota mascota : Principal.encontradas) {
					if (perdidaAComparar.getNumeroChip() == mascota.getNumeroChip()) {
						coincidencias.add(mascota);
					}
					else if (perdidaAComparar.getRaza().equals(mascota.getRaza())
							&& perdidaAComparar.getEspecie().equals(
									mascota.getEspecie())
							&& perdidaAComparar.getColor().equals(mascota.getColor())) {
						coincidencias.add(mascota);
					}
				}
				resultados = coincidencias;
				break;
			
			}
			
			case "perdidas":{
				for (Mascota mascota : Principal.perdidas) {
					if (perdidaAComparar.getNumeroChip() == mascota.getNumeroChip()) {
						coincidencias.add(mascota);
					}

					else if (perdidaAComparar.getRaza().equals(mascota.getRaza())
							&& perdidaAComparar.getEspecie().equals(
									mascota.getEspecie())
							&& perdidaAComparar.getColor().equals(mascota.getColor())) {
						coincidencias.add(mascota);

					}
				}
				resultados =  coincidencias;
				break;
			  
			}
			
			case "refugiadas":{
				for (Mascota mascota : Principal.refugiadas) {
					if (perdidaAComparar.getNumeroChip() == mascota.getNumeroChip()) {
						coincidencias.add(mascota);
					}

					else if (perdidaAComparar.getRaza().equals(mascota.getRaza())
							&& perdidaAComparar.getEspecie().equals(
									mascota.getEspecie())
							&& perdidaAComparar.getColor().equals(mascota.getColor())) {
						coincidencias.add(mascota);

					}
				}
				resultados =  coincidencias;
				break;
			}
			
			case "adoptadas":{
				for (Mascota mascota : Principal.adoptadas) {
					if (perdidaAComparar.getNumeroChip() == mascota.getNumeroChip()) {
						coincidencias.add(mascota);
					}

					else if (perdidaAComparar.getRaza().equals(mascota.getRaza())
							&& perdidaAComparar.getEspecie().equals(
									mascota.getEspecie())
							&& perdidaAComparar.getColor().equals(mascota.getColor())) {
						coincidencias.add(mascota);

					}
				}
				resultados = coincidencias;
				break;
			}
			
			case "enAdopcion":{
				for (Mascota mascota : Principal.enAdopcion) {
					if (perdidaAComparar.getNumeroChip() == mascota.getNumeroChip()) {
						coincidencias.add(mascota);
					}

					else if (perdidaAComparar.getRaza().equals(mascota.getRaza())
							&& perdidaAComparar.getEspecie().equals(
									mascota.getEspecie())
							&& perdidaAComparar.getColor().equals(mascota.getColor())) {
						coincidencias.add(mascota);

					}
				}
				resultados = coincidencias;
				break;
			}
		
			case "localizadas":{
				for (Mascota mascota : Principal.localizadas) {
					if (perdidaAComparar.getNumeroChip() == mascota.getNumeroChip()) {
						coincidencias.add(mascota);
					}

					else if (perdidaAComparar.getRaza().equals(mascota.getRaza())
							&& perdidaAComparar.getEspecie().equals(
									mascota.getEspecie())
							&& perdidaAComparar.getColor().equals(mascota.getColor())) {
						coincidencias.add(mascota);

					}
				}
				resultados = coincidencias;
				break;
			}
			
			case"muertas":{
				for (Mascota mascota : Principal.muertas) {
					if (perdidaAComparar.getNumeroChip() == mascota.getNumeroChip()) {
						coincidencias.add(mascota);
					}

					else if (perdidaAComparar.getRaza().equals(mascota.getRaza())
							&& perdidaAComparar.getEspecie().equals(
									mascota.getEspecie())
							&& perdidaAComparar.getColor().equals(mascota.getColor())) {
						coincidencias.add(mascota);

					}
				}
				resultados = coincidencias;
				break;
			}
			
			default:{
			JOptionPane.showMessageDialog(null, "Error inesperado",
					"No se han encontrado coincidencias.",
				JOptionPane.ERROR_MESSAGE);	
			}
		}
		return resultados;
	}
	
	public static ArrayList<Usuario> getListaCoincidenciasCondiciones(Mascota pMascotaAComparar){
		// Busca los usuarios que tengan condiciones de refugio similares a las características
		// de la mascota reportada.

		ArrayList<Usuario> coincidenciasCondiciones =  new ArrayList<Usuario>();

		for (Usuario usuario : Principal.blanca) {
			if (pMascotaAComparar.getTamanio().equals(usuario
							.getCondicionesRefugio().getTamanioMascota())
							&& pMascotaAComparar.isVacunada() == usuario
									.getCondicionesRefugio().isVacunada()
							&& pMascotaAComparar.isDiscapacitada() == usuario
									.getCondicionesRefugio().isDiscapacitada()
							&& pMascotaAComparar.isCastrada() == usuario
									.getCondicionesRefugio().isCastrada()
							&& pMascotaAComparar.isDesparacitada() == usuario
									.getCondicionesRefugio().isDesparacitada()) {
				coincidenciasCondiciones.add(usuario);
			}
		}

		return coincidenciasCondiciones;
	}
}



