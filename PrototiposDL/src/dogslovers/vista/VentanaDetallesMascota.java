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
import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;
import javax.swing.JList;

import dogslovers.modelo.Mascota;

public class VentanaDetallesMascota extends JFrame {
	private JTextField campoNombre;
	private JTextField campoNumChip;
	private JTextField campoColor;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_4;
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnNewRadioButton;

	public VentanaDetallesMascota(Mascota mascota, String orden) {

		getContentPane().setLayout(null);
		JLabel lblDetallesMascota = new JLabel("Detalles Mascota");
		lblDetallesMascota.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetallesMascota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDetallesMascota.setBounds(30, 11, 152, 25);
		getContentPane().add(lblDetallesMascota);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Editar detalles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(206, 51, 308, 240);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(8, 2, 10, 5));

		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);

		campoNombre = new JTextField(mascota.getNombre());
		panel.add(campoNombre);
		if (orden == "MostrarDetalles") { campoNombre.setEditable(false); }
		else campoNombre.setEditable(true);
		campoNombre.setColumns(10);

		JLabel lblNmeroDelChip = new JLabel("N\u00FAmero del Chip");
		panel.add(lblNmeroDelChip);

		campoNumChip = new JTextField(mascota.getNumeroChip());
		panel.add(campoNumChip);
		if (orden == "MostrarDetalles") { campoNumChip.setEditable(false); }
		else campoNombre.setEditable(true);
		campoNumChip.setColumns(10);

		JLabel lblColor = new JLabel("Color");
		panel.add(lblColor);

		campoColor = new JTextField(mascota.getColor());
		panel.add(campoColor);
		if (orden == "MostrarDetalles") { campoColor.setEditable(false); }
		else campoColor.setEditable(true);
		campoColor.setColumns(10);

		JLabel lblEspecie = new JLabel("Especie");
		panel.add(lblEspecie);

		JList listaEspecie = new JList();
		panel.add(listaEspecie);
		if (orden == "MostrarDetalles") {listaEspecie.setToolTipText(mascota.getEspecie());}
		else listaEspecie.setModel(Principal.);
		JLabel lblRaza = new JLabel("Raza");
		panel.add(lblRaza);

		JList listaRaza = new JList();
		panel.add(listaRaza);

		JLabel lblEdad = new JLabel("Edad");
		panel.add(lblEdad);

		JList listaEdad = new JList();
		panel.add(listaEdad);

		JLabel lblTamao = new JLabel("Tama\u00F1o");
		panel.add(lblTamao);

		JList listaTama�o = new JList();
		panel.add(listaTama�o);

		JLabel lblNewLabel_1 = new JLabel("Sexo");
		panel.add(lblNewLabel_1);

		JList listaSexo = new JList();
		panel.add(listaSexo);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estado Actual",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 361, 504, 46);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 0, -60));

		rdbtnNewRadioButton_1 = new JRadioButton("Perdida");
		panel_1.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("Encontrada");
		panel_1.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_4 = new JRadioButton("Localizada");
		panel_1.add(rdbtnNewRadioButton_4);

		rdbtnNewRadioButton_3 = new JRadioButton("Adoptada");
		panel_1.add(rdbtnNewRadioButton_3);

		rdbtnNewRadioButton = new JRadioButton("Refugiada");
		panel_1.add(rdbtnNewRadioButton);

		JButton btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(399, 418, 115, 23);
		getContentPane().add(btnGuardarCambios);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(274, 418, 115, 23);
		getContentPane().add(btnCancelar);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Informacion Fisica-Veterinaria", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 302, 505, 46);
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 0, -60));

		checkBox = new JCheckBox("Vacunada");
		panel_2.add(checkBox);

		checkBox_1 = new JCheckBox("Castrada");
		panel_2.add(checkBox_1);

		checkBox_2 = new JCheckBox("Desparacitada");
		panel_2.add(checkBox_2);

		checkBox_3 = new JCheckBox("Discapacitada");
		panel_2.add(checkBox_3);

		JLabel lblInformacinPrincipal = new JLabel("Informaci\u00F3n Principal");
		lblInformacinPrincipal.setFont(lblInformacinPrincipal.getFont().deriveFont(
				lblInformacinPrincipal.getFont().getStyle() | Font.BOLD));
		lblInformacinPrincipal.setBounds(298, 26, 134, 23);
		getContentPane().add(lblInformacinPrincipal);

		JLabel lblFotoMascota = new JLabel("FOTO MASCOTA");
		lblFotoMascota.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblFotoMascota.setBackground(Color.GREEN);
		lblFotoMascota.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoMascota.setBounds(10, 51, 186, 240);
		getContentPane().add(lblFotoMascota);

		JButton btnSoyDueoDe = new JButton("\u00A1Soy el due\u00F1o de esta mascota!");
		btnSoyDueoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSoyDueoDe.setBounds(10, 418, 186, 23);
		getContentPane().add(btnSoyDueoDe);

		JButton btnVerMsFotos = new JButton("Ver m\u00E1s fotos");
		btnVerMsFotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerMsFotos.setBounds(46, 274, 115, 17);
		getContentPane().add(btnVerMsFotos);
	}
}
