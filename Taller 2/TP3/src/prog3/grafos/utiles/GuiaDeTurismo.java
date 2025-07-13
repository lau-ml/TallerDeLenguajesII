package prog3.grafos.utiles;

import prog3.grafos.*;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class GuiaDeTurismo<T> {
	public ListaGenerica <String> caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen, String
			puntoInteresDestino)
	{
		Vertice<String> origen = null;
		Vertice<String> destino=null;
		int min=Integer.MAX_VALUE;
		ListaGenerica<String> caminoMenor=new ListaGenericaEnlazada<String> ();
		ListaGenerica<String> camino= new ListaGenericaEnlazada<String> ();//Camino en el que guardo el camino actual
		int [] max= {Integer.MIN_VALUE};//Camino min; distancias.
		ListaGenerica<Vertice<String>> listaVertices = grafo.listaDeVertices();
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		listaVertices.comenzar();
		while (!listaVertices.fin() && (origen == null || destino==null)) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(puntoInteresOrigen))
				origen = v;
			if (v.dato().equals(puntoInteresDestino))
				destino = v;
		}
		dfsCaminoConMenorNrodeViajes(origen, destino,grafo, marca, camino,max,min,caminoMenor);
		
		return caminoMenor;
	}
private void dfsCaminoConMenorNrodeViajes(Vertice<String> origen,Vertice<String> destino, Grafo<String> grafo,boolean [] marca, ListaGenerica <String> camino,int [] max, int min,ListaGenerica<String> caminoMenor)
{
	marca[origen.posicion()] = true;
	camino.agregarFinal(origen.dato());
	if (origen.dato().equals(destino.dato()) && min>max[0])
	{
		max[0]=min;
		AgregarLista(camino,caminoMenor);
	}
	ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(origen);
	ady.comenzar();
	{
		while (!ady.fin()) {
			Arista<String> arista = ady.proximo();
			int j = arista.verticeDestino().posicion();
			if (!marca[j]) {
				if (arista.peso()<min)
					this.dfsCaminoConMenorNrodeViajes(arista.verticeDestino(),destino,grafo,marca,camino,max,arista.peso(),caminoMenor);
				else
					this.dfsCaminoConMenorNrodeViajes(arista.verticeDestino(),destino,grafo,marca,camino,max,min,caminoMenor);				
			}
		}
	}
	camino.eliminarEn(camino.tamanio()-1);
	marca[origen.posicion()] = false;
}

private void AgregarLista (ListaGenerica<String> recorrido,ListaGenerica<String> lista)
{
int tamanio=lista.tamanio();
for (int i=0; i<tamanio;i++)
	lista.eliminarEn(0);
for (int i=0;i<recorrido.tamanio();i++)
{
	lista.agregarFinal(recorrido.elemento(i));
}

}
}