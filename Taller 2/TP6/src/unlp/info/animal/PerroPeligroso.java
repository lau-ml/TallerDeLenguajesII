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
//Una soluci�n posible es implementar las mismas firmas de m�todos en las interfaces, para luego ser implementadas.
//Como se trata de m�todos muy generales, basta con implementarlo una sola vez.

