package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;

/**
 * Rappresenta un'ordinazione bar.
 *
 * @see ArticoloBar
 */
public interface OrdinazioneBar {

    /**
     * Ritorna l'id dell'ordinazione bar.
     *
     * @return id dell'ordinazione bar
     */
    long getId();

    /**
     * Ritorna l' {@link ArticoloBar} associato all'ordinazione.
     *
     * @return l'articolo bar associato all'ordinazione
     * @see ArticoloBar
     */
    ArticoloBar getArticoloBar();

    /**
     * Ritorna la data di acquisto dell'ordinazione bar.
     *
     * @return data di acquisto dell'ordinazione bar
     */
    GregorianCalendar getDataAcquisto();

    /**
     * Ritorna il costo dell'ordinazione bar.
     *
     * @return costo dell'ordinazione bar
     */
    double getCosto();

    /**
     * Specifica se un'ordinazione &egrave; stata pagata.
     *
     * @return {@code true} se l'ordinazione &egrave; stata pagata, {@code false} altrimenti
     */
    boolean isPagato();

    /**
     * Imposta lo stato di pagamento dell'ordinazione bar.
     *
     * @param pagato {@code true} se l'ordinazione &egrave; stata pagata, {@code false} altrimenti
     */
    void setPagato(boolean pagato);

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
