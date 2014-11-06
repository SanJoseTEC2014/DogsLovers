package dogslovers.control;

import dogslovers.control.excepciones.*;
import dogslovers.modelo.Usuario;

public class Acceso {
	private static Usuario usuarioActivo;
	
	private static Usuario superUsuario;
	
	private static boolean modoAdministrador;
	
	// Aplicación de Singleton para el superUsuario
	private static void inicializarSuperUsuario(){
		superUsuario = new Usuario("pitbull", "Superusuario", "Paws", 111111111, "terrier", 25505033, "paws_TEC@gmail.com", Usuario.lapsos.get(2));
		superUsuario.setAdministrador(true);
	}
	
	private static Usuario getInstanciaSuperUsuario(){
		if (superUsuario == null){
			inicializarSuperUsuario();
		}
		return superUsuario;
	}
	
	public static void validarCredenciales(String pNickname, String pContrasenia) throws Exception{
		/*
		JOptionPane.showMessageDialog(null, superUsuario.toString() +
									"\npNickname: " + pNickname + "\npContraseña: " + pContrasenia +
									"\nEstá accediendo el superusuario?: " +
									(isSuperUsuario(pNickname, pContrasenia) ? "Sí" : "No"));
		*/
		if (isSuperUsuario(pNickname, pContrasenia)){
			usuarioActivo = getInstanciaSuperUsuario();
			setModoAdministrador(true);
		} else {
			Usuario usuarioPorAcceder = validarUsuarioRegistrado(pNickname);
			if (usuarioPorAcceder.getContrasenia().equals(pContrasenia)){
				usuarioActivo = usuarioPorAcceder;
				setModoAdministrador(usuarioActivo.isAdministrador());
			} else {
				throw new ContraseniaIncorrectaException("Contraseña incorrecta.");
			}
		}
	}
	
	private static boolean isSuperUsuario(String pNickname, String pContrasenia){
		if (pNickname.equals(getInstanciaSuperUsuario().getNickname())){
			if (pContrasenia.equals(getInstanciaSuperUsuario().getContrasenia())) {
				return true;
			}
		} return false;
	}
	
	private static Usuario validarUsuarioRegistrado(String pNickname) throws Exception {
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
	
}