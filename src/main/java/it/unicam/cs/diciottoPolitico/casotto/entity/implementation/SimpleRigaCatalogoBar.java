package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;
import it.unicam.cs.diciottoPolitico.casotto.entity.ArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoBar;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia RigaCatalogoBar.
 */
@Entity
@Table(name = "riga_catalogo_bar")
public class SimpleRigaCatalogoBar implements RigaCatalogoBar {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    private final UUID id;

    @OneToOne(targetEntity = SimpleArticoloBar.class)
    @JoinColumn(name = "articolo_bar_id", referencedColumnName = "id")
    private ArticoloBar articoloBar;

    @Column
    private double prezzo;

    @Column
    private int quantita;

    /**
     * Metodo costruttore.
     *
     * @param articoloBar l'articolo bar associato alla riga
     * @param prezzo il prezzo associato alla riga
     * @param quantita la quantit&agrave; di articoli bar contenuti nella riga
     * @throws NullPointerException se l'articolo &egrave; nullo
     */
    public SimpleRigaCatalogoBar(ArticoloBar articoloBar, double prezzo, int quantita) {
        this();
        this.articoloBar = Objects.requireNonNull(articoloBar,"L'articolo bar non puo' essere nullo");
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    protected SimpleRigaCatalogoBar() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId(){
        return this.id;
    }
    @Override
    public ArticoloBar getValore() {
        return this.articoloBar;
    }

    @Override
    public double getPrezzo() {
        return this.prezzo;
    }

    @Override
    public int getQuantita() {
        return this.quantita;
    }

    @Override
    public void setQuantita(int quantita) {
        if(quantita < 0)
            throw new IllegalArgumentException("La quantita' deve essere maggiore di 0");
        this.quantita = quantita;
    }

    @Override
    public void setPrezzo(double prezzo) {
        if(prezzo < 0)
            throw new IllegalArgumentException("Il prezzo deve essere maggiore di 0");
        this.prezzo = prezzo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleRigaCatalogoBar)) return false;
        SimpleRigaCatalogoBar that = (SimpleRigaCatalogoBar) o;
        return Double.compare(that.getPrezzo(), getPrezzo()) == 0 && getQuantita() == that.getQuantita() && articoloBar.equals(that.articoloBar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articoloBar, getPrezzo(), getQuantita());
    }
}
