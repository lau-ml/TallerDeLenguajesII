package prog3.grafos.utiles;

import prog3.grafos.*;
import prog3.listagenerica.ListaGenerica;
import prog3.util.Cola;

public class Algoritmos<T> {
	public boolean subgrafoCuadrado(Grafo<T> grafo) {
		int i = 0;
		int cant = 1;
		int u=0;
		boolean cumpleCuadrado = false;
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		for (i = 0; i < grafo.listaDeVertices().tamanio() && !cumpleCuadrado; i++) {
			if (!marca[i] && !cumpleCuadrado)
				{cumpleCuadrado = dfsCuadrado(i, grafo, grafo.listaDeVertices().elemento(i).posicion(), marca, cant);
				u++;
				}
		}
		System.out.print(u);
		return cumpleCuadrado;
	}

	private boolean dfsCuadrado(int i, Grafo<T> grafo, int pos, boolean[] marca, int cant) {
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		
		ady.comenzar();
		while (!ady.fin()) {
			int j = ady.proximo().verticeDestino().posicion();
			if (cant == 4 && marca[j]) //Debo tener cuidado. La cantidad debe ser igual a 4 aristas, ya que debe ser simple!No perder de vista eso! 
				return true;
			else if (!marca[j]) {
				if (this.dfsCuadrado(j, grafo, pos, marca, cant + 1))
					return true;
			}
		}
		marca[i] = false;
		return false;
	}

	public int getGrado(Grafo<T> grafo) {

		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		int[] gradosVertice = new int[grafo.listaDeVertices().tamanio()];
		int i;
		for (i = 0; i < marca.length; i++) {
			if (!marca[i])
				this.bfs(i, grafo, marca, gradosVertice);
		}
		int max=Integer.MIN_VALUE;
		for (i=0;i<grafo.listaDeVertices().tamanio();i++)
			if (gradosVertice[i]>max)
				max=gradosVertice[i];
		return max;
	}

	private void bfs(int i, Grafo<T> grafo, boolean[] marca, int[] gradosVertice) {
		marca[i] = true;
		ListaGenerica<Arista<T>> ady = null;
		Cola<Vertice<T>> q = new Cola<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		while (!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			// System.out.println(v.dato());
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().posicion();
				gradosVertice[j]++;
				if (!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
					gradosVertice[v.posicion()]++;
			}
		}
	}
	public int [] getGradoEntrada(Grafo<T> grafo) {

		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		int[] gradosVertice = new int[grafo.listaDeVertices().tamanio()];
		int i;
		for (i = 0; i < marca.length; i++) {
			if (!marca[i])
				this.bfs2(i, grafo, marca, gradosVertice);
		}
		//int max=Integer.MIN_VALUE; No necesito obtener el grado del grafo. Solamente los grados de entrada
		//for (i=0;i<grafo.listaDeVertices().tamanio();i++)
			//if (gradosVertice[i]>max)
				//max=gradosVertice[i];
		return gradosVertice;
	}

	private void bfs2(int i, Grafo<T> grafo, boolean[] marca, int[] gradosVertice) {
		marca[i] = true;
		ListaGenerica<Arista<T>> ady = null;
		Cola<Vertice<T>> q = new Cola<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		while (!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			// System.out.println(v.dato());
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().posicion();
				gradosVertice[j]++;//Cuento solamente los grados de entrada!
				if (!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
					//gradosVertice[v.posicion()]++; No cuento la cantidad de grados de salida
			}
		}
	}
	
	public boolean subgrafoCiclo(Grafo<T> grafo) {
		int i = 0;
		int cant = 1;
		boolean cumpleCiclo = false;
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		for (i = 0; i < grafo.listaDeVertices().tamanio() && !cumpleCiclo; i++) {
			if (!marca[i] && !cumpleCiclo)
				cumpleCiclo = dfsCiclo(i, grafo, grafo.listaDeVertices().elemento(i).posicion(), marca, cant);
		}
		return cumpleCiclo;
	}

	private boolean dfsCiclo(int i, Grafo<T> grafo, int pos, boolean[] marca, int cant) {
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		
		ady.comenzar();
		while (!ady.fin()) {
			int j = ady.proximo().verticeDestino().posicion();
			if (cant > 2 && j == pos) //Un grafo tiene un ciclo si la cantidad de aristas del mismo es mayor a 2. Por otro lado j debe ser igual a la posicion que paso como referencia. 
				return true;
			else if (!marca[j]) {
				if (this.dfsCiclo(j, grafo, pos, marca, cant + 1))
					return true;
			}
		}
		marca[i] = false;
		return false;
	}
}
