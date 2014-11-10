package dogslovers.vista;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.List;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Canvas;

public class VentanaMenuPrincipal extends JFrame {
	public VentanaMenuPrincipal() {
		setSize(700,565);
		
		JButton botonVerMascotasPerdidas = new JButton("Ver mascotas perdidas");
		botonVerMascotasPerdidas.setIcon(new ImageIcon(VentanaMenuPrincipal.class.getResource("/dogslovers/recursos/imagenes/sistema/Huellas.png")));
		
		JButton btnVerMascotasEncontradas = new JButton("Ver mascotas encontradas");
		btnVerMascotasEncontradas.setIcon(new ImageIcon(VentanaMenuPrincipal.class.getResource("/dogslovers/recursos/imagenes/sistema/Huellas.png")));
		
		JButton btnVerMascotasEn = new JButton("Ver mascotas en adopci\u00F3n");
		btnVerMascotasEn.setIcon(new ImageIcon(VentanaMenuPrincipal.class.getResource("/dogslovers/recursos/imagenes/sistema/Huellas.png")));
		
		JButton btnManualDeUsuario = new JButton("Ver Manual de Usuario");
		
		JButton btnContactenos = new JButton("Contactenos");
		
		JButton btnVerPerfil = new JButton("Ver perfil");
		
		JLabel lblBienvenidoAPaws = new JLabel("Bienvenido a Paws!");
		lblBienvenidoAPaws.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VentanaMenuPrincipal.class.getResource("/dogslovers/recursos/imagenes/sistema/iconoMenuPrincipal.png")));
		
		JButton btnIrABsqueda_1 = new JButton("Ir a b\u00FAsqueda de  mascotas");
		btnIrABsqueda_1.setIcon(new ImageIcon(VentanaMenuPrincipal.class.getResource("/dogslovers/recursos/imagenes/sistema/iconoBuscador.png")));
		
		JButton btnIrABsqueda = new JButton("Ir a b\u00FAsqueda de personas");
		btnIrABsqueda.setIcon(new ImageIcon(VentanaMenuPrincipal.class.getResource("/dogslovers/recursos/imagenes/sistema/iconoBuscador.png")));
		
		JButton btnRegistraTuMascota = new JButton("Registra tu mascota");
		btnRegistraTuMascota.setIcon(new ImageIcon(VentanaMenuPrincipal.class.getResource("/dogslovers/recursos/imagenes/sistema/iconoRegistrarmascota.png")));
		
		JButton btnVerDetallesDe = new JButton("Ver detalles de mascotas registradas");
		
		JButton btnAyuda = new JButton("Ayuda");
		
		JButton btnNewButton = new JButton("Ver Asociaciones");
		
		JButton btnConfiguracin = new JButton("Configuraci\u00F3n");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnVerMascotasEncontradas)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(botonVerMascotasPerdidas))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnRegistraTuMascota)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnIrABsqueda_1)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnVerMascotasEn)
								.addComponent(btnIrABsqueda)))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(btnVerPerfil)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnVerDetallesDe)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnManualDeUsuario))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(111)
									.addComponent(lblBienvenidoAPaws)))))
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnConfiguracin)
						.addComponent(btnAyuda)
						.addComponent(btnContactenos))
					.addContainerGap(541, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(lblBienvenidoAPaws)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVerPerfil)
						.addComponent(btnNewButton)
						.addComponent(btnVerDetallesDe)
						.addComponent(btnManualDeUsuario))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVerMascotasEncontradas, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonVerMascotasPerdidas)
						.addComponent(btnVerMascotasEn))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegistraTuMascota, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIrABsqueda_1)
						.addComponent(btnIrABsqueda))
					.addGap(43)
					.addComponent(btnConfiguracin)
					.addGap(18)
					.addComponent(btnContactenos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAyuda)
					.addGap(76))
		);
		getContentPane().setLayout(groupLayout);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

