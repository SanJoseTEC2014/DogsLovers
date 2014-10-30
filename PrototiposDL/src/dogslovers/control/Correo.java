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
	// TODO definir si estos datos serán obtenidos de algún archivo o programados en duro. 

	// Servidor SMTP
	static final String hostServidorCorreo = "smtp.gmail.com";
	// El puerto 587 nos permite utilizar STARTTLS para cifrar la conexión.
	static final int puertoComunicacionServidor = 587;
	
	static String emisor = "alejandrinabiblioteca@gmail.com";
	static String nombreUsuarioSMTP = "alejandrinabiblioteca@gmail.com";
	static String passwordSMTP = "casa1234casa";

	private static void enviarCorreo(String pReceptor, String pAsunto, String pCuerpo) throws MessagingException {
		// props contendrá información de la conexión.
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", puertoComunicacionServidor);

		// La sesión SMTP inicia en una conexión sin cifrar, y luego el cliente
		// emitirá un comando STARTTLS para actualizar a una conexión cifrada.
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
							"Su mascota " + pMascota.getNombre() + " podría haber sido localizada. \n" +
							"Le notificamos que éstas son las mascotas que podrían coincidir con \n" +
							"la suya, según la descripción que ha ingresado en nuestro sistema, \n" + 
							"acorde a los datos disponibles al día de hoy: \n\n";
		
		// A continuación se calculan los valores necesarios para darle formato de tabla
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
		cuerpoMsg += String.format("%" + stringMaxTamanio + "s", "TAMAÑO") + " ";
		cuerpoMsg += String.format("%" + stringMaxSexo + "s", "SEXO") + "\n"; // Nótese el salto de línea
		
		// Construcción de las líneas de la tabla con los datos de las mascotas:		
		for (int i = 0; i < pCoincidencias.size(); i++){
			cuerpoMsg += String.format("%" + stringMaxNombre + "s", pCoincidencias.get(i).getNombre()) + " ";
			cuerpoMsg += String.format("%" + stringMaxEspecie + "s",pCoincidencias.get(i).getEspecie()) + " ";
			cuerpoMsg += String.format("%" + stringMaxRaza + "s", 	pCoincidencias.get(i).getRaza()) + " ";
			cuerpoMsg += String.format("%" + stringMaxColor + "s", 	pCoincidencias.get(i).getColor()) + " ";
			cuerpoMsg += String.format("%" + stringMaxTamanio + "s",pCoincidencias.get(i).getTamanio()) + " ";
			cuerpoMsg += String.format("%" + stringMaxSexo + "s", 	pCoincidencias.get(i).getSexo()) + "\n";
																						// Nótese el salto de línea
		}
		
		cuerpoMsg += "\nPor favor si desea más información sobre alguna de éstas mascotas, \n" +
					 "ingrese a nuestro sistema, y solicite un emparejamiento bajo demanda \n" +
					 "para ponerse en contacto con los usuarios encargados de dichas mascotas.";
		
		cuerpoMsg += "\n\n" + "Atentamente: " + "\n" + "Paws San José";
		enviarCorreo(pUsuario.getCorreo(), asunto, cuerpoMsg);
		
	}

}
