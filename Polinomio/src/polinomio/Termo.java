package polinomio;

public class Termo {
    private int coef;
    private int exp;
    
    public Termo(int coef, int exp){
        this.coef = coef;
        this.exp = exp;
    }

    public int getCoef() {
        return coef;
    }

    public int getExp() {
        return exp;
    }
    
}
