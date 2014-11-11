package dogslovers.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dogslovers.control.Principal;
import dogslovers.control.excepciones.MascotaNoEncontradaException;
import dogslovers.modelo.Mascota;
import dogslovers.modelo.ModeloTablaMascotas;
import dogslovers.recursos.Diseno;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaListaTodasMascotas extends JFrame {
	private JTable tablaMascotas;
	private JLabel labelTitulo;
	private JButton botonVerDetallesUsuario;
	private JButton botonLocalizacion;
	private JLabel espacioIzq;
	public VentanaListaTodasMascotas() {
		getContentPane().setBackground(Diseno.fondoVentanas);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setHgap(20);
		borderLayout.setVgap(20);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		labelTitulo = new JLabel();
		labelTitulo.setFont(Diseno.fuenteTitulosVentanas.deriveFont(35f));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setOpaque(false);
		panel.add(labelTitulo, BorderLayout.NORTH);
		
		tablaMascotas = new JTable();
		getContentPane().add(tablaMascotas, BorderLayout.CENTER);
		
		espacioIzq = new JLabel(" ");
		getContentPane().add(espacioIzq, BorderLayout.WEST);
		
		JLabel espacioDer = new JLabel(" ");
		getContentPane().add(espacioDer, BorderLayout.EAST);
		
		JPanel marcoBotones = new JPanel();
		marcoBotones.setOpaque(false);
		getContentPane().add(marcoBotones, BorderLayout.SOUTH);
		
		botonVerDetallesUsuario = new JButton("Ver detalles del Usuario Asociado");
		botonVerDetallesUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDetallesMascota();
			}
		});
		marcoBotones.add(botonVerDetallesUsuario);
		
		botonLocalizacion = new JButton("Localic\u00E9 a mi Mascota");
		marcoBotones.add(botonLocalizacion);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		marcoBotones.add(btnCancelar);
	}
	public void close(){
		this.dispose();
	}
	public void setDatosIniciales(ArrayList<Mascota> pLista, boolean emparejamiento){
		if (emparejamiento) {
			labelTitulo.setText("Resultados Emparejamiento");
		} else {
			labelTitulo.setText("Mascotas");
		}
		tablaMascotas.setModel(new ModeloTablaMascotas(pLista));
		tablaMascotas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaMascotas.setAutoCreateRowSorter(true);
	}
	private void mostrarDetallesMascota(){
		int filaSeleccionada = tablaMascotas.getSelectedRow();
		if (filaSeleccionada != -1){
			Integer idMascota = (Integer) tablaMascotas.getValueAt(filaSeleccionada, 0);
			try {
				Principal.coordinador.mostrarDetallesMascota(Principal.getMascotaID(idMascota));
			} catch (MascotaNoEncontradaException e1) {
				JOptionPane.showMessageDialog(getContentPane(),
					e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(getContentPane(),
				"Debe seleccionar una mascota primero",
				"Información", JOptionPane.INFORMATION_MESSAGE);			
		}
	}
	
}