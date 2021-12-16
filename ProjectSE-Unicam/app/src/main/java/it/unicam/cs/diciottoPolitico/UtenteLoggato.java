package it.unicam.cs.diciottoPolitico;

import java.util.Queue;

/**
 * Rappresenta un utente che si &egrave; loggato attraverso un meccanismo di autenticazione.
 */
public interface UtenteLoggato {

    /**
     * Restituisce l' id di questo addetto bar
     *
     * @return l' id dell' addetto bar
     */
    long getId();

    /**
     * Restituisce la password di questo addetto bar.
     *
     * @return la password dell' addetto bar
     */
    String getPassword(); // todo hashare password

    /**
     * Imposta la password specificata all' addetto bar
     *
     * @param password la password da impostare all' addetto bar
     */
    void setPassword(String password);

    /**
     * Ottieni il nome dell'utente.
     *
     * @return il nome dell'utente
     */
    String getNome();

    /**
     * Ottieni il cognome del cliente.
     *
     * @return il cognome del cliente
     */
    String getCognome();

    /**
     * Ottieni il numero del cliente.
     *
     * @return il numero del cliente
     */
    String getNumero();

    /**
     * Modifica il nome del cliente in base al nome passato come parametro.
     *
     * @param nome con il quale si vuole aggiornare il nome del cliente
     */
    void setNome(String nome);

    /**
     * Modifica il cognome del cliente in base al cognome passato come parametro.
     *
     * @param cognome con il quale si vuole aggiornare il cognome del cliente
     */
    void setCognome(String cognome);

    /**
     * Modifica il numero del cliente in base al numero passato come parametro.
     *
     * @param numero con il quale si vuole aggiornare il numero del cliente
     */
    void setNumero(String numero);

    /**
     * Ottieni le notifiche nella casella notifiche del cliente.
     *
     * @return la lista di notifiche del cliente
     */
    Queue<Notifica> getNotifiche();

    /**
     * Aggiunge una notifica alla casella notifiche del cliente e
     * verifica che l'operazione sia stata effettuata correttamente.
     *
     * @param notifica da aggiungere alla casella notifiche del cliente
     * @return true se la notifica &egrave; stata aggiunta,
     * false altrimenti
     */
    boolean addNotifica(Notifica notifica);

    /**
     * Rimuovi una notifica dalla casella notifiche del cliente e
     * verifica che l'operazione sia stata effettuata correttamente.
     *
     * @param notifica da rimuovere dalla casella notifiche del cliente
     * @return true se la notifica &egrave; stata rimossa,
     * false altrimenti
     */
    boolean removeNotifica(Notifica notifica);

    /**
     * Confronta l' elemento specificato con questo utente loggato.
     * Restituisce {@code true} se l' elemento specificato &egrave; anch' esso un utente loggato ed
     * ha le stesse caratteristiche di questo utente loggato.
     * (Due elementi {@code e1} e {@code e2} sono <i>uguali</i> se {@code Objects.equals(e1,e2)}.)
     *
     * @param o l' elemento da essere confrontato per l' uguaglianza con questo utente loggato
     * @return {@code true} se l' elemento specificato &egrave; uguale a questo utente loggato
     */
    boolean equals(Object o);

    /**
     * Restituisce l' hashCode per questo utente loggato.
     *
     * @return l' hashCode per questo utente loggato
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();

}
