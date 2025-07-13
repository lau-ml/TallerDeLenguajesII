package prog3.util;

import prog3.grafos.*;
import prog3.listagenerica.*;

public class Mapa<T> {
	private Grafo<String> mapaCiudad = new GrafoImplListAdy<String>();

	public Mapa() {

		Vertice<String> vertice1 = new VerticeImplListAdy<String>("Buenos Aires");
		Vertice<String> vertice2 = new VerticeImplListAdy<String>("Barcelona");
		Vertice<String> vertice3 = new VerticeImplListAdy<String>("Madrid");
		Vertice<String> vertice4 = new VerticeImplListAdy<String>("Paris");
		Vertice<String> vertice5 = new VerticeImplListAdy<String>("Rio de Janeiro");
		mapaCiudad.agregarVertice(vertice1);
		mapaCiudad.agregarVertice(vertice2);
		mapaCiudad.agregarVertice(vertice3);
		mapaCiudad.agregarVertice(vertice4);
		mapaCiudad.agregarVertice(vertice5);
		mapaCiudad.conectar(vertice1, vertice2);
		mapaCiudad.conectar(vertice2, vertice3);
		mapaCiudad.conectar(vertice2, vertice4);
		mapaCiudad.conectar(vertice2, vertice5);
		mapaCiudad.conectar(vertice4, vertice5);
	}

	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		Vertice<String> origen = null;
		Vertice<String> destino = null;
		ListaGenerica<Vertice<String>> listaVertices = mapaCiudad.listaDeVertices();
		boolean[] marca = new boolean[mapaCiudad.listaDeVertices().tamanio()];
		listaVertices.comenzar();
		while (!listaVertices.fin() && (destino == null || origen == null)) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(ciudad1))
				origen = v;
			if (v.dato().equals(ciudad2))
				destino = v;
		}
		dfsCamino(origen, destino, this.mapaCiudad, marca, camino);
		return camino;
	}

	private boolean dfsCamino(Vertice<String> origen, Vertice<String> destino, Grafo<String> grafo, boolean[] marca,
			ListaGenerica<String> camino) {
		marca[origen.posicion()] = true;
		camino.agregarFinal(origen.dato());
		if (origen.equals(destino))
			return true;
		else {
			Vertice<String> v = grafo.listaDeVertices().elemento(origen.posicion());
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				if (!marca[arista.verticeDestino().posicion()]) {
					if (this.dfsCamino(arista.verticeDestino(), destino, grafo, marca, camino))
						return true;
				}
			}
		}
		camino.eliminarEn(camino.tamanio() - 1);
		return false;
	}

	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
			ListaGenerica<String> ciudades) {
		ListaGenerica<String> caminoExceptuado = new ListaGenericaEnlazada<String>();
		Vertice<String> origen = null;
		Vertice<String> destino = null;
		ListaGenerica<Vertice<String>> listaVertices = mapaCiudad.listaDeVertices();
		boolean[] marca = new boolean[mapaCiudad.listaDeVertices().tamanio()];
		listaVertices.comenzar();
		while (!listaVertices.fin() && (destino == null || origen == null)) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(ciudad1))
				origen = v;
			if (v.dato().equals(ciudad2))
				destino = v;
		}
		if (ciudades != null)
			dfsCaminoExceptuado(origen, destino, this.mapaCiudad, marca, caminoExceptuado, ciudades);
		else
			dfsCamino(origen, destino, this.mapaCiudad, marca, caminoExceptuado);
		return caminoExceptuado;
	}

	public boolean dfsCaminoExceptuado(Vertice<String> origen, Vertice<String> destino, Grafo<String> grafo,
			boolean[] marca, ListaGenerica<String> caminoExceptuado, ListaGenerica<String> ciudades)

	{
		marca[origen.posicion()] = true;
		caminoExceptuado.agregarFinal(origen.dato());
		boolean prohibido = false;
		ciudades.comenzar();
		if (ciudades.incluye(origen.dato()))
				prohibido=true;
		if (!prohibido)
		{if (origen.equals(destino))
			return true;
		else  {
			Vertice<String> v = grafo.listaDeVertices().elemento(origen.posicion());
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				if (!marca[arista.verticeDestino().posicion()]) {
					if (this.dfsCaminoExceptuado(arista.verticeDestino(), destino, grafo, marca, caminoExceptuado,
							ciudades))
						return true;
				}
			}
		}
		}
		caminoExceptuado.eliminarEn(caminoExceptuado.tamanio() - 1);
		return false;
	}

	public ListaGenerica<String> devolverCaminoMasCorto(String ciudad1, String ciudad2) {
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> caminoMin = new ListaGenericaEnlazada<String>();
		Vertice<String> origen = null;
		Vertice<String> destino = null;
		int suma = 0;
		int min[] = { Integer.MAX_VALUE };
		ListaGenerica<Vertice<String>> listaVertices = mapaCiudad.listaDeVertices();
		boolean[] marca = new boolean[mapaCiudad.listaDeVertices().tamanio()];
		listaVertices.comenzar();
		while (!listaVertices.fin() && (destino == null || origen == null)) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(ciudad1))
				origen = v;
			if (v.dato().equals(ciudad2))
				destino = v;
		}
		dfsCaminoMasCorto(origen, destino, this.mapaCiudad, marca, camino, caminoMin, suma, min);
		return caminoMin;
	}

	public void dfsCaminoMasCorto(Vertice<String> origen, Vertice<String> destino, Grafo<String> grafo, boolean[] marca,
			ListaGenerica<String> camino, ListaGenerica<String> caminoMin, int suma, int[] min)

	{
		marca[origen.posicion()] = true;
		camino.agregarFinal(origen.dato());
		if (origen.equals(destino)) {
			if (suma < min[0]) {
				min[0] = suma;
				copiarCamino(caminoMin, camino);
			}
		} else {
			Vertice<String> v = grafo.listaDeVertices().elemento(origen.posicion());
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				if (!marca[arista.verticeDestino().posicion()]) {
					this.dfsCaminoMasCorto(arista.verticeDestino(), destino, this.mapaCiudad, marca, camino, caminoMin,
							suma + arista.peso(), min);
				}
			}
		}
		marca[origen.posicion()] = false;
		camino.eliminarEn(camino.tamanio() - 1);
	}

	public void copiarCamino(ListaGenerica<String> caminoMin, ListaGenerica<String> camino) {
		int i, u;
		u = caminoMin.tamanio();
		for (i = 0; i < u; i++)
			caminoMin.eliminarEn(0);
		for (i = 0; i < camino.tamanio(); i++)
			caminoMin.agregarFinal(camino.elemento(i));
	}

	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		Vertice<String> origen = null;
		Vertice<String> destino = null;
		int suma = 0;
		ListaGenerica<Vertice<String>> listaVertices = mapaCiudad.listaDeVertices();
		boolean[] marca = new boolean[mapaCiudad.listaDeVertices().tamanio()];
		listaVertices.comenzar();
		while (!listaVertices.fin() && (destino == null || origen == null)) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(ciudad1))
				origen = v;
			if (v.dato().equals(ciudad2))
				destino = v;
		}
		dfsCaminoSinCargarCombustible(origen, destino, this.mapaCiudad, marca, camino, suma, tanqueAuto);
		return camino;
	}

	private boolean dfsCaminoSinCargarCombustible(Vertice<String> origen, Vertice<String> destino, Grafo<String> grafo,
			boolean[] marca, ListaGenerica<String> camino, int suma, int tanqueAuto) {
		marca[origen.posicion()] = true;
		camino.agregarFinal(origen.dato());
		if (origen.equals(destino))
			return true;
		else {
			Vertice<String> v = grafo.listaDeVertices().elemento(origen.posicion());
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				if (!marca[arista.verticeDestino().posicion()]) {
					if (tanqueAuto >= suma + arista.peso())
						if (this.dfsCaminoSinCargarCombustible(arista.verticeDestino(), destino, grafo, marca, camino,
								suma + arista.peso(), tanqueAuto))
							return true;
				}
			}
		}
		camino.eliminarEn(camino.tamanio() - 1);
		return false;
	}
	public  ListaGenerica<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int
			tanqueAuto)
	{
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> caminoTanque = new ListaGenericaEnlazada<String>();
		Vertice<String> origen = null;
		Vertice<String> destino = null;
		int suma = 0;
		int min[] = { Integer.MAX_VALUE };
		int maxTanque=tanqueAuto;
		ListaGenerica<Vertice<String>> listaVertices = mapaCiudad.listaDeVertices();
		boolean[] marca = new boolean[mapaCiudad.listaDeVertices().tamanio()];
		listaVertices.comenzar();
		while (!listaVertices.fin() && (destino == null || origen == null)) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(ciudad1))
				origen = v;
			if (v.dato().equals(ciudad2))
				destino = v;
		}
		dfsCaminoConMenorCargaDeCombustible(origen, destino, this.mapaCiudad, marca, camino,caminoTanque, suma,min, tanqueAuto,maxTanque);
		
		return caminoTanque;
	}
	private void dfsCaminoConMenorCargaDeCombustible(Vertice<String> origen, Vertice<String> destino, Grafo<String> grafo, boolean[] marca,
			ListaGenerica<String> camino, ListaGenerica<String> caminoMin, int sumaCargas, int[] min,int tanqueAuto,int maxTanque)

	{
		marca[origen.posicion()] = true;
		camino.agregarFinal(origen.dato());
		if (origen.equals(destino)) {
			if (sumaCargas < min[0]) {
				min[0] = sumaCargas;
				copiarCamino(caminoMin, camino);
			}
		} else {
			Vertice<String> v = grafo.listaDeVertices().elemento(origen.posicion());
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				if (!marca[arista.verticeDestino().posicion()]) {
					if (tanqueAuto>=arista.peso())
						this.dfsCaminoConMenorCargaDeCombustible(arista.verticeDestino(), destino, grafo, marca, camino, caminoMin,
								sumaCargas, min,tanqueAuto-arista.peso(),maxTanque);
					else {
						if (maxTanque>=arista.peso())
							this.dfsCaminoConMenorCargaDeCombustible(arista.verticeDestino(), destino, grafo, marca, camino, caminoMin,
									sumaCargas+1, min,maxTanque-arista.peso(),maxTanque);
					}
						
				}
			}
		}
		marca[origen.posicion()] = false;
		camino.eliminarEn(camino.tamanio() - 1);
	}
}