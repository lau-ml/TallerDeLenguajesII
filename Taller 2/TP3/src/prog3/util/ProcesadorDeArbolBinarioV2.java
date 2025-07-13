package prog3.util;

import prog3.arbolbinariov2.*;

public class ProcesadorDeArbolBinarioV2 {
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
				if (arbolAUX.getDato()!=null)
				suma += arbolAUX.getDato();
				if (arbolAUX.tieneHijoIzquierdo())
					cola.encolar(arbolAUX.getHijoIzquierdo());
				if (arbolAUX.tieneHijoDerecho())
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