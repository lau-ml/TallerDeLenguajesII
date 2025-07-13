package todo;

public abstract class Sistema {
	
public abstract double convertirMismasUnidades();

public double devolverEnMetros(Sistema sistema)
{
	return sistema.convertirMismasUnidades();
}
public double sumaEntreSistemas(SistemaInternacional internacional, SistemaIngles ingles)
{
	return internacional.convertirMismasUnidades()+ingles.convertirMismasUnidades();
}
}
