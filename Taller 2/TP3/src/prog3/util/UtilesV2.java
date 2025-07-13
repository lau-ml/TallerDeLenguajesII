package prog3.util;

import prog3.arbolbinariov2.ArbolBinario;
import prog3.listagenerica.ListaGenericaEnlazada;

public class UtilesV2 {

	public int sumaMaximaVertical(ArbolBinario<Integer> arbol) {
		int sumahi = 0;
		int sumahd = 0;
		int sumamax = 0;
		if (arbol != null && !arbol.esVacio()) {
			if (!arbol.esHoja()) {
				sumahi += sumaMaximaVertical(arbol.getHijoIzquierdo());
				sumahd += sumaMaximaVertical(arbol.getHijoDerecho());
			}
			if (sumahi > sumamax)
				sumamax = sumahi;
			else
				sumamax = sumahd;
			if (arbol.getDato() != null)
				sumamax += arbol.getDato();
		}
		return sumamax;
	}

	public int sumaMaximaHorizontal(ArbolBinario<Integer> arbol) {
		ArbolBinario<Integer> arbolAUX = new ArbolBinario<Integer>();
		Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
		boolean lleno = true;
		int max;
		int suma = 0;
		if (arbol != null && !arbol.esVacio())
			max = arbol.getDato();
		else
			max = 0;
		cola.encolar(arbol);
		cola.encolar(null);
		while (!cola.esVacia() && (lleno)) {
			arbolAUX = cola.desencolar();
			if (arbolAUX != null) {
				if (arbolAUX.tieneHijoIzquierdo()) {
					cola.encolar(arbolAUX.getHijoIzquierdo());
					if (arbol.getDato() != null)
						suma += arbolAUX.getHijoIzquierdo().getDato();
				}
				if (arbolAUX.tieneHijoDerecho()) {
					cola.encolar(arbolAUX.getHijoDerecho());
					if (arbol.getDato() != null)
						suma += arbolAUX.getHijoDerecho().getDato();
				}
			} else if (!cola.esVacia()) {
				if (suma > max)
					max = suma;
				cola.encolar(null);
				suma = 0;
			}
		}
		return max;
	}

	public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario) {
		// TO-DO
		ListaGenericaEnlazada<String> resultado = new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<String> actual = new ListaGenericaEnlazada<String>();
		if (abinario != null && !abinario.esVacio())
			secuenciaConMasPreguntasPRIV(abinario, actual, resultado);
		return resultado;
	}

	private void secuenciaConMasPreguntasPRIV(ArbolBinario<String> abinario, ListaGenericaEnlazada<String> actual,
			ListaGenericaEnlazada<String> resultado) {
		//
		actual.agregarFinal(abinario.getDato());
		if (abinario.esHoja()) {
			if (actual.tamanio() > resultado.tamanio()) {
				while (!resultado.esVacia())
					resultado.eliminarEn(0);
				actual.comenzar();
				while (!actual.fin())
					resultado.agregarFinal(actual.proximo());
			}
		} else {
			if (abinario.tieneHijoIzquierdo()) {
				actual.agregarFinal("SI");
				secuenciaConMasPreguntasPRIV(abinario.getHijoIzquierdo(), actual, resultado);
				actual.eliminarEn(actual.tamanio() - 1);
			}
			if (abinario.tieneHijoDerecho()) {
				actual.agregarFinal("NO");
				secuenciaConMasPreguntasPRIV(abinario.getHijoDerecho(), actual, resultado);
				actual.eliminarEn(actual.tamanio() - 1);
			}
		}
		actual.eliminarEn(actual.tamanio() - 1);
	}

	public ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntasV2(
			ArbolBinario<String> abinario) {
		// TO-DO
		ListaGenericaEnlazada<String> resultado = new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<String> actual = new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> resultado2 = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		if (abinario != null && !abinario.esVacio())
			secuenciaConMasPreguntasPRIV2(abinario, actual, resultado, resultado2);
		return resultado2;
	}

	private void secuenciaConMasPreguntasPRIV2(ArbolBinario<String> abinario, ListaGenericaEnlazada<String> actual,
			ListaGenericaEnlazada<String> resultado, ListaGenericaEnlazada<ListaGenericaEnlazada<String>> resultado2) {
		//
		actual.agregarFinal(abinario.getDato());// Guardo el dato
		if (abinario.esHoja()) {
			if (actual.tamanio() > resultado.tamanio()) { // Comparo los tamaños, si es mayor:
				while (!resultado.esVacia())
					resultado.eliminarEn(0); // limpio la lista resultado, la cual guarda el ultimo camino mas largo
				actual.comenzar();
				while (!actual.fin()) // Recorro la lista actual hasta el final y la agrego en la lista resultado
					resultado.agregarFinal(actual.proximo());
				while (!resultado2.esVacia()) // Vacio, si es que tiene datos, la lista que me guarda todos los caminos
												// maximos
					resultado2.eliminarEn(0);
				resultado2.agregarFinal(resultado);
			} else if (actual.tamanio() == resultado.tamanio()) { // Caso de igualdad
				ListaGenericaEnlazada<String> lAUX = new ListaGenericaEnlazada<String>();// Creo un nodo para guardar
																							// una lista del mismo
																							// tamaño que resultado
				actual.comenzar();
				while (!actual.fin())
					lAUX.agregarFinal(actual.proximo());
				resultado2.agregarFinal(lAUX);
				// No actualizo resultado, ya que ahí tengo guardada la primera lista maxima.
				// Por eso se debe crear una nueva lista.
			}
		} else {
			if (abinario.tieneHijoIzquierdo()) {
				actual.agregarFinal("SI");
				secuenciaConMasPreguntasPRIV2(abinario.getHijoIzquierdo(), actual, resultado, resultado2);
				actual.eliminarEn(actual.tamanio() - 1);
			}
			if (abinario.tieneHijoDerecho()) {
				actual.agregarFinal("NO");
				secuenciaConMasPreguntasPRIV2(abinario.getHijoDerecho(), actual, resultado, resultado2);
				actual.eliminarEn(actual.tamanio() - 1);
			}
		}
		actual.eliminarEn(actual.tamanio() - 1);
	}

	public ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> ab) {
		ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();
		int suma = 0, nivel = 0;
		if (ab != null)
			trayectoriaPesada2(ab, suma, nivel, lista);
		return lista;
	}

	private void trayectoriaPesada2(ArbolBinario<Integer> ab, int suma, int nivel,
			ListaGenericaEnlazada<Integer> lista) {
		if (ab.esHoja())
			lista.agregarFinal(suma + ab.getDato() * nivel);
		else {
			if (ab.tieneHijoIzquierdo() && ab.getDato() != null)
				trayectoriaPesada2(ab.getHijoIzquierdo(), suma + ab.getDato() * nivel, nivel + 1, lista);
			if (ab.tieneHijoDerecho() && ab.getDato() != null)
				trayectoriaPesada2(ab.getHijoDerecho(), suma + ab.getDato() * nivel, nivel + 1, lista);
		}
	}
}
