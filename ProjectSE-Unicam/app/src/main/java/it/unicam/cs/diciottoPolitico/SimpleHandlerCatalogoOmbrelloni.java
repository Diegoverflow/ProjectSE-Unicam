package it.unicam.cs.diciottoPolitico;

public class SimpleHandlerCatalogoOmbrelloni implements HandlerCatalogo<RigaCatalogoOmbrellone>{

    private final Catalogo<Ombrellone, RigaCatalogoOmbrellone> rigaCatalogoOmbrellone;

    public SimpleHandlerCatalogoOmbrelloni(Catalogo<Ombrellone, RigaCatalogoOmbrellone> rigaCatalogoOmbrellone) {
        this.rigaCatalogoOmbrellone = rigaCatalogoOmbrellone;
    }

    @Override
    public boolean aggiungiRigaCatalogo(RigaCatalogoOmbrellone rigaDaAggiungere) {
        return false;
    }

    @Override
    public boolean rimuoviRigaCatalogo(RigaCatalogoOmbrellone rigaDaEliminare) {
        return false;
    }

    @Override
    public void modificaPrezzoRigaCatalogo(RigaCatalogoOmbrellone rigaCatalogo, double nuovoPrezzo) {

    }
}
