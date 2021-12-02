package it.unicam.cs.diciottoPolitico;

public class SimpleOmbrellone implements Ombrellone{

    private long id;
    private boolean isLibero;
    private Categoria categoria;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public boolean getLibero() {
        return this.isLibero;
    }

    @Override
    public Categoria getCategoria() {
        return this.categoria;
    }

    @Override
    public void setLibero(boolean libero) {
        this.isLibero = libero;
    }

    @Override
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
