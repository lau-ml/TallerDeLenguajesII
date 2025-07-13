package exceptions;

public class TelefonoException extends CamposMalCargadosException{

	private static final long serialVersionUID = 1L;

	public TelefonoException (String telefono) {
		super(telefono);
	}

}
