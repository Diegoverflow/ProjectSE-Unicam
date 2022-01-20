package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoBar;

/**
 * Interfaccia specifica per aggiornare un CatalogoBar
 */
public interface HandlerCatalgoBar extends HandlerCatalogo<RigaCatalogoBar>{

    /**
     * Imposta la quantit&agrave; di articoli bar secondo un certo parametro
     * @param quantita da salvare
     * @return {@code true} se la quantit&agrave; &egrave; stata aggiornata,
     *         {@code false} altrimenti
     */
    boolean modificaQuantitaArticoli(int quantita);

}
