package dogslovers.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import dogslovers.control.Principal;
import dogslovers.control.Tiempo;
import dogslovers.control.excepciones.FechaInvalidaException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaParametrosSistema extends JFrame {
	private JComboBox<String> comboMes;
	private JButton botonGuardarFecha;
	private JComboBox<String> comboCalificaciones;
	private JButton botonAvanzarUnDia;
	private JButton btnGuardarCalificacion;
	private JPanel panelContenido;
	private JPanel panelTitulo;
	private JPanel panelBotonesFecha;
	private JLabel labelTitulo1;
	private JLabel labelTitulo2;
	private JLabel labelCalificacionMinima;
	private JPanel panelInferior;
	private JTextField textAnio;
	private JLabel labelAnio;
	private JLabel lblMes;
	private JTextField textDia;
	private JLabel labelDia;
	private JPanel panelDatosFecha;
	
	private static boolean fechaInicioEstablecida;
	
	public VentanaParametrosSistema() {
		
		getContentPane().setBackground(Principal.fondoVentanas);
		setSize(650, 310);
		
		panelTitulo = new JPanel();
		panelTitulo.setOpaque(false);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		labelTitulo1 = new JLabel("Par\u00E1metros");
		labelTitulo1.setFont(Principal.fuenteTitulosVentanas.deriveFont(35f));
		labelTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(labelTitulo1, BorderLayout.NORTH);
		
		labelTitulo2 = new JLabel("Sistema");
		labelTitulo2.setFont(Principal.fuenteTitulosVentanas.deriveFont(40f));
		labelTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(labelTitulo2, BorderLayout.SOUTH);
		
		panelContenido = new JPanel();
		panelContenido.setOpaque(false);
		getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelDatosFecha = new JPanel();
		panelDatosFecha.setOpaque(false);
		panelDatosFecha.setBorder(new TitledBorder(null, "Fecha de Inicio de Producci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelContenido.add(panelDatosFecha);
		
		labelDia = new JLabel("D\u00EDa");
		panelDatosFecha.add(labelDia);
		
		textDia = new JTextField();
		panelDatosFecha.add(textDia);
		textDia.setColumns(10);
		
		lblMes = new JLabel("Mes");
		panelDatosFecha.add(lblMes);
		
		comboMes = new JComboBox<String>();
		comboMes.setModel(new DefaultComboBoxModel<String>(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		panelDatosFecha.add(comboMes);
		
		labelAnio = new JLabel("A\u00F1o");
		panelDatosFecha.add(labelAnio);
		
		textAnio = new JTextField();
		panelDatosFecha.add(textAnio);
		textAnio.setColumns(10);
		
		panelBotonesFecha = new JPanel();
		panelBotonesFecha.setOpaque(false);
		panelContenido.add(panelBotonesFecha);
		panelBotonesFecha.setLayout(new BorderLayout(0, 0));
		
		botonGuardarFecha = new JButton("Guardar Fecha");
		botonGuardarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Tiempo.setFechaInicioProduccion(textDia.getText(),
							(String) comboMes.getSelectedItem(),
							textAnio.getText());
					
				} catch (FechaInvalidaException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage()
						+ (ex.getCause() == null ? "" : ex.getCause().getMessage()),
						"Error del sistema.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonGuardarFecha.setOpaque(false);
		panelBotonesFecha.add(botonGuardarFecha, BorderLayout.NORTH);
		
		botonAvanzarUnDia = new JButton("Avanzar un D\u00EDa");
		botonAvanzarUnDia.setOpaque(false);
		panelBotonesFecha.add(botonAvanzarUnDia, BorderLayout.SOUTH);
		
		labelCalificacionMinima = new JLabel("Calificaci\u00F3n M\u00EDnima para degradar a un Usuario a Lista Negra:");
		panelContenido.add(labelCalificacionMinima);
		
		comboCalificaciones = new JComboBox<String>();
		comboCalificaciones.setModel(new DefaultComboBoxModel<String>(new String[] {"5.0", "4.5", "4.0", "3.5", "3.0", "2.5", "2.0", "1.5", "1.0", "0.5", "0.0"}));
		panelContenido.add(comboCalificaciones);
		
		btnGuardarCalificacion = new JButton("Guardar Calificaci\u00F3n");
		btnGuardarCalificacion.setOpaque(false);
		panelContenido.add(btnGuardarCalificacion);
		
		panelInferior = new JPanel();
		panelInferior.setOpaque(false);
		getContentPane().add(panelInferior, BorderLayout.SOUTH);
		
		JButton botonCerrar = new JButton("Cerrar");
		botonCerrar.setOpaque(false);
		panelInferior.add(botonCerrar);
	}
	
	public static void setFechaInicio(boolean opcion){
		fechaInicioEstablecida = opcion;
	}
	
}
