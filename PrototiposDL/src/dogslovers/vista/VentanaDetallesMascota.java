package dogslovers.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
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
import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;
import javax.swing.JList;

import dogslovers.control.Principal;
import dogslovers.modelo.Mascota;
import dogslovers.modelo.Usuario;

import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;

public class VentanaDetallesMascota extends JFrame {
	private JTextField campoColor;
	private JCheckBox checkVacunada;
	private JCheckBox checkCastrada;
	private JCheckBox checkDesparacitada;
	private JCheckBox checkDiscapacitada;
	private JRadioButton radioPerdida;
	private JRadioButton radioEncontrada;
	private JRadioButton radioLocalizada;
	private JRadioButton radioAdoptada;
	private JRadioButton radioRefugiada;
	private JComboBox<String> comboEspecie;
	private JComboBox<String> comboRaza;
	private JComboBox<String> comboEdad;
	private JComboBox<String> comboTamanio;
	private JComboBox<String> comboSexo;
	private final ButtonGroup buttonGroupEstados = new ButtonGroup();
	private JTextField campoNumeroChip;
	private JPanel marcoCentro;
	private JPanel marcoFoto;
	private JLabel labelDetalles;
	private JLabel labelFotoMascota;
	private JButton botonVerMasFotos;
	private JPanel marcoInformacionPrincipal;
	private JLabel labelNombre;
	private JTextField campoNombre;
	private JLabel labelNumeroChip;
	private JLabel labelColor;
	private JLabel lblEspecie;
	private JLabel labelRaza;
	private JLabel labelEdad;
	private JLabel labelTamanio;
	private JLabel labelSexo;
	private JPanel marcoInferior;
	private JPanel marcoRadios;
	private JPanel marcoChecks;
	private JPanel marcoOperaciones;
	private JButton botonSoyDuenio;
	private JPanel marcoOperacionesBasicas;
	private JButton botonCancelar;
	private JButton botonGuardarCambios;

	public VentanaDetallesMascota(Mascota mascota, boolean editable) {
		setSize(600, 500);
		getContentPane().setBackground(Principal.fondoVentanas);
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
		labelDetalles.setFont(new Font("Tahoma", Font.PLAIN, 20));

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
		marcoInformacionPrincipal.setLayout(new GridLayout(8, 2, 0, 10));

		labelNombre = new JLabel("Nombre");
		marcoInformacionPrincipal.add(labelNombre);

		campoNombre = new JTextField(mascota.getNombre());
		marcoInformacionPrincipal.add(campoNombre);
		campoNombre.setEditable(editable);
		campoNombre.setColumns(12);

		labelNumeroChip = new JLabel("N\u00FAmero del Chip");
		marcoInformacionPrincipal.add(labelNumeroChip);

		campoNumeroChip = new JTextField();
		campoNumeroChip.setText(mascota.getNumeroChip() == null ? "" : mascota.getNumeroChip().toString());
		campoNumeroChip.setColumns(12);
		marcoInformacionPrincipal.add(campoNumeroChip);

		labelColor = new JLabel("Color");
		marcoInformacionPrincipal.add(labelColor);

		campoColor = new JTextField(mascota.getColor());
		marcoInformacionPrincipal.add(campoColor);
		campoColor.setColumns(12);

		lblEspecie = new JLabel("Especie");
		marcoInformacionPrincipal.add(lblEspecie);

		comboEspecie = new JComboBox<String>();
		comboEspecie.setToolTipText("");
		marcoInformacionPrincipal.add(comboEspecie);

		labelRaza = new JLabel("Raza");
		marcoInformacionPrincipal.add(labelRaza);

		comboRaza = new JComboBox<String>();
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
		marcoInformacionPrincipal.add(comboEdad);

		labelTamanio = new JLabel("Tama\u00F1o");
		marcoInformacionPrincipal.add(labelTamanio);

		comboTamanio = new JComboBox<String>();
		marcoInformacionPrincipal.add(comboTamanio);

		labelSexo = new JLabel("Sexo");
		marcoInformacionPrincipal.add(labelSexo);

		comboSexo = new JComboBox<String>();
		marcoInformacionPrincipal.add(comboSexo);
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
		buttonGroupEstados.add(radioPerdida);
		marcoRadios.add(radioPerdida);

		radioEncontrada = new JRadioButton("Encontrada");
		buttonGroupEstados.add(radioEncontrada);
		marcoRadios.add(radioEncontrada);

		radioLocalizada = new JRadioButton("Localizada");
		buttonGroupEstados.add(radioLocalizada);
		marcoRadios.add(radioLocalizada);

		radioAdoptada = new JRadioButton("Adoptada");
		buttonGroupEstados.add(radioAdoptada);
		marcoRadios.add(radioAdoptada);

		radioRefugiada = new JRadioButton("Refugiada");
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
		marcoChecks.add(checkVacunada);

		checkCastrada = new JCheckBox("Castrada");
		marcoChecks.add(checkCastrada);

		checkDesparacitada = new JCheckBox("Desparacitada");
		marcoChecks.add(checkDesparacitada);

		checkDiscapacitada = new JCheckBox("Discapacitada");
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
		botonGuardarCambios.setOpaque(false);
		marcoOperacionesBasicas.add(botonGuardarCambios);

		campoNombre.setEditable(editable);
		campoNumeroChip.setEditable(editable);
		campoColor.setEditable(editable);
		
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
}
