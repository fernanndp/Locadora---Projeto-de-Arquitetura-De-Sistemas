package ClassesFilha;

import ClassesAbstratas.Filme;

public class FilmeDVD extends Filme {
    public FilmeDVD(String titulo, String genero) {
        super(titulo, genero);
    }

    @Override
    public String getFormato() {
        return "DVD";
    }
}
