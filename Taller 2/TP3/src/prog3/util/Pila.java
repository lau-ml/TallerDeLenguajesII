package prog3.util;
import prog3.listagenerica.*;
public class Pila<T> {
private ListaGenericaEnlazada<T> Pila= new ListaGenericaEnlazada<T>();
public void apilar(T elemento) {
Pila.agregarEn(elemento, 0);
}
public T desapilar() {
	T dat=Pila.elemento(0);
	Pila.eliminarEn(0);
	return dat;
}
public T tope()
{
	return Pila.elemento(0);
}
public boolean esVacia() {
	return Pila.tamanio()==0;
}
}
