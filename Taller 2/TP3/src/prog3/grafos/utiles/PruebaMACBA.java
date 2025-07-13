package prog3.grafos.utiles;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;

public class PruebaMACBA {
public static void main(String[] args) {
	MACBA<Sala> macba=new MACBA<Sala>();
	Grafo<Sala> grafo= new GrafoImplListAdy<Sala>();
	Vertice<Sala> vertice1 = new VerticeImplListAdy<Sala>(new Sala());
	Vertice<Sala> vertice2 = new VerticeImplListAdy<Sala>(new Sala());
	Vertice<Sala> vertice3 = new VerticeImplListAdy<Sala>(new Sala());
	Vertice<Sala> vertice4 = new VerticeImplListAdy<Sala>(new Sala());
	Vertice<Sala> vertice5 = new VerticeImplListAdy<Sala>(new Sala());
	Vertice<Sala> vertice6 = new VerticeImplListAdy<Sala>(new Sala());
	Vertice<Sala> vertice7 = new VerticeImplListAdy<Sala>(new Sala());
	grafo.agregarVertice(vertice1);
	grafo.agregarVertice(vertice2);
	grafo.agregarVertice(vertice3);
	grafo.agregarVertice(vertice4);
	grafo.agregarVertice(vertice5);
	grafo.agregarVertice(vertice6);
	grafo.agregarVertice(vertice7);
	vertice1.dato().setNombre("1");
	vertice2.dato().setNombre("2");
	vertice3.dato().setNombre("3");
	vertice4.dato().setNombre("4");
	vertice5.dato().setNombre("5");
	vertice6.dato().setNombre("6");
	vertice7.dato().setNombre("7");
	grafo.conectar(vertice1, vertice2,30);
	grafo.conectar(vertice2, vertice1,30);
	
	grafo.conectar(vertice1, vertice3,15);
	grafo.conectar(vertice3, vertice1,15);
	
	grafo.conectar(vertice1, vertice4,10);
	grafo.conectar(vertice4, vertice1,10);
	
	grafo.conectar(vertice2, vertice4,25);
	grafo.conectar(vertice4, vertice2,25);
	
	grafo.conectar(vertice2, vertice5,60);
	grafo.conectar(vertice5, vertice2,60);
	
	grafo.conectar(vertice3, vertice4,40);
	grafo.conectar(vertice4, vertice3,40);
	
	grafo.conectar(vertice3, vertice6,20);		
	grafo.conectar(vertice6, vertice3,20);
	
	grafo.conectar(vertice6, vertice7,30);
	grafo.conectar(vertice7, vertice6,30);
	
	grafo.conectar(vertice5, vertice7,20);
	grafo.conectar(vertice7, vertice5,20);
	
	grafo.conectar(vertice4, vertice7,35);
	grafo.conectar(vertice7, vertice4,35);
	System.out.println(macba.macba(grafo));
}
}
