package prog3.grafos.utiles;
import prog3.util.*;

import prog3.listagenerica.*;
public class PruebaMapa {

	public static void main(String[] args) {
		
		Mapa<String> mapa1= new Mapa<String>();
		System.out.println("Cualquier camino en funcion de lista de adyacencias" + mapa1.devolverCamino("Buenos Aires", "Rio de Janeiro"));//Devuelve cualquier camino que llegue de Buenos Aires hasta Rio  
		ListaGenerica<String> ciudades=new ListaGenericaEnlazada<String>();
		ciudades.agregarFinal("Paris");
		System.out.println("Camino exceptuado: " + mapa1.devolverCaminoExceptuando("Buenos Aires", "Rio de Janeiro", ciudades));//Devuelve el camino que no contenga un conjunto determinado de ciudades
		System.out.println(mapa1.devolverCaminoMasCorto("Camuino exceptuado: " + "Buenos Aires","Rio de Janeiro"));//Devuelve el camino mas corto entre Buenos Aires y Rio
		System.out.println(mapa1.caminoSinCargarCombustible("Sin cargar combustible" + "Buenos Aires", "Rio de Janeiro", 3));//Devuelve cualquier camino que comunique ambas ciudades, sin que el auto pueda cargar combustible o quedarse sin.
		System.out.println(mapa1.caminoConMenorCargaDeCombustible("Camino con menor carga: " + "Buenos Aires", "Rio de Janeiro", 40));
	}

}
