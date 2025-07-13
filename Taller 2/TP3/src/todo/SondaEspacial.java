package todo;
import prog3.listagenerica.*;
public class SondaEspacial<T> {
private  T medida;
private ListaGenerica<Double> valores= new ListaGenericaEnlazada<Double>();
public SondaEspacial (T dato)
{
	this.setMedida(dato);
}

public T getMedida() {
	return medida;
}
public void setMedida(T medida) {
	this.medida = medida;
}
public void imprimirMedida()
{
	System.out.print(medida);
}
public void guardarMediciones(ListaGenerica<Double> unidades)
{
	for(int i=0; i<unidades.tamanio();i++)
		valores.agregarFinal(unidades.elemento(i));
}
}
