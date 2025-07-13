package unlp.info.modelo;
import java.util.*;
public class Test {
public static void main(String[] args) {
	Scanner scan= new Scanner(System.in);
	Persona [] personas=new Persona[8];
	Empleado [] empleados=new Empleado[8];
	
	for (int i=0;i<8;i++)
	{	scan.nextLine();
		personas[i]=new Persona();
		empleados[i]=new Empleado();
		System.out.print("Ingrese apellido: ");
		personas[i].setApellido(scan.nextLine());
		empleados[i].setApellido(personas[i].getApellido());
		System.out.print("Ingrese nombre: ");
		personas[i].setNombre(scan.nextLine());
		empleados[i].setNombre(personas[i].getNombre());
		empleados[i].setSueldo(scan.nextDouble());
		
		
	}
	Arrays.sort(personas);
	Arrays.sort(empleados, new ComparadorEmpleado());
	for (int i=0;i<8;i++)
	{	
		
		System.out.println("Apellido: "+ empleados[i].getApellido());
		System.out.println("Nombre: "+ empleados[i].getNombre());
		System.out.println("Sueldo: "+ empleados[i].getSueldo());
	}
	scan.close();
}
}
