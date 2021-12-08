package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un addetto bar che si occupa di effettuare principalmente operazioni inerenti
 * alle ordinazioni bar. In particolare si occoupa  di prendere in carico un' ordinazione del bar,
 * di consegnarla al cliente e di eliminare la notifica relativa a quell' ordine.
 */
public interface AddettoBar {

    /**
     * Restituisce {@code true} se l' ordinazione relativa all' id specificato viene consegnata
     * con successo, {@code false} altrimenti.
     *
     * @param idOrdinazione l' id dell' ordinazione da consegnare
     * @return {@code true} se l' ordinazione viene consegnata con successo, {@code false} altrimenti
     */
    boolean consegnaOrdine(long idOrdinazione);

    /**
     * Restituisce {@code true} se l' ordinazione relativa all' id specificato viene presa in carico,
     * {@code false} altrimenti.
     *
     * @param idOrdinazione l' id dell' ordinazione da prendere in carico
     * @return {@code true} se l' ordinazione viene presa in carico, {@code false} altrimenti
     */
    boolean prendiInCarico(long idOrdinazione);

    /**
     * Una volta che l' ordine &egrave; stato preso in carico, elimina la notifica relativa a quest' ordine.
     * Restituisce {@code true} se la notifica viene eliminata, {@code false} altrimenti.
     *
     * @param idNotifica l' id della notifica da eliminare
     * @return {@code true} se la notifica viene eliminata, {@code false} altrimenti
     */
    boolean removeNotifica(long idNotifica);

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
