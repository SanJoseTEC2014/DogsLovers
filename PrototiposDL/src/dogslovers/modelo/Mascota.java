package dogslovers.modelo;

/**	Prototipo de la clase Mascota
 *	Fecha de creaci�n: 03/10/2014
 * 
 *	@author Isaac Antonio Campos Mes�n 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa Mar�a Molina Corrales 2013006074
 *	@author Luis Andr�s Pe�a Castillo 2014057250 
 *  
 */

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import dogslovers.control.Imagenes;
import dogslovers.control.MaquinaEstadosMascotas;
import dogslovers.control.excepciones.ImagenNoEncontradaException;
import dogslovers.modelo.Suceso;

public class Mascota {

	private static LinkedList<String> edades = new LinkedList<String>();
	private static LinkedList<String> tamanios = new LinkedList<String>();
	private static LinkedList<String> especies = new LinkedList<String>();
	private static LinkedList<LinkedList<String>> razas = new LinkedList<LinkedList<String>>();
	
	private static Integer totalIDsRegistradas = 0;

	private Integer id;
	private String nombre;
	private Integer numeroChip;
	private String especie;
	private String raza;
	private String color;
	private String edad;
	private String sexo;
	private boolean castrada;
	private boolean vacunada;
	private boolean desparacitada;
	private String tamanio;
	private String estado;
	private Suceso perdida;
	private Suceso encuentro;
	private Suceso localizacion;
	private Suceso refugio;
	private Suceso adopcion;
	private Suceso defuncion;
	private Integer recompensa;
	private String notas;

	public Mascota(String pNombre, String pEspecie, String pRaza, Suceso pSuceso, boolean perdida, Integer pRecompensa,
			String pNotas) {
		id = ++totalIDsRegistradas;
		nombre = pNombre;
		especie = pEspecie;
		raza = pRaza;

		if (perdida) {
			this.perdida = pSuceso;
			this.encuentro = null;
			this.estado = MaquinaEstadosMascotas.estadoPERDIDA;
		} else {
			this.perdida = null;
			this.encuentro = pSuceso;
			this.estado = MaquinaEstadosMascotas.estadoENCONTRADA;
		}

		recompensa = pRecompensa;
		notas = pNotas;
	}

	public Integer getID() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroChip() {
		return numeroChip;
	}

	public void setNumeroChip(Integer numeroChip) {
		this.numeroChip = numeroChip;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isCastrada() {
		return castrada;
	}

	public void setCastrada(boolean castrada) {
		this.castrada = castrada;
	}

	public boolean isVacunada() {
		return vacunada;
	}

	public void setVacunada(boolean vacunada) {
		this.vacunada = vacunada;
	}

	public boolean isDesparacitada(){
		return desparacitada;
	}

	public void setDesparacitada(boolean desparacitada) {
		this.desparacitada = desparacitada;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public Suceso getPerdida() {
		return perdida;
	}

	public void setPerdida(Suceso perdida) {
		this.perdida = perdida;
	}

	public Suceso getEncuentro() {
		return encuentro;
	}

	public void setEncuentro(Suceso encuentro) {
		this.encuentro = encuentro;
	}

	public Suceso getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(Suceso localizacion) {
		this.localizacion = localizacion;
	}

	public Suceso getRefugio() {
		return refugio;
	}

	public void setRefugio(Suceso refugio) {
		this.refugio = refugio;
	}

	public Suceso getAdopcion() {
		return adopcion;
	}

	public void setAdopcion(Suceso adopcion) {
		this.adopcion = adopcion;
	}

	public Suceso getDefuncion() {
		return defuncion;
	}

	public void setDefuncion(Suceso defuncion) {
		this.defuncion = defuncion;
	}

	public Integer getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(Integer recompensa) {
		this.recompensa = recompensa;
	}

	public String getNotasSecundarias() {
		return notas;
	}

	public void setNotasSecundarias(String notas) {
		this.notas = notas;
	}

	// MAQUINA DE ESTADOS
	public String getEstado() {
		return estado;
	}

	public void setEstado(String pEstado) {
		estado = pEstado;
	}

	public BufferedImage getImagen() throws ImagenNoEncontradaException{
		return Imagenes.getPerfilMascota(id);
	}
	
	public String toString() {
		String msg = "Nombre de la mascota: " + getNombre();
		msg += "\nID: " + getID();
		msg += " Estado: " + getEstado();

		msg += "\nEspecie: " + getEspecie();
		msg += "  Raza: " + getRaza();

		msg += "\nMonto de recompensa: " + getRecompensa() + "\n";
		// msg += "\nNotas Secundarias: " + getNotasSecundarias();
		return msg;
	}

	// Constructor invocado �nicamente por el m�todo .clone()
	private Mascota(Integer pID, String pNombre, String pEspecie, String pRaza, Integer pRecompensa, String pNotas) {
		id = pID;
		nombre = pNombre;
		especie = pEspecie;
		raza = pRaza;
		recompensa = pRecompensa;
		notas = pNotas;
	}
	
	public Mascota clone() {
		  Mascota clone = new Mascota(id, nombre, especie, raza, recompensa, notas);
		  clone.setColor(color);
		  clone.setEdad(edad);
		  clone.setEstado(estado);
		  clone.setNumeroChip(numeroChip);
		  clone.setSexo(sexo);
		  clone.setTamanio(tamanio);
		  
		  clone.setPerdida(perdida);
		  clone.setEncuentro(encuentro);
		  clone.setLocalizacion(localizacion);
		  clone.setRefugio(refugio);
		  clone.setAdopcion(adopcion);
		  clone.setDefuncion(defuncion);
		  
		  clone.setCastrada(castrada);
		  clone.setDesparacitada(desparacitada);
		  clone.setVacunada(vacunada);
		  return clone;
	}

	public static DefaultComboBoxModel<String> getModeloEspecies() {
		return new DefaultComboBoxModel<String>((String[]) especies.toArray());
	}
	
	// Recibe la especie seleccionada en el JComboBox para que �ste pueda refrescarse
	// cuando se est� editando la especie de una Mascota.
	public static DefaultComboBoxModel<String> getModeloRazas(String pEspecie) {
		return new DefaultComboBoxModel<String>(
			(String[]) razas.get(
				especies.indexOf(pEspecie)
			).toArray()
		);
	}
	
	public static DefaultComboBoxModel<String> getModeloEdades() {
		  return new DefaultComboBoxModel<String>((String[]) edades.toArray());
	}
	
	public static DefaultComboBoxModel<String> getModeloTamanios() {
		  return new DefaultComboBoxModel<String>((String[]) tamanios.toArray());
	}
	
	public static void addEdad(String pEdad){
		edades.add(pEdad);
	}
	
	public static void addTamanio(String pTamanio){
		tamanios.add(pTamanio);
	}
	
	public static void addEspecie(String pEspecie){
		especies.add(pEspecie);
	}
	
	public static void addRaza(String pEspecie, String pRaza){
		razas.get(especies.indexOf(pEspecie)).add(pRaza);
	}
	
	public static LinkedList<String> getEspecies() {
		return especies;
	}

	public static LinkedList<LinkedList<String>> getRazas() {
		return razas;
	}

	public static Integer getTotalChips() {
		return totalIDsRegistradas;
	}
	
}
