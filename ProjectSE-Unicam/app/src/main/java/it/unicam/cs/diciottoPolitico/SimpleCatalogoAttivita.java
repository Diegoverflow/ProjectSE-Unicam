package it.unicam.cs.diciottoPolitico;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SimpleCatalogoAttivita implements Catalogo<Attivita, RigaCatalogoAttivita>{

    private final List<RigaCatalogoAttivita> righeCatologoAttivita;

    public SimpleCatalogoAttivita() {
        this.righeCatologoAttivita = new LinkedList<>();
    }

    @Override
    public boolean addRiga(RigaCatalogoAttivita riga) {
        if (riga == null)
            throw new NullPointerException("Riga nulla non valida");
        if (!this.righeCatologoAttivita.contains(riga))
            return this.righeCatologoAttivita.add(riga);
        return false;
    }

    @Override
    public boolean remove(RigaCatalogoAttivita riga) {
        if (riga == null)
            throw new NullPointerException("Riga nulla non valida");
        if (this.righeCatologoAttivita.contains(riga))
            return this.righeCatologoAttivita.remove(riga);
        return false;
    }

    @Override
    public List<RigaCatalogoAttivita> getRigaBy(Predicate<RigaCatalogoAttivita> predicate) {
        return this.righeCatologoAttivita.stream().parallel().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<RigaCatalogoAttivita> getAllRighe() {
        return this.righeCatologoAttivita;
    }

}
