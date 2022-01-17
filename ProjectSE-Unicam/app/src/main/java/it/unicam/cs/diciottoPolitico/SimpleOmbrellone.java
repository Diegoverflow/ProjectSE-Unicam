package it.unicam.cs.diciottoPolitico;

import java.util.Objects;

/**
 * Semplice implementazione dell'interfaccia Ombrellone.
 */
public class SimpleOmbrellone implements Ombrellone{

    private long id;
    private boolean isLibero;
    private Categoria categoria;
    private final String codiceSpiaggia;

    /**
     * Costruisce un Ombrellone secondo i seguenti parametri:
     * @param id dell'ombrellone
     * @param isLibero dell'ombrellone
     * @param categoria dell'ombrellone
     * @param codiceSpiaggia dell'ombrellone
     */
    public SimpleOmbrellone(long id, boolean isLibero, Categoria categoria, String codiceSpiaggia) {
        this(isLibero, categoria, codiceSpiaggia);
        this.id = id;
    }

    /**
     * Costruisce un Ombrellone secondo i seguenti parametri:
     * @param isLibero dell'ombrellone
     * @param categoria dell'ombrellone
     * @param codiceSpiaggia dell'ombrellone
     */
    public SimpleOmbrellone(boolean isLibero, Categoria categoria, String codiceSpiaggia) {
        this.isLibero = isLibero;
        this.categoria = categoria;
        this.codiceSpiaggia = codiceSpiaggia;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getCodiceSpiaggia() {
        return this.codiceSpiaggia;
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
