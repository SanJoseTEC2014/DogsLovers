package dogslovers.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import java.awt.FlowLayout;

public class VentanaDetallesMascota extends JFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	public VentanaDetallesMascota() {
		getContentPane().setLayout(null);
		
		JLabel lblEstadoActual = new JLabel("Estado Actual");
		lblEstadoActual.setFont(lblEstadoActual.getFont().deriveFont(lblEstadoActual.getFont().getStyle() | Font.BOLD));
		lblEstadoActual.setBounds(225, 383, 90, 23);
		getContentPane().add(lblEstadoActual);
		
		JLabel lblInformacinFsica = new JLabel("Informaci\u00F3n F\u00EDsica-Veterinaria");
		lblInformacinFsica.setFont(lblInformacinFsica.getFont().deriveFont(lblInformacinFsica.getFont().getStyle() | Font.BOLD));
		lblInformacinFsica.setBounds(187, 306, 181, 23);
		getContentPane().add(lblInformacinFsica);
		
		JLabel lblDetallesMascota = new JLabel("Detalles Mascota");
		lblDetallesMascota.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetallesMascota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDetallesMascota.setBounds(187, 6, 152, 25);
		getContentPane().add(lblDetallesMascota);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Editar detalles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 65, 495, 230);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 4, 20, 50));
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNmeroDelChip = new JLabel("N\u00FAmero del Chip");
		panel.add(lblNmeroDelChip);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Especie");
		panel.add(lblEspecie);
		
		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblRaza = new JLabel("Raza");
		panel.add(lblRaza);
		
		textField_5 = new JTextField();
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		panel.add(lblColor);
		
		textField_6 = new JTextField();
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		panel.add(lblEdad);
		
		textField_7 = new JTextField();
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sexo");
		panel.add(lblNewLabel_1);
		
		textField_8 = new JTextField();
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblTamao = new JLabel("Tama\u00F1o");
		panel.add(lblTamao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 404, 504, 55);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 0, -60));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Perdida");
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Encontrada");
		panel_1.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Localizada");
		panel_1.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Refugiada");
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Adoptada");
		panel_1.add(rdbtnNewRadioButton_3);
		
		JButton btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(272, 470, 115, 23);
		getContentPane().add(btnGuardarCambios);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(105, 470, 115, 23);
		getContentPane().add(btnCancelar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 325, 504, 55);
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 0, -60));
		
		JCheckBox checkBox = new JCheckBox("Vacunada");
		panel_2.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Castrada");
		panel_2.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Desparacitada");
		panel_2.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Discapacitada");
		panel_2.add(checkBox_3);
		
		JLabel lblInformacinPrincipal = new JLabel("Informaci\u00F3n Principal");
		lblInformacinPrincipal.setFont(lblInformacinPrincipal.getFont().deriveFont(lblInformacinPrincipal.getFont().getStyle() | Font.BOLD));
		lblInformacinPrincipal.setBounds(197, 31, 134, 23);
		getContentPane().add(lblInformacinPrincipal);
	}
}
