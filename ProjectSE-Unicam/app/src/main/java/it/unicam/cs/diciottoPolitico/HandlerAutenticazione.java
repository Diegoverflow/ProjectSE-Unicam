package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un gestore per l'autenticazione di un cliente.
 */
public interface HandlerAutenticazione {

    /**
     * Autentica un utente.
     *
     * @param email email dell' utente
     * @param password password dell'utente
     * @return true se email e password corrispondono a un utente, false altrimenti
     */
    boolean autenticarsi(String email, String password);
}
