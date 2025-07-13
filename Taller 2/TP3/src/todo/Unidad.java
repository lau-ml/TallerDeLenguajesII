package todo;
import prog3.listagenerica.*;
import static todo.LongitudMedida.*;
import static todo.MagnitudIng.*;

public class Unidad {

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		Longitud sistema=new Longitud();
		sistema.setMedida(KM);
		sistema.setCant(1);
		MagnitudI inglesI= new MagnitudI();
		inglesI.setCant(1);
		inglesI.setMagnitudInglesa(PIE);
		ListaGenerica<MagnitudI> listaLongitudes=new ListaGenericaEnlazada<MagnitudI>();
		MagnitudI inglesI2= new MagnitudI();
		inglesI2.setCant(11);
		inglesI2.setMagnitudInglesa(PIE);
		MagnitudI inglesI3= new MagnitudI();
		inglesI3.setCant(13);
		inglesI3.setMagnitudInglesa(PIE);
		MagnitudI inglesI4= new MagnitudI();
		inglesI4.setCant(14);
		inglesI4.setMagnitudInglesa(PIE);
		MagnitudI inglesI5= new MagnitudI();
		inglesI5.setCant(10);
		inglesI5.setMagnitudInglesa(PIE);
		SondaEspacial<LongitudMedida> sonda= new SondaEspacial<LongitudMedida>(KM);
		listaLongitudes.agregarFinal(inglesI);
		listaLongitudes.agregarFinal(inglesI2);
		listaLongitudes.agregarFinal(inglesI3);
		listaLongitudes.agregarFinal(inglesI4);
		listaLongitudes.agregarFinal(inglesI5);
		ListaGenerica <Double> cantidadesSonda= new ListaGenericaEnlazada<Double>();
		for (int i=0; i<listaLongitudes.tamanio();i++)
			{
			cantidadesSonda.agregarFinal((listaLongitudes.elemento(i).convertirMismasUnidades())/sistema.getMedida().multiplicador());
		
			}
		for (int i=0; i<listaLongitudes.tamanio();i++)
			sonda.guardarMediciones(cantidadesSonda);
			
		
	}

}
