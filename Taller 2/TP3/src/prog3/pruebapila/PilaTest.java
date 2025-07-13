package prog3.pruebapila;
import prog3.util.*;
public class PilaTest {
public static void main(String[] args) {
	Pila<Character> pila1=new Pila<Character>();
	pila1.apilar('a');
	pila1.apilar('b');
	pila1.apilar('c');
	pila1.apilar('d');
	pila1.apilar('e');
	pila1.desapilar();
	pila1.desapilar();
	pila1.desapilar();
	pila1.desapilar();
	System.out.print(pila1.tope());
}
}
