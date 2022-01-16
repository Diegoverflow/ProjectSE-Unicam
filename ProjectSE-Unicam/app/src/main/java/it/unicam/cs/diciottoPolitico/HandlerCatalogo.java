package it.unicam.cs.diciottoPolitico;

/**
 * Interfaccia per aggiornare un generico Catalogo
 * @param <R> tipo delle righe presenti nel catalogo
 */
public interface HandlerCatalogo <R> {

    /**
     * Aggiunge una riga al catalogo
     * @param rigaDaAggiungere riga da aggiungere
     * @return {@code true} se la riga viene aggiunta
     *         {@code false} altrimenti
     */
    boolean aggiungiRigaCatalogo(R rigaDaAggiungere);

    /**
     * Rimuovi una riga dal catalogo
     * @param rigaDaEliminare riga da elimininare
     * @return {@code true} se la riga &grave; stata rimossa
     *         {@code false} altrimenti
     */
    boolean rimuoviRigaCatalogo(R rigaDaEliminare);

    boolean modificaPrezzoRigaCatalogo(R rigaCatalogo, double nuovoPrezzo);

}
