package prog3.grafos.utiles;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.*;
import prog3.util.Cola;

public class Cafe<T> {
	public int cafeCercano(Grafo<String> grafo, String esquina, int cantidad) {
		int i = -1;
		int suma = 0;
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		ListaGenerica<Vertice<String>> listaV = new ListaGenericaEnlazada<Vertice<String>>();
		listaV.comenzar();
		while (!listaV.fin()) {
			Vertice<String> v = listaV.proximo();
			if (v.dato().equals(esquina))
				i = v.posicion();
		}
		if (i != -1)
			if ((suma = this.bfs(i, grafo, marca)) > cantidad)
				return suma;
		return 0;
	}

	private int bfs(int i, Grafo<String> grafo, boolean[] marca) {
		marca[i] = true;
		ListaGenerica<Arista<String>> ady = null;
		Cola<Vertice<String>> q = new Cola<Vertice<String>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		q.encolar(null);
		int suma = 0;
		while (!q.esVacia()) {
			Vertice<String> v = q.desencolar();
			if (v != null) {
				ady = grafo.listaDeAdyacentes(v);
				ady.comenzar();
				while (!ady.fin()) {
					Arista<String> arista = ady.proximo();
					int j = arista.verticeDestino().posicion();
					if (!marca[j]) {
						marca[j] = true;
						suma += arista.peso();
					}
				}
			}
		}
		return suma;
	}
}
