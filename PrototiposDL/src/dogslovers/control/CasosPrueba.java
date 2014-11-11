package dogslovers.control;

import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

import dogslovers.modelo.Mascota;
import dogslovers.modelo.Suceso;
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
				/**
				 * registro.get(1) Nombre
				 * registro.get(2) Especie
				 * registro.get(3) Raza
				 * registro.get(4) Recompensa
				 * 
				 * SUCESO:
				 * registro.get(5) Nickname Registrante
				 * registro.get(6) Descripción
				 * registro.get(7) Lugar
				 * 
				 * registro.get(8) Sexo
				 * registro.get(9) Color
				 * registro.get(10) Tamaño
				 * registro.get(11) Estado Inicial
				 * 
				 * Características
				 * registro.get(12) Castrada
				 * registro.get(13) Vacunada
				 * registro.get(14) Desparacitada
				 * 
				 * registro.get(15) Numero Chip
				 */
				Mascota porRegistrar = new Mascota(registro.get(1), registro.get(2),
						registro.get(3), Integer.parseInt(registro.get(4)));
				switch(registro.get(11)){
				case "PERDIDO":
					porRegistrar.addPerdida(new Suceso(registro.get(5), registro.get(7), registro.get(6)));
					break;
				case "ENCONTRADO":
					porRegistrar.addEncuentro(new Suceso(registro.get(5), registro.get(7), registro.get(6)));
					break;
				case "ENADOPCION":
					porRegistrar.addAdoptable(new Suceso(registro.get(5), registro.get(7), registro.get(6)));
					break;
				}
				porRegistrar.setSexo(registro.get(8));
				porRegistrar.setColor(registro.get(9));
				porRegistrar.setTamanio(registro.get(10));
				porRegistrar.setCastrada(registro.get(12).equals("SI") ? true : false);
				porRegistrar.setVacunada(registro.get(13).equals("SI") ? true : false);
				porRegistrar.setDesparacitada(registro.get(14).equals("SI") ? true : false);
				porRegistrar.setNumeroChip(registro.get(15));
				switch(registro.get(11)){
				case "PERDIDO":
					Principal.perdidas.add(porRegistrar);
					break;
				case "ENCONTRADO":
					Principal.encontradas.add(porRegistrar);
					break;
				case "ENADOPCION":
					Principal.enAdopcion.add(porRegistrar);
					break;
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
				e.getMessage(),
				"Error de casos de prueba",
				JOptionPane.ERROR_MESSAGE);
		}
	}
}
