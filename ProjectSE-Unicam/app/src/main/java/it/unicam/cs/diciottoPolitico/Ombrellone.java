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
     * Specifica se l'ombrellone &egrave; libero.
     *
     * @return true se l'ombrellone &egrave; libero, false altrimenti
     */
    boolean isLibero();

    /**
     * Ritorna la categoria dell'ombrellone.
     *
     * @return la categoria dell'ombrellone
     */
    Categoria getCategoria();

    /**
     * Imposta lo stato di disponibilit&agrave; dell'ombrellone.
     *
     * @param libero true se l'ombrellone &egrave; libero, false altrimenti
     */
    void setLibero(boolean libero);

    /**
     * Imposta la categoria dell'ombrellone.
     *
     * @param categoria la nuova categoria dell'ombrellone
     * @throws NullPointerException se la categoria &egrave; nulla
     */
    void setCategoria(Categoria categoria);
}
