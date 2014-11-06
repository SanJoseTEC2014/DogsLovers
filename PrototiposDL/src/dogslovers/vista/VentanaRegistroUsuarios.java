package dogslovers.vista;

import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import dogslovers.control.Correo;
import dogslovers.control.Principal;
import dogslovers.modelo.Usuario;

import java.awt.HeadlessException;
import java.awt.Window.Type;
import java.awt.ScrollPane;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaRegistroUsuarios extends JFrame {
	private JLabel lblContrasenia;
	private JPasswordField passwordTextBox;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JTextField telefonoTextBox;
	private JTextField correoTextBox;
	private JLabel lblRegistrarse;
	private JButton botonLeerCondicionesUso;
	private JCheckBox aceptarCondicionesUsoCheckBox;
	private JPanel marcoBotones;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblCedula;
	private JLabel lblNickname;
	private JTextField nicknameTextBox;
	private JTextField cedulaTextBox;
	private JTextField apellidosTextBox;
	private JTextField nombreTextBox;
	private JPanel marcoOperaciones;
	private JButton botonRegistrar;
	private JButton botonCancelar;
	private JPanel marcoCampos;
	
	public VentanaRegistroUsuarios() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().setBackground(Principal.fondoVentanas);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Registro de Usuarios");
		setSize(443,476);
		
		lblRegistrarse = new JLabel("Registrarse como Nuevo Usuario");
		lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarse.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		marcoOperaciones = new JPanel();
		marcoOperaciones.setOpaque(false);
		marcoOperaciones.setLayout(new BoxLayout(marcoOperaciones, BoxLayout.Y_AXIS));
		
		botonLeerCondicionesUso = new JButton("Leer Condiciones de Uso");
		botonLeerCondicionesUso.setAlignmentX(Component.CENTER_ALIGNMENT);
		marcoOperaciones.add(botonLeerCondicionesUso);
		
		aceptarCondicionesUsoCheckBox = new JCheckBox("Aceptar Condiciones de Uso");
		aceptarCondicionesUsoCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//TODO validar el correo 
				
				try {
					Correo.enviarCodigoCorreo(nicknameTextBox.getText(), nombreTextBox.getText(), correoTextBox.getText());
					abrirVentanaValidacion("Verificacíon de codigo");

				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

				private void abrirVentanaValidacion(String msg) {
					JFrame frame = new JFrame(msg);
					String codigo = JOptionPane.showInputDialog(frame, "Ingrese el codigo enviado al correo",
							"Verificacíon de codigo", JOptionPane.INFORMATION_MESSAGE);
					
					//if the user presses Cancel, this will be null
					if (codigo != null){
						if (codigo.equals(Integer.toString(nicknameTextBox.getText().hashCode()))) {
							botonRegistrar.setEnabled(true);
						} else {
							abrirVentanaValidacion("Codigo incorreco");
						}
					}
				}
		});
		aceptarCondicionesUsoCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		marcoOperaciones.add(aceptarCondicionesUsoCheckBox);
		aceptarCondicionesUsoCheckBox.setOpaque(false);
		
		marcoBotones = new JPanel();
		marcoBotones.setOpaque(false);
		marcoOperaciones.add(marcoBotones);
		
		botonRegistrar = new JButton("Registrar");
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal.blanca.add(new Usuario(nicknameTextBox.getText(), nombreTextBox.getText(), apellidosTextBox.getText(), Integer.parseInt(cedulaTextBox.getText()), passwordTextBox.getPassword().toString(), Integer.parseInt(telefonoTextBox.getText()), correoTextBox.getText()));
			}
		});
		marcoBotones.add(botonRegistrar);
		botonRegistrar.setEnabled(false);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		marcoBotones.add(botonCancelar);
		botonLeerCondicionesUso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(getContentPane(),
					"Lea los siguientes terminos antes de registrarse"+"\n"+
					"1- Este no es un sistema para dar en adopción una mascota",
					"Condiciones de Uso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(lblRegistrarse, BorderLayout.NORTH);
		
		marcoCampos = new JPanel();
		marcoCampos.setBorder(new TitledBorder(null, "Ingrese sus Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		marcoCampos.setOpaque(false);
		marcoCampos.setLayout(new BoxLayout(marcoCampos, BoxLayout.PAGE_AXIS));
		
		lblNombre = new JLabel("Nombre");
		marcoCampos.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		nombreTextBox = new JTextField();
		nombreTextBox.setColumns(10);
		marcoCampos.add(nombreTextBox);
		nombreTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblApellidos = new JLabel("Apellidos");
		marcoCampos.add(lblApellidos);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		apellidosTextBox = new JTextField();
		marcoCampos.add(apellidosTextBox);
		apellidosTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		apellidosTextBox.setColumns(10);
		
		lblCedula = new JLabel("C\u00E9dula");
		marcoCampos.add(lblCedula);
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		cedulaTextBox = new JTextField();
		marcoCampos.add(cedulaTextBox);
		cedulaTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cedulaTextBox.setColumns(10);
		
		lblNickname = new JLabel("Nickname");
		marcoCampos.add(lblNickname);
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		nicknameTextBox = new JTextField();
		marcoCampos.add(nicknameTextBox);
		nicknameTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nicknameTextBox.setColumns(10);
		
		lblContrasenia = new JLabel("Contrase\u00F1a");
		marcoCampos.add(lblContrasenia);
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		passwordTextBox = new JPasswordField();
		marcoCampos.add(passwordTextBox);
		passwordTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		marcoCampos.add(lblTelefono);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		telefonoTextBox = new JTextField();
		marcoCampos.add(telefonoTextBox);
		telefonoTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		telefonoTextBox.setColumns(10);
		
		lblCorreo = new JLabel("Correo");
		marcoCampos.add(lblCorreo);
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		correoTextBox = new JTextField();
		marcoCampos.add(correoTextBox);
		correoTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		correoTextBox.setColumns(10);
		getContentPane().add(marcoOperaciones, BorderLayout.SOUTH);
		
		getContentPane().add(marcoCampos);
	}
	
}

