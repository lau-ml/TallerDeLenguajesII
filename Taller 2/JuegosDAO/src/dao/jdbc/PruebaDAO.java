package dao.jdbc;

import java.util.Scanner;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import tpEntregable2.Deportista;
import tpEntregable2.Disciplina;

public class PruebaDAO {
public static void main(String[] args) {
	

DeportistaDAOjdbc depJDBC=new DeportistaDAOjdbc();
DisciplinaDAOjdbc disJDBC= new DisciplinaDAOjdbc(); 
Deportista dep=new Deportista();
Scanner scan= new Scanner(System.in);
dep.cargarDeportista(scan);
scan.close();
Disciplina disciplina=new Disciplina();
disciplina.setNombre("Fútbol");
//depJDBC.agregar(dep);
//disJDBC.agregar(disciplina);
ListaGenerica<Disciplina> disciplinas=disJDBC.obtener();
disciplinas.comenzar();
while (!disciplinas.fin())
System.out.println(disciplinas.proximo().getNombre());
//System.out.println(depJDBC.encontrar(44));
}
}