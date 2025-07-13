package tpEntregable1;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

/**
 * La clase Juego se encarga de representar de manera abstracta a los 2 tipos de
 * Juego. Esta caracterizada por tener su mascota, su lista de disciplinas, su
 * calendario, sus fechas de inicio y fin ademas de la lista de delegaciones
 * participantes y un ranking pensado para realizarse luego de la finalización
 * de los Juegos.
 * 
 * @author Lautaro Moller
 * @author Tomás Mc Nally
 * @since 16-09-2021
 * @version 1.0
 */
public abstract class Juego {
	private Mascota mascota;
	private ListaGenerica<Disciplina> disciplinas = new ListaGenericaEnlazada<Disciplina>();
	private Calendario calendario;
	private Fecha fechaInicio;
	private Fecha fechaFin;
	private Ranking ranking;
	private ListaGenerica<Delegacion> delegaciones = new ListaGenericaEnlazada<Delegacion>();

	/**
	 * Se encarga de devolver la mascota asignada de los juegos
	 * 
	 * @return Mascota Devuelve mascota
	 */
	public Mascota getMascota() {
		return mascota;
	}

	/**
	 * Se encarga de asignarle a los juegos una mascota
	 * 
	 * @param Recibe la mascota
	 */
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	/**
	 * Obtiene un listado de las disciplinas participantes de los juegos
	 * 
	 * @return ListaGenerica<Disciplina> Devuelve las disciplinas
	 */
	public ListaGenerica<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	/**
	 * Se encarga de asignar las disciplinas a los juegos
	 * 
	 * @param disciplinas recibe un listado de disciplinas
	 */
	public void setDisciplinas(ListaGenerica<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	/**
	 * Obtiene el calendario de los juegos
	 * 
	 * @return Calendario Devuelve el calendario
	 */
	public Calendario getCalendario() {
		return calendario;
	}

	/**
	 * Asigna el calendario recibido
	 * 
	 * @param calendario Recibe el calendario de los juegos
	 */
	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	/**
	 * Obtiene la fecha de inicio de las actividades de los juegos
	 * 
	 * @return Fecha Devuelve la fecha de inicio de los juegos
	 */
	public Fecha getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Asigna la fecha de comienzo de los juegos
	 * 
	 * @param fechaInicio Recibe la fecha inicial
	 */
	public void setFechaInicio(Fecha fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene la fecha de cierre de los juegos
	 * 
	 * @return Fecha Devuelve la fecha final
	 */
	public Fecha getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece la fecha de cierre de los juegos
	 * 
	 * @param fechaFin recibe la fecha final de los juegos
	 */
	public void setFechaFin(Fecha fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtiene la lista de delegaciones participantes
	 * 
	 * @return ListaGeneria<Delegacion> Devuelve las delegaciones
	 */
	public ListaGenerica<Delegacion> getDelegaciones() {
		return delegaciones;
	}

	/**
	 * Asigna las delegaciones participantes de los juegos.
	 * 
	 * @param delegaciones recibe una lista de delegaciones
	 */
	public void setDelegaciones(ListaGenerica<Delegacion> delegaciones) {
		this.delegaciones = delegaciones;
	}

	/**
	 * El método se encarga de crear un rannking según medallas de Oro y según total
	 * de medallas, no recibe ni retorna valores por tratarse de un método que
	 * analiza y organiza información propia.
	 */
	public void crearRanking() {
		ListaGenerica<Delegacion> ordenOro = new ListaGenericaEnlazada<Delegacion>();
		ListaGenerica<Delegacion> ordenTotal = new ListaGenericaEnlazada<Delegacion>();
		this.copiar(ranking.ordenarporOro, ordenOro);
		this.copiar(ranking.ordenarTotal, ordenTotal);
	}

	/**
	 * Obtiene los atletas ganadores de medalla de Oro de los Juegos
	 * 
	 * @return Retorna la lista de atletas ganadores
	 */

	public ListaGenerica<Atleta> getMedallasOro() {
		ListaGenerica<Atleta> atletas = new ListaGenericaEnlazada<Atleta>();
		atletas.comenzar();
		delegaciones.comenzar();
		while (!delegaciones.fin())
			this.agregar(delegaciones.proximo().getMedallasOro(), atletas);
		return atletas;
	}

	/**
	 * Este método se encarga de agregar a una lista de atletas otra lista de
	 * atletas
	 * 
	 * @param listaAux   El método recibe una lista con los atletas a agregar a la
	 *                   listaFinal
	 * @param listaFinal El método recibe la lista de atletas a la cual hay que
	 *                   agregar los atletas pertenecientes a la otra lista
	 */
	private void agregar(ListaGenerica<Atleta> listaAux, ListaGenerica<Atleta> listaFinal) {
		listaAux.comenzar();
		while (!listaAux.fin())
			listaFinal.agregarFinal(listaAux.proximo());
	}

	/**
	 * Devuelve un boolean que indica si el participante compite tanto de forma
	 * individual o grupal
	 * 
	 * @param atleta Recibe un atleta del cual se requiere información
	 * @return boolean Devuelve un boolean que en caso de ser verdadero indica que
	 *         el atleta está compitiendo de forma individual y grupal y falso en
	 *         caso contrario
	 */
	public boolean indYEq(Atleta atleta) {
		return (atleta.estaEnIndividual() && atleta.estaEnEquipo());
	}

	/**
	 * Devuelve la sede en donde se realiza una ronda de una determinada competencia
	 * 
	 * @param competencia Recibe la competencia de la cual se necesita información
	 * @param ronda       Recibe la ronda al cual se le busca la sede
	 * @return Sede Devuelve la sede donde se realiza
	 */
	public Sede sedeRonda(Competencia competencia, Ronda ronda) {
		return competencia.getSede(ronda);
	}

	/**
	 * Devuelve una lista de rondas que se realizan en una fecha en particular
	 * 
	 * @param fecha Se recibe una fecha de la cual se quiere obtener información
	 * 
	 * @return ListaGenerica<Ronda> devuelve las rondas
	 */
	public ListaGenerica<Ronda> competencias(Fecha fecha) {
		return this.calendario.rondas(fecha);
	}

	/**
	 * Se obtiene las rondas realizadas en una determinada sede pasada como
	 * parámetro, en forma de calendario
	 * 
	 * @param sede Recibe una sede en particular
	 * 
	 * @return Calendario Devuelve un calendario
	 */
	public Calendario getCompetencias(Sede sede) {
		return this.calendario.rondasEnSede(sede);
	}

	/**
	 * Este método determina si un Atleta fue o no galardonado con una medalla
	 * 
	 * @param atleta Recibe un atleta
	 * 
	 * @return boolean Devuelve verdadero si el atletaque fue pasado como parametro
	 *         obtuvo medalla, falso en caso contrario
	 */
	public boolean esMedallista(Atleta atleta) {
		return atleta.equipo[0].delegacion.esMedallista(atleta);
	}

	/**
	 * Llama a la competencia para saber si es o no el equipo pasado por parámetro
	 * finalista
	 * 
	 * @param equipo      recibe el equipo del cual se busca saber si es finalista
	 * @param competencia recibe la competencia donde se desempeña el equipo
	 * @return Devuelve verdadero en caso de que el equipo sea finalista o falso en
	 *         caso contrario
	 */
	public boolean esFinalista(Equipo equipo, Competencia competencia) {
		return competencia.esFinalista(equipo, competencia);
	}

	/**
	 * Copia en la lista final, la lista de delegaciones pasada como auxiliar
	 * 
	 * @param listaAux   Recibe una lista con las delegaciones en ranking
	 * 
	 * @param listaFinal recibe una lista final, que se vacía para poder organizar
	 *                   las delegaciones según la auxiliar
	 */
	private void copiar(ListaGenerica<Delegacion> listaAux, ListaGenerica<Delegacion> listaFinal) {
		listaFinal.comenzar();
		while (!listaFinal.fin())
			listaFinal.eliminar(listaFinal.proximo());
		listaAux.comenzar();
		while (!listaAux.fin())
			listaFinal.agregarFinal(listaAux.proximo());
	}

	/**
	 * El método se encarga de setear la cantidad de rondas de una competencia
	 * perteneciente a una disciplina
	 * 
	 * @see tpEntregable1.Disciplina
	 * @param disciplina  Recibe la diciplina
	 * @param competencia Recibe la competencia
	 * @param cant        Recibe el numero de rondas que debe tener
	 */
	public void setCantRondas(Disciplina disciplina, Competencia competencia, int cant) {
		disciplina.setCantRondas(competencia, cant);
	}

	/**
	 * El método se encarga de devolver el ranking Oro creado por Ranking
	 * 
	 * @see Ranking
	 * @return Delegacion Retorna el ranking
	 */
	public Delegacion getRankingOro() {
		return (Ranking.getRankingOro());
	}

	/**
	 * El método se encarga de devolver el ranking Total creado por Ranking
	 * 
	 * @see Ranking
	 * @return Delegacion Retorna el ranking
	 */
	public Delegacion getRankingTotal() {
		return (Ranking.getRankingTotal());
	}
}