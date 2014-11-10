package dogslovers.modelo;

import java.math.*;
import java.text.*;
import java.util.*;

import dogslovers.modelo.ColeccionMascotas;
import dogslovers.control.MediadorMensajes;
import dogslovers.control.Principal;
import dogslovers.control.excepciones.MascotaNoEncontradaException;
import dogslovers.control.excepciones.UsuarioNoExisteException;

public class Usuario implements Comunicable {

	public static final List<String> lapsos = Arrays.asList("Diario", "Semanal", "Mensual");
	private static Double calificacionMinimaPermitida;
	
	public static Double getCalificacionMinimaPermitida() {
		return calificacionMinimaPermitida;
	}

	public static void setCalificacionMinimaPermitidaUsuarios(Double pCalificacion) {
		calificacionMinimaPermitida = pCalificacion;
	}
	
	private String nickname;
	private String nombre;
	private String apellidos;
	private Integer cedula;
	private String contrasenia;
	private Integer telefono;
	private String correo;
	private String direccion;
	private String lapsoEmparejamiento;
	private Integer diasUltimoEmparejamiento;
	private ArrayList<Calificacion> calificaciones;
	private ColeccionMascotas misMascotas;
	private BandejaMensajes buzon;
	private boolean refugiante;
	private boolean administrador;
	private CondicionesRefugio condicionesRef;
	private Double ponderadoCalificacion;

	public Usuario(String pNickname, String pNombre, String pApellidos, Integer pCedula, String pContrasenia,
		Integer pTelefono, String pCorreo, String pDireccion) {
		nickname = pNickname;
		nombre = pNombre;
		apellidos = pApellidos;
		cedula = pCedula;
		contrasenia = pContrasenia;
		telefono = pTelefono;
		correo = pCorreo;
		calificaciones = new ArrayList<Calificacion>();
		misMascotas = new ColeccionMascotas();
		buzon = new BandejaMensajes();
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
		//lapsos.get(1) == Semanal
		if (lapsoEmparejamiento.equals(lapsos.get(1))) {
			if (diasUltimoEmparejamiento == 7) {
				diasUltimoEmparejamiento = 0;
			}
		}
		//lapsos.get(2) == Mensual
		if (lapsoEmparejamiento.equals(lapsos.get(2))) {
			if (diasUltimoEmparejamiento == 30) {
				diasUltimoEmparejamiento = 0;
			}
		}

	}

	public ColeccionMascotas getMascotas() {
		return misMascotas;
	}
	
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	
	public BandejaMensajes getBuzon(){
		return buzon;
	}

	public void addCalificacion(Calificacion pCalificacion) {
		//System.out.println(pCalificacion.getEstrellas());
		actualizarPonderado(pCalificacion.getEstrellas());
		//System.out.println(ponderadoCalificacion);
		this.calificaciones.add(pCalificacion);
		//System.out.println(ponderadoCalificacion);
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
		
		if (ponderadoCalificacion < calificacionMinimaPermitida	&& Principal.isUsuarioEnListaBlanca(nickname))
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
	
	@Override
	public void enviarMensaje(String pTipoMensaje, Mascota pMascota, String pNickDestino) throws UsuarioNoExisteException{
		MediadorMensajes.recibirMensaje(
			new Mensaje(pMascota,
				new Suceso(this.nickname, this.direccion, pTipoMensaje),
			pNickDestino)
		);
	}
	
	@Override
	public void recibirMensaje(Mensaje pMensaje) {
		switch (pMensaje.getSuceso().getDescripcion()){
			// Mensajes de mayor prioridad
			
			
			// Mensajes de menor prioridad
			case Mensaje.notificacion_SOLICITUD_REFUGIO:
			{
				buzon.recibirSolicitudRefugio(pMensaje);
			}
			break;
			case Mensaje.notificacion_CONFIRMACION_SOLICITUD_REFUGIO:
			{
				buzon.recibirConfirmacionRefugio(pMensaje);
			}
			break;
			case Mensaje.notificacion_RECHAZO_SOLICITUD_REFUGIO:
			{
				buzon.recibirRechazoRefugio(pMensaje);
			}
			break;
			case Mensaje.notificacion_SOLICITUD_ADOPCION:
			{
				buzon.recibirSolicitudAdopcion(pMensaje);
			}
			break;
			case Mensaje.notificacion_CONFIRMACION_SOLICITUD_ADOPCION:
			{
				buzon.recibirConfirmacionAdopcion(pMensaje);
			}
			break;
			case Mensaje.notificacion_RECHAZO_SOLICITUD_ADOPCION:
			{
				buzon.recibirRechazoAdopcion(pMensaje);
			}
			break;
		}
	}
	
	public String[][] getArrayCalificaciones(){
		String[][] ArregloCalificaciones = new String[calificaciones.size()][3];
		for (int i = 0; i < calificaciones.size(); i++){
			ArregloCalificaciones[i][0] = calificaciones.get(i).getNicknameCalificante();
			ArregloCalificaciones[i][1] = Integer.toString(calificaciones.get(i).getEstrellas());
			ArregloCalificaciones[i][2] = calificaciones.get(i).getMensaje();
		}
		return ArregloCalificaciones;
	}
	
	public Usuario clone() {
		  Usuario clone = new Usuario(nickname, nombre, apellidos, cedula, "", telefono, correo, direccion);
		  return clone;
	}
	
	
}
