package unlp.info.animal;
import unlp.info.animalespeligrosos.*;
import unlp.info.domestico.*;
public class PerroPeligroso implements AnimalPeligroso, PerroDomestico {
public void muerde() {
System.out.println("GRRRR!");
}
public void ladra() {
System.out.println("GUAU GUAU!");
}
public void mueveCola() {
System.out.println("Mueve cola");
}
}
//Una solución posible es implementar las mismas firmas de métodos en las interfaces, para luego ser implementadas.
//Como se trata de métodos muy generales, basta con implementarlo una sola vez.

