package ejercicio1;

public class TestString {
	/*DIFERENCIAS ENTRE STRING, STRINGBUILDER Y STRINGBUFFER

	Vamos a enumerar las principales diferencias entre estas tres clases:

	- StringBuffer y StringBuilder son mutables, mientras que String es inmutable. Cada vez que modificamos un String se crea un objeto nuevo. Esto no ocurre con StringBuffer y StringBuilder.

	- Los objetos String se almacenan en el Constant String Pool que es un repositorio o almacén de cadenas, de valores de Strings. Esto se hace  con el fin de que si creamos otro String, con el mismo valor, no se cree un nuevo objeto sino que se use el mismo y se asigne una referencia al objeto ya creado. Los objetos StringBuffer y StringBuilder se almacenan en el heap que es otro espacio de memoria usado en tiempo de ejecución para almacenar las instancias de clases, objetos y arrays. Realmente no nos interesa entrar a nivel de detalle en estas diferencias: simplemente, recordar que los objetos String tienen diferente tratamiento que los StringBuffer y StringBuilder.

	- La  implementación de la clase StringBuffer  es synchronized (sincronizada) mientras StringBuilder no.

	- El operador de concatenación “+” es implementado internamente por Java usando StringBuilder.

	 

	 

	CRITERIOS PARA USAR STRING, STRINGBUILDER O STRINGBUFFER

	¿Cómo decidir qué clase usar? Normalmente usaremos la clase String. No obstante, en algunos casos puede ser de interés usar StringBuffer o StringBuilder. A continuación damos algunas indicaciones útiles para elegir:

	- Si el valor del objeto no va a cambiar o va a cambiar poco, entonces es mejor usar String, la clase más convencional para el trabajo con cadenas.

	- Si el valor del objeto puede cambiar gran número de veces y puede ser modificado por más de un hilo (thread) la mejor opción es StringBuffer porque es thread safe (sincronizado). Esto asegura que un hilo no puede modificar el StringBuffer que está siendo utilizado por otro hilo.

	- Si el valor del objeto puede cambiar gran número de veces y solo será modificado por un mismo hilo o thread (lo más habitual), entonces usamos StringBuilder, ya que al no ser sincronizado es más rápido y tiene mejor rendimiento. El propio api de Java recomienda usar StringBuilder con preferencia sobre StringBuffer, excepto si la situación requiere sincronización. En esencia la multitarea (trabajar con varios thread) nos permite ejecutar varios procesos a la vez “en paralelo”. Es decir, de forma concurrente y por tanto eso nos permite hacer programas que se ejecuten en menor tiempo y sean más eficientes. Es*/
	public Integer num = 5;
	public Integer numMax = 10;

	public static void main(String[] args) {
		System.out.println("Evaluaci�n del tiempo de ejecuci�n de concatenaciones...");

		long start = 0L;
		long end = 0L;
		String s1 = "�Cual ";
		String s2 = "de ";
		String s3 = "todos ";
		String s4 = "ejecuta ";
		String s5 = "mas ";
		String s6 = "rapido? ";

		start = System.currentTimeMillis();
		concat1(s1, s2, s3, s4, s5, s6);
		end = System.currentTimeMillis();
		System.out.println("Concat de String:::::" + (end - start) + " ms");

		start = System.currentTimeMillis();
		concat2(s1, s2, s3, s4, s5, s6);
		end = System.currentTimeMillis();
		System.out.println("Concat de StringBuffer:::::" + (end - start) + " ms");

		start = System.currentTimeMillis();
		concat3(s1, s2, s3, s4, s5, s6);
		end = System.currentTimeMillis();
		System.out.println("Concat de StringBuilder:::::" + (end - start) + " ms");

	}

	public static String concat1(String s1, String s2, String s3, String s4, String s5, String s6) {
		String result = "";
		for (int i = 0; i < 5000; i++) {
			result = result.concat(s1);
			result = result.concat(s2);
			result = result.concat(s3);
			result = result.concat(s4);
			result = result.concat(s5);
			result = result.concat(s6);
		}
		return result;
	}

	public static String concat2(String s1, String s2, String s3, String s4, String s5, String s6) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < 5000; i++) {
			result = result.append(s1);
			result = result.append(s2);
			result = result.append(s3);
			result = result.append(s4);
			result = result.append(s5);
			result = result.append(s6);
		}
		return result.toString();
	}

	public static String concat3(String s1, String s2, String s3, String s4, String s5, String s6) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 5000; i++) {
			result = result.append(s1);
			result = result.append(s2);
			result = result.append(s3);
			result = result.append(s4);
			result = result.append(s5);
			result = result.append(s6);
		}
		return result.toString();
	}

}