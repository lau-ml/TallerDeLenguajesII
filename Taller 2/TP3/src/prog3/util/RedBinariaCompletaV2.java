package prog3.util;
/* Para realizar el recorrido usaría un recorrido por niveles, ya que con el mismo, puedo ir recursivamente comparando el maximo de los caminos ingresados. En base a eso, puedo retornar el tiempo entre cada uno.*/
import prog3.arbolbinariov2.ArbolBinario;
public class RedBinariaCompletaV2 {
public int mayorDelay(ArbolBinario<Integer> ab)	
{
	if (ab.completo())
	return sumarDelay(ab);
	else
		{System.out.print("No es un arbol completo, no se puede procesar");
		return 0;
		}
}
public int sumarDelay(ArbolBinario<Integer> ab)
{
int sumaMax=0;
int sumaHI=0;
int sumaHD=0;
if (!ab.esHoja())
	{sumaHI+=sumarDelay(ab.getHijoIzquierdo());
	sumaHD+=sumarDelay(ab.getHijoIzquierdo());
}
if (sumaHI>sumaMax)
	sumaMax=sumaHI;
else sumaMax=sumaHD;
return sumaMax+ab.getDato();
}
}