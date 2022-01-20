package it.unicam.cs.diciottoPolitico.casotto.entity;

import java.util.Date;
import java.util.GregorianCalendar;
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
     * Restituisce la lista delle prenotazioni associate all' ombrellone di questa riga.
     *
     * @return la lista delle prenotazioni di questa riga
     * @see PrenotazioneOmbrellone
     */
    List<PrenotazioneOmbrellone> getPrenotazioni();

    /**
     * Imposta un nuovo prezzo all' {@link Ombrellone} di questa riga.
     *
     * @param nuovoPrezzo il nuovo prezzo da impostare all' ombrellone di questa riga.
     * @throws IllegalArgumentException se il prezzo specificato &egrave; minore di {@code 0}
     */
    void setPrezzoOmbrellone(double nuovoPrezzo);

    /**
     * Aggiunge la {@link PrenotazioneOmbrellone} specificata a questa riga catalogo.
     * La prenotazione viene aggiunta in coda a tutte le prenotazioni associate all' ombrellone di questa riga.
     *
     * @param prenotazione la prenotazione da aggiungere
     * @return {@code true} se la prenotazione viene aggiunta con successo, {@code false} altrimenti.
     * @throws NullPointerException se la prenotazione specificata &egrave; {@code null}
     */
    boolean addPrenotazione(PrenotazioneOmbrellone prenotazione);
}
