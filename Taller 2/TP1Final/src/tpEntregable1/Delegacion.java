package tpEntregable1;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

/**
 * La clase Delegacion se encarga de representar a cada una de las delegaciones
 * participantes en los Juegos.Se caracteriza por tener su propio pa�s
 * representado, su capit�n, su medallero y los equipos que la conforman.
 *
 * @author Lautaro Moller
 * @author Tom�s Mc Nally
 * @version 1.0
 * @since 16-09-2021
 */

public class Delegacion {

	private MedalleroDelegacion medallero;
	private Atleta capitan;
	private Pais pais;
	private ListaGenerica<Equipo> equipos = new ListaGenericaEnlazada<Equipo>();

	/**
	 * Este m�todo se encarga de buscar y devolver los atletas ganadores de medalla
	 * de oro pertenecientes a la delegacion.
	 * 
	 * @see tpEntregable1.MedalleroDelegacion
	 * @param void El m�todo no recibe ning�n parametro ya que se basa en analizar
	 *             datos ya almacenados bajo un criterio constante
	 * @return ListaGenerica<Atleta> El m�todo retorna una lista de los atletas que
	 *         consiguieron obtener una medalla de Oro
	 */
	public ListaGenerica<Atleta> getMedallasOro() {
		return this.medallero.getMedallistasOro();
	}

	/**
	 * Este m�todo se encarga de devolver la cantidad de medallas de oro obtenidas
	 * por la delegaci�n
	 * 
	 * @see tpEntregable1.MedalleroDelegacion
	 * @param void El m�todo no recibe ning�n parametro ya que se basa en analizar
	 *             datos ya almacenados bajo un criterio constante
	 * @return int El m�todo retorna la cantidad de medallas de oro obtenidas
	 */
	public int getCantidadOro() {
		return this.medallero.getCantidadOro();
	}

	/**
	 * Este m�todo se encarga de devolver la cantidad de medallas de plata obtenidas
	 * por la delegaci�n
	 * 
	 * @see tpEntregable1.MedalleroDelegacion
	 * @param void El m�todo no recibe ning�n parametro ya que se basa en analizar
	 *             datos ya almacenados bajo un criterio constante
	 * @return int El m�todo retorna la cantidad de medallas de plata obtenidas
	 */
	public int getCantidadPlata() {
		return this.medallero.getCantidadPlata();
	}

	/**
	 * Este m�todo se encarga de devolver la cantidad de medallas de bronce
	 * obtenidas por la delegaci�n
	 * 
	 * @see tpEntregable1.MedalleroDelegacion
	 * @param void El m�todo no recibe ning�n parametro ya que se basa en analizar
	 *             datos ya almacenados bajo un criterio constante
	 * @return int El m�todo retorna la cantidad de medallas de bronce obtenidas
	 */
	public int getCantidadBronce() {
		return this.medallero.getCantidadOro();
	}

	/**
	 * Este m�todo se encarga de devolver la cantidad total de medallas obtenidas
	 * por la delegaci�n
	 * 
	 * @see tpEntregable1.MedalleroDelegacion
	 * @param void El m�todo no recibe ning�n parametro ya que se basa en analizar
	 *             datos ya almacenados bajo un criterio constante
	 * @return int El m�todo retorna la cantidad total de medallas obtenidas
	 */
	public int getCantidadTotalMedallas() {
		return (this.getCantidadOro() + this.getCantidadPlata() + this.getCantidadBronce());
	}

	/**
	 * Este m�todo se encarga de determinar si un atleta participa en los Juegos de
	 * forma individual como tambi�n en equipo.
	 * 
	 * @see tpEntregable1.Equipo
	 * @see tpEntregable1.Atleta
	 * @param atleta Es el unico parametro que recibe y representa al atleta que
	 *               queremos conocer su situaci�n.
	 * @return boolean El m�todo retorna True en caso de que participe tanto
	 *         individualmente como en equipo y False en caso contrario.
	 */
	public boolean indYEq(Atleta atleta) {
		boolean cumple = false;
		equipos.comenzar();
		Equipo aux = new Equipo();
		Atleta atletaAux;
		while (!equipos.fin() && !cumple) {
			aux = equipos.proximo();
			aux.atletas.comenzar();
			while (!aux.atletas.fin() && !cumple) {
				atletaAux = aux.atletas.proximo();
				if (atletaAux.equals(atleta))
					if ((atletaAux.estaEnIndividual) && (atletaAux.estaEnEquipo()))
						cumple = true;
			}
		}
		return cumple;
	}

	/**
	 * Este m�todo se encarga de determinar si un atleta consiguio una Medalla en
	 * los Juegos
	 * 
	 * @see tpEntregable1.MedalleroDelegacion
	 * @param atleta Es el unico parametro que recibe y representa al atleta que
	 *               queremos conocer su situaci�n.
	 * @return boolean El m�todo retorna True en caso de que haya ganado una medalla
	 *         y False en caso contrario.
	 */
	public boolean esMedallista(Atleta atleta) {
		return (this.medallero.esMedallista(atleta));
	}

	/**
	 * Este m�todo se encarga de cargar un equipo ganador de medalla de oro en el
	 * medallero de la delegacion
	 * 
	 * @see tpEntregable1.MedalleroDelegacion
	 * @param equipo Es el unico parametro que recibe y representa al equipo ganador
	 *               de la medalla
	 */
	public void cargarOro(Equipo equipo) {
		this.medallero.addOro(equipo);
	}

	/**
	 * Este m�todo se encarga de cargar un equipo ganador de medalla de plata en el
	 * medallero de la delegacion
	 * 
	 * @see tpEntregable1.MedalleroDelegacion
	 * @param equipo Es el unico parametro que recibe y representa al equipo ganador
	 *               de la medalla
	 */
	public void cargarPlata(Equipo equipo) {
		this.medallero.addPlata(equipo);
	}

	/**
	 * Este m�todo se encarga de cargar un equipo ganador de medalla de bronce en el
	 * medallero de la delegacion
	 * 
	 * @see tpEntregable1.MedalleroDelegacion
	 * @param equipo Es el unico parametro que recibe y representa al equipo ganador
	 *               de la medalla
	 */
	public void cargarBronce(Equipo equipo) {
		this.medallero.addBronce(equipo);
	}
}