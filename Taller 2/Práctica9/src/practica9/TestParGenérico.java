package practica9;

public class TestParGenérico {
public static void main(String[] args) {
	ParGenérico <String, Integer> par= new ParGenérico<String, Integer>();
	par.setX("HOLA");
	par.setY(1);
	System.out.println(par.getX());
	System.out.println(par.getY());
}
}
