package exe01;

import static exe01.Calculo.somar;
import static exe01.Calculo.subtrair;
//import static exe01.Calculo.xpto;

public class ExemploCalculo {

	public static void main(String[] args) {
		
		int a, b;
		a = 3;
		b = 2;
//		int c;
		
		System.out.println(somar(a, b) + subtrair(a, b));
		
//		xpto(a, b, c);
//		System.out.println(somar(a, b) + c);
	
		int c, d;
		c = 1;
		d = 4;
		
		System.out.println(somar(c, d));
		System.out.println(subtrair(c, d));

	}
	
}
