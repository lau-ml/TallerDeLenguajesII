package practica9;

public class TestParGen�rico {
public static void main(String[] args) {
	ParGen�rico <String, Integer> par= new ParGen�rico<String, Integer>();
	par.setX("HOLA");
	par.setY(1);
	System.out.println(par.getX());
	System.out.println(par.getY());
}
}
