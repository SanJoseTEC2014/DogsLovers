package dogslovers.modelo;

public class CondicionesRefugio {
	private boolean necesitaAlimentos;
	private boolean vacunada;
	private boolean castrada;
	private boolean desparacitada;

	public boolean isVacunada() {
		return vacunada;
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
	public CondicionesRefugio(boolean pNecesitaAlimentos, boolean pVacunada,
							  boolean pCastrada, boolean pDesparacitada)
	{
		necesitaAlimentos = pNecesitaAlimentos;
		vacunada = pVacunada;
		castrada = pCastrada;
		desparacitada = pDesparacitada;
	}
}






