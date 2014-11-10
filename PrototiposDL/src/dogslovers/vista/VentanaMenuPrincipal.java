package dogslovers.vista;

import java.awt.*;

import javax.swing.*;
import javax.swing.GroupLayout.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;

import dogslovers.control.Acceso;
import dogslovers.control.Imagenes;
import dogslovers.control.Principal;
import dogslovers.control.excepciones.ImagenNoEncontradaException;
import dogslovers.recursos.Diseno;
import dogslovers.recursos.jflow.Configuration;
import dogslovers.recursos.jflow.JFlowPanel;
import dogslovers.recursos.jflow.Shape;
import dogslovers.recursos.jflow.shape.Picture;

import java.awt.Label;
import java.awt.Canvas;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;

public class VentanaMenuPrincipal extends JFrame {
	private JFlowPanel prueba;
	JLabel lblBienvenido;
	private JMenuItem mntmSolicitarSerCasa;
	private JMenu mnAyuda;
	private JMenuItem mntmParametrosSistema;
	private JMenu mnCuenta;
	private JMenuItem mntmCondicionesDeRefugio;

	public VentanaMenuPrincipal() {
		setTitle("Paws");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(700,565);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setBackground(Diseno.fondoVentanas);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		lblBienvenido = new JLabel();
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
		mntmRegistraTuMascota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal.coordinador.mostrarRegistroMascotas();
			}
		});
		mnMascotas.add(mntmRegistraTuMascota);
		
		JMenuItem mntmMisMascotas = new JMenuItem("Mis mascotas");
		mntmMisMascotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal.coordinador.mostrarMascotasAsociadas(Acceso.getUsuarioActivo());
			}
		});
		mnMascotas.add(mntmMisMascotas);
		
		JMenuItem mntmVerEncontradas = new JMenuItem("Ver encontradas");
		mnMascotas.add(mntmVerEncontradas);
		
		JMenuItem mntmVerPerdidas = new JMenuItem("Ver perdidas");
		mnMascotas.add(mntmVerPerdidas);
		
		JMenuItem mntmVerEnAdopcin = new JMenuItem("Ver en adopci\u00F3n");
		mnMascotas.add(mntmVerEnAdopcin);
		
		JMenu mnBsqueda = new JMenu("B\u00FAsqueda");
		menuBar.add(mnBsqueda);
		
		JMenuItem mntmUsuarios = new JMenuItem("Herramienta de busqueda");
		mntmUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal.coordinador.mostrarBusqueda();
			}
		});
		mnBsqueda.add(mntmUsuarios);
		
		JMenu mnAsociaciones = new JMenu("Asociaciones");
		menuBar.add(mnAsociaciones);
		
		JMenuItem mntmListaDeAsociaciones = new JMenuItem("Lista de Asociaciones");
		mnAsociaciones.add(mntmListaDeAsociaciones);
		
		JMenuItem mntmRealizarUnaDonacin = new JMenuItem("Realizar una donaci\u00F3n");
		mnAsociaciones.add(mntmRealizarUnaDonacin);
		
		mnCuenta = new JMenu("Cuenta");
		menuBar.add(mnCuenta);
		
		JMenuItem mntmVerMisDetalles = new JMenuItem("Detalles de mi cuenta");
		mntmVerMisDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal.coordinador.mostrarDetallesUsuario(Acceso.getUsuarioActivo());
			}
		});
		mnCuenta.add(mntmVerMisDetalles);
		
		// TODO BORRAR LA LINEA 167 HASTA QUE FUNCIONE ToDO 
		mntmParametrosSistema = new JMenuItem("Parametros Sistema");
			mntmParametrosSistema.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Principal.coordinador.mostrarParametrosSistema();
				}
			});
		
		JMenuItem mntmVerMisCalificaciones = new JMenuItem("Ver mis calificaciones");
		mntmVerMisCalificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal.coordinador.mostrarCalificaciones(Acceso.getUsuarioActivo());
			}
		});
		mnCuenta.add(mntmVerMisCalificaciones);
		mnCuenta.add(mntmParametrosSistema);
		
		mntmCondicionesDeRefugio = new JMenuItem("Editar condiciones de refugio");
		mnCuenta.add(mntmCondicionesDeRefugio);
		// TODO borrar la 130 al terminar de debugguear
		
		mntmSolicitarSerCasa = new JMenuItem("Llenar solicitud refugiante");
		mnCuenta.add(mntmSolicitarSerCasa);
		
	
		mntmCondicionesDeRefugio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal.coordinador.mostrarCondicionesRefugio(Acceso.getUsuarioActivo());
			}
		});
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		
		JMenuItem mntmManualDeUso = new JMenuItem("Manual de Uso");
		mntmManualDeUso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URL("http://www.mylostpaws.weebly.com").toURI());
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnAyuda.add(mntmManualDeUso);
		
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
	
	public void setUsuario(){
		lblBienvenido.setText(Acceso.getUsuarioActivo().getNombre()+" Bienvenid@ a");
	
		if(Acceso.isAdministradorActivo()) mnCuenta.add(mntmParametrosSistema);

		if(Acceso.getUsuarioActivo().isRefugiante()) mnCuenta.add(mntmSolicitarSerCasa);

	}
}

