package it.unicam.cs.diciottoPolitico.casotto.entity;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimplePrenotazioneOmbrellone;

import java.util.List;

/**
 * Rappresenta una riga di un catalogo ombrelloni.
 * La riga &egrave; una tripla formata da {@link Ombrellone}, il prezzo associato a quest' ultimo e la lista delle prenotazioni dell' ombrellone.
 */
public interface RigaCatalogoOmbrellone extends RigaCatalogo<Ombrellone> {

    /**
     * Restituisce il prezzo associato all' ombrellone presente in questa riga.
     *
     * @return il prezzo associato all' ombrellone
     */
    double getPrezzoOmbrellone();

    /**
     * Imposta un nuovo prezzo all' {@link Ombrellone} di questa riga.
     *
     * @param nuovoPrezzo il nuovo prezzo da impostare all' ombrellone di questa riga.
     * @throws IllegalArgumentException se il prezzo specificato &egrave; minore di {@code 0}
     */
    void setPrezzoOmbrellone(double nuovoPrezzo);


}
