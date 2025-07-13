package prog3.util;
import prog3.listagenerica.*;
public class Cola<T> {
private ListaGenericaEnlazada<T> Cola=new ListaGenericaEnlazada<T>();

public void encolar(T elemento)
{
	this.Cola.agregarFinal(elemento);
}
public T desencolar()
{
T dato=Cola.elemento(0);
Cola.eliminarEn(0);
return dato;
}
public T tope()
{
return this.Cola.elemento(0);	
}


public boolean esVacia()
{
return this.Cola.tamanio()==0;	
}
}