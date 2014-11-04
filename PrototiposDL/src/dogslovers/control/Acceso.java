package dogslovers.control;

import javax.swing.JOptionPane;

import dogslovers.control.excepciones.ContraseniaIncorrectaException;
import dogslovers.control.excepciones.UsuarioNoExisteException;
import dogslovers.modelo.Usuario;

public class Acceso {
	private static Usuario usuarioActivo;
	
	private static Usuario superUsuario;
	
	private static boolean modoAdministrador;
	
	// Aplicaci�n de Singleton para el superUsuario
	static void inicializarSuperUsuario(){
		superUsuario = new Usuario("pitbull", "Super Usuario", "Pitbull Terrier", 0000000000, "terrier", 25505033, "paws_TEC@gmail.com", "MENSUAL");
		superUsuario.setAdministrador(true);
	}
	
	private static boolean isSuperUsuario(String pNickname, String pContrasenia){
		if (pNickname == superUsuario.getNickname()){
			if (pContrasenia == superUsuario.getContrasenia()) {
				return true;
			}
		} return false;
	}
		
	
	public static void validarCredenciales(String pNickname, String pContrasenia) throws Exception{
		JOptionPane.showMessageDialog(null, superUsuario.toString() +
									"\npNickname: " + pNickname + "\npContrase�a" + pContrasenia +
									"\nEst� accediendo el superusuario?: " +
									(isSuperUsuario(pNickname, pContrasenia) ? "S�" : "No"));
		if (isSuperUsuario(pNickname, pContrasenia)){
			usuarioActivo = superUsuario;
			setModoAdministrador(true);
		} else {
			Usuario usuarioPorAcceder = validarUsuarioRegistrado(pNickname);
			if (usuarioPorAcceder.getContrasenia() != pContrasenia){
				throw new ContraseniaIncorrectaException("Contrase�a incorrecta.");
			} else {
				usuarioActivo = usuarioPorAcceder;
				setModoAdministrador(usuarioActivo.isAdministrador());
			}
		}
	}
	
	private static Usuario validarUsuarioRegistrado(String pNickname) throws Exception {
		Integer i = 0;
		while (i < Principal.blanca.size() && Principal.blanca.get(i).getNickname() != pNickname){
			i++;
		}
		if (i < Principal.blanca.size()) {
			return Principal.blanca.get(i); // El usuario est� presente en la lista blanca.
		} else {
			i = 0; // Reinicia el �ndice para recorrer la lista negra
			while (i < Principal.negra.size() && Principal.negra.get(i).getNickname() != pNickname){
				i++;
			}
			if (i < Principal.negra.size()) {
				return Principal.negra.get(i); // El usuario est� presente en la lista negra.
			} else {
				throw new Exception("Usuario no registrado en el sistema.");
				// El usuario no est� presente en ninguna lista.
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