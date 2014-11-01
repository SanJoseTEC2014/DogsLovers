package dogslovers.modelo;

public class CondicionesRefugio {
	private String tamanioMascota;
	private boolean necesitaAlimentos;
	private boolean vacunada;
	private boolean discapacitada;
	private boolean castrada;
	private boolean desparacitada;
	
	public String getTamanioMascota() {
		return tamanioMascota;
	}
	public void setTamanioMascota(String tamanioMascota) {
		this.tamanioMascota = tamanioMascota;
	}
	public boolean isVacunada() {
		return vacunada;
	}
	public boolean isDiscapacitada() {
		return discapacitada;
	}
	public boolean isCastrada() {
		return castrada;
	}
	public boolean isDesparacitada() {
		return desparacitada;
	}
	
	public boolean checkNecesitaAlimentos() {
		return necesitaAlimentos;
	}
	
	public CondicionesRefugio(String pTamanioMascota,
							  boolean pNecesitaAlimentos, boolean pVacunada,
							  boolean pDiscapacitada, boolean pCastrada, boolean pDesparacitada) {
		tamanioMascota = pTamanioMascota;
		necesitaAlimentos = pNecesitaAlimentos;
		vacunada = pVacunada;
		discapacitada = pDiscapacitada;
		castrada = pCastrada;
		desparacitada = pDesparacitada;
	}
}






