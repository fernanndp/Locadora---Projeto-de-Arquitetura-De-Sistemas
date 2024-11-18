package model;


public class FilmeBluRay extends Filme {
    public FilmeBluRay(String titulo, String genero) {
        super(titulo, genero);
    }

    @Override
    public String getFormato() {
        return "Blu-ray";
    }

    @Override
    public double calcularPreco() {
        return 10.0;
    }

    @Override
    public String exibirDetalhes() {
        return "Alta definição e qualidade superior.";
    }
}

