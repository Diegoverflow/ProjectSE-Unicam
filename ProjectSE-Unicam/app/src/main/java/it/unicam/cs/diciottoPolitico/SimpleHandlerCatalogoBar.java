package it.unicam.cs.diciottoPolitico;

public class SimpleHandlerCatalogoBar implements HandlerCatalgoBar{

    Catalogo<ArticoloBar, RigaCatalogoBar> catalogoBar;

    public SimpleHandlerCatalogoBar(Catalogo<ArticoloBar, RigaCatalogoBar> catalogoBar) {
        this.catalogoBar = catalogoBar;
    }

    @Override
    public boolean modificaQuantitaArticoli(int quantita) {
        return false;
    }

    @Override
    public boolean aggiungiRigaCatalogo(RigaCatalogoBar rigaDaAggiungere) {
        return false;
    }

    @Override
    public boolean rimuoviRigaCatalogo(RigaCatalogoBar rigaDaEliminare) {
        return false;
    }

    @Override
    public void modificaPrezzoRigaCatalogo(RigaCatalogoBar rigaCatalogo, double nuovoPrezzo) {

    }
}
