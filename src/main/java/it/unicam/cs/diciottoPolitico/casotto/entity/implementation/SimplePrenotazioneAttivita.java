package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Attivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia PrenotazioneAttivita.
 */
@Entity
@Table(name = "prenotazione_attivita")
public class SimplePrenotazioneAttivita implements PrenotazioneAttivita {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Temporal(TemporalType.DATE)
    private GregorianCalendar dataAcquisto;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean statoPagamento;

    @Column
    private double costo;

    @ManyToOne(targetEntity = SimpleAttivita.class)
    @JoinColumn(name = "attivita_id")
    private Attivita attivita;

    @ManyToOne(targetEntity = SimpleUtente.class)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    /**
     * Costruisce una prenotazione attivit&agrave;
     *
     * @param costo    della prenotazione
     * @param attivita da associare alla prenotazione
     * @throws NullPointerException se l'attivit&agrave; o l'utente sono nulli
     * @apiNote la data di acquisto &egrave; impostata automaticamente dal sistema alla data corrente
     * e lo stato di pagamento &egrave; impostato automaticamente a {@code false}
     */
    public SimplePrenotazioneAttivita(double costo, Attivita attivita, Utente utente) {
        this();
        this.dataAcquisto = new GregorianCalendar();
        this.statoPagamento = false;
        this.costo = costo;
        this.attivita = attivita;
        this.utente = Objects.requireNonNull(utente, "L'utente non puo' essere nullo");
    }

    protected SimplePrenotazioneAttivita() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getCodice() {
        return this.id;
    }

    @Override
    public GregorianCalendar getDataAcquisto() {
        return this.dataAcquisto;
    }

    @Override
    public boolean isPagata() {
        return this.statoPagamento;
    }

    @Override
    public void setIsPagata(boolean statoPagamento) {
        this.statoPagamento = statoPagamento;
    }

    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public Attivita getAttivita() {
        return this.attivita;
    }

    @Override
    public Utente getUtente() {
        return this.utente;
    }
}
