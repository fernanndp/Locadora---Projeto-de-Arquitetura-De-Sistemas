package ClassesService;

import ClassesAbstratas.Filme;

import java.util.ArrayList;
import java.util.List;


public class FilmeService {
    private List<Filme> filmes;

    public FilmeService() {
        this.filmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public Filme buscarFilme(String titulo) {
        return filmes.stream()
                .filter(f -> f.getTitulo().equals(titulo))
                .findFirst().orElse(null);
    }

    public List<Filme> getFilmes() {
        return filmes;
    }
}

