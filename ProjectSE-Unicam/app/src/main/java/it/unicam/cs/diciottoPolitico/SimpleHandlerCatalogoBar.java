package it.unicam.cs.diciottoPolitico;

import java.util.Objects;

public class SimpleHandlerCatalogoBar implements HandlerCatalgoBar{

    Catalogo<ArticoloBar, RigaCatalogoBar> catalogoBar;

    public SimpleHandlerCatalogoBar(Catalogo<ArticoloBar, RigaCatalogoBar> catalogoBar) {
        this.catalogoBar = catalogoBar;
    }

    @Override
    public boolean modificaQuantitaArticoli(int quantita) {
        return true;
    }

    @Override
    public boolean aggiungiRigaCatalogo(RigaCatalogoBar rigaDaAggiungere) {
        return this.catalogoBar.add(Objects.requireNonNull(rigaDaAggiungere, "riga catalogo nulla"));
    }

    @Override
    public boolean rimuoviRigaCatalogo(RigaCatalogoBar rigaDaEliminare) {
        return false;
    }

    @Override
    public void modificaPrezzoRigaCatalogo(RigaCatalogoBar rigaCatalogo, double nuovoPrezzo) {

    }
}
