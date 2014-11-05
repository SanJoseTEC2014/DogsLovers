package dogslovers.modelo;

public interface Comunicable {
	public void enviarMensaje(int pTipoMensaje, Mascota pMascota, String pNickDestino);
	public void recibirMensaje(Mensaje pMensaje);
}
