package dogslovers.control;

import dogslovers.control.excepciones.ContraseniaIncorrectaException;
import dogslovers.control.excepciones.UsuarioNoExisteException;
import dogslovers.modelo.Usuario;

public class Acceso {
	private static Usuario usuarioActivo;
	
	private static Usuario superUsuario;
	
	private static boolean modoAdministrador;
	
	// Aplicación de Singleton para el superUsuario
	private static void inicializarSuperUsuario(){
		superUsuario = new Usuario("pitbull", "Super Usuario", "Pitbull Terrier", 0000000000, "terrier", 25505033, "DIARIO", false, true);
		superUsuario.setAdministrador(true);
	}
	public static Usuario getSuperUsuario(){
		if (superUsuario == null){
			inicializarSuperUsuario();
		}
		return superUsuario;
	}
	
	public static boolean validarCredenciales(String pNickname, String pContrasenia) throws UsuarioNoExisteException, ContraseniaIncorrectaException{
		if (pNickname == getSuperUsuario().getNickname()){
			if (pContrasenia == getSuperUsuario().getContrasenia()) {
				usuarioActivo = getSuperUsuario();
				setModoAdministrador(true);
			} else {
				throw new ContraseniaIncorrectaException("No puede acceder como superusuario.");
			}
		} else {
			Usuario usuarioPorAcceder = validarUsuarioRegistrado(pNickname);
			if (usuarioPorAcceder.getContrasenia() != pContrasenia){
				throw new ContraseniaIncorrectaException("Contraseña incorrecta.");
			}
			if (usuarioPorAcceder.isAdministrador()){
				setModoAdministrador(true);
			} else {
				setModoAdministrador(false);
			}
		}
		return true;
	}
	
	private static Usuario validarUsuarioRegistrado(String pNickname) throws UsuarioNoExisteException {
		Integer i = 0;
		while (i < Principal.blanca.size() && Principal.blanca.get(i).getNickname() != pNickname){
			i++;
		}
		if (i < Principal.blanca.size()) {
			return Principal.blanca.get(i); // El usuario está presente en la lista blanca.
		} else {
			i = 0; // Reinicia el índice para recorrer la lista negra
			while (i < Principal.negra.size() && Principal.negra.get(i).getNickname() != pNickname){
				i++;
			}
			if (i < Principal.negra.size()) {
				return Principal.negra.get(i); // El usuario está presente en la lista negra.
			} else {
				throw new UsuarioNoExisteException("Usuario no registrado en el sistema.");
				// El usuario no está presente en ninguna lista.
			}
		}
	}
	
	private static void setModoAdministrador(boolean opcion){
		modoAdministrador = opcion;
	}
	
	public static boolean isAdministradorActivo(){
		return modoAdministrador;
	}
	
	public static Usuario getUsuarioActivo(){
		return usuarioActivo;
	}
	
	public static void setUsuarioActivo(String pNickname, String pContrasenia){
		validarCredenciales(pNickname, pContrasenia);
	}
	
}