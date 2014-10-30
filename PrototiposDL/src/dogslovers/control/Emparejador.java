package dogslovers.control;

import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;

import dogslovers.modelo.Usuario;
import dogslovers.modelo.Mascota;
import dogslovers.control.Principal;

public class Emparejador {
	

	public static void rutinaMatch(Usuario pUsuario){
	
		switch (pUsuario.getLapsoEmparejamiento()){
			case "diario" : {
				emparejarBajoDemanda(pUsuario);
			}
			break;
			case "semanal": {
				if (pUsuario.getDiasUltimoEmparejamiento() == 7){
					emparejarBajoDemanda(pUsuario);
				} else {
					pUsuario.addDiasTranscurridos();
				}
			}
			break;
			case "mensual": {
				if (pUsuario.getDiasUltimoEmparejamiento() == 30){
					emparejarBajoDemanda(pUsuario);
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
	
	private static void emparejarBajoDemanda(Usuario pUsuario) {

		// Empareja todas las mascotas reportadas como propias por pUsuario con todas
		// las mascotas reportadas en el sistema como "encontradas" (sin dueño)
		
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
		
		ArrayList<Usuario> coincidenciasCondiciones = new ArrayList<Usuario>();

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
	
	

