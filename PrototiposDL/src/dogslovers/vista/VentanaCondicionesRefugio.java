package dogslovers.vista;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FontFormatException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.ResourceBundle.Control;

import javax.swing.JCheckBox;

import dogslovers.control.Acceso;
import dogslovers.control.Principal;
import dogslovers.modelo.Usuario;
import dogslovers.recursos.Diseno;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCondicionesRefugio extends JFrame {
	private JTextField textDetalles;
	private JButton botonGuardarCambios;
	private JCheckBox checkSoloDesparacitada;
	private JCheckBox checkSoloCastrada;
	private JCheckBox checkSoloVacunada;
	private JCheckBox checkNecesitaAlimentos;
	private Usuario usuarioSeleccionado;
	
	public VentanaCondicionesRefugio() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel titulo = new JPanel();
		getContentPane().add(titulo, BorderLayout.NORTH);
		titulo.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblCondicionesDeRefugio = new JLabel("Condiciones de Refugio");
		titulo.add(lblCondicionesDeRefugio);
		lblCondicionesDeRefugio.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblCondicionesDeRefugio.setFont(Diseno.getFuentePaws());
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Los requisitos para refugiar unas mascota son:");
		titulo.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6, 0, 0, 0));
		
		checkNecesitaAlimentos = new JCheckBox("Se debe entregar alimento para la mascota");
		checkNecesitaAlimentos.setEnabled(false);
		panel.add(checkNecesitaAlimentos);
		
		checkSoloVacunada = new JCheckBox("La mascota debe estar vacunada");
		checkSoloVacunada.setEnabled(false);
		panel.add(checkSoloVacunada);
		
		checkSoloCastrada = new JCheckBox("La mascota debe estar Castrada");
		checkSoloCastrada.setEnabled(false);
		panel.add(checkSoloCastrada);
		
		checkSoloDesparacitada = new JCheckBox("La mascota debe estar desparacitada");
		checkSoloDesparacitada.setEnabled(false);
		panel.add(checkSoloDesparacitada);
		
		textDetalles = new JTextField();
		textDetalles.setEditable(false);
		textDetalles.setBorder(new TitledBorder(null, "Detalles Adicionales", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.add(textDetalles);
		textDetalles.setColumns(10);
		
		botonGuardarCambios = new JButton("Guardar cambios");
		botonGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarCambios();
			}
		});
		panel.add(botonGuardarCambios);
	}
	protected void guardarCambios() {
		Acceso.getUsuarioActivo().getCondicionesRefugio().setDetallesAdicionales(textDetalles.getText());
		Acceso.getUsuarioActivo().getCondicionesRefugio().setSoloDesparacitada(checkSoloDesparacitada.isSelected());
		Acceso.getUsuarioActivo().getCondicionesRefugio().setSoloCastrada(checkSoloCastrada.isSelected());
		Acceso.getUsuarioActivo().getCondicionesRefugio().setSoloVacunada(checkSoloVacunada.isSelected());
		Acceso.getUsuarioActivo().getCondicionesRefugio().setNecesitaAlimentos(checkNecesitaAlimentos.isSelected());
		
	}
	public void setDatos(Usuario pUsuarioSeleccionado) {
		
		this.usuarioSeleccionado = pUsuarioSeleccionado;
		
		textDetalles.setText(usuarioSeleccionado.getCondicionesRefugio().getDetallesAdicionales());
		
		botonGuardarCambios.setVisible(usuarioSeleccionado == Acceso.getUsuarioActivo());
		botonGuardarCambios.setSelected(usuarioSeleccionado == Acceso.getUsuarioActivo());

		checkSoloDesparacitada.setVisible(usuarioSeleccionado.getCondicionesRefugio().isSoloDesparacitada());
		checkSoloDesparacitada.setSelected(usuarioSeleccionado.getCondicionesRefugio().isSoloDesparacitada());

		checkSoloCastrada.setVisible(usuarioSeleccionado.getCondicionesRefugio().isSoloDesparacitada());
		checkSoloCastrada.setSelected(usuarioSeleccionado.getCondicionesRefugio().isSoloDesparacitada());

		checkSoloVacunada.setVisible(usuarioSeleccionado.getCondicionesRefugio().isSoloVacunada());
		checkSoloVacunada.setSelected(usuarioSeleccionado.getCondicionesRefugio().isSoloVacunada());

		checkNecesitaAlimentos.setVisible(usuarioSeleccionado.getCondicionesRefugio().isNecesitaAlimentos());
		checkNecesitaAlimentos.setSelected(usuarioSeleccionado.getCondicionesRefugio().isNecesitaAlimentos());
		
		if (pUsuarioSeleccionado == Acceso.getUsuarioActivo()) ventanaModoEdicion();


	}
	
	private void ventanaModoEdicion() {
		
		textDetalles.setEditable(true);
		
		checkSoloDesparacitada.setEnabled(true);
		checkSoloDesparacitada.setVisible(true);

		checkSoloCastrada.setEnabled(true);
		checkSoloCastrada.setVisible(true);

		checkSoloVacunada.setEnabled(true);
		checkSoloVacunada.setVisible(true);

		checkNecesitaAlimentos.setEnabled(true);
		checkNecesitaAlimentos.setVisible(true);

	}
	

}
