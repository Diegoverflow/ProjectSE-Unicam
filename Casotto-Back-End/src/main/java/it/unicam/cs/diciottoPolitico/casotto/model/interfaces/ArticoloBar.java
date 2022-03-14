package it.unicam.cs.diciottoPolitico.casotto.model.interfaces;

import it.unicam.cs.diciottoPolitico.casotto.model.TipoArticoloBar;

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

    /**
     * Restituisce il tipo di questo articolo bar.
     *
     * @return il tipo di questo articolo bar
     */
    TipoArticoloBar getTipoArticoloBar();

    /**
     * Imposta il tipo specificato a questo articolo bar.
     *
     * @param tipo il tipo da specificare a questo articolo bar
     */
    void setTipoArticoloBar(TipoArticoloBar tipo);

    /**
     * Restituisce il nome di questo articolo bar.
     *
     * @return il nome di questo articolo bar
     */
    String getNome();

    /**
     * Imposta il nome specificato a questo articolo bar.
     *
     * @param nome il nome da specificare a questo articolo bar
     */
    void setNome(String nome);
}
