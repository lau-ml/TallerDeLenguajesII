package prog3.listaenteros;

/**
 * La clase ListaDeEnterosEnlazada es una ListaDeEnteros, donde los elementos de
 * la lista (nodos) referencian al siguiente elemento (nodo), por este motivo,
 * la ListaDeEnterosEnlazada no tiene límite en la cantidad de elementos que se
 * pueden almacenar.
 */
public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	/* primer nodo de la lista, si la lista esta vacia, inicio es null */
	private NodoEntero inicio;

	/*
	 * nodo actual que se va actualizando a medida que recorremos la lista, si la
	 * lista esta vacia, actual es null
	 */
	private NodoEntero actual;

	/* ultimo nodo de la lista, si la lista esta vacia, fin es null */
	private NodoEntero fin;

	/* cantidad de nodos en la lista */
	private int tamanio;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public Integer proximo() {
		Integer elem = this.actual.getDato();
		this.actual = this.actual.getSiguiente();
		return elem;
	}

	@Override
	public boolean fin() {
		return (this.actual == null);
	}

	@Override
	public Integer elemento(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // no es posicion valida
			return null;
		NodoEntero n = this.inicio;
		while (pos-- > 0)
			n = n.getSiguiente();
		return n.getDato();
	}

	@Override
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 0 || pos > this.tamanio()) // posicion no valida
			return false;
		this.tamanio++;
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (pos == 0) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
		} else {
			NodoEntero n = this.inicio;
			NodoEntero ant = null;
			int posActual = 0;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);

			if (aux.getSiguiente() == null)
				this.fin = aux;
		}
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);

		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			aux.setSiguiente(this.inicio);
			this.inicio = aux;
		}
		this.tamanio++;
		return true;
	}

	@Override
	public boolean agregarFinal(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}

	@Override
	public boolean eliminar(Integer elem) {
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while ((n != null) && (!n.getDato().equals(elem))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				this.inicio = this.inicio.getSiguiente();
			else
				ant.setSiguiente(n.getSiguiente());
			this.tamanio--;

			return true;
		}
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // posicion no valida
			return false;
		this.tamanio--;
		if (pos == 0) {
			this.inicio = this.inicio.getSiguiente();
			return true;
		}
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while (!(n == null) && (pos > 0)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		if (ant.getSiguiente() == null)
			this.fin = ant;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
		NodoEntero n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		NodoEntero n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}

	@Override
	public boolean esVacia() {
		return this.tamanio() == 0;
	}

	public void recursivo(NodoEntero l)/*
										 * Utilizo nodos para poder realizar la recursion, al estilo de los demas
										 * lenguajes
										 */
	{
		if (l != null) {
			recursivo(l.getSiguiente());
			System.out.print("<--" + l.getDato());
		}
	}

	public void recursivoBien(ListaDeEnterosEnlazada l)/*
														 * Utilizo las herramientas que me brinda la clase para poder
														 * recorrer la lista, por medio del puntero actual
														 */
	/* Que al llamar al modulo, lo hago antes apuntar al inicio de la lista */
	{
		if (l.fin() == false) {
			int u = l.proximo();
			recursivoBien(l);
			System.out.print(u);
		}
	}

	public ListaDeEnterosEnlazada ordenar() {
		ListaDeEnterosEnlazada lista= new ListaDeEnterosEnlazada();
		NodoEntero n= new NodoEntero();
		n=this.inicio;
		int salio=0;
		int i=0;
		while (this.tamanio()>i)
		{int min=Integer.MAX_VALUE;
			while (n != null) {
			if (n.getDato()<min && n.getDato()>salio)
				min =n.getDato();
			n=n.getSiguiente();
		}
		salio=min;
		n=this.inicio;
		lista.agregarFinal(salio);
		i++;
		}
		return lista;
	}
	/*Similar sucede si trabajo con la ListaDeEnterosEnlazada en vez de con los nodos referenciados a cada una de las listas*/
	public ListaDeEnterosEnlazada combinarOrdenado(ListaDeEnterosEnlazada ordenada)
	{	ListaDeEnterosEnlazada resultado=new ListaDeEnterosEnlazada();
	boolean termino=false;
	NodoEntero puntOrd=new NodoEntero();
	NodoEntero puntOrd2 = new NodoEntero();
	puntOrd=this.inicio;
	puntOrd2=ordenada.inicio;
	while (!termino)
	{if ((puntOrd==null)&&(puntOrd2==null))
		termino=true;
	if (puntOrd!=null & puntOrd2!=null)
	{	if (puntOrd.getDato()<puntOrd2.getDato())
			{resultado.agregarFinal(puntOrd.getDato());
			puntOrd=puntOrd.getSiguiente();
			}
	else {resultado.agregarFinal(puntOrd2.getDato());
		puntOrd2=puntOrd2.getSiguiente();
	}
	}
	else if(puntOrd!=null & puntOrd2==null)
	{
		resultado.agregarFinal(puntOrd.getDato());
		puntOrd=puntOrd.getSiguiente();
	}
	else if (puntOrd==null && puntOrd2!=null)
	{
		resultado.agregarFinal(puntOrd2.getDato());
		puntOrd2=puntOrd2.getSiguiente();
	}
}return resultado;
}
	public ListaDeEnterosEnlazada combinarOrdenado2(ListaDeEnterosEnlazada ordenada)
	{	ListaDeEnterosEnlazada resultado=new ListaDeEnterosEnlazada();
	boolean termino=false;
	this.actual=this.inicio;
	ordenada.actual=ordenada.inicio;
	while (!termino)
	{if ((this.fin()==true)&&(ordenada.fin()==true))
		termino=true;
	if (this.fin()==false & ordenada.fin()==false)
	{	if (this.actual.getDato()<ordenada.actual.getDato())
			{resultado.agregarFinal(this.proximo());
			}
	else {resultado.agregarFinal(ordenada.proximo());
	}
	}
	else if(this.fin()!=true & ordenada.fin()==true)
	{
		resultado.agregarFinal(this.proximo());
	}
	else if (this.fin()==true && ordenada.fin()!=true)
	{
		resultado.agregarFinal(ordenada.proximo());
	}
}return resultado;
}
}