package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;

/**
 * Interfaccia che descrive una prenotazione di un ombrellone.
 */
public interface PrenotazioneOmbrellone {

    /**
     * Ottieni il codice associato all'ombrellone.
     * @return il codice dell'ombrellone
     */
    long getId();

    /**
     * Ottieni la data in cui &egrave; riservata la prenotazione.
     * @return la data di prenotazione
     */
    GregorianCalendar getDataPrenotazione();

    /**
     * Ottieni la da in cui la prenotazione &egrave; stata acquistata.
     * @return la data di acquisto della prenotazione
     */
    GregorianCalendar getDataAcquisto();

    /**
     * Ottieni lo stato di pagamento della prenotazione.
     * @return true se la prenotazione &grave; stata gi&agrave; saldata,
     *         false altrimenti
     */
    boolean getStatoPagamento();

    /**
     * Ottieni il costo della prenotazione.
     * @return il costo della prenotazione
     */
    double getCosto();

    /**
     * Ottieni l'ombrellone associato alla prenotazione
     * @return l'ombrellone della prenotazione
     */
    Ombrellone getOmbrellone();

    /**
     * Ottieni la fascia oraria nella quale la prenotazione &egrave; riservata.
     * @return la fascia oraria della prenotazione
     */
    FasciaOraria getFasciaOraria();
}
