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
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Suceso getDetalle() {
		return detalle;
	}
	public void setDetalle(Suceso detalle) {
		this.detalle = detalle;
	}
	public Integer getOrganizacionID() {
		return organizacionID;
	}
	public void setOrganizacionID(Integer organizacionID) {
		this.organizacionID = organizacionID;
	}

	
}
