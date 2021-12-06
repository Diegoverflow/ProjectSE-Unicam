package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un addetto bar che si occupa di effettuare principalmente operazioni inerenti
 * alle ordinazioni bar. In particolare si occoupa  di prendere in carico un' ordinazione del bar,
 * di consegnarla al cliente e di eliminare la notifica relativa a quell' ordine.
 */
public interface AddettoBar {

    /**
     * Restituisce true se l' ordinazione relativa all'id specificato viene consegnata
     * con successo, false altrimenti.
     *
     * @param idOrdinazione l'id dell' ordinazione da consegnare
     * @return true se l' ordinazione viene consegnata con successo, false altrimenti
     */
    boolean consegnaOrdine(long idOrdinazione);

    /**
     * Restituisce true se l' ordinazione relativa all' id specificato viene presa in carico,
     * false altrimenti.
     *
     * @param idOrdinazione l'id dell' ordinazione da prendere in carico
     * @return true se l' ordinazione viene presa in carico, false altrimenti
     */
    boolean prendiInCarico(long idOrdinazione);

    /**
     * Una volta che l' ordine &egrave; stato preso in carico, elimina la notifica relativa a quest' ordine.
     * Restituisce true se la notifica viene eliminata, false alteimenti.
     *
     * @param idNotifica l'id della notifica da eliminare
     * @return true se la notifica viene eliminata, false altrimenti
     */
    boolean removeNotifica(long idNotifica);
}
