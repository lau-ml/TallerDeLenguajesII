package prog3.util;

import prog3.arbolgeneral.*;
import prog3.listagenerica.*;

public class RedDeAguaPotable<T> {
	public double menorCaudal(ArbolGeneral<T> arbol, double litros) {
		double min = 999999;
		double resultado = 0;

		if (!arbol.esVacio()) {
			if (arbol.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
				hijos = arbol.getHijos();
				hijos.comenzar();
				while (!hijos.fin())
					resultado = menorCaudal(hijos.proximo(), litros / 4);
				if (resultado < min)
					min = resultado;
			} else
				min = litros;
		}
		return min;
	}
}