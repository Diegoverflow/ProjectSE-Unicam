package it.unicam.cs.diciottoPolitico;

import java.util.List;

/**
 * Implementazione di un semplice gestore per il Catalogo delle attivit&agrave; che lo chalet
 * mette a disposizione per i clienti.
 */
public class SimpleHandlerCatalogoAttivita implements HandlerCatalogo<Attivita, RigaCatalogoAttivita> {

    private final Catalogo<Attivita, RigaCatalogoAttivita> catalogoAttivita;

    /**
     * Crea un gestore per il catalogo attivit&agrave;
     */
    public SimpleHandlerCatalogoAttivita() {
        this.catalogoAttivita = new SimpleCatalogo<>();
    }

    @Override
    public boolean aggiungiRiga(RigaCatalogoAttivita riga) {
        return this.catalogoAttivita.add(riga);
    }

    @Override
    public boolean rimuoviRiga(RigaCatalogoAttivita riga) {
        return this.catalogoAttivita.remove(riga);
    }

    @Override
    public void modificaPrezzoRigaCatalogo(RigaCatalogoAttivita riga, double nuovoPrezzo) {
        riga.setPrezzo(nuovoPrezzo);
    }

    @Override
    public List<RigaCatalogoAttivita> getAllRighe() {
        return this.catalogoAttivita.getAllRighe();
    }
}
