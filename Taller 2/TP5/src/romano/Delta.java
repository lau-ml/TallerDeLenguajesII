package romano;
import griego.*;
public class Delta extends Alpha {
	
		void unMetodoD(Alpha a, Delta d){
		//a.x=10; Se aclara que cuando uno desea acceder con una clase a un método protected, se debe recordar que este brinda acceso package y a las subclases que se encuentran en otros paquetes
			//Por lo tanto, el error radica en querer invocar un método que solo puede ser accedido cuando se está en el paquete que contiene a la clase
		d.x=10;
	//	a.otroMetodoA(); Sucede lo mismo
		d.otroMetodoA();//Fundamental para la herencia. El protected permite que se pueda acceder desde una subclase a la clase padre.
		}
		}

