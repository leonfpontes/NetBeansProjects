package Ex5;

public class Plano {
    boolean[][] plano;
    
    public Plano(int n){
        plano = new boolean[n][n];
    }
    
    public Plano(int n, int m){
        plano = new boolean[n][m];
    }
    
    public void mover(Ponto p1, Ponto p2){
        plano[p2.getX()-1][p2.getY()-1] = plano[p1.getX()-1][p1.getY()-1];
        plano[p1.getX()-1][p1.getY()-1] = false;
    }
    
    public void inserir(Ponto p){
        plano[p.getX()-1][p.getY()-1] = true;
    }
    
    public boolean contem(Ponto p){
        return plano[p.getX()-1][p.getY()-1];
    }
}
