package dogslovers.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

import dogslovers.control.excepciones.FechaInvalidaException;

public class Tiempo {
	private static Calendar fechaSistema;
	
	private static Integer diaInicioProduccion;
	private static String mesInicioProduccion;
	private static Integer anioInicioProduccion;
	
	public static void setFechaInicioProduccion(String pDia, String pMes, String pAnio) throws FechaInvalidaException{
		validarFecha(pDia, pMes, pAnio);
		diaInicioProduccion = Integer.parseInt(pDia);
		mesInicioProduccion = pMes;
		anioInicioProduccion = Integer.parseInt(pAnio);
		establecerInicio();
		JOptionPane.showMessageDialog(null, fechaSistema.getTime());
	}

	private static void validarFecha(String pDia, String pMes, String pAnio) throws FechaInvalidaException{
		// Se intenta contemplar todo caso de error.
	    if (pDia == null || pDia.equals("") || pMes == null ||
	    	pMes.equals("") || pAnio == null || pAnio.equals("")){
	    	throw new FechaInvalidaException("Campos vacíos.");
	    }
	    SimpleDateFormat validador = new SimpleDateFormat("dd/MMMM/yyyy");
	    try {
			validador.parse(pDia + "/" + pMes + "/" + pAnio);
		} catch (ParseException ex) {
			throw new FechaInvalidaException("Fecha inválida.\n", ex);
		}
	}
	
	private static void establecerInicio() throws FechaInvalidaException {
		SimpleDateFormat validador = new SimpleDateFormat("dd/MMMM/yyyy");
		try {
			fechaSistema = new Calendar.Builder()
					.setCalendarType("iso8601")
					.setInstant(validador
							.parse(diaInicioProduccion + 
							 "/" + mesInicioProduccion +
							 "/" + anioInicioProduccion)
					).build();
		} catch (ParseException ex) {
			throw new FechaInvalidaException("Error inesperado del sistema. \n" +
											"Contacte al equipo de desarrollo.", ex);
		}
	}
	
	
	
	
}
