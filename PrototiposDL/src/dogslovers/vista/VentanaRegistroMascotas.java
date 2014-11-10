package dogslovers.vista;

import javax.swing.GroupLayout.*;

import java.awt.Font;

import javax.swing.*;
import javax.swing.LayoutStyle.*;

import dogslovers.control.Acceso;
import dogslovers.control.CasosPrueba;
import dogslovers.control.Principal;
import dogslovers.modelo.Mascota;
import dogslovers.modelo.Suceso;
import dogslovers.recursos.Diseno;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import java.awt.GridLayout;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class VentanaRegistroMascotas extends JFrame {
	private JTextField campoNombre;
	private JTextField campoNumeroDeChip;
	private JFormattedTextField campoRecompensa;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton radioButtonEncontrada;
	private JRadioButton radioButtonPerdida;
	private JRadioButton radioButtonAdoptable;
	private JTextPane campoNotas;
	private JComboBox<String> comboBoxEspecie;
	private JComboBox<String> comboBoxRaza;
	private JComboBox<String> comboBoxTamanio;
	private JComboBox<String> comboBoxColor;
	private JComboBox<String> comboBoxEdad;
	private JComboBox<String> comboBoxSexo;
	private JCheckBox checkBoxCastrada;
	private JCheckBox checkBoxVacunada;
	private JCheckBox checkBoxDesparacitada;
	private JCheckBox checkBoxDiscapacitada;
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
		
		campoNombre = new JTextField();
		campoNombre.setBounds(37, 90, 255, 25);
		campoNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoNombre.setColumns(10);
		
		JLabel lblNmeroDeChip = new JLabel("N\u00FAmero de chip");
		lblNmeroDeChip.setBounds(37, 118, 90, 16);
		lblNmeroDeChip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblRecompensa = new JLabel("Recompensa (colones)");
		lblRecompensa.setBounds(315, 68, 169, 16);
		lblRecompensa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setBounds(315, 118, 32, 16);
		lblNotas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton botonRegistrar = new JButton("Registrar");
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mascota mascota = new Mascota(campoNombre.getText(), (String)comboBoxEspecie.getSelectedItem(), (String)comboBoxRaza.getSelectedItem(), Integer.getInteger(campoRecompensa.getText()) , campoNotas.getText());
				mascota.setCastrada(checkBoxCastrada.isSelected());
				mascota.setColor((String)comboBoxColor.getSelectedItem());
				mascota.setDesparacitada(checkBoxDesparacitada.isSelected());
				mascota.setEdad((String)comboBoxEdad.getSelectedItem());
				mascota.setNumeroChip(campoNumeroDeChip.getText());
				mascota.setSexo((String)comboBoxSexo.getSelectedItem());
				mascota.setTamanio((String) comboBoxTamanio.getSelectedItem());
				mascota.setVacunada(checkBoxVacunada.isSelected());
				
				if (radioButtonAdoptable.isSelected()){ 
					Acceso.getUsuarioActivo().getMascotas().addAdoptables(mascota);
					mascota.addAdopcion(new Suceso(Acceso.getUsuarioActivo().getNickname(), "en mi casa", campoNotas.getText()));
					Principal.enAdopcion.add(mascota);
				}
				if (radioButtonEncontrada.isSelected()){ 
					Acceso.getUsuarioActivo().getMascotas().addEncontrada(mascota);
					mascota.addEncuentro(new Suceso(Acceso.getUsuarioActivo().getNickname(), "en mi casa", campoNotas.getText()));
					Principal.encontradas.add(mascota);
				}
				if (radioButtonPerdida.isSelected()){ 
					Acceso.getUsuarioActivo().getMascotas().addPerdida(mascota);
					mascota.addPerdida(new Suceso(Acceso.getUsuarioActivo().getNickname(), "en mi casa", campoNotas.getText()));
					Principal.perdidas.add(mascota);
				}
				
				JOptionPane.showMessageDialog(getContentPane(), 
						"Registro Satisfactorio, se le recuerda que puede editar la informacion\n de esta mascota en la pestaña de mis mascotas", "Información",
						 JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				


			}
		});
		botonRegistrar.setOpaque(false);
		botonRegistrar.setBounds(295, 512, 104, 25);
		botonRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setOpaque(false);
		botonCancelar.setBounds(147, 512, 115, 25);
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().setLayout(null);
		getContentPane().add(lblNombre);
		getContentPane().add(lblNmeroDeChip);
		
		campoNumeroDeChip = new JTextField();
		campoNumeroDeChip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoNumeroDeChip.setColumns(10);
		campoNumeroDeChip.setBounds(37, 136, 255, 25);
		getContentPane().add(campoNumeroDeChip);
		getContentPane().add(campoNombre);
		getContentPane().add(lblNotas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(315, 136, 259, 211);
		getContentPane().add(scrollPane);
		
		campoNotas = new JTextPane();
		scrollPane.setViewportView(campoNotas);
		campoNotas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lblRecompensa);
		getContentPane().add(lblRegistrarUnaMascota);
		getContentPane().add(botonRegistrar);
		getContentPane().add(botonCancelar);
		
		JPanel Estado = new JPanel();
		Estado.setBorder(new TitledBorder(null, "\u00BFC\u00F3mo desea registrar la mascota?", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		Estado.setOpaque(false);
		Estado.setBounds(297, 370, 296, 50);
		getContentPane().add(Estado);
		
		radioButtonEncontrada = new JRadioButton("Encontrada");
		radioButtonEncontrada.setSelected(true);
		buttonGroup.add(radioButtonEncontrada);
		radioButtonEncontrada.setOpaque(false);
		Estado.add(radioButtonEncontrada);
		radioButtonEncontrada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		radioButtonPerdida = new JRadioButton("Perdida");
		buttonGroup.add(radioButtonPerdida);
		radioButtonPerdida.setOpaque(false);
		Estado.add(radioButtonPerdida);
		radioButtonPerdida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		radioButtonAdoptable = new JRadioButton("Adoptable");
		buttonGroup.add(radioButtonAdoptable);
		radioButtonAdoptable.setOpaque(false);
		Estado.add(radioButtonAdoptable);
		radioButtonAdoptable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel caracteristicas = new JPanel();
		caracteristicas.setOpaque(false);
		caracteristicas.setBorder(new TitledBorder(null, "Caracter\u00EDsticas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		caracteristicas.setBounds(37, 186, 206, 314);
		getContentPane().add(caracteristicas);
		caracteristicas.setLayout(new GridLayout(6, 2, 0, 30));
		
		JLabel lblEspecie = new JLabel("Especie");
		caracteristicas.add(lblEspecie);
		lblEspecie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		comboBoxEspecie = new JComboBox<String>();
		caracteristicas.add(comboBoxEspecie);
		comboBoxEspecie.setModel(new DefaultComboBoxModel<String>(new String[] {"Perro", "Gato", "Conejo"}));
		comboBoxEspecie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblRaza = new JLabel("Raza");
		caracteristicas.add(lblRaza);
		lblRaza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		comboBoxRaza = new JComboBox<String>();
		caracteristicas.add(comboBoxRaza);
		comboBoxRaza.setModel(new DefaultComboBoxModel<String>(new String[] {"Chihuaha", "Doberman", "Otro"}));
		comboBoxRaza.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTamao = new JLabel("Tama\u00F1o");
		caracteristicas.add(lblTamao);
		lblTamao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		comboBoxTamanio = new JComboBox<String>();
		caracteristicas.add(comboBoxTamanio);
		comboBoxTamanio.setModel(new DefaultComboBoxModel<String>(new String[] {"Peque\u00F1o", "Mediano", "Grande"}));
		comboBoxTamanio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblColor = new JLabel("Color");
		caracteristicas.add(lblColor);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		comboBoxColor = new JComboBox<String>();
		caracteristicas.add(comboBoxColor);
		comboBoxColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxColor.setModel(new DefaultComboBoxModel<String>(new String[] {"Blanco", "Negro", "Gris", "Caf\u00E9"}));
		//caracteristicas.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblEspecie, especieComboBox, lblRaza, razaComboBox, lblTamao, tamanioComboBox, lblSexo, sexoComboBox, lblColor, colorComboBox, lblEdad, edadComboBox}));
		
		JLabel lblEdad = new JLabel("Edad");
		caracteristicas.add(lblEdad);
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		comboBoxEdad = new JComboBox<String>();
		caracteristicas.add(comboBoxEdad);
		comboBoxEdad.setModel(new DefaultComboBoxModel<String>(new String[] {"Cachorro", "Adulto"}));
		comboBoxEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblSexo = new JLabel("Sexo");
		caracteristicas.add(lblSexo);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		comboBoxSexo = new JComboBox<String>();
		caracteristicas.add(comboBoxSexo);
		comboBoxSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"Macho", "Hembra"}));
		comboBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("######");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		campoRecompensa = new JFormattedTextField(formatter);
		campoRecompensa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoRecompensa.setColumns(10);
		campoRecompensa.setBounds(314, 90, 255, 25);
		getContentPane().add(campoRecompensa);
		
		JPanel condicionesfisicas = new JPanel();
		condicionesfisicas.setOpaque(false);
		condicionesfisicas.setBorder(new TitledBorder(null, "Condiciones F\u00EDsicas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		condicionesfisicas.setBounds(304, 432, 277, 68);
		getContentPane().add(condicionesfisicas);
		condicionesfisicas.setLayout(new GridLayout(0, 2, 0, 0));
		
		checkBoxCastrada = new JCheckBox("Castrada");
		condicionesfisicas.add(checkBoxCastrada);
		checkBoxCastrada.setOpaque(false);
		checkBoxCastrada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		checkBoxVacunada = new JCheckBox("Vacunada");
		condicionesfisicas.add(checkBoxVacunada);
		checkBoxVacunada.setOpaque(false);
		checkBoxVacunada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		checkBoxDesparacitada = new JCheckBox("Desparacitada");
		condicionesfisicas.add(checkBoxDesparacitada);
		checkBoxDesparacitada.setOpaque(false);
		checkBoxDesparacitada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		checkBoxDiscapacitada = new JCheckBox("Discapacitada");
		condicionesfisicas.add(checkBoxDiscapacitada);
		checkBoxDiscapacitada.setOpaque(false);
		checkBoxDiscapacitada.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}
}
