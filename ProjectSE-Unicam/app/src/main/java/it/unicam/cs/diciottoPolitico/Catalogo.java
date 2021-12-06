package it.unicam.cs.diciottoPolitico;

import java.util.List;
import java.util.function.Predicate;

/**
 * Interfaccia che descrive un catologo
 * @param <R> Righe Cataloghi
 */
public interface Catalogo<S, R extends RigaCatalogo<S>> {

    boolean addRiga(R righa);

    boolean remove(R riga);

    List<R> getRigaBy(Predicate<R> predicate);

}
