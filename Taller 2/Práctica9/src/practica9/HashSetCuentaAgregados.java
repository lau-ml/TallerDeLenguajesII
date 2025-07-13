package practica9;

import java.util.*;

public class HashSetCuentaAgregados<E> extends HashSet<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantidadAgregados = 0;

	public HashSetCuentaAgregados() {
	}

	public HashSetCuentaAgregados(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	// @Override
/*	public boolean add(E e) {
		cantidadAgregados++;
		return super.add(e);
	}*/
//Al llamar al método addAll de la instancia de la clase HashSetCuentaAgregados sucede que, se contabiliza la cantidad de elementos actualizando la cantidad de agregados
//En función de la colección que se le pase.
//Dado que se sobreescribe el método add, lo que sucede es que se terminan contando dos veces. La alternativa es:
//O se elimina el método add dentro de la clase HashSetCuentaAgregados o se borra la línea dentro de addAll
//La forma que considero más conveniente es eliminar el add HashSetCuentaAgregados. Esto por el hecho de que lo único que se genera es llamar a un método para solamente actualizar una variable
	//la cual ya sé desde un inicio.
	@Override
	public boolean addAll(Collection<? extends E> c) {
		cantidadAgregados += c.size();
		return super.addAll(c);
	}

	public int getCantidadAgregados() {
		return cantidadAgregados;
	}
}
