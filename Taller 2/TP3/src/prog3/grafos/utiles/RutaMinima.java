package prog3.grafos.utiles;
import prog3.listagenerica.*;
public class RutaMinima {
private boolean unico;
private ListaGenerica<String> lista;

public RutaMinima(boolean unico) {
	super();
	this.unico = unico;
	this.lista = new ListaGenericaEnlazada<String>();
}
public void AgregarLista (ListaGenerica<String> recorrido)
{
int tamanio=this.lista.tamanio();
for (int i=0; i<tamanio;i++)
	this.lista.eliminarEn(0);
for (int i=0;i<recorrido.tamanio();i++)
{
	this.lista.agregarFinal(recorrido.elemento(i));
}

}
public boolean isUnico() {
	return unico;
}
public void setUnico(boolean unico) {
	this.unico = unico;
}
public ListaGenerica<String> getLista() {
	return lista;
}
public void setLista(ListaGenerica<String> lista) {
	this.lista = lista;
}
}
