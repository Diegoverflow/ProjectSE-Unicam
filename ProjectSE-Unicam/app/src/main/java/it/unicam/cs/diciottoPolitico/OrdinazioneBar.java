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
     * Specifica se un'ordinazione &egrave; stata consegnata.
     *
     * @return {@code true} se l'ordinazione &egrave; stata consegnata, {@code false} altrimenti
     */
    boolean isConsegnato();

    /**
     * Specifica se un'ordinazione &egrave; stata pagata.
     *
     * @return {@code true} se l'ordinazione &egrave; stata pagata, {@code false} altrimenti
     */
    boolean isPagato();

    /**
     * Specifica se un'ordinazione &egrave; stata presa in carico.
     *
     * @return {@code true} se l'ordinazione &egrave; stata presa in carico, {@code false} altrimenti
     */
    boolean isPresoInCarico();

    /**
     * Imposta lo stato di pagamento dell'ordinazione bar.
     *
     * @param pagato {@code true} se l'ordinazione &egrave; stata pagata, {@code false} altrimenti
     */
    void setPagato(boolean pagato);

    /**
     * Imposta lo stato di consegna dell'ordinazione bar.
     *
     * @param consegnato {@code true} se l'ordinazione &egrave; stata consegnata, {@code false} altrimenti
     */
    void setConsegnato(boolean consegnato);

    /**
     * Imposta lo stato stato di presa in carico dell'ordinazione bar
     *
     * @param presoInCarico {@code true} se l'ordinazione &egrave; stata presa in carico, {@code false} altrimenti
     */
    void setPresoInCarico(boolean presoInCarico);

}
