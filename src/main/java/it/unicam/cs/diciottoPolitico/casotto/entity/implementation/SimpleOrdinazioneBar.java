package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.ArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.OrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.StatusOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;

import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.*;

/**
 * Semplice implementazione dell'interfaccia OrdinazioneBar.
 */
@Entity
@Table(name = "ordinazione_bar")
public class SimpleOrdinazioneBar implements OrdinazioneBar {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    private UUID id;

    @ManyToOne(targetEntity = SimpleArticoloBar.class)
    @JoinColumn(name = "articolo_bar_id")
    private ArticoloBar articoloBar;

    @Temporal(TemporalType.DATE)
    private GregorianCalendar dataAcquisto;

    @Column
    private double costo;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean pagato;

    @Enumerated(EnumType.STRING)
    private StatusOrdinazioneBar statusOrdinazioneBar;

    @ManyToOne(targetEntity = SimpleUtente.class)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    /**
     * Metodo costruttore.
     *
     * @param articoloBar l'articolo bar associato all'ordinazione
     * @param costo       costo dell'ordinazione bar
     * @param utente      l'utente che ha effettuato l'ordinazione bar
     * @throws NullPointerException     se l'articolo bar o l'utente sono nulli
     * @throws IllegalArgumentException se il costo è negativo
     */
    public SimpleOrdinazioneBar(ArticoloBar articoloBar, double costo, Utente utente) {
        this();
        this.dataAcquisto = new GregorianCalendar();
        if (costo < 0) throw new IllegalArgumentException("Il costo non puo' essere negativo");
        this.articoloBar = Objects.requireNonNull(articoloBar, "L'articolo bar non puo' essere nullo");
        this.costo = costo;
        this.pagato = false;
        this.statusOrdinazioneBar = StatusOrdinazioneBar.DA_PRENDERE_IN_CARICO;
        this.utente = utente;
    }

    protected SimpleOrdinazioneBar() {
        this.id= UUID.randomUUID();
    }

    @Override
    public UUID getCodice() {
        return this.id;
    }

    @Override
    public ArticoloBar getArticoloBar() {
        return this.articoloBar;
    }

    @Override
    public GregorianCalendar getDataAcquisto() {
        return this.dataAcquisto;
    }

    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public boolean isPagata() {
        return this.pagato;
    }

    @Override
    public void setIsPagata(boolean pagato) {
        this.pagato = pagato;
    }

    @Override
    public StatusOrdinazioneBar getStatus() {
        return null;
    }

    @Override
    public void setStatus(StatusOrdinazioneBar statusOrdinazioneBar) {
        this.statusOrdinazioneBar = Objects.requireNonNull(statusOrdinazioneBar, "Lo status non puo' essere nullo");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleOrdinazioneBar)) return false;
        SimpleOrdinazioneBar that = (SimpleOrdinazioneBar) o;
        return getCodice() == that.getCodice() && Double.compare(that.getCosto(), getCosto()) == 0 && getArticoloBar().equals(that.getArticoloBar()) && getDataAcquisto().equals(that.getDataAcquisto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodice(), getArticoloBar(), getDataAcquisto(), getCosto());
    }

    @Override
    public Utente getUtente() {
        return this.utente;
    }
}
