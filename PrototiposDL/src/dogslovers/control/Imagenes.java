package dogslovers.control;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import dogslovers.control.excepciones.ImagenNoEncontradaException;

public class Imagenes {
	
	protected static String directorioSistema = System.getProperty("user.dir");
	protected static String rutaFotosMascotas = directorioSistema + "\\src\\dogslovers\\recursos\\imagenes\\mascotas\\";
	protected static String rutaFotosUsuarios = directorioSistema + "\\src\\dogslovers\\recursos\\imagenes\\usuarios\\";
	protected static String rutaFotosSistema  = directorioSistema + "\\src\\dogslovers\\recursos\\imagenes\\sistema\\";
	
	public static BufferedImage cargarImagen(String pRuta) throws ImagenNoEncontradaException{
		// JOptionPane.showMessageDialog(null, pRuta);
		try {
			return ImageIO.read(new File(pRuta));
		} catch (IOException e) {
			throw new ImagenNoEncontradaException(e.getMessage());
		}
	}
	
	public static BufferedImage getEstrellas(Double ponderado) throws ImagenNoEncontradaException{
		String rutaEstrellas = rutaFotosSistema + "estrellas\\";
		
		if (ponderado <= 5.0 && ponderado > 4.5) {
			rutaEstrellas += "5.0";
			
		} else if (ponderado == 4.5) {
			rutaEstrellas += "4.5";
			
		} else if (ponderado >= 4.0 && ponderado < 4.5) {
			rutaEstrellas += "4.0";
			
		} else if (ponderado == 3.5) {
			rutaEstrellas += "3.5";
			
		} else if (ponderado >= 3.0 && ponderado < 3.5) {
			rutaEstrellas += "3.0";
			
		} else if (ponderado == 2.5) {
			rutaEstrellas += "2.5";
			
		} else if (ponderado >= 2.0 && ponderado < 2.5) {
			rutaEstrellas += "2.0";
			
		} else if (ponderado == 1.5) {
			rutaEstrellas += "1.5";
			
		} else if (ponderado >= 1.0 && ponderado < 1.5) {
			rutaEstrellas += "1.0";
			
		} else if (ponderado == 0.5) {
			rutaEstrellas += "0.5";
			
		} else if (ponderado >= 0.0 && ponderado < 0.5) {
			rutaEstrellas += "0.0";
		}
		rutaEstrellas += ".png";
		return cargarImagen(rutaEstrellas);
	}
	
	public static BufferedImage getPerfilMascota(Integer idMascota) throws ImagenNoEncontradaException{
		return cargarImagen(rutaFotosMascotas + idMascota.toString() + ".jpg"); //   + "\\perfil.jpg");
	}
	
	public static BufferedImage getPerfil(String nickUsuario)  throws ImagenNoEncontradaException{
		return cargarImagen(rutaFotosUsuarios + nickUsuario + "\\perfil.jpg");
	}
	
	public static BufferedImage getImagenError() throws ImagenNoEncontradaException {
		return cargarImagen(rutaFotosSistema + "404.jpg");
	}
	
	public static BufferedImage getLogo() throws ImagenNoEncontradaException {
		return cargarImagen(rutaFotosSistema + "paws.png");
	}
	
	public static BufferedImage getIconoSistema() throws ImagenNoEncontradaException {
		return cargarImagen(rutaFotosSistema + "iconoHuella.png");
	}
	
	public static BufferedImage getIconoBusqueda() throws ImagenNoEncontradaException {
		return cargarImagen(rutaFotosSistema + "iconoBuscarMascota.png");
	}
	
	public static void guardarFotoPerfilUsuario(String nickUsuario, Path rutaOrigen){
		Path rutaDestino = Paths.get(rutaFotosUsuarios + nickUsuario + "\\perfil.jpg");
		guardarImagen(rutaOrigen, rutaDestino);
	}
	
	private static void guardarImagen(Path pOrigen, Path pDestino) {
		try {
			FileInputStream flujoArchivoEntrada = new FileInputStream(pOrigen.toString());
			FileOutputStream flujoArchivoSalida = new FileOutputStream(pDestino.toString());
			byte[] buffer = new byte[1024];
			int length;
			while ((length = flujoArchivoEntrada.read(buffer)) > 0) { 
				flujoArchivoSalida.write(buffer, 0, length);
			}
			flujoArchivoEntrada.close();
			flujoArchivoSalida.close();
		} catch (IOException noHayArchivo) {
			JOptionPane.showMessageDialog(null,
				"No se pudo copiar la imagen seleccionada.\n" + noHayArchivo.getMessage(),
				"ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static String seleccionarImagen() {
		// TODO Auto-generated method stub
		return null;
	}
}
