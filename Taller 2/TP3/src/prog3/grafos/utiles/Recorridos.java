package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.listagenerica.*;
import prog3.util.*;
public class Recorridos<T> {
		 public ListaGenericaEnlazada<Vertice<T>> dfs(Grafo<T> grafo){
		 boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		 ListaGenericaEnlazada<Vertice<T>> lista= new ListaGenericaEnlazada<Vertice<T>>();
		 lista.comenzar();
		 for (int i=0; i<=grafo.listaDeVertices().tamanio()-1;i++){
		 if (!marca[i])
		 this.dfs(i, grafo, marca,lista);
		 }
		 return lista;
		 }
		private void dfs(int i, Grafo<T> grafo, boolean[] marca,ListaGenericaEnlazada<Vertice<T>> lista){
		 marca[i] = true;
		 Vertice<T> v = grafo.listaDeVertices().elemento(i);
		 //System.out.println(v.dato());
		 lista.agregarFinal(v);
		 ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		 ady.comenzar();
		 while(!ady.fin()){
		 int j = ady.proximo().verticeDestino().posicion();
		 if(!marca[j]){
		 this.dfs(j, grafo, marca,lista);
		 }
		 }
		 }
		
		public ListaGenericaEnlazada<Vertice<T>> bfs(Grafo<T> grafo) {
			 boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
			 ListaGenericaEnlazada<Vertice<T>> lista= new ListaGenericaEnlazada<Vertice<T>>();
			 lista.comenzar();
			 for (int i = 0; i < marca.length; i++) {
			 if (!marca[i])
			 this.bfs(i, grafo, marca,lista);
			 }
			 return lista;
			 }
		private void bfs(int i, Grafo<T> grafo, boolean[] marca,ListaGenericaEnlazada<Vertice<T>> lista)
		{
			marca[i]=true;
			ListaGenerica<Arista<T>> ady=null;
			Cola<Vertice<T>> q = new Cola<Vertice<T>>();
			q.encolar(grafo.listaDeVertices().elemento(i));
			while (!q.esVacia())
			{Vertice<T> v= q.desencolar();
			//System.out.println(v.dato());
			lista.agregarFinal(v);
			ady=grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin())
			{	Arista<T> arista= ady.proximo();
				int j=arista.verticeDestino().posicion();
				if (!marca[j]) {
					Vertice<T> w=arista.verticeDestino();
					marca[j]=true;
					q.encolar(w);
				}
			}
		}
		}
}

