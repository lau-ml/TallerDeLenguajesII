package exceptions;

public abstract class CamposMalCargadosException extends Exception{

	private static final long serialVersionUID = -4439024437793755128L;
	private String campo;

	public CamposMalCargadosException(String campo) {
		this.campo = campo;
	}

	public String getCampo() {
		return campo;
	}
}