package prog3.util;
import prog3.util.*;
import prog3.arbolgeneral.*;

public class PruebaParcial {
public static void main(String[] args) {
ArbolGeneral<Integer> raiz=new ArbolGeneral<Integer>(20);	
ArbolGeneral<Integer> nodo_10 = new ArbolGeneral<Integer>(11);
ArbolGeneral<Integer> nodo_8= new ArbolGeneral<Integer>(2);
ArbolGeneral<Integer> nodo_15= new ArbolGeneral<Integer>(0);
ArbolGeneral<Integer> nodo_2= new ArbolGeneral<Integer>(6);
ArbolGeneral<Integer> nodo_5= new ArbolGeneral<Integer>(5);
ArbolGeneral<Integer> nodo_4= new ArbolGeneral<Integer>(4);
ArbolGeneral<Integer> nodo_9= new ArbolGeneral<Integer>(1);
ArbolGeneral<Integer> nodo_12= new ArbolGeneral<Integer>(1);
nodo_8.agregarHijo(nodo_15);
nodo_10.agregarHijo(nodo_5);
nodo_10.agregarHijo(nodo_4);
raiz.agregarHijo(nodo_10);
nodo_8.agregarHijo(nodo_12);
nodo_2.agregarHijo(nodo_9);
raiz.agregarHijo(nodo_8);
raiz.agregarHijo(nodo_2);
Parcial parcial1= new Parcial();
System.out.print(parcial1.resolver(raiz));
}
}
