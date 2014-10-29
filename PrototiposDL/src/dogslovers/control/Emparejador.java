package dogslovers.control;

import java.util.ArrayList;

import dogslovers.modelo.Mascota;
import dogslovers.control.Principal;

public class Emparejador {
	

	public static void rutinaMatch(Usuario pUsuario){
	
		switch (pUsuario.getLapso()){
			case "diario" : {
				emparejarBajoDemanda(pUsuario);
			}
			break;
			case "semanal": {
				if (pUsuario.getDiasTranscurridos() == 7){
					emparejarBajoDemanda(pUsuario);
				} else {
					pUsuario.addDiasTranscurridos();
				}
			}
			break;
			case "mensual": {
				if (pUsuario.getDiasTranscurridos() == 30){
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
		
		ArrayList<Integer> idsPropias = pUsuario.getMascotasPropiasIDs();
		ArrayList<ArrayList<Mascota>> matrizCoincidencias;

			for (Integer id : idsPropias) {
				matrizCoincidencias.add(getListaCoincidencias(Principal.getMascotasEncontradas(id)));
			}

			for (int lista = 0; lista < matrizCoincidencias.size(); lista++) {
				try {
					Correo.enviarCoincidencias(matrizCoincidencias.get(lista), pUsuario.getCorreo());
				} catch (ExcepcionCorreo ex) {
					JOptionPane.showMessageDialog(null, "Error",
						"Error al enviar el correo con la lista de coincidencias de" +
						"\nMascota: " + matrizCoincidencias.get(lista).getNombre() +
						"\nDueño: " + matrizCoincidencias.get(lista).getNickDuenio() +
						"\nPor favor, para obtener la lista de resultados sobre esta mascota,\n" +
						"ejecute un emparejamiento bajo demanda.",
						"\nCausa del error: " + ex.getMessage(),
					JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	
	public static ArrayList<Mascota> getListaCoincidencias(Mascota perdidaAComparar){
		
		ArrayList<Mascota> coincidencias = new ArrayList<Mascota>();

		for(Mascota mascota : encontradas){
			if(perdidaAComparar.getChipID() == mascota.getChipID()){
				coincidencias.add(mascota);
			}
			
			else if(perdidaAComparar.getRaza().equals(mascota.getRaza()) && perdidaAComparar.getEspecie().equals(mascota.getEspecie()) &&
				perdidaAComparar.getColor().equals(mascota.getColor())){
					coincidencias.add(mascota);

		}
		return coincidencias;
	 }
}

	public static ArrayList<Usuario> getListaCoincidenciasCondiciones(Mascota pMascotaAComparar){
		
		ArrayList<Usuario> coincidenciasCondiciones = new ArrayList<Usuario>();

		for(Usuario usuario : usuarios){
			if(pMascotaAComparar.getEspecie().equals(usuario.getCondicionesRef.getEspecie() && pMascotaAComparar.getTamanio().equals			
				(usuario.getCondicionesRef().getTamanio()) && pMascotaAComparar.getVacunada() == usuario.getCondicionesRef.getVacunada() &&
 				pMascotaAComparar.getDiscapacitada() == usuario.getCondicionesRef.getDiscapacitada() && 
 				pMascotaAComparar.getCastrada() == usuario.getCondicionesRef.getCastrada() && 
 				pMascotaAComparar.getDesparacitada() == usuario.getCondicionesRef.getDesparacitad())){
				coincidenciasCondiciones.add(usuario);
		          }
		}

		return coincidenciasCondiciones;
}
	
}
	
	

