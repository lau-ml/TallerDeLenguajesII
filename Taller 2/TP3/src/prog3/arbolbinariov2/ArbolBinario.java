package prog3.arbolbinariov2;

import prog3.listagenerica.*;
import prog3.util.Cola;

public class ArbolBinario<T> {

	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * 
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
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
				if (arbolAUX.tieneHijoIzquierdo()) {
					cola.encolar(arbolAUX.getHijoIzquierdo());
					cantNodos++;
				}
				if (arbolAUX.tieneHijoDerecho()) {
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

	public boolean completo() {
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		ArbolBinario<T> ab = new ArbolBinario<T>();
		boolean flag = true;
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			ab = cola.desencolar();
			if (ab != null) {
				if (ab.tieneHijoIzquierdo()) {
					if (!flag)
						return false;
					cola.encolar(ab.getHijoIzquierdo());
				}
				if (ab.tieneHijoDerecho()) {
					if (!flag)
						return false;
					cola.encolar(ab.getHijoDerecho());
				}
				if (!ab.tieneHijoIzquierdo() && ab.tieneHijoDerecho())
					return false;
				else if (flag && !(ab.tieneHijoIzquierdo() && ab.tieneHijoDerecho()))
					flag = false;

			} else if (flag)
				cola.encolar(null);
		}
		return true;
	}

	// imprime el árbol en preorden
	public void printPreorden() {
		if (this!=null) {
			if (this.dato!=null)
			System.out.print(this.getDato());
			if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPreorden();
			if (this.tieneHijoDerecho())
			this.getHijoDerecho().printPreorden();
	}
	}
	// imprime el �rbol en postorden
	public void printPostorden() {
		if (this!=null)
		{ if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPostorden();
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().printPostorden();
			if (this.dato!=null)
			System.out.print(this.getDato());
		}
	}
	
	public void printInorden() {
		if (this!=null)
		{	if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printInorden();
			if (this.dato!=null)
			System.out.print(this.getDato());
			if (this.tieneHijoDerecho())
			this.getHijoDerecho().printInorden();
		}
	}

	public void recorridoPorNiveles() {

	}

	public ListaGenerica<T> frontera() {
		ListaGenericaEnlazada<T> lista = new ListaGenericaEnlazada<T>();
		lista.comenzar();
		frontera2(lista);
		return lista;
	}

	private void frontera2(ListaGenerica<T> lista) {
		if (this!=null)
			{if (this.tieneHijoIzquierdo())
				this.getHijoIzquierdo().frontera2(lista);
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().frontera2(lista);
		if (this.esHoja())
			lista.agregarFinal(this.getDato());
	}
	}

	public int contarHojas() {
		int suma = 0;
		if (this != null && !this.esVacio()) {
			if (this.esHoja())
				return 1;
			else
				suma = this.getHijoIzquierdo().contarHojas() + this.getHijoDerecho().contarHojas();
		}
		return suma;
	}

}
