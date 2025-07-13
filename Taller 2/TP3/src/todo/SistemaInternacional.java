package todo;

public abstract class SistemaInternacional extends Sistema {
	public abstract double convertirMismasUnidades();
	public double devolverSuma(SistemaInternacional sistema1, SistemaInternacional sistema2)
	{
		return (sistema1.convertirMismasUnidades()+sistema2.convertirMismasUnidades());
	}
}
