package prog3.util;
import prog3.arbolgeneral.*;
import prog3.listagenerica.*;
public class TestTrie {
public static void main(String[] args) {
	Trie triePrueba=new Trie();
	String palabra="hola";
	ListaGenerica<Character> lista=new ListaGenericaEnlazada<Character>();
	
	triePrueba.agregarPalabra(palabra);
	palabra="lola";
	triePrueba.agregarPalabra(palabra);
	palabra="cala";
	triePrueba.agregarPalabra(palabra);
	palabra="coca";
	triePrueba.agregarPalabra(palabra);
	palabra="cacerola";
	triePrueba.agregarPalabra(palabra);
	palabra="carro";
	triePrueba.agregarPalabra(palabra);
	palabra="civilizacion";
	triePrueba.agregarPalabra("casaca");
	triePrueba.agregarPalabra(palabra);
	triePrueba.agregarPalabra("civilizacion");
	ListaGenerica <ArbolGeneral<Character>> hijos=new ListaGenericaEnlazada<ArbolGeneral<Character>>();
	hijos=triePrueba.getArbol().getHijos();
	hijos.comenzar();
	//hijos=hijos.proximo().getHijos();
	//hijos.comenzar();
	//while (!hijos.fin())
	//System.out.print(hijos.proximo().getDato());
	hijos.comenzar();
	hijos=hijos.proximo().getHijos();
	hijos.comenzar();
	//while (!hijos.fin())
		//System.out.print(hijos.proximo().getDato());
	
	lista=triePrueba.getArbol().preorder(triePrueba.getArbol());
	lista.comenzar();
	//while (!lista.fin())
	//	System.out.print(lista.proximo());
	ListaGenerica<StringBuilder> listaPalabras= new ListaGenericaEnlazada<StringBuilder>();
	listaPalabras=triePrueba.palabrasQueEmpiezanCon("c");
	if (listaPalabras.elemento(0)==null)
		System.out.print("No hay palabra cargada con ese prefijo en el trie");
	else
	System.out.print(listaPalabras);
}
}
