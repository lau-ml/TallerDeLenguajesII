package prog3.util;

import prog3.arbolgeneral.*;
import prog3.listagenerica.*;

public class Trie {
	private ArbolGeneral<Character> arbol = new ArbolGeneral<Character>(null);

	public ArbolGeneral<Character> getArbol() {
		return arbol;
	}

	public void agregarPalabra(String palabra) {
		StringBuilder word = new StringBuilder(palabra);
		agregarPalabra_PRIV(word, this.arbol);
	}

	private void agregarPalabra_PRIV(StringBuilder word, ArbolGeneral<Character> arbol) {
		if (word.length() > 0) {
			ListaGenerica<ArbolGeneral<Character>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Character>>();
			hijos = arbol.getHijos();
			hijos.comenzar();
			Character caracter;
			int i = 0;
			boolean cambio = false;
			while (!hijos.fin() && !cambio) {
				caracter = hijos.proximo().getDato();
				if (word.charAt(0) < caracter) {
					ArbolGeneral<Character> arbolAUX = new ArbolGeneral<Character>(word.charAt(0));
					hijos.agregarEn(arbolAUX, i);
					word.deleteCharAt(0);
					cambio = true;
					agregarPalabra_PRIV(word, hijos.elemento(i));
				} else if (word.charAt(0) == caracter) {
					agregarPalabra_PRIV(word.deleteCharAt(0), hijos.elemento(i));
					cambio = true;
				} else
					i++;
			}
			if (!cambio) {
				ArbolGeneral<Character> arbolAUX = new ArbolGeneral<Character>(word.charAt(0));
				hijos.agregarFinal(arbolAUX);
				cambio=true;
				agregarPalabra_PRIV(word.deleteCharAt(0), hijos.elemento(i));
			}
		}
	}
	public ListaGenerica<StringBuilder> palabrasQueEmpiezanCon(String palabra)
	{
	StringBuilder comparacion=new StringBuilder(palabra);
	ListaGenerica<StringBuilder> lista=new ListaGenericaEnlazada<StringBuilder>();
	StringBuilder constructor= new StringBuilder();
	lista.comenzar();
	palabrasQueEmpiezanCon_PRIV(constructor,comparacion,lista, this.arbol);
	return lista;	
	}
	private void palabrasQueEmpiezanCon_PRIV(StringBuilder constructor, StringBuilder comparacion,ListaGenerica<StringBuilder> lista, ArbolGeneral<Character> arbol)
	{
	if (comparacion.length()>0)
	{
		ListaGenerica<ArbolGeneral<Character>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Character>>();
		hijos = arbol.getHijos();
		hijos.comenzar();
		Character caracter;
		int i = 0;
		boolean cambio = false;
		while (!hijos.fin() && !cambio) {
			caracter = hijos.proximo().getDato();
			if (comparacion.charAt(0) == caracter) {
				constructor.append(caracter);
				palabrasQueEmpiezanCon_PRIV(constructor,comparacion.deleteCharAt(0),lista, hijos.elemento(i));
				cambio = true;
			} else if (comparacion.charAt(0)>caracter)
				i++;
	}
	}else if (arbol.esHoja())
		{StringBuilder palabraFin=new StringBuilder(constructor);
		lista.agregarFinal(palabraFin);
		}
		else 
		{ListaGenerica<ArbolGeneral<Character>> hijos=new ListaGenericaEnlazada<ArbolGeneral<Character>>();
			hijos=arbol.getHijos();
			hijos.comenzar();
			int i=0;
			while (!hijos.fin())
			{	constructor.append(hijos.proximo().getDato());
				palabrasQueEmpiezanCon_PRIV(constructor,comparacion,lista,hijos.elemento(i++));
				constructor.deleteCharAt(constructor.length()-1);
			}
		}
		
}
}