package it.unicam.cs.diciottoPolitico;

import java.util.List;
import java.util.function.Predicate;

//todo api
public class CatalogoBar implements Catalogo<ArticoloBar,RigaCatalogoBar>{
    @Override
    public boolean addRiga(RigaCatalogoBar righa) {
        return false;
    }

    @Override
    public boolean remove(RigaCatalogoBar riga) {
        return false;
    }

    @Override
    public List<RigaCatalogoBar> getRigaBy(Predicate<RigaCatalogoBar> predicate) {
        return null;
    }
}
