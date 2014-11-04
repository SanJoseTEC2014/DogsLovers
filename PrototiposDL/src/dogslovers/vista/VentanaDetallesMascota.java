package dogslovers.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
	private JList<String> listaEspecie;
	private JList<String> listaRaza;
	private JList<String> listaEdad;
	private JList<String> listaTamaño;
	private JList<String> listaSexo;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public VentanaDetallesMascota(Mascota mascota, boolean editable) {

		setSize(540,490);
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
		panel.setLayout(new GridLayout(8, 2, 5, 2));

		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);

		campoNombre = new JTextField(mascota.getNombre());
		panel.add(campoNombre);
		if (editable) { campoNombre.setEditable(true); }
		else {campoNombre.setEditable(false);}
		campoNombre.setColumns(10);

		JLabel lblNmeroDelChip = new JLabel("N\u00FAmero del Chip");
		panel.add(lblNmeroDelChip);


		campoNumChip = mascota.getNumeroChip() == null? new JTextField() : new JTextField( mascota.getNumeroChip());
		

		panel.add(campoNumChip);
		if (editable) {campoNombre.setEditable(true);  }
		else campoNumChip.setEditable(false);
		campoNumChip.setColumns(10);

		JLabel lblColor = new JLabel("Color");
		panel.add(lblColor);

		campoColor = new JTextField(mascota.getColor());
		panel.add(campoColor);
		if (editable) { campoColor.setEditable(true); }
		else campoColor.setEditable(false);
		campoColor.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Especie");
		panel.add(lblEspecie);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		
		listaEspecie = new JList<String>();
		scrollPane.setViewportView(listaEspecie);
		listaEspecie.setVisibleRowCount(10);
		listaEspecie.setToolTipText("");
		listaEspecie.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (editable) { 
			listaEspecie.setModel(mascota.getModeloEspecies());
			
		}
		else listaEspecie.setToolTipText(mascota.getEspecie()); 
		
		JLabel lblRaza = new JLabel("Raza");
		panel.add(lblRaza);
										
										
										JScrollPane scrollPane_1 = new JScrollPane();
										scrollPane_1.setOpaque(false);
										panel.add(scrollPane_1);
											
								
										listaRaza = new JList<String>();
										scrollPane_1.setViewportView(listaRaza);
										listaRaza.setVisibleRowCount(10);
										listaRaza.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (editable) { 
			listaRaza.setModel(mascota.getModeloRazas());
		}
		else listaRaza.setToolTipText(mascota.getRaza()); 

		

		JLabel lblEdad = new JLabel("Edad");
		panel.add(lblEdad);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel.add(scrollPane_2);

		listaEdad = new JList<String>();
		scrollPane_2.setViewportView(listaEdad);
		listaEdad.setVisibleRowCount(4);
		listaEdad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (editable) { 
			listaEdad.setModel(mascota.getModeloEdades());
			
		}
		else listaEdad.setToolTipText(mascota.getEdad()); 
		
		

		JLabel lblTamao = new JLabel("Tama\u00F1o");
		panel.add(lblTamao);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel.add(scrollPane_3);

		listaTamaño = new JList<String>();
		scrollPane_3.setViewportView(listaTamaño);
		listaTamaño.setVisibleRowCount(3);
		listaTamaño.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (editable) { 
			listaTamaño.setModel(mascota.getModeloEdades());
			
		}
		else listaTamaño.setToolTipText(mascota.getTamanio()); 

		JLabel lblNewLabel_1 = new JLabel("Sexo");
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel.add(scrollPane_4);

		listaSexo = new JList<String>();
		scrollPane_4.setViewportView(listaSexo);
		listaSexo.setVisibleRowCount(2);
		listaSexo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

		

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estado Actual",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 361, 504, 46);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 0, -60));

		rdbtnNewRadioButton_1 = new JRadioButton("Perdida");
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel_1.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("Encontrada");
		buttonGroup.add(rdbtnNewRadioButton_2);
		panel_1.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_4 = new JRadioButton("Localizada");
		buttonGroup.add(rdbtnNewRadioButton_4);
		panel_1.add(rdbtnNewRadioButton_4);

		rdbtnNewRadioButton_3 = new JRadioButton("Adoptada");
		buttonGroup.add(rdbtnNewRadioButton_3);
		panel_1.add(rdbtnNewRadioButton_3);

		rdbtnNewRadioButton = new JRadioButton("Refugiada");
		buttonGroup.add(rdbtnNewRadioButton);
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
		checkBox.setSelected(mascota.isVacunada());
		checkBox.setEnabled(editable);
		
			
		checkBox_1 = new JCheckBox("Castrada");
		panel_2.add(checkBox_1);
		checkBox_1.setSelected(mascota.isCastrada());
		checkBox_1.setEnabled(editable);
		

		checkBox_2 = new JCheckBox("Desparacitada");
		panel_2.add(checkBox_2);
		checkBox_2.setSelected(mascota.isDesparacitada());
		checkBox_2.setEnabled(editable);

		checkBox_3 = new JCheckBox("Discapacitada");
		panel_2.add(checkBox_3);
		checkBox_3.setSelected(mascota.isDiscapacitada());
		checkBox_3.setEnabled(editable);
		

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
