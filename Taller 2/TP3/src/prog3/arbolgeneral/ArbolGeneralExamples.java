package prog3.arbolgeneral;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.Cola;

public class ArbolGeneralExamples<T> {

	public ListaGenerica<T> preorder(ArbolGeneral<T> arbol) {
		ListaGenerica<T> result = new ListaGenericaEnlazada<T>();
		this.preorder_private(arbol, result);
		return result;

	}

	private void preorder_private(ArbolGeneral<T> arbol, ListaGenerica<T> result) {
		if (!arbol.esVacio()) {
			result.agregarFinal(arbol.getDato());

			if (arbol.tieneHijos()) {

				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					ArbolGeneral<T> hijo = hijos.proximo();
					this.preorder_private(hijo, result);
				}

			}
		}

	}

	public ListaGenerica<T> posorder(ArbolGeneral<T> arbol) {
		ListaGenerica<T> result = new ListaGenericaEnlazada<T>();
		this.posorder_private(arbol, result);
		return result;
	}

	private void posorder_private(ArbolGeneral<T> arbol, ListaGenerica<T> result) {

		if (arbol.tieneHijos()) {

			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				ArbolGeneral<T> hijo = hijos.proximo();
				this.posorder_private(hijo, result);
			}

		}
		if (!arbol.esVacio()) {
			result.agregarFinal(arbol.getDato());
		}

	}

	public ListaGenerica<T> porNiveles(ArbolGeneral<T> arbol) {
		ListaGenerica<T> result = new ListaGenericaEnlazada<T>();
		ListaGenerica<ArbolGeneral<T>> cola = new ListaGenericaEnlazada<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol_encolado;

		cola.agregarFinal(arbol);
		cola.agregarFinal(null);

		while (cola.tamanio() > 0) {
			arbol_encolado = cola.elemento(0);
			cola.eliminarEn(0);

			if (arbol_encolado != null) {
				result.agregarFinal(arbol_encolado.getDato());
				if (arbol_encolado.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = arbol_encolado.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.agregarFinal(hijos.proximo());
					}
				}

			} else {
				if (cola.tamanio() > 0)
					cola.agregarFinal(null);
			}

		}

		return result;
	}

	/*
	 * public int altura(ArbolGeneral<T> arbol) { int altura = 0; if
	 * (arbol.tieneHijos()) { ListaGenerica<ArbolGeneral<T>> hijos =
	 * arbol.getHijos(); hijos.comenzar(); while (!hijos.fin()) { altura =
	 * Math.max(altura, this.altura(hijos.proximo())); } } else { return 0; } return
	 * altura + 1;
	 * 
	 * }
	 */
	/*
	 * public int altura(ArbolGeneral<T> arbol) { Cola<ArbolGeneral<T>> cola = new
	 * Cola<ArbolGeneral<T>>(); ListaGenerica<ArbolGeneral<T>> lista = new
	 * ListaGenericaEnlazada<ArbolGeneral<T>>(); int altura = 0;
	 * cola.encolar(arbol); cola.encolar(null); while (!cola.esVacia()) { arbol =
	 * cola.desencolar(); if (arbol != null) { lista = arbol.getHijos();
	 * lista.comenzar(); while (!lista.fin()) cola.encolar(lista.proximo()); } else
	 * { if (arbol == null && !cola.esVacia()) { cola.encolar(null); altura++; } } }
	 * return altura; }
	 */
	public int altura(ArbolGeneral<T> arbol) {
		int max = 0;
		int suma = 0;
		return alturaPRIV(suma, max, arbol);
	}

	private int alturaPRIV(int suma, int max, ArbolGeneral<T> arbol) {
		if (arbol.esHoja()) {
			if (suma > max)
				max=suma;
		} else {
			if (this != null)
				if (arbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						max = this.alturaPRIV(suma + 1, max, hijos.proximo());
					}
				}

		}
		return max;
	}

	public boolean include(ArbolGeneral<T> arbol, T dato) {
		
		if (dato == arbol.getDato())
			return true;
		else
			if (arbol.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> lista = new ListaGenericaEnlazada<ArbolGeneral<T>>();
				lista = arbol.getHijos();
				lista.comenzar();
				while (!lista.fin())
					{if (this.include(lista.proximo(), dato))
						return true;
					
					}
	}
		return false;
}
	public int ancho(ArbolGeneral<T> a)
	{
		ListaGenerica<ArbolGeneral<T>> lista= new ListaGenericaEnlazada<ArbolGeneral<T>>();
		Cola<ArbolGeneral<T>> cola= new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol= new ArbolGeneral<T>(null);
		int max=-1;
		int ancho=0;
		cola.encolar(a);
		cola.encolar(null);
		while (!cola.esVacia())
		{	arbol=cola.desencolar();
		if (arbol!=null)
		{ancho++;
			if (arbol.tieneHijos())
				{lista=arbol.getHijos();
				lista.comenzar();
				while (!lista.fin())
					cola.encolar(lista.proximo());
				}
		}else if(!cola.esVacia())
		{
		cola.encolar(null);	
			if (ancho>max)
				max=ancho;
			ancho=0;
		}
		}
		return max;
		}
	/*		
	public int nivel(ArbolGeneral<T> a,T dato)
	{
	ListaGenerica<ArbolGeneral<T>> lista= new ListaGenericaEnlazada<ArbolGeneral<T>>();
	Cola<ArbolGeneral<T>> cola= new Cola<ArbolGeneral<T>>();
	ArbolGeneral<T> arbol= new ArbolGeneral<T>(null);
	int nivel=0;
	boolean encontre=false;
	cola.encolar(a);
	cola.encolar(null);
	while (!cola.esVacia()&& !encontre)
	{arbol=cola.desencolar();
	if (arbol!=null)
	{
		if (arbol.getDato()==dato)
			encontre=true;
		else if (arbol.tieneHijos())
		{
		lista=arbol.getHijos();
		lista.comenzar();
		while (!lista.fin())
			cola.encolar(lista.proximo());
		}
		
	}else if (!cola.esVacia()) 
			{nivel++;
			 cola.encolar(null);
			}
	}
	if (encontre)
		return nivel;else
			return -1;
	
	}*/
	public int nivel(ArbolGeneral<T> arbol, T dato)
	{
	int nivel_dato=0;
	return (nivel_private(arbol,dato,nivel_dato));
	}
	private int nivel_private(ArbolGeneral<T> arbol, T dato, int nivel_dato)
	{
		if (arbol.getDato()==dato)
			return nivel_dato;
		else 
			if(arbol.tieneHijos())
			{ListaGenerica<ArbolGeneral<T>> lista= new ListaGenericaEnlazada<ArbolGeneral<T>>();
			lista=arbol.getHijos();
			lista.comenzar();
			int u;
			while (!lista.fin())
				if ((u=this.nivel_private(lista.proximo(), dato, nivel_dato+1))>0)
					return u;
			}
		return -1;
	}
	}
	

