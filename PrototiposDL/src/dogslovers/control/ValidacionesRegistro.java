package dogslovers.control;

/**	 Controlador ValidacionesRegistro: 
 * 	 Este controlador se encarga de validar cada uno de los datos
 *   ingresados por un usuario cuando este intenta realizar un registro en
 *   el sistema.
 *  
 *	 Fecha de creación: 10/11/2014
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
 *  
 */

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
		 // Compila la expresià¹“n regular dada como un Pattern.
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
