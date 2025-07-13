package tpEntregable1;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

/**
 * La clase Competencia se encarga de representar a cada una de las competencias
 * presentes en cada una de las disciplinas de los Juegos (Ej : 100 metros
 * Llanos de la disciplina Atletismo).Se caracteriza por tener un cronograma
 * propio, el nombre de la Competencia(Evento),su lista de rondas, la disciplina
 * que se realiza y el listado de equipos participantes.
 *
 * @author Lautaro Moller
 * @author Tom�s Mc Nally
 * @version 1.0
 * @since 16-09-2021
 */
public class Competencia {
	private int hombres;
	private int mujeres;
	private int cantRondas;
	private Calendario cronograma;
	private String Evento;
	private ListaGenerica<Ronda> rondas = new ListaGenericaEnlazada<Ronda>();
	private Disciplina disciplina;
	private ListaGenerica<Equipo> participantes = new ListaGenericaEnlazada<Equipo>();

	/**
	 * Este m�todo se encarga de cargar informaci�n acerca del sexo de los
	 * participantes.
	 * 
	 * @see tpEntregable1.Equipo
	 */
	public void cargarAtletas() {
		participantes.comenzar();
		mujeres = 0;
		hombres = 0;
		Equipo aux = new Equipo();
		Atleta atletaAux;
		while (!participantes.fin()) {
			aux = participantes.proximo();
			aux.atletas.comenzar();
			while (!aux.atletas.fin()) {
				atletaAux = aux.atletas.proximo();
				if (atletaAux.getSexo.equals(Masculino))
					hombres++;
				else
					mujeres++;
			}
		}
	}

	/**
	 * Este m�todo se encarga de devolver el cronograma de la competencia
	 * 
	 * @see tpEntregable1.Calendario
	 * @return Calendario El m�todo retorna un Calendario de la competencia.
	 */
	public Calendario getCronograma() {
		return cronograma;
	}

	/**
	 * Este m�todo se encarga de cargar el cronograma de la competencia
	 * 
	 * @see tpEntregable1.Calendario
	 * @param cronograma El m�todo recibe un calendario que tiene solo informaci�n
	 *                   de la competencia
	 */
	public void setCalendario(Calendario cronograma) {
		this.cronograma = cronograma;
	}

	/**
	 * Este m�todo se encarga de devolver la cantidad de hombres que participan en
	 * la competencia
	 * 
	 * @return int El m�todo retorna un entero que representa esta cantidad.
	 */
	public int getHombres() {
		return this.hombres;
	}

	/**
	 * Este m�todo se encarga de devolver la cantidad de mujeres que participan en
	 * la competencia
	 * 
	 * @return int El m�todo retorna un entero que representa esta cantidad.
	 */
	public int getMujeres() {
		return this.mujeres;
	}

	/**
	 * Este m�todo se encarga de devolver la cantidad total de atletas que
	 * participan en la competencia
	 * 
	 * @return int El m�todo retorna un entero que representa esta cantidad.
	 */
	public int getTotalAtletas() {
		return (this.mujeres + this.hombres);
	}

	/**
	 * Este m�todo se encarga de devolver el nombre con el cual se identifica a la
	 * competencia
	 * 
	 * @return String El m�todo retorna el nombre de la competencia.
	 */
	public String getEvento() {
		return Evento;
	}

	/**
	 * Este m�todo se encarga de setear el nombre con el cual se identifica a la
	 * competencia
	 * 
	 * @param evento El m�todo recibe el nombre de la competencia y lo actualiza en
	 *               sus atributos.
	 */
	public void setEvento(String evento) {
		Evento = evento;
	}

	/**
	 * Este m�todo se encarga de devolver el numero de rondas que se realizan en la
	 * competencia
	 * 
	 * @return int El m�todo retorna la cantidad de rondas que se van a realizar a
	 *         lo largo de la competencia.
	 */
	public int getCantRondas() {
		return (rondas.tamanio());
	}

	/**
	 * Este m�todo se encarga de devolver la disciplina de la cual forma parte la
	 * competencia
	 * 
	 * @see tpEntregable1.disciplina
	 * @return Disciplina El m�todo retorna la disciplina
	 */
	public Disciplina getDisciplina() {
		return (disciplina);
	}

