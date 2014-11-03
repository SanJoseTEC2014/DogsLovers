package dogslovers.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dogslovers.control.BuscadorMascotas;
import dogslovers.modelo.Mascota;

import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JProgressBar;

public class FormularioBusquedaMascotas extends JFrame {

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
	private JButton btnContraerVentana;
	boolean pantallaOculta = true;
	private JPanel panelTable;
	private JScrollPane scrollPane;
	private JScrollPane scrollJTable;
	
	private ArrayList<Mascota> listaOrigenMascotas;
	private JLabel lblNewLabel_1;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JCheckBox checkMascotasEncontradas;
	private JCheckBox checkMascotasAdoptadas;
	private JCheckBox checkMascotasEnRefugio;
	private JCheckBox checkMascotasEnAdopcion;
	private JCheckBox checkMascotasPerdidas;
	
	private boolean[] listasSeleccionadas = {true, false, false, false, false, false};
	private JCheckBox checkTodasLasListas;
	private JProgressBar progressBar;
	//listas seleccionadas para busqueda     todas(las listas) //perdidas // encontradas// adoptadas// en adopcion// en refugio//

	public FormularioBusquedaMascotas() {
		setName("barraCarga");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 290);

		JPanel marcoTitulo = new JPanel();
		getContentPane().add(marcoTitulo, BorderLayout.NORTH);
		marcoTitulo.setLayout(new BorderLayout(0, 0));
		
