package dogslovers.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Prueba {

	private JFrame frame;
	private JPanel panelPHP;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Prueba() {
		
		panelPHP = new JPanel();
		panelPHP.setBounds(0, 0, 434, 260);

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHolaAmigos = new JLabel("HOLA AMIGOS :3");
		lblHolaAmigos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHolaAmigos.setBounds(103, panelPHP.getHeight()-120, 196, 50);
		frame.getContentPane().add(lblHolaAmigos);
		
		
		frame.getContentPane().add(panelPHP);
	}
}
