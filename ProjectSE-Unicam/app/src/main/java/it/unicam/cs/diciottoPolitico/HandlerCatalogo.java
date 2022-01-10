package it.unicam.cs.diciottoPolitico;

import java.util.List;

/**
 * Rappresenta un gestore per uno specifico {@link Catalogo}.
 * Questo gestore implementa operazioni di aggiunya, modifica e rimozione di una specifica riga
 * dal catalogo di cui questo gestore si occupa.
 *
 * @param <T> il tipo parametrico per la tipologia di oggetti relativi alle righe del catalogo.
 * @param <R> il tipo parametrico per le righe catalogo del generico catalogo.
 *
 * @see Catalogo
 * @see RigaCatalogo
 */
public interface HandlerCatalogo<T, R extends RigaCatalogo<T>> {

    /**
     * Aggiunge la riga specificata al catalogo di questo gestore.
     * Restituisce {@code true} se la riga viene aggiunta al catalogo con successo, {@code false} altrimenti.
     *
     * @param riga la riga da aggiungere al catalogo
     * @return {@code true} se la riga viene aggiunta al catalogo, {@code} false altrimenti.
     */
    boolean aggiungiRiga(R riga);

    /**
     * Rimuove la riga specificata dal catalogo di questo gestore.
     * Restituisce {@code true} se la riga viene rimossa dal catalogo con successo, {@code false} altrimenti.
     *
     * @param riga la riga da rimuovere dal catalogo
     * @return {@code true} se la riga viene rimossa dal catalogo, {@code} false altrimenti.
     */
    boolean rimuoviRiga(R riga);

    /**
     * Modifica il prezzo della riga specificata con il nuovo prezzo specificato.
     *
     * @param riga        la riga a cui modificare il prezzo
     * @param nuovoPrezzo il nuovo prezzo che avr&agrave; la riga
     */
    void modificaPrezzoRigaCatalogo(R riga, double nuovoPrezzo);

    /**
     * Restituisce la lista di tutte le righe di questo catalogo.
     *
     * @return la lista di tutte le righe di questo catalogo
     */
    List<R> getAllRighe();

}
