package it.unicam.cs.diciottoPolitico.casotto.entity;

import java.util.List;

/**
 * Rappresenta una riga nel catalogo attivit&agrave;, la riga è formata da un {@link Attivita}, dal prezzo di quest' ultima.
 */
public interface RigaCatalogoAttivita extends RigaCatalogo<Attivita> {

    /**
     * Restituisce il prezzo associato all' {@link Attivita} contenuta in questa riga del catalogo attivit&agrave;.
     *
     * @return il prezzo dell' attivit&agrave; di questa riga presente nel catalogo attivit&agrave;
     */
    double getPrezzo();

    /**
     * Imposta il prezzo specificato all' {@link Attivita} contenuta in questa riga del catalogo attivit&agrave;.
     *
     * @param prezzo il nuovo prezzo che sar&agrave; associato all' {@link Attivita} contenuta in questa riga del catalogo attivit&agrave;
     * @throws IllegalArgumentException se il prezzo &egrave; minore di {@code 0}
     */
    void setPrezzo(double prezzo);

    /**
     * Ottieni il numero massimo dei posti prenotabili associati all'attivit&agrave;
     * @return il numero massimo dei posti prenotabili associati all'attivit&agrave;
     */
    int getPostiTotali();

    /**
     * Ottieni la lista delle prenotazioni associate associate all'attivit&agrave;
     * @return la lista delle prenotazioni associate associate all'attivit&agrave;
     */
    List<PrenotazioneAttivita> getPrenotazioniAttivita();

}
