package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Semplice implementazione dell'interfaccia PrenotazioneAttivita.
 */
public class SimplePrenotazioneAttivita implements PrenotazioneAttivita {

    private long id;
    private final GregorianCalendar dataAcquisto;
    private boolean statoPagamento;
    private final double costo;
    private final Attivita attivita;
    private final Utente utente;

    /**
     * Costruisce una prenotazione attivit&agrave;
     *
     * @param id       della prenotazione
     * @param costo    della prenotazione
     * @param attivita da associare alla prenotazione
     * @throws NullPointerException se l'attivit&agrave; o l'utente sono nulli
     * @apiNote la data di acquisto &egrave; impostata automaticamente dal sistema alla data corrente
     * e lo stato di pagamento &egrave; impostato automaticamente a {@code false}
     */
    public SimplePrenotazioneAttivita(long id, double costo, Attivita attivita, Utente utente) {
        this.id = id;
        this.dataAcquisto = new GregorianCalendar();
        this.statoPagamento = false;
        this.costo = costo;
        this.attivita = Objects.requireNonNull(attivita, "Attivita nulla non valida");
        this.utente = Objects.requireNonNull(utente,"L'utente non puo' essere nullo");
    }

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
        this.dataAcquisto = new GregorianCalendar();
        this.statoPagamento = false;
        this.costo = costo;
        this.attivita = attivita;
        this.utente = Objects.requireNonNull(utente,"L'utente non puo' essere nullo");
    }

    @Override
    public long getCodice() {
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
