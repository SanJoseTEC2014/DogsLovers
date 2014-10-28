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

public class Imagenes {
	protected static String directorioSistema = System.getProperty("user.dir");
	protected static String rutaFotosMascotas = directorioSistema + "\\src\\dogslovers\\recursos\\imagenes\\mascotas\\";
	protected static String rutaFotosUsuarios = directorioSistema + "\\src\\dogslovers\\recursos\\imagenes\\usuarios\\";
	protected static String rutaFotosSistema  = directorioSistema + "\\src\\dogslovers\\recursos\\imagenes\\sistema\\";
	
	private static BufferedImage cargarImagen(String pRuta) throws IOException{
		return ImageIO.read(new File(pRuta));
	}
	
	public static BufferedImage getPerfil(Integer idMascota) throws IOException{
		return cargarImagen(rutaFotosMascotas + idMascota.toString() + "\\perfil.jpg");
	}
	
	public static BufferedImage getPerfil(String nickUsuario)  throws IOException{
		return cargarImagen(rutaFotosUsuarios + nickUsuario + "\\perfil.jpg");
	}
	
	public static BufferedImage getImagenError() throws IOException {
		return cargarImagen(rutaFotosSistema + "404.jpg");
	}
	
	public static BufferedImage getIcono() throws IOException {
		return cargarImagen(rutaFotosSistema + "icono.jpg");
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
}
