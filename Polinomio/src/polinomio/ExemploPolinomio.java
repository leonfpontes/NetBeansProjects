package polinomio;


public class ExemploPolinomio {

    public static void main(String[] args) {
    // Escreva um programa na linguagem Java para computar polinômios da forma: 
    // P(x) = anxn + an-1xn-1 + . . . + a1x + a0.
    // 3x^2 + 2x - 10
    Termo t2 = new Termo(3, 2);
    Termo t1 = new Termo(2, 1);
    Termo t0 = new Termo(-10, 0);

    Polinomio p = new Polinomio();
    p.add(t2);
    p.add(t1);
    p.add(t0);

    //p.add(t2, t1, t2);

    // 4x^5 + 7x^3 - 8x
    }
    
}
