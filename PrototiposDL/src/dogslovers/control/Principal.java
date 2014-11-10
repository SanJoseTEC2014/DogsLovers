package dogslovers.control;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import dogslovers.control.excepciones.*;
import dogslovers.modelo.*;
import dogslovers.recursos.Diseno;

public class Principal {
	public static final String directorioProyecto = System.getProperty("user.dir");
	public static ArrayList<Mascota> perdidas = new ArrayList<Mascota>();
	public static ArrayList<Mascota> encontradas = new ArrayList<Mascota>();
	public static ArrayList<Mascota> localizadas = new ArrayList<Mascota>();
	public static ArrayList<Mascota> refugiadas = new ArrayList<Mascota>();
	public static ArrayList<Mascota> adoptadas = new ArrayList<Mascota>();
	public static ArrayList<Mascota> enAdopcion = new ArrayList<Mascota>();
	public static ArrayList<Mascota> muertas = new ArrayList<Mascota>();
	public static ArrayList<Usuario> blanca = new ArrayList<Usuario>();
	public static ArrayList<Usuario> negra = new ArrayList<Usuario>();
	public static ArrayList<Organizacion> organizaciones = new ArrayList<Organizacion>();
	public static ArrayList<Donacion> donaciones = new ArrayList<Donacion>();
	
	public static CoordinadorVisual coordinador;
	
	public static Usuario getUsuarioListaBlanca(String pNickname) throws UsuarioNoExisteException{
		for (Usuario x : blanca){
			if (x.getNickname().equals(pNickname)) return x;
		}
		throw new UsuarioNoExisteException("El usuario no aparece registrado.");
	}
	
	public static void inicializarMascotas() {
		Mascota.addEspecie("Perro");
		Mascota.addRaza("Perro", "Chihuahua");
		Mascota.addRaza("Perro", "Dálmata");
		Mascota.addRaza("Perro", "Schanuzer");
		Mascota.addRaza("Perro", "Casizagua");
		Mascota.addRaza("Perro", "Poodle");
		Mascota.addRaza("Perro", "Rottweiler");
		Mascota.addRaza("Perro", "Golden Retreiver");
		
		Suceso suceso1 = new Suceso("lizchavca", "San José", "Se perdió chingo.");
		Mascota mascota1 = new Mascota("Waffles", "Perro", "Otro", 500000000, "ola k ase");
		mascota1.addPerdida(suceso1);
		mascota1.setColor("Negro");
		mascota1.setTamanio("Grande");
		mascota1.setSexo("Macho");
		
		Suceso suceso2 = new Suceso("lapc506", "Heredia", "Se perdió con ropa.");
		Mascota mascota2 = new Mascota("Chochoi", "Gato", "Otro", 0, "meeeooowww");
		mascota2.addEncuentro(suceso2);
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
	
	public static void inicializarUsuarios() {
		
		Usuario.setCalificacionMinimaPermitidaUsuarios(3.0);
		
		blanca.add(new Usuario("lizchavca", "Liza", "Chaves Carranza",
				116070870, "wat", 89456736, "lizchavca@gmail.com", "sabanilla"));
		blanca.get(0).addCalificacion(new Calificacion("Isaac", 4, "bakaa"));
		//blanca.get(0).addCalificacion(new Calificacion("KAKO", 0, "bakaaa ne"));
		blanca.get(0).setCondicionesRefugio(new CondicionesRefugio(true, false, true, true, "caca"));
		
		blanca.get(0).setRefugiante(true);
	}
	
//	public static ArrayList<Mascota> ordenarMascotasExtravioReciente(LinkedList<Mascota> pLista){
//		Collections.sort(pLista, new ComparadorFechasRecientes());
//		return pLista;
//	}
	
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
		
		Tiempo.setFechaInicioProduccion(Calendar.getInstance());
		Diseno.inicializarFuentePaws();
		Diseno.inicializarLookAndFeel();
		
		inicializarMascotas();
		inicializarUsuarios();
		
		CasosPrueba.cargarDocumentoUsuariosPrueba();
		CasosPrueba.cargarDocumentoMascotasPrueba();

		
		// VentanaDetallesMascota: encontradas.get(0).clone(), false
		
		// PRUEBA ENVIANDO CORREOS CON COINCIDENCIAS
		/*
		try {
			Correo.enviarCoincidencias(encontradas, encontradas.get(0), blanca.get(0));
		} catch (MessagingException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(),
			"Error al enviar el correo.", JOptionPane.ERROR_MESSAGE);
		}
		*/
		
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				coordinador = new CoordinadorVisual();
				//coordinador.mostrarInicioSesion();
				coordinador.mostrarInicioSesion();
			}
		});

	}
	
	// TODO Hay que organizar cómo ordenar en orden
	// de fechas recientes los resultados de una búsqueda.
	/*
	private static class ComparadorFechasRecientes implements Comparator<Mascota>{
		@Override
		public int compare(Mascota arg0, Mascota arg1) {
			if( arg0.getPerdida().getFecha().getTime().before( arg1.getPerdida().getFecha().getTime() ) ){
				return 1;
	        } else {
	            return -1;
	        }
		}
	}
	*/

	public static boolean isUsuarioEnListaBlanca(String nickname) { // metodo se puede sustituir blanca.contains(usuario)
		for (Usuario usuario : blanca ){
			if (usuario.getNickname().equals(nickname)) return true;
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

	public static ArrayList<Usuario> getCopiaUsuarios() {
		ArrayList<Usuario> copia = new ArrayList<Usuario>();
	    for(Usuario usuario : blanca) copia.add((Usuario) usuario.clone());
	    for(Usuario usuario : negra) copia.add((Usuario) usuario.clone());
	    return copia;
	}
	
	public static ArrayList<Usuario> getCopiaUsuariosRefugiantes() {
		ArrayList<Usuario> copia = new ArrayList<Usuario>();
	    for(Usuario usuario : blanca) if(usuario.isRefugiante()) copia.add((Usuario) usuario.clone());
	    for(Usuario usuario : negra) copia.add((Usuario) usuario.clone());
	    return copia;
	}

	public static Mascota getMascotaID(String IDmascota) throws MascotaNoEncontradaException {
		for (Mascota mascota : perdidas) if (IDmascota.equals(mascota.getID().toString())) return mascota;
		for (Mascota mascota : encontradas) if (IDmascota.equals(mascota.getID().toString())) return mascota;
		for (Mascota mascota : refugiadas) if (IDmascota.equals(mascota.getID().toString())) return mascota;
		for (Mascota mascota : adoptadas) if (IDmascota.equals(mascota.getID().toString())) return mascota;
		for (Mascota mascota : enAdopcion) if (IDmascota.equals(mascota.getID().toString())) return mascota;
		throw new MascotaNoEncontradaException("Error inesperado no se pueden cargar los detalles de la mascota");
	}
}
