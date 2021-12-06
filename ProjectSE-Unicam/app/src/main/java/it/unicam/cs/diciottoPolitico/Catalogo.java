package it.unicam.cs.diciottoPolitico;

import java.util.List;
import java.util.function.Predicate;

/**
 * Rappresenta un generico catologo.
 * Questo catalogo &egrave; formato da righe catalogo di tipo <R> che contengono principalmente oggetti di tipo <T>.
 *
 * @param <T> il tipo parametrico per la tipologia di oggetti relativi alle righe del catalogo.
 * @param <R> il tipo parametrico per le righe catalogo di questo generico catalogo.
 */
public interface Catalogo<T, R extends RigaCatalogo<T>> {

    /**
     * Aggiunge la riga catalogo specificata a questo catalogo.
     * Restituisce true se la riga catalogo viene aggiunta, altrimenti false.
     *
     * @param riga la riga catalogo da aggiungere a questo catalogo
     * @return true se la riga catalogo viene aggiunta, altrimenti false
     */
    boolean addRiga(R riga);

    /**
     * Rimuove la riga catalogo specificata da questo catalogo.
     * Restituisce true se la riga catalogo viene rimossa, altrimenti false.
     *
     * @param riga la riga da rimuovere da questo catalogo
     * @return true se la riga catalogo viene rimossa, altrimenti false
     */
    boolean remove(R riga);

    /**
     * Restituisce una lista di righe castalogo filtrate tramite il predicato specificato.
     *
     * @param predicate il predicato con cui filtrare le righe catalogo
     * @return la lista delle righe catalogo filtrate tramite il predicato specificato
     */
    List<R> getRigaBy(Predicate<R> predicate);

}
