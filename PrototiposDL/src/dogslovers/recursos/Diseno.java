package dogslovers.recursos;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dogslovers.control.Principal;

public class Diseno {
	public static Color fondoVentanas = new Color(30, 144, 255);
	public static Color fondoMarcosVentanas = new Color(144, 238, 144);
	private static final File archivoFuenteHuellas = new File(Principal.directorioProyecto + 
								"\\src\\dogslovers\\recursos\\fuentes\\ennobled pet.ttf");
	public static Font fuenteTitulosVentanas;
	
	public static Font getFuentePaws() throws FontFormatException, IOException {
		return Font.createFont(Font.TRUETYPE_FONT, archivoFuenteHuellas);
		// Se usa de la siguiente manera:
		// label.setFont(getFuentePaws().deriveFont(50f));
	}
	
	public static void inicializarFuentePaws(){
		// Intenta cargar la fuente "Ennobled Pet" para usarla de título en las ventanas.
		try {
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(getFuentePaws());
			fuenteTitulosVentanas = getFuentePaws();
		} catch (FontFormatException | IOException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getCause().getMessage(), JOptionPane.ERROR_MESSAGE);
			fuenteTitulosVentanas = new Font("Segoe UI Light", Font.PLAIN, 30);
		}
	}
	
	public static void inicializarLookAndFeel(){
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
	}
	
	
}
