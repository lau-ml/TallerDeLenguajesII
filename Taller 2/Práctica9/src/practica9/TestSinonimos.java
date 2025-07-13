package practica9;

public class TestSinonimos {
public static void main(String[] args) {
	DiccionarioDeSinonimos diccionario= new DiccionarioDeSinonimos();
	diccionario.getSinonimos("sillón");
	diccionario.getClaves();
	diccionario.print();
}
}
