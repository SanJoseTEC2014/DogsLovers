package dogslovers.modelo;

import java.math.*;
import java.text.*;
import java.util.*;

import dogslovers.control.Principal;
import dogslovers.control.excepciones.MascotaNoEncontradaException;

public class Usuario {

	public static final List<String> lapsos = Arrays.asList("Diario", "Semanal", "Mensual");

	private String nickname;
	private String nombre;
	private String apellidos;
	private Integer cedula;
	private String contrasenia;
	private Integer telefono;
	private String correo;
	private String lapsoEmparejamiento;
	private Integer diasUltimoEmparejamiento;
	private ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
	private ArrayList<Mascota> listaMascotasPerdidas = new ArrayList<Mascota>();
	private ArrayList<Mascota> listaMascotasEncontradas = new ArrayList<Mascota>();
	private ArrayList<Mascota> listaMascotasLocalizadas = new ArrayList<Mascota>();
	private ArrayList<Mascota> listaMascotasRefugiadas = new ArrayList<Mascota>();
	private ArrayList<Mascota> listaMascotasSolicitudRefugio = new ArrayList<Mascota>();
	private ArrayList<Mascota> listaMascotasAdoptadas = new ArrayList<Mascota>();
	private ArrayList<Mascota> listaMascotasAdoptables = new ArrayList<Mascota>();
	private ArrayList<Mascota> listaMascotasSolicitudAdopcion = new ArrayList<Mascota>();
	
	
	
	
	
	private boolean refugiante;
	private boolean administrador;
	private CondicionesRefugio condicionesRef;
	private Double ponderadoCalificacion;

