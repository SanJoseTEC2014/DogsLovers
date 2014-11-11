package dogslovers.vista;

import javax.mail.internet.NewsAddress;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import dogslovers.control.Acceso;
import dogslovers.control.Principal;
import dogslovers.control.excepciones.MascotaNoEncontradaException;
import dogslovers.control.excepciones.UsuarioNoExisteException;
import dogslovers.modelo.ColeccionMascotas;
import dogslovers.modelo.ModeloTablaMascotas;
import dogslovers.modelo.Usuario;
import dogslovers.recursos.Diseno;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMascotasDeUsuario extends JFrame {
	private JTable tableMascotas;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Usuario usuarioActivo;
	private JRadioButton rdbtnPerdidas;
	private JRadioButton rdbtnEncontradas;
	private JRadioButton rdbtnAdoptables;
	private JRadioButton rdbtnAdoptadas;
	private JRadioButton rdbtnRefugiadas;
	private JButton botonDetalles;
	
	public VentanaMascotasDeUsuario() {
		
		setSize(500, 300);
		setBackground(Diseno.fondoVentanas);
		JLabel lblNewLabel = new JLabel("Mascotas asociadas al usuario");
		lblNewLabel.setFont(Diseno.fuenteTitulosVentanas);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		botonDetalles = new JButton("Ver detalles de mascota");
		botonDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int fila = tableMascotas.getSelectedRow();
				if (fila != -1){
					String IDMascota = (String) tableMascotas.getValueAt(fila, 0);
					try {
						Principal.coordinador.mostrarDetallesMascota(Principal.getMascotaID(Integer.parseInt(IDMascota)));
					} catch (MascotaNoEncontradaException e) {
						JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "Información", "Debe seleccionar una mascota primero", JOptionPane.INFORMATION_MESSAGE);			
				}
			}
		});
		getContentPane().add(botonDetalles, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		rdbtnPerdidas = new JRadioButton("Perdidas");
		rdbtnPerdidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableMascotas.setModel(new ModeloTablaMascotas(ColeccionMascotas.getPerdidas(usuarioActivo)));
			}
		});
		buttonGroup.add(rdbtnPerdidas);
		panel_1.add(rdbtnPerdidas);
		
		rdbtnEncontradas = new JRadioButton("Encontradas");
		rdbtnEncontradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableMascotas.setModel(new ModeloTablaMascotas(ColeccionMascotas.getEncontradas(usuarioActivo)));

			}
		});
		buttonGroup.add(rdbtnEncontradas);
		panel_1.add(rdbtnEncontradas);
		
		rdbtnAdoptables = new JRadioButton("Adoptables");
		rdbtnAdoptables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableMascotas.setModel(new ModeloTablaMascotas(ColeccionMascotas.getAdoptables(usuarioActivo)));

			}
		});
		buttonGroup.add(rdbtnAdoptables);
		panel_1.add(rdbtnAdoptables);
		
		rdbtnAdoptadas = new JRadioButton("Adoptadas");
		rdbtnAdoptadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableMascotas.setModel(new ModeloTablaMascotas(ColeccionMascotas.getAdoptadas(usuarioActivo)));

			}
		});
		buttonGroup.add(rdbtnAdoptadas);
		panel_1.add(rdbtnAdoptadas);
		
		rdbtnRefugiadas = new JRadioButton("Refugiadas");
		rdbtnRefugiadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableMascotas.setModel(new ModeloTablaMascotas(ColeccionMascotas.getRefugiadas(usuarioActivo)));
			}
		});
		buttonGroup.add(rdbtnRefugiadas);
		panel_1.add(rdbtnRefugiadas);
		
		tableMascotas = new JTable();
		panel.add(tableMascotas, BorderLayout.CENTER);
	}
	
	public void setUsuario(Usuario pUsuario){
		
		usuarioActivo = pUsuario;
		if (pUsuario == Acceso.getUsuarioActivo()) botonDetalles.setText("Editar Detalles");
		
		rdbtnPerdidas.setVisible(ColeccionMascotas.getPerdidas(pUsuario).size() != 0);
		rdbtnEncontradas.setVisible(ColeccionMascotas.getEncontradas(pUsuario).size() != 0);
		rdbtnAdoptables.setVisible(ColeccionMascotas.getAdoptables(pUsuario).size() != 0);
		rdbtnAdoptadas.setVisible(ColeccionMascotas.getAdoptadas(pUsuario).size() != 0);
		rdbtnRefugiadas.setVisible(ColeccionMascotas.getRefugiadas(pUsuario).size() != 0); 
	}

}
