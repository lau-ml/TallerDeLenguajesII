package unlp.info.modelo;

import java.util.Comparator;

public class ComparadorEmpleado implements Comparator<Empleado> {
	 public int compare(Empleado p1, Empleado p2) {
		 double sueldo= p1.getSueldo() -p2.getSueldo();
		 if (!(p1.getApellido().equals(p2.getApellido())))
				return p1.getApellido().compareTo(p2.getApellido());
				else
					if (!(p1.getNombre().equals(p2.getNombre())))
						return p1.getNombre().compareTo(p2.getNombre());
					else
						if (sueldo<0)
							return -1;
						else if (sueldo==0)
							return 0;
						else return 1;						
	 }
	
}
