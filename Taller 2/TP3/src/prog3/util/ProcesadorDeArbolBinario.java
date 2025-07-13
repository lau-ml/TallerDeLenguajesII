package prog3.util;

import prog3.arbol.binario.*;

public class ProcesadorDeArbolBinario {
	private ArbolBinario<Integer> arbol;

	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	public int sumaElementosProfundidad(int p) {
		ArbolBinario<Integer> arbolAUX = new ArbolBinario<Integer>();
		Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
		boolean finalizar = false;
		int suma = 0;
		int nivel = 0;
		cola.encolar(this.getArbol());
		cola.encolar(null);
		while (!cola.esVacia() && !finalizar) {
			arbolAUX = cola.desencolar();
			if (arbolAUX != null) {
				suma += arbolAUX.getDatoRaiz();
				if (!arbolAUX.getHijoIzquierdo().esVacio())
					cola.encolar(arbolAUX.getHijoIzquierdo());
				if (!arbolAUX.getHijoDerecho().esVacio())
					cola.encolar(arbolAUX.getHijoDerecho());
			}
		
			else if (!finalizar) {
			if (nivel++ != p) {
				suma = 0;
				cola.encolar(null);
			} else
				finalizar = true;
		}
		}
		return suma;
	}
}
