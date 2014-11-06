package dogslovers.control;

import java.util.*;

import dogslovers.modelo.Usuario;

public class Tiempo {
	private static Calendar fechaSistema;
	
	private static int diaInicioProduccion;
	private static int mesInicioProduccion;
	private static int anioInicioProduccion;
	
	public static void setFechaInicioProduccion(int pDia, int pMes, int pAnio){
		diaInicioProduccion = pDia;
		mesInicioProduccion = pMes;
		anioInicioProduccion = pAnio;
		establecerInicio();
	}

	private static void establecerInicio() {
		
	}
	
	
	
	
}
