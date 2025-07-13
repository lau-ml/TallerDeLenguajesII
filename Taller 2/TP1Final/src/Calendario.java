package tpEntregable1;

import prog3.listagenerica.*;

/**
 * La clase calendario tiene asociada la cantidad de d�as que duran los juegos,
 * una fecha de inicio y tiene asociado un conjunto de nodos calendarios al cual
 * le delega la responsabilidad de agregar o quitar informaci�n en cuanto a la
 * fecha de realizaci�n de una determinada ronda. A su vez, la clase calendario
 * es capaz de acceder a la informaci�n que el nodo calendario almacena.
 * 
 * @author Lautaro Moller
 * @autor Tom�s Mc Nally
 * @version 1.0
 */
public class Calendario {
	private NodoCalendario[] nodos;
	private int cantDias;
	private Fecha fechaInicio;

	/**
	 * Convierte una fecha a indice para acceso al vector
	 * 
	 * @param fecha Recibe una fecha
	 * @return int Devulve la posici�n correspondiente a la posici�n del vector de
	 *         nodos calendario
	 */
	private int calcularPosicion(Fecha fecha) {
		return (fecha.getDia() + (fecha.getMes() - fechaInicio.getMes()) * 30 - fechaInicio.getDia());
	}

	/**
	 * Se encarga de crear un vector de nodos calendario, obteniendo su dimensi�n a
	 * partir de obtener una fecha v�lida.
	 * 
	 * @param fechaInicio Recibe la fecha del comienzo de los juegos
	 * @param fechaFin    Recibe la fecha del final de los juegos.
	 */

	public void setearVector(Fecha fechaInicio, Fecha fechaFin) {
		this.fechaInicio = fechaInicio;
		cantDias = calcularPosicion(fechaFin);
		nodos = new NodoCalendario[cantDias];
	}

	/**
	 * Le pide a nodos que se encargue de agregar una ronda, la cual tiene su propia
	 * fecha
	 * 
	 * @param ronda Recibe una ronda en particular a ser agregada
	 */
	public void agregarRonda(Ronda ronda) {
		int posicion = calcularPosicion(ronda.getFecha());
		nodos[posicion].addRonda(ronda);
	}

	/**
	 * Se encarga de pedirle a nodoCalendario, que borre la informaci�n que ten�a
	 * respecto a una determinada ronda y la actualice con una nueva fecha
	 * 
	 * @param ronda Recibe la ronda a modificar
	 * @param fecha Recibe la fecha con la cual se pretende actualizar una ronda
	 */
	public void modificarRonda(Ronda ronda, Fecha fecha) {
		int posicion = calcularPosicion(ronda.getFecha());
		nodos[posicion].subRonda(ronda);
		ronda.setFecha(fecha);
		posicion = calcularPosicion(ronda.getFecha());
		nodos[posicion].addRonda(ronda);
	}

	/**
	 * Obtiene una lista de rondas, la cual obtiene a partir de nodo calendario
	 * 
	 * @param sede  Recibe la sede de la que se pretende obtener informaci�n
	 * @param fecha Recibe la fecha en la cual se realiza la actividad
	 * @return ListaGenerica<Ronda> Devuelve una lista de rondas.
	 */
	public ListaGenerica<Ronda> rondasEn(Sede sede, Fecha fecha) {
		int posicion = calcularPosicion(fecha);
		return (nodos[posicion].getSede(sede));
	}

	/**
	 * El m�todo se encarga de devolver una lista de rondas, a partir de un pedido
	 * al nodo correspondiente con la fecha.
	 * 
	 * @param fecha Recibe la fecha con la cual se pretende obtener informaci�n
	 * @return ListaGenerica<Ronda> Devuelve una lista de rondas
	 */
	public ListaGenerica<Ronda> rondas(Fecha fecha) {
		int posicion = calcularPosicion(fecha);
		return (nodos[posicion].enLista());
	}

	/**
	 * Se crea un calendario con las rondas que se llevan a cabo en una determinada
	 * sede
	 * 
	 * @param sede Recibe una sede donde se llevan a cabo rondas
	 * @return Calendario Un cronograma del tipo calendario con la informaci�n
	 *         recolectada de la sede.
	 */
	public Calendario getRonda(Sede sede) {
		Calendario cronogramaSede = new Calendario();
		cronogramaSede.setearVector(fechaInicio, fechaFin);
		int i = 0;
		for (i = 0; i <= cantDias; i++) {
			cronogramaSede.nodos[i] = rondasEnPriv(sede, i);
		}
		return cronogramaSede;
	}

	/**
	 * Obtiene un nodo calendario que tiene informaci�n acerca de una sede en un
	 * determinado d�a
	 * 
	 * @param sede Recibe una sede de la cual se busca obtener informaci�n
	 * @param i    Recibe el d�a
	 * @return NodoCalendario Devuelve un NodoCalendario
	 */
	private NodoCalendario rondasEnPriv(Sede sede, int i) {
		return (nodos[i].getSedeEnNodo(sede));
	}
}
