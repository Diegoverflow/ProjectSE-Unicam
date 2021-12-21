package it.unicam.cs.diciottoPolitico;

import java.util.Objects;

/**
 * Semplice implementazione dell'interfaccia {@link ArticoloBar}.
 */
public class SimpleArticoloBar implements ArticoloBar {
    private long id;
    private String descrizione;

    /**
     * Metodo Costruttore.
     *
     * @param descrizione descrizione dell' articolo bar
     * @throws NullPointerException se la descrizione &egrave; {@code null}
     */
    public SimpleArticoloBar(String descrizione) {
        this.descrizione = Objects.requireNonNull(descrizione, "La descrizione deve essere non nulla");
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getDescrizione() {
        return this.descrizione;
    }

    @Override
    public void setDescrizione(String descrizione) {
        this.descrizione = Objects.requireNonNull(descrizione, "La descrizione deve essere non nulla");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleArticoloBar)) return false;
        SimpleArticoloBar that = (SimpleArticoloBar) o;
        return getId() == that.getId() && getDescrizione().equals(that.getDescrizione());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescrizione());
    }
}
