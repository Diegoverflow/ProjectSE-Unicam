package it.unicam.cs.diciottoPolitico;

import java.util.Objects;

/**
 * Semplice implementazione dell'interfaccia Ombrellone.
 */
public class SimpleOmbrellone implements Ombrellone{

    private long id;
    private boolean isLibero;
    private Categoria categoria;

    /**
     * Metodo costruttore.
     *
     * @param categoria la categoria dell'ombrellone
     */
    public SimpleOmbrellone(Categoria categoria) {
        this.isLibero = false;
        this.categoria = Objects.requireNonNull(categoria,"La categoria non puo' essere nulla");
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public boolean isLibero() {
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
        this.categoria = Objects.requireNonNull(categoria,"La categoria non puo' essere nulla");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleOmbrellone)) return false;
        SimpleOmbrellone that = (SimpleOmbrellone) o;
        return getId() == that.getId() && isLibero() == that.isLibero() && getCategoria() == that.getCategoria();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isLibero(), getCategoria());
    }
}
