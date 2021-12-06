package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un articolo bar
 */
public interface ArticoloBar {

    /**
     * Ritorna l'id dell'articolo bar.
     *
     * @return id dell'articolo bar
     */
    long getId();

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
     */
    void setDescrizione(String descrizione);
}
