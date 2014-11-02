package dogslovers.control;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import dogslovers.control.excepciones.*;
import dogslovers.modelo.*;
import dogslovers.vista.*;

public class Principal {

	public static ArrayList<Mascota> perdidas = new ArrayList<Mascota>();
	public static ArrayList<Mascota> encontradas = new ArrayList<Mascota>();
	public static ArrayList<Mascota> localizadas = new ArrayList<Mascota>();
	public static ArrayList<Mascota> refugiadas = new ArrayList<Mascota>();
	public static ArrayList<Mascota> adoptadas = new ArrayList<Mascota>();
	public static ArrayList<Mascota> enAdopcion = new ArrayList<Mascota>();
	public static ArrayList<Mascota> muertas = new ArrayList<Mascota>();
	public static ArrayList<Usuario> blanca = new ArrayList<Usuario>();
	public static ArrayList<Usuario> negra = new ArrayList<Usuario>();
	//public static ArrayList<Organizacion> organizaciones = new ArrayList<Mascota>;
	//public static ArrayList<Donacion> donaciones = new ArrayList<Mascota>;
	
	private static double calificacionMinimaPermitidaUsuarios = 3; // el valor por defecto es 3 
	
	
	public static final Color fondoVentanas = new Color(30, 144, 255);
	public static final Color fondoMarcosVentanas = new Color(144, 238, 144);
	
	public static void inicializarMascotas() {
		Mascota.especies.add("Perro");
		Mascota.razas.add( new String[]{ "Otro", "Chihuahua", "Schnauzer", "Doberman", "Salchicha" });
		for(int i = 0; i < 100; i++) 
			encontradas.add(new Mascota("Wáffles", "Perro", "Otro", new Suceso("", "San José", 15, 5, 2013, "Se perdió chingo."), false, 500000000,
						"Mi perro es muy bonito y se perdió, entonces quiero encontrarlo y doy mucha plata por él porque me gusta mucho y chao."));
		// System.out.println(encontradas.size()); // Validación de inserción de las 100 Mascota
	}
	
//	public static ArrayList<Mascota> ordenarMascotasExtravioReciente(LinkedList<Mascota> pLista){
//		Collections.sort(pLista, new ComparadorFechasRecientes());
//		return pLista;
//	}

	public static void main(String[] args) {
		
		// Establece un look and feel metálico, si no lo encuentra, establece el look and feel del sistema operativo.
		
		try {
			UIManager.setLookAndFeel(javax.swing.plaf.nimbus.NimbusLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
				e2.printStackTrace();
			}
		}
		
		inicializarMascotas();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicioSesion window = new VentanaInicioSesion();
					window.setVisible(true);
					FormularioBusquedaMascotas window2 = new FormularioBusquedaMascotas(encontradas);
					window2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
//	private static class ComparadorFechasRecientes implements Comparator<Mascota>{
//		@Override
//		public int compare(Mascota arg0, Mascota arg1) {
//			if( arg0.getPerdida().getFecha().getTime().before( arg1.getPerdida().getFecha().getTime() ) ){
//				return 1;
//	        } else {
//	            return -1;
//	        }
//		}
//	}

	public static boolean isUsuarioEnListaBlanca(String nickname) { // metodo se puede sustituir blanca.contains(usuario)
		for (Usuario usuario : blanca ){
			if (usuario.getNickname() == nickname) return true;
		}
		return false;
	}
	
	

	public static void transladarUsuarioListaNegra(Usuario usuario)  {
		try {
			negra.add(removeUsuarioListaBlanca(usuario));
		} catch (UsuarioNoExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error del sistema", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private static Usuario removeUsuarioListaBlanca(Usuario usuario) throws UsuarioNoExisteException {
		if (blanca.remove(usuario)){
			return usuario;
		}
		else {
			throw new UsuarioNoExisteException("El usuario no existe en lista blanca.");
		}
	}

	public static void transladarUsuarioListaBlanca(Usuario usuario) {
		try {
			blanca.add(removeUsuarioListaNegra(usuario));
		} catch (UsuarioNoExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error del sistema", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static Usuario removeUsuarioListaNegra(Usuario usuario) throws UsuarioNoExisteException {
		if (negra.remove(usuario)){
			return usuario;
		}
		else {
			throw new UsuarioNoExisteException("El usuario no existe en lista negra.");
		} 
	}

	public static double getCalificacionMinimaPermitidaUsuarios() {
		return calificacionMinimaPermitidaUsuarios;
	}

	public static void setCalificacionMinimaPermitidaUsuarios(double calificacionMinimaPermitida) {
		Principal.calificacionMinimaPermitidaUsuarios = calificacionMinimaPermitida;
	}

	
}
