package dogslovers.vista;

import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import dogslovers.modelo.Usuario;

public class VentanaCalificaciones extends JFrame {
	private JTable tablaCalificaciones;
	private JScrollPane panelScrol;
	String Titulos[] = {"Nick Calificante", "Calificación", "Comentario"};

	public VentanaCalificaciones() {
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		setSize(400,400);
		tablaCalificaciones = new JTable();
		tablaCalificaciones.setAutoCreateRowSorter(true);
		panelScrol = new JScrollPane();
		getContentPane().add(panelScrol);
		panelScrol.setViewportView(tablaCalificaciones);
	}
	public void setUsuario(Usuario usuarioActual) {
		tablaCalificaciones = new JTable(usuarioActual.getArrayCalificaciones(), Titulos );
	}
}
	
