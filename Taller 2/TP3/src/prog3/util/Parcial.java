package prog3.util;
import prog3.arbolgeneral.*;
import prog3.listagenerica.*;
public class Parcial {
public boolean resolver (ArbolGeneral<Integer> arbol)
{
	int suma=0;
	int valorPadre=0;
	boolean correcta= true;
	Cola<ArbolGeneral<Integer>> cola= new Cola<ArbolGeneral<Integer>> ();
	ArbolGeneral<Integer> arbolAUX;
	ListaGenerica<ArbolGeneral<Integer>> hijos= new ListaGenericaEnlazada<ArbolGeneral<Integer>>();
	cola.encolar(arbol);
	cola.encolar(null);
	while (!cola.esVacia() && correcta)
	{
		arbolAUX=cola.desencolar();
		if (arbolAUX!=null)
		{	if (arbolAUX.tieneHijos())
			{suma=0;
			valorPadre=arbolAUX.getDato();
			hijos=arbolAUX.getHijos();
			hijos.comenzar();
			while (!hijos.fin())
			{ArbolGeneral<Integer> arbolAUX2= hijos.proximo();
			suma+=arbolAUX2.getDato();
			cola.encolar(arbolAUX2);
			
			}
			if (valorPadre<=suma)
				correcta=false;
			else
			cola.encolar(null);
			}
		}
		{		
		
		}
	}
	return correcta;

	

}
}
