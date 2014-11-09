package dogslovers.modelo;

import dogslovers.control.excepciones.UsuarioNoExisteException;

public interface Comunicable {
	public void enviarMensaje(String pTipoMensaje, Mascota pMascota, String pNickDestino) throws UsuarioNoExisteException;
	public void recibirMensaje(Mensaje pMensaje);
}
