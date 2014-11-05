package dogslovers.control.excepciones;

public class EstadoNoExisteException extends IllegalArgumentException {
	public EstadoNoExisteException(String pString) {
		super(pString);
	}
}