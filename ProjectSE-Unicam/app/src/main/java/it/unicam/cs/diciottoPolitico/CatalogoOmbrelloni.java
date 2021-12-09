package it.unicam.cs.diciottoPolitico;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CatalogoOmbrelloni implements Catalogo<Ombrellone,RigaCatalogoOmbrellone>{

    private final List<RigaCatalogoOmbrellone> righeCatalogoOmbrellone;

    /**
     * Metodo costruttore.
     */
    public CatalogoOmbrelloni() {
        this.righeCatalogoOmbrellone = new ArrayList<>();
    }


    @Override
    public boolean addRiga(RigaCatalogoOmbrellone riga) {
        if (this.righeCatalogoOmbrellone.contains(Objects.requireNonNull(riga,"La riga non puo' essere nulla")))
            return false;
        return this.righeCatalogoOmbrellone.add(riga);
    }

    @Override
    public boolean remove(RigaCatalogoOmbrellone riga) {
        if(!this.righeCatalogoOmbrellone.contains(Objects.requireNonNull(riga,"La riga non puo' essere nulla")))
            return false;
        return this.righeCatalogoOmbrellone.remove(riga);
    }

    @Override
    public List<RigaCatalogoOmbrellone> getRigaBy(Predicate<RigaCatalogoOmbrellone> predicate) {
        return this.righeCatalogoOmbrellone.stream().filter(Objects.requireNonNull(predicate,"Il predicato non puo' essere nullo")).collect(Collectors.toList());
    }

    @Override
    public List<RigaCatalogoOmbrellone> getAllRighe() {
        return this.righeCatalogoOmbrellone;
    }
}
