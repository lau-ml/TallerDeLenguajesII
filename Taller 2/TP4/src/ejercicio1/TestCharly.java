package ejercicio1;

public class TestCharly {
public static void main(String[] args) {
	CharlyGarcía charly=CharlyGarcía.getCharly(60, 1.76, true);
	CharlyGarcía charly2=CharlyGarcía.getCharly(60, 1.76, true);
	System.out.println(charly.equals(charly2));//Al intentar hacer una nueva instancia, ambos terminan siendo la misma instancia en memoria
	charly.cantar();
	charly2.cantar();
}
}
