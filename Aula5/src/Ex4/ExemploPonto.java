package Ex4;

public class ExemploPonto {

    public static void main(String[] args) {
        int n = 10;
        Plano p1 = new Plano(n);
        // ponto (1,2);
        p1.inserir(1, 2);
        // mover (1,2) para (3,4)
        p1.mover(1, 2, 3, 4);
        // contém o ponto (3,4)?
        boolean contem1 = p1.contem(3, 4);

        Plano p2 = new Plano(n);
        // ponto (3,2);
        p2.inserir(3, 2);
        // mover (3,2) para (5,4)
        p2.mover(3, 2, 5, 4);
        // contém o ponto (5,4)?
        boolean contem2 = p2.contem(5, 4);

        Plano p3 = p2;
        // ponto (7,1);
        p3.inserir(7, 1);
    }
    
}
