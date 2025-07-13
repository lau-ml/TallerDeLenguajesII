package prog3.listaenteros.test;

import prog3.listaenteros.ListaDeEnterosEnlazada;
import prog3.util.*;
/*La implementación de los métodos de lista de enteros enlazada, respecto al agreagar, son bastantes similares en el caso de agregar al final y agregar al principio. 
 Además, se observa que en caso de que la lista esté vacía, las operaciones a realizar son las mismas, es decir, setear la referencia al nodo principio, actual y final.
 La diferencia entre ellas, radica en el direccionamiento que se debe hacer, para poder insertar el nodo según su respectivo método
 La practicidad radica en actualizar los nodos principio, actual y final. Esto permite no tener que recorrer la lista en ninguno de los dos casos.
 En cambio, agregar en, tiene una mayor dificultad. Se debe chequear que sea una posición válida, y se debe recorrer la lista guardando el anterior, para poder engancharlo con el nuevo nodo que apuntará al siguiente que se encontraba en esta posición deseada, en caso de que se encuentre en una posición que no sea el inicio.
 En resumen, la que menos operaciones tendrá que realizar sería agregar al principio en una lista y la segunda dependerá de que tanto tenga que avanzar para poder guardar un elemento, ya que de esto depende el algoritmo agregar en.
 */
public class ListaDeEnterosEnlazadaTestBasico {
	public static void main(String[] args) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		l.agregarInicio(3);
		l.agregarFinal(6);
		l.agregarInicio(4);
		l.agregarInicio(8);
		l.agregarFinal(5);
		l.agregarInicio(99);
		System.out.println(l);
	//l.recursivo(l.);
		l.comenzar();/*Hago que el puntero apunte a la dirección de inicio*/
		l.recursivoBien(l);
		System.out.print(l.ordenar());
		int [] k = new int[10];
		int i;
		int t=10;
		for (i=0;i<10;i++)
			{k[i]=t--;
			}
		UtilitariosLista.mergeSort(k,0,9);
		for (i=0;i<10;i++)
			System.out.print(k[i]);
	}
	


}
