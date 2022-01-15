package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;

/**
 * Rappresenta un'ordinazione bar.
 *
 * @see ArticoloBar
 */
public interface OrdinazioneBar extends Vendita{

    /**
     * Ritorna l' {@link ArticoloBar} associato all'ordinazione.
     *
     * @return l'articolo bar associato all'ordinazione
     * @see ArticoloBar
     */
    ArticoloBar getArticoloBar();

    /**
     * Ritorna lo stato dell'ordinazione bar.
     *
     * @return lo stato dell'ordinazione bar
     */
    StatusOrdinazioneBar getStatus();

    /**
     * Imposta lo status dell'ordinazione bar.
     *
     * @param statusOrdinazioneBar il nuovo status dell'ordinazione bar
     * @throws NullPointerException se lo status &egrave; nullo
     */
    void setStatus(StatusOrdinazioneBar statusOrdinazioneBar);

    /**
     * Ritorna l'utente che ha effettuato l'ordinazione bar.
     *
     * @return l'utente che ha effettuato l'ordinazione bar
     */
    Utente getUtente();

}
