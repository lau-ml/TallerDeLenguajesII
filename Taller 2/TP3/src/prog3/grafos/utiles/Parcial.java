package prog3.grafos.utiles;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Parcial {
	public ListaGenerica<String> resolver(Grafo<String> ciudades, String origen, String destino, int rutaObligatoria) {
		Vertice<String> Vorigen = null;
		Vertice<String> Vdestino = null;
		int cant = 0;
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();// Donde voy a guardar el camino
		ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();// Camino que utilizo para recorrer
		int[] max = { Integer.MIN_VALUE };// Camino max. Cantidad de ciudades
		ListaGenerica<Vertice<String>> listaVertices = ciudades.listaDeVertices();
		boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
		listaVertices.comenzar();
		while (!listaVertices.fin() && (Vorigen == null || Vdestino == null)) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(origen))
				Vorigen = v;// Vertice que identifica a la ciudad de comienzo
			if (v.dato().equals(destino))
				Vdestino = v;// Vertice que identifica a la ciudad de final
		}
		boolean rutaOblig = false;// Si pase por la ruta.
		if (Vorigen!=null && Vdestino!=null)
			resolver2(Vorigen, Vdestino, ciudades, marca, camino, max, cant, actual, rutaOblig, rutaObligatoria);
		return camino;
	}

	private void resolver2(Vertice<String> origen, Vertice<String> destino, Grafo<String> grafo, boolean[] marca,
			ListaGenerica<String> camino, int[] max, int cant, ListaGenerica<String> actual, boolean rutaOblig,
			int rutaObligatoria) {
		marca[origen.posicion()] = true;
		actual.agregarFinal(origen.dato());
		if (origen.dato().equals(destino.dato()) && cant > max[0] && rutaOblig)//Pregunto si paso por la ruta, si llegue a destino y si es el camino mas largo
		{
			max[0] = cant;
			copiarRutas(actual, camino);//Copio las rutas.
		}
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(origen);
		ady.comenzar();
		{
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().posicion();
				if (!marca[j]) {
					if (arista.peso() == rutaObligatoria)
						this.resolver2(arista.verticeDestino(), destino, grafo, marca, camino, max, cant + 1, actual,
								true, rutaObligatoria);
					else
						this.resolver2(arista.verticeDestino(), destino, grafo, marca, camino, max, cant + 1, actual,
								rutaOblig, rutaObligatoria);
				}
			}
		}
		actual.eliminarEn(actual.tamanio() - 1);
		marca[origen.posicion()] = false;
	}

	private void copiarRutas(ListaGenerica<String> actual, ListaGenerica<String> camino) {
		int i = camino.tamanio();
		for (int j = 0; j < i; j++)
			camino.eliminarEn(0);
		for (int j = 0; j < actual.tamanio(); j++)
			camino.agregarFinal(actual.elemento(j));

	}
}
