package it.unicam.cs.diciottoPolitico.casotto.service;

/**
 * Interfaccia generica per aggiornare un Catalogo
 * @param <R> tipo delle righe presenti nel catalogo
 */
public interface HandlerCatalogo <R> {

    /**
     * Aggiunge una riga al catalogo
     * @param rigaDaAggiungere .
     * @return {@code true} se la riga viene aggiunta
     *         {@code false} altrimenti
     */
    boolean aggiungiRigaCatalogo(R rigaDaAggiungere);

    /**
     * Rimuovi una riga dal catalogo
     * @param rigaDaEliminare .
     * @return {@code true} se la riga &grave; stata rimossa
     *         {@code false} altrimenti
     */
    boolean rimuoviRigaCatalogo(R rigaDaEliminare);

    /**
     * Modifica il prezzo di una certa riga presente sul catalogo
     * @param rigaCatalogo di cui si vuole aggiornare il prezzo
     * @param nuovoPrezzo da impostare
     * @return {@code true} se il prezzo della riga &grave; stato aggiornato
     *         {@code false} altrimenti
     */
    void modificaPrezzoRigaCatalogo(R rigaCatalogo, double nuovoPrezzo);

}
