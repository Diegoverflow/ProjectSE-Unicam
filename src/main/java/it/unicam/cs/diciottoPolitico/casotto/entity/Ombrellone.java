package it.unicam.cs.diciottoPolitico.casotto.entity;

import java.util.UUID;

/**
 * Rappresenta un ombrellone.
 */
public interface Ombrellone {

    /**
     * Ritorna l'id dell'ombrellone.
     *
     * @return id dell'ombrellone
     */
    UUID getId();

    /**
     * Ottieni il codice identificativo dell'ombrellone sulla spieggia
     *
     * @return il codice dell'ombrellone
     */
    String getCodiceSpiaggia();

    /**
     * Imposta il codice spiaggia dell'ombrellone
     */
    void setCodiceSpiaggia(String codiceSpiaggia);

    /**
     * Ritorna la {@link Categoria} dell'ombrellone.
     *
     * @return la categoria dell'ombrellone
     */
    Categoria getCategoria();

    /**
     * Imposta la categoria dell'ombrellone.
     *
     * @param categoria la nuova categoria dell'ombrellonez
     */
    void setCategoria(Categoria categoria);
}
