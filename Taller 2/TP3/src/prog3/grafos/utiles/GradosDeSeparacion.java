package prog3.grafos.utiles;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;

import prog3.util.Cola;

public class GradosDeSeparacion<T> {

	public int bfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		boolean puedo = true;
		int mgs = 0;
		int mgv = 0;
		
		
		for (int i = 0; i < grafo.listaDeVertices().tamanio() && puedo; i++) {
			
				mgv = this.bfs(i, grafo, marca);
				if (mgv == 0) 
					{puedo = false;
					mgs = 0;
					}
					if (mgv > mgs)
					mgs = mgv;
			
		}
		return mgs;
	}

	private int bfs(int i, Grafo<T> grafo, boolean[] marca) {
		int k;
		for (k = 0; k < grafo.listaDeVertices().tamanio(); k++)
			marca[k] = false;
		marca[i] = true;
		ListaGenerica<Arista<T>> ady = null;
		Cola<Vertice<T>> q = new Cola<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		q.encolar(null);
		int gradoSeparacion = 0;
		int visitados = 1;
		while (!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			if (v != null) {
				ady = grafo.listaDeAdyacentes(v);
				ady.comenzar();
				while (!ady.fin()) {
					Arista<T> arista = ady.proximo();
					int j = arista.verticeDestino().posicion();
					if (!marca[j]) {
						visitados++;
						Vertice<T> w = arista.verticeDestino();
						marca[j] = true;
						q.encolar(w);
					}
				}
			} else {
				if (!q.esVacia())
				{gradoSeparacion++;
					q.encolar(null);
				}
			}
		}
		if (visitados < grafo.listaDeVertices().tamanio())
			return 0;
		else
		return gradoSeparacion;
	}

	public int dfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		int[] minimoSeparacion = new int[grafo.listaDeVertices().tamanio()];
		boolean puedo = true;
		boolean fin=false;
		int mgs = 0;
		int mgv = 0;
		int j;
		int cant = 0;
		for (int i = 0; i < marca.length  && puedo; i++) {
			
			if (!marca[i] && puedo) {
				for (j = 0; j < grafo.listaDeVertices().tamanio(); j++)
					minimoSeparacion[j] = Integer.MAX_VALUE;
				this.dfs(i, grafo, marca, minimoSeparacion, cant);
				for (j = 0; j < grafo.listaDeVertices().tamanio() && !fin; j++) {
					if (minimoSeparacion[j] == Integer.MAX_VALUE)
						{mgv = 0;
						fin=true;
						}// Muy similar a lo que sucede cuando hacemos el bfs. Lo que tiene de distinto, es que se debe calcular el maximo de ellos al salir de la recursion
						else if (minimoSeparacion[j] > mgv)
						mgv = minimoSeparacion[j];
				}
				if (mgv == 0) {
					puedo = false;
					mgs = 0;
				} else if (mgv > mgs)
					mgs = mgv;
			}
		}
		return mgs;
	}

	private void dfs(int i, Grafo<T> grafo, boolean[] marca, int[] minimoSeparacion, int cant) {
		marca[i] = true;
		if (cant < minimoSeparacion[i])
			minimoSeparacion[i] = cant;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()) {
			int j = ady.proximo().verticeDestino().posicion();
			if (!marca[j]) {
				this.dfs(j, grafo, marca, minimoSeparacion, cant + 1);
			}
		}
		marca[i] = false;
	}
}
