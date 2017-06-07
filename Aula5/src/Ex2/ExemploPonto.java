package Ex2;

public class ExemploPonto {

    public static void main(String[] args) {
        int n = 10;
        
        Plano plano = new Plano(n);
        
        plano.inserir(1, 2);
        
        plano.mover(1, 2, 4, 5);
        
        boolean contem = plano.contem(4, 5);
    }
    
}
