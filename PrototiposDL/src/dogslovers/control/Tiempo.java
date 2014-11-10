package dogslovers.control;

/**	 Controlador Tiempo: 
 * 	 Este controlador se encarga de manejar el tiemp
 * 
 *	 Fecha de creación: 6/11/2014
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
 *  
 */

import java.text.SimpleDateFormat;
import java.util.*;

import dogslovers.modelo.Usuario;

public class Tiempo {
	private static Calendar fechaSistema;

	public static void setFechaInicioProduccion(Calendar pFechaInicio){
		fechaSistema = pFechaInicio;
	}

	public static void avanzarDia() {
		fechaSistema.add(Calendar.DAY_OF_MONTH, 1);
		for (Usuario i : Principal.blanca){
			Emparejador.rutinaMatch(i);
		}
	}

	public static Calendar getFechaSistema(){
		return fechaSistema;
	}
	
	public static String getStringFechaSistema(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/YYYY");
		return sdf.format(fechaSistema.getTime());
	}
		

	public static boolean isFechaEstablecida() {
		return (fechaSistema != null);
	}

}
