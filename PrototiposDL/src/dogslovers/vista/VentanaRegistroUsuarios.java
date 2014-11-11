package dogslovers.vista;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.MaskFormatter;
import javax.mail.MessagingException;

import dogslovers.control.Correo;
import dogslovers.control.Principal;
import dogslovers.control.ValidacionesRegistro;
import dogslovers.modelo.Usuario;
import dogslovers.recursos.Diseno;



public class VentanaRegistroUsuarios extends JFrame {
	private JTextField apellidosTextBox;
	private JButton botonCancelar;
	private JButton botonLeerCondicionesUso;
	private JButton botonRegistrar;
	private JButton btnValidarCampos;
	private JFormattedTextField cedulaTextBox;
	private JCheckBox checkBoxAceptarCondicionesUso;
	private JTextField correoTextBox;
	private JTextField direccionTextBox;
	private JLabel lblApellidos;
	private JLabel lblCedula;
	private JLabel lblContrasenia;
	private JLabel lblCorreo;
	private JLabel lblDireccin;
	private JLabel lblNickname;
	private JLabel lblNombre;
	private JLabel lblRegistrarse;
	private JLabel lblTelefono;
	private JPanel marcoBotones;
	private JPanel marcoCampos;
	private JPanel marcoOperaciones;
	private JTextField nicknameTextBox;
	private JTextField nombreTextBox;
	private JPasswordField passwordTextBox;
	private JFormattedTextField telefonoTextBox;
	
	public VentanaRegistroUsuarios() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().setBackground(Diseno.fondoVentanas);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Registro de Usuarios");
		setSize(443,557);
		
		lblRegistrarse = new JLabel("Registrarse como Nuevo Usuario");
		lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarse.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblRegistrarse.setFont(Diseno.fuenteTitulosVentanas.deriveFont(22f));
		
		marcoOperaciones = new JPanel();
		marcoOperaciones.setOpaque(false);
		marcoOperaciones.setLayout(new BoxLayout(marcoOperaciones, BoxLayout.Y_AXIS));
		
		btnValidarCampos = new JButton("Validar campos");
		btnValidarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!correoValido()){}
				if (ValidacionesRegistro.HayCamposVacios(arregloCamposAValidar()) || !correoValido()){
					JOptionPane.showMessageDialog(getContentPane(), "Debe llenar correctamente todos los campos antes de continuar", "Faltan campos",
							JOptionPane.ERROR_MESSAGE);
				}
				else {botonLeerCondicionesUso.setEnabled(true);}
			}
		});
		btnValidarCampos.setAlignmentY(Component.TOP_ALIGNMENT);
		btnValidarCampos.setAlignmentX(Component.CENTER_ALIGNMENT);
		marcoOperaciones.add(btnValidarCampos);
		
		botonLeerCondicionesUso = new JButton("Leer Condiciones de Uso");
		botonLeerCondicionesUso.setEnabled(false);
		botonLeerCondicionesUso.setOpaque(false);
		botonLeerCondicionesUso.setAlignmentX(Component.CENTER_ALIGNMENT);
		marcoOperaciones.add(botonLeerCondicionesUso);
		
		checkBoxAceptarCondicionesUso = new JCheckBox("Aceptar Condiciones de Uso");
		checkBoxAceptarCondicionesUso.setEnabled(false);
		checkBoxAceptarCondicionesUso.addActionListener(new ActionListener() {
			
				
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

				public void actionPerformed(ActionEvent arg0) {
					
					if (checkBoxAceptarCondicionesUso.isSelected()){
						try {
							Correo.enviarCodigoCorreo(nicknameTextBox.getText(), nombreTextBox.getText(), correoTextBox.getText());
							abrirVentanaValidacion("Verificacíon de codigo");
	
						} catch (MessagingException e) {
							JOptionPane.showMessageDialog(getContentPane(),
									e.getMessage(),
									"Correo inválido.",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
		});
		checkBoxAceptarCondicionesUso.setAlignmentX(Component.CENTER_ALIGNMENT);
		marcoOperaciones.add(checkBoxAceptarCondicionesUso);
		checkBoxAceptarCondicionesUso.setOpaque(false);
		
		marcoBotones = new JPanel();
		marcoBotones.setOpaque(false);
		marcoOperaciones.add(marcoBotones);
		
		botonRegistrar = new JButton("Registrar");
		botonRegistrar.setOpaque(false);
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal.blanca.add(
					new Usuario(
						nicknameTextBox.getText(),
						nombreTextBox.getText(),
						apellidosTextBox.getText(),
						Integer.parseInt(cedulaTextBox.getText()),
						new String(passwordTextBox.getPassword()),
						Integer.parseInt(telefonoTextBox.getText()),
						correoTextBox.getText(),
						direccionTextBox.getText()
						)
					);
				JOptionPane.showMessageDialog(getContentPane(), "Su cuenta ha sido registrada satisfactoriamente", "Registro finalizado",
						JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}
		});
		marcoBotones.add(botonRegistrar);
		botonRegistrar.setEnabled(false);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		botonCancelar.setOpaque(false);
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
				checkBoxAceptarCondicionesUso.setEnabled(true);
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
		
		MaskFormatter formatoCedula = null;
		try {
			formatoCedula = new MaskFormatter("#########");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cedulaTextBox = new JFormattedTextField(formatoCedula);
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
		
		MaskFormatter formatoTelefono = null;
		try {
			formatoTelefono = new MaskFormatter("########");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		telefonoTextBox = new JFormattedTextField(formatoTelefono);
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
		
		lblDireccin = new JLabel("Direcci\u00F3n");
		marcoCampos.add(lblDireccin);
		
		direccionTextBox = new JTextField();
		direccionTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		direccionTextBox.setColumns(10);
		marcoCampos.add(direccionTextBox);
	}

	protected String[] arregloCamposAValidar() {
		String[] camposAValidar = {nicknameTextBox.getText(), 
				nombreTextBox.getText(), apellidosTextBox.getText(), 
				cedulaTextBox.getText(), String.valueOf(passwordTextBox.getPassword()), 
				telefonoTextBox.getText(), correoTextBox.getText(), direccionTextBox.getText()};
		return camposAValidar;
	}
	
	protected boolean correoValido() {
		if (!ValidacionesRegistro.validarCorreo(correoTextBox.getText()))
			lblCorreo.setText("Direccion de correo invalida, favor corregir");
		else {lblCorreo.setText("Correo");}
		return ValidacionesRegistro.validarCorreo(correoTextBox.getText());
	}
	
}

