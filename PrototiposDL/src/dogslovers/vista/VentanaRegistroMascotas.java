package dogslovers.vista;

import javax.swing.GroupLayout.*;

import java.awt.Font;

import javax.swing.*;
import javax.swing.LayoutStyle.*;

import dogslovers.recursos.Diseno;

public class VentanaRegistroMascotas extends JFrame {
	private JTextField nombreTextBox;
	private JTextField numeroChipTextBox;
	private JTextField recompensaTextBox;
	public VentanaRegistroMascotas() {
		setTitle("  Registro de mascotas");
		getContentPane().setBackground(Diseno.fondoVentanas);
		setSize(666,680);
		
		JLabel lblRegistrarUnaMascota = new JLabel("Registrar una mascota");
		lblRegistrarUnaMascota.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nombreTextBox = new JTextField();
		nombreTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nombreTextBox.setColumns(10);
		
		JLabel lblNmeroDeChip = new JLabel("N\u00FAmero de chip");
		lblNmeroDeChip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		numeroChipTextBox = new JTextField();
		numeroChipTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		numeroChipTextBox.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Especie");
		lblEspecie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> especieComboBox = new JComboBox<String>();
		especieComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Perro", "Gato", "Conejo"}));
		especieComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> razaComboBox = new JComboBox<String>();
		razaComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Chihuaha", "Doberman", "Otro"}));
		razaComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> colorComboBox = new JComboBox<String>();
		colorComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		colorComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Blanco", "Negro", "Gris", "Caf\u00E9"}));
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> edadComboBox = new JComboBox<String>();
		edadComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Cachorro", "Adulto"}));
		edadComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> sexoComboBox = new JComboBox<String>();
		sexoComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Macho", "Hembra"}));
		sexoComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> tamanioComboBox = new JComboBox<String>();
		tamanioComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Peque\u00F1o", "Mediano", "Grande"}));
		tamanioComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JCheckBox castradaCheckBox = new JCheckBox("Castrada");
		castradaCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox vacunadaCheckBox = new JCheckBox("Vacunada");
		vacunadaCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox desparacitadaCheckBox = new JCheckBox("Desparacitada");
		desparacitadaCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox discapacitadaCheckBox = new JCheckBox("Discapacitada");
		discapacitadaCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblcmoDeseaRegistrar = new JLabel("\u00BFC\u00F3mo desea registrar a la mascota?");
		lblcmoDeseaRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRecompensa = new JLabel("Recompensa");
		lblRecompensa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		recompensaTextBox = new JTextField();
		recompensaTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		recompensaTextBox.setColumns(10);
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblOtrasCaractersticas = new JLabel("Otras Caracter\u00EDsticas");
		lblOtrasCaractersticas.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JRadioButton encontradaRadioButton = new JRadioButton("Encontrada");
		encontradaRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton perdidaRadioButton = new JRadioButton("Perdida");
		perdidaRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton botonRegistrar = new JButton("Registrar");
		botonRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JTextPane notasTextPane = new JTextPane();
		notasTextPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton adoptableRadioButton = new JRadioButton("Adoptable");
		adoptableRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNmeroDeChip)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(nombreTextBox, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblEspecie)
												.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
												.addComponent(especieComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblRaza)
												.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
												.addComponent(razaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(lblTamao)
													.addComponent(lblSexo)
													.addComponent(lblColor)
													.addComponent(lblEdad))
												.addPreferredGap(ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addComponent(colorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(edadComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(sexoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(tamanioComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
											.addComponent(numeroChipTextBox, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
										.addGap(89))))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNotas)
										.addComponent(recompensaTextBox, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(notasTextPane, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblRecompensa))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(29)
									.addComponent(encontradaRadioButton)
									.addGap(46)
									.addComponent(perdidaRadioButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(144)
									.addComponent(lblOtrasCaractersticas)))
							.addGap(38)
							.addComponent(adoptableRadioButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(225)
							.addComponent(lblRegistrarUnaMascota))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(castradaCheckBox)
								.addComponent(vacunadaCheckBox))
							.addGap(92)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(desparacitadaCheckBox)
								.addComponent(discapacitadaCheckBox))
							.addGap(82)
							.addComponent(botonRegistrar)
							.addGap(29)
							.addComponent(botonCancelar)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(lblcmoDeseaRegistrar, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(279))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblRegistrarUnaMascota)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(lblRecompensa))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nombreTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(recompensaTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNmeroDeChip)
						.addComponent(lblNotas))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(numeroChipTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEspecie)
								.addComponent(especieComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRaza)
								.addComponent(razaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(colorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblColor))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(edadComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEdad))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSexo)
								.addComponent(sexoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTamao)
								.addComponent(tamanioComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblcmoDeseaRegistrar))
						.addComponent(notasTextPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(encontradaRadioButton)
						.addComponent(perdidaRadioButton)
						.addComponent(adoptableRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblOtrasCaractersticas)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(discapacitadaCheckBox)
								.addComponent(castradaCheckBox))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(desparacitadaCheckBox)
								.addComponent(vacunadaCheckBox))
							.addGap(16))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(botonRegistrar)
								.addComponent(botonCancelar))
							.addGap(26))))
		);
		getContentPane().setLayout(groupLayout);
	}
}
