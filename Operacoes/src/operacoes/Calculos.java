package operacoes;

public class Calculos {
    
    //ABSTRACT
    
    public double soma(double... numeros){
        double resultado = 0;
        for (double numero: numeros){
            resultado += numero;
        }
        return resultado;
    }
    
    public double subtracao(double... numeros){
        double resultado = 0;
        for (double numero: numeros){
            resultado -= numero;
        }
        return resultado;
    }
}
