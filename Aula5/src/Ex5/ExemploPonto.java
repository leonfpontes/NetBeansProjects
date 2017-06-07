package Ex5;

public class ExemploPonto {

    public static void main(String[] args) {
        int n = 10;
        Plano plano = new Plano(n);
        
        Ponto p1 = new Ponto(1,2);
        plano.inserir(p1);
        
        Ponto p2 = new Ponto(4,5);
        plano.mover(p1, p2);
        
        boolean contem = plano.contem(p2);
        
//        Plano p2 = new Plano(n);
//        // ponto (3,2);
//        p2.inserir(3, 2);
//        // mover (3,2) para (5,4)
//        p2.mover(3, 2, 5, 4);
//        // contém o ponto (5,4)?
//        boolean contem2 = p2.contem(5, 4);
//
//        Plano p3 = p2;
//        // ponto (7,1);
//        p3.inserir(7, 1);
        
    }
    
}
