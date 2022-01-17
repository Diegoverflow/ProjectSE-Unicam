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
     * Crea un Utente e lo aggiunge alla lista corrispondente
     * @param nome dell'Utente
     * @param cognome dell'Utente
     * @param password dell'Utente
     * @param cellulare dell'Utente
     * @param email dell'Utente
     * @param ruoloUtente dell'Utente
     * @return {@code true} se il cliente viene creato correttamente,
     *         {@code false} altrimenti
     */
    boolean creaUtente( String nome,
                         String cognome,
                         String password,
                         String cellulare,
                         String email,
                         RuoloUtente ruoloUtente);

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
