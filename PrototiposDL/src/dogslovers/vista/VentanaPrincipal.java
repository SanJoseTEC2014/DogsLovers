package dogslovers.vista;

import dogslovers.control.*;
import dogslovers.control.excepciones.ImagenNoEncontradaException;

import javax.swing.JFrame;
import dogslovers.recursos.jflow.JFlowPanel;
import dogslovers.recursos.jflow.Configuration;
import dogslovers.recursos.jflow.Shape;
import dogslovers.recursos.jflow.shape.Picture;

import java.awt.BorderLayout;
import java.util.LinkedList;

public class VentanaPrincipal extends JFrame {
	
	JFlowPanel prueba;
	
	public VentanaPrincipal() {
		setSize(640, 360);
		
		Configuration configTest = new Configuration();
		configTest.shapeWidth = 0.8;
		configTest.scrollFactor = 5.0;
		configTest.framesPerSecond = 30;
		
		configTest.shapes = new LinkedList<Shape>();
		// Después de muchas pruebas unitarias,
		// el máximo de imágenes que la matriz sostiene son 10.
		for (int img = 1; img < 10; img++){ 
			try {
				configTest.shapes.add(new Picture(Imagenes.getPerfilMascota(img)));
			} catch (ImagenNoEncontradaException e) {
				break;
			}
		}
		
		prueba = new JFlowPanel(configTest);
		getContentPane().add(prueba, BorderLayout.CENTER);
	}
}
