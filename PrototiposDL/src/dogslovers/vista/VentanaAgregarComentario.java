package dogslovers.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import dogslovers.recursos.Diseno;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

public class VentanaAgregarComentario extends JFrame {
	private JTextField textComentario;
	private JLabel lblTitulo;
	private JPanel panelTitulo;
	private JPanel cajaComentarios;
	private JComboBox<String> comboCalificacion;
	private JLabel lblCalificacion;
	private JButton btnCancelar;
	private JButton btnComentar;
	private JPanel panelBotones;
	private JPanel panelContenido;
	public VentanaAgregarComentario() {
		setSize(650,400);
		getContentPane().setBackground(Diseno.fondoVentanas);
		setTitle("Agregar Comentario");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelTitulo = new JPanel();
		panelTitulo.setOpaque(false);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		lblTitulo = new JLabel("Dejar Comentario");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(Diseno.fuenteTitulosVentanas.deriveFont(40f));
		panelTitulo.add(lblTitulo);
		
		panelContenido = new JPanel();
		panelContenido.setOpaque(false);
		getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(20, 20));
		
		cajaComentarios = new JPanel();
		panelContenido.add(cajaComentarios);
		cajaComentarios.setOpaque(false);
		cajaComentarios.setBorder(new TitledBorder(null, "Escribir Comentario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cajaComentarios.setLayout(new BorderLayout(20, 20));
		
		textComentario = new JTextField();
		cajaComentarios.add(textComentario);
		textComentario.setColumns(10);
		
		JPanel panelCalificacion = new JPanel();
		panelContenido.add(panelCalificacion, BorderLayout.SOUTH);
		panelCalificacion.setOpaque(false);
		panelCalificacion.setLayout(new BorderLayout(20, 20));
		
		lblCalificacion = new JLabel("Calificaci\u00F3n");
		lblCalificacion.setHorizontalAlignment(SwingConstants.RIGHT);
		panelCalificacion.add(lblCalificacion, BorderLayout.CENTER);
		
		comboCalificacion = new JComboBox<String>();
		comboCalificacion.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5"}));
		panelCalificacion.add(comboCalificacion, BorderLayout.EAST);
		
		panelBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBotones.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(20);
		panelBotones.setOpaque(false);
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		btnCancelar = new JButton("Cancelar");
		panelBotones.add(btnCancelar);
		btnCancelar.setOpaque(false);
		
		btnComentar = new JButton("Comentar");
		panelBotones.add(btnComentar);
		btnComentar.setOpaque(false);
	}
}
