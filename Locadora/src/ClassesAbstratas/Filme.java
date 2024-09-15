package ClassesAbstratas;

import Interfaces.TipoFilme;

public abstract class Filme implements TipoFilme {
    private String titulo;
    private String genero;
    private boolean disponivel;

    public Filme(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