	public Usuario(String pNickname, String pNombre, String pApellidos, Integer pCedula, String pContrasenia,
		Integer pTelefono, String pCorreo, String pLapsoEmparejamiento) {
		nickname = pNickname;
		nombre = pNombre;
		apellidos = pApellidos;
		cedula = pCedula;
		contrasenia = pContrasenia;
		telefono = pTelefono;
		correo = pCorreo;
		lapsoEmparejamiento = pLapsoEmparejamiento;
		refugiante = false; // se instancian las personas como NO refugiantes
		administrador = false;
		ponderadoCalificacion = 5.0;
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

	public ArrayList<Mascota> getListaMascotasPerdidas() {
		return listaMascotasPerdidas;
	}

	public void addMascotaPerdida(Mascota mascotaPerdida) {
		this.listaMascotasPerdidas.add(mascotaPerdida);
	}

	public Mascota removeMascotaPerdida(Mascota mascotaPerdida) throws MascotaNoEncontradaException {
		if (!this.listaMascotasPerdidas.remove(mascotaPerdida)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return mascotaPerdida;
	}

	public ArrayList<Mascota> getListaMascotasEncontradas() {
		return listaMascotasEncontradas;
	}

	public void addMascotaEncontrada(Mascota mascotaEncontrada) {
		this.listaMascotasEncontradas.add(mascotaEncontrada);
	}

	public Mascota removeMascotaEncontrada(Mascota mascotaEncontrada) throws MascotaNoEncontradaException {
		if (!this.listaMascotasEncontradas.remove(mascotaEncontrada)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return mascotaEncontrada;
	}

	public ArrayList<Mascota> getListaMascotasLocalizadas() {
		return listaMascotasLocalizadas;
	}

	public void addMascotaLocalizadas(Mascota mascotaLocalizada) {
		this.listaMascotasLocalizadas.add(mascotaLocalizada);
	}

	public Mascota removeMascotaLocalizadas(Mascota mascotaLocalizada) throws MascotaNoEncontradaException {
		if (!this.listaMascotasLocalizadas.remove(mascotaLocalizada)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return mascotaLocalizada;
	}

	public ArrayList<Mascota> getListaMascotasRefugiadas() {
		return listaMascotasRefugiadas;
	}

	public void addMascotaRefugiada(Mascota mascotaRefugiada) {
		this.listaMascotasRefugiadas.add(mascotaRefugiada);
	}

	public Mascota removeMascotaRefugiada(Mascota mascotaRefugiada) throws MascotaNoEncontradaException {
		if (!this.listaMascotasRefugiadas.remove(mascotaRefugiada)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return mascotaRefugiada;
	}

	public ArrayList<Mascota> getListaMascotasSolicitudRefugio() {
		return listaMascotasSolicitudRefugio;
	}

	public void addMascotaSolicitudRefugio(Mascota mascotaSolicitudRefugio) {
		this.listaMascotasSolicitudRefugio.add(mascotaSolicitudRefugio);
	}

	public Mascota removeMascotaSolicitudRefugio(Mascota mascotaSolicitudRefugio) throws MascotaNoEncontradaException {
		if (!listaMascotasSolicitudRefugio.remove(mascotaSolicitudRefugio)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return mascotaSolicitudRefugio;
	}

	public ArrayList<Mascota> getListaMascotasAdoptadas() {
		return listaMascotasAdoptadas;
	}

	public void addMascotasAdoptadass(Mascota mascotaAdoptadas) {
		this.listaMascotasAdoptadas.add(mascotaAdoptadas);
	}

	public Mascota removeMascotasAdoptadas(Mascota mascotaAdoptada) throws MascotaNoEncontradaException {
		if (!this.listaMascotasAdoptadas.remove(mascotaAdoptada)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return mascotaAdoptada;
	}

	public ArrayList<Mascota> getListaMascotasSolicitudAdopcion() {
		return listaMascotasSolicitudAdopcion;
	}

	public void addMascotaSolicitudAdopcion(Mascota mascotaSolicitudAdopcion) {
		this.listaMascotasSolicitudAdopcion.add(mascotaSolicitudAdopcion);
	}

	// El remove retorna true si el objeto esta en la lista y borra el objeto en caso de no estar retorna false
	// si el ojeto no fue encotrado lanza la excepcion 
	public Mascota removeMascotaSolicitudAdopcion(Mascota mascotaSolicitudAdopcion) throws MascotaNoEncontradaException {
		if (!this.listaMascotasAdoptadas.remove(mascotaSolicitudAdopcion)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return mascotaSolicitudAdopcion;
	}

	public ArrayList<Mascota> getListaMascotasAdoptables() {
		return listaMascotasAdoptables;
	}

	public void addMascotaAdoptable(Mascota mascotaAdoptable) {
		this.listaMascotasAdoptables.add(mascotaAdoptable);
	}

	public Mascota removeMascotaAdoptable(Mascota mascotaAdoptable) throws MascotaNoEncontradaException {
		if (!this.listaMascotasAdoptadas.remove(mascotaAdoptable)) {
			throw new MascotaNoEncontradaException("La mascota no está en la lista indicada.");
		}
		return mascotaAdoptable;
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

	public void addCalificacion(Calificacion pCalificacion) {
		System.out.println(pCalificacion.getEstrellas());
		actualizarPonderado(pCalificacion.getEstrellas());
		System.out.println(ponderadoCalificacion);
		this.calificaciones.add(pCalificacion);
		System.out.println(ponderadoCalificacion);
	}
	
	public double getPonderadoCalificacion(){
		DecimalFormat redondeo = new DecimalFormat("#.#");
		redondeo.setRoundingMode(RoundingMode.HALF_UP);
		return Double.parseDouble(redondeo.format(ponderadoCalificacion));
		//return ponderadoCalificacion;
	}
	
	private void actualizarPonderado(Integer ultimaCalificacion){
		ponderadoCalificacion = (ponderadoCalificacion * calificaciones.size() + ultimaCalificacion)
								/ (calificaciones.size() + 1); // +1 de la calificación que está agregando
		
		if (ponderadoCalificacion < Principal.getCalificacionMinimaPermitidaUsuarios()
				&& Principal.isUsuarioEnListaBlanca(nickname))
		{
			Principal.transladarUsuarioListaNegra(this);
		} else
			if (Principal.negra.contains(this)) {  
				Principal.transladarUsuarioListaBlanca(this);
		}
	}
	
	public String toString(){
		return "Nombre: " + nombre + "\nNickname: " + nickname +
			   "\nContraseña: " + contrasenia + "\nAdmin?: " + (administrador ? "Sí" : "No");
	}
	
	
}
