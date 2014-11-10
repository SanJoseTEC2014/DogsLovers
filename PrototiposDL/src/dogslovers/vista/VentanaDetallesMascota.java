package dogslovers.vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import dogslovers.control.MaquinaEstadosMascotas;
import dogslovers.modelo.Mascota;
import dogslovers.recursos.Diseno;

public class VentanaDetallesMascota extends JFrame {
	private JButton botonCancelar;
	private JButton botonGuardarCambios;
	private JButton botonQuieroAdoptarEsta;
	private JButton botonSoyDuenio;
	private JButton botonVerMasFotos;
	private final ButtonGroup buttonGroupEstados = new ButtonGroup();
	private JTextField campoColor;
	private JTextField campoMontoRecompensa;
	private JTextField campoNombre;
	private JTextField campoNumeroChip;
	private JCheckBox checkCastrada;
	private JCheckBox checkDesparacitada;
	private JCheckBox checkDiscapacitada;
	private JCheckBox checkVacunada;
	private JComboBox<String> comboEdad;
	private JComboBox<String> comboEspecie;
	private JComboBox<String> comboRaza;
	private JComboBox<String> comboSexo;
	private JComboBox<String> comboTamanio;
	private JLabel labelColor;
	private JLabel labelDetalles;
	private JLabel labelEdad;
	private JLabel labelFotoMascota;
	private JLabel labelMontoRecompensa;
	private JLabel labelNombre;
	private JLabel labelNumeroChip;
	private JLabel labelRaza;
	private JLabel labelSexo;
	private JLabel labelTamanio;
	private JLabel lblEspecie;
	private JPanel marcoCentro;
	private JPanel marcoChecks;
	private JPanel marcoFoto;
	private JPanel marcoInferior;
	private JPanel marcoInformacionPrincipal;
	private JPanel marcoOperaciones;
	private JPanel marcoOperacionesBasicas;
	private JPanel marcoRadios;
	private JRadioButton radioAdoptada;
	private JRadioButton radioEncontrada;
	private JRadioButton radioLocalizada;
	private JRadioButton radioPerdida;
	private JRadioButton radioRefugiada;

