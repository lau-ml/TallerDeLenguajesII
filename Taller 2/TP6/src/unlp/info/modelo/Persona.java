package unlp.info.modelo;
import java.util.*;
public class Persona implements Comparable<Persona> {
private String nombre;
private String apellido;
private int edad;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
@Override
public int compareTo(Persona o) {
	if (!(this.apellido.equals(o.apellido)))
			return this.apellido.compareTo(o.apellido);
			else
				return (this.nombre.compareTo(o.nombre));
}
}