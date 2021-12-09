package it.unicam.cs.diciottoPolitico;

// TODO: Modificare javadoc


/**
 * Rappresenta un addetto bar che si occupa di effettuare principalmente operazioni inerenti
 * alle ordinazioni bar. In particolare si occoupa  di prendere in carico un' ordinazione del bar,
 * di consegnarla al cliente e di eliminare la notifica relativa a quell' ordine.
 */
public interface AddettoBar {

    /**
     * Restituisce l' id di questo addetto bar
     *
     * @return l' id dell' addetto bar
     */
    long getId();

    /**
     * Restituisce il nome di questo addetto bar.
     *
     * @return il nome dell' addetto bar
     */
    String getNome();

    /**
     * Restituisce il cognome di questo addetto bar.
     *
     * @return il cognome dell' addetto bar
     */
    String getCognome();

    /**
     * Restituisce la password di questo addetto bar.
     *
     * @return la password dell' addetto bar
     */
    String getPassword();   // TODO: Ricordarsi di hashare le passsword per non mostrarle in chiaro!

    /**
     * Imposta il nome specificato all' addetto bar
     *
     * @param nome il nome da impostare all' addetto bar
     */
    void setNome(String nome);

    /**
     * Imposta il cognome specificato all' addetto bar
     *
     * @param cognome il cognome da impostare all' addetto bar
     */
    void setCognome(String cognome);

    /**
     * Imposta la password specificata all' addetto bar
     *
     * @param password la password da impostare all' addetto bar
     */
    void setPassword(String password);

    /**
     * Aggiunge una notifica inviata dall' handler a questo addetto bar.
     *
     * @param notifica la notifica specificata da aggiungere all' insieme delle notifiche di questo addetto bar
     */
    void addNotifica(Notifica notifica);

    /**
     * Rimuove la notifica specificata dall' insieme delle notifiche di questo addetto bar.
     *
     * @param notifica la notifica da rimuovere dall' insieme delle notifiche di questo addetto bar
     */
    boolean removeNotifica(Notifica notifica);


    /**
     * Confronta l' elemento specificato con questo addetto bar.
     * Restituisce {@code true} se l' elemento specificato &egrave; anch' esso un addetto bar ed
     * ha gli stessi attributi di questo addetto bar.
     * (Due elementi {@code e1} e {@code e2} sono <i>uguali</i> se {@code Objects.equals(e1,e2)}.)
     *
     * @param o l' elemento da essere confrontato per l' uguaglianza con questo addetto bar
     * @return {@code true} se l' elemento specificato &egrave; uguale a questo addetto bar
     */
    boolean equals(Object o);

    /**
     * Restituisce l' hashCode per questo addetto bar.
     *
     * @return l' hashCode per questo addetto bar
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();

}
