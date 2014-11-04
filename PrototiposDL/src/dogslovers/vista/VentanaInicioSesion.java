package dogslovers.vista;

import javax.swing.*;

import dogslovers.control.Acceso;
import dogslovers.control.Imagenes;
import dogslovers.control.Principal;
import dogslovers.control.excepciones.ContraseniaIncorrectaException;
import dogslovers.control.excepciones.UsuarioNoExisteException;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


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
		setResizable(false);
		setTitle("Inicio");
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(30, 144, 255));
		setBackground(Principal.fondoVentanas);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		try {
			imagenLogotipo = new ImageIcon(Imagenes.getLogo());
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(getContentPane(), e1.getMessage(),
				"Error inesperado del sistema.", JOptionPane.ERROR_MESSAGE);
		}
		
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
					JOptionPane.showMessageDialog(getContentPane(), passwordTextBox.getPassword());
					Acceso.validarCredenciales(nicknameTextBox.getText(), passwordTextBox.getPassword().toString());
					cerrarVentana();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Error de Acceso", JOptionPane.ERROR_MESSAGE);
					labelUsuarioError.setText(e.getMessage());
				}
			}
		});
		botonInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonInicioSesion.setOpaque(false);
		
		botonRegistrarNuevoUsuario = new JButton("Registrar Nuevo Usuario");
		botonRegistrarNuevoUsuario.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			VentanaRegistroUsuarios window = new VentanaRegistroUsuarios();
			window.setVisible(true);	
			}
		});
		
		marcoBotones.add(botonRegistrarNuevoUsuario);
		botonRegistrarNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonRegistrarNuevoUsuario.setOpaque(false);
	}
	
	private void cerrarVentana() {
		setVisible(false);
	}
	
}