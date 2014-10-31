package dogslovers.control;

import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;

import dogslovers.modelo.Usuario;
import dogslovers.modelo.Mascota;
import dogslovers.control.Principal;

public class Emparejador {


	public static void rutinaMatch(Usuario pUsuario, String pListaMascotas){

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
		// las mascotas reportadas en el sistema como "encontradas", "perdidas",
		// "refugiadas", "adoptadas", "localizadas" o "muertas".

		switch(pListaMascotas){
            case "encontradas":{

                ArrayList<Mascota> coincidencias;

                for (int i = 0; i < Principal.encontradas.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.encontradas.get(i));
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

                ArrayList<Mascota> coincidencias;

                for (int i = 0; i < Principal.perdidas.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.perdidas.get(i));
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

                ArrayList<Mascota> coincidencias;

                for (int i = 0; i < Principal.refugiadas.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.refugiadas.get(i));
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

                ArrayList<Mascota> coincidencias;

                for (int i = 0; i < Principal.adoptadas.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.adoptadas.get(i));
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

            case "localizadas":{

                ArrayList<Mascota> coincidencias;

                for (int i = 0; i < Principal.localizadas.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.localizadas.get(i));
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

                ArrayList<Mascota> coincidencias;

                for (int i = 0; i < Principal.muertas.size(); i++) {
                    coincidencias = getListaCoincidencias(Principal.muertas.get(i));
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

	public static ArrayList<Mascota> getListaCoincidencias(Mascota perdidaAComparar){

		ArrayList<Mascota> coincidencias = new ArrayList<Mascota>();

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
		return coincidencias;

	}

	public static ArrayList<Usuario> getListaCoincidenciasCondiciones(Mascota pMascotaAComparar){

		ArrayList<Usuario> coincidenciasCondiciones =  new ArrayList<Usuario>();

		for (Usuario usuario : Principal.blanca) {
			if (pMascotaAComparar.getEspecie().equals(
					usuario.getCondicionesRef().getEspecie())
							&& pMascotaAComparar.getTamanio().equals(
									usuario.getCondicionesRef().getTamanioMascota())
							&& pMascotaAComparar.isVacunada() == usuario
									.getCondicionesRef().isVacunada()
							&& pMascotaAComparar.isDiscapacitada() == usuario
									.getCondicionesRef().isDiscapacitada()
							&& pMascotaAComparar.isCastrada() == usuario
									.getCondicionesRef().isCastrada()
							&& pMascotaAComparar.isDesparacitada() == usuario
									.getCondicionesRef().isDesparacitada()) {
				coincidenciasCondiciones.add(usuario);
			}
		}

		return coincidenciasCondiciones;
	}

}



