package prog3.grafos.utiles;

import prog3.grafos.*;
import prog3.listagenerica.*;
import prog3.util.*;

public class Dijkstra<T> {
	public Costo[] dijkstraSinHeap(Grafo<T> grafo, Vertice<T> v) {
		Costo[] costo = new Costo[grafo.listaDeVertices().tamanio()];
		boolean[] conocido = new boolean[grafo.listaDeVertices().tamanio()];
		for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
			conocido[i] = false;
			costo[i] = new Costo();
		}
		int menor = Integer.MAX_VALUE;
		ListaGenerica<Vertice<T>> lista = grafo.listaDeVertices();
		lista.comenzar();
		while (!lista.fin()) {
			int i = lista.proximo().posicion();
			costo[i].setMin(Integer.MAX_VALUE);
			costo[i].setAnt(-1);
		}
		costo[v.posicion()].setMin(0);
		lista.comenzar();
		Vertice<T> vertice = null;
		while (!lista.fin()) {// Recorro lista de vertices. Costo V

			for (int i = 0; i < lista.tamanio(); i++)
				if (!conocido[i] && costo[i].getMin() < menor) {
					menor = costo[i].getMin();
					conocido[i] = true;
					vertice = grafo.listaDeVertices().elemento(i);
				} // Recorro la lista de vertices nuevamente. En el peor de los casos, el minimo
					// es el ultimo de la lista de vertices. Por tanto, orden V.
			ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(vertice);
			ady.comenzar();
			while (!ady.fin()) { // Recorro la lista de aristas del vertice. E chica.
				Arista<T> arista = ady.proximo();
				Vertice<T> Vaux = arista.verticeDestino();
				if (!conocido[Vaux.posicion()]) {
					if (costo[Vaux.posicion()].getMin() > costo[vertice.posicion()].getMin() + arista.peso()) {
						{
							costo[Vaux.posicion()].setMin(costo[vertice.posicion()].getMin() + arista.peso());
							costo[Vaux.posicion()].setAnt(vertice.posicion());
						}
					}
				}
			}
			menor = Integer.MAX_VALUE;
			lista.proximo();
		}
		return costo;
	}

	// Por tanto, el coste del algoritmo será de (V^2 + E). En conclusión, el
	// algoritmo se vuelve muy ineficiente a medida que la cantidad de vertices
	// aumenta.
	Costo[] dijkstraConHeap(Grafo<T> grafo, Vertice<T> v) {
		Costo[] costo = new Costo[grafo.listaDeVertices().tamanio()];
		boolean[] conocido = new boolean[grafo.listaDeVertices().tamanio()];
		for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
			conocido[i] = false;
			costo[i] = new Costo();
		}

		ListaGenerica<Vertice<T>> lista = grafo.listaDeVertices();
		lista.comenzar();
		while (!lista.fin()) {
			int i = lista.proximo().posicion();
			costo[i].setMin(Integer.MAX_VALUE);
			costo[i].setAnt(-1);
		}
		costo[v.posicion()].setMin(0);
		Heap<T> heap = new Heap<T>();
		heap.insert(heap, costo[v.posicion()].getMin(), v);
		lista.comenzar();
		Vertice<T> vertice = null;
		while (!lista.fin()) {// Recorro lista de vertices. Costo V
			vertice = heap.delete_min(heap, 0);// Saco el minimo de la heap. Log V. Quedaria V log V
			conocido[vertice.posicion()] = true;
			// Recorro la lista de vertices nuevamente. En el peor de los casos, el minimo
			// es el ultimo de la lista de vertices. Por tanto, orden V.
			ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(vertice);
			ady.comenzar();
			while (!ady.fin()) { // Recorro la lista de aristas del vertice. E chica.

				Arista<T> arista = ady.proximo();
				Vertice<T> Vaux = arista.verticeDestino();
				if (!conocido[Vaux.posicion()]) {

					if (costo[Vaux.posicion()].getMin() > costo[vertice.posicion()].getMin() + arista.peso()) {
						{
							costo[Vaux.posicion()].setMin(costo[vertice.posicion()].getMin() + arista.peso());
							costo[Vaux.posicion()].setAnt(vertice.posicion());
							heap.insert(heap, costo[Vaux.posicion()].getMin(), Vaux);// Inserto en la heap Log v.
																						// Quedaria E log (V)
						}
					}
				}
			}
			lista.proximo();
		}
		return costo;
	} // El resultado del algoritmo seria E log V . Mas eficiente que el V^2 del
		// algoritmo anterior
}
