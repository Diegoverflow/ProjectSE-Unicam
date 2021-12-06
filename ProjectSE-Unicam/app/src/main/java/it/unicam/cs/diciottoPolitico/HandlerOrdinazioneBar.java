package it.unicam.cs.diciottoPolitico;

import java.util.List;

/**
 * Rappresenta un gestore di ordinazioni bar.
 * In particolare esso si occupa di gestire le ordinazioni effettuate al bar da parte
 * dei clienti e di notificare gli addetti del bar per, a loro volta,  gestire tali ordinazioni.
 */
public interface HandlerOrdinazioneBar {

    /**
     * Restituisce una lista di righe catalogo bar.
     *
     * @return la lista di righe catalogo bar
     */
    List<Object> getRigheArticoliDisponibili();
    // TODO: Refactor di Object con RigaCatalogoBar

    /**
     * Crea un' ordinazione bar secondo l' ordinazione bar ed il cliente specificati.
     * Precisamente il cliente specificato &egrave; colui che ha effettuato un' ordinazione.
     * Restituisce true se la creazione dell' ordinazione bar va a buon fine, false altrimenti.
     *
     * @param ordinazioneBar l' ordinazione bar da creare
     * @param cliente        il cliente che ha effettuato l' ordinazione bar
     * @return true se la creazione dell' ordinazione va a buon fine, false altrimenti.
     */
    boolean creaOrdinazione(Object ordinazioneBar, Cliente cliente);    // TODO: Refactor di Object con OrdinazioneBar

    /**
     * Restituisce la lista di tutte le ordinazioni bar ancora da consegnare ai clienti.
     *
     * @return la lista di tutte le ordinazioni non consegnate.
     */
    List<Object> getOrdinazioniDaConsegnare();  // TODO: Refactor di Object con OrdinazioneBar

    // TODO: Check per id ordinazione bar

    // TODO: metodo per aggiungere/modificare/rimuovere addetti bar

}
