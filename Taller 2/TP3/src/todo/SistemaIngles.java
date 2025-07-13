package todo;

public abstract class SistemaIngles extends Sistema{
	public abstract double convertirMismasUnidades();
	public double devolverSuma (SistemaIngles sistema1, SistemaIngles sistema2)
	{
		return sistema2.convertirMismasUnidades()+sistema1.convertirMismasUnidades();
	}
}
