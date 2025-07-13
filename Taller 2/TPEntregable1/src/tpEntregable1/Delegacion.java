 package tpEntregable1;

public class Delegacion {
	
	private MedalleroDelagacion medallero;
	private Atleta capitan;
	private ListaGenerica<Pais> paises= new ListaGenericaEnlazada<Pais>();
	private ListaGenerica<Equipo> equipos = new ListaGenericaEnlazada<Equipo>();
	
	public ListaGenerica<Atleta> getMedallasOro ();
	
	{
		return this.medallero.getMedallistasOro();
	}
	
	public int getCantidadOro () {
		return this.medallero.getCantidadOro();
	}
	
	public int getCantidadPlata ()
	{
		return this.medallero.getCantidadPlata();
	}
	public int getCantidadBronce ()
	{
		return this.medallero.getCantidadOro();
	}
	public int getCantidadTotalMedallas ()
	{
		return this.getCantidadBronce() + this.getCantidadOro() +this.getCantidadBronce();
	}
	public void  inscribirAtleta(Atleta atleta)
	{	equipos.comenzar();
		this.equipos.proximo().addAtleta(atleta);
	}
	public boolean indYEq (Atleta atleta) 
	{	boolean cumple=false;
		equipos.comenzar();
		Equipo aux= new Equipo();
		Atleta atletaAux;
		while (!equipos.fin() && !cumple)
		{	aux=equipos.proximo();
			aux.atletas.comenzar();
			while (!aux.atletas.fin() && !cumple)
				{auxAtleta=aux.atletas.proximo();
			 if(auxAtleta.equals(atleta))
						 if (estaEnIndividual && estaEnEquipo)
							 cumple=true;
	}
		return cumple;
	}
	}
	public boolean esMedallista (Atleta atleta)
	{
		this.medallero.esMedallista(atleta);
	}
	public void cargarOro(Equipo equipo)
	{
		this.medallero.addOro(Equipo equipo);
	}
	public void cargarPlata(Equipo equipo) 
	{
		this.medallero.addPlata(Equipo equipo);
	}
	public void cargarBronce (Equipo equipo)
	{
		this.medallero.addBronce(Equipo equipo);
	}
}
