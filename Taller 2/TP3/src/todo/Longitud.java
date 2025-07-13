package todo;

public class Longitud extends Fundamental {
	private double cant;
	private LongitudMedida medida;
	public double convertirMismasUnidades()
	{
			return cant*medida.multiplicador();
	}
	public double getCant() {
		return cant;
	}
	public void setCant(double cant) {
		this.cant = cant;
	}
	public LongitudMedida getMedida() {
		return medida;
	}
	public void setMedida(LongitudMedida medida) {
		this.medida = medida;
	}
}
