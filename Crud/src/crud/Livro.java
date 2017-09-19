package crud;

public class Livro {

    public String getVsNomeLivro() {
        return vsNomeLivro;
    }

    public void setVsNomeLivro(String vsNomeLivro) {
        this.vsNomeLivro = vsNomeLivro;
    }

    public String getVsNomeAutor() {
        return vsNomeAutor;
    }

    public void setVsNomeAutor(String vsNomeAutor) {
        this.vsNomeAutor = vsNomeAutor;
    }

    public double getVnCodLivro() {
        return vnCodLivro;
    }

    public void setVnCodLivro(double vnCodLivro) {
        this.vnCodLivro = vnCodLivro;
    }
    private String vsNomeLivro, vsNomeAutor;
    private double vnCodLivro;
}
