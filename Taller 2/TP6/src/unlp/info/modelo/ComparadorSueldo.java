package unlp.info.modelo;

import java.util.Comparator;

public class ComparadorSueldo implements Comparator<Empleado>{

	@Override
	public int compare(Empleado o1, Empleado o2) {
		
		if (o1.getSueldo()-o2.getSueldo()>0)
		return 1;
		else if (o1.getSueldo()-o2.getSueldo()==0)
				return 0;
		else return -1;
	}

}
