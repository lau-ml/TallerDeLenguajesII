package prog3.arbolbinariov2.test;

import prog3.arbolbinariov2.ArbolBinario;
import prog3.util.UtilesV2;
import prog3.listagenerica.*;
import prog3.util.ProcesadorDeArbolBinarioV2;

public class PruebaArbol<T> {
	public static void main(String[] args) {
		ArbolBinario<Integer> arbolBinarioB = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> hijoIzquierdoB = new ArbolBinario<Integer>(1);
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		ArbolBinario<Integer> hijoDerechoB = new ArbolBinario<Integer>(3);
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(1));
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);
		UtilesV2 prueba = new UtilesV2();
		int u = prueba.sumaMaximaVertical(arbolBinarioB);
		int b = prueba.sumaMaximaHorizontal(arbolBinarioB);
		ListaGenericaEnlazada<Integer> lista1=new ListaGenericaEnlazada<Integer>();
		System.out.println(u);
		System.out.println(b);
		lista1=prueba.trayectoriaPesada(arbolBinarioB);
		ArbolBinario<String> arbolBinarioC= new ArbolBinario<String>("Tiene cuatro patas?");
		ArbolBinario<String> arbolBinarioD= new ArbolBinario<String>("Se mueve?");
		ArbolBinario<String> arbolBinarioE= new ArbolBinario<String>("Ladra?");
		ArbolBinario<String> arbolBinarioF= new ArbolBinario<String>("Es un perro");
		ArbolBinario<String> arbolBinarioG= new ArbolBinario<String>("Es una mesa");
		ArbolBinario<String> arbolBinarioH= new ArbolBinario<String>("Es una mesa");
		ArbolBinario<String> arbolBinarioI= new ArbolBinario<String>("Es una mesa");
		ArbolBinario<String> arbolBinarioJ= new ArbolBinario<String>("Es una mesa");
		ArbolBinario<String> arbolBinarioK= new ArbolBinario<String>("Es una mesa");
		ArbolBinario<String> arbolBinarioL= new ArbolBinario<String>("Es una mesa");
		ArbolBinario<String> arbolBinarioM= new ArbolBinario<String>("Es una mesa");
		//arbolBinarioL.agregarHijoIzquierdo(arbolBinarioM);
		//arbolBinarioK.agregarHijoIzquierdo(arbolBinarioL);
		//arbolBinarioJ.agregarHijoIzquierdo(arbolBinarioK);
		//arbolBinarioI.agregarHijoIzquierdo(arbolBinarioJ);
		//arbolBinarioH.agregarHijoIzquierdo(arbolBinarioI);
		arbolBinarioG.agregarHijoIzquierdo(arbolBinarioH);
		arbolBinarioE.agregarHijoIzquierdo(arbolBinarioF);
		arbolBinarioE.agregarHijoDerecho(new ArbolBinario <String>("Es un gato"));
		arbolBinarioD.agregarHijoIzquierdo(arbolBinarioE);
		arbolBinarioD.agregarHijoDerecho(arbolBinarioG);
		arbolBinarioC.agregarHijoIzquierdo(arbolBinarioD);
		ListaGenericaEnlazada<String> lista= new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> lista3= new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		lista3=prueba.secuenciaConMasPreguntasV2(arbolBinarioC);
		lista=prueba.secuenciaConMasPreguntas(arbolBinarioC);
		//arbolBinarioC.printInorden();
		//arbolBinarioC.printPreorden();
		//arbolBinarioC.printPostorden();
		while (!lista.esVacia())
		{		System.out.print(lista.elemento(0));
				lista.eliminarEn(0);
	}
		while (!lista1.esVacia())
		{		System.out.println(lista1.elemento(0));
				lista1.eliminarEn(0);
	}		
		ProcesadorDeArbolBinarioV2 a= new ProcesadorDeArbolBinarioV2();
		a.setArbol(arbolBinarioB);
		System.out.println(a.sumaElementosProfundidad(2));
		System.out.println(lista3.elemento(0));
		System.out.println(lista3.elemento(1));
		System.out.println(lista3.elemento(2));
	}
}