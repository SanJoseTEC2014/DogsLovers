package dogslovers.vista;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import dogslovers.control.Busqueda;
import dogslovers.modelo.Mascota;
import dogslovers.modelo.ModeloTablaMascotas;
import dogslovers.recursos.Diseno;

public class VentanaBusqueda extends JFrame implements Runnable {

	private static final Integer anchoVentana = 500;
	private static final Integer altoVentanaContraida = 380;
	boolean ventanaContraida;

	private JPanel marcoTitulo;
	private JButton btnAyuda;
	private JProgressBar progressBar;
	private JButton btnBuscar;
	private JPanel marcoContenido;
	private JPanel marcoParametros;
	private JPanel marcoCampos;
	private JCheckBox checkNombre;
	private JTextField textNombre;
	private JCheckBox checkLugar;
	private JTextField textLugar;
	private JCheckBox checkNumeroChip;
	private JTextField textNumeroChip;
	private JCheckBox checkEspecie;
	private JComboBox<String> comboEspecies;
	private JCheckBox checkRaza;
	private JComboBox<String> comboRazas;
	private JPanel marcoListas;
	private JCheckBox checkMascotasEncontradas;
	private JCheckBox checkMascotasAdoptadas;
	private JCheckBox checkMascotasEnRefugio;
	private JCheckBox checkMascotasEnAdopcion;
	private JCheckBox checkMascotasPerdidas;
	private boolean[] listasSeleccionadas;
	private JScrollPane marcoResultados;
	private JTable tablaResultados;
	private JButton btnContraerVentana;
	private JPanel marcoOperaciones;
	private JButton btnVerDetalles;
	private JTabbedPane tabbedPane;
	private JPanel pestaniaMascotas;
	private JPanel pestaniaUsuarios;
	Thread hiloBarraProgreso;
	Thread hiloExpandirVentana;
	private ModeloTablaMascotas modelo;
	private JLabel labelTitulo1;

