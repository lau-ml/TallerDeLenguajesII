package unlp.info.test;

import unlp.info.animal.PerroPeligroso;
import unlp.info.animalespeligrosos.AnimalPeligroso;
import unlp.info.domestico.PerroDomestico;

public class Test {
public static void main(String[] args) {
	PerroDomestico gordo = new PerroPeligroso();
	gordo.ladra();
	gordo.mueveCola();
	gordo.muerde();// El perro domestico no tiene definido el comportamiento muerde
	AnimalPeligroso rita = new PerroPeligroso();
	rita.muerde();
	rita.ladra();//El animal peligroso, no tiene definido el comportamiento ladrar
	rita.mueveCola();//" " " no sabe mover la cola

}
}
