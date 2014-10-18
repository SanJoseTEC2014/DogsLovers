package dogslovers.control;

import java.awt.EventQueue;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dogslovers.modelo.Mascota;
import dogslovers.modelo.Suceso;
import dogslovers.vista.FormularioBusquedaMascotas;

public class Principal {

	private static LinkedList<Mascota> prototipo;
	
	public static void inicializarMascotas() {
		Mascota.especies.add("Perro");
		Mascota.razas.add( new String[]{ "Otro", "Chihuahua", "Schnauzer", "Doberman", "Salchicha" } );
		prototipo = new LinkedList<Mascota>();
	}
	
	public static LinkedList<Mascota> ordenarMascotasExtravioReciente(LinkedList<Mascota> pLista){
		Collections.sort(pLista, new ComparadorFechasRecientes());
		return pLista;
	}

	public static void main(String[] args) {
		
		// Establece un look and feel metálico, si no lo encuentra, establece el look and feel del sistema operativo.
		/*
		try {
			UIManager.setLookAndFeel(javax.swing.plaf.nimbus.NimbusLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
				e2.printStackTrace();
			}
		}
		*/		
		inicializarMascotas();
		prototipo.add(new Mascota("Lucky", 83511265, "bormo1218@gmail.com", 0, 1, new Suceso("Heredia", 26, 9, 2014, "Fue horrible."), 50000, "Agradable."));
		/*
		for (Mascota i : prototipo){	System.out.println(i);		}
		*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioBusquedaMascotas window = new FormularioBusquedaMascotas(prototipo);
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
