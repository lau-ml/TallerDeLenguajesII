package unlp.info.reinoanimal;

public class Perro extends Animal {
	@Override
	protected void saludo() {// No puede declararse como package. Se estar�a perdiendo visibilidad
	System.out.println("Guau!");
	}
}
