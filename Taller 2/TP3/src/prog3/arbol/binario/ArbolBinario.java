package prog3.arbol.binario;

import prog3.util.*;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

/* Al implementar esta forma de armar un arbol los nodos hoja se crean formando un nuevo nodo que tendra como referencia a arboles nulos(izq y der)*/
public class ArbolBinario<T> {

	private NodoBinario<T> raiz;

	public ArbolBinario() {
		this.raiz = null;
	}

	public ArbolBinario(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinario(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinario<T> getHijoDerecho() {
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}

	public void eliminarHijoIzquierdo() {
		this.raiz.setHijoIzquierdo(new NodoBinario<T>(null));
	}

	public void eliminarHijoDerecho() {
		this.raiz.setHijoDerecho(new NodoBinario<T>(null));
	}

	public boolean esVacio() {
		return this.raiz == null;
	}

	public boolean esHoja() {
		return this.getDatoRaiz() != null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}

	public ListaGenerica<T> frontera() {
		ListaGenericaEnlazada<T> lista = new ListaGenericaEnlazada<T>();
		lista.comenzar();
		frontera2(lista);
		return lista;
	}

	private void frontera2(ListaGenerica<T> lista) {
		if (!this.esVacio())
			if (!this.getHijoIzquierdo().esVacio())
				this.getHijoIzquierdo().frontera2(lista);
		if (!this.getHijoDerecho().esVacio())
			this.getHijoDerecho().frontera2(lista);
		if (this.getHijoDerecho().esVacio() && this.getHijoIzquierdo().esVacio())
			lista.agregarFinal(this.getDatoRaiz());
	}

	public boolean lleno() {
		ArbolBinario<T> arbolAUX = new ArbolBinario<T>();
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		boolean lleno = true;
		int nivel = 0;
		int cantNodos = 0;
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia() && (lleno)) {
			arbolAUX = cola.desencolar();
			if (arbolAUX != null) {
				if (!arbolAUX.getHijoIzquierdo().esVacio()) {
					cola.encolar(arbolAUX.getHijoIzquierdo());
					cantNodos++;
				}
				if (!arbolAUX.getHijoDerecho().esVacio()) {
					cola.encolar(arbolAUX.getHijoDerecho());
					cantNodos++;
				}
			} else if (!cola.esVacia()) {
				if (cantNodos == Math.pow(2, ++nivel)) {
					cola.encolar(null);
					cantNodos = 0;
				} else
					lleno = false;
			}
		}
		return lleno;
	}

	/*
	 * public boolean completo() { ArbolBinario<T> ab=this; int u=cantNodos(ab); int
	 * i=0; boolean esCompleto=cumpleCompleto(ab,u,i); return esCompleto; } private
	 * boolean cumpleCompleto(ArbolBinario <T> ab,int cantNodos,int i) {if
	 * (ab.esVacio()) return true; if (i>=cantNodos) return false; return
	 * (cumpleCompleto(ab.getHijoIzquierdo(),cantNodos,i*2 +1)&&
	 * cumpleCompleto(ab.getHijoDerecho(),cantNodos,i*2+2)); }
	 * 
	 * private int cantNodos(ArbolBinario<T> ab){ if (ab.esVacio()) return 0; return
	 * cantNodos(ab.getHijoIzquierdo())+cantNodos(ab.getHijoDerecho()) + 1; }
	 */
	public boolean completo() {
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		ArbolBinario<T> ab = new ArbolBinario<T>();
		boolean flag = true;
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			ab = cola.desencolar();
			if (ab != null) {		
				if (!ab.getHijoIzquierdo().esVacio())
						{if (!flag)
							return false;
					cola.encolar(ab.getHijoIzquierdo());
						}
				if (!ab.getHijoDerecho().esVacio())
				{	if (!flag)
						return false;
					cola.encolar(ab.getHijoDerecho());
				}
				if (ab.getHijoIzquierdo().esVacio() && !ab.getHijoDerecho().esVacio())
					return  false;
				else if (flag && !(!ab.getHijoIzquierdo().esVacio() && !ab.getHijoIzquierdo().esVacio()))
					flag=false;
				
			} else if (flag)
				cola.encolar(null);
		}
		return true;
	}

}