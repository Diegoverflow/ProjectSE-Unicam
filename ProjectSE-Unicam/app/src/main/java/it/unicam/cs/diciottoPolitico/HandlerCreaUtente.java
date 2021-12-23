package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un gestore per la creazione di un utente loggato.
 * Questo gestore si occupa di far selezionare una tipologia di utente da creare e, in base a questa,
 * di creare l' utente che il gestore desidera creare.
 *
 * @see TipologiaUtente
 * @see UtenteLoggato
 */
public interface HandlerCreaUtente {

    /**
     * Crea un {@link UtenteLoggato} in base all' utente e la tipologia specificati.
     *
     * @param tipologia la tipologia a cui l' utente da creare appartiene
     * @param utente    l' utente loggsto da creare
     * @return {@code true} se l' utente loggato viene creato con successo, {@code false} altrimenti.
     * @throws UserNotCreatedException se ci sono errori riguardanti i dati dell' utente oppure se l' utente era gi&agrave; presente nel sistema.
     */
    boolean creaUtente(TipologiaUtente tipologia, UtenteLoggato utente);

    /**
     * Restituisce la tipologia dell' utente selezionata.
     *
     * @param tipologie l' array di tipologie disponibili
     * @return la tipologia dell' utente loggato selezionata.
     */
    TipologiaUtente scegliTipologiaUtente(TipologiaUtente[] tipologie);

}
