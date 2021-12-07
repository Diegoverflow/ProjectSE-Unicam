package it.unicam.cs.diciottoPolitico;

import java.util.Objects;

public class SimpleOmbrellone implements Ombrellone{

    private long id;
    private boolean isLibero;
    private Categoria categoria;


    public SimpleOmbrellone(long id, boolean isLibero, Categoria categoria) {
        this.id = id;
        this.isLibero = isLibero;
        this.categoria = Objects.requireNonNull(categoria,"La categoria non puo' essere nulla");
    }

    public SimpleOmbrellone(boolean isLibero, Categoria categoria) {
        this.isLibero = isLibero;
        this.categoria = categoria;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleOmbrellone)) return false;
        SimpleOmbrellone that = (SimpleOmbrellone) o;
        return getId() == that.getId() && getLibero() == that.getLibero() && getCategoria() == that.getCategoria();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLibero(), getCategoria());
    }
}
