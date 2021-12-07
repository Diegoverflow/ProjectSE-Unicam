package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;

/**
 * Rappresenta un'ordinazione bar.
 */
public interface OrdinazioneBar {

    /**
     * Ritorna l'id dell'ordinazione bar.
     *
     * @return id dell'ordinazione bar
     */
    long getId();

    /**
     * Ritorna l'articolo bar associato all'ordinazione.
     *
     * @return l'articolo bar associato all'ordinazione
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
     * @return true se l'ordinazione &egrave; stata consegnata, false altrimenti
     */
    boolean isConsegnato();

    /**
     * Specifica se un'ordinazione &egrave; stata pagata.
     *
     * @return true se l'ordinazione &egrave; stata pagata, false altrimenti
     */
    boolean isPagato();

    /**
     * Specifica se un'ordinazione &egrave; stata presa in carico.
     *
     * @return true se l'ordinazione &egrave; stata presa in carico, false altrimenti
     */
    boolean isPresoInCarico();

    /**
     * Imposta lo stato di pagamento dell'ordinazione bar.
     *
     * @param pagato true se l'ordinazione &egrave; stata pagata, false altrimenti
     */
    void setPagato(boolean pagato);

    /**
     * Imposta lo stato di consegna dell'ordinazione bar.
     *
     * @param consegnato true se l'ordinazione &egrave; stata consegnata, false altrimenti
     */
    void setConsegnato(boolean consegnato);

    /**
     * Imposta lo stato stato di presa in carico dell'ordinazione bar
     *
     * @param presoInCarico true se l'ordinazione &egrave; stata presa in carico, false altrimenti
     */
    void setPresoInCarico(boolean presoInCarico);

}
