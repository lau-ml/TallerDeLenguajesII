package unlp.info.reinoanimal;

public class Gato extends Animal {
	@Override
	protected void saludo() {//No funciona dado que gato no puede restringir m�s el acceso que el que est� declarado.
		//El unico que funcionaria es protected y public
	System.out.println("Miau!");
	}
	
}
