package ejercicio1;

public class TestCharly {
public static void main(String[] args) {
	CharlyGarc�a charly=CharlyGarc�a.getCharly(60, 1.76, true);
	CharlyGarc�a charly2=CharlyGarc�a.getCharly(60, 1.76, true);
	System.out.println(charly.equals(charly2));//Al intentar hacer una nueva instancia, ambos terminan siendo la misma instancia en memoria
	charly.cantar();
	charly2.cantar();
}
}
