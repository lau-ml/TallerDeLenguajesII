package exceptions;

public class ApellidoException extends CamposMalCargadosException{

	private static final long serialVersionUID = 7578117367110309249L;

	public ApellidoException (String apellido) {
		super(apellido);
	}

}
