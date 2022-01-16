package it.unicam.cs.diciottoPolitico;

import java.util.Objects;

public class SimpleHandlerCatalogoAttivita implements HandlerCatalogo<RigaCatalogoAttivita>{

    private final Catalogo<Attivita, RigaCatalogoAttivita> catalogoAttivita;

    public SimpleHandlerCatalogoAttivita(Catalogo<Attivita, RigaCatalogoAttivita> catalogoAttivita) {
        this.catalogoAttivita = catalogoAttivita;
    }

    @Override
    public boolean aggiungiRigaCatalogo(RigaCatalogoAttivita rigaDaAggiungere) {
        return this.catalogoAttivita.add(Objects.requireNonNull(rigaDaAggiungere, "riga catalogo nulla"));
    }

    @Override
    public boolean rimuoviRigaCatalogo(RigaCatalogoAttivita rigaDaEliminare) {
        return this.catalogoAttivita.remove(Objects.requireNonNull(rigaDaEliminare, "riga catalogo nulla"));
    }


    @Override
    public void modificaPrezzoRigaCatalogo(RigaCatalogoAttivita rigaCatalogo, double nuovoPrezzo) {
        this.catalogoAttivita.
                getRigheBy(p-> p.equals(Objects.requireNonNull(rigaCatalogo, "riga catalogo nulla"))).
                stream().
                findFirst().
                ifPresent(p->p.setPrezzo(nuovoPrezzo));
    }

}
