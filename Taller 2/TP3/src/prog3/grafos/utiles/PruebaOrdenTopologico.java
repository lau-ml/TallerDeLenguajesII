package prog3.grafos.utiles;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;
import prog3.listagenerica.*;
public class PruebaOrdenTopologico<T> {
public static void main(String[] args) {
	Grafo<String> grafo = new GrafoImplListAdy<String>();
	Vertice<String> vertice1 = new VerticeImplListAdy<String>("C1");
	Vertice<String> vertice2 = new VerticeImplListAdy<String>("C2");
	Vertice<String> vertice3 = new VerticeImplListAdy<String>("C3");
	Vertice<String> vertice4 = new VerticeImplListAdy<String>("C4");
	Vertice<String> vertice5 = new VerticeImplListAdy<String>("C5");
	grafo.agregarVertice(vertice5);
	grafo.agregarVertice(vertice1);
	grafo.agregarVertice(vertice2);
	grafo.agregarVertice(vertice3);
	grafo.agregarVertice(vertice4);
	
	grafo.conectar(vertice1, vertice3);
	grafo.conectar(vertice2, vertice3);
	grafo.conectar(vertice2, vertice4);
	grafo.conectar(vertice4, vertice5);
	grafo.conectar(vertice3, vertice5);
	//grafo.conectar(vertice5,vertice2);
	OrdenTopologico<String> prueba= new OrdenTopologico<String>();
	ListaGenerica<Vertice<String>> lista=new ListaGenericaEnlazada<Vertice<String>>();
	lista=prueba.ordenTopologicoIterativo(grafo);
	lista.comenzar();
	for (int i=0;i<lista.tamanio();i++)
		System.out.print(lista.elemento(i).dato()+"-");
}
}
