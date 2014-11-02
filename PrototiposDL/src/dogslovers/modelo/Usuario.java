package dogslovers.modelo;

import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dogslovers.control.Acceso;
import dogslovers.control.Principal;
import dogslovers.control.excepciones.IDMascotaNoEncontradaException;

public class Usuario {

	static final public String[] lapsos = { "diario", "semanal", "mensual" };

	public static String[] getLapsos() {
		return lapsos;
	}

	private String nickname;
	private String nombre;
	private String apellidos;
	private Integer cedula;
	private String contrasenia;
	private Integer telefono;
	private String correo;
	private String lapsoEmparejamiento;
	private Integer diasUltimoEmparejamiento;
	private ArrayList<Calificacion> calificaciones;
	private ArrayList<Integer> mascotasPerdidasIDs;
	private ArrayList<Integer> mascotasEncontradasIDs;
	private ArrayList<Integer> mascotasLocalizadasIDs;
	private ArrayList<Integer> mascotasRefugiadasIDs;
	private ArrayList<Integer> mascotasSolicitudRefugioIDs;
	private ArrayList<Integer> mascotasAdoptadasIDs;
	private ArrayList<Integer> mascotasAdoptablesIDs;
	private ArrayList<Integer> mascotasSolicitudAdopcionIDs;
	private boolean refugiante;
	private boolean administrador;
	private CondicionesRefugio condicionesRef;
	private double ponderadoCalificacion;

	// private twitter cuentaTwitter;

