package Ex1;


public class Calculo {
    public static double somar(double a, double b){
        return a+b;
    }
    
    public static double subtrair(double a, double b){
        return a-b;
    }
    
    public static double dividir(double a, double b){
        if (b != 0)
            return a/b;
        else
            return 0;
    }
    
    public static double multiplicar (double a, double b){
        return a*b;
    }
}
