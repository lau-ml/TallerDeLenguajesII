package prog3.util;

import prog3.arbolgeneral.*;
import prog3.listagenerica.*;

public class Empresa {
	private ArbolGeneral<Empleado> empleados;
	private String nombreEMP;

	public String getNombreEMP() {
		return nombreEMP;
	}

	public void setNombreEMP(String nombreEMP) {
		this.nombreEMP = nombreEMP;
	}

	public int empleadosPorCategoria(int categoria) {
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		ArbolGeneral<Empleado> arbol = new ArbolGeneral<Empleado>(null);
		int catEMP = 1;
		int cant = 0;
		cola.encolar(empleados);
		cola.encolar(null);
		boolean flag = false;
		while (!cola.esVacia() && !flag) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (categoria == catEMP)
					cant++;
				else if (arbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
					hijos = arbol.getHijos();
					hijos.comenzar();
					while (hijos.fin())
						cola.encolar(hijos.proximo());
				}
			} else if (cant != 0)
				flag = true;
			else if (!cola.esVacia()) {
				catEMP++;
				cola.encolar(null);
				cant = 0;
			}
		}
		return cant;
	}

	public int categoriaConMasEmpleados() {
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		ArbolGeneral<Empleado> arbol = new ArbolGeneral<Empleado>(null);
		int cant = 0;
		int max = -1;
		int cat = 1;
		int cat_mayor = 0;
		cola.encolar(empleados);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				cant++;
				if (arbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
					hijos = arbol.getHijos();
					hijos.comenzar();
					while (hijos.fin())
						cola.encolar(hijos.proximo());
				}
			} else if (!cola.esVacia()) {
				cola.encolar(null);
				if (cant > max) {
					max = cant;
					cat_mayor = cat;
				}
				cat++;
				cant = 0;
			}
		}
		return cat_mayor;
	}
	public int cantidadTotalEmpleados()
	{
		return cantidadTotalEmpleados_PRIV(empleados);
	}
	public int cantidadTotalEmpleados_PRIV(ArbolGeneral<Empleado> arbol)
	{	int suma=0;
		if (arbol.esHoja())
			suma++;
		else 
			if (arbol.tieneHijos())
				{ListaGenerica<ArbolGeneral<Empleado>> hijos= new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
				hijos=arbol.getHijos();
				hijos.comenzar();
				suma++;
				while (!hijos.fin())
					{suma+=this.cantidadTotalEmpleados_PRIV(hijos.proximo());
					}

}
		return suma;
		}
public void reemplazarPresidente() {
	reemplazarPresidente_PRIV(empleados);
}
private void reemplazarPresidente_PRIV(ArbolGeneral<Empleado> arbol)
{	if (!arbol.esVacio())
		{ArbolGeneral <Empleado> empleadoMayor=arbol;
		ListaGenerica<ArbolGeneral<Empleado>> hijos= new ListaGenericaEnlazada<ArbolGeneral<Empleado>>(); 
		empleadoMayor.getDato().setAntiguedad(-1);
		hijos=empleadoMayor.getHijos();
		hijos.comenzar();
		while (!hijos.fin())
		{ArbolGeneral<Empleado> hijo= hijos.proximo();
		if (hijo.getDato().getAntiguedad()>empleadoMayor.getDato().getAntiguedad())
			empleadoMayor=hijo;
		}
		arbol.getDato().setCategoria(empleadoMayor.getDato().getCategoria());
		arbol.getDato().setAntiguedad(empleadoMayor.getDato().getAntiguedad());
		arbol.getDato().setNombre(empleadoMayor.getDato().getNombre());
		if (empleadoMayor.esHoja())
			hijos.eliminar(empleadoMayor);
		else 
			reemplazarPresidente_PRIV(empleadoMayor);	
		}
	
}
}