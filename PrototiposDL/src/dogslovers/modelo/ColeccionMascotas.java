package dogslovers.modelo;

import java.util.ArrayList;

import dogslovers.control.excepciones.MascotaNoEncontradaException;

public class ColeccionMascotas {
	private ArrayList<Mascota> perdidas;
	private ArrayList<Mascota> encontradas;
	private ArrayList<Mascota> localizadas;
	private ArrayList<Mascota> refugiadas;
	private ArrayList<Mascota> adoptables;
	private ArrayList<Mascota> adoptadas;
	
	public ColeccionMascotas(){
		perdidas = new ArrayList<Mascota>();
		encontradas = new ArrayList<Mascota>();
		localizadas = new ArrayList<Mascota>();
		refugiadas = new ArrayList<Mascota>();
		adoptables = new ArrayList<Mascota>();
		adoptadas = new ArrayList<Mascota>();	
	}

	public ArrayList<Mascota> getPerdidas() {
		return perdidas;
	}

	public ArrayList<Mascota> getEncontradas() {
		return encontradas;
	}

	public ArrayList<Mascota> getLocalizadas() {
		return localizadas;
	}

	public ArrayList<Mascota> getRefugiadas() {
		return refugiadas;
	}

	public ArrayList<Mascota> getAdoptables() {
		return adoptables;
	}

	public ArrayList<Mascota> getAdoptadas() {
		return adoptadas;
	}
	///////////////////////////////////////////////////////////// ADDs y REMOVEs
	public void addPerdida(Mascota pMascota) {
		perdidas.add(pMascota);
	}
	
	public Mascota removePerdida(Mascota pMascota) throws MascotaNoEncontradaException {
		if (!perdidas.remove(pMascota)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return pMascota;
	}

	public void addEncontrada(Mascota pMascota) {
		encontradas.add(pMascota);
	}
	
	public Mascota removeEncontrada(Mascota pMascota) throws MascotaNoEncontradaException {
		if (!encontradas.remove(pMascota)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return pMascota;
	}
	
	public void addRefugiada(Mascota pMascota) {
		refugiadas.add(pMascota);
	}
	
	public Mascota removeRefugiada(Mascota pMascota) throws MascotaNoEncontradaException {
		if (!refugiadas.remove(pMascota)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return pMascota;
	}

	public void addAdoptables(Mascota pMascota) {
		adoptables.add(pMascota);
	}
	
	public Mascota removeAdoptable(Mascota pMascota) throws MascotaNoEncontradaException {
		if (!adoptables.remove(pMascota)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return pMascota;
	}
	
	// Estado final, no debería tener remove
	public void addAdoptada(Mascota pMascota) {
		adoptadas.add(pMascota);
	}
	
	// Estado final, no debería tener remove
	public void addLocalizada(Mascota pMascota) {
		localizadas.add(pMascota);
	}
		
}
