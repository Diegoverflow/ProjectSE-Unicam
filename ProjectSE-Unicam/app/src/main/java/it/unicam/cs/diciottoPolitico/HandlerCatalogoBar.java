package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta lo specifico gestore per il Catalogo Bar.
 */
public interface HandlerCatalogoBar extends HandlerCatalogo<ArticoloBar, RigaCatalogoBar> {

    /**
     * Modifica la quantit&agrave; della {@link RigaCatalogoBar} specificata.
     *
     * @param rigaBar  la riga a cui modificare la quantit&agrave;
     * @param quantita la nuova quantit&agrave; della riga specificata
     * @throws NullPointerException se la riga specificata &egrave; {@code null}
     */
    void modificaRigaCatalogoBar(RigaCatalogoBar rigaBar, int quantita);

}
