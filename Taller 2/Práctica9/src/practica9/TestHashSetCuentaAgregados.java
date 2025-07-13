package practica9;
import java.util.*;
public class TestHashSetCuentaAgregados {
	public static void main(String[] args) {
		Set <Integer> conjunto= new TreeSet<Integer>();
		for (int i=0;i<50;i++)
		conjunto.add(1);
		conjunto.add(2);
		HashSetCuentaAgregados<Integer> hashSet=new HashSetCuentaAgregados<Integer>();
		hashSet.addAll(conjunto);
		hashSet.addAll(conjunto);
		System.out.println(hashSet.getCantidadAgregados());
}
}