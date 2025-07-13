package ejercicio1;
//Tira error ya que llama al constructor vacío de la clase padre y este no existe al haberse declarado uno distinto
//Una solución posible es agregarle el constructor vacío. Genera la famosa sobrecarga
public class Hijo extends Padre {
	Hijo() {
		System.out.println("Constructor Hijo()");
		}

}
