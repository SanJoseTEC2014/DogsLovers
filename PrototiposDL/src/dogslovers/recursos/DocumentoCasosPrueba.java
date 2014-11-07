package dogslovers.recursos;

import java.io.*;
import java.util.LinkedList;
import dogslovers.control.Principal;

public class DocumentoCasosPrueba {
	public static final String directorioCasosPrueba = Principal.directorioProyecto +
										"\\src\\dogslovers\\recursos\\casosprueba\\";
	
	private LinkedList<String[]> documento;
	
	public DocumentoCasosPrueba(String pNombreArchivo) throws FileNotFoundException, IOException {
		BufferedReader archivo = new BufferedReader(new FileReader(directorioCasosPrueba + pNombreArchivo));
		LinkedList<String> lineas = new LinkedList<String>();
		String lineaActual;
		while ( (lineaActual = archivo.readLine()) != null ) {
			lineas.add(lineaActual);
		}
		tokenizar(lineas);
		archivo.close();
	}
	
	private void tokenizar(LinkedList<String> lineas){
		for (String pLinea : lineas)
		{
			LinkedList<String> tokens = new LinkedList<String>();
	        while (pLinea.indexOf(";") == -1){
	        	tokens.add(pLinea.substring(0, pLinea.indexOf(";")));
	        	pLinea = pLinea.substring(pLinea.indexOf(";") + 1, pLinea.length());
	        }
	        tokens.add(pLinea); // Añade el último token sin ;
	        documento.add((String[]) tokens.toArray());
		}
	}
}
