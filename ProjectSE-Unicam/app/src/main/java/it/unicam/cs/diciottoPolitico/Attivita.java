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
     * Aumenta di 1 il numero di posti occupati.
     * Restituisce {@code true} se la modifica del numero di posti occupati &egrave; andata a buon fine, {@code false} altrimenti.
     *
     * @return {@code true} se il numero di posti occupati diventa uguale al numero di posti totali, {@code false} altrimenti
     */
    boolean aggiungiPostoOccupato();

}
