package exceptions;

public class NombreException extends CamposMalCargadosException{

	private static final long serialVersionUID = 7705548562340036592L;

	public NombreException (String nombre) {
		super(nombre);
	}

}
