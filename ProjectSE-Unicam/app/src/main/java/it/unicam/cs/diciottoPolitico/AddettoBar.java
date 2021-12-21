package it.unicam.cs.diciottoPolitico;

import java.util.Queue;

/**
 * Rappresenta un addetto bar che si occupa di effettuare principalmente operazioni inerenti
 * alle ordinazioni bar. In particolare prender&agrave; in carico un' ordinazione del bar,
 * la consegnarer&agrave; al cliente ed eliminer&agrave; la notifica relativa a quell' ordine.
 */
public interface AddettoBar extends UtenteLoggato {

    /**
     * Ritorna una coda di una ordini consegnati da questo addetto bar.
     *
     * @return una coda di una ordini consegnati da questo addetto bar
     */
    Queue<OrdinazioneBar> getordinazioniBarConsegnate();

}
