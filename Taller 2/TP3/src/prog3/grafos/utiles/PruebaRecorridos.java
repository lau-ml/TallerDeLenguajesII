package prog3.grafos.utiles;


import prog3.grafos.*;

public class PruebaRecorridos {
public static void main(String[] args) {
	VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
	VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(2);
	VerticeImplListAdy<Integer> vert3 = new VerticeImplListAdy<Integer>(3);
	VerticeImplListAdy<Integer> vert4 = new VerticeImplListAdy<Integer>(4);
	Grafo<Integer> grafo = new GrafoImplListAdy<Integer>();
	grafo.agregarVertice(vert1);
	grafo.agregarVertice(vert2);
	grafo.agregarVertice(vert3);
	grafo.agregarVertice(vert4);
	grafo.conectar(vert1, vert2);
	grafo.conectar(vert1, vert3);
	grafo.conectar(vert2, vert1);
	grafo.conectar(vert4,vert2);
	grafo.conectar(vert2,vert4);
	grafo.conectar(vert2, vert3);
	grafo.conectar(vert3,vert2);
	grafo.conectar(vert3, vert1);
	Recorridos<Integer> recorrer=new Recorridos<Integer>();
	System.out.println(recorrer.bfs(grafo));
	System.out.println(recorrer.dfs(grafo));
}
}
