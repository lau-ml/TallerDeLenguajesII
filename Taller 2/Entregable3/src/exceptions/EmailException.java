package exceptions;

public class EmailException extends CamposMalCargadosException{

	private static final long serialVersionUID = -4867566541849738580L;

	public EmailException (String email) {
		super(email);
	}

}
