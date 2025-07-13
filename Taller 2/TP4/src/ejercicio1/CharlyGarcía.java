package ejercicio1;

public class CharlyGarcía {

	private static CharlyGarcía charly;
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

	public static CharlyGarcía getCharly(int edad, double altura, boolean solista) {
		if (charly == null)
			charly = new CharlyGarcía(edad, altura, solista);
		return charly;
	}

	private CharlyGarcía(int edad, double altura, boolean solista) {
		this.edad = edad;
		this.altura = altura;
		this.solista = solista;
	}

	public void cantar() {
		System.out.println("Charly Garcia está cantando");
	}
}
