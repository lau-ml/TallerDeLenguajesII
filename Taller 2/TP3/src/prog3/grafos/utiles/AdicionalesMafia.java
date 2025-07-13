package prog3.grafos.utiles;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.*;

public class AdicionalesMafia {
	public ListaGenerica<String> mafia(Grafo<Sitio> grafo) {
		Vertice<Sitio> origen = null;
		Vertice<Sitio> destino = null;
		int mafias = 0;
		int[] min = { Integer.MAX_VALUE };
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> mejor = new ListaGenericaEnlazada<String>();
		ListaGenerica<Vertice<Sitio>> listaVertices = grafo.listaDeVertices();
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		listaVertices.comenzar();
		while (!listaVertices.fin() && (origen == null)) {
			Vertice<Sitio> v = listaVertices.proximo();
			if (v.dato().getCiudad().equals("Casa del intendente"))
				origen = v;
			if (v.dato().getCiudad().equals("Municipalidad"))
				destino = v;
		}
		mafia(origen, destino, grafo, marca, mafias, min, camino, mejor);
		return mejor;
	}

	private void mafia(Vertice<Sitio> origen, Vertice<Sitio> destino, Grafo<Sitio> grafo, boolean[] marca, int mafias,
			int[] min, ListaGenerica<String> camino, ListaGenerica<String> mejor) {

		marca[origen.posicion()] = true;
		camino.agregarFinal(origen.dato().getCiudad());
		if (origen.dato().isMafia())
			mafias++;
		if (origen.dato().getCiudad().equals(destino.dato().getCiudad()) && mafias<min[0])
				{
					min[0]=mafias;
					copiarMejor(camino,mejor);
				}
		ListaGenerica<Arista<Sitio>> ady = grafo.listaDeAdyacentes(origen);
		ady.comenzar();
		{
			while (!ady.fin()) {
				Arista<Sitio> arista = ady.proximo();
				int j = arista.verticeDestino().posicion();
				if (!marca[j]) {
					if (arista.peso()==0)
						this.mafia(arista.verticeDestino(), destino, grafo, marca, mafias, min, camino,
							mejor);
					else 
						this.mafia(arista.verticeDestino(), destino, grafo, marca, mafias + 1, min, camino,
								mejor);
				}
			}
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
