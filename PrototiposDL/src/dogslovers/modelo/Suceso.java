package dogslovers.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import dogslovers.control.Tiempo;

public class Suceso {

	private String lugar;
	private Calendar fecha;
	private String descripcion;
	private String nick;
	
	public Suceso(String pNick, String pLugar, String pDescripcion) {
		nick = pNick;
		lugar = pLugar;
		// Copia el valor Date de la fecha del Sistema
		fecha = new Calendar.Builder().setCalendarType("iso8601")
				.setInstant(Tiempo.getFechaSistema().getTime()).build();
		descripcion = pDescripcion;
	}
	
	public String getNick() {
		return nick;
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
		msg += "\nUsuario reportante: " + getNick();
		return msg;
	}

}
