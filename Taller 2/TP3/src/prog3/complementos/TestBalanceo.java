package prog3.complementos;

import prog3.util.*;

public class TestBalanceo {
	public static void main(String[] args) {
		String caract = "{[()()()()()]}";
		Pila<Character> pila = new Pila<Character>();
		if (Balanceado(caract, pila) == true)
			System.out.println("Esta bien balanceado");
		else
			System.out.println("No esta bien balanceado");
	}

	public static boolean Balanceado(String caract, Pila<Character> pila) {

		boolean balanced = true;
		boolean parentDesap = true;
		boolean corcheteDesap = true;
		char caracter = 'a';
		int i = 0;
		while (i < caract.length() && balanced == true) {
			if (caract.charAt(i) == '(') {
				if (caracter != '(') {
					parentDesap = false;
					pila.apilar('(');
					caracter = '(';
				} else
					balanced = false;
			} else if ((caract.charAt(i) == ')')) {
				if (!pila.esVacia()) {
					pila.desapilar();
					parentDesap = true;
					caracter = ')';
				} else
					balanced = false;
			} else if (parentDesap) {
				if (caract.charAt(i) == '[') {
					if (caracter != '[') {
						pila.apilar('[');
						caracter = '[';
						corcheteDesap = false;
					} else
						balanced = false;
				} else if (caract.charAt(i) == ']') {
					if (!pila.esVacia()) {
						caracter = ']';
						pila.desapilar();
						corcheteDesap = true;
					} else
						balanced = false;
				} else if (corcheteDesap) {
					if (caract.charAt(i) == '{')
						if (caracter != '{') {
							pila.apilar('{');
							caracter = '{';
						} else
							balanced = false;
					else if (caract.charAt(i) == '}')
						if (!pila.esVacia()) {
							pila.desapilar();
							caracter = ']';
						} else
							balanced = false;
				} else
					balanced = false;
			} else
				balanced = false;
			i++;
		}
		if (pila.esVacia() != true)
			balanced = false;
		return balanced;
	}
}
