package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoOmbrellone;

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
        return this.catalogoOmbrelloni.add(Objects.requireNonNull(rigaDaEliminare, "Riga catalogo nulla"));
    }

    @Override
    public void modificaPrezzoRigaCatalogo(RigaCatalogoOmbrellone rigaCatalogo, double nuovoPrezzo) {
        this.catalogoOmbrelloni.
                getRigheBy(p->p.equals(Objects.requireNonNull(rigaCatalogo, "riga catalogo nulla"))).
                stream().
                findFirst().
                ifPresent(r->r.setPrezzoOmbrellone(nuovoPrezzo));
    }
}
