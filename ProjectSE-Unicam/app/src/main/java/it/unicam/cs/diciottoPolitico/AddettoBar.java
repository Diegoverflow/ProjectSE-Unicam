package it.unicam.cs.diciottoPolitico;

// TODO: Modificare javadoc


import java.util.Queue;

/**
 * Rappresenta un addetto bar che si occupa di effettuare principalmente operazioni inerenti
 * alle ordinazioni bar. In particolare si occoupa  di prendere in carico un' ordinazione del bar,
 * di consegnarla al cliente e di eliminare la notifica relativa a quell' ordine.
 */
public interface AddettoBar extends UtenteLoggato{

    /**
     * Ritorna una coda di una ordini consegnati dall'addetto bar.
     *
     * @return una coda di una ordini consegnati dall'addetto bar.
     */
    Queue<OrdinazioneBar> getordinazioniBarConsegnate();

}
