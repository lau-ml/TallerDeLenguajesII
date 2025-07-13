package prog3.util;
import java.util.HashMap;
import prog3.grafos.*;
public class Heap<T> {

	private int tamanio = 0;
	private int[] dato;
	private HashMap<Integer, Vertice<T>> hashMap = new HashMap<Integer, Vertice<T>>();
	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public int[] getDato() {
		return dato;
	}

	public void setDato(int[] dato) {
		this.dato = dato;
	}

	private void percolate_up(Heap<T> h, Integer i, Vertice<T> vertice) {
		int temp = h.dato[i];
		while (i / 2 > 0 && h.dato[i / 2] > temp) {//Intercambia valores superiores con las partes bajas
			h.dato[i] = h.dato[i / 2];
			hashMap.put(i, hashMap.get(i/2));//Esta actualizacion debe estar reflejada en la tabla hash
			i = i / 2;
		}
		h.dato[i] = temp; // ubicación correcta del elemento a filtrar
		hashMap.put(i,vertice);//La nueva ubicacion, debe estar actualizada en la tabla hash
	}
	
	public void insert(Heap<T> h, int x,Vertice<T> vertice) {
		h.tamanio = h.tamanio + 1;
		int [] nuevoArreglo= new int[h.tamanio+1];
		if (h.dato!=null)
		System.arraycopy(h.dato, 0, nuevoArreglo, 0, h.tamanio);//Copio el arreglo en uno nuevo
		h.dato=nuevoArreglo;//Lo asigno al nuevo arreglo
		
		h.dato[h.tamanio] = x;
		percolate_up(h, h.tamanio,vertice);//Inserto y hago filtrado hacia arriba
	}

	public Vertice<T> delete_min(Heap<T> h, int e) {
		Vertice<T> vertice=null;
		if (h.tamanio > 0) { // la heap no está vacía
			e = h.dato[1];
			vertice=hashMap.get(1);// Me traigo el valor que esta almacenado en la primera posicion
			//System.out.println(vertice.dato()); Lo imprimo
			
			h.dato[1] = h.dato[h.tamanio];//Guardo el ultimo dato para filtrarlo
			hashMap.put(1, hashMap.get(h.tamanio));//Manifiesto este cambio en la hashMap
			h.tamanio = h.tamanio - 1;//Disminuyo el tamaño de la hash
			percolate_down(h, 1);//Hago filtrado hacia abajo del ultimo elemento
		}
		
		return vertice;
		
	} // end del delete_min

	private void percolate_down(Heap<T> h, int p) {
		int candidato = h.dato[p];
		Vertice<T> vertice=hashMap.get(1);
		
		boolean stop_perc = false;
		while ((2 * p <= h.tamanio) && (!stop_perc)) {
			int h_min = 2 * p; // buscar el hijo con clave menor
			if (h_min != h.tamanio)
				if (h.dato[h_min + 1] < h.dato[h_min])
					h_min = h_min + 1;//Considero si no estoy en el ultimo nodo y actualizo el minimo en funcion de los dos padres
			if (candidato > h.dato[h_min]) { // percolate_down
				h.dato[p] = h.dato[h_min];//Guardo en la posicion el mas chico de los dos
				hashMap.put(p,hashMap.get(h_min));//Reflejo ese cambio en la hash
				p = h_min;
			} else
				stop_perc = true;
		} // end { while }
		hashMap.put(p, vertice);//La posicion del elemento cambia en la hash
		h.dato[p] = candidato;//Guardo donde corresponde ubicar el elemento que estaba antes en la primera posicion
	} // end {percolate_down }

}
