package unlp.info.math;

public class Complex {
private double re;
private double im;
public Complex(double re, double im)
{
	this.re=re;
	this.im=im;
}
public final double realPart ()
{return re;
}
public final double imaginaryPart()
{return im;
}
public final Complex add (Complex c)
{	Complex complejoSuma=Complex.valueOf(this.realPart(), this.imaginaryPart());
	complejoSuma.im+=c.imaginaryPart();
	complejoSuma.re+=c.realPart();
	return complejoSuma;
}

public final Complex substract(Complex c)
{
	Complex complejoResta= Complex.valueOf(this.realPart(),this.imaginaryPart());
	complejoResta.im-=c.imaginaryPart();
	complejoResta.re-=c.realPart();
	return complejoResta;
}

//multiply
//divide
public boolean equals(Complex c)
{
	return (this.im==c.imaginaryPart() && this.re==c.realPart());
}

@Override
public String toString() {
	return "Componente imaginaria: " + this.imaginaryPart()+ "." + "Componente real: " + this.realPart();
}
public static Complex valueOf(double re, double im){
 Complex complejo= new Complex(re,im);
 return complejo;
}

}