package prog3.util;

public class UtilitariosLista {
	public static void mergeSort(int[] a, int izq, int der) {
		if (izq < der) {
			int m = (izq + der) / 2;
			mergeSort(a, izq, m);
			mergeSort(a, m + 1, der);
			merge(a, izq, m, der);
		}
	}

	public static void merge(int[] a, int izq, int m, int der) {
		int[] b = new int[a.length];
		int i, j, k;
		for (i = izq; i <= der; i++)
			b[i] = a[i];
		i = izq;
		j = m + 1;
		k = izq;
		while (i <= izq && j <= der) {
			if (b[i] <= b[j])
				a[k++] = b[i++];
			else
				a[k++] = b[j++];
		}
		while (i <= m)
			a[k++] = b[i++];
		while (j <= der)
			a[k++] = b[j++];

	}
}
