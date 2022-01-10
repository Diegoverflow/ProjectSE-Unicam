package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un manager che si interagire con il database.
 */
public interface DatabaseManager {

    /**
     * Controlla se l'email &egrave; stata utilizzata per registrare un cliente.
     * @param email da verificare.
     * @return {@code true} se l'email &egrave; associata ad un cliente,
     *         {@code false} altrimenti.
     */
    boolean verificaPresenza (String email);

    /**
     * Controlla se l'email e la password corrispondono ad un cliente registrato.
     * @param email da verificare.
     * @param password da verificare.
     * @return {@code true} se il cliente con queste credianziali &egrave; registrato,
     *         {@code false} altrimenti.
     */
    boolean verificaPresenza (String email, String password);

    /**
     * Aggiunge un cliente al database del sistema.
     * @param cliente da aggiungere.
     * @return {@code true} se il cliente &egrave; stato aggiunto,
     *         {@code false} altrimenti.
     */
    boolean addNuovoCliente (Cliente cliente);  // TODO: Non bisognerebbe metere Utente come tipo?
}
