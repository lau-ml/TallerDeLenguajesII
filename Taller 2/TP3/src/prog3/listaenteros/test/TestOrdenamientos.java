package prog3.listaenteros.test;
import prog3.listaenteros.ListaDeEnterosEnlazada;
/*Tener en cuenta la cantidad de veces que se ejecuta. Se ejecuta n veces la busqueda del minimo por una cantidad de n elementos, ya que no se sabe si la misma está ordenada o no. Por otro lado, respecto al agregar, se agrega n veces, aunque el hecho de tener un nodo apuntando al final, resulta que la lista no tenga que recorrerse  cada vez que se pide guardar.*/
/* En el caso del combinarOrdenado se parte de dos listas ordenadas, para finalmente terminar en una. Se recorre n veces la lista lista 1 y m veces la lista dos. Esto se debe a que se van comparando las posiciones respectivas y luego se avanza, en caso de que ambas estén con elementos. En caso de que no, se termina la lista restante. Todo esto se desarrolla hasta que los punteros apunten a null*/
public class TestOrdenamientos {
	public static void main(String[] args) {
		ListaDeEnterosEnlazada lista= new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada lista2= new ListaDeEnterosEnlazada();
		lista.agregarFinal(1);
		lista.agregarFinal(5);
		lista.agregarFinal(8);
		lista.agregarFinal(9);
		lista.agregarFinal(86);
		//System.out.print(lista.ordenar());
		lista2.agregarFinal(2);
		lista2.agregarFinal(3);
		lista2.agregarFinal(4);
		lista2.agregarFinal(96);
		System.out.print(lista.combinarOrdenado2(lista2));
	}
}
