package dogslovers.control;

import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

import dogslovers.modelo.Mascota;
import dogslovers.modelo.Usuario;
import dogslovers.recursos.DocumentoCasosPrueba;

public class CasosPrueba {
	public static void cargarDocumentoUsuariosPrueba(){
		try {
			DocumentoCasosPrueba usuariosPrueba = new DocumentoCasosPrueba("usuarios.csv");
			for (int i = 0; i < usuariosPrueba.getDocumentoSize(); i++){
				LinkedList<String> registro = usuariosPrueba.getRegistro(i);
				Usuario porRegistrar = new Usuario(registro.get(0), registro.get(1),
						registro.get(2) + " " + registro.get(3),
						Integer.parseInt(registro.get(4)), registro.get(5), 
						Integer.parseInt(registro.get(6)), registro.get(7), registro.get(8));
				Principal.blanca.add(porRegistrar);
			}
			JOptionPane.showMessageDialog(null,
					"Casos de prueba cargados satisfactoriamente.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
				e.getMessage(),
				"Error de casos de prueba",
				JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void cargarDocumentoMascotasPrueba(){
		try {
			DocumentoCasosPrueba mascotasPrueba = new DocumentoCasosPrueba("mascotas.csv");
			for (int i = 0; i < mascotasPrueba.getDocumentoSize(); i++){
				LinkedList<String> registro = mascotasPrueba.getRegistro(i);
				// SE ASUME QUE EL DOCUMENTO DE CASOS DE PRUEBA CONTIENE
				// SIEMPRE DIECISEIS CAMPOS POR REGISTRO:
				// Mascota porRegistrar = new Mascota(pNombre, pEspecie, pRaza, pSuceso, perdida, pRecompensa, pNotas);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
				e.getMessage(),
				"Error de casos de prueba",
				JOptionPane.ERROR_MESSAGE);
		}
	}
}
