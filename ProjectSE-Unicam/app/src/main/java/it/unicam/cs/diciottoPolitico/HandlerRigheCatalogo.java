package it.unicam.cs.diciottoPolitico;

import java.util.List;

public interface HandlerRigheCatalogo<T, R extends RigaCatalogo<T>, C extends Catalogo<T, R>> {

    /**
     * Aggiunge la riga specificata al catalogo specificato.
     * Restituisce {@code true} se la riga viene aggiunta al catalogo con successo, {@code false} altrimenti.
     *
     * @param riga     la riga da aggiungere al catalogo
     * @param catalogo il catalogo a cui aggiungere la riga
     * @return {@code true} se la riga viene aggiunta al catalogo, {@code} false altrimenti.
     * @throws NullPointerException se almeno uno dei parametri specificati &egrave; {@code null}
     */
    boolean aggiungiRiga(R riga, C catalogo);

    /**
     * Rimuove la riga specificata dal catalogo specificato.
     * Restituisce {@code true} se la riga viene rimossa dal catalogo con successo, {@code false} altrimenti.
     *
     * @param riga     la riga da rimuovere dal catalogo
     * @param catalogo il catalogo da cui rimuovere la riga
     * @return {@code true} se la riga viene rimossa dal catalogo, {@code} false altrimenti.
     * @throws NullPointerException se almeno uno dei parametri specificati &egrave; {@code null}
     */
    boolean rimuoviRiga(R riga, C catalogo);

    /**
     * Modifica il prezzo della riga specificata con il nuovo prezzio specificato.
     *
     * @param riga        la riga a cui modificare il prezzo
     * @param nuovoPrezzo il nuovo prezzo che avr&agrave; la riga
     * @throws NullPointerException     se la riga &egrave; {@code null}
     * @throws IllegalArgumentException se il nuovo prezzo specificato &egrave; negativo
     */
    void modificaPrezzoRigaCatalogo(R riga, double nuovoPrezzo);

    /**
     * Modifica la quantit&agrave; della {@link RigaCatalogoBar} specificata.
     *
     * @param rigaBar  la riga a cui modificare la quantit&agrave;
     * @param quantita la nuova quantit&agrave; della riga specificata
     * @throws NullPointerException     se la riga specificata &egrave; {@code null}
     * @throws IllegalArgumentException se la quantit&agrave; specificata &egrave; negativa
     */
    void modificaRigaCatalogoBar(R rigaBar, int quantita);

    /**
     * Restituisce una lista di tutte le righe appartenenti alla tipologia catalogo specificata.
     *
     * @param tipologia la tipologia del catalogo
     * @return la lista di tutte le righe presenti nel catalogo in base alla tipologia specificata.
     * @throws NullPointerException se la tipologia specificata &egrave; {@code null}
     */
    List<R> getRigheBy(TipologieCatalogo tipologia);

}
