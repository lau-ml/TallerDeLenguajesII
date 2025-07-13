package practica9;
import java.util.*;
public class DiccionarioDeSinonimos {
private Map <String, Set <String>> diccionario= new TreeMap <String,  Set<String>>();
//Para tenerlo ordenado lo que utilicé fue un TreeMap y un TreeSet. La única manera de poder tenerlos ordenados.
//No modifico los nombres de las variables listas, para recordar que en un principio fue pensado de esa manera.
public DiccionarioDeSinonimos() {
	super();
	Set <String> lista= new TreeSet<String>();
	lista.add("asiento");
	lista.add("butaca");
	lista.add("silla");
	diccionario.put("sillón", lista);

	Set <String> lista2= new TreeSet<String>();
	lista2.add("edificación");
	lista2.add("inmueble");
	lista2.add("hogar");
	lista2.add("obra");
	diccionario.put("casa", lista2);
	
	Set <String> lista3= new TreeSet<String>();
	lista3.add("ejemplar");
	lista3.add("manual");
	lista3.add("obra");
	lista3.add("texto");
	diccionario.put("libro", lista3);
	
	Set <String> lista4= new TreeSet<String>();
	lista4.add("equipo");
	lista4.add("ordenador");
	lista4.add("pc");
	diccionario.put("computador", lista4);
}
public void getSinonimos(String palabra) {
	
	System.out.println(this.diccionario.get(palabra));
}
public void getClaves()
{
	System.out.println(this.diccionario.keySet());
}
public void print() {
	Set <String> palabras=this.diccionario.keySet();
	for (String palabra: palabras)
	{
		System.out.println("Palabra: " + palabra + ". Sinónimos: " + this.diccionario.get(palabra));
	}
}

}
