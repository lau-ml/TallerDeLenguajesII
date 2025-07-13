package prog3.util;
import prog3.arbolgeneral.*;
import prog3.listagenerica.*;
public class TestImagen {
public static void main(String[] args) {
	Imagen img=new Imagen(4);
	int i;
	int j;
	for (i=0;i<4;i++)
		for(j=0;j<4;j++)
			img.set(i, j, true);
	for (i = 0; i <2; i++) 
		for (j = 0; j < 2; j++)
			img.set(i, j, false);
	img.set(0, 0, true);
		
	
	ArbolGeneral<Boolean> arbolPrueba;
	arbolPrueba=img.imagenComprimida();
	ListaGenerica <ArbolGeneral<Boolean>> lista=new ListaGenericaEnlazada<ArbolGeneral<Boolean>>();
	lista=arbolPrueba.getHijos();
	lista=lista.proximo().getHijos();
	lista.comenzar();
	while (!lista.fin())
	System.out.print(lista.proximo().getDato());
	
}
}
