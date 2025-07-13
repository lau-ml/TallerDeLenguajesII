package prog3.grafos.utiles;

import prog3.listagenerica.*;
import prog3.grafos.*;
public class Delta<T> {
	public int maxIslasDistintas(Grafo<String> grafo) {
		Vertice<String> origen = null;
		int islas = 0;
		ListaGenerica<Vertice<String>> listaVertices = grafo.listaDeVertices();
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		listaVertices.comenzar();
		while (!listaVertices.fin() && (origen == null)) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals("Muelle Principal"))
				origen = v;
		}
		return dfsMaxIslas(origen, grafo, marca, islas);
	}

	private int dfsMaxIslas(Vertice<String> origen, Grafo<String> grafo, boolean[] marca, int islas) {
		int sumaMax = islas;
		int suma = 0;
		marca[origen.posicion()] = true;
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(origen);
		ady.comenzar();
		{
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().posicion();
				if (!marca[j]) {
					suma = this.dfsMaxIslas(arista.verticeDestino(), grafo, marca, islas + 1);
					if (suma > sumaMax)
						sumaMax = suma;
				}
			}
		}
		marca[origen.posicion()] = false;
		return sumaMax;
	}
	public RutaMinima caminoMasCorto(Grafo<String> grafo, String islaO, String islaD)
	{
		Vertice<String> origen = null;
		Vertice<String> destino=null;
		int cant=0;
		RutaMinima rutaMin= new RutaMinima(true);//Envio que por el momento, el camino es posible sin pasar por el muelle entre islas e islas
		ListaGenerica<String> camino= new ListaGenericaEnlazada<String> ();//Camino en el que guardo el camino actual
		int [] min= {Integer.MAX_VALUE};//Camino min; distancias.
		boolean unicoBoleto=true;
		ListaGenerica<Vertice<String>> listaVertices = grafo.listaDeVertices();
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		listaVertices.comenzar();
		while (!listaVertices.fin() && (origen == null || destino==null)) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(islaO))
				origen = v;
			if (v.dato().equals(islaD))
				destino = v;
		}
		dfsCaminoMasCorto(origen, destino,grafo, marca, camino,rutaMin, min,cant,unicoBoleto);
		
		return rutaMin;
	}
	private void dfsCaminoMasCorto(Vertice<String> origen, Vertice<String> destino,Grafo<String> grafo, boolean [] marca, ListaGenerica<String> camino,RutaMinima rutaMin,int [] min,int cant,boolean unicoBoleto)
	{	
		marca[origen.posicion()] = true;
		camino.agregarFinal(origen.dato());
		if (origen.dato().equals("Muelle Principal"))
			unicoBoleto=false;
		if (origen.dato().equals(destino.dato()) && cant<min[0])
		{
			min[0]=cant;
			rutaMin.AgregarLista(camino);
			rutaMin.setUnico(unicoBoleto);
		}
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(origen);
		ady.comenzar();
		{
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().posicion();
				if (!marca[j]) {
					this.dfsCaminoMasCorto(arista.verticeDestino(),destino, grafo, marca,camino,rutaMin,min,cant+arista.peso(),unicoBoleto);
					
				}
			}
		}
		camino.eliminarEn(camino.tamanio()-1);
		marca[origen.posicion()] = false;
}
}