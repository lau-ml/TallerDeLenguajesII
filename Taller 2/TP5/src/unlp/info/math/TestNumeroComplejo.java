package unlp.info.math;

import java.util.Scanner;

public class TestNumeroComplejo {
	public static void main(String[] args) {
		
	
	Scanner scan= new Scanner(System.in);
double im= scan.nextDouble();
double re= scan.nextDouble();
Complex complejo1= new Complex(re,im);
im= scan.nextDouble();
re= scan.nextDouble();
Complex complejo2= new Complex(re,im);
System.out.println(complejo1.add(complejo2).toString());
scan.close();
	}
}
