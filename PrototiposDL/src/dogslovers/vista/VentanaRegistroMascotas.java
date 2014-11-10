package dogslovers.vista;

import javax.swing.GroupLayout.*;

import java.awt.Font;

import javax.swing.*;
import javax.swing.LayoutStyle.*;

import dogslovers.control.Acceso;
import dogslovers.control.CasosPrueba;
import dogslovers.control.Imagenes;
import dogslovers.control.Principal;
import dogslovers.control.excepciones.ImagenNoEncontradaException;
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
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.awt.BorderLayout;

public class VentanaRegistroMascotas extends JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField campoNombre;
	private JTextArea campoNotas;
	private JTextField campoNumeroDeChip;
	private JFormattedTextField campoRecompensa;
	private JCheckBox checkBoxCastrada;
	private JCheckBox checkBoxDesparacitada;
	private JCheckBox checkBoxVacunada;
	private JComboBox<String> comboBoxColor;
	private JComboBox<String> comboBoxEspecie;
	private JComboBox<String> comboBoxRaza;
	private JComboBox<String> comboBoxSexo;
	private JComboBox<String> comboBoxTamanio;
	private String imagenSeleccionada;
	private JRadioButton radioButtonAdoptable;
	private JRadioButton radioButtonEncontrada;
	private JRadioButton radioButtonPerdida;
	
	public VentanaRegistroMascotas() {
		setResizable(false);
		setTitle("  Registro de mascotas");
		getContentPane().setBackground(Diseno.fondoVentanas);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(663,632);
		getContentPane().setLayout(new BorderLayout(20, 10));
		
		JLabel lblRegistrarUnaMascota = new JLabel("Registrar una mascota");
		lblRegistrarUnaMascota.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarUnaMascota.setFont(Diseno.fuenteTitulosVentanas.deriveFont(25f));
		getContentPane().add(lblRegistrarUnaMascota, BorderLayout.NORTH);
		
		
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("######");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel labelEspacioIzq = new JLabel(" ");
		getContentPane().add(labelEspacioIzq, BorderLayout.WEST);
		
		JLabel labelEspacioDer = new JLabel(" ");
		getContentPane().add(labelEspacioDer, BorderLayout.EAST);
		
		JPanel panelContenido = new JPanel();
		panelContenido.setOpaque(false);
		getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));
		
		JPanel columnaIzq = new JPanel();
		panelContenido.add(columnaIzq, BorderLayout.WEST);
		columnaIzq.setOpaque(false);
		columnaIzq.setLayout(new BoxLayout(columnaIzq, BoxLayout.Y_AXIS));
		
		JPanel datosIniciales = new JPanel();
		datosIniciales.setOpaque(false);
		columnaIzq.add(datosIniciales);
		datosIniciales.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		datosIniciales.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		campoNombre = new JTextField();
		datosIniciales.add(campoNombre);
		campoNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoNombre.setColumns(10);
		
		JLabel lblNmeroDeChip = new JLabel("N\u00FAmero de chip");
		datosIniciales.add(lblNmeroDeChip);
		lblNmeroDeChip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		campoNumeroDeChip = new JTextField();
		datosIniciales.add(campoNumeroDeChip);
		campoNumeroDeChip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoNumeroDeChip.setColumns(10);
		
		JPanel caracteristicas = new JPanel();
		columnaIzq.add(caracteristicas);
		caracteristicas.setOpaque(false);
		caracteristicas.setBorder(new TitledBorder(null, "Caracter\u00EDsticas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		caracteristicas.setLayout(new GridLayout(5, 2, 0, 5));
		
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
		
		JLabel lblSexo = new JLabel("Sexo");
		caracteristicas.add(lblSexo);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		comboBoxSexo = new JComboBox<String>();
		caracteristicas.add(comboBoxSexo);
		comboBoxSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"Macho", "Hembra"}));
		comboBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel estado = new JPanel();
		columnaIzq.add(estado);
		estado.setBorder(new TitledBorder(null, "\u00BFC\u00F3mo desea registrar la mascota?", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		estado.setOpaque(false);
		
		radioButtonEncontrada = new JRadioButton("Encontrada");
		radioButtonEncontrada.setSelected(true);
		buttonGroup.add(radioButtonEncontrada);
		radioButtonEncontrada.setOpaque(false);
		estado.add(radioButtonEncontrada);
		radioButtonEncontrada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		radioButtonPerdida = new JRadioButton("Perdida");
		buttonGroup.add(radioButtonPerdida);
		radioButtonPerdida.setOpaque(false);
		estado.add(radioButtonPerdida);
		radioButtonPerdida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		radioButtonAdoptable = new JRadioButton("Adoptable");
		buttonGroup.add(radioButtonAdoptable);
		radioButtonAdoptable.setOpaque(false);
		estado.add(radioButtonAdoptable);
		radioButtonAdoptable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel condicionesfisicas = new JPanel();
		columnaIzq.add(condicionesfisicas);
		condicionesfisicas.setOpaque(false);
		condicionesfisicas.setBorder(new TitledBorder(null, "Condiciones F\u00EDsicas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		condicionesfisicas.setLayout(new GridLayout(0, 1, 0, 0));
		
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
		
		JPanel panelRecompensa = new JPanel();
		panelRecompensa.setOpaque(false);
		columnaIzq.add(panelRecompensa);
		panelRecompensa.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblRecompensa = new JLabel("Recompensa (colones)");
		panelRecompensa.add(lblRecompensa);
		lblRecompensa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
				
				campoRecompensa = new JFormattedTextField(formatter);
				panelRecompensa.add(campoRecompensa);
				campoRecompensa.setFont(new Font("Tahoma", Font.PLAIN, 13));
				campoRecompensa.setColumns(10);
				
				JPanel columnaDer = new JPanel();
				panelContenido.add(columnaDer, BorderLayout.CENTER);
				columnaDer.setOpaque(false);
				columnaDer.setLayout(new BoxLayout(columnaDer, BoxLayout.Y_AXIS));
				
				JPanel panelDetalles = new JPanel();
				panelDetalles.setBorder(new TitledBorder(null, "Detalles", TitledBorder.CENTER, TitledBorder.TOP, null, null));
				panelDetalles.setOpaque(false);
				columnaDer.add(panelDetalles);
				panelDetalles.setLayout(new BorderLayout(10, 10));
				
				JPanel panel_1 = new JPanel();
				panelDetalles.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new BorderLayout(0, 0));
				
				campoNotas = new JTextArea();
				campoNotas.setOpaque(false);
				panel_1.add(campoNotas);
				campoNotas.setRows(1);
				campoNotas.setFont(new Font("Tahoma", Font.PLAIN, 13));
				
				JLabel labelNotas = new JLabel("Notas adicionales:");
				labelNotas.setHorizontalAlignment(SwingConstants.CENTER);
				panel_1.add(labelNotas, BorderLayout.NORTH);
				labelNotas.setAlignmentX(Component.CENTER_ALIGNMENT);
				labelNotas.setFont(new Font("Tahoma", Font.PLAIN, 13));
				
				JPanel panel = new JPanel();
				panelDetalles.add(panel, BorderLayout.SOUTH);
				panel.setLayout(new BorderLayout(0, 0));
				
				JLabel lblNewLabel = new JLabel("Direccion del suceso:");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel, BorderLayout.NORTH);
				
				JEditorPane dtrpnDireccionSuceso = new JEditorPane();
				dtrpnDireccionSuceso.setOpaque(false);
				panel.add(dtrpnDireccionSuceso, BorderLayout.SOUTH);
				
				JPanel panelFoto = new JPanel();
				panelFoto.setOpaque(false);
				columnaDer.add(panelFoto);
				panelFoto.setBorder(new TitledBorder(null, "Foto de su Mascota", TitledBorder.CENTER, TitledBorder.TOP, null, null));
				panelFoto.setLayout(new BorderLayout(0, 0));
				
				JLabel labelFoto = new JLabel("Ninguna Seleccionada");
				labelFoto.setHorizontalAlignment(SwingConstants.CENTER);
				labelFoto.setAlignmentX(Component.CENTER_ALIGNMENT);
				panelFoto.add(labelFoto);
				
				JButton btnSeleccionarImagen = new JButton("Seleccionar Imagen");
				btnSeleccionarImagen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							imagenSeleccionada = Imagenes.seleccionarImagen();
							int ancho = labelFoto.getSize().width;
							int alto = labelFoto.getSize().height;
							labelFoto.setText("");
							labelFoto.setIcon(new ImageIcon(Imagenes.cargarImagen(imagenSeleccionada)
									.getScaledInstance(ancho, alto, BufferedImage.SCALE_FAST)));
						} catch (ImagenNoEncontradaException e) {
							JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
									"Advertencia", JOptionPane.WARNING_MESSAGE);
							imagenSeleccionada = "";
							labelFoto.setIcon(null);
							labelFoto.setText("Ninguna Seleccionada");
						}
					}
				});
				btnSeleccionarImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
				panelFoto.add(btnSeleccionarImagen, BorderLayout.SOUTH);
		
		JPanel panelOperaciones = new JPanel();
		panelOperaciones.setOpaque(false);
		getContentPane().add(panelOperaciones, BorderLayout.SOUTH);
		
		JButton botonCancelar = new JButton("Cancelar");
		panelOperaciones.add(botonCancelar);
		botonCancelar.setOpaque(false);
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton botonRegistrar = new JButton("Registrar");
		panelOperaciones.add(botonRegistrar);
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mascota mascota = new Mascota(campoNombre.getText(), (String)comboBoxEspecie.getSelectedItem(), (String)comboBoxRaza.getSelectedItem(), Integer.getInteger(campoRecompensa.getText()==null? "0" : campoRecompensa.getText() ) , campoNotas.getText());
				mascota.setCastrada(checkBoxCastrada.isSelected());
				mascota.setColor((String)comboBoxColor.getSelectedItem());
				mascota.setDesparacitada(checkBoxDesparacitada.isSelected());
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
		botonRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
	}
}
