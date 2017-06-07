package polinomio;

public class Polinomio {

    // TODO trocar por uma lista encadeada
    private Termo[] termos;

    public Polinomio() {
            termos = new Termo[10]; // TODO melhorar 
    }

    public void add(Termo t) {
            // TODO implementar.
    }

    public void add(Termo... t) {
            // TODO implementar.
    }

    public void add(int coef, int exp) {
            add(new Termo(coef, exp));
    }

    public long calcular(int x) {
            // TODO implementar.
            return -1;
    }
}
