package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;

public class SimplePrenotazioneAttivita implements PrenotazioneAttivita {

    private long id;
    private final GregorianCalendar dataAcquisto;
    private boolean statoPagamento;
    private final double costo;
    private final Attivita attivita;

    /**
     * Costruisce una prenotazione attivit&agrave;
     *
     * @param id       della prenotazione
     * @param costo    della prenotazione
     * @param attivita da associare alla prenotazione
     * @apiNote la data di acquisto &egrave; impostata automaticamente dal sistema alla data corrente
     * e lo stato di pagamento &egrave; impostato automaticamente a {@code false}
     */
    public SimplePrenotazioneAttivita(long id, double costo, Attivita attivita) {
        if (attivita == null)
            throw new NullPointerException("Attivita nulla non valida");
        this.id = id;
        this.dataAcquisto = new GregorianCalendar();
        this.statoPagamento = false;
        this.costo = costo;
        this.attivita = attivita;
    }

    /**
     * Costruisce una prenotazione attivit&agrave;
     *
     * @param costo    della prenotazione
     * @param attivita da associare alla prenotazione
     * @apiNote la data di acquisto &egrave; impostata automaticamente dal sistema alla data corrente
     * e lo stato di pagamento &egrave; impostato automaticamente a {@code false}
     */
    public SimplePrenotazioneAttivita(double costo, Attivita attivita) {
        this.dataAcquisto = new GregorianCalendar();
        this.statoPagamento = false;
        this.costo = costo;
        this.attivita = attivita;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public GregorianCalendar getDataAcquisto() {
        return this.dataAcquisto;
    }

    @Override
    public boolean getStatoPagamento() {
        return this.statoPagamento;
    }

    @Override
    public void setStatoPagamento(boolean statoPagamento) {
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
}
