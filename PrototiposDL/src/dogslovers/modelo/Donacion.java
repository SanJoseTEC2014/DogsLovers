package dogslovers.modelo;

public class Donacion {
	private Double monto;
	private String nicknameDonante;
	private Suceso detalle;
	private Integer organizacionID;
	
	public Donacion(String pNick, Double pMonto, Suceso pDetalle, Integer pOrganizacionID) {
		nicknameDonante = pNick;
		monto = pMonto;
		detalle = pDetalle;
		organizacionID = pOrganizacionID;
	}
	public String getNicknameDonante() {
		return nicknameDonante;
	}
	public Double getMonto() {
		return monto;
	}
	public Suceso getDetalle() {
		return detalle;
	}
	public Integer getOrganizacionID() {
		return organizacionID;
	}
	
}
