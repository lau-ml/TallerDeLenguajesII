package generadorRandom;

public final class GeneraRandom {
 final static int MAXIMO_VALOR= Integer.MAX_VALUE;
 public static final int generaRandom()
 {	double aleatorio=Math.random()*MAXIMO_VALOR;
	 return Math.round(Math.round(aleatorio));//Devuelve un entero que simboliza el número random
 }
 private GeneraRandom()
 {
	 
 }
}