	public Usuario(String pNickname, String pNombre, String pApellidos, Integer pCedula, String pContrasenia,
			Integer pTelefono, String pLapsoEmparejamiento) {
		nickname = pNickname;
		nombre = pNombre;
		apellidos = pApellidos;
		cedula = pCedula;
		contrasenia = pContrasenia;
		telefono = pTelefono;
		lapsoEmparejamiento = pLapsoEmparejamiento;
		refugiante = false; // se instancian las personas como NO refugiantes
		administrador = false;

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

	public Integer getCedula() {
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

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getLapsoEmparejamiento() {
		return lapsoEmparejamiento;
	}

	public void setLapsoEmparejamiento(String lapsoEmparejamiento) {
		this.lapsoEmparejamiento = lapsoEmparejamiento;
	}

	public Integer getDiasUltimoEmparejamiento() {
		return diasUltimoEmparejamiento;
	}

	public void setDiasUltimoEmparejamiento(int diasUltimoEmparejamiento) {
		this.diasUltimoEmparejamiento = diasUltimoEmparejamiento;
	}

	public ArrayList<Integer> getMascotasPerdidasIDs() {
		return mascotasPerdidasIDs;
	}

	public void addMascotaPerdidaID(Integer mascotaPerdidaID) {
		this.mascotasPerdidasIDs.add(mascotaPerdidaID);
	}

	public Integer removeMascotaPerdidaID(Integer mascotaPerdidaID) throws IDMascotaNoEncontradaException {
		int posMascota = mascotasPerdidasIDs.indexOf(mascotaPerdidaID);
		if (posMascota == -1) {
			throw new IDMascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return this.mascotasPerdidasIDs.remove(posMascota);
	}

	public ArrayList<Integer> getMascotasEncontradasIDs() {
		return mascotasEncontradasIDs;
	}

	public void addMascotaEncontradaID(Integer mascotaEncontradaID) {
		this.mascotasEncontradasIDs.add(mascotaEncontradaID);
	}

	public Integer removeMascotaEncontradaID(Integer mascotaEncontradaID) throws IDMascotaNoEncontradaException {
		int posMascota = mascotasEncontradasIDs.indexOf(mascotaEncontradaID);
		if (posMascota == -1) {
			throw new IDMascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return this.mascotasEncontradasIDs.remove(posMascota);
	}

	public ArrayList<Integer> getMascotasLocalizadasIDs() {
		return mascotasLocalizadasIDs;
	}

	public void addMascotaLocalizadasID(Integer mascotaLocalizadaID) {
		this.mascotasLocalizadasIDs.add(mascotaLocalizadaID);
	}

	public Integer removeMascotaLocalizadasID(Integer mascotaLocalizadaID) throws IDMascotaNoEncontradaException {
		int posMascota = mascotasLocalizadasIDs.indexOf(mascotaLocalizadaID);
		if (posMascota == -1) {
			throw new IDMascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return this.mascotasLocalizadasIDs.remove(posMascota);
	}

	public ArrayList<Integer> getMascotasRefugiadasIDs() {
		return mascotasRefugiadasIDs;
	}

	public void addMascotaRefugiadaID(Integer mascotaRefugiadaID) {
		this.mascotasRefugiadasIDs.add(mascotaRefugiadaID);
	}

	public Integer removeMascotaRefugiadaID(Integer mascotaRefugiadaID) throws IDMascotaNoEncontradaException {
		int posMascota = mascotasRefugiadasIDs.indexOf(mascotaRefugiadaID);
		if (posMascota == -1) {
			throw new IDMascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return this.mascotasRefugiadasIDs.remove(posMascota);
	}

	public ArrayList<Integer> getMascotasSolicitudRefugioIDs() {
		return mascotasSolicitudRefugioIDs;
	}

	public void addMascotaSolicitudRefugioID(Integer mascotaSolicitudRefugioID) {
		this.mascotasSolicitudRefugioIDs.add(mascotaSolicitudRefugioID);
	}

	public Integer removeMascotaSolicitudRefugioID(Integer mascotaSolicitudRefugioID)
			throws IDMascotaNoEncontradaException {
		int posMascota = mascotasSolicitudRefugioIDs.indexOf(mascotaSolicitudRefugioID);
		if (posMascota == -1) {
			throw new IDMascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return this.mascotasSolicitudRefugioIDs.remove(posMascota);
	}

	public ArrayList<Integer> getMascotasAdoptadasIDs() {
		return mascotasAdoptadasIDs;
	}

	public void addMascotasAdoptadasIDs(Integer mascotaAdoptadaIDs) {
		this.mascotasAdoptadasIDs.add(mascotaAdoptadaIDs);
	}

	public Integer removeMascotasAdoptadasID(Integer mascotaAdoptadaID) throws IDMascotaNoEncontradaException {
		int posMascota = mascotasAdoptadasIDs.indexOf(mascotaAdoptadaID);
		if (posMascota == -1) {
			throw new IDMascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return this.mascotasAdoptadasIDs.remove(posMascota);
	}

	public ArrayList<Integer> getMascotasSolicitudAdopcionIDs() {
		return mascotasSolicitudAdopcionIDs;
	}

	public void addMascotaSolicitudAdopcionID(Integer mascotaSolicitudAdopcionID) {
		this.mascotasSolicitudAdopcionIDs.add(mascotaSolicitudAdopcionID);
	}

	public Integer removeMascotaSolicitudAdopcionID(Integer mascotaSolicitudAdopcionID)
			throws IDMascotaNoEncontradaException {
		int posMascota = mascotasSolicitudAdopcionIDs.indexOf(mascotaSolicitudAdopcionID);
		if (posMascota == -1) {
			throw new IDMascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return this.mascotasAdoptadasIDs.remove(posMascota);
	}

	public ArrayList<Integer> getMascotasAdoptablesIDs() {
		return mascotasAdoptablesIDs;
	}

	public void addMascotaAdoptableID(Integer mascotaAdoptableID) {
		this.mascotasAdoptablesIDs.add(mascotaAdoptableID);
	}

	public Integer removeMascotaAdoptableID(Integer mascotaAdoptablID) throws IDMascotaNoEncontradaException {
		int posMascota = mascotasSolicitudAdopcionIDs.indexOf(mascotaAdoptablID);
		if (posMascota == -1) {
			throw new IDMascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return this.mascotasAdoptadasIDs.remove(posMascota);
	}

	public boolean isRefugiante() {
		return refugiante;
	}

	public void setRefugiante(boolean refugiante) {
		this.refugiante = refugiante;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public CondicionesRefugio getCondicionesRefugio() {
		return condicionesRef;
	}

	public void setCondicionesRefugio(CondicionesRefugio pCondiciones) {
		condicionesRef = pCondiciones;
	}

	public void addDiasTranscurridos() {
		diasUltimoEmparejamiento++;
		if (lapsoEmparejamiento.equals("SEMANAL")) {
			if (diasUltimoEmparejamiento == 7) {
				diasUltimoEmparejamiento = 0;
			}
		}
		if (lapsoEmparejamiento.equals("MENSUAL")) {
			if (diasUltimoEmparejamiento == 30) {
				diasUltimoEmparejamiento = 0;
			}
		}

	}

	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void addCalificacion(Calificacion Calificacion) {
		calcularPonderado(Calificacion);
		this.calificaciones.add(Calificacion);
	}
	
	private void calcularPonderado(Calificacion ultimaCalificacion){
		ponderadoCalificacion = (ponderadoCalificacion * calificaciones.size() + ultimaCalificacion.getEstrellas())
								/ calificaciones.size() + 1; // +1 de la calificación que está agregando
		
		if (ponderadoCalificacion < Principal.getCalificacionMinimaPermitidaUsuarios()
				&& Principal.isUsuarioEnListaBlanca(nickname))
		{
			Principal.transladarUsuarioListaNegra(this);
		} else
			if (Principal.negra.contains(this)) {  
				Principal.transladarUsuarioListaBlanca(this);
		}
	}
	
	
	
	
}
