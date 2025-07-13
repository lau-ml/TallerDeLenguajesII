package exceptions;

import javax.swing.JOptionPane;

public class PaisRepetidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public void getError() {
		JOptionPane.showMessageDialog(null, "No se puede almacenar el pais ya que tiene nombre repetido", "Error",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
