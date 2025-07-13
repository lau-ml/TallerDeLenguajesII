package tpEntregable1;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

/**
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
 * @return Devuelve mascota
 */

public Mascota getMascota() {
	return mascota;
}
/**
 * Se encarga de asignarle a los juegos una mascota
 * @param Recibe la mascota
 */
public void setMascota(Mascota mascota) {
	this.mascota = mascota;
}
/**
 * Obtiene un listado de las disciplinas participantes de los juegos
 * @return Devuelve las disciplinas
 */
public ListaGenerica<Disciplina> getDisciplinas() {
	return disciplinas;
}
/**
 * Se encarga de asignar las disciplinas a los juegos
 * @param disciplinas recibe un listado de disciplinas
 */
public void setDisciplinas(ListaGenerica<Disciplina> disciplinas) {
	this.disciplinas = disciplinas;
}
/**
 * Obtiene el calendario de los juegos
 * @return Devuelve el calendario
 */
public Calendario getCalendario() {
	return calendario;
}
/**
 * Asigna el calendario recibido
 * @param calendario Recibe el calendario de los juegos
 */
public void setCalendario(Calendario calendario) {
	this.calendario = calendario;
}
/**
 * Obtiene la fecha de inicio de las actividades de los juegos
 * @return Devuelve la fecha de inicio de los juegos
 */
public Fecha getFechaInicio() {
	return fechaInicio;
}

/**
 * Asigna la fecha de comienzo de los juegos
 * @param fechaInicio Recibe la fecha inicial
 */
public void setFechaInicio(Fecha fechaInicio) {
	this.fechaInicio = fechaInicio;
}

/**
 * Obtiene la fecha de cierre de los juegos
 * @return Devuelve la fecha final
 */
public Fecha getFechaFin() {
	return fechaFin;
}
/**
 * Establece la fecha de cierre de los juegos
 * @param fechaFin recibe la fecha final de los juegos
 */
public void setFechaFin(Fecha fechaFin) {
	this.fechaFin = fechaFin;
}
/**
 * Obtiene la lista de delegaciones participantes
 * @return Devuelve las delegaciones
 */
public ListaGenerica<Delegacion> getDelegaciones() {
	return delegaciones;
}
/**
 * Asigna las delegaciones participantes de los juegos.
 * @param delegaciones recibe una lista de delegaciones
 */
public void setDelegaciones(ListaGenerica<Delegacion> delegaciones) {
	this.delegaciones = delegaciones;
}

public void crearRanking() {
	ListaGenerica<Delegacion> ordenOro= new ListaGenericaEnlazada<Delegacion>();
	ListaGenerica<Delegacion> ordenTotal= new ListaGenericaEnlazada<Delegacion>();
	this.copiar(ranking.ordenarporOro,ordenOro);
	this.copiar(ranking.ordenarTotal,ordenTotal);
}
/**
 * Obtiene las medallas
 * @return Retorna una lista de atletas
 */

public ListaGenerica<Atleta> getMedallasOro ()
{ ListaGenerica<Atleta> atletas= new ListaGenericaEnlazada<Atleta>();
atletas.comenzar();
delegaciones.comenzar();
while (!delegaciones.fin())
		this.agregar(delegaciones.proximo().getMedallasOro(),atletas);
return atletas;
}

private void agregar(ListaGenerica<Atleta> listaAux, ListaGenerica<Atleta> listaFinal) {
	listaAux.comenzar();
    while (!listaAux.fin())
        listaFinal.agregarFinal(listaAux.proximo());
}
/**
 * Devuelve un boolean que indica si el participante compite tanto de forma individual o grupal
 * @param atleta Recibe un atleta del cual se requiere información
 * @return Devuelve un boolean que en caso de ser verdadero indica que el atleta está compitiendo de forma individual y grupal
 */
public boolean indYEq(Atleta atleta) {
	return (atleta.estaEnIndividual() && atleta.estaEnEquipo());
}
/**
 * Devuelve la sede en donde se realiza una ronda de una determinada competencia
 * @param competencia recibe la competencia de la cual se necesita información
 * @param ronda recibe la ronda al cual se le busca la sede
 * @return
 */
public Sede sedeRonda (Competencia competencia,Ronda ronda)
{
	return competencia.getSede(ronda);
}
/**
 * Devuelve una lista de rondas que se obtienen a partir de una fecha en particular
 * @param fecha Se recibe una fecha de la cual se quiere obtener información
 * @return devuelve las rondas
 */
public ListaGenerica<Ronda> competencias (Fecha fecha)
{
	return this.calendario.rondas(fecha);
}
/**
 * Se obtiene las rondas realizadas en una determinada sede pasada como parámetro, en forma de calendario
 * @param sede Recibe una sede en particular
 * @return Devuelve un calendario
 */
public Calendario getCompetencias (Sede sede)
{
	return this.calendario.rondasEnSede(sede);
}
/**
 * Va llamando desde atleta, pasando por equipo hasta la delegación para preguntar si es que el atleta que se pasó por parámetro fue premiado con medallas.
 * @param atleta Recibe un atleta
 * @return Devuelve verdadero si el atleta pasado como parametro obtuvo medalla, falso en caso contrario
 */
public boolean esMedallista (Atleta atleta)
{
	return atleta.equipo[0].delegacion.esMedallista(atleta);
}
/**
 * Llama a la competencia para saber si es o no el equipo pasado por parámetro finalista
 * @param equipo recibe el equipo del cual se busca saber si es finalista
 * @param competencia recibe la competencia donde se desempeña el equipo
 * @return Devuelve verdadero en caso de que el equipo sea finalista o falso en caso contrario
 */
public boolean esFinalista (Equipo equipo, Competencia competencia)
{
	return competencia.esFinalista(equipo,competencia);
}
/**
 * Copia en la lista final, la lista de delegaciones pasada como auxiliar
 * @param listaAux Recibe una lista con las delegaciones en ranking
 * @param listaFinal recibe una lista final, que se vacía para poder organizar las delegaciones según la auxiliar
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
 * 
 * @param disciplina
 * @param competencia
 * @param cant
 */
public void setCantRondas(Disciplina disciplina, Competencia competencia, int cant) {
    disciplina.setCantRondas(competencia, cant);
}
}
