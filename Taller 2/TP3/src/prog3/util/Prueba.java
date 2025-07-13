package prog3.util;

public class Prueba {
	public static void main(String[] args) {
		/*int i, j, k, sum;
		sum = 0;
		int n=4;
		int sumI=0;
		int sumK=0;
		for (i=n; i>1; i--) {
			sumK=0;
			sumI++;
			for ( j=1; j < i*i; j++) {
				sumK++;
				for ( k=i; k<j; k+=2) {
		sum = sum + 1;
		}
		}
		}
		System.out.print(sum);
		*/
		int a=5,x=6,y=8;
		while (a > 0)
			{x += y;
			a-=1;
			}
		System.out.print(x);
		}
	

/*	public static void main(String[] args) {
		int x=0;
		int n=6;
		int ayuda1=0,ayuda2=0,ayuda3=0;
		for (int i = 1; i < n; i = i+4)
			{ayuda1++;
			ayuda2=0;
			for (int j = n; j > 1; j = j/4)
			{	ayuda2++;
			ayuda3=0;
				for (int k = 1; k < n; k = k*2)
				{		ayuda3++;
					x +=1;
				}
			}
			}
		int suma=1;
		for (int i=1;i<=n;i++)
		for (int j=1;j<=i;j++)
		suma = suma + 1;
		int producto=1;
		for (int i=1;i<=n;i++)
		for (int j=1;j<=i;j++)
		producto= 2*producto;
		int sum=0;
		for(int i = 0; i< n; i++)
			sum++;
		sum=0;
		for(int i = 0; i< n; i+=2)
			sum++;
		sum=0;
		for(int i = 0; i< n; i++)
			for(int j = 0; j< n; j++)
			sum++;
sum=0;
for(int i = 0; i< n; i++)
for(int j = 0; j< n*n; j++)
sum++;
		System.out.print(sum);*/
	}


