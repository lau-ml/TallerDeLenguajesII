package ejercicio1;

public class CharlyGarc�a {

	private static CharlyGarc�a charly;
	private int edad;
	private double altura;
	private boolean solista;

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public boolean isSolista() {
		return solista;
	}

	public void setSolista(boolean solista) {
		this.solista = solista;
	}

	public static CharlyGarc�a getCharly(int edad, double altura, boolean solista) {
		if (charly == null)
			charly = new CharlyGarc�a(edad, altura, solista);
		return charly;
	}

	private CharlyGarc�a(int edad, double altura, boolean solista) {
		this.edad = edad;
		this.altura = altura;
		this.solista = solista;
	}

	public void cantar() {
		System.out.println("Charly Garcia est� cantando");
	}
}
