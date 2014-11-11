package dogslovers.vista;

import java.awt.*;

import javax.swing.*;

import dogslovers.control.Acceso;
import dogslovers.control.Emparejador;
import dogslovers.control.Principal;
import dogslovers.control.excepciones.MascotaNoEncontradaException;
import dogslovers.modelo.Mascota;
import dogslovers.modelo.ModeloTablaMascotas;
import dogslovers.modelo.Usuario;
import dogslovers.recursos.Diseno;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaMascotasDeUsuario extends JFrame {
	private JTable tablaMascotas;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Usuario usuarioActivo;
	private JRadioButton rdbtnPerdidas;
	private JRadioButton rdbtnEncontradas;
	private JRadioButton rdbtnAdoptables;
	private JRadioButton rdbtnAdoptadas;
	private JRadioButton rdbtnRefugiadas;
	private JButton botonDetalles;
	private JPanel panel;
	private JButton botonEmparejamiento;
	
	public VentanaMascotasDeUsuario() {
		
		setSize(500, 300);
		setBackground(Diseno.fondoVentanas);
		JLabel lblNewLabel = new JLabel("Mascotas asociadas al usuario");
		lblNewLabel.setFont(Diseno.fuenteTitulosVentanas);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		botonDetalles = new JButton("Ver detalles de mascota");
		botonDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fila = tablaMascotas.getSelectedRow();
				if (fila != -1){
					String IDMascota = (String) tablaMascotas.getValueAt(fila, 0);
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
		panel.add(botonDetalles);

		botonEmparejamiento = new JButton("Solicitar Emparejamiento bajo Demanda");
		botonEmparejamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = tablaMascotas.getSelectedRow();
				if (fila != -1){
					Integer IDMascota = (Integer) tablaMascotas.getValueAt(fila, 0);
					try {
						ArrayList<Mascota> resultadosMascota = Emparejador.emparejarBajoDemanda(Principal.getMascotaID(IDMascota));
						VentanaListaTodasMascotas ventanaResultados = new VentanaListaTodasMascotas();
						ventanaResultados.setDatosIniciales(resultadosMascota, true);
					} catch (MascotaNoEncontradaException e1) {
						JOptionPane.showMessageDialog(getContentPane(),
						e1.getMessage(), "Error inesperado del sistema.", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "Información", "Debe seleccionar una mascota primero", JOptionPane.INFORMATION_MESSAGE);			
				}
			}
		});
		botonEmparejamiento.setVisible(false);
		panel.add(botonEmparejamiento);
		
		JPanel panelContenido = new JPanel();
		getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));
		
		JPanel radios = new JPanel();
		panelContenido.add(radios, BorderLayout.NORTH);
		
		rdbtnPerdidas = new JRadioButton("Perdidas");
		rdbtnPerdidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablaMascotas.setModel(new ModeloTablaMascotas(usuarioActivo.getMascotas().getPerdidas()));
				botonEmparejamiento.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnPerdidas);
		radios.add(rdbtnPerdidas);
		
		rdbtnEncontradas = new JRadioButton("Encontradas");
		rdbtnEncontradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablaMascotas.setModel(new ModeloTablaMascotas(usuarioActivo.getMascotas().getEncontradas()));
				botonEmparejamiento.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnEncontradas);
		radios.add(rdbtnEncontradas);
		
		rdbtnAdoptables = new JRadioButton("Adoptables");
		rdbtnAdoptables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablaMascotas.setModel(new ModeloTablaMascotas(usuarioActivo.getMascotas().getAdoptables()));
				botonEmparejamiento.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnAdoptables);
		radios.add(rdbtnAdoptables);
		
		rdbtnRefugiadas = new JRadioButton("Refugiadas");
		rdbtnRefugiadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablaMascotas.setModel(new ModeloTablaMascotas(usuarioActivo.getMascotas().getRefugiadas()));
				botonEmparejamiento.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnRefugiadas);
		radios.add(rdbtnRefugiadas);
		
		rdbtnAdoptadas = new JRadioButton("Adoptadas");
		rdbtnAdoptadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablaMascotas.setModel(new ModeloTablaMascotas(usuarioActivo.getMascotas().getAdoptadas()));
				botonEmparejamiento.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnAdoptadas);
		radios.add(rdbtnAdoptadas);
		
		tablaMascotas = new JTable();
		panelContenido.add(tablaMascotas, BorderLayout.CENTER);
	}
	
	public void setUsuario(Usuario pUsuario){
		
		usuarioActivo = pUsuario;
		if (pUsuario == Acceso.getUsuarioActivo()) botonDetalles.setText("Editar Detalles");
		
		rdbtnPerdidas.setVisible(pUsuario.getMascotas().getPerdidas().size() != 0);
		rdbtnEncontradas.setVisible(pUsuario.getMascotas().getEncontradas().size() != 0);
		rdbtnAdoptables.setVisible(pUsuario.getMascotas().getAdoptables().size() != 0);
		rdbtnAdoptadas.setVisible(pUsuario.getMascotas().getAdoptadas().size() != 0);
		rdbtnRefugiadas.setVisible(pUsuario.getMascotas().getRefugiadas().size() != 0); 
	}

}
