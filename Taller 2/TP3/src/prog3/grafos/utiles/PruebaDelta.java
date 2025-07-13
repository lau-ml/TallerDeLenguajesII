package prog3.grafos.utiles;
import prog3.grafos.*;
public class PruebaDelta {
public static void main(String[] args) {
	
Delta<String> delta=new Delta<String>();
Grafo<String> grafo= new GrafoImplListAdy<String>();
Vertice<String> vertice1 = new VerticeImplListAdy<String>("Muelle Principal");
Vertice<String> vertice2 = new VerticeImplListAdy<String>("Barcelona");
Vertice<String> vertice3 = new VerticeImplListAdy<String>("Madrid");
Vertice<String> vertice4 = new VerticeImplListAdy<String>("Paris");
Vertice<String> vertice5 = new VerticeImplListAdy<String>("Rio de Janeiro");
Vertice<String> vertice6 = new VerticeImplListAdy<String>("Balcarce");
Vertice<String> vertice7 = new VerticeImplListAdy<String>("Lanus");
grafo.agregarVertice(vertice1);
grafo.agregarVertice(vertice2);
grafo.agregarVertice(vertice3);
grafo.agregarVertice(vertice4);
grafo.agregarVertice(vertice5);
grafo.agregarVertice(vertice6);
grafo.agregarVertice(vertice7);
grafo.conectar(vertice1, vertice2);
grafo.conectar(vertice2, vertice3);
grafo.conectar(vertice2, vertice4);
grafo.conectar(vertice2, vertice5,40);
grafo.conectar(vertice4, vertice5);
grafo.conectar(vertice5, vertice6);
grafo.conectar(vertice1, vertice7);
grafo.conectar(vertice7, vertice2);
grafo.conectar(vertice6,vertice1);
grafo.conectar(vertice6,vertice3,10);
grafo.conectar(vertice3, vertice2);
System.out.println(delta.maxIslasDistintas(grafo));
RutaMinima rutaMin =(delta.caminoMasCorto(grafo, "Balcarce","Madrid"));
System.out.println(rutaMin.getLista());
System.out.print("Pudo hacerse con un boleto? ");
System.out.print(rutaMin.isUnico());
}
}