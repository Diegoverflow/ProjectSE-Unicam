package it.unicam.cs.diciottoPolitico;

import java.util.List;
import java.util.Objects;

/**
 * Implementazione di un semplice gestore per il Catalogo bar che lo chalet
 * mette a disposizione per i clienti.
 */
public class SimpleHandlerCatalogoBar implements HandlerCatalogoBar {

    private final Catalogo<ArticoloBar, RigaCatalogoBar> catalogoBar;

    /**
     * Crea un semplice gestore per il catalogo bar.
     */
    public SimpleHandlerCatalogoBar() {
        this.catalogoBar = new SimpleCatalogo<>();
    }

    @Override
    public boolean aggiungiRiga(RigaCatalogoBar riga) {
        return this.catalogoBar.add(riga);
    }

    @Override
    public boolean rimuoviRiga(RigaCatalogoBar riga) {
        return this.catalogoBar.remove(riga);
    }

    @Override
    public void modificaPrezzoRigaCatalogo(RigaCatalogoBar riga, double nuovoPrezzo) {
        riga.setPrezzo(nuovoPrezzo);
    }

    @Override
    public List<RigaCatalogoBar> getAllRighe() {
        return this.catalogoBar.getAllRighe();
    }

    @Override
    public void modificaRigaCatalogoBar(RigaCatalogoBar riga, int quantita) {
        Objects.requireNonNull(riga, "Riga specificata null!");
        riga.setQuantita(quantita);
    }
}