	public VentanaDetallesMascota() {
		setSize(600, 500);
		getContentPane().setBackground(Diseno.fondoVentanas);
		getContentPane().setLayout(new BorderLayout(20, 10));

		marcoCentro = new JPanel();
		marcoCentro.setOpaque(false);
		getContentPane().add(marcoCentro, BorderLayout.CENTER);
		marcoCentro.setLayout(new BorderLayout(10, 10));

		marcoFoto = new JPanel();
		marcoFoto.setOpaque(false);
		marcoCentro.add(marcoFoto, BorderLayout.CENTER);
		marcoFoto.setLayout(new BorderLayout(10, 10));
		labelDetalles = new JLabel("Detalles Mascota");
		marcoFoto.add(labelDetalles, BorderLayout.NORTH);
		labelDetalles.setHorizontalAlignment(SwingConstants.CENTER);
		labelDetalles.setFont(Diseno.fuenteTitulosVentanas.deriveFont(25f));

		labelFotoMascota = new JLabel("FOTO MASCOTA");
		marcoFoto.add(labelFotoMascota, BorderLayout.CENTER);
		labelFotoMascota.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null));
		labelFotoMascota.setBackground(Color.GREEN);
		labelFotoMascota.setHorizontalAlignment(SwingConstants.CENTER);

		botonVerMasFotos = new JButton("Ver m\u00E1s fotos");
		botonVerMasFotos.setOpaque(false);
		marcoFoto.add(botonVerMasFotos, BorderLayout.SOUTH);

		marcoInformacionPrincipal = new JPanel();
		marcoInformacionPrincipal.setOpaque(false);
		marcoCentro.add(marcoInformacionPrincipal, BorderLayout.EAST);
		marcoInformacionPrincipal.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Informaci\u00F3n Principal", TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 11), new Color(
						0, 0, 0)));
		marcoInformacionPrincipal.setLayout(new GridLayout(9, 2, 0, 10));

		labelNombre = new JLabel("Nombre");
		marcoInformacionPrincipal.add(labelNombre);

		campoNombre = new JTextField();
		campoNombre.setEditable(false);
		marcoInformacionPrincipal.add(campoNombre);
		campoNombre.setColumns(12);

		labelNumeroChip = new JLabel("N\u00FAmero del Chip");
		marcoInformacionPrincipal.add(labelNumeroChip);

		campoNumeroChip = new JTextField();
		campoNumeroChip.setEditable(false);
		campoNumeroChip.setColumns(12);
		marcoInformacionPrincipal.add(campoNumeroChip);

		labelColor = new JLabel("Color");
		marcoInformacionPrincipal.add(labelColor);

		campoColor = new JTextField();
		campoColor.setEditable(false);
		marcoInformacionPrincipal.add(campoColor);
		campoColor.setColumns(12);

		lblEspecie = new JLabel("Especie");
		marcoInformacionPrincipal.add(lblEspecie);

		comboEspecie = new JComboBox<String>();
		comboEspecie.setEnabled(false);
		comboEspecie.setToolTipText("");
		marcoInformacionPrincipal.add(comboEspecie);

		labelRaza = new JLabel("Raza");
		marcoInformacionPrincipal.add(labelRaza);

		comboRaza = new JComboBox<String>();
		comboRaza.setEnabled(false);
		// Esto permite que cuando el ComboBox esté desactivado, pueda
		// seguir viéndose el texto del lapso del Usuario claramente.
		comboRaza.setRenderer(new DefaultListCellRenderer(){
		    @Override
		    public Component
		    getListCellRendererComponent(JList<?> list, Object value, int index,
		    							boolean isSelected, boolean cellHasFocus)
		    {
		        JComponent result = (JComponent)super.getListCellRendererComponent
		        					(list, value, index, isSelected, cellHasFocus);
		        result.setOpaque(false);
		        return result;
		    }
		});
		// Aquí se obtienen los datos directamente del Modelo
		// String[] lapsos = (String[]) Usuario.lapsos.toArray();
		// comboRaza.setModel(new DefaultComboBoxModel<String>(lapsos));
		marcoInformacionPrincipal.add(comboRaza);
		
		marcoInformacionPrincipal.add(comboRaza);

		labelEdad = new JLabel("Edad");
		marcoInformacionPrincipal.add(labelEdad);

		comboEdad = new JComboBox<String>();
		comboEdad.setEnabled(false);
		marcoInformacionPrincipal.add(comboEdad);

		labelTamanio = new JLabel("Tama\u00F1o");
		marcoInformacionPrincipal.add(labelTamanio);

		comboTamanio = new JComboBox<String>();
		comboTamanio.setEnabled(false);
		marcoInformacionPrincipal.add(comboTamanio);

		labelSexo = new JLabel("Sexo");
		marcoInformacionPrincipal.add(labelSexo);

		comboSexo = new JComboBox<String>();
		comboSexo.setEnabled(false);
		marcoInformacionPrincipal.add(comboSexo);
		
		labelMontoRecompensa = new JLabel("Monto Recompensa:");
		marcoInformacionPrincipal.add(labelMontoRecompensa);
		
		campoMontoRecompensa = new JTextField();
		campoMontoRecompensa.setEditable(false);
		campoMontoRecompensa.setColumns(12);
		marcoInformacionPrincipal.add(campoMontoRecompensa);
		botonVerMasFotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		marcoInferior = new JPanel();
		marcoInferior.setOpaque(false);
		getContentPane().add(marcoInferior, BorderLayout.SOUTH);
		marcoInferior.setLayout(new BorderLayout(10, 10));

		marcoRadios = new JPanel();
		marcoRadios.setOpaque(false);
		marcoInferior.add(marcoRadios, BorderLayout.NORTH);
		marcoRadios.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Estado Actual",
				TitledBorder.LEFT, TitledBorder.TOP, new Font("Tahoma",
						Font.BOLD, 11), new Color(0, 0, 0)));
		marcoRadios.setLayout(new GridLayout(0, 5, 20, 20));

		radioPerdida = new JRadioButton("Perdida");
		radioPerdida.setEnabled(false);
		radioPerdida.setOpaque(false);
		buttonGroupEstados.add(radioPerdida);
		marcoRadios.add(radioPerdida);

		radioEncontrada = new JRadioButton("Encontrada");
		radioEncontrada.setEnabled(false);
		radioEncontrada.setOpaque(false);
		buttonGroupEstados.add(radioEncontrada);
		marcoRadios.add(radioEncontrada);

		radioLocalizada = new JRadioButton("Localizada");
		radioLocalizada.setEnabled(false);
		radioLocalizada.setOpaque(false);
		buttonGroupEstados.add(radioLocalizada);
		marcoRadios.add(radioLocalizada);

		radioAdoptada = new JRadioButton("Adoptada");
		radioAdoptada.setEnabled(false);
		radioAdoptada.setOpaque(false);
		buttonGroupEstados.add(radioAdoptada);
		marcoRadios.add(radioAdoptada);

		radioRefugiada = new JRadioButton("Refugiada");
		radioRefugiada.setEnabled(false);
		radioRefugiada.setOpaque(false);
		buttonGroupEstados.add(radioRefugiada);
		marcoRadios.add(radioRefugiada);

		marcoChecks = new JPanel();
		marcoChecks.setOpaque(false);
		marcoInferior.add(marcoChecks, BorderLayout.CENTER);
		marcoChecks.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Información Física & Veterinaria", TitledBorder.LEFT,
				TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 11), new Color(
						0, 0, 0)));
		marcoChecks.setLayout(new GridLayout(0, 4, 20, 20));

		checkVacunada = new JCheckBox("Vacunada");
		checkVacunada.setEnabled(false);
		checkVacunada.setOpaque(false);
		marcoChecks.add(checkVacunada);

		checkCastrada = new JCheckBox("Castrada");
		checkCastrada.setEnabled(false);
		checkCastrada.setOpaque(false);
		marcoChecks.add(checkCastrada);

		checkDesparacitada = new JCheckBox("Desparacitada");
		checkDesparacitada.setEnabled(false);
		checkDesparacitada.setOpaque(false);
		marcoChecks.add(checkDesparacitada);

		checkDiscapacitada = new JCheckBox("Discapacitada");
		checkDiscapacitada.setEnabled(false);
		checkDiscapacitada.setOpaque(false);
		marcoChecks.add(checkDiscapacitada);

		marcoOperaciones = new JPanel();
		marcoOperaciones.setOpaque(false);
		marcoInferior.add(marcoOperaciones, BorderLayout.SOUTH);
		marcoOperaciones.setLayout(new BorderLayout(10, 10));

		botonSoyDuenio = new JButton("\u00A1Soy el due\u00F1o de esta mascota!");
		botonSoyDuenio.setOpaque(false);
		botonSoyDuenio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		marcoOperaciones.add(botonSoyDuenio, BorderLayout.WEST);

		marcoOperacionesBasicas = new JPanel();
		marcoOperacionesBasicas.setOpaque(false);
		marcoOperacionesBasicas.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		marcoOperaciones.add(marcoOperacionesBasicas, BorderLayout.EAST);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setOpaque(false);
		marcoOperacionesBasicas.add(botonCancelar);

		botonGuardarCambios = new JButton("Guardar Cambios");
		botonGuardarCambios.setVisible(false);
		botonGuardarCambios.setOpaque(false);
		marcoOperacionesBasicas.add(botonGuardarCambios);
		
		botonQuieroAdoptarEsta = new JButton("Quiero adoptarla");
		botonQuieroAdoptarEsta.setOpaque(false);
		marcoOperaciones.add(botonQuieroAdoptarEsta, BorderLayout.CENTER);
		
		/*
		if (orden == "MostrarDetalles") {
			comboEspecie.setToolTipText(mascota.getEspecie());
		} else
			comboEspecie.setModel(mascota.getModeloEspecies());
		if (orden == "MostrarDetalles") {
			comboRaza.setToolTipText(mascota.getRaza());
		} else
			comboRaza.setModel(mascota.getModeloRazas());
		if (orden == "MostrarDetalles") {
			comboEdad.setToolTipText(mascota.getEdad());
		} else
			comboEdad.setModel(mascota.getModeloEdades());
		if (orden == "MostrarDetalles") {
			comboTamanio.setToolTipText(mascota.getTamanio());
		} else
			comboTamanio.setModel(mascota.getModeloEdades());
		if (orden == "MostrarDetalles") {
			checkVacunada.setSelected(mascota.isVacunada());
		} else {
			checkVacunada.setSelected(mascota.isVacunada());

		}
		if (orden == "MostrarDetalles") {
			checkCastrada.setSelected(mascota.isCastrada());
		} else {
			checkCastrada.setSelected(mascota.isCastrada());
		}
		if (orden == "MostrarDetalles") {
			checkDesparacitada.setSelected(mascota.isDesparacitada());
		} else {
			checkDesparacitada.setSelected(mascota.isDesparacitada());
		}
		if (orden == "MostrarDetalles") {
			checkDiscapacitada.setSelected(mascota.isDiscapacitada());
		} else {
			checkDiscapacitada.setSelected(mascota.isDiscapacitada());
		}
		*/
	}
	
	public void setDatosIniciales(Mascota mascota){
		
		// El boton soy dueño aparece sii la mascota esta encontrada, adoptable o refugiada
		botonSoyDuenio.setVisible(mascota.getEstadoActual().equals(MaquinaEstadosMascotas.estadoENCONTRADA)
				|| mascota.getEstadoActual().equals(MaquinaEstadosMascotas.estadoADOPTABLE)
				|| mascota.getEstadoActual().equals(MaquinaEstadosMascotas.estadoREFUGIADA));

		campoNombre.setText(mascota.getNombre());
		campoNumeroChip.setText(mascota.getNumeroChip() == null ? "" : mascota.getNumeroChip().toString());
		campoColor.setText(mascota.getColor());
		
		labelMontoRecompensa.setVisible(mascota.getEstadoActual().equals(MaquinaEstadosMascotas.estadoPERDIDA));
		campoMontoRecompensa.setVisible(mascota.getEstadoActual().equals(MaquinaEstadosMascotas.estadoPERDIDA));
		campoMontoRecompensa.setText(mascota.getRecompensa().toString());
		
		// pone el boton de adoptar visible si la mascota está adoptable o en refugio
		botonQuieroAdoptarEsta.setVisible(mascota.getEstadoActual()
				.equals(MaquinaEstadosMascotas.estadoADOPTABLE)
						|| mascota.getEstadoActual()
						.equals(MaquinaEstadosMascotas.estadoREFUGIADA));
		
		
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		
		modelo.addElement(mascota.getEspecie());
		comboEspecie.setModel(modelo);
		
		modelo.removeAllElements();
		modelo.addElement(mascota.getRaza());
		comboRaza.setModel(modelo);
		
		modelo.removeAllElements();
		modelo.addElement(mascota.getSexo());
		comboSexo.setModel(modelo);
		
		modelo.removeAllElements();
		modelo.addElement(mascota.getTamanio());
		comboTamanio.setModel(modelo);
		
		
		//TODO activarRadiobuttonEstadoActual();
		
		
	}
	
	public void setModoEdicion(boolean opcion){
		
		botonGuardarCambios.setEnabled(opcion);
		botonCancelar.setEnabled(opcion);
		
		campoNombre.setEditable(opcion);
		campoNumeroChip.setEditable(opcion);
		campoColor.setEditable(opcion);
		
		comboEspecie.setModel(Mascota.getModeloEspecies());
		
		// TODO comboRaza.setModel(modelo);
		
		//comboSexo.setModel(Mascota.getm);
		
		comboTamanio.setModel(Mascota.getModeloTamanios());
	}
}
