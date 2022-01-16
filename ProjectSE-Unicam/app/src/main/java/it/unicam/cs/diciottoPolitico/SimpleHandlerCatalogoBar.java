package it.unicam.cs.diciottoPolitico;

public class SimpleHandlerCatalogoBar implements HandlerCatalgoBar{

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
