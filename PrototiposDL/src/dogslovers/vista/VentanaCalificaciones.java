package dogslovers.vista;

import javax.swing.JFrame;
import javax.swing.JSlider;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import dogslovers.modelo.Usuario;

public class VentanaCalificaciones extends JFrame {
	private JTable tablaCalificaciones;
	private JScrollPane panelScrol;
	public VentanaCalificaciones(Usuario usuario) {
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		setSize(400,400);
		panelScrol = new JScrollPane();
		getContentPane().add(panelScrol);
		String Titulos[] = {"Nick Calificante", "Calificación", "Comentario"};
		tablaCalificaciones = new JTable(usuario.getArraycalificaciones(), Titulos );
		panelScrol.setViewportView(tablaCalificaciones);
	}
}
	
