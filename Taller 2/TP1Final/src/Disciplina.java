package tpEntregable1;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

/**
 * La clase Disciplina se encarga de representar a cada una de las disciplinas
 * participantes en los Juegos.Se caracteriza por tener su conjunto de
 * competencias, su nombre, cantidad de hombres y mujers participantes adem�s de
 * un Tipo y Regularidad
 *
 * @author Lautaro Moller
 * @author Tom�s Mc Nally
 * @version 1.0
 * @since 16-09-2021
 */
public class Disciplina {
	private ListaGenerica<Competencia> competencias = new ListaGenericaEnlazada<Competencia>();
	private String nombre;
	private int mujeres;
	private int hombres;
	private Tipo tipo;
	private Regularidad regularidad;

	/**
	 * La clase enumerativa Tipo se encarga de representar si la disciplina entrega
	 * o no medalla en los Juegos
	 */
	enum Tipo {
		Medalla, Exhibicion;
	}

	/**
	 * La clase enumerativa Regularidad se encarga de representar si la disciplina
	 * se realiza por �ltima vez en estos juegos o va a continuar realizandose
	 */
	enum Regularidad {
		Regular, UltimaVez;
	}

	/**
	 * Este m�todo se encarga de determinar si la disciplina se realiza o no por
	 * ultima vez
	 * 
	 * @return boolean El m�todo retorna True si es la utimas vez que se realiza y
	 *         False en caso contrario
	 */
	public boolean esUltimaVez() {
		return (this.regularidad.equals(Regularidad.UltimaVez));
	}

	/**
	 * Este m�todo se encarga de devolver el nombre por el que se conoce a la
	 * disciplina
	 * 
	 * @return String El m�todo retorna el nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este m�todo se encarga de setear el nombre por el que se va a conocer a la
	 * disciplina
	 * 
	 * @param String El m�todo recibe un String con el nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este m�todo se encarga de cargar los atributos relacionados a la cantidad de
	 * atletas de la disciplina
	 * 
	 * @see tpEntregable1.Competencia
	 */
	public void cargarCantidadesAtletas() {
		competencias.comenzar();
		Competencia aux = new Competencia();
		mujeres = 0;
		hombres = 0;

		while (!competencias.fin()) {
			aux = competencias.proximo();
			mujeres += aux.getMujeres();
			hombres += aux.getHombres();
		}
	}

	/**
	 * Este m�todo se encarga de devolver la Sede en la cual se desarrolla una
	 * determinada Ronda de una Competencia
	 * 
	 * @param competencia El m�todo recibe la competencia en la cual buscar la Ronda
	 * @param ronda       El m�todo recibe la Ronda de la cual queremos conocer la
	 *                    Sede
	 * @return Sede El m�todo retorna la Sede buscada.
	 */
	public Sede getSede(Competencia competencia, Ronda ronda) {
		return competencia.getSede(ronda);
	}

	/**
	 * Este m�todo se encarga de devolver el total de Atletas que participan en la
	 * disciplina
	 * 
	 * @return int El m�todo retorna la cantidad buscada.
	 */
	public int getTotalAtletas() {
		return (this.mujeres + this.hombres);
	}

	/**
	 * Este m�todo se encarga de devolver la cantidad de hombres participantes en la
	 * disciplina
	 * 
	 * @return int El m�todo retorna la cantidad buscada.
	 */
	public int getHombres() {
		return this.hombres;
	}

	/**
	 * Este m�todo se encarga de devolver la cantidad de mujeres participantes en la
	 * disciplina
	 * 
	 * @return int El m�todo retorna la cantidad buscada.
	 */
	public int getMujeres() {
		return this.mujeres;
	}

	/**
	 * Este m�todo se encarga de setear el tipo de la disciplina (Entrega medalla o
	 * es de exhibici�n)
	 * 
	 * @param tipo El m�todo recibe el tipo del cual debe ser la disciplina
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * Este m�todo se encarga de determinar si la disciplina da o no medalla
	 * 
	 * @return boolean El m�todo retorna True si la disciplina da medalla y False en
	 *         caso contrario
	 */
	public boolean daMedalla() {
		return (this.tipo.equals(Tipo.Medalla));
	}

	/**
	 * Este m�todo se encarga de determinar si un equipo fue finalista o no en una
	 * determinada competencia de la disciplina
	 * 
	 * @param equipo      El m�todo recibe el equipo acerca del cual se quiere
	 *                    conocer la informaci�n
	 * @param competencia El m�todo recibe la competencia en la cual queremos saber
	 *                    si el equipo fue finalista
	 * @return boolean El m�todo retorna True si el equipo fue finalista y False en
	 *         caso contrario
	 */
	public boolean esFinalista(Equipo equipo, Competencia competencia) {
		return competencia.esFinalista(equipo);
	}

	/**
	 * Este m�todo se encarga de setear la cantidad de rondas que debe tener una
	 * competencia de la disciplina.
	 * 
	 * @param competencia El m�todo recibe la competencia a la cual hay que setearle
	 *                    la cantidad de rondas que la conforman.
	 * @param cant        El m�todo recibe la cantidad susodicha.
	 */
	public void setCantRondas(Competencia competencia, int cant) {
		competencia.setCantRondas(cant);
	}
}
