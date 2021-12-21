package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta una riga nel catalogo bar, la riga &egrave; formata da un {@link ArticoloBar}, dal prezzo di quest' ultimo e dalla quantit&agrave
 * di articoli bar attualmente disponibili nello chalet.
 */
public interface RigaCatalogoBar extends RigaCatalogo<ArticoloBar> {

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
     * @throws IllegalArgumentException se la quantit&agrave; &egrave; minore di {@code 0}
     */
    void setQuantita(int quantita);

    /**
     * Imposta il prezzo contenuto nella riga.
     *
     * @param prezzo il nuovo prezzo contenuto nella riga
     * @throws IllegalArgumentException se il prezzo &egrave; minore di {@code 0}
     */
    void setPrezzo(double prezzo);
}
