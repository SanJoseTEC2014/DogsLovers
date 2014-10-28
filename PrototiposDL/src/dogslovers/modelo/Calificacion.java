package dogslovers.modelo;

public class Calificacion {
	private Integer estrellas;
	private String mensaje;
	private String nicknameCalificante;

	public Integer getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public Calificacion(String pNicknameCalificante, Integer pEstrellas, String pMensaje) {
		nicknameCalificante = pNicknameCalificante;
		estrellas = pEstrellas;
		mensaje = pMensaje;
	}
}
