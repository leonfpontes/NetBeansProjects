package aula3;

public enum TipoVersao {
    UM(1, "um"),
    DOIS(2, "dois"),
    TRES(3,"tres");
    
    int valor;
    String descricao;
    
    private TipoVersao(int valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }
    
}
