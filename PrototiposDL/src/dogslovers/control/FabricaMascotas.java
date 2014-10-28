package dogslovers.control;

import dogslovers.modelo.Mascota;
import dogslovers.modelo.Suceso;

public class FabricaMascotas {
	private String nombre;
	private Integer numeroChip;
	private String especie;
	private String raza;
	private String color;
	private String edad;
	private String sexo;
	private String tamanio;
	private String nickUsuario;
	private Suceso suceso;
	private boolean encontrada;
	private boolean castrada;
	private boolean vacunada;
	private boolean desparacitada;
	private boolean discapacitada;
	private Integer recompensa;
	private String notas;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNumeroChip(Integer numeroChip) {
		this.numeroChip = numeroChip;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
	public void setNickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
	}
	public void setSuceso(Suceso suceso) {
		this.suceso = suceso;
	}
	public void setEncontrada(boolean encontrada) {
		this.encontrada = encontrada;
	}
	public void setCastrada(boolean castrada) {
		this.castrada = castrada;
	}
	public void setVacunada(boolean vacunada) {
		this.vacunada = vacunada;
	}
	public void setDesparacitada(boolean desparacitada) {
		this.desparacitada = desparacitada;
	}
	public void setDiscapacitada(boolean discapacitada) {
		this.discapacitada = discapacitada;
	}
	public void setRecompensa(Integer recompensa) {
		this.recompensa = recompensa;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
	
	public Mascota crearMascota() {
		return new Mascota(nombre, especie, raza, suceso, recompensa, notas);
	}
}
