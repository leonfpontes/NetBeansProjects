
package operacoes;


public class Operacoes {

    public static void main(String[] args) {
        
    }
    
    public static void mostrarCalculo(String operacao, double... n){
        Calculos c = new Calculos();
        System.out.print("O resultado é: ");
        switch (operacao){
            case "SOMA":
                for (double numero: n){
                    System.out.print(c.soma(numero));
                }
                break;
            case "SUBTRACAO":
                for (double numeros: n){
                    System.out.print(c.subtracao(n));
                }
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
