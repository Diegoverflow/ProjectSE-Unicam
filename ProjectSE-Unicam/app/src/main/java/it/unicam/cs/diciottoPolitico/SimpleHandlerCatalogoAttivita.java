package it.unicam.cs.diciottoPolitico;

import java.util.Objects;

public class SimpleHandlerCatalogoAttivita implements HandlerCatalogo<RigaCatalogoAttivita>{

    Catalogo<Attivita, RigaCatalogoAttivita> catalogoAttivita;

    public SimpleHandlerCatalogoAttivita(Catalogo<Attivita, RigaCatalogoAttivita> catalogoAttivita) {
        this.catalogoAttivita = catalogoAttivita;
    }

    @Override
    public boolean aggiungiRigaCatalogo(RigaCatalogoAttivita rigaDaAggiungere) {
        return this.catalogoAttivita.add(rigaDaAggiungere);
    }

    @Override
    public boolean rimuoviRigaCatalogo(RigaCatalogoAttivita rigaDaEliminare) {
        return this.catalogoAttivita.remove(rigaDaEliminare);
    }

    @Override
    public void modificaPrezzoRigaCatalogo(RigaCatalogoAttivita rigaCatalogo, double nuovoPrezzo) {

    }
}
