package dogslovers.control;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import dogslovers.modelo.Mascota;
import dogslovers.modelo.Usuario;

public class Correo {
	// TODO definir si estos datos ser�n obtenidos de alg�n archivo o programados en duro. 

	// Servidor SMTP
	static final String hostServidorCorreo = "smtp.gmail.com";
	// El puerto 587 nos permite utilizar STARTTLS para cifrar la conexi�n.
	static final int puertoComunicacionServidor = 587;
	
	static String emisor = "alejandrinabiblioteca@gmail.com";
	static String nombreUsuarioSMTP = "alejandrinabiblioteca@gmail.com";
	static String passwordSMTP = "casa1234casa";

	private static void enviarCorreo(String pReceptor, String pAsunto, String pCuerpo) throws MessagingException {
		// props contendr� informaci�n de la conexi�n.
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", puertoComunicacionServidor);

		// La sesi�n SMTP inicia en una conexi�n sin cifrar, y luego el cliente
		// emitir� un comando STARTTLS para actualizar a una conexi�n cifrada.
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.starttls.required", true);

		Session session = Session.getDefaultInstance(props);
		MimeMessage msg;
		
		msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(emisor));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(pReceptor));
		msg.setSubject(pAsunto);
		msg.setContent(pCuerpo, "text/plain");

		Transport transport = session.getTransport();
		transport.connect(hostServidorCorreo, nombreUsuarioSMTP, passwordSMTP);

		transport.sendMessage(msg, msg.getAllRecipients());		
		transport.close();
	}
	
	public static void enviarCoincidencias(ArrayList<Mascota> pCoincidencias, Mascota pMascota, Usuario pUsuario) throws MessagingException {
		String asunto = "Su mascota puede haber sido localizada.";
		
		String cuerpoMsg =	"Estimado usuario " + pUsuario.getNombre() + ", \n" +
							"Su mascota " + pMascota.getNombre() + " podr�a haber sido localizada. \n" +
							"Le notificamos que �stas son las mascotas que podr�an coincidir con \n" +
							"la suya, seg�n la descripci�n que ha ingresado en nuestro sistema, \n" + 
							"acorde a los datos disponibles al d�a de hoy: \n\n";
		
		// A continuaci�n se calculan los valores necesarios para darle formato de tabla
		// a los datos de las mascotas en la lista de coincidencias, para formar
		// el cuerpo del mensaje:
		int stringMaxNombre = 0;
		int stringMaxEspecie = 0;
		int stringMaxRaza = 0;
		int stringMaxColor = 0;
		int stringMaxTamanio = 0;
		int stringMaxSexo = 0;
		
		for (int i = 0; i < pCoincidencias.size(); i++){
			if (pCoincidencias.get(i).getNombre().length() > stringMaxNombre){
				stringMaxNombre = pCoincidencias.get(i).getNombre().length();
			}
			if (pCoincidencias.get(i).getEspecie().length() > stringMaxEspecie){
				stringMaxEspecie = pCoincidencias.get(i).getEspecie().length();
			}
			if (pCoincidencias.get(i).getRaza().length() > stringMaxRaza){
				stringMaxRaza = pCoincidencias.get(i).getRaza().length();
			}
			if (pCoincidencias.get(i).getColor().length() > stringMaxColor){
				stringMaxColor = pCoincidencias.get(i).getColor().length();
			}
			if (pCoincidencias.get(i).getTamanio().length() > stringMaxTamanio){
				stringMaxTamanio = pCoincidencias.get(i).getTamanio().length();
			}
			if (pCoincidencias.get(i).getSexo().length() > stringMaxSexo){
				stringMaxSexo = pCoincidencias.get(i).getSexo().length();
			}
		}
		
		// Encabezados de las columnas:
		cuerpoMsg += String.format("%" + stringMaxNombre + "s", "NOMBRE") + " ";
		cuerpoMsg += String.format("%" + stringMaxEspecie + "s", "ESPECIE") + " ";
		cuerpoMsg += String.format("%" + stringMaxRaza + "s", "RAZA") + " ";
		cuerpoMsg += String.format("%" + stringMaxColor + "s", "COLOR") + " ";
		cuerpoMsg += String.format("%" + stringMaxTamanio + "s", "TAMA�O") + " ";
		cuerpoMsg += String.format("%" + stringMaxSexo + "s", "SEXO") + "\n"; // N�tese el salto de l�nea
		
		// Construcci�n de las l�neas de la tabla con los datos de las mascotas:		
		for (int i = 0; i < pCoincidencias.size(); i++){
			cuerpoMsg += String.format("%" + stringMaxNombre + "s", pCoincidencias.get(i).getNombre()) + " ";
			cuerpoMsg += String.format("%" + stringMaxEspecie + "s",pCoincidencias.get(i).getEspecie()) + " ";
			cuerpoMsg += String.format("%" + stringMaxRaza + "s", 	pCoincidencias.get(i).getRaza()) + " ";
			cuerpoMsg += String.format("%" + stringMaxColor + "s", 	pCoincidencias.get(i).getColor()) + " ";
			cuerpoMsg += String.format("%" + stringMaxTamanio + "s",pCoincidencias.get(i).getTamanio()) + " ";
			cuerpoMsg += String.format("%" + stringMaxSexo + "s", 	pCoincidencias.get(i).getSexo()) + "\n";
																						// N�tese el salto de l�nea
		}
		
		cuerpoMsg += "\nPor favor si desea m�s informaci�n sobre alguna de �stas mascotas, \n" +
					 "ingrese a nuestro sistema, y solicite un emparejamiento bajo demanda \n" +
					 "para ponerse en contacto con los usuarios encargados de dichas mascotas.";
		
		cuerpoMsg += "\n\n" + "Atentamente: " + "\n" + "Paws San Jos�";
		enviarCorreo(pUsuario.getCorreo(), asunto, cuerpoMsg);
		
	}

}
