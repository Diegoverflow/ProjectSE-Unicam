package it.unicam.cs.diciottoPolitico.casotto.entity;

import java.util.UUID;

/**
 * Rappresenta un articolo bar.
 */
public interface ArticoloBar {

    /**
     * Ritorna l'id dell'articolo bar.
     *
     * @return id dell'articolo bar
     */
    UUID getId();

    /**
     * Ritorna la descrizione dell'articolo bar.
     *
     * @return descrizione dell'articolo bar
     */
    String getDescrizione();

    /**
     * Imposta una nuova descrizione per l'articolo bar.
     *
     * @param descrizione nuova descrizione
     * @throws NullPointerException se la descrizione &egrave; {@code null}
     */
    void setDescrizione(String descrizione);
}
