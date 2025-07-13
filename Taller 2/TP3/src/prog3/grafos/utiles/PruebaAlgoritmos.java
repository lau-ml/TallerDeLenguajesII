package prog3.grafos.utiles;
import prog3.grafos.*;


public class PruebaAlgoritmos<T> {
	public static void main(String[] args) {
	Grafo<String> grafo = new GrafoImplListAdy<String>();
	Vertice<String> vertice1 = new VerticeImplListAdy<String>("Buenos Aires");
	Vertice<String> vertice2 = new VerticeImplListAdy<String>("Barcelona");
	Vertice<String> vertice3 = new VerticeImplListAdy<String>("Madrid");
	Vertice<String> vertice4 = new VerticeImplListAdy<String>("Paris");
	Vertice<String> vertice5 = new VerticeImplListAdy<String>("Rio de Janeiro");
	grafo.agregarVertice(vertice5);
	grafo.agregarVertice(vertice1);
	grafo.agregarVertice(vertice2);
	grafo.agregarVertice(vertice3);
	grafo.agregarVertice(vertice4);
	
	grafo.conectar(vertice1, vertice2);
	grafo.conectar(vertice2, vertice3);
	grafo.conectar(vertice3, vertice4);
	grafo.conectar(vertice4, vertice1);
	grafo.conectar(vertice1, vertice5);
	grafo.conectar(vertice5,vertice2);
	Algoritmos<String> prueba= new Algoritmos<String>();
	System.out.print(prueba.subgrafoCuadrado(grafo));
	System.out.print(prueba.getGrado(grafo));
	System.out.print(prueba.subgrafoCiclo(grafo));
}

}