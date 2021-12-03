package it.unicam.cs.diciottoPolitico;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Rappresenta un catalogo di ombrelloni.
 * Il catalogo non &egrave; altro che una sequenza di righe catalogo.
 */
public interface CatalogoOmbrelloni {

    /**
     * Aggiunge una riga a questa catalogo ombrelloni.
     *
     * @param ombrellone l' ombrellone da aggiungere a questa riga.
     * @param prezzo     il prezzo associato all' ombrelllone di questa riga.
     * @return true se la riga &egrave; stata aggiunta con successo, false altrimenti.
     */
    boolean addRigaOmbrellone(Ombrellone ombrellone, double prezzo);

    /**
     * Rimuove la riga catalogo associata all' ombrellone specificato.
     *
     * @param ombrellone l' ombrellone associato alla riga catalogo da eliminare.
     * @return true se la riga &egrave; stata eliminata con successo, false altrimenti.
     * @throws NullPointerException se l' ombrellone specificato &egrave; null
     */
    boolean removeRigaOmbrellone(Ombrellone ombrellone);

    /**
     * Modifica il prezzo dell' ombrellone della riga catalogo specificato.
     *
     * @param ombrellone  l' ombrellone di cui modificarne il prezzo
     * @param nuovoPrezzo il nuovo prezzo da impostare all' ombrellone
     * @return true se il prezzo dell' ombrellone viene modificato, false altrimenti
     * @throws NullPointerException se l' ombrellone specificato &egrave; null
     */
    boolean modificaPrezzo(Ombrellone ombrellone, double nuovoPrezzo);

    /**
     * Restituisce un Optional che descrive l' ombrellone per l' id specificato.
     * Se non viene trovato nessun ombrellone in base all' id specificato viene restituito un empty Optional.
     *
     * @param id l' id dell' ombrellone da ritornare
     * @return l' Optional che descrive l' ombrellone trovato in base all' id specificato, empty Optional altrimenti
     */
    Optional<Ombrellone> getOmbrelloneBy(long id);

    /**
     * Restituisce la lista di tutti gli ombrelloni aventi il prezzo specificato.
     * Se non viene trovato nessun ombrellone per quel prezzo viene ritornata una lista vuota.
     *
     * @param prezzo il prezzo da specificare
     * @return la lista di tutti gli ombrelloni trovati in base al prezzo specificato
     * @throws IllegalArgumentException se il prezzo specificato non &egrave; valido
     */
    List<Ombrellone> getOmbrelloniBy(double prezzo);

    /**
     * Restituisce la lista degli ombrelloni in base alla data e la fascia oraria specificate.
     *
     * @param data         la data per gli ombrelloni da filtrare
     * @param fasciaOraria la fascia oraria per gli ombrelloni da filtrare
     * @return la lista degli ombrelloni filtrati in base a data e fascia oraria specificate
     * @throws NullPointerException se almeno uno dei parametri specificati &egrave; null
     */
    List<Ombrellone> getOmbrelloniBy(Date data, FasciaOraria fasciaOraria);
    //tOdO List<RigaCatalogo> getOmbrelloniBy(GregorianCalendar data, FasciaOraria fasciaOraria);


    /**
     * Restituisce un Optional che descrive la riga catalogo in base all' ombrellone specificato.
     * Se non viene trovato nessun ombrellone viene ritornato un empty Optional.
     *
     * @param ombrellone l' ombrellone contenuto nella riga catalogo da ritornare
     * @return un Optional che descrive la riga catalogo dell' ombrellone specificato, altrimenti un empty Optional se non viene trovato nessun ombrellone
     * @throws NullPointerException se l' ombrellone specificato &egrave; null
     */
    Optional<RigaCatalogo> getRigaCatalogoBy(Ombrellone ombrellone);
}
