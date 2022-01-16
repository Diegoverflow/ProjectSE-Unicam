package it.unicam.cs.diciottoPolitico;

public class SimpleHandlerCatalogoAttivita implements HandlerCatalogo<RigaCatalogoAttivita>{

    @Override
    public boolean aggiungiRigaCatalogo(RigaCatalogoAttivita rigaDaAggiungere) {
        return false;
    }

    @Override
    public boolean rimuoviRigaCatalogo(RigaCatalogoAttivita rigaDaEliminare) {
        return false;
    }

    @Override
    public boolean modificaPrezzoRigaCatalogo(RigaCatalogoAttivita rigaCatalogo, double nuovoPrezzo) {
        return false;
    }
}
