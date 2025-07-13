package prog3.arbol.binario;
public class Recorrido<T> {
	public void Preorder(ArbolBinario<T> arbol)
	{	if (!arbol.esVacio())
		System.out.print(arbol.getDatoRaiz());
		if (!arbol.getHijoIzquierdo().esVacio())
			Preorder(arbol.getHijoIzquierdo());
		if (!arbol.getHijoDerecho().esVacio())
			Preorder(arbol.getHijoDerecho());
	}
	public void PostOrder(ArbolBinario<T> arbol)
	{	if (!arbol.esVacio())
		if (!arbol.getHijoIzquierdo().esVacio())
			PostOrder(arbol.getHijoIzquierdo());
		if (!arbol.getHijoDerecho().esVacio())
			PostOrder(arbol.getHijoDerecho());
		System.out.print(arbol.getDatoRaiz());
	}
	public void InOrder(ArbolBinario<T> arbol)
	{	if (!arbol.esVacio())
		if (!arbol.getHijoIzquierdo().esVacio())
			InOrder(arbol.getHijoIzquierdo());
		System.out.print(arbol.getDatoRaiz());
		if (!arbol.getHijoDerecho().esVacio())
			InOrder(arbol.getHijoDerecho());
	}	
	
	
}
