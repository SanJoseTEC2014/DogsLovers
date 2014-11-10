package dogslovers.vista;

import javax.swing.GroupLayout.*;

import java.awt.Font;

import javax.swing.*;
import javax.swing.LayoutStyle.*;

import dogslovers.recursos.Diseno;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;

public class VentanaRegistroMascotas extends JFrame {
	private JTextField nombreTextBox;
	private JTextField numeroDeChip;
	private JTextField textField;
	public VentanaRegistroMascotas() {
		setResizable(false);
		setTitle("  Registro de mascotas");
		getContentPane().setBackground(Diseno.fondoVentanas);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(627,583);
		
		JLabel lblRegistrarUnaMascota = new JLabel("Registrar una mascota");
		lblRegistrarUnaMascota.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarUnaMascota.setBounds(147, 23, 309, 33);
		lblRegistrarUnaMascota.setFont(Diseno.fuenteTitulosVentanas.deriveFont(25f));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(37, 68, 45, 16);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nombreTextBox = new JTextField();
		nombreTextBox.setBounds(37, 90, 255, 25);
		nombreTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nombreTextBox.setColumns(10);
		
		JLabel lblNmeroDeChip = new JLabel("N\u00FAmero de chip");
		lblNmeroDeChip.setBounds(37, 118, 90, 16);
		lblNmeroDeChip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblRecompensa = new JLabel("Recompensa");
		lblRecompensa.setBounds(315, 68, 73, 16);
		lblRecompensa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setBounds(315, 118, 32, 16);
		lblNotas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton botonRegistrar = new JButton("Registrar");
		botonRegistrar.setOpaque(false);
		botonRegistrar.setBounds(295, 512, 93, 25);
		botonRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setOpaque(false);
		botonCancelar.setBounds(173, 512, 89, 25);
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JTextPane notasTextPane = new JTextPane();
		notasTextPane.setBounds(315, 136, 259, 211);
		notasTextPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().setLayout(null);
		getContentPane().add(lblNombre);
		getContentPane().add(lblNmeroDeChip);
		
		numeroDeChip = new JTextField();
		numeroDeChip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		numeroDeChip.setColumns(10);
		numeroDeChip.setBounds(37, 136, 255, 25);
		getContentPane().add(numeroDeChip);
		getContentPane().add(nombreTextBox);
		getContentPane().add(lblNotas);
		getContentPane().add(notasTextPane);
		getContentPane().add(lblRecompensa);
		getContentPane().add(lblRegistrarUnaMascota);
		getContentPane().add(botonRegistrar);
		getContentPane().add(botonCancelar);
		
		JPanel Estado = new JPanel();
		Estado.setBorder(new TitledBorder(null, "\u00BFC\u00F3mo desea registrar la mascota?", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		Estado.setOpaque(false);
		Estado.setBounds(297, 370, 296, 50);
		getContentPane().add(Estado);
		
		JRadioButton encontradaRadioButton = new JRadioButton("Encontrada");
		encontradaRadioButton.setOpaque(false);
		Estado.add(encontradaRadioButton);
		encontradaRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton perdidaRadioButton = new JRadioButton("Perdida");
		perdidaRadioButton.setOpaque(false);
		Estado.add(perdidaRadioButton);
		perdidaRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton adoptableRadioButton = new JRadioButton("Adoptable");
		adoptableRadioButton.setOpaque(false);
		Estado.add(adoptableRadioButton);
		adoptableRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel caracteristicas = new JPanel();
		caracteristicas.setOpaque(false);
		caracteristicas.setBorder(new TitledBorder(null, "Caracter\u00EDsticas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		caracteristicas.setBounds(37, 186, 206, 314);
		getContentPane().add(caracteristicas);
		caracteristicas.setLayout(new GridLayout(6, 2, 0, 30));
		
		JLabel lblEspecie = new JLabel("Especie");
		caracteristicas.add(lblEspecie);
		lblEspecie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> especieComboBox = new JComboBox<String>();
		caracteristicas.add(especieComboBox);
		especieComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Perro", "Gato", "Conejo"}));
		especieComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblRaza = new JLabel("Raza");
		caracteristicas.add(lblRaza);
		lblRaza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> razaComboBox = new JComboBox<String>();
		caracteristicas.add(razaComboBox);
		razaComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Chihuaha", "Doberman", "Otro"}));
		razaComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTamao = new JLabel("Tama\u00F1o");
		caracteristicas.add(lblTamao);
		lblTamao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> tamanioComboBox = new JComboBox<String>();
		caracteristicas.add(tamanioComboBox);
		tamanioComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Peque\u00F1o", "Mediano", "Grande"}));
		tamanioComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblColor = new JLabel("Color");
		caracteristicas.add(lblColor);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> colorComboBox = new JComboBox<String>();
		caracteristicas.add(colorComboBox);
		colorComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		colorComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Blanco", "Negro", "Gris", "Caf\u00E9"}));
		//caracteristicas.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblEspecie, especieComboBox, lblRaza, razaComboBox, lblTamao, tamanioComboBox, lblSexo, sexoComboBox, lblColor, colorComboBox, lblEdad, edadComboBox}));
		
		JLabel lblEdad = new JLabel("Edad");
		caracteristicas.add(lblEdad);
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> edadComboBox = new JComboBox<String>();
		caracteristicas.add(edadComboBox);
		edadComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Cachorro", "Adulto"}));
		edadComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblSexo = new JLabel("Sexo");
		caracteristicas.add(lblSexo);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> sexoComboBox = new JComboBox<String>();
		caracteristicas.add(sexoComboBox);
		sexoComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Macho", "Hembra"}));
		sexoComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(314, 90, 255, 25);
		getContentPane().add(textField);
		
		JPanel condicionesfisicas = new JPanel();
		condicionesfisicas.setOpaque(false);
		condicionesfisicas.setBorder(new TitledBorder(null, "Condiciones F\u00EDsicas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		condicionesfisicas.setBounds(304, 432, 277, 68);
		getContentPane().add(condicionesfisicas);
		condicionesfisicas.setLayout(new GridLayout(0, 2, 0, 0));
		
		JCheckBox castradaCheckBox = new JCheckBox("Castrada");
		condicionesfisicas.add(castradaCheckBox);
		castradaCheckBox.setOpaque(false);
		castradaCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox vacunadaCheckBox = new JCheckBox("Vacunada");
		condicionesfisicas.add(vacunadaCheckBox);
		vacunadaCheckBox.setOpaque(false);
		vacunadaCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox desparacitadaCheckBox = new JCheckBox("Desparacitada");
		condicionesfisicas.add(desparacitadaCheckBox);
		desparacitadaCheckBox.setOpaque(false);
		desparacitadaCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox discapacitadaCheckBox = new JCheckBox("Discapacitada");
		condicionesfisicas.add(discapacitadaCheckBox);
		discapacitadaCheckBox.setOpaque(false);
		discapacitadaCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}
}
