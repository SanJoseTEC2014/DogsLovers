package dogslovers.modelo;

import java.util.ArrayList;

public class Usuario {
	
	static final public String[] lapsos = {"diario", "semanal", "mensual"}; 
	private String nickname;
	private String nombre;
	private String apellidos;
	private int cedula;
	private String contrasenia;
	private int telefono;
	private String lapsoEmparejamiento;
	private int diasUltimoEmparejamiento;
	//private ArrayList<Calificaciones> calificaciones;
	private ArrayList<Integer> mascotasPerdidasIDs;
	private ArrayList<Integer> mascotasEncontradasIDs;
	private ArrayList<Integer> mascotasLocalizadasIDs;
	private ArrayList<Integer> mascotasRefugiadasIDs;
	private ArrayList<Integer> mascotasSolicitudRefugioIDs;
	private ArrayList<Integer> mascotasAdoptadasIDs;
	private ArrayList<Integer> mascotasSolicitudAdopcionIDs;
	private boolean refugiante;
	private boolean adoptante;
	private boolean administrador;
	private CondicionesRefugio condicionesRef;
	//private facebook cuentaFacebook;
	//private twitter cuentaTwitter;
	
	public Usuario(String pNickname, String pNombre, String pApellidos, 
			       Integer pCedula, String pContrasenia, Integer pTelefono, 
			       String pLapsoEmparejamiento, boolean pRefugiante, 
			       CondicionesRefugio pCondiciones, boolean pAdoptante) {
		nickname = pNickname;
		nombre = pNombre;
		apellidos = pApellidos;
		cedula = pCedula;
		contrasenia = pContrasenia;
		telefono = pTelefono;
		lapsoEmparejamiento = pLapsoEmparejamiento;
		refugiante = pRefugiante;
		condicionesRef = pCondiciones;
		adoptante = pAdoptante;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getLapsoEmparejamiento() {
		return lapsoEmparejamiento;
	}
	public void setLapsoEmparejamiento(int lapsoEmparejamiento) {
		this.lapsoEmparejamiento = lapsoEmparejamiento;
	}
	public int getDiasUltimoEmparejamiento() {
		return diasUltimoEmparejamiento;
	}
	public void setDiasUltimoEmparejamiento(int diasUltimoEmparejamiento) {
		this.diasUltimoEmparejamiento = diasUltimoEmparejamiento;
	}
	public ArrayList<Integer> getMascotasPerdidasIDs() {
		return mascotasPerdidasIDs;
	}
	public void setMascotasPerdidasIDs(ArrayList<Integer> mascotasPerdidasIDs) {
		this.mascotasPerdidasIDs = mascotasPerdidasIDs;
	}
	public ArrayList<Integer> getMascotasEncontradasIDs() {
		return mascotasEncontradasIDs;
	}
	public void setMascotasEncontradasIDs(ArrayList<Integer> mascotasEncontradasIDs) {
		this.mascotasEncontradasIDs = mascotasEncontradasIDs;
	}
	public ArrayList<Integer> getMascotasLocalizadasIDs() {
		return mascotasLocalizadasIDs;
	}
	public void setMascotasLocalizadasIDs(ArrayList<Integer> mascotasLocalizadasIDs) {
		this.mascotasLocalizadasIDs = mascotasLocalizadasIDs;
	}
	public ArrayList<Integer> getMascotasRefugiadasIDs() {
		return mascotasRefugiadasIDs;
	}
	public void setMascotasRefugiadasIDs(ArrayList<Integer> mascotasRefugiadasIDs) {
		this.mascotasRefugiadasIDs = mascotasRefugiadasIDs;
	}
	public ArrayList<Integer> getMascotasSolicitudRefugioIDs() {
		return mascotasSolicitudRefugioIDs;
	}
	public void setMascotasSolicitudRefugioIDs(ArrayList<Integer> mascotasSolicitudRefugioIDs) {
		this.mascotasSolicitudRefugioIDs = mascotasSolicitudRefugioIDs;
	}
	public ArrayList<Integer> getMascotasAdoptadasIDs() {
		return mascotasAdoptadasIDs;
	}
	public void setMascotasAdoptadasIDs(ArrayList<Integer> mascotasAdoptadasIDs) {
		this.mascotasAdoptadasIDs = mascotasAdoptadasIDs;
	}
	public ArrayList<Integer> getMascotasSolicitudAdopcionIDs() {
		return mascotasSolicitudAdopcionIDs;
	}
	public void setMascotasSolicitudAdopcionIDs(ArrayList<Integer> mascotasSolicitudAdopcionIDs) {
		this.mascotasSolicitudAdopcionIDs = mascotasSolicitudAdopcionIDs;
	}
	public boolean isRefugiante() {
		return refugiante;
	}
	public void setRefugiante(boolean refugiante) {
		this.refugiante = refugiante;
	}
	public boolean isAdoptante() {
		return adoptante;
	}
	public void setAdoptante(boolean adoptante) {
		this.adoptante = adoptante;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	public static String[] getLapsos() {
		return lapsos;
	}
}
