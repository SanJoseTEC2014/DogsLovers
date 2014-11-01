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
	
	public static void inicializarMascotas() {
		Mascota.especies.add("Perro");
		Mascota.razas.add( new String[]{ "Otro", "Chihuahua", "Schnauzer", "Doberman", "Salchicha" });
		for(int i = 0; i < 20; i++) 
		encontradas.add((new Mascota("Waffles", "Perro", "Otro", new Suceso("San José", 15, 5, 2013, "Se perdió chingo."), 500000000, "Mi perro es muy bonito y se perdió, entonces quiero"
				+ " encontrarlo y doy mucha plata por él porque me gusta mucho y chao.")));
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
					System.out.println(encontradas.size());
					FormularioBusquedaMascotas window = new FormularioBusquedaMascotas(encontradas);
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
			if( arg0.getPerdida().getFecha().getTime().before( arg1.getPerdida().getFecha().getTime() ) ){
				return 1;
	        } else {
	            return -1;
	        }
		}
	}

}
