package prog3.grafos.utiles;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class MACBA<T> {
	
	public ListaGenerica<String> macba(Grafo<Sala> grafo) {
		Vertice<Sala> origen = null;
		int cant = 0;
		int salas=0;
		int[] max = { Integer.MIN_VALUE };
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> mejor = new ListaGenericaEnlazada<String>();
		ListaGenerica<Vertice<Sala>> listaVertices = grafo.listaDeVertices();
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		listaVertices.comenzar();
		while (!listaVertices.fin() && (origen == null)) {
			Vertice<Sala> v = listaVertices.proximo();
			if (v.dato().getNombre().equals("1"))
				origen = v;
		}
		caminoSalas(origen, grafo, marca, cant,salas, max, camino, mejor);
		return mejor;
	}
	
	
	private void caminoSalas(Vertice<Sala> origen, Grafo<Sala> grafo, boolean[] marca, int cant,int salas,
			int[] max, ListaGenerica<String> camino, ListaGenerica<String> mejor) {

		marca[origen.posicion()] = true;
		camino.agregarFinal(origen.dato().getNombre());
		cant+=origen.dato().getMinutos();
		
		ListaGenerica<Arista<Sala>> ady = grafo.listaDeAdyacentes(origen);
		ady.comenzar();
		
		{
			while (!ady.fin()) {
				Arista<Sala> arista = ady.proximo();
				int j = arista.verticeDestino().posicion();
				if (!marca[j]) {
					if(arista.peso()+cant<=120)
						this.caminoSalas(arista.verticeDestino(), grafo, marca,cant+arista.peso(),salas+1, max, camino,
							mejor);
				}
			}
		}
		if (cant<=120 && salas>max[0])
		{
			max[0]=salas;
			copiarMejor(camino,mejor);
		}
		camino.eliminarEn(camino.tamanio() - 1);
		marca[origen.posicion()] = false;
	}
	private void copiarMejor(ListaGenerica<String> camino,ListaGenerica<String> mejor)
	{
		int i = mejor.tamanio();
		for(int j=0;j<i;j++)
			mejor.eliminarEn(0);
		for (int j=0;j<camino.tamanio();j++)
			mejor.agregarFinal(camino.elemento(j));
			
	}
}
