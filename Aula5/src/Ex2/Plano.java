package Ex2;

public class Plano {
    int[][] plano;
    
    public Plano(int n){
        plano = new int[n][n];
    }
    
    public Plano(int n, int m){
        plano = new int[n][m];
    }
    
    public void mover(int x1, int y1, int x2, int y2){
        plano[x2-1][y2-1] = plano[x1-1][y1-1];
        plano[x1-1][y1-1] = 0;
    }
    
    public void inserir(int x, int y){
        plano[x-1][y-1] = 1;
    }
    
    public boolean contem(int x, int y){
        return plano[x-1][y-1]==1;
    }
}