	public VentanaBusqueda() {
		
		Thread hiloBarraProgreso = new Thread(this);
		Thread hiloExpandirVentana = new Thread(this); 
		
		setName("barraCarga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 392);
		getContentPane().setBackground(Diseno.fondoVentanas);
		ventanaContraida = true;
		
		labelTitulo1 = new JLabel("B\u00FAsquedaa");
		getContentPane().add(labelTitulo1, BorderLayout.NORTH);
		labelTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo1.setFont(Diseno.fuenteTitulosVentanas.deriveFont(35f));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		pestaniaMascotas = new JPanel();
		pestaniaMascotas.setOpaque(false);
		pestaniaMascotas.setLayout(new BorderLayout(0, 0));

		marcoTitulo = new JPanel();
		marcoTitulo.setOpaque(false);
		pestaniaMascotas.add(marcoTitulo, BorderLayout.NORTH);
		marcoTitulo.setLayout(new BorderLayout(0, 0));

		progressBar = new JProgressBar();
		marcoTitulo.add(progressBar, BorderLayout.CENTER);
		progressBar.setStringPainted(true);
		progressBar.setString("");
		// Perdidas, Encontradas, Adoptadas, Adoptables, Refugiadas

		btnBuscar = new JButton("Buscar");
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
				if (checkNumeroChip.isSelected()) {
					// TODO Validar que lo que est� escrito en el textChip
					terminos.add(textNumeroChip.getText());
				} else {
					terminos.add("");
				}
				if (checkEspecie.isSelected()) {
					terminos.add((String) comboEspecies.getSelectedItem());
					if (checkRaza.isSelected()) {
						terminos.add((String) comboRazas.getSelectedItem());
					} else {
						terminos.add("");
					}
				} else {
					// Sin especie y sin raza.
					terminos.add("");
					terminos.add("");
				}

				listasSeleccionadas[0] = checkMascotasEncontradas.isSelected();
				listasSeleccionadas[1] = checkMascotasPerdidas.isSelected();
				listasSeleccionadas[2] = checkMascotasAdoptadas.isSelected();
				listasSeleccionadas[3] = checkMascotasEnAdopcion.isSelected();
				listasSeleccionadas[4] = checkMascotasEnRefugio.isSelected();

				if (algunaListaSeleccionada(listasSeleccionadas)) {
					//modelo = new Busqueda(terminos, listasSeleccionadas);

					ModeloTablaMascotas modelo = new ModeloTablaMascotas(Busqueda.buscarMascotas(terminos, listasSeleccionadas));
					tablaResultados.setModel(modelo);
					tablaResultados.setVisible(true);
					progressBar.setMaximum(modelo.getCantidadDeResultados());

					if (ventanaContraida) {
						// Se intenta hacer procesamiento en paralelo...
						//hiloBarraProgreso.start();
						expandirVentana();
						//hiloExpandirVentana.start();
						
					}
				} else {
					progressBar.setString("No se ha seleccionado ninguna lista");
				}
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}

			

			private boolean algunaListaSeleccionada(boolean[] listasSeleccionadas) {
				for (boolean x : listasSeleccionadas) {
					if (x)
						return true;
				}
				return false;
			}

		});
		marcoTitulo.add(btnBuscar, BorderLayout.EAST);

		btnAyuda = new JButton("\u00A1Necesito Ayuda!");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Para realizar una b�squeda, seleccione los campos que \n"
								+ "desee tomar en cuenta. Si un campo no est� seleccionado, \n"
								+ "las mascotas que aparezcan en los resultados de b�squeda \n"
								+ "no estar�n filtradas (exclu�das) por dicho campo. \n\n"
								+ "Para m�s informaci�n, contacte al equipo de desarrollo.", "Ayuda ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		marcoTitulo.add(btnAyuda, BorderLayout.WEST);

		marcoContenido = new JPanel();
		marcoContenido.setOpaque(false);
		pestaniaMascotas.add(marcoContenido, BorderLayout.CENTER);
		marcoContenido.setLayout(new BorderLayout(0, 0));

		marcoParametros = new JPanel();
		marcoParametros.setOpaque(false);
		marcoParametros.setLayout(new BorderLayout(0, 0));
		marcoContenido.add(marcoParametros, BorderLayout.NORTH);

		marcoCampos = new JPanel();
		marcoCampos.setOpaque(false);
		marcoCampos.setBorder(new TitledBorder(null, "Par\u00E1metros de B\u00FAsqueda", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		marcoCampos.setLayout(new GridLayout(6, 2, 0, 0));
		marcoParametros.add(marcoCampos, BorderLayout.CENTER);

		checkNombre = new JCheckBox("Nombre");
		checkNombre.setOpaque(false);
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
		marcoCampos.add(checkNombre);

		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setColumns(10);
		marcoCampos.add(textNombre);

		checkLugar = new JCheckBox("Lugar P\u00E9rdida / Encuentro");
		checkLugar.setOpaque(false);
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
		marcoCampos.add(checkLugar);

		textLugar = new JTextField();
		textLugar.setEnabled(false);
		textLugar.setColumns(10);
		marcoCampos.add(textLugar);

		checkNumeroChip = new JCheckBox("N\u00FAmero de Chip");
		checkNumeroChip.setOpaque(false);
		checkNumeroChip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkNumeroChip.isSelected()) {
					textNumeroChip.setEnabled(true);
				} else {
					textNumeroChip.setText("");
					textNumeroChip.setEnabled(false);
				}
			}
		});
		marcoCampos.add(checkNumeroChip);

		textNumeroChip = new JTextField();
		textNumeroChip.setEnabled(false);
		textNumeroChip.setColumns(10);
		marcoCampos.add(textNumeroChip);

		checkEspecie = new JCheckBox("Especie");
		checkEspecie.setOpaque(false);
		checkEspecie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkEspecie.isSelected()) {
					comboEspecies.setEnabled(true);
					checkRaza.setEnabled(true);
					comboEspecies.setModel(new DefaultComboBoxModel<String>(Mascota.getEspecies()
							.toArray(new String[Mascota.getEspecies().size()])));
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
		marcoCampos.add(checkEspecie);

		comboEspecies = new JComboBox<String>();
		comboEspecies.setEnabled(false);
		marcoCampos.add(comboEspecies);

		checkRaza = new JCheckBox("Raza");
		checkRaza.setOpaque(false);
		checkRaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkRaza.isSelected()) {
					comboRazas.setEnabled(true);
					comboRazas.setModel(new DefaultComboBoxModel<String>( (String[]) Mascota.getRazas().get(comboEspecies
							.getSelectedIndex()).toArray()));
				} else {
					comboRazas.setModel(new DefaultComboBoxModel<String>());
					comboRazas.setEnabled(false);
				}
			}
		});
		checkRaza.setEnabled(false);
		marcoCampos.add(checkRaza);

		comboRazas = new JComboBox<String>();
		comboRazas.setEnabled(false);
		marcoCampos.add(comboRazas);

		marcoListas = new JPanel();
		marcoListas.setOpaque(false);
		marcoListas.setBorder(new TitledBorder(null, "\u00BFD\u00F3nde desea buscar?", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		FlowLayout flowLayout = (FlowLayout) marcoListas.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		marcoParametros.add(marcoListas, BorderLayout.SOUTH);

		checkMascotasPerdidas = new JCheckBox("Perdidas");
		checkMascotasPerdidas.setOpaque(false);
		marcoListas.add(checkMascotasPerdidas);

		checkMascotasEncontradas = new JCheckBox("Encontradas");
		checkMascotasEncontradas.setOpaque(false);
		checkMascotasEncontradas.setSelected(true);
		marcoListas.add(checkMascotasEncontradas);

		checkMascotasAdoptadas = new JCheckBox("Adoptadas");
		checkMascotasAdoptadas.setOpaque(false);
		checkMascotasAdoptadas.setSelected(true);
		marcoListas.add(checkMascotasAdoptadas);

		checkMascotasEnAdopcion = new JCheckBox("En Adopci�n");
		checkMascotasEnAdopcion.setOpaque(false);
		marcoListas.add(checkMascotasEnAdopcion);
		checkMascotasEnAdopcion.setSelected(true);

		checkMascotasEnRefugio = new JCheckBox("Refugiadas");
		checkMascotasEnRefugio.setOpaque(false);
		checkMascotasEnRefugio.setSelected(true);
		marcoListas.add(checkMascotasEnRefugio);

		marcoResultados = new JScrollPane();
		marcoResultados.setOpaque(false);
		marcoContenido.add(marcoResultados, BorderLayout.CENTER);

		tablaResultados = new JTable();
		tablaResultados.setShowHorizontalLines(true);
		tablaResultados.setShowVerticalLines(true);
		marcoResultados.setViewportView(tablaResultados);

		btnContraerVentana = new JButton("Ocultar Resultados");
		btnContraerVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanaContraida) {
					// Contrae la ventana un p�xel a la vez
					for (int i = 0; i < 400; i++) {
						setSize(anchoVentana, getHeight() - 1);
					}
					ventanaContraida = true;
					tablaResultados.setVisible(false);
					progressBar.setValue(0);
					progressBar.setString("");

				}
			}
		});
		btnContraerVentana.setEnabled(false);
		marcoContenido.add(btnContraerVentana, BorderLayout.SOUTH);

		pestaniaUsuarios = new JPanel();
		pestaniaUsuarios.setOpaque(false);
		pestaniaUsuarios.setLayout(new BorderLayout(0, 0));

		marcoOperaciones = new JPanel();
		marcoOperaciones.setOpaque(false);
		getContentPane().add(marcoOperaciones, BorderLayout.SOUTH);
		marcoOperaciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnVerDetalles = new JButton("Ver Detalles");
		marcoOperaciones.add(btnVerDetalles);

		listasSeleccionadas = new boolean[] { false, false, false, false, false };
		
		//TODO Quitar estas dos lineas una vez que quede completada la clase
		tabbedPane.addTab("Usuarios", null, pestaniaUsuarios, null);
		tabbedPane.addTab("Mascotas", null, pestaniaMascotas, null);

	}

	private void actualizarBarraProgreso() {
		for (Integer i = 0; i < modelo.getCantidadDeResultados(); i++) {
			try {
				progressBar.setValue(i);
				Integer mascotas = i + 1;
				progressBar.setString(mascotas.toString().concat(" MascotasEncontradas"));
				java.lang.Thread.sleep(100);

			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public void run() {

		Thread ct = Thread.currentThread();

		while (ct == hiloBarraProgreso) {
			actualizarBarraProgreso();
		}
		
		while (ct == hiloExpandirVentana) {
			expandirVentana();
		
		}
		
	}

	private void expandirVentana() {
		// Expande la ventana
		for (int i = 0; i < 100; i++) {
			// Cada iteraci�n expande la ventana 2 p�xeles hasta
			// un m�ximo de 200 p�xeles estirados
			setSize(anchoVentana, getHeight() + 2);
		}
		btnContraerVentana.setEnabled(true);
		ventanaContraida = false;
	}
	
	
	public void busquedaGeneral(){
		tabbedPane.addTab("Usuarios", null, pestaniaUsuarios, null);
		tabbedPane.addTab("Mascotas", null, pestaniaMascotas, null);
	}
	
	public void busquedaRefugiantes() {
		tabbedPane.addTab("Usuarios", null, pestaniaUsuarios, null);
	}
	
	

}