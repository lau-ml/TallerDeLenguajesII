package griego;
//Es v�lido el acceso por parte de la clase Gamma. El especificador de acceso protected, lo que hace es
//Facilitar a las clases que la extienden que no se encuentran en un mismo paquete, acceso a la utilizaci�n de los m�todos
//Adem�s, protected permite acceso a aquellas clases que se encuentran en un mismo paquete. Por ello, es que no salta error cuando Gamma intenta
//acceder al m�todo
//Respecto a la modificaci�n que se sugiere en el inciso b, el acceso es inv�lido, ya que el acceso package, solo est� definido
//Para las clases que se encuentran en el paquete. Cuando se importa el paquete lo que se puede acceder con la clase, son los m�todos p�blicos, no los m�todos package en si
//Cuando se hace 
public class Prueba {
public static void main(String[] args) {
	Gamma gamma= new Gamma();
	gamma.unM�todoG();
}
}
