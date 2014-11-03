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

public class VentanaDetallesMascota extends JFrame {
	private JTextField textField;
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
		
		JLabel lblDetallesMascota = new JLabel("Detalles Mascota");
		lblDetallesMascota.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetallesMascota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDetallesMascota.setBounds(177, 11, 166, 34);
		getContentPane().add(lblDetallesMascota);
		
		JLabel lblEditarDetalles = new JLabel("Editar detalles");
		lblEditarDetalles.setBounds(10, 34, 77, 25);
		getContentPane().add(lblEditarDetalles);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 56, 504, 323);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 4, 20, 35));
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		panel.add(lblNewLabel);
		
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
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Vacunada");
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Castrada");
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Desparacitada");
		panel.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxDiscapacitada = new JCheckBox("Discapacitada");
		panel.add(chckbxDiscapacitada);
		
		JButton btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(309, 699, 115, 23);
		getContentPane().add(btnGuardarCambios);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(140, 699, 115, 23);
		getContentPane().add(btnCancelar);
	}
}
