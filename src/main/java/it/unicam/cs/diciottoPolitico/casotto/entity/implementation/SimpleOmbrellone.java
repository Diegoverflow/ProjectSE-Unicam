package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Categoria;
import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia Ombrellone.
 */
@Entity
@Table(name = "ombrellone")
public class SimpleOmbrellone implements Ombrellone {

    @Id
    @Column(columnDefinition = "BINARY(16)",updatable = false,unique = true,nullable = false)
    private final UUID id;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column
    private String codiceSpiaggia;

    /**
     * Costruisce un Ombrellone secondo i seguenti parametri:
     *
     * @param categoria      dell'ombrellone
     * @param codiceSpiaggia dell'ombrellone
     */
    public SimpleOmbrellone(Categoria categoria, String codiceSpiaggia) {
        this();
        this.categoria = categoria;
        this.codiceSpiaggia = codiceSpiaggia;
    }

    protected SimpleOmbrellone() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public String getCodiceSpiaggia() {
        return this.codiceSpiaggia;
    }

    @Override
    public Categoria getCategoria() {
        return this.categoria;
    }

    @Override
    public void setCategoria(Categoria categoria) {
        this.categoria = Objects.requireNonNull(categoria, "La categoria non puo' essere nulla");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleOmbrellone)) return false;
        SimpleOmbrellone that = (SimpleOmbrellone) o;
        return getId() == that.getId() && getCategoria() == that.getCategoria();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getCategoria());
    }
}
