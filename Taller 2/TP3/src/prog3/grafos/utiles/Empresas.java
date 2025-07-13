package prog3.grafos.utiles;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.util.Cola;

public class Empresas<T> {
	public MayoresEmpresas[] bfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		MayoresEmpresas[] mayores=new MayoresEmpresas[5];
		int cantidad;
		for (int j=0; j<5;j++)
			{mayores[j]=new MayoresEmpresas();
			mayores[j].setCantidadEmp(0);
			mayores[j].setNroEmp(0);
			}
		
		for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
			
				cantidad=this.bfs(i, grafo, marca);
				int j = 0;
				while (j<5 && cantidad<=mayores[j].getCantidadEmp())
					j++;
				if (j!=5)
					{for(int k=4;k>j;k--)
						{mayores[k].setCantidadEmp(mayores[k-1].getCantidadEmp());
						mayores[k].setNroEmp(mayores[k-1].getNroEmp());
						}
					mayores[j].setCantidadEmp(cantidad);
					mayores[j].setNroEmp(i);
					}
						}
		return mayores;
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
		
		int visitados = 0;
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
				{
					q.encolar(null);
				
				}
			}
		}
		
		return visitados;
	}
}