		progressBar = new JProgressBar();
		marcoTitulo.add(progressBar, BorderLayout.CENTER);
		progressBar.setStringPainted(true);
		progressBar.setString("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		marcoTitulo.add(lblNewLabel, BorderLayout.NORTH);

		JButton btnBuscar = new JButton("Realizar B\u00FAsqueda");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				LinkedList<String> terminos = new LinkedList<String>();
				if (checkNombre.isSelected()) {
					terminos.add(textNombre.getText());
				} else {
					terminos.add("");
				}
				if (checkLugar.isSelected()) {
					terminos.add(textLugar.getText());
				} else {
					terminos.add("");
				}
				if (checkChipID.isSelected()) {
					terminos.add(textChipID.getText());
				} else {
					terminos.add("");
				}
				if (checkEspecie.isSelected()) {
					terminos.add(Mascota.especies.get(comboEspecies.getSelectedIndex()));
					if (checkRaza.isSelected()) {
						terminos.add(Mascota.razas.get(comboEspecies.getSelectedIndex())
								[comboRazas.getSelectedIndex()]);
					} else {
						terminos.add("");
					}
				} else {
					// Sin especie y sin raza.
					terminos.add("");
					terminos.add("");
				}
				
				
				if (checkTodasLasListas.isSelected()) listasSeleccionadas[0] = true;
				else listasSeleccionadas[0] = false;
		
				if (checkMascotasEncontradas.isSelected()) listasSeleccionadas[1] = true;
				else listasSeleccionadas[1] = false;
					
				if (checkMascotasPerdidas.isSelected()) listasSeleccionadas[2] = true;
				else listasSeleccionadas[2] = false;
				
				if (checkMascotasAdoptadas.isSelected()) listasSeleccionadas[3] = true;
				else listasSeleccionadas[3] = false;
				
				if (checkMascotasEnAdopcion.isSelected()) listasSeleccionadas[4] = true;
				else listasSeleccionadas[4] = false;
				
				if (checkMascotasEnRefugio.isSelected()) listasSeleccionadas[5]=true;
				else listasSeleccionadas[5] = false;
				
				if (algunaListaSeleccionada(listasSeleccionadas)){
					BuscadorMascotas Modelo = new BuscadorMascotas(terminos, listasSeleccionadas);
					jMascotas.setModel(Modelo);
					jMascotas.setVisible(true);
					progressBar.setMaximum(Modelo.getCantidadDeResultados());
					
					if (pantallaOculta){	
						actualizarBarraProgreso(Modelo.getCantidadDeResultados());
						
						// Expande la ventana
						for (int i = 0; i < 200; i++){
							// Cada iteración expande la ventana 2 píxeles hasta un máximo de 400 píxeles estirados
							setSize(500, getHeight()+2);
						}
						pantallaOculta = false;
					}
				}
				else{ 
					progressBar.setString("No se ha seleccionado ninguna lista");
				}
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
				
			

			private void actualizarBarraProgreso(Integer cantidadDeMascotas) {
				for (Integer i = 0; i < cantidadDeMascotas; i++){
					try {
						progressBar.setValue(i);
						Integer mascotas = i+1;
						progressBar.setString(mascotas.toString().concat(" MascotasEncontradas"));
						java.lang.Thread.sleep(10);
						
					} catch (InterruptedException e) {}
				}
			}



			private boolean algunaListaSeleccionada(boolean[] listasSeleccionadas) {
				boolean unaListaSeleccionada = false;
				for (int i=0; i<listasSeleccionadas.length; i++){
					if (listasSeleccionadas[i]) {
						unaListaSeleccionada = true;
						break;
					}
				}
				return unaListaSeleccionada;
			}
			
		});
		marcoTitulo.add(btnBuscar, BorderLayout.EAST);

		JButton btnAyuda = new JButton("\u00A1Necesito Ayuda!");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(getContentPane(),
					"Para realizar una búsqueda, seleccione los campos que \n" + 
					"desee tomar en cuenta. Si un campo no está seleccionado, \n" + 
					"las mascotas que aparezcan en los resultados de búsqueda \n" +
					"no estarán filtradas (excluídas) por dicho campo. \n\n" + 
					"Para más información, contacte al equipo de desarrollo.",
					"Ayuda ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		marcoTitulo.add(btnAyuda, BorderLayout.WEST);

		JPanel marcoContenido;

		btnContraerVentana = new JButton("Ocultar resultados");
		btnContraerVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!pantallaOculta){
					// Contrae la ventana un píxel a la vez
					for (int i = 0; i < 400; i++){
						setSize(500, getHeight()-1);
					}
					pantallaOculta = true;
					jMascotas.setVisible(false);
					progressBar.setValue(0);
					progressBar.setString("");

				}
			}
		});
		marcoTitulo.add(btnContraerVentana, BorderLayout.SOUTH);
		
		marcoContenido = new JPanel();
		getContentPane().add(marcoContenido, BorderLayout.CENTER);
		marcoContenido.setLayout(new BorderLayout(0, 0));
		
		JPanel marcoOpciones = new JPanel();
		marcoContenido.add(marcoOpciones, BorderLayout.NORTH);
		marcoOpciones.setLayout(new GridLayout(6, 2, 0, 0));

		checkNombre = new JCheckBox("Nombre");
		checkNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkNombre.isSelected()) {
					textNombre.setEnabled(true);
				} else {
					textNombre.setText("");
					textNombre.setEnabled(false);
				}
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
				if (checkLugar.isSelected()) {
					textLugar.setEnabled(true);
				} else {
					textLugar.setText("");
					textLugar.setEnabled(false);
				}
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
				if (checkChipID.isSelected()) {
					textChipID.setEnabled(true);
				} else {
					textChipID.setText("");
					textChipID.setEnabled(false);
				}
			}
		});
		marcoOpciones.add(checkChipID);

		textChipID = new JTextField();
		textChipID.setEnabled(false);
		marcoOpciones.add(textChipID);
		textChipID.setColumns(10);

		checkEspecie = new JCheckBox("Especie");
		checkEspecie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkEspecie.isSelected()) {
					comboEspecies.setEnabled(true);
					checkRaza.setEnabled(true);
					comboEspecies.setModel(new DefaultComboBoxModel<String>(
							Mascota.especies
									.toArray(new String[Mascota.especies.size()])));
				} else {
					comboEspecies.setEnabled(false);
					comboEspecies.setModel(new DefaultComboBoxModel<String>());
					checkRaza.setSelected(false);
					checkRaza.setEnabled(false);
					comboRazas.setModel(new DefaultComboBoxModel<String>());
				}
				comboRazas.setEnabled(false);
			}
		});
		marcoOpciones.add(checkEspecie);

		comboEspecies = new JComboBox<String>();
		comboEspecies.setEnabled(false);
		marcoOpciones.add(comboEspecies);

		checkRaza = new JCheckBox("Raza");
		checkRaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkRaza.isSelected()) {
					comboRazas.setEnabled(true);
					comboRazas
							.setModel(new DefaultComboBoxModel<String>(
									Mascota.razas.get(comboEspecies
											.getSelectedIndex())));
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
		
		lblNewLabel_1 = new JLabel("Buscar en:");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		marcoOpciones.add(lblNewLabel_1);
		
		menuBar = new JMenuBar();
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		marcoOpciones.add(menuBar);
		
		mnMenu = new JMenu("Menu seleccion");
		mnMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		mnMenu.setBorderPainted(true);
		mnMenu.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		mnMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnMenu.setFocusPainted(true);
		mnMenu.setDelay(100);
		mnMenu.setAutoscrolls(true);
		menuBar.add(mnMenu);
		
		checkTodasLasListas = new JCheckBox("TODAS");
		checkTodasLasListas.setSelected(true);
		mnMenu.add(checkTodasLasListas);
		
		checkMascotasEncontradas = new JCheckBox("Mascotas encontradas");
		mnMenu.add(checkMascotasEncontradas);
		
		checkMascotasPerdidas = new JCheckBox("Mascotas perdidas");
		mnMenu.add(checkMascotasPerdidas);
		
		checkMascotasAdoptadas = new JCheckBox("Mascotas adoptadas");
		mnMenu.add(checkMascotasAdoptadas);
		
		checkMascotasEnAdopcion = new JCheckBox("Mascotas en adopcion");
		mnMenu.add(checkMascotasEnAdopcion);
		
		checkMascotasEnRefugio = new JCheckBox("Mascotas en refugio");
		mnMenu.add(checkMascotasEnRefugio);
				
				scrollJTable = new JScrollPane();
				marcoContenido.add(scrollJTable, BorderLayout.CENTER);
				
						jMascotas = new JTable();
						scrollJTable.setViewportView(jMascotas);
						jMascotas.setShowHorizontalLines(true);
						jMascotas.setShowVerticalLines(true);

		JPanel marcoConfirmaciones = new JPanel();
		getContentPane().add(marcoConfirmaciones, BorderLayout.SOUTH);
		marcoConfirmaciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnVerDetalles = new JButton("Ver Detalles");
		marcoConfirmaciones.add(btnVerDetalles);

	}
}
