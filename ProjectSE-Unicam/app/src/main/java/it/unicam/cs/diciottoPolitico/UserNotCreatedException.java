package it.unicam.cs.diciottoPolitico;

/**
 * Viene lanciata quando si tenta di creare un utente ma a causa di qualche errore, non ci si riesce a crearlo.
 */
public class UserNotCreatedException extends Exception {

    /**
     * Crea una {@code UserNotCreatedException} con il messaggio dettagliato specificato.
     *
     * @param message il messaggio dettagliato specificato
     */
    public UserNotCreatedException(String message) {
        super(message);
    }
}
