package prog3.listagenerica;

public class ColaGenerica<T> {
	private ListaGenericaEnlazada <T> l= new ListaGenericaEnlazada <T>() ;

	public void encolar(T elem) {
		l.agregarFinal(elem);
	}

	public T desencolar() {
		T elem= l.elemento(0);
		l.eliminarEn(0);
		return elem;
	}

	public T tope() {
		return l.elemento(0);
	}

	public boolean esVacia() {
		return l.tamanio() == 0;
	}
}