	/**
	 * Este m�todo se encarga de devolver la Sede en la cual se realiza una
	 * determinada Ronda de la competencia.
	 * 
	 * @see tpEntregable1.Ronda
	 * @param ronda El m�todo recibe la ronda acerca de la cual quiere conocer la
	 *              Sede
	 * @return Sede El m�todo retorna la Sede correspondiente
	 */
	public Sede getSede(Ronda ronda) {
		rondas.comenzar();
		boolean encontre = false;
		Ronda rondaAux;
		while (!rondas.fin() && !encontre) {
			rondaAux = rondas.proximo();
			if (rondaAux.equals(ronda))
				encontre = true;
		}
		return (rondaAux.getSede());
	}

	/**
	 * Este m�todo se encarga de setear la cantidad de Rondas que debe de tener la
	 * competencia
	 * 
	 * @param cant El m�todo recibe la cantidad mencionada y la almacena.
	 */
	public void setCantRondas(int cant) {
		cantRondas = cant;
	}

	/**
	 * Este m�todo se encarga de devolver si un equipo participo de la final
	 * correspondiente a la competencia
	 * 
	 * @see tpEntregable1.Ronda
	 * @see tpEntregable1.Equipo
	 * @param equipo El m�todo recibe el equipo acerca del cual quiere conocer la
	 *               informaci�n
	 * @return boolean El m�todo retorna True en caso de que el Equipo haya
	 *         participado y False en caso contrario.
	 */
	public boolean esFinalista(Equipo equipo) {
		rondas.comenzar();
		Ronda rondaAux;
		rondaAux = rondas.proximo();
		return (rondaAux.participantes.incluye(equipo));
	}

	/* El nroFase vale 1 y 2 para Final y partido por Bronce respectivamente */
	/**
	 * Este m�todo se encarga de crear una ronda de tipo Puntos en alguna de sus
	 * instancias.
	 * 
	 * @see tpEntregable1.Puntos
	 * @param hora             El m�todo recibe la Hora a la que se va a realizar la
	 *                         Ronda
	 * @param fecha            El m�todo recibe la Fecha a la que se va a realizar
	 *                         la Ronda
	 * @param sede             El m�todo recibe la Sede en la que se va a realizar
	 *                         la Ronda
	 * @param participantes    El m�todo recibe los participantes de la Ronda
	 * @param cantClasificados El m�todo recibe la cantidad de clasificados que debe
	 *                         tener la Ronda
	 * @param nroFase          El m�todo recibe el numero de Fase que representa
	 */
	public void crearRondaPuntos(Hora hora, Fecha fecha, Sede sede, ListaGenerica<Equipo> participantes,
			int cantClasificados, int nroFase) {
		if (nroFase == 1) {
			Ronda rondaAux = new Final();
		} else {
			Ronda rondaAux = new InstanciaPrevia();
			rondaAux.setFase(nroFase);
		}
		rondaAux.setHora(hora);
		rondaAux.setFecha(fecha);
		rondaAux.setSede(sede);
		rondaAux.setParticipantes(participantes);
		rondaAux.setCantClasificados(cantClasificados);
	}

	/**
	 * Este m�todo se encarga de crear una ronda de tipo EliminacionDirecta en
	 * alguna de sus instancias.
	 * 
	 * @see tpEntregable1.Puntos
	 * @param hora          El m�todo recibe la Hora a la que se va a realizar la
	 *                      Ronda
	 * @param fecha         El m�todo recibe la Fecha a la que se va a realizar la
	 *                      Ronda
	 * @param sede          El m�todo recibe la Sede en la que se va a realizar la
	 *                      Ronda
	 * @param participantes El m�todo recibe los participantes de la Ronda
	 * @param nroFase       El m�todo recibe el numero de Fase que representa
	 */
	public void crearRondaEliminacion(Hora hora, Fecha fecha, Sede sede, ListaGenerica<Equipo> participantes,
			int nroFase) {
		if (nroFase == 1) {
			FinalE rondaAux = new FinalE();
		} else {
			if (nroFase == 2) {
				PorBronce rondaAux = new PorBronce();
			} else {
				InstanciaPreviaE rondaAux = new InstanciaPreviaE();
				rondaAux.setFase(nroFase);
			}
		}
		rondaAux.setHora(hora);
		rondaAux.setFecha(fecha);
		rondaAux.setSede(sede);
		rondaAux.setParticipantes(participantes);
	}

	/**
	 * Este m�todo se encarga de armar la Competencia a partir de crear la lista
	 * sucesiva de Rondas utilizando los resultados que le da la misma Ronda,
	 * quedando en 1er lugar de la lista la final, luego el partido por bronce y asi
	 * siguiendo
	 * 
	 */
	public void armarCompetencia() {

	}

}
