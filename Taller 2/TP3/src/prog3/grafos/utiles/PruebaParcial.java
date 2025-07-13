package prog3.grafos.utiles;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;

public class PruebaParcial {
public static void main(String[] args) {
	Parcial parcial=new Parcial();
	Grafo<String> grafo= new GrafoImplListAdy<String>();
	Vertice<String> vertice1 = new VerticeImplListAdy<String>("Corunia");
	Vertice<String> vertice2 = new VerticeImplListAdy<String>("Vigo");
	Vertice<String> vertice3 = new VerticeImplListAdy<String>("Oviedo");
	Vertice<String> vertice4 = new VerticeImplListAdy<String>("Bilbao");
	Vertice<String> vertice5 = new VerticeImplListAdy<String>("Badajoz");
	Vertice<String> vertice6 = new VerticeImplListAdy<String>("Madrid");
	Vertice<String> vertice7 = new VerticeImplListAdy<String>("Barcelona");
	Vertice<String> vertice8 = new VerticeImplListAdy<String>("Zaragoza");
	Vertice<String> vertice9 = new VerticeImplListAdy<String>("Granada");
	grafo.agregarVertice(vertice1);
	grafo.agregarVertice(vertice2);
	grafo.agregarVertice(vertice3);
	grafo.agregarVertice(vertice4);
	grafo.agregarVertice(vertice5);
	grafo.agregarVertice(vertice6);
	grafo.agregarVertice(vertice7);
	grafo.agregarVertice(vertice8);
	grafo.agregarVertice(vertice9);
	
	
	
	grafo.conectar(vertice1, vertice2,171);
	grafo.conectar(vertice2, vertice1,171);
	
	grafo.conectar(vertice1, vertice3,304);
	grafo.conectar(vertice3, vertice1,304);
	
	grafo.conectar(vertice2, vertice4,255);
	grafo.conectar(vertice4, vertice2,255);
	
	grafo.conectar(vertice4, vertice6,193);
	grafo.conectar(vertice6, vertice4,193);
	
	grafo.conectar(vertice6, vertice8,302);
	grafo.conectar(vertice8, vertice6,302);
	
	grafo.conectar(vertice3, vertice4,280);
	grafo.conectar(vertice4, vertice3,280);
	
	grafo.conectar(vertice3, vertice6,311);
	grafo.conectar(vertice6, vertice3,311);
	
	grafo.conectar(vertice4, vertice5,251);
	grafo.conectar(vertice5, vertice4,251);
	
	grafo.conectar(vertice5, vertice9,350);
	grafo.conectar(vertice9, vertice5,350);
	
	grafo.conectar(vertice6, vertice9,321);
	grafo.conectar(vertice9, vertice6,321);
	
	grafo.conectar(vertice6, vertice8,302);
	grafo.conectar(vertice8, vertice6,302);
	
	grafo.conectar(vertice6, vertice7,402);
	grafo.conectar(vertice7, vertice6,402);
	
	System.out.println(parcial.resolver(grafo, "Corunia", "Granada", 193));
}
}
