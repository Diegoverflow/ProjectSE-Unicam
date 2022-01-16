package it.unicam.cs.diciottoPolitico;

import java.util.List;
import java.util.Set;

/**
 * Interfaccia che descrive un gestore utenti per la creazione di utenza e la verifica delle credenziali
 */
public interface HandlerUtenti {

    // TODO: 15/01/22   il vpp ha le liste parametrizzate con CLIENTE CASSIERE ETC

    /**
     * Ottieni la lista dei clienti dello Chalet
     * @return la lista dei clienti
     */
    Set<Utente> getClienti();

    /**
     * Ottieni la lista del Personale Bar dello Chalet
     * @return la lista del Personale Bar
     */
    Set<Utente> getPersonaleBar();

    /**
     * Ottieni la lista dei Cassieri dello Chalet
     * @return la lista dei Cassieri
     */
    Set<Utente> getCassieri();

    /**
     * Ottieni la lista dei Gestori dello Chalet
     * @return la lista dei Gestori
     */
    Set<Utente> getGestori();

    /**
     * Crea un Cliente e lo aggiunge alla lista corrispondente
     * @param nome del cliente
     * @param cognome del cliente
     * @param password del cliente
     * @param cellulare del cliente
     * @param email del cliente
     * @return {@code true} se il cliente viene creato correttamente,
     *         {@code false} altrimenti
     */
    boolean creaCliente( String nome,
                         String cognome,
                         String password,
                         String cellulare,
                         String email);

    /**
     * Crea un membro del Personale Bar e lo aggiunge alla lista corrispondente
     * @param nome del Personale Bar
     * @param cognome del Personale Bar
     * @param password del Personale Bar
     * @param cellulare del Personale Bar
     * @param email del Personale Bar
     * @return {@code true} se il membro del Personale Bar viene creato correttamente,
     *         {@code false} altrimenti
     */
    boolean creaPersonaleBar( String nome,
                         String cognome,
                         String password,
                         String cellulare,
                         String email);

    /**
     * Crea un Cassiere e lo aggiunge alla lista corrispondente
     * @param nome del Cassiere
     * @param cognome del Cassiere
     * @param password del Cassiere
     * @param cellulare del Cassiere
     * @param email del Cassiere
     * @return {@code true} se il Cassiere viene creato correttamente,
     *         {@code false} altrimenti
     */
    boolean creaCassiere( String nome,
                         String cognome,
                         String password,
                         String cellulare,
                         String email);

    /**
     * Crea un Gestore e lo aggiunge alla lista corrispondente
     * @param nome del Gestore
     * @param cognome del Gestore
     * @param password del Gestore
     * @param cellulare del Gestore
     * @param email del Gestore
     * @return {@code true} se il Gestore  viene creato correttamente,
     *         {@code false} altrimenti
     */
    boolean creaGestore( String nome,
                         String cognome,
                         String password,
                         String cellulare,
                         String email);

    /**
     * Elimina un Utente dal Sistema
     * @param codice dell'Utente che si vuole eliminare
     * @return {@code true} se l'Utente viene eliminato,
     *         {@code false} altrimenti
     */
    boolean eliminaUtente (long codice);

    /**
     * Verifica le credenziali di un Utente
     * @param email dell'Utente da autenticare
     * @param password dell'Utente da autenticare
     * @return {@code true} se le credenziali corrispondo ad un'Utente presente nel Sistema,
     *         {@code false} altrimenti
     */
    boolean autenticarsi (String email, String password);
    

}
