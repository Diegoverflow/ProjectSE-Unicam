package it.unicam.cs.diciottoPolitico;

import java.util.Queue;

/**
 * Rappresenta un utente che utilizza il sistema.
 */
public interface Utente {

    /**
     * Restituisce l' id di questo utente.
     *
     * @return l' id dell' utente.
     */
    long getId();

    /**
     * Restituisce la password di questo utente.
     *
     * @return la password dell' utente
     */
    String getPassword();

    /**
     * Imposta la password specificata all' utente.
     *
     * @param password la password da impostare all' utente
     */
    void setPassword(String password);

    /**
     * Restituisce il nome dell' utente.
     *
     * @return il nome dell' utente
     */
    String getNome();

    /**
     * Imposta il nome specificato all' utente.
     *
     * @param nome con il quale si vuole aggiornare il nome dell' utente
     */
    void setNome(String nome);

    /**
     * Imposta il cognome specificato all' utente.
     *
     * @param cognome con il quale si vuole aggiornare il cognome dell' utente
     */
    void setCognome(String cognome);

    /**
     * Restituisce il cognome dell' utente.
     *
     * @return il cognome dell' utente
     */
    String getCognome();

    /**
     * Restituisce il numero del cellulare dell' utente.
     *
     * @return il numero del cellulare dell' utente
     */
    String getCellulare();

    /**
     * Imposta il cellulare specificato all' utente.
     *
     * @param cellulare con il quale si vuole aggiornare il cellulare dell' utente
     */
    void setCellulare(String cellulare);

    /**
     * Restituisce l' email dell' utente.
     *
     * @return la email dell' utente
     */
    String getEmail();

    /**
     * Imposta l' email specificata all' utente.
     *
     * @param email la mail da associare all' utente
     */
    void setEmail(String email);

    /**
     * Restituisce le notifiche presenti nella casella notifiche dell' utente.
     *
     * @return la lista di notifiche dell' utente
     */
    Queue<Notifica> getNotifiche();

    /**
     * Aggiunge una notifica alla casella notifiche dell' utente e
     * verifica che l' operazione sia stata effettuata correttamente.
     *
     * @param notifica da aggiungere alla casella notifiche dell' utente
     * @return {@code true} se la notifica &egrave; stata aggiunta,
     * {@code false} altrimenti
     * @throws NullPointerException          se la notifica specificata &egraveM {@code null}
     */
    boolean addNotifica(Notifica notifica); // TODO: spostare su HandlerUtenti

    /**
     * Rimuove la notifica specificata dalla casella notifiche dell' utente e
     * verifica che l' operazione sia stata effettuata correttamente.
     *
     * @param notifica da rimuovere dalla casella notifiche dell' utente
     * @return {@code true} se la notifica &egrave; stata rimossa,
     * {@code false} altrimenti
     * @throws NullPointerException          se la notifica specificata &egraveM {@code null}
     */
    boolean removeNotifica(Notifica notifica);  // TODO: Spostare su HandlerUtenti

    /**
     * Confronta l' elemento specificato con questo utente.
     * Restituisce {@code true} se l' elemento specificato &egrave; anch' esso un utente ed
     * ha le stesse caratteristiche di questo utente.
     * (Due elementi {@code e1} e {@code e2} sono <i>uguali</i> se {@code Objects.equals(e1,e2)}.)
     *
     * @param o l' elemento da essere confrontato per l' uguaglianza con questo utente
     * @return {@code true} se l' elemento specificato &egrave; uguale a questo utente, {@code false} altrimenti
     */
    boolean equals(Object o);

    /**
     * Restituisce l' hashCode per questo utente.
     *
     * @return l' hashCode per questo utente
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();

    /**
     * Ritorna il ruolo dell'utente.
     *
     * @return il ruolo dell'utente
     */
    RuoloUtente getRuolo();
}
