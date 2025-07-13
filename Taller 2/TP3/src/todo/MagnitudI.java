package todo;

public class MagnitudI extends SistemaIngles{
	private double cant;
	private MagnitudIng magnitudInglesa;
	
	public double getCant() {
		return cant;
	}
	public void setCant(double cant) {
		this.cant = cant;
	}
	public MagnitudIng getMagnitudInglesa() {
		return magnitudInglesa;
	}
	public void setMagnitudInglesa(MagnitudIng magnitudInglesa) {
		this.magnitudInglesa = magnitudInglesa;
	}

	public  double convertirMismasUnidades()
	{
		return (cant*magnitudInglesa.multiplicador()/3.281);
	
	}
}
