package prog3.grafos.utiles;

import prog3.listagenerica.*;
import prog3.grafos.*;

import prog3.util.*;

public class OrdenTopologico<T> {
	public ListaGenerica<Vertice<T>> ordenTopologicoIterativo(Grafo<T> grafo) {
		boolean[] paso = new boolean[grafo.listaDeVertices().tamanio()];
		Cola<Vertice<T>> colaV = new Cola<Vertice<T>>();
		Algoritmos<T> algoritmo = new Algoritmos<T>();
		ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
		int[] gradosEntrada = algoritmo.getGradoEntrada(grafo);// Tener en cuenta que esto es E+V Por cada vertice
																// recorro sus aristas
		for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++)// Orden V (Encolo los que son de grado 0)
		{
			if (gradosEntrada[i] == 0) {
				colaV.encolar(grafo.listaDeVertices().elemento(i));
				paso[i] = true;
			} else
				paso[i] = false;
		}

		while (!colaV.esVacia()) // Orden V. En teoria, se van a encolar n vertices. Por tanto, encolar y
									// desencolar se va a hacer V veces.
		{
			Vertice<T> vertice = colaV.desencolar();// Constante
			lista.agregarFinal(vertice);
			ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(vertice);
			ady.comenzar();
			while (!ady.fin()) // Orden E chica (aristas de un solo vertice). Al hacer la sumatoria queda que V
								// veces e queda E.
			{
				Arista<T> arista = ady.proximo();
				gradosEntrada[arista.verticeDestino().posicion()]--;
				Vertice<T> aux = arista.verticeDestino();
				if (gradosEntrada[aux.posicion()] == 0 && paso[aux.posicion()] == false) {
					colaV.encolar(aux);
					paso[aux.posicion()] = true;
				}

			}
		}
		return lista;
	}// El orden del algoritmo sera de O(V+E)

}
