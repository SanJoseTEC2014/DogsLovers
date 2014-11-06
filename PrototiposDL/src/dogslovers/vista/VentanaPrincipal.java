package dogslovers.vista;

import dogslovers.control.*;
import dogslovers.control.excepciones.ImagenNoEncontradaException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dogslovers.recursos.jflow.JFlowPanel;
import dogslovers.recursos.jflow.Configuration;
import dogslovers.recursos.jflow.Shape;
import dogslovers.recursos.jflow.shape.Picture;

import java.awt.BorderLayout;

public class VentanaPrincipal extends JFrame {
	
	JFlowPanel prueba;
	Shape[] mascotas;
	
	public VentanaPrincipal() {
		setSize(640, 360);
		
		Configuration configTest = new Configuration();
		configTest.backgroundColor = Principal.fondoVentanas;
		configTest.shadingFactor = 1.0;
		configTest.zoomScale = 4.0;
		configTest.framesPerSecond = 30;
		
		try {
			configTest.shapes = new Picture[]{new Picture(Imagenes.getPerfilMascota(1)),
											  new Picture(Imagenes.getPerfilMascota(2)),
											  new Picture(Imagenes.getPerfilMascota(3)),
											  new Picture(Imagenes.getPerfilMascota(4)),
											  new Picture(Imagenes.getPerfilMascota(5))};
		} catch (ImagenNoEncontradaException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage());
		}
		System.out.println(configTest.toString());
		prueba = new JFlowPanel(configTest);
		getContentPane().add(prueba, BorderLayout.CENTER);
	}
	
}
