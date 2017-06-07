
package Ex1;

public class ExemploCalculo {

    public static void main(String[] args) {
        int a, b;
        a = 225;
        b = 5;
        
        System.out.println("Soma: " + Calculo.somar(a,b) +
                           "\nSubtração: " + Calculo.subtrair(a, b) +
                           "\nDivisao: " + Calculo.dividir(a, b) +
                           "\nMultiplicação: " + Calculo.multiplicar(a, b));
    }
    
}
