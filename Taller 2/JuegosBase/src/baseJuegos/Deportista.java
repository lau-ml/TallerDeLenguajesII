package baseJuegos;

import java.util.Scanner;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Deportista {
	private String apellidos;
	private String nombres;
	private String email;
	private String telefono;
	private ListaGenerica<Integer> disciplinas = new ListaGenericaEnlazada<Integer>();
	
	public Deportista() {
		super();
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public ListaGenerica<Integer> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(ListaGenerica<Integer> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void cargarDeportista(Scanner scan) {
		System.out.println("Ingrese Nombre del deportista:");
		nombres =scan.nextLine();
		System.out.println("Ingrese Apellido del deportista:");
		apellidos=scan.nextLine();
		System.out.println("Ingrese email del deportista:");
		email=scan.nextLine();
		System.out.println("Ingrese Telefono del deportista:");
		telefono=scan.nextLine();
	}
	
	public void cargarLista(Scanner scan) {
		disciplinas.comenzar();
		int aux, pos = 0;
		aux = scan.nextInt();
		while (aux != 0) {
			disciplinas.agregarEn(aux, pos);
			pos++;
			aux = scan.nextInt();
		}
	}
	
	@Override
	public String toString() {
		String aux="El deportista es: "+nombres.toString()+" "+apellidos.toString()+" con email "+email.toString()+" y telefono "+telefono.toString();
		return aux;
	}
	
	

}
