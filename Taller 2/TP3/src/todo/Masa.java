package todo;

public class Masa extends Fundamental {
private double cant;
private MasaMedida medida;

@ Override
public double convertirMismasUnidades()
{
	return 4;
}


public double getCant() {
	return cant;
}


public void setCant(double cant) {
	this.cant = cant;
}


public MasaMedida getMedida() {
	return medida;
}


public void setMedida(MasaMedida medida) {
	this.medida = medida;
}
}

