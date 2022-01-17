package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un ombrellone.
 */
public interface Ombrellone {

    /**
     * Ritorna l'id dell'ombrellone.
     *
     * @return id dell'ombrellone
     */
    long getId();

    /**
     * Ottieni il codice identificativo dell'ombrellone sulla spieggia
     *
     * @return il codice dell'ombrellone
     */
    String getCodiceSpiaggia();

    /**
     * Specifica se l'ombrellone &egrave; libero.
     *
     * @return {@code true} se l'ombrellone &egrave; libero, {@code false} altrimenti
     */
    boolean isLibero();

    /**
     * Ritorna la {@link Categoria} dell'ombrellone.
     *
     * @return la categoria dell'ombrellone
     */
    Categoria getCategoria();

    /**
     * Imposta lo stato di disponibilit&agrave; dell'ombrellone.
     *
     * @param libero {@code true} se l'ombrellone &egrave; libero, {@code false} altrimenti
     */
    void setLibero(boolean libero);

    /**
     * Imposta la categoria dell'ombrellone.
     *
     * @param categoria la nuova categoria dell'ombrellone
     * @throws NullPointerException se la categoria &egrave; {@code null}
     */
    void setCategoria(Categoria categoria);
}
