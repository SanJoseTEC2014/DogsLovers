package dogslovers.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;

import dogslovers.control.Principal;
import javax.swing.SwingConstants;

public class VentanaAgregarComentario extends JFrame {
	private JTextField textField;
	public VentanaAgregarComentario() {
		setSize(600,400);
		getContentPane().setBackground(Principal.fondoVentanas);
		setTitle("Agregar Comentario");
		getContentPane().setLayout(null);
		
		JPanel cajaComentarios = new JPanel();
		cajaComentarios.setOpaque(false);
		cajaComentarios.setBorder(new TitledBorder(null, "Escribir Comentario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cajaComentarios.setBounds(10, 67, 552, 165);
		getContentPane().add(cajaComentarios);
		cajaComentarios.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 21, 532, 133);
		cajaComentarios.add(textField);
		textField.setColumns(10);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setOpaque(false);
		panelTitulo.setBounds(232, 32, 130, 24);
		getContentPane().add(panelTitulo);
		
		JLabel lblNewLabel = new JLabel("Dejar Comentario");
		panelTitulo.add(lblNewLabel);
		
		JPanel ComboCalificacion = new JPanel();
		ComboCalificacion.setOpaque(false);
		ComboCalificacion.setBounds(10, 243, 145, 42);
		getContentPane().add(ComboCalificacion);
		ComboCalificacion.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCalificacin = new JLabel("Calificaci\u00F3n");
		ComboCalificacion.add(lblCalificacin, BorderLayout.WEST);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		ComboCalificacion.add(comboBox, BorderLayout.CENTER);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setOpaque(false);
		btnCancelar.setBounds(188, 300, 89, 23);
		getContentPane().add(btnCancelar);
		
		JButton btnComentar = new JButton("Comentar");
		btnComentar.setOpaque(false);
		btnComentar.setBounds(310, 300, 89, 23);
		getContentPane().add(btnComentar);
	}
}
