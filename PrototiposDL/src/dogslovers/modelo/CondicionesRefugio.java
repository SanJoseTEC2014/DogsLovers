package dogslovers.modelo;


public class CondicionesRefugio {

	private boolean necesitaAlimentos;
	private boolean soloVacunadas;
	private boolean soloCastradas;
	private boolean soloDesparacitadas;
	private String detallesAdicionales;
	
	public CondicionesRefugio(boolean pNecesitaAlimentos, boolean pVacunada,
			 boolean pCastrada, boolean pDesparacitada, String pDetallesAdicionales) {

		necesitaAlimentos = pNecesitaAlimentos;
		soloVacunadas = pVacunada;
		soloCastradas = pCastrada;
		soloDesparacitadas = pDesparacitada;
		detallesAdicionales = pDetallesAdicionales;
		
	}
	
	
	public boolean isSoloVacunada() {
		return soloVacunadas;
	}
	
	public boolean isSoloCastrada() {
		return soloCastradas;
	}
	
	public boolean isSoloDesparacitada() {
		return soloDesparacitadas;
	}

	public boolean isNecesitaAlimentos() {
		return necesitaAlimentos;
	}

	public void setNecesitaAlimentos(boolean necesitaAlimentos) {
		this.necesitaAlimentos = necesitaAlimentos;
	}

	public void setSoloVacunada(boolean vacunada) {
		this.soloVacunadas = vacunada;
	}

	public void setSoloCastrada(boolean castrada) {
		this.soloCastradas = castrada;
	}

	public void setSoloDesparacitada(boolean desparacitada) {
		this.soloDesparacitadas = desparacitada;
	}

	public String getDetallesAdicionales() {
		return detallesAdicionales;
	}

	public void setDetallesAdicionales(String detallesAdicionales) {
		this.detallesAdicionales = detallesAdicionales;

	}
}






