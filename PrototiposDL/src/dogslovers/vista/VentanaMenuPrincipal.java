package dogslovers.vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import dogslovers.control.Imagenes;
import dogslovers.control.excepciones.ImagenNoEncontradaException;
import dogslovers.recursos.Diseno;
import dogslovers.recursos.jflow.Configuration;
import dogslovers.recursos.jflow.JFlowPanel;
import dogslovers.recursos.jflow.Shape;
import dogslovers.recursos.jflow.shape.Picture;

import java.awt.Label;
import java.awt.Canvas;
import java.awt.FlowLayout;
import java.util.LinkedList;

public class VentanaMenuPrincipal extends JFrame {
	private JFlowPanel prueba;

	public VentanaMenuPrincipal() {
		setTitle("Paws");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(700,565);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setBackground(Diseno.fondoVentanas);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblBienvenido = new JLabel("Bienvenido a");
		panel.add(lblBienvenido);
		lblBienvenido.setFont(Diseno.fuenteTitulosVentanas.deriveFont(30f));
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		try {
			label_1.setIcon(new ImageIcon(Imagenes.getLogo().getScaledInstance(240, 170, BufferedImage.SCALE_FAST)));
		} catch (ImagenNoEncontradaException e1) {
			JOptionPane.showMessageDialog(getContentPane(), e1.getMessage(),
				"Error inesperado del sistema.", JOptionPane.ERROR_MESSAGE);
		}
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMascotas = new JMenu("Mascotas");
		menuBar.add(mnMascotas);
		
		JMenuItem mntmRegistraTuMascota = new JMenuItem("Registra tu mascota");
		mnMascotas.add(mntmRegistraTuMascota);
		
		JMenuItem mntmVerEncontradas = new JMenuItem("Ver encontradas");
		mnMascotas.add(mntmVerEncontradas);
		
		JMenuItem mntmVerPerdidas = new JMenuItem("Ver perdidas");
		mnMascotas.add(mntmVerPerdidas);
		
		JMenuItem mntmVerEnAdopcin = new JMenuItem("Ver en adopci\u00F3n");
		mnMascotas.add(mntmVerEnAdopcin);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmVerMisDetalles = new JMenuItem("Mis detalles");
		mnUsuarios.add(mntmVerMisDetalles);
		
		JMenuItem menuItem = new JMenuItem("");
		mnUsuarios.add(menuItem);
		
		JMenu mnBsqueda = new JMenu("B\u00FAsqueda");
		menuBar.add(mnBsqueda);
		
		JMenuItem mntmUsuarios = new JMenuItem("Usuarios");
		mnBsqueda.add(mntmUsuarios);
		
		JMenuItem mntmMascotas = new JMenuItem("Mascotas");
		mnBsqueda.add(mntmMascotas);
		
		JMenu mnAsociaciones = new JMenu("Asociaciones");
		menuBar.add(mnAsociaciones);
		
		JMenuItem mntmListaDeAsociaciones = new JMenuItem("Lista de Asociaciones");
		mnAsociaciones.add(mntmListaDeAsociaciones);
		
		JMenuItem mntmRealizarUnaDonacin = new JMenuItem("Realizar una donaci\u00F3n");
		mnAsociaciones.add(mntmRealizarUnaDonacin);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmManualDeUso = new JMenuItem("Manual de Uso");
		mnAyuda.add(mntmManualDeUso);
		
		JMenuItem mntmSolicitarSerCasa = new JMenuItem("Solicitar ser Casa Cuna");
		mnAyuda.add(mntmSolicitarSerCasa);
		
		JMenuItem mntmCondicionesDeRefugio = new JMenuItem("Condiciones Casa Cuna");
		mnAyuda.add(mntmCondicionesDeRefugio);
		
		JMenuItem mntmContctenos = new JMenuItem("Cont\u00E1ctenos");
		mnAyuda.add(mntmContctenos);
		
		Configuration configTest = new Configuration();
		configTest.shapeWidth = 0.8;
		configTest.scrollFactor = 10.0;
		configTest.framesPerSecond = 60;
		
		configTest.shapes = new LinkedList<Shape>();
		// Después de muchas pruebas unitarias,
		// el máximo de imágenes que la matriz sostiene son 10.
		for (int img = 1; img < 10; img++){ 
			try {
				configTest.shapes.add(new Picture(Imagenes.getPerfilMascota(img)));
			} catch (ImagenNoEncontradaException e) {
				break;
			}
		}
		
		prueba = new JFlowPanel(configTest);
		prueba.setOpaque(false);
		getContentPane().add(prueba);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

