package dogslovers.vista;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;

public class VentanaRegistroMascotas extends JFrame {
	private JTextField nombreTextBox;
	private JTextField numeroChipTextBox;
	private JTextField recompensaTextBox;
	public VentanaRegistroMascotas() {
		setTitle("Registro de mascotas");
		setSize(628,591);
		
		JLabel lblRegistrarUnaMascota = new JLabel("Registrar una mascota");
		lblRegistrarUnaMascota.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nombreTextBox = new JTextField();
		nombreTextBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nombreTextBox.setColumns(10);
		
		JLabel lblNmeroDeChip = new JLabel("N\u00FAmero de chip");
		lblNmeroDeChip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		numeroChipTextBox = new JTextField();
		numeroChipTextBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		numeroChipTextBox.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Especie");
		lblEspecie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox especieComboBox = new JComboBox();
		especieComboBox.setModel(new DefaultComboBoxModel(new String[] {"Perro", "Gato", "Conejo"}));
		especieComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox razaComboBox = new JComboBox();
		razaComboBox.setModel(new DefaultComboBoxModel(new String[] {"Chihuaha", "Doberman", "Otro"}));
		razaComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox colorComboBox = new JComboBox();
		colorComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		colorComboBox.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Gris", "Caf\u00E9"}));
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox edadComboBox = new JComboBox();
		edadComboBox.setModel(new DefaultComboBoxModel(new String[] {"Cachorro", "Adulto"}));
		edadComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox sexoComboBox = new JComboBox();
		sexoComboBox.setModel(new DefaultComboBoxModel(new String[] {"Macho", "Hembra"}));
		sexoComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox tamanioComboBox = new JComboBox();
		tamanioComboBox.setModel(new DefaultComboBoxModel(new String[] {"Peque\u00F1o", "Mediano", "Grande"}));
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
		recompensaTextBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		botonRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JTextPane notasTextPane = new JTextPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblNmeroDeChip)
								.addComponent(numeroChipTextBox, 224, 235, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEspecie)
									.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
									.addComponent(especieComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblRaza)
									.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
									.addComponent(razaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTamao)
										.addComponent(lblSexo)
										.addComponent(lblColor)
										.addComponent(lblEdad))
									.addPreferredGap(ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(colorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(edadComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(sexoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tamanioComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblcmoDeseaRegistrar, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(nombreTextBox, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
							.addGap(89)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(notasTextPane, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
								.addComponent(lblRecompensa)
								.addComponent(lblNotas)
								.addComponent(recompensaTextBox, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(29)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(encontradaRadioButton)
										.addComponent(vacunadaCheckBox)
										.addComponent(castradaCheckBox))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(45)
											.addComponent(perdidaRadioButton)
											.addGap(145)
											.addComponent(botonRegistrar))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(30)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(desparacitadaCheckBox)
												.addComponent(discapacitadaCheckBox)))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(81)
									.addComponent(lblOtrasCaractersticas)))
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addComponent(botonCancelar)
							.addGap(11))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(225)
							.addComponent(lblRegistrarUnaMascota)))
					.addContainerGap())
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNmeroDeChip)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numeroChipTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
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
							.addComponent(lblcmoDeseaRegistrar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(encontradaRadioButton)
								.addComponent(perdidaRadioButton)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNotas)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(notasTextPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOtrasCaractersticas)
						.addComponent(botonRegistrar)
						.addComponent(botonCancelar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(discapacitadaCheckBox)
						.addComponent(castradaCheckBox))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(desparacitadaCheckBox)
						.addComponent(vacunadaCheckBox))
					.addGap(18))
		);
		getContentPane().setLayout(groupLayout);
	}
}
