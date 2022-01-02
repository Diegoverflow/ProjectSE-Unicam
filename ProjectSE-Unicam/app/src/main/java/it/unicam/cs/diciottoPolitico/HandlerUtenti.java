package it.unicam.cs.diciottoPolitico;

import java.util.List;

/**
 * Rappresenta un gestore di utenti.
 * L'implementazione di questa interfaccia deve essere fatta attraverso una classe singleton.
 *
 * @see TipologiaUtente
 * @see UtenteLoggato
 */
public interface HandlerUtenti {

    /**
     * Crea un {@link Cliente}.
     *
     * @param password password del cliente
     * @param nome nome del cliente
     * @param cognome cognome del cliente
     * @param cellulare cellulare del cliente
     * @return true se il cliente non era già stato creato, false altrimenti
     */
    boolean creaCliente(String password, String nome, String cognome, String cellulare, String email);

    /**
     * Crea un {@link AddettoBar}.
     *
     * @param password password dell'addetto bar
     * @param nome nome dell'addetto bar
     * @param cognome cognome dell'addetto bar
     * @param cellulare cellulare dell'addetto bar
     * @return true se l'addetto bar non era già stato creato, false altrimenti
     * @throws NullPointerException se uno dei parametri &egrave; null
     */
    boolean creaAddettoBar(String password, String nome, String cognome, String cellulare);

    /**
     * Ritorna tutti i clienti creati.
     *
     * @return tutti i clienti creati
     */
    List<Cliente> getClienti();

    /**
     * Ritorna tutti gli addetti bar creati.
     *
     * @return tutti gli addetti bar creati
     */
    List<AddettoBar> getAddettiBar();

    /**
     * Elimina un utente.
     *
     * @param id id dell'utente da eliminare
     * @return true se l'utente &egrave; stato eliminato
     */
    boolean eliminaUtente(long id);

    /**
     * Ritorna l'istanza di un HandlerUtenti.
     *
     * @return l'istanza di un HandlerUtenti
     */
    HandlerUtenti getInstance();

}
