package dogslovers.modelo;
/**	Prototipo de la clase Mascota
 *	Fecha de creación: 03/10/2014
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
 *  
 */

import java.util.LinkedList;
import dogslovers.modelo.Suceso;

public class Mascota {
	
	public static LinkedList<String> especies = new LinkedList<String>();
	public static LinkedList<String[]> razas = new LinkedList<String[]>(); 
	private static Integer totalChips = 0;
	
	private String nombre;
	private Integer chipID; // Se usa también para la foto: /src/imagenes/mascotas/chipID.png
	private String especie;
	private String raza;
	private String estado;
	
	private Suceso extravio;
	private Suceso encuentro;

	private Integer recompensa;
	private String notasSecundarias;
	
	public Mascota(String pNombre, String pEspecie, String pRaza,
				   Suceso pExtravio, Integer pRecompensa, String pNotasSecundarias) {
		nombre = pNombre;
		chipID = ++totalChips;
		estado = "Perdido";
		
		especie = pEspecie;
		raza = pRaza;
		
		extravio = pExtravio;
		
		recompensa = pRecompensa;
		notasSecundarias = pNotasSecundarias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		nombre = pNombre;
	}

	public Integer getChipID() {
		return chipID;
	}

	public void setChipID(Integer pChipID) {
		chipID = pChipID;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String pEspecie) {
		especie = pEspecie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String pRaza) {
		raza = pRaza;
	}

	public Suceso getExtravio() {
		return extravio;
	}

	public void setExtravio(Suceso pLugar) {
		extravio = pLugar;
	}

	public Suceso getEncuentro() {
		return encuentro;
	}

	public void setEncuentro(Suceso pLugar) {
		encuentro = pLugar;
	}

	public Integer getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(Integer pRecompensa) {
		recompensa = pRecompensa;
	}

	public String getNotasSecundarias() {
		return notasSecundarias;
	}

	public void setNotasSecundarias(String pNotas) {
		notasSecundarias = pNotas;
	}

	// / MAQUINA DE ESTADOS
	public String getEstado() {
		return estado;
	}

	public void setEstado(String pEstado) {
		estado = pEstado;
	}
	
	public String toString(){
		String msg = "Nombre de la mascota: " + getNombre();
		msg += "\nNumero ID en el chip: " + getChipID();
		msg += "\nEstado de la mascota: " + getEstado();
		
		msg += "\n\nEspecie de la mascota: " + getEspecie();
		msg += "\nRaza de la mascota: " + getRaza();
		
		msg += "\nExtravío: \n" + extravio.toString();
		//msg += "\n\nEncuentro: " + encuentro.toString();
		
		msg += "\n\nMonto de recompensa: " + getRecompensa();
		msg += "\nNotas Secundarias: " + getNotasSecundarias();
		return msg;
	} 
}
