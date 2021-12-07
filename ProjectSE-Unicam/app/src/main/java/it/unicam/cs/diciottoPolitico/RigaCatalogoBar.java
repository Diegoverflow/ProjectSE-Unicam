package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta una riga nel catalogo bar, la riga è formata da un articolo bar,dal prezzo e dalla quantit&agrave di articoli disponibili.
 */
public interface RigaCatalogoBar extends RigaCatalogo<ArticoloBar>{

    /**
     * Ritorna il prezzo contenuto nella riga.
     *
     * @return il prezzo nella riga
     */
    double getPrezzo();

    /**
     * Ritorna la quantit&agrave; di articoli bar che la riga ha a disposizione.
     *
     * @return la quantit&agrave; di articoli bar che la riga ha a disposizione
     */
    int getQuantita();

    /**
     * Imposta la quantit&agrave; di articoli bar associati alla riga.
     *
     * @param quantita la nuova quantit&agrave; di articoli bar associati alla riga
     * @throws IllegalArgumentException se la quantit&agrave; &egrave; minore di 0
     */
    void setQuantita(int quantita);

    /**
     * Imposta il prezzo contenuto nella riga.
     *
     * @param prezzo il nuovo prezzo contenuto nella riga
     * @throws IllegalArgumentException se il prezzo &egrave; minore di 0
     *
     */
    void setPrezzo(double prezzo);
}
