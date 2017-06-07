package Ex4;

public class Plano {
    boolean[][] plano;
    
    public Plano(int n){
        plano = new boolean[n][n];
    }
    
    public Plano(int n, int m){
        plano = new boolean[n][m];
    }
    
    public void mover(int x1, int y1, int x2, int y2){
        plano[x2-1][y2-1] = plano[x1-1][y1-1];
        plano[x1-1][y1-1] = false;
    }
    
    public void inserir(int x, int y){
        plano[x-1][y-1] = true;
    }
    
    public boolean contem(int x, int y){
        return plano[x-1][y-1];
    }
}
