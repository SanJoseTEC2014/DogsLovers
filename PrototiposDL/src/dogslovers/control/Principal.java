package dogslovers.control;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.mail.*;
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
	public static final String directorioProyecto = System.getProperty("user.dir");
	private static final File archivoFuenteHuellas = new File(directorioProyecto + "\\src\\dogslovers\\recursos\\ennobled pet.ttf");
	public static Font fuenteTitulosVentanas;
	
	public static void inicializarMascotas() {
		
		
		Mascota.especies.add("Perro");
		Mascota.razas.add( new String[]{ "Otro", "Chihuahua", "Schnauzer", "Doberman", "Salchicha" });
		Mascota mascota1 = new Mascota("Waffles", "Perro", "Otro",
							new Suceso("lizchavca", "San José", 15, 5, 2013, "Se perdió chingo."),
							false, 500000000,
							"ola k ase");
		mascota1.setColor("Negro");
		mascota1.setTamanio("Grande");
		mascota1.setSexo("Macho");
		Mascota mascota2 = new Mascota("Chochoi", "Gato", "Otro",
				new Suceso("lapc506", "Heredia", 06, 11, 2014, "Se perdió con ropa."),
				true, 0, "meeeooowww");
		mascota2.setColor("Negro");
		mascota2.setTamanio("Pequeño");
		mascota2.setSexo("Macho");
		for(int i = 0; i < 10; i++) {
			encontradas.add(mascota1);
			encontradas.add(mascota2);
		}
		
		// Validación de inserción de las 100 Mascota
		// System.out.println(encontradas.size());
	}
	
//	public static ArrayList<Mascota> ordenarMascotasExtravioReciente(LinkedList<Mascota> pLista){
//		Collections.sort(pLista, new ComparadorFechasRecientes());
//		return pLista;
//	}

	public static Font getFuentePaws() throws FontFormatException, IOException {
		return Font.createFont(Font.TRUETYPE_FONT, archivoFuenteHuellas);
		// Se usa de la siguiente manera:
		// label.setFont(getFuentePaws().deriveFont(50f));
	}
	
	public static void main(String[] args) {
		/** DEMOSTRACION REFERENCIA DE OBJETOS EN MEMORIA
		
		ArrayList<Mascota> A = new ArrayList<Mascota>();
		ArrayList<Mascota> B = new ArrayList<Mascota>();
		A.add(mascota);
		System.out.println(mascota.toString());
		mascota.setNombre("Isaac");
		
		System.out.println(A.get(0).toString());
		System.out.println(mascota.toString());
		System.out.println(A.get(0) == mascota);
		A.remove(0);
		System.out.println(mascota==null);
		System.out.println(mascota.toString());
		
		// Prueba del clón 
		System.out.println(encontradas.get(0).clone().toString());
		
		// Demostración del clonado
		System.out.println(encontradas.get(0) == encontradas.get(0).clone() ? "Same" : "Different");
		
		*/
		
		// Intenta cargar la fuente "Ennobled Pet" para usarla de título en las ventanas.
		try {
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(getFuentePaws());
			fuenteTitulosVentanas = getFuentePaws();
		} catch (FontFormatException | IOException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getCause().getMessage(), JOptionPane.ERROR_MESSAGE);
			fuenteTitulosVentanas = new Font("Segoe UI Light", Font.PLAIN, 30);
		}
		
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
				/*
				
				VentanaInicioSesion window1 = new VentanaInicioSesion();
				window1.setVisible(true);
				
				VentanaDetallesUsuario window2 = new VentanaDetallesUsuario();
				Usuario Liza = new Usuario("lizchavca", "Liza", "Chaves Carranza",
											116070870, "wat", 89456736, "lizchavca@gmail.com");
				Liza.addCalificacion(new Calificacion("Isaac", 4, "bakaa"));
				window2.obtenerDatosIniciales(Liza);
				window2.setModoEdicion(false);
				window2.setVisible(true);
				
				VentanaRegistroMascotas window3 = new VentanaRegistroMascotas();
				window3.setVisible(true);
				
				VentanaBusquedaMascotas window4 = new VentanaBusquedaMascotas();
				window4.setVisible(true);
				
				VentanaDetallesMascota window5 = new VentanaDetallesMascota(encontradas.get(0).clone(), false);
				window5.setVisible(true);
				
				VentanaRegistroUsuarios window6 = new VentanaRegistroUsuarios();
				window6.setVisible(true);
				
				VentanaParametrosSistema window7 = new VentanaParametrosSistema();
				window7.setVisible(true);
				
				*/
				VentanaPrincipal window8 = new VentanaPrincipal();
				window8.setVisible(true);
				/*
				// PRUEBA ENVIANDO CORREOS CON COINCIDENCIAS 
				try {
					Correo.enviarCoincidencias(encontradas, encontradas.get(0), );
				} catch (MessagingException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),
					"Error al enviar el correo.", JOptionPane.ERROR_MESSAGE);
				}
				*/
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
	

	
	public static ArrayList<Mascota> getCopiaMascotasPerdidas(){
		ArrayList<Mascota> copia = new ArrayList<Mascota>();
	    for (Mascota mascota : perdidas) copia.add(mascota.clone());
	    return copia;
	}
	public static ArrayList<Mascota> getCopiaMascotasEncontradas(){
		ArrayList<Mascota> copia = new ArrayList<Mascota>();
	    for(Mascota mascota : encontradas) copia.add(mascota.clone());
	    return copia;
	}
	public static ArrayList<Mascota> getCopiaMascotasLocalizadas(){
		ArrayList<Mascota> copia = new ArrayList<Mascota>();
	    for(Mascota mascota : localizadas) copia.add(mascota.clone());
	    return copia;
	}
	public static ArrayList<Mascota> getCopiaMascotasRefugiadas(){
		ArrayList<Mascota> copia = new ArrayList<Mascota>();
	    for(Mascota mascota : refugiadas) copia.add(mascota.clone());
	    return copia;
	}
	public static ArrayList<Mascota> getCopiaMascotasAdoptadas(){
		ArrayList<Mascota> copia = new ArrayList<Mascota>();
	    for(Mascota mascota : adoptadas) copia.add(mascota.clone());
	    return copia;
	}
	public static ArrayList<Mascota> getCopiaMascotasEnAdopcion(){
		ArrayList<Mascota> copia = new ArrayList<Mascota>();
	    for(Mascota mascota : enAdopcion) copia.add(mascota.clone());
	    return copia;
	}
	public static ArrayList<Mascota> getCopiaMascotasMuertas(){
		ArrayList<Mascota> copia = new ArrayList<Mascota>();
	    for(Mascota mascota : muertas) copia.add(mascota.clone());
	    return copia;
	}
	
}
