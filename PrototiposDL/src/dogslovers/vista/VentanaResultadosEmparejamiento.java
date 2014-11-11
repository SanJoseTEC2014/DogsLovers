package dogslovers.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dogslovers.control.Principal;
import dogslovers.control.excepciones.MascotaNoEncontradaException;
import dogslovers.control.excepciones.UsuarioNoExisteException;
import dogslovers.modelo.Mascota;
import dogslovers.modelo.ModeloTablaMascotas;
import dogslovers.recursos.Diseno;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaResultadosEmparejamiento extends JFrame {
	private JTable tablaEmparejamiento;
	private JLabel label;
	private JButton botonVerDetallesUsuario;
	private JButton botonLocalizacion;
	private JLabel espacioIzq;
	public VentanaResultadosEmparejamiento() {
		getContentPane().setBackground(Diseno.fondoVentanas);
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setHgap(20);
		borderLayout.setVgap(20);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		label = new JLabel("Resultados Emparejamiento");
		label.setFont(Diseno.fuenteTitulosVentanas.deriveFont(35f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(false);
		panel.add(label, BorderLayout.NORTH);
		
		tablaEmparejamiento = new JTable();
		getContentPane().add(tablaEmparejamiento, BorderLayout.CENTER);
		
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
	public void setDatosIniciales(ArrayList<Mascota> resultadosEmp){
		tablaEmparejamiento.setModel(new ModeloTablaMascotas(resultadosEmp));
		tablaEmparejamiento.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaEmparejamiento.setAutoCreateRowSorter(true);
	}
	private void mostrarDetallesMascota(){
		int filaSeleccionada = tablaEmparejamiento.getSelectedRow();
		if (filaSeleccionada != -1){
			Integer idMascota = (Integer) tablaEmparejamiento.getValueAt(filaSeleccionada, 0);
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