package unlp.info.comparacionstring;

public class StringDemo {
	public static void main(String[] args) {
		String str1="Leones y Tigres y Osos!";
		String str2="Leones y Tigres y Osos!";
		String str3=str2;
		String str4=new String("Leones y Tigres y Osos!");
		String str5=" Y yo!";
		String str6="Leones y Tigres y Osos! Y yo!";
		String str7= str1 + str5;
		System.out.println(str1==str2);//Debe devolver true ya que el objeto se encuentra creado
		System.out.println(str1==str3);//Debe devolver true, ya que tanto str1 como str2 como str3 apuntan al mismo objeto instanciado en memoria
		System.out.println(str1==str4);//Debe devolver falso. Son dos objetos creados ubicados en distinta parte de la memoria. Las referencias no coinciden
		System.out.println(str2==str3);//Debe devolver true. Esto se debe a que ambos apuntan al mismo lugar.
		System.out.println(str2==str4);//Debe devolver false, ya que ambos apuntan a distintos lugares de memoria
		System.out.println(str3==str4);//Lo mismo que en el anterior. str3 apunta a lo mismo que apunta str2 y str1. Por tanto las referencias comparadas con str4 dan como resultado que sea nulo
		System.out.println(str6==str7);//Se compara si es que ambos apuntan al mismo lugar. Esto resulta falso. Cuando se combinan dos strings, se aloca en memoria un nuevo lugar donde guardar el resultado. Por tanto, las referencias no coinciden.
		System.out.println(str1.equals(str4)); //Da como resultado verdadero. Ya que se compara ahora el contenido, no las referencias
		System.out.println(str6.equals(str7));//Lo mismo que con el anterior. No se comparan referencias.
		}
	/*public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = count;
            if (n == anotherString.count) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = offset;
                int j = anotherString.offset;
                while (n-- != 0) {
                    if (v1[i++] != v2[j++])
                        return false;
                }
                return true;
            }
        }
        return false;
    }
    */ // De esta manera se implementa el equals en java. Por default, java lo que compara son referencias en caso de la mayoría de los objetos.
	//Un caso particular es el del equals del string, el cual sobreescribe el equals y va comparando. En caso de encontrarse al menos un caracter distinto o dimensión distinta retorna falso.
	//En el caso de querer implementarlo con personas, sobreescribiría el método equals, indicando las características propias de una persona a ser comparada.
	//Es decir, por ejemplo, sexo, edad, altura, etc.
	//El criterio por default sería comparar referencias
	
		}

