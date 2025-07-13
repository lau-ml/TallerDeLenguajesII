package griego;
//Es válido el acceso por parte de la clase Gamma. El especificador de acceso protected, lo que hace es
//Facilitar a las clases que la extienden que no se encuentran en un mismo paquete, acceso a la utilización de los métodos
//Además, protected permite acceso a aquellas clases que se encuentran en un mismo paquete. Por ello, es que no salta error cuando Gamma intenta
//acceder al método
//Respecto a la modificación que se sugiere en el inciso b, el acceso es inválido, ya que el acceso package, solo está definido
//Para las clases que se encuentran en el paquete. Cuando se importa el paquete lo que se puede acceder con la clase, son los métodos públicos, no los métodos package en si
//Cuando se hace 
public class Prueba {
public static void main(String[] args) {
	Gamma gamma= new Gamma();
	gamma.unMétodoG();
}
}
