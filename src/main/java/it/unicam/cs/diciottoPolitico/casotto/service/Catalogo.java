package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogo;

import java.util.List;
import java.util.function.Predicate;

/**
 * Rappresenta un generico catologo.
 * Questo catalogo &egrave; formato da righe ({@link RigaCatalogo}) di tipo <R> che contengono principalmente oggetti di tipo <T>.
 *
 * @param <T> il tipo parametrico per la tipologia di oggetti relativi alle righe del catalogo.
 * @param <R> il tipo parametrico per le righe catalogo di questo generico catalogo.
 */
public interface Catalogo<T, R extends RigaCatalogo<T>> {

    /**
     * Se la riga catalogo non &egrave; presente nel catalogo, aggiunge la riga catalogo specificata a questo catalogo.
     * Restituisce {@code true} se la riga catalogo viene aggiunta, altrimenti {@code false}.
     *
     * @param riga la riga catalogo da aggiungere a questo catalogo
     * @return {@code true} se la riga catalogo viene aggiunta, altrimenti {@code false}
     */
    boolean add(R riga);

    /**
     * Rimuove la riga catalogo specificata da questo catalogo.
     * Restituisce {@code true} se la riga catalogo viene rimossa, altrimenti {@code false}.
     *
     * @param riga la riga da rimuovere da questo catalogo
     * @return {@code true} se la riga catalogo viene rimossa, altrimenti {@code false}
     */
    boolean remove(R riga);

    /**
     * Restituisce una lista di righe catalogo filtrate tramite il predicato specificato.
     *
     * @param predicate il predicato con cui filtrare le righe catalogo
     * @return la lista delle righe catalogo filtrate tramite il predicato specificato
     * @throws NullPointerException se il predicato &egrave; {@code null}
     */
    List<R> getRigheBy(Predicate<R> predicate);

    /**
     * Ritorna una lista contenente tutte le righe di questo catalogo.
     *
     * @return la lista di tutte le righe di questo catalogo
     */
    List<R> getAllRighe();

}
