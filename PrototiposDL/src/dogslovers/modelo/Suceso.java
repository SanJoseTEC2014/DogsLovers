package dogslovers.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Suceso {

	private String lugar;
	private Calendar fecha;
	private String descripcion;
	
	public Suceso(String pLugar, Integer pDia, Integer pMes, Integer pAnio, String pDescripcion) {
		lugar = pLugar;
		fecha = Calendar.getInstance(); fecha.set(pAnio, pMes, pDia);
		descripcion = pDescripcion;
	}

	public String getLugar() {
		return lugar;
	}

	public Calendar getFecha() {
		return fecha;
	}
	
	
	public String getFechaString() {
		SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
		return mascara.format(fecha.getTime());
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public String toString() {
		String msg = "Lugar del suceso: " + getLugar();
		msg += "\nFecha del suceso: " + getFechaString();
		msg += "\nDescripción del suceso: " + getDescripcion();
		return msg;
	}

}
