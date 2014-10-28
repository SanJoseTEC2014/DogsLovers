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
import dogslovers.modelo.CondicionesRefugio;

public class Mascota {
	
	public static LinkedList<String> especies = new LinkedList<String>();
	public static LinkedList<String[]> razas = new LinkedList<String[]>(); 
	private static Integer totalChips = 0;
	
	public static LinkedList<String> getEspecies() {
		return especies;
	}

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
	private boolean discapacitada;
	private String tamanio;
	private String estado;
	private String nickDuenio;
	private String nickEncontrante;
	private String nickRefugiante;
	private String nickAdoptante;
	private Suceso perdida;
	private Suceso encuentro;
	private Suceso localizacion;
	private Suceso refugio;
	private Suceso adopcion;
	private Suceso defuncion;
	private Integer recompensa;
	private String notas;
	
	public static void setEspecies(LinkedList<String> especies) {
		Mascota.especies = especies;
	}

	public static LinkedList<String[]> getRazas() {
		return razas;
	}

	public static void setRazas(LinkedList<String[]> razas) {
		Mascota.razas = razas;
	}

	public static Integer getTotalChips() {
		return totalChips;
	}

	public static void setTotalChips(Integer totalChips) {
		Mascota.totalChips = totalChips;
	}

	public Integer getChipID() {
		return id;
	}

	public void setChipID(Integer id) {
		this.id = id;
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

	public boolean isDesparacitada() {
		return desparacitada;
	}

	public void setDesparacitada(boolean desparacitada) {
		this.desparacitada = desparacitada;
	}

	public boolean isDiscapacitada() {
		return discapacitada;
	}

	public void setDiscapacitada(boolean discapacitada) {
		this.discapacitada = discapacitada;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getNickDuenio() {
		return nickDuenio;
	}

	public void setNickDuenio(String nickDuenio) {
		this.nickDuenio = nickDuenio;
	}

	public String getNickEncontrante() {
		return nickEncontrante;
	}

	public void setNickEncontrante(String nickEncontrante) {
		this.nickEncontrante = nickEncontrante;
	}

	public String getNickRefugiante() {
		return nickRefugiante;
	}

	public void setNickRefugiante(String nickRefugiante) {
		this.nickRefugiante = nickRefugiante;
	}

	public String getNickAdoptante() {
		return nickAdoptante;
	}

	public void setNickAdoptante(String nickAdoptante) {
		this.nickAdoptante = nickAdoptante;
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
	
//	public Mascota(String pNombre, String pEspecie, String pRaza,
//				   Suceso pExtravio, Integer pRecompensa, String pNotasSecundarias) {
//		nombre = pNombre;
//		chipID = ++totalChips;
//		estado = "Perdido";
//		
//		especie = pEspecie;
//		raza = pRaza;
//		
//		extravio = pExtravio;
//		
//		recompensa = pRecompensa;
//		notasSecundarias = pNotasSecundarias;
//	}

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
		
		//msg += "\n\nEncuentro: " + encuentro.toString();
		
		msg += "\n\nMonto de recompensa: " + getRecompensa();
		msg += "\nNotas Secundarias: " + getNotasSecundarias();
		return msg;
	} 
}
