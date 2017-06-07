package Ex1;

public class ExemploPonto {

    public static void mover(int[][] plano,
                             int x1, int y1,
                             int x2, int y2) {
        plano[x2-1][y2-1] = plano[x1-1][y1-1];
        plano[x1-1][y1-1] = 0;
    }
	
    public static void inserir(int[][] plano, int x, int y) {
        plano[x-1][y-1] = 1;
    }

    public static boolean contem(int[][] plano, int x, int y) {
        return plano[x-1][y-1] == 1;
    }

    public static void main(String[] args) {	

        int n = 10;

        int[][] plano = new int[n][n];

        // ponto (1,2);
        inserir(plano, 1, 2);

        // mover (1,2) para (3,4)
        mover(plano, 1, 2, 3, 4);

        // contém o ponto (3,4)?
        boolean contem = contem(plano, 3, 4);
    }
    
}
