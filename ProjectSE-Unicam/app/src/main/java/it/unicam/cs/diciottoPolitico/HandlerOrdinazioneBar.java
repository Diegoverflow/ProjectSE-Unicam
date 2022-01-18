package it.unicam.cs.diciottoPolitico;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Rappresenta un gestore di ordinazioni bar.
 * In particolare esso si occupa di gestire le ordinazioni effettuate al bar da parte
 * dei clienti e di notificare gli addetti bar per, a loro volta, gestire tali ordinazioni.
 *
 * @see OrdinazioneBar
 * @see ArticoloBar
 * @see AddettoBar
 * @see Cliente
 */
public interface HandlerOrdinazioneBar {

    /**
     * Restituisce una lista degli articoli bar disponibili.
     *
     * @return la lista degli articoli bar disponibili
     * @see ArticoloBar
     */
    List<ArticoloBar> getArticoliDisponibili();

    /**
     * Prende in carico un'ordinazione bar.
     *
     * @param ordinazioneBar l'ordinazione bar da prendere in carico
     * @return true se lo status dell'ordinazione bar &egrave; stato impostato in PRESO_IN_CARICO
     * @throws NullPointerException se l'ordinazione bar &egrave; nulla
     * @throws IllegalArgumentException se l'ordinazione bar non &egrave; presente tra le ordinazioni effettuate
     */
    boolean prendiInCaricoOrdinazioneBar(OrdinazioneBar ordinazioneBar);

    /**
     * Consegna un'ordinazione bar.
     *
     * @param ordinazioneBar l'ordinazione bar da consegnare
     * @return true se lo status dell'ordinazione bar &egrave; stato impostato in CONSEGNATO
     * @throws NullPointerException se l'ordinazione bar &egrave; nulla
     * @throws IllegalArgumentException se l'ordinazione bar non &egrave; presente tra le ordinazioni effettuate
     */
    boolean consegnaOrdinazioneBar(OrdinazioneBar ordinazioneBar);

    /**
     * Crea {@link OrdinazioneBar} secondo la riga catalogo bar ed il {@link Cliente} specificati.
     * Precisamente il cliente specificato &egrave; colui che ha effettuato l' ordinazione bar.
     * Restituisce {@code true} se la creazione dell' ordinazione bar va a buon fine, {@code false} altrimenti.
     *
     * @param rigaCatalogoBar la riga usata per creare l'ordinazione bar
     * @param utente        l'utente che ha effettuato l' ordinazione bar
     * @return {@code true} se la creazione dell' ordinazione va a buon fine, {@code false} altrimenti
     * @throws NullPointerException se uno qualsiasi dei parametri &egrave; nullo
     * @see OrdinazioneBar
     * @see Cliente
     */
    boolean creaOrdinazioneBar(RigaCatalogoBar rigaCatalogoBar, Utente utente);

    /**
     * Ritorna tutte le ordinazioni bar effettuate.
     *
     * @return tutte le ordinazioni bar effettuate
     */
    List<OrdinazioneBar> getOrdinazioniBar();

    /**
     * Ritorna tutte le ordinazioni bar da prendere in carico.
     *
     * @return tutte le ordinazioni bar da prendere in carico
     */
    List<OrdinazioneBar> getOrdinazioniDaPrendereInCarico();

    /**
     * Ritorna tutte le ordinazioni bar da consegnare.
     *
     * @return tutte le ordinazioni bar da consegnare
     */
    List<OrdinazioneBar> getOrdinazioniDaConsegnare();

    /**
     * Rimuove una ordinazione bar.
     *
     * @param ordinazioneBar l'ordinazione bar da rimuovere
     * @return true se l'ordinazione bar &egrave; stata rimossa, false se la l'ordinazione bar non era presente
     * @throws NullPointerException se l'ordinazione bar &egrave; nulla
     */
    boolean removeOrdinazioneBar(OrdinazioneBar ordinazioneBar);
}
