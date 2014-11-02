package dogslovers.vista;

import javax.swing.*;

import dogslovers.control.Acceso;
import dogslovers.control.Principal;
import dogslovers.control.excepciones.ContraseniaIncorrectaException;
import dogslovers.control.excepciones.UsuarioNoExisteException;

import java.awt.*;
import java.awt.event.*;

public class VentanaInicioSesion extends JFrame {
	
	// Atributos
	private JTextField nicknameTextBox;
	private JPasswordField passwordTextBox;
	private JLabel labelPasswordError;
	private JLabel labelUsuarioError;
	private JLabel labelNickname;
	private JLabel labelPassword;
	private JPanel marcoDatosIngresados;
	private JButton botonRegistrarNuevoUsuario;
	private JButton botonInicioSesion;
	private JPanel marcoBotones;
	private JLabel labelLogotipo;
	private ImageIcon imagenLogotipo;

	public VentanaInicioSesion() {
		String directorioProyecto = System.getProperty("user.dir");
		setIconImage(Toolkit.getDefaultToolkit().getImage(directorioProyecto + "\\src\\icono.png"));
		try { 					// Establece en la ventana el LOOK AND FEEL del sistema operativo:
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setTitle("Inicio");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(30, 144, 255));
		setBackground(Principal.fondoVentanas);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		imagenLogotipo = new ImageIcon(VentanaInicioSesion.class.getResource("/dogslovers/recursos/paws_logo.png"));
		
		labelLogotipo = new JLabel("");
		labelLogotipo.setIcon(imagenLogotipo);
		labelLogotipo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(labelLogotipo, BorderLayout.NORTH);
		
		marcoDatosIngresados = new JPanel();
		marcoDatosIngresados.setBackground(Principal.fondoVentanas);
		getContentPane().add(marcoDatosIngresados, BorderLayout.CENTER);
		marcoDatosIngresados.setLayout(new BoxLayout(marcoDatosIngresados, BoxLayout.PAGE_AXIS));
		
		labelNickname = new JLabel("Nickname:");
		marcoDatosIngresados.add(labelNickname);
		labelNickname.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		nicknameTextBox = new JTextField();
		nicknameTextBox.setFont(new Font("Calibri", Font.PLAIN, 20));
		marcoDatosIngresados.add(nicknameTextBox);
		
		labelUsuarioError = new JLabel("");
		marcoDatosIngresados.add(labelUsuarioError);
		
		labelPassword = new JLabel("Contrase\u00F1a:");
		marcoDatosIngresados.add(labelPassword);
		labelPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		passwordTextBox = new JPasswordField();
		passwordTextBox.setFont(new Font("Calibri", Font.PLAIN, 20));
		passwordTextBox.setHorizontalAlignment(SwingConstants.LEFT);
		marcoDatosIngresados.add(passwordTextBox);
		
		labelPasswordError = new JLabel("");
		marcoDatosIngresados.add(labelPasswordError);
		
		marcoBotones = new JPanel();
		marcoBotones.setBackground(Principal.fondoVentanas);
		getContentPane().add(marcoBotones, BorderLayout.SOUTH);
		
		botonInicioSesion = new JButton("Iniciar Sesi\u00F3n");
		marcoBotones.add(botonInicioSesion);
		botonInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Acceso.validarCredenciales(nicknameTextBox.getText(), passwordTextBox.getPassword().toString());
					cerrarVentana();
				} catch (UsuarioNoExisteException e) {
					JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Error de Acceso", JOptionPane.ERROR_MESSAGE);
					labelUsuarioError.setText(e.getMessage());
				} catch (ContraseniaIncorrectaException e) {
					JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Error de Acceso", JOptionPane.ERROR_MESSAGE);
					labelPasswordError.setText(e.getMessage());
				}
			}
		});
		botonInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonInicioSesion.setOpaque(false);
		
		botonRegistrarNuevoUsuario = new JButton("Registrar Nuevo Usuario");
		marcoBotones.add(botonRegistrarNuevoUsuario);
		botonRegistrarNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonRegistrarNuevoUsuario.setOpaque(false);
		
		setSize(imagenLogotipo.getIconWidth(), imagenLogotipo.getIconHeight() * 2);
		setResizable(false);
	}
	
	private void cerrarVentana() {
		this.dispose();	
	}
	
}