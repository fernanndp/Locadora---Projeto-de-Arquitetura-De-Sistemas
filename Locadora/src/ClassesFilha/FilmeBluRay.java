package ClassesFilha;

import ClassesAbstratas.Filme;

public class FilmeBluRay extends Filme {
    public FilmeBluRay(String titulo, String genero) {
        super(titulo, genero);
    }

    @Override
    public String getFormato() {
        return "Blu-ray";
    }
}

