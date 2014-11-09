package dogslovers.vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.mail.MessagingException;

import dogslovers.control.Correo;
import dogslovers.control.Principal;
import dogslovers.modelo.Usuario;
import dogslovers.recursos.Diseno;



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
		getContentPane().setBackground(Diseno.fondoVentanas);
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
				"LEA LOS SIGUIENTES TERMINOS ANTES DE REGISTRARSE"+"\n"+
				"1.Descripción general del servicio:"+ "\n" +
				"Paws es un sistema de identificación de mascotas a través del cual sus" + "\n"+ 
				"dueños pueden encontrar a su mascota perdida,ayudar a otras a volver"+ "\n"+ 
				 " a casa e interactuar con el resto de usuarios."+ "\n"+ 
				"Este servicio no asegura,ni garantiza que los dueños recuperen a sus mascotas perdidas,"+ "\n"+ 
				"simplemente les provee de una herramienta para lograrlo."  + "\n"+ 
				"2. Registro:" + "\n"+ 
				"Para poder registar una mascota y utilizar ciertas funcionalidades del sistema"+ "\n"+
				"es necesario registrarse."+ "\n"+
				"3.Contenidos facilitados por los usuarios:"+ "\n"+
				"El Usuario podrá registrar a su mascota (o varias) en estado de Perdida, Encontrada o en Adopción "+ "\n"+ 
				"y asociarlas a su perfil facilitando contenido en forma de texto e imágenes.",
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

