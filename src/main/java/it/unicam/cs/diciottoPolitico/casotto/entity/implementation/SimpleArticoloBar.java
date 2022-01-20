package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.ArticoloBar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia {@link ArticoloBar}.
 */
@Entity
@Table(name="articoli_bar")
public class SimpleArticoloBar implements ArticoloBar {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private final UUID id;

    @Column
    private String descrizione;

    /**
     * Metodo Costruttore.
     *
     * @param descrizione descrizione dell' articolo bar
     * @throws NullPointerException se la descrizione &egrave; {@code null}
     */
    public SimpleArticoloBar(String descrizione) {
        this();
        this.descrizione = Objects.requireNonNull(descrizione, "La descrizione deve essere non nulla");
    }

    protected SimpleArticoloBar(){
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
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
