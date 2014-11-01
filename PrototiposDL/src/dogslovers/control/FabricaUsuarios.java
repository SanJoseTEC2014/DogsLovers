package dogslovers.control;

import dogslovers.modelo.Usuario;
import dogslovers.modelo.CondicionesRefugio;

public class FabricaUsuarios {
	private String nickname;
	private String nombre;
	private String apellidos;
	private Integer cedula;
	private String contrasenia;
	private Integer telefono;
	private String lapsoEmparejamiento;
	private boolean refugiante;
	private CondicionesRefugio condiciones;
	private boolean adoptante;
//	private CuentaFacebook facebook;
//	private CuentaTwitter twitter;	
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	public void setLapsoEmparejamiento(String lapsoEmparejamiento) {
		this.lapsoEmparejamiento = lapsoEmparejamiento;
	}
	
	public void setRefugiante(boolean refugiante) {
		this.refugiante = refugiante;
	}
	
	public void setCondiciones(CondicionesRefugio condiciones) {
		this.condiciones = condiciones;
	}
	
	public void setAdoptante(boolean adoptante) {
		this.adoptante = adoptante;
	}
	
//	public void setFacebook(CuentaFacebook facebook) {
//		this.facebook = facebook;
//	}
	
//	public void setTwitter(CuentaTwitter twitter) {
//		this.twitter = twitter;
//	}
	
	public Usuario crearUsuario() {
		return new Usuario(nickname, nombre, apellidos, cedula, contrasenia,
				           telefono, lapsoEmparejamiento, refugiante, adoptante);
	}
}





