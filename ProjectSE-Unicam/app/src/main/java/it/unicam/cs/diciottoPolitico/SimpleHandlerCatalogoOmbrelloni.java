package it.unicam.cs.diciottoPolitico;

import java.util.List;

/**
 * Implementazione di un semplice gestore per il Catalogo degli ombrelloni che lo chalet
 * mette a disposizione per i clienti.
 */
public class SimpleHandlerCatalogoOmbrelloni implements HandlerCatalogo<Ombrellone, RigaCatalogoOmbrellone> {

    private final Catalogo<Ombrellone, RigaCatalogoOmbrellone> catalogoOmbrelloni;

    /**
     * Crea un semplice gestore per il catalogo degli ombrelloni.
     */
    public SimpleHandlerCatalogoOmbrelloni() {
        this.catalogoOmbrelloni = new SimpleCatalogo<>();
    }

    @Override
    public boolean aggiungiRiga(RigaCatalogoOmbrellone riga) {
        return this.catalogoOmbrelloni.add(riga);
    }

    @Override
    public boolean rimuoviRiga(RigaCatalogoOmbrellone riga) {
        return this.catalogoOmbrelloni.remove(riga);
    }

    @Override
    public void modificaPrezzoRigaCatalogo(RigaCatalogoOmbrellone riga, double nuovoPrezzo) {
        riga.setPrezzoOmbrellone(nuovoPrezzo);
    }

    @Override
    public List<RigaCatalogoOmbrellone> getAllRighe() {
        return this.catalogoOmbrelloni.getAllRighe();
    }
}
