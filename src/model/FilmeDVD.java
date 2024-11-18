package model;

public class FilmeDVD extends Filme {
    public FilmeDVD(String titulo, String genero) {
        super(titulo, genero);
    }

    @Override
    public String getFormato() {
        return "DVD";
    }

    @Override
    public double calcularPreco() {
        return 5.0;
    }

    @Override
    public String exibirDetalhes() {
        return "Definição padrão e custo acessível.";
    }
}
