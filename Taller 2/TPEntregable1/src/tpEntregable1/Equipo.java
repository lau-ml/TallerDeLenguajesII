package tpEntregable1;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
/**
 * Esta clase busca representar a cada uno de los equipos participantes de cada delegaci�n. Esta tiene por tanto, una lista de atletas, una
 * delegaci�n a la cual representa y puede llegar a tener o no un entrenador . El equipo, tambi�n representa a aquellos atletas que compiten
 * de forma individual. Es decir, un deportista que compite solo en Judo, se considera como un equipo de 1 integrante
 * @author Lautaro Moller
 * @author Tom�s Mc Nally
 * @since 16-09-2021
 * @version 1.0
 */
public class Equipo {
	private ListaGenerica<Atleta> atletas= new ListaGenericaEnlazada<Atleta>();
	private  Delegacion delegacion;
	private  Entrenador entrenador;
	
	/**
	 * El m�todo se encarga de devolver la cantidad de atletas que forman el equipo
	 * @return Devuelve el tama�o de la lista de atletas
	 */
	public int getCantAtletas() {
		return (atletas.tamanio());
	}
	
	/**
	 * Obtiene los atletas que forman el equipo
	 * @return Devuelve la lista de atletas
	 */
	public ListaGenerica<Atleta> getEquipo() {
		return atletas;
	}

	/**
	 *  Asigna a la lista que maneja una dada lista de atletas
	 * @param atletas Recibe una lista de atletas
	 */
	public void setEquipo(ListaGenerica<Atleta> atletas) {
		this.atletas = atletas;
	}
	/** 
	 * Se obtiene la delegaci�n a la que representa
	 * @return Devuelve una delegaci�n
	 */
	public Delegacion getDelegacion() {
		return delegacion;
	}
	/**
	 * Asigna la delegaci�n recibida como par�metro
	 * @param delegacion Recibe una delegaci�n
	 */
	public void setDelegacion(Delegacion delegacion) {
		this.delegacion = delegacion;
	}
	/**
	 * Se asocia al equipo el entrenador recibido.
	 * @param entrenador Recibe un entrenador
	 */
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	/**
	 * Indica si el equipo tiene entrenador
	 * @return En caso de que haya un entrenador, lo devuelve, en caso contrario devuelve null 
	 */
	public Entrenador getEntrenador() {
		return entrenador;
	}
	/**
	 * Inscribe un atleta dentro de la lista de atletas que maneja este equipo
	 * @param atleta Recibe un determinado atleta
	 * @return Devuelve verdadero en caso de que se haya podido inscribir, falso en caso contrario
	 */
	public boolean addAtleta (Atleta atleta) {
		return (atletas.agregarInicio(atleta));
	}
	
	/**
	 * Elimina un atleta que est� en el equipo de la lista de atletas
	 * @param atleta Recibe un determinado atleta
	 * @return Devuelve verdadero en caso de que se haya podido eliminar correctamente de la lista
	 */
	public boolean subAtleta (Atleta atleta) {
		return (atletas.eliminar(atleta));
	}
	/**
	 * Indica si el equipo tiene o no un entrenador
	 * @return  Devuelve true en caso de que est� asignado un entrenador, falso en caso contrario
	 */

	public boolean hayEntrenador () {
		return (entrenador!=null);
	}
	/**
	 * Indica si el equipo est� conformado por un solo atleta
	 * @return Devuelve el tama�o de la lista de atletas
	 */
	
	public boolean esIndividual () {
		return (atletas.tamanio()==1);
	}

}
