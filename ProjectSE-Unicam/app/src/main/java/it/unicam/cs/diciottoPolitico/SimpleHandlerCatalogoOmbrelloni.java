package it.unicam.cs.diciottoPolitico;

import java.util.Objects;

public class SimpleHandlerCatalogoOmbrelloni implements HandlerCatalogo<RigaCatalogoOmbrellone>{

    private final Catalogo<Ombrellone, RigaCatalogoOmbrellone> catalogoOmbrelloni;

    public SimpleHandlerCatalogoOmbrelloni(Catalogo<Ombrellone, RigaCatalogoOmbrellone> catalogoOmbrelloni) {
        this.catalogoOmbrelloni = catalogoOmbrelloni;
    }

    @Override
    public boolean aggiungiRigaCatalogo(RigaCatalogoOmbrellone rigaDaAggiungere) {
        return this.catalogoOmbrelloni.add(Objects.requireNonNull(rigaDaAggiungere, "Riga catologo nulla"));
    }

    @Override
    public boolean rimuoviRigaCatalogo(RigaCatalogoOmbrellone rigaDaEliminare) {
        return false;
    }

    @Override
    public void modificaPrezzoRigaCatalogo(RigaCatalogoOmbrellone rigaCatalogo, double nuovoPrezzo) {

    }
}
