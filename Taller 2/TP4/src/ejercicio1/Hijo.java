package ejercicio1;
//Tira error ya que llama al constructor vac�o de la clase padre y este no existe al haberse declarado uno distinto
//Una soluci�n posible es agregarle el constructor vac�o. Genera la famosa sobrecarga
public class Hijo extends Padre {
	Hijo() {
		System.out.println("Constructor Hijo()");
		}

}
