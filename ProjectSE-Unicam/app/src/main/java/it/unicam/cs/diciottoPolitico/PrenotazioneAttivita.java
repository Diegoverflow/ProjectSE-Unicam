package it.unicam.cs.diciottoPolitico;

/**
 * Interfaccia che descrive una prenotazione di un'attivit&agrave;
 *
 * @see Attivita
 */
public interface PrenotazioneAttivita extends Vendita{

    /**
     * Ottieni l'attivit&agrave; associata alla prenotazione
     *
     * @return l'attivit&agrave; associata alla prenotazione
     * @see Attivita
     */
    Attivita getAttivita();

    /**
     * Ritorna l'utente che ha effettuato la prenotazione dell'attivit&agrave;.
     *
     * @return l'utente che ha effettuato la prenotazione dell'attivit&agrave;
     */
    Utente getUtente();

}
