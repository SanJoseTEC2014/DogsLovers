package dogslovers.control;

import java.awt.EventQueue;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dogslovers.modelo.Mascota;
import dogslovers.modelo.Suceso;
import dogslovers.modelo.Usuario;
import dogslovers.vista.FormularioBusquedaMascotas;

public class Principal {

	public static ArrayList<Mascota> perdidas;
	public static ArrayList<Mascota> encontradas;
	public static ArrayList<Mascota> localizadas;
	public static ArrayList<Mascota> refugiadas;
	public static ArrayList<Mascota> adoptadas;
	public static ArrayList<Mascota> muertas;
	public static ArrayList<Usuario> blanca;
	public static ArrayList<Usuario> negra;
	//public static ArrayList<Organizacion> organizaciones;
	//public static ArrayList<Donacion> donaciones;
	
	public static void inicializarMascotas() {
		Mascota.especies.add("Perro");
		Mascota.razas.add( new String[]{ "Otro", "Chihuahua", "Schnauzer", "Doberman", "Salchicha" } );
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
					FormularioBusquedaMascotas window = new FormularioBusquedaMascotas(perdidas);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	private static class ComparadorFechasRecientes implements Comparator<Mascota>{
		@Override
		public int compare(Mascota arg0, Mascota arg1) {
			if( arg0.getExtravio().getFecha().getTime().before( arg1.getExtravio().getFecha().getTime() ) ){
				return 1;
	        } else {
	            return -1;
	        }
		}
	}

}
