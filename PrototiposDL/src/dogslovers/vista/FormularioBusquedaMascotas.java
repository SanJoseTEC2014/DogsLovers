package dogslovers.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dogslovers.control.BuscadorMascotas;
import dogslovers.modelo.Mascota;

import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class FormularioBusquedaMascotas extends JFrame {
	
	private static LinkedList<Mascota> listaOrigenMascotas;
	
	private final JLabel lblNewLabel = new JLabel("B\u00FAsqueda Mascotas Extraviadas");
	private JTable jMascotas;
	private JTextField textNombre;
	private JTextField textLugar;
	private JTextField textChipID;
	private JCheckBox checkNombre;
	private JCheckBox checkLugar;
	private JCheckBox checkChipID;
	private JCheckBox checkEspecie;
	private JCheckBox checkRaza;
	private JComboBox<String> comboEspecies;
	private JComboBox<String> comboRazas;

	public FormularioBusquedaMascotas(LinkedList<Mascota> pListaOrigenMascotas) {
		listaOrigenMascotas = pListaOrigenMascotas;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,700);
		
		JPanel marcoTitulo = new JPanel();
		getContentPane().add(marcoTitulo, BorderLayout.NORTH);
		marcoTitulo.setLayout(new BorderLayout(0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		marcoTitulo.add(lblNewLabel, BorderLayout.NORTH);
		
		JButton btnBuscar = new JButton("Realizar B\u00FAsqueda");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkedList<String> terminos = new LinkedList<String>();
				if (checkNombre.isSelected())	{ terminos.add(textNombre.getText()); } else { terminos.add(""); }
				if (checkLugar.isSelected())	{ terminos.add(textLugar.getText()); } else { terminos.add(""); }
				if (checkChipID.isSelected())	{ terminos.add(textChipID.getText()); } else { terminos.add(""); }
				if (checkEspecie.isSelected())	{
					terminos.add(Mascota.especies.get(comboEspecies.getSelectedIndex()));
					if (checkRaza.isSelected()) {
						terminos.add(Mascota.razas.get(comboEspecies.getSelectedIndex())[comboRazas.getSelectedIndex()]);
					} else { terminos.add(""); } 
				}
				else {
					terminos.add(""); terminos.add("");
				}
				jMascotas.setModel(new BuscadorMascotas((LinkedList<Mascota>) listaOrigenMascotas.clone(), terminos));
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		marcoTitulo.add(btnBuscar, BorderLayout.EAST);
		
		JButton btnAyuda = new JButton("\u00A1Necesito Ayuda!");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("kako :3");
			}
		});
		marcoTitulo.add(btnAyuda, BorderLayout.WEST);
		
		JPanel marcoContenido = new JPanel();
		getContentPane().add(marcoContenido, BorderLayout.CENTER);
		marcoContenido.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollTabla = new JScrollPane();
		scrollTabla.setViewportBorder(UIManager.getBorder("TitledBorder.border"));
		scrollTabla.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		marcoContenido.add(scrollTabla, BorderLayout.CENTER);
		
		jMascotas = new JTable();
		jMascotas.setShowHorizontalLines(true);
		jMascotas.setShowVerticalLines(true);
		scrollTabla.add(jMascotas);
		
		JPanel marcoOpciones = new JPanel();
		marcoContenido.add(marcoOpciones, BorderLayout.NORTH);
		marcoOpciones.setLayout(new GridLayout(5, 2, 0, 0));
		
		checkNombre = new JCheckBox("Nombre");
		checkNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkNombre.isSelected()) { textNombre.setEnabled(true); } else { textNombre.setText(""); textNombre.setEnabled(false); } 
			}
		});
		marcoOpciones.add(checkNombre);
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		marcoOpciones.add(textNombre);
		textNombre.setColumns(10);
		
		checkLugar = new JCheckBox("Lugar Extrav\u00EDo");
		checkLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkLugar.isSelected()) { textLugar.setEnabled(true); } else { textLugar.setText(""); textLugar.setEnabled(false); } 
			}
		});
		marcoOpciones.add(checkLugar);
		
		textLugar = new JTextField();
		textLugar.setEnabled(false);
		marcoOpciones.add(textLugar);
		textLugar.setColumns(10);
		
		checkChipID = new JCheckBox("N\u00FAmero de Chip");
		checkChipID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkChipID.isSelected()) { textChipID.setEnabled(true); } else { textChipID.setText(""); textChipID.setEnabled(false); } 
			}
		});
		marcoOpciones.add(checkChipID);
		
		textChipID = new JTextField();
		textChipID.setEnabled(false);
		marcoOpciones.add(textChipID);
		textChipID.setColumns(10);
		
		checkEspecie = new JCheckBox("Especie");
		checkEspecie .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkEspecie.isSelected()) {
					comboEspecies.setEnabled(true);
					checkRaza.setEnabled(true);
					comboEspecies.setModel(new DefaultComboBoxModel<String>(Mascota.especies.toArray(new String[Mascota.especies.size()])));
				} else {
					comboEspecies.setEnabled(false);
					comboEspecies.setModel(new DefaultComboBoxModel<String>());
					checkRaza.setSelected(false);
					checkRaza.setEnabled(false);
					comboRazas.setModel(new DefaultComboBoxModel<String>());}
					comboRazas.setEnabled(false);
				}
			}
		);
		marcoOpciones.add(checkEspecie);
		
		comboEspecies = new JComboBox<String>();
		comboEspecies.setEnabled(false);
		marcoOpciones.add(comboEspecies);
		
		checkRaza = new JCheckBox("Raza");
		checkRaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkRaza.isSelected()) {
					comboRazas.setEnabled(true);
					comboRazas.setModel(new DefaultComboBoxModel<String>(Mascota.razas.get(comboEspecies.getSelectedIndex())));
				} else {
					comboRazas.setModel(new DefaultComboBoxModel<String>());
					comboRazas.setEnabled(false);
				}
			}
		});
		checkRaza.setEnabled(false);
		marcoOpciones.add(checkRaza);
		
		comboRazas = new JComboBox<String>();
		comboRazas.setEnabled(false);
		marcoOpciones.add(comboRazas);
		
		JPanel marcoConfirmaciones = new JPanel();
		getContentPane().add(marcoConfirmaciones, BorderLayout.SOUTH);
		marcoConfirmaciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnReportarEncuentro = new JButton("Reportar Encuentro");
		marcoConfirmaciones.add(btnReportarEncuentro);
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		marcoConfirmaciones.add(btnVerDetalles);
		
	}
	
}
