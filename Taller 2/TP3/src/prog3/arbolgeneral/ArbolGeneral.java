package prog3.arbolgeneral;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}

	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}

	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo))
				hijos.eliminar(hijo);
		}
	}

	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}

	/*
	 * public int altura() { if (this.esHoja()) return 0; else { int maximo=0;
	 * int calculado=0; ListaGenerica<ArbolGeneral<T>>lista=this.getHijos();
	 * ArbolGeneral<T> arbol=null; lista.comenzar(); while (!lista.esVacia()) {
	 * arbol=lista.proximo(); calculado=arbol.altura(); if (calculado>maximo)
	 * maximo=calculado; } return 1+maximo; } }
	 */

	/*public int altura() {
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol = new ArbolGeneral<T>(null);
		ListaGenerica<ArbolGeneral<T>> lista = new ListaGenericaEnlazada<ArbolGeneral<T>>();
		int altura = 0;
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				lista = arbol.getHijos();
				lista.comenzar();
				while (!lista.fin())
					cola.encolar(lista.proximo());
			} else {
				if (arbol == null && !cola.esVacia()) {
					cola.encolar(null);
					altura++;
				}
			}
		}
		return altura;
	}
	*/
	public int altura()
	{int max=0;
	int suma=0;	
	return alturaPRIV(suma,max,this); 
	}
private int alturaPRIV(int suma, int max, ArbolGeneral<T> arbol )
{
	if (arbol.esHoja()) {
		if (suma>max)
			return suma;
}else
{if (this!=null)
	if (arbol.tieneHijos()) {
		ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
		hijos.comenzar();
		while (!hijos.fin()) {
			max=this.alturaPRIV(suma, max,hijos.proximo());
		}
	}
		
}
	return max;
}
public boolean include(T dato)
{if (this.esHoja())
	if (dato==this.getDato())
		return true;
	else {
		if (this.tieneHijos())
			{ListaGenerica<ArbolGeneral<T>> lista =new ListaGenericaEnlazada<ArbolGeneral<T>>();
			lista=this.getHijos();
			lista.comenzar();
			while (!lista.fin())
				lista.proximo().include(dato);
	}
	}
return false;
}
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

public Integer nivel(T dato) {
		// falta implementar
		return -1;
	}

	public Integer ancho() {
		// Falta implementar..
		return 0;
	}

}