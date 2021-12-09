package it.unicam.cs.diciottoPolitico;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Implementazione dell'interfaccia Catalogo come un catalogo bar.
 */
public class CatalogoBar implements Catalogo<ArticoloBar, RigaCatalogoBar> {
    private final List<RigaCatalogoBar> righeCatalogoBar;

    /**
     * Metodo costruttore.
     */
    public CatalogoBar() {
        this.righeCatalogoBar = new ArrayList<>();
    }

    @Override
    public boolean addRiga(RigaCatalogoBar riga) {
        if (this.righeCatalogoBar.contains(Objects.requireNonNull(riga,"La riga non puo' essere nulla")))
            return false;
        return this.righeCatalogoBar.add(riga);
    }

    @Override
    public boolean remove(RigaCatalogoBar riga) {
        if(!this.righeCatalogoBar.contains(Objects.requireNonNull(riga,"La riga non puo' essere nulla")))
            return false;
        return this.righeCatalogoBar.remove(riga);
    }

    @Override
    public List<RigaCatalogoBar> getRigaBy(Predicate<RigaCatalogoBar> predicate) {
        return this.righeCatalogoBar.stream().filter(Objects.requireNonNull(predicate,"Il predicato non puo' essere nullo")).collect(Collectors.toList());
    }
}
