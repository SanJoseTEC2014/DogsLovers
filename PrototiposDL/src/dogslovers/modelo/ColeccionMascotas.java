package dogslovers.modelo;

import java.util.ArrayList;

import dogslovers.control.Acceso;
import dogslovers.control.Principal;
import dogslovers.control.excepciones.MascotaNoEncontradaException;
import dogslovers.control.excepciones.UsuarioNoExisteException;

public class ColeccionMascotas {

	public static ArrayList<Mascota> getPerdidas(Usuario pUsuario) {
		ArrayList<Mascota> perdidas = new ArrayList<Mascota>();
		for (Mascota mascota : Principal.perdidas){
			if (mascota.getUltimoSuceso().getNick() == pUsuario.getNickname()){
				perdidas.add(mascota);
			}
		}
		return perdidas;
	}

	public static ArrayList<Mascota> getEncontradas(Usuario pUsuario) {
		ArrayList<Mascota> encontradas = new ArrayList<Mascota>();
		for (Mascota mascota : Principal.encontradas){
			if (mascota.getUltimoSuceso().getNick() == pUsuario.getNickname()){
				encontradas.add(mascota);
			}
		}
		return encontradas;
	}

	public static ArrayList<Mascota> getLocalizadas(Usuario pUsuario) {
		ArrayList<Mascota> localizada = new ArrayList<Mascota>();
		for (Mascota mascota : Principal.localizadas){
			if (mascota.getUltimoSuceso().getNick() == pUsuario.getNickname()){
				localizada.add(mascota);
			}
		}
		return localizada;
	}

	public static ArrayList<Mascota> getRefugiadas(Usuario pUsuario) {
		ArrayList<Mascota> refugiadas = new ArrayList<Mascota>();
		for (Mascota mascota : Principal.refugiadas){
			if (mascota.getUltimoSuceso().getNick() == pUsuario.getNickname()){
				refugiadas.add(mascota);
			}
		}
		return refugiadas;
	}

	public static ArrayList<Mascota> getAdoptables(Usuario pUsuario) {
		ArrayList<Mascota> adoptables = new ArrayList<Mascota>();
		for (Mascota mascota : Principal.enAdopcion){
			if (mascota.getUltimoSuceso().getNick() == pUsuario.getNickname()){
				adoptables.add(mascota);
			}
		}
		return adoptables;
	}

	public static ArrayList<Mascota> getAdoptadas(Usuario pUsuario) {
		ArrayList<Mascota> adoptadas = new ArrayList<Mascota>();
		for (Mascota mascota : Principal.adoptadas){
			if (mascota.getUltimoSuceso().getNick() == pUsuario.getNickname()){
				adoptadas.add(mascota);
			}
		}
		return adoptadas;
	}
}
