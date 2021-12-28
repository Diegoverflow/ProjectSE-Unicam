package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un gestore per la creazione di un utente loggato.
 * Questo gestore si occupa di far selezionare una tipologia di utente da creare e, in base a questa,
 * di creare l' utente che il gestore desidera creare.
 *
 * @see TipologiaUtente
 * @see UtenteLoggato
 */
public interface HandlerUtenti {

    /**
     * Crea un {@link Cliente} in base al cliente e la tipologia specificati.
     *
     * @param tipologia la tipologia a cui il cliente deve appartenere
     * @param cliente   il cliente da creare
     * @return {@code true} se il cliente viene creato con successo, {@code false} altrimenti.
     */
    boolean creaCliente(TipologiaUtente tipologia, Cliente cliente);

    /**
     * Restituisce un array di tutte le tipologie utente.
     *
     * @return l' array di tutte le tipologie utente.
     */
    TipologiaUtente[] mostraTipologieUtente();

}
