package prog3.grafos.utiles;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;

public class PruebaDijkstra {
	public static void main(String[] args) {
		Grafo<String> grafo = new GrafoImplListAdy<String>();
		Vertice<String> vertice1 = new VerticeImplListAdy<String>("Buenos Aires");
		Vertice<String> vertice2 = new VerticeImplListAdy<String>("Barcelona");
		Vertice<String> vertice3 = new VerticeImplListAdy<String>("Madrid");
		Vertice<String> vertice4 = new VerticeImplListAdy<String>("Paris");
		Vertice<String> vertice5 = new VerticeImplListAdy<String>("Rio de Janeiro");
		Vertice<String> vertice6 = new VerticeImplListAdy<String>("Lisboa");
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);
		grafo.agregarVertice(vertice5);
		grafo.agregarVertice(vertice6);

		grafo.conectar(vertice1, vertice6, 5);
		grafo.conectar(vertice1, vertice5, 10);
		grafo.conectar(vertice1, vertice3, 40);

		grafo.conectar(vertice6, vertice5, 10);
		grafo.conectar(vertice6, vertice2, 20);

		grafo.conectar(vertice5, vertice4, 20);

		grafo.conectar(vertice2, vertice4, 5);

		grafo.conectar(vertice4, vertice3, 5);

		grafo.conectar(vertice3, vertice2, 10);
		grafo.conectar(vertice3, vertice5, 5);

		Dijkstra<String> prueba = new Dijkstra<String>();

		Costo[] costo = prueba.dijkstraConHeap(grafo, vertice1);
		for (int i = 0; i < costo.length; i++)
			System.out.println(costo[i].getMin() + " " + costo[i].getAnt());

	}
}
