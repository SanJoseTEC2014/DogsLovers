package dogslovers.control;

import java.awt.Component;
import java.awt.image.ComponentSampleModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;

import dogslovers.control.excepciones.MascotaNoEncontradaException;
import dogslovers.control.excepciones.UsuarioNoExisteException;
import dogslovers.modelo.Mascota;

public class ValidacionesRegistro {

	public static boolean validarCorreo(String email) {
		final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";	
		 // Compila la expresi๓n regular dada como un Pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        // Compara la entrada dada contra este Pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
	}

	public static boolean HayCamposVacios(String[] campos) {
		for (String campo : campos) {
			if (campo.trim().isEmpty()) return true;
		}
		return false;
	}

	public static boolean isNicknameRepetido(String pNickname){
		try {
			Principal.getUsuarioListaBlanca(pNickname);
			return true;
		} catch (UsuarioNoExisteException e) {
			try {
				Principal.getUsuarioListaNegra(pNickname);
				return true;
			} catch (UsuarioNoExisteException e1) {
				return false; // No se repite
			}
		}
	}
	
	public static boolean isNumeroChipMascotaRepetido(String pNumeroChip){
		for (Mascota mascota : Principal.perdidas) 		if (mascota.getNumeroChip().equals(pNumeroChip)) return true;
		for (Mascota mascota : Principal.encontradas) 	if (mascota.getNumeroChip().equals(pNumeroChip)) return true;
		for (Mascota mascota : Principal.refugiadas) 	if (mascota.getNumeroChip().equals(pNumeroChip)) return true;
		for (Mascota mascota : Principal.adoptadas) 	if (mascota.getNumeroChip().equals(pNumeroChip)) return true;
		for (Mascota mascota : Principal.enAdopcion) 	if (mascota.getNumeroChip().equals(pNumeroChip)) return true;
		return false;
	}
}
