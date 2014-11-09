package dogslovers.recursos;

import java.io.*;
import java.util.*;

import dogslovers.control.Principal;

public class DocumentoCasosPrueba {
	public static final String directorioCasosPrueba =
			Principal.directorioProyecto +
			"\\src\\dogslovers\\recursos\\casosprueba\\";
	
	private LinkedList<LinkedList<String>> documento;

	public DocumentoCasosPrueba(String pNombreArchivo) throws FileNotFoundException, IOException {
		BufferedReader archivo = new BufferedReader(new FileReader(directorioCasosPrueba + pNombreArchivo));
		documento = new LinkedList<LinkedList<String>>();
		
		LinkedList<String> lineasArchivo = new LinkedList<String>();
		String lineaActual;
		while ( (lineaActual = archivo.readLine()) != null ) {
			lineasArchivo.add(lineaActual);
		}
		// Sección de Tokeniza
		for (String pLinea : lineasArchivo)
		{
			LinkedList<String> tokens = new LinkedList<String>();
			for (String token : pLinea.split(";")) tokens.add(token);
			documento.add(tokens);
		}
		archivo.close();
	}
	
	public LinkedList<String> getRegistro(int indice){
		return documento.get(indice);
	}
	
	public int getDocumentoSize() {
		return documento.size();
	}

}
