package dogslovers.vista;

import java.awt.*;
import java.text.*;
import java.util.regex.*;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;

import dogslovers.control.Imagenes;
import dogslovers.control.Principal;
import dogslovers.modelo.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class VentanaDetallesUsuario extends JFrame {
	private JPanel marcoTitulos;
	private JLabel labelTitulo1;
	private JLabel labelTitulo2;
	private JPanel marcoContenido;
	private JPanel marcoFotoPerfil;
	private JLabel labelFoto;
	private JButton btnActualizarFoto;
	private JPanel marcoDetalles;
	private JLabel labelNickname;
	private JLabel labelNombre;
	private JLabel labelApellidos;
	private JLabel labelCedula;
	private JFormattedTextField formatCedula;
	private JLabel labelTelefono;
	private JFormattedTextField formatTelefono;
	private JLabel labelPromedio;
	private JLabel labelEstrellas;
	private JLabel labelLapsos;
	private JComboBox<String> comboLapsos;
	private JPanel marcoOperaciones;
	private JButton botonGuardarCambios;
	private JButton botonDetalles;
	private JButton botonVerMascotas;
	private JButton botonSalir;
	private Usuario usuarioActual;
	private JButton botonCondiciones;
	private JLabel labelCorreo;
	private JTextField textCorreo;
	
	private boolean modoEdicion;
	private JTextField textNombre;
	private JTextField textNickname;
	private JTextField textApellidos;

	public VentanaDetallesUsuario(){
		setSize(730,500);
		setBackground(Principal.fondoVentanas);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		marcoTitulos = new JPanel();
		marcoTitulos.setLayout(new BorderLayout(0, 0));
		getContentPane().add(marcoTitulos, BorderLayout.NORTH);
		
				labelTitulo1 = new JLabel("Informaci�n");
				marcoTitulos.add(labelTitulo1, BorderLayout.NORTH);
				labelTitulo1.setFont(Principal.fuenteTitulosVentanas.deriveFont(40f));
				labelTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
				
				labelTitulo2 = new JLabel("Contacto");
				marcoTitulos.add(labelTitulo2, BorderLayout.SOUTH);
				labelTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
				labelTitulo2.setFont(Principal.fuenteTitulosVentanas.deriveFont(40f));
				
		marcoContenido = new JPanel();
		marcoContenido.setLayout(new BorderLayout(0, 0));
		getContentPane().add(marcoContenido, BorderLayout.CENTER);
				
				marcoFotoPerfil = new JPanel();
				marcoFotoPerfil.setBorder(new TitledBorder(null, "Foto de Perfil", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				marcoFotoPerfil.setLayout(new BoxLayout(marcoFotoPerfil, BoxLayout.Y_AXIS));
				marcoContenido.add(marcoFotoPerfil, BorderLayout.WEST);
				
						labelFoto = new JLabel("No disponible");
						labelFoto.setAlignmentX(Component.CENTER_ALIGNMENT);
						marcoFotoPerfil.add(labelFoto);
						
						btnActualizarFoto = new JButton("Actualizar Foto");
						btnActualizarFoto.setAlignmentX(Component.CENTER_ALIGNMENT);
						marcoFotoPerfil.add(btnActualizarFoto);
				
				marcoDetalles = new JPanel();
				marcoDetalles.setBorder(new TitledBorder(null, "Detalles:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				marcoDetalles.setLayout(new GridLayout(0, 2, 3, 3));
				marcoContenido.add(marcoDetalles, BorderLayout.CENTER);
				
						labelNickname = new JLabel("Nickname: ");
						marcoDetalles.add(labelNickname);
						
						textNickname = new JTextField();
						textNickname.setEditable(false);
						textNickname.setHorizontalAlignment(SwingConstants.CENTER);
						textNickname.setColumns(10);
						marcoDetalles.add(textNickname);
						
						labelNombre = new JLabel("Nombre: ");
						marcoDetalles.add(labelNombre);
						
						textNombre = new JTextField();
						textNombre.setHorizontalAlignment(SwingConstants.CENTER);
						textNombre.setColumns(10);
						marcoDetalles.add(textNombre);
						
						labelApellidos = new JLabel("Apellidos:");
						marcoDetalles.add(labelApellidos);
						
						textApellidos = new JTextField();
						textApellidos.setHorizontalAlignment(SwingConstants.CENTER);
						textApellidos.setColumns(10);
						marcoDetalles.add(textApellidos);
						
						labelCedula = new JLabel("N\u00FAmero de C\u00E9dula: ");
						marcoDetalles.add(labelCedula);
						
						try {
							formatCedula = new JFormattedTextField(new MaskFormatter("#-####-####"));
							formatCedula.setHorizontalAlignment(SwingConstants.CENTER);
							marcoDetalles.add(formatCedula);
						} catch (ParseException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
							marcoDetalles.add(new JLabel("Error inesperado en el sistema."));
						}
						
						labelTelefono = new JLabel("N\u00FAmero de Tel\u00E9fono:");
						marcoDetalles.add(labelTelefono);
						
						try {
							formatTelefono = new JFormattedTextField(new MaskFormatter("####-####"));
							formatTelefono.setHorizontalAlignment(SwingConstants.CENTER);
							marcoDetalles.add(formatTelefono);
						} catch (ParseException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
							marcoDetalles.add(new JLabel("Error inesperado en el sistema."));
						}
						
						labelCorreo = new JLabel("Correo Electr\u00F3nico:");
						marcoDetalles.add(labelCorreo);
						
						textCorreo = new JTextField();
						textCorreo.setHorizontalAlignment(SwingConstants.CENTER);
						marcoDetalles.add(textCorreo);
						
						labelPromedio = new JLabel("Promedio de Calificaciones: ");
						marcoDetalles.add(labelPromedio);
						
						labelEstrellas = new JLabel("");
						labelEstrellas.setHorizontalAlignment(SwingConstants.CENTER);
						marcoDetalles.add(labelEstrellas);
						
						labelLapsos = new JLabel("Peridiocidad de Emparejamientos");
						marcoDetalles.add(labelLapsos);
						
						comboLapsos = new JComboBox<String>();
						// Esto permite que cuando el ComboBox est� desactivado, pueda
						// seguir vi�ndose el texto del lapso del Usuario claramente.
						comboLapsos.setRenderer(new DefaultListCellRenderer(){
						    @Override
						    public Component
						    getListCellRendererComponent(JList list, Object value, int index,
						    							boolean isSelected, boolean cellHasFocus)
						    {
						        JComponent result = (JComponent)super.getListCellRendererComponent
						        					(list, value, index, isSelected, cellHasFocus);
						        result.setOpaque(false);
						        return result;
						    }
						});
						// Aqu� se obtienen los datos directamente del Modelo
						String[] lapsos = (String[]) Usuario.lapsos.toArray();
						comboLapsos.setModel(new DefaultComboBoxModel<String>(lapsos));
						marcoDetalles.add(comboLapsos);
				
		marcoOperaciones = new JPanel();
		marcoOperaciones.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		getContentPane().add(marcoOperaciones, BorderLayout.SOUTH);
				
				botonGuardarCambios = new JButton("Guardar Cambios");
				marcoOperaciones.add(botonGuardarCambios);
				
				botonCondiciones = new JButton("Ver Condiciones de Refugio");
				marcoOperaciones.add(botonCondiciones);
				
				botonDetalles = new JButton("Ver Detalles de Calificaciones");
				marcoOperaciones.add(botonDetalles);
				
				botonVerMascotas = new JButton("Ver Mascotas Asociadas");
				marcoOperaciones.add(botonVerMascotas);
				
				botonSalir = new JButton("Salir");
				botonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						close();
					}
				});
				marcoOperaciones.add(botonSalir);
	}
	
	public void obtenerDatosIniciales(Usuario pUsuario) {
		usuarioActual = pUsuario;
		textNickname.setText(usuarioActual.getNickname());
		textNombre.setText(usuarioActual.getNombre());
		textApellidos.setText(usuarioActual.getApellidos());
		formatCedula.setText(usuarioActual.getCedula().toString());
		formatTelefono.setText(usuarioActual.getTelefono().toString());
		textCorreo.setText(usuarioActual.getCorreo());
		try {
			labelEstrellas.setIcon(new ImageIcon(Imagenes.getEstrellas(usuarioActual.getPonderadoCalificacion())));
		} catch (IOException e) {
			labelEstrellas.setText("Error inesperado al cargar imagen. \n" +
								   "Ponderado: " + usuarioActual.getPonderadoCalificacion());
		}
		comboLapsos.setSelectedIndex(Usuario.lapsos.indexOf(usuarioActual.getLapsoEmparejamiento()));
	}
	
	public void setModoEdicion(boolean pModo){
		modoEdicion = pModo;
		textNombre.setEditable(modoEdicion);
		textApellidos.setEditable(modoEdicion);
		formatCedula.setEditable(modoEdicion);
		formatTelefono.setEditable(modoEdicion);
		textCorreo.setEditable(modoEdicion);
		//comboLapsos.setEditable(modoEdicion);
		comboLapsos.setEnabled(modoEdicion);
	}
	
	private void close(){
		setVisible(false);
	}
}