package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;

/**
 * Interfaccia che descrive un'attvit&agrave;
 */
public interface Attivita {

    /**
     * Ottieni l'identificativo dell'attivit&agrave;
     *
     * @return l'id dell'attivit&agrave;
     */
    long getId();

    /**
     * Ottieni l'orario di inizio dell'attivit&agrave;
     *
     * @return l'orario di inizio dell'attivit&agrave;
     */
    GregorianCalendar getDataOrarioInizio();

    /**
     * Ottieni l'ora in cui l'attivit&agrave; termina
     *
     * @return l'ora a in cui termina l'attivit&agrave;
     */
    GregorianCalendar getDataOrarioFine();

    /**
     * Ottieni la descrizione dell'attivit&agrave;
     *
     * @return la descrizione dell'attivit&agrave;
     */
    String getDescrizione();

    /**
     * Imposta la descrizione dell'attivit&agrave;
     *
     * @param descrizione da impostare
     */
    void setDescrizione(String descrizione);

    /**
     * Ottieni il numero massimo di partecipanti all'attivit&agrave;
     *
     * @return il numero di posti totali
     */
    int getPostiTotali();

    /**
     * Ottieni il numero di partecipanti iscritti all'attivit&agrave;
     *
     * @return il numero di partecipanti iscritti all'attivit&agrave;
     */
    int getPostiOccupati();

    /**
     * Imposta i posti occupati dell'attivit&agrave;.
     *
     * @return {@code true} se il nuovo numero di posti occupati &egrave; compreso tra 0 (incluso) e i posti totali (incluso) dell'attivit&agrave;, {@code false} altrimenti
     */
    boolean setPostiOccupati(int postiOccupati);

}
