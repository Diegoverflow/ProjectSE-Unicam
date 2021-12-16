package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;

/**
 * Interfaccia che descrive una prenotazione di un'attivit&agrave;
 *
 * @see Attivita
 */
public interface PrenotazioneAttivita {

    /**
     * Ottieni l'identificativo della prenotazione attivit&agrave;
     *
     * @return l'identificativo della prenotazione attivit&agrave;
     */
    long getId();

    /**
     * Ottieni la data di acquisto della prenotazione
     *
     * @return la data di acquisto della prenotazione
     */
    GregorianCalendar getDataAcquisto();

    /**
     * Ottieni lo stato del pagamento della prenotazione
     *
     * @return {@code true} se la prenotazione &egrave; stata saldata,
     * {@code false} altrimenti
     */
    boolean getStatoPagamento();

    /**
     * Imposta lo stato di pagamento della prenotazione attivit&agrave;
     *
     * @param statoPagamento da impostare
     */
    void setStatoPagamento(boolean statoPagamento);

    /**
     * Ottieni il costo di una prenotazione attivit&agrave;
     *
     * @return il costo della prenotazione
     */
    double getCosto();

    /**
     * Ottieni l'attivit&agrave; associata alla prenotazione
     *
     * @return l'attivit&agrave; associata alla prenotazione
     * @see Attivita
     */
    Attivita getAttivita();

}
