package todo;

public class Tiempo extends Fundamental {
	private double cant;
	private TiempoMedida medida;
	@Override
	public double convertirMismasUnidades() {
		
		return 0;
	}
	public double getCant() {
		return cant;
	}
	public void setCant(double cant) {
		this.cant = cant;
	}
	public TiempoMedida getMedida() {
		return medida;
	}
	public void setMedida(TiempoMedida medida) {
		this.medida = medida;
	}

	
}
