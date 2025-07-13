package prog3.util;

import prog3.arbolgeneral.*;
import prog3.listagenerica.*;

public class Imagen {
	private boolean imagen[][];

	public Imagen(int tamanio) {
		boolean matrizAUX[][] = new boolean[tamanio][tamanio];
		this.imagen = matrizAUX;
	}

	private Imagen(Imagen img, int parte) {
		
		this(img.dimension()/2);
		int i;
		int j;
		int k = 0;
		int l = 0;
		switch (parte) {
		case 1:
			for (i = 0; i <= img.dimension() / 4; i++) {
				for (j = 0; j <= img.dimension() / 4; j++)
					this.set(k, l++, img.get(i, j));
				k++;
				l = 0;
			}
			break;
		case 2:
			for (i = 0; i <= img.dimension() / 4; i++) {
				for (j = img.dimension() / 2; j < img.dimension(); j++)
					this.set(k, l++, img.get(i, j));
				k++;
				l = 0;
			}
			break;
		case 3:
			for (i = img.dimension() / 2; i < img.dimension(); i++) {
				l = 0;
				for (j = 0; j <= img.dimension() / 4; j++)
					this.set(k, l++, img.get(i, j));
				k++;
				
			}
			break;
		case 4:
			for (i = img.dimension() / 2; i < img.dimension(); i++) {
				l=0;
				for (j = img.dimension() / 2; j < img.dimension(); j++)
					this.set(k, l++, img.get(i, j));
			k++;
			}
			break;
		}
	}

	public ListaGenerica<Imagen> dividirEnSubimagenes() {
		int i;
		ListaGenerica<Imagen> listaIMG = new ListaGenericaEnlazada<Imagen>();
		for (i = 1; i <= 4; i++) {
			Imagen img = new Imagen(this, i);
			listaIMG.agregarFinal(img);
		}
		return listaIMG;
	}

	public int dimension() {
		return imagen.length;
	}

	public ArbolGeneral<Boolean> imagenComprimida() {
		ArbolGeneral<Boolean> compresion;
		compresion = imagenComprimida_PRIV(this);
		return compresion;
	}

	private ArbolGeneral<Boolean> imagenComprimida_PRIV(Imagen img) {
		ArbolGeneral<Boolean> nodo = new ArbolGeneral<Boolean>(null);
		if (!img.igualColor()) {
			ArbolGeneral<Boolean> nodoAUX = new ArbolGeneral<Boolean>(null);
			ListaGenerica<Imagen> listaIMG = new ListaGenericaEnlazada<Imagen>();
			listaIMG=img.dividirEnSubimagenes();
			listaIMG.comenzar();
			int i;
			for (i=1;i<=4;i++)
				{nodoAUX=imagenComprimida_PRIV(listaIMG.proximo());
				nodo.agregarHijo(nodoAUX);
				}
				} else
			nodo.setDato(img.color());
		return nodo;
	}

	public boolean igualColor() {
		int i;
		int j;
		boolean color = this.imagen[0][0];
		boolean cumple = true;
		for (i = 0; i < this.dimension() && cumple; i++)
			for (j = 0; j < this.dimension() && cumple; j++)
				if (color != this.get(i, j))
					cumple = false;
		return cumple;
	}

	public boolean color() {
		return this.imagen[0][0];
	}

	public boolean get(int i, int j) {
		return this.imagen[i][j];
	}

	public void set(int i, int j, boolean color) {
		this.imagen[i][j] = color;
	}
}
