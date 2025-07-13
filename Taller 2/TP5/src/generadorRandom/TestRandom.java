package generadorRandom;

//Se podr�a instanciar como tambi�n se podr�a llamar a los metodos de clase, sin embargo carece de sentido, ya que el m�todo no depende de la instancia. Es un m�todo de clase el cual hace siempre lo mismo.
//Por lo tanto, conviene declararlo como static.
//b) Significa que la clase no puede ser extendida.
//Otra clase que no puede ser heredada es la clase String.
//Para que no se pueda instanciar desde afuera, lo que se hace es declarar al constructor como privado.
public class TestRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++)
			System.out.println(GeneraRandom.generaRandom());
	}

}
