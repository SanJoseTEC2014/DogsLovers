package dogslovers.vista;

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

import java.awt.Window.Type;
import java.awt.ScrollPane;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistroUsuarios extends JFrame {
	private JTextField nombreTextBox;
	private JTextField apellidosTextBox;
	private JTextField cedulaTextBox;
	private JTextField nicknameTextBox;
	private JLabel lblContrasenia;
	private JPasswordField passwordTextBox;
	private JLabel lblTelefono;
	private JLabel label_1;
	private JLabel lblCorreo;
	private JTextField telefonoTextBox;
	private JTextField correoTextBox;
	private JLabel lblRegistrarse;
	private JButton botonLeerCondicionesUso;
	private JCheckBox aceptarCondicionesUsoCheckBox;
	
	public VentanaRegistroUsuarios() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Registro de Usuarios");
		setSize(443,616);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		nombreTextBox = new JTextField();
		nombreTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nombreTextBox.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		apellidosTextBox = new JTextField();
		apellidosTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		apellidosTextBox.setColumns(10);
		
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		cedulaTextBox = new JTextField();
		cedulaTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cedulaTextBox.setColumns(10);
		
		JLabel label = new JLabel("");
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		nicknameTextBox = new JTextField();
		nicknameTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nicknameTextBox.setColumns(10);
		
		lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		passwordTextBox = new JPasswordField();
		passwordTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton botonRegistrar = new JButton("Registrar");
		
		JButton botonCancelar = new JButton("Cancelar");
		
		label_1 = new JLabel("");
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		telefonoTextBox = new JTextField();
		telefonoTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		telefonoTextBox.setColumns(10);
		
		correoTextBox = new JTextField();
		correoTextBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		correoTextBox.setColumns(10);
		
		lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		botonLeerCondicionesUso = new JButton("Leer Condiciones de Uso");
		botonLeerCondicionesUso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(getContentPane(),
					"Lea los siguientes terminos antes de registrarse",
					"Condiciones de Uso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		aceptarCondicionesUsoCheckBox = new JCheckBox("Aceptar Condiciones de Uso");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(118)
					.addComponent(label)
					.addGap(35))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(lblRegistrarse)
					.addContainerGap(173, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(81)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addGap(48)
							.addComponent(botonRegistrar)
							.addGap(46)
							.addComponent(botonCancelar)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCorreo)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTelefono)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblContrasenia)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNickname)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCedula)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblApellidos)
									.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNombre)
										.addContainerGap())
									.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(apellidosTextBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
											.addComponent(nombreTextBox, Alignment.LEADING, 272, 272, Short.MAX_VALUE)
											.addComponent(cedulaTextBox, Alignment.LEADING, 272, 272, Short.MAX_VALUE)
											.addComponent(nicknameTextBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
											.addComponent(passwordTextBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
											.addComponent(telefonoTextBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
											.addComponent(correoTextBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
										.addGap(74)))))))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(143)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(aceptarCondicionesUsoCheckBox)
						.addComponent(botonLeerCondicionesUso))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRegistrarse)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNombre)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nombreTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblApellidos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(apellidosTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCedula)
					.addGap(2)
					.addComponent(cedulaTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(lblNickname))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nicknameTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblContrasenia)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(passwordTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTelefono)
					.addGap(10)
					.addComponent(telefonoTextBox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCorreo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(correoTextBox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(botonLeerCondicionesUso)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(aceptarCondicionesUsoCheckBox)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(botonRegistrar)
								.addComponent(botonCancelar))))
					.addGap(66))
		);
		getContentPane().setLayout(groupLayout);
		
	}
}

