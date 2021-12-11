package it.unicam.cs.diciottoPolitico;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Implementazione di base dell'interfaccia Catalogo.
 *
 * @param <T> il tipo parametrico per la tipologia di oggetti relativi alle righe del catalogo.
 * @param <R> il tipo parametrico per le righe catalogo di questo generico catalogo.
 */
public class SimpleCatalogo<T,R extends RigaCatalogo<T>> implements Catalogo<T,R>{

    private final List<R> righeCatalogo;

    /**
     * Metodo costruttore.
     */
    public SimpleCatalogo() {
        this.righeCatalogo = new ArrayList<>();
    }

    @Override
    public boolean add(R riga) {
        if (this.righeCatalogo.contains(Objects.requireNonNull(riga,"La riga non puo' essere nulla")))
            return false;
        return this.righeCatalogo.add(riga);
    }

    @Override
    public boolean remove(R riga) {
        if(!this.righeCatalogo.contains(Objects.requireNonNull(riga,"La riga non puo' essere nulla")))
            return false;
        return this.righeCatalogo.remove(riga);
    }

    @Override
    public List<R> getRigaBy(Predicate<R> predicate) {
        return this.righeCatalogo.stream().filter(Objects.requireNonNull(predicate,"Il predicato non puo' essere nullo")).collect(Collectors.toList());
    }

    @Override
    public List<R> getAllRighe() {
        return this.righeCatalogo;
    }
}
