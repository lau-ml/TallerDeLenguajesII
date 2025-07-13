package tpEntregable1;

public class Disciplina {
	
	private ListaGenerica<Competencia> competencias= new ListaGenericaEnlazada<Competencia>();
	private String nombre; 
	private  int mujeres;
	private  int hombres;
	private Tipo tipo;
	private Regularidad regularidad;
	
	public boolean esUltimaVez() {
		return (this.regularidad.equals(regularidad.UltimaVez));
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setMujeres() {
	competencias.comenzar();
	int cantMujeres=0;
		while (!competencias.fin())
			cantMujeres+=competencias.proximo().getHombres();
	this.mujeres=cantMujeres;		
	}
	
	public Sede getSede(Competencia competencia, Ronda ronda)
	{
		return competencia.getSede(sede);
	}
	
	public void setHombres() {
		competencias.comenzar();
		int cantHombres=0;
		while (!competencias.fin())
			cantHombres+=competencias.proximo().getHombres();
		this.hombres=cantHombres;
	}
	public int getTotalAtletas ()
	{
		return (this.mujeres+this.hombres);
	}
	public int getHombres()
	{
		return this.hombres;
	}
	public int getMujeres()
	{
		return this.mujeres;
	}
	public void setTipo(Tipo tipo)
	{
		this.tipo=tipo;
	}
	public boolean daMedalla()
	{
		return (this.regularidad.equals(regularidad.Medalla));
	}
	public boolean esFinalista(Equipo equipo, Competencia competencia)
	{
		return competencia.esFinalista(equipo);
	}
}