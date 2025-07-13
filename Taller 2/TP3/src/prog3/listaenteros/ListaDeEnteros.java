package prog3.listaenteros;

/**
 * ListaDeEnteros es una clase abstracta que define los m√©todos que deber√°n
 * implementar todas aquellas clases que quieran representar una coleccion de
 * n√∫meros enteros, extendiendo esta clase
 * */
/* La clase se define principalmente como abstracta, para determinar un conjunto de mÈtodos, comportamientos, que tienen que cumplir de forma obligatoria las subclases que pertenecen a ella.
 * Es decir, son mÈtodos que no tienen una implementaciÛn dentro de la clase padre. Esto permite una simplicidad en el codigo a implementar, permitiendo que cada subclase establezca su forma particular de hacerlo*/
 /*Por otro lado, da una idea general. Al dar si se quiere esta idea general del tipo de clase, lo que provoca es que no se la pueda instanciar, ya que no se sabe nada respecto a sus metodos */
/*No se puede agregar comportamiento dentro de metodos abstractos, ya que los mismos son implementados en las subclases que heredan su comportamiento general. Es decir, dentro de los mismos metodos no se puede agregar, pero eso no implica que no podamos agregar nuevos metodos concretos, que sea igual para todas las subclases. Sin embargo
 Es fundamental tener en cuenta la implementaciÛn que corresponde, en caso de que efectivamente sea un mÈtodo abstracto*/
 
public abstract class ListaDeEnteros {

	/** permite posicionarse al principio de la lista */
	public abstract void comenzar();

	/** permite avanzar al proximo elemento de lista */
	public abstract Integer proximo();

	/**
	 * devuelve true si nos encontramos en el √∫ltimo elemento de la lista, false
	 * en caso contrario
	 */
	public abstract boolean fin();

	/**
	 * devuelve el elemento que se encuentra en la posicion pos. Hay que
	 * recordar que la lista empieza en la posicion 0.
	 * 
	 * @param pos
	 *            posicion del elemento que se va a recuperar
	 */
	public abstract Integer elemento(int pos);

	/**
	 * agrega un elemento en la posicion pos indicada. Si hubiera un elemento en
	 * dicha posicion, el mismo se reubicar√° a continuaci√≥n del elemento que
	 * vamos a agregar. Si pudo eliminarlo devuelve true, false en caso contrario.
	 * 
	 * @param elem
	 *            elemento a agregar
	 * @param pos
	 *            posicion donde deber√° agregarse el elemento
	 * */
	public abstract boolean agregarEn(Integer elem, int pos);

	/**
	 * agrega un elemento al principio de la lista. Si pudo agregarlo devuelve true, false en caso contrario.
	 * 
	 * @param elem
	 *            elemento a agregar
	 * */
	public abstract boolean agregarInicio(Integer elem);

	/**
	 * agrega un elemento al final de la lista. Si pudo agregarlo devuelve true, false en caso contrario.
	 * 
	 * @param elem
	 *            elemento a agregar
	 * */
	public abstract boolean agregarFinal(Integer elem);

	/**
	 * elimina la primer ocurrencia del elemento elem indicado. Si pudo eliminarlo devuelve true, false en caso contrario.
	 * 
	 * @param elem
	 *            elemento a eliminar
	 * */
	public abstract boolean eliminar(Integer elem);

	/**
	 * elimina el elemento ubicado en la posicion pos. Si pudo eliminarlo devuelve true, false en caso contrario.
	 * 
	 * @param pos
	 *            posicion del elemento a eliminar
	 * */
	public abstract boolean eliminarEn(int pos);

	/**
	 * devuleve true si la lista contiene al elemento elem, false en caso
	 * contrario
	 * 
	 * @param elem
	 *            elemento a buscar en la lista
	 * */
	public abstract boolean incluye(Integer elem);

	/**
	 * devuelve true si la lista no contiene elemntos, false en caso contrario
	 * */
	public abstract boolean esVacia();

	/**
	 * devuelve un numero que representa la cantidad de elementos que contiene
	 * la lista
	 * */
	public abstract int tamanio();

}
