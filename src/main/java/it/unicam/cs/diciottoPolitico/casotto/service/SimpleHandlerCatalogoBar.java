package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.ArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoBar;

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
        return this.catalogoBar.add(Objects.requireNonNull(rigaDaEliminare, "Riga catalogo nulla"));
    }

    @Override
    public void modificaPrezzoRigaCatalogo(RigaCatalogoBar rigaCatalogo, double nuovoPrezzo) {
        this.catalogoBar.
                getRigheBy(p->p.equals(Objects.requireNonNull(rigaCatalogo, "riga catalogo nulla"))).
                stream().
                findFirst().
                ifPresent(r->r.setPrezzo(nuovoPrezzo));
    }
}
