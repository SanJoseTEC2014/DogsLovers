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
import javax.swing.JScrollBar;

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
	private final JButton btnVentanaPrueba = new JButton("Ocultar resultados");
	boolean pantallaOculta = true;
	private JLabel txtMensajeEstado;
	private JPanel panelTable;
	private JScrollPane scrollPane;

	public FormularioBusquedaMascotas(LinkedList<Mascota> pListaOrigenMascotas) {
		listaOrigenMascotas = pListaOrigenMascotas;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,280);
		
		JPanel marcoTitulo = new JPanel();
		getContentPane().add(marcoTitulo, BorderLayout.NORTH);
		marcoTitulo.setLayout(new BorderLayout(0, 0));
		
		txtMensajeEstado = new JLabel("");
		txtMensajeEstado.setHorizontalAlignment(SwingConstants.CENTER);
		marcoTitulo.add(txtMensajeEstado, BorderLayout.CENTER);
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
				
				if (pantallaOculta){
					
					
					try {
					    Thread.sleep(1000);  //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
					
					for (int i=0; i<200; i++){ // despliega la ventana 
											   //el 200x2 (aumenta 2 a la ventana cada iteracion) es la cantidad de pixeles que debe estirarse
						
						setSize(500, getHeight()+2);
					}
					pantallaOculta = false;
					txtMensajeEstado.setText("Resultados de la busqueda");
				}
				
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
		btnVentanaPrueba.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!pantallaOculta){
					txtMensajeEstado.setText("Ocultando...");
					for (int i=0; i<400; i++){
						setSize(500, getHeight()-1);
					}
					pantallaOculta = true;
					txtMensajeEstado.setVisible(false);
				}
			}
		});
		marcoTitulo.add(btnVentanaPrueba, BorderLayout.SOUTH);
		
		JPanel marcoContenido = new JPanel();
		getContentPane().add(marcoContenido, BorderLayout.CENTER);
		marcoContenido.setLayout(new BorderLayout(0, 0));
		
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
		
		panelTable = new JPanel();
		marcoContenido.add(panelTable, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		panelTable.add(scrollPane);
		
		jMascotas = new JTable();
		scrollPane.setViewportView(jMascotas);
		jMascotas.setShowHorizontalLines(true);
		jMascotas.setShowVerticalLines(true);
		
		JPanel marcoConfirmaciones = new JPanel();
		getContentPane().add(marcoConfirmaciones, BorderLayout.SOUTH);
		marcoConfirmaciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnReportarEncuentro = new JButton("Reportar Encuentro");
		marcoConfirmaciones.add(btnReportarEncuentro);
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		marcoConfirmaciones.add(btnVerDetalles);
		
	}
	
}
