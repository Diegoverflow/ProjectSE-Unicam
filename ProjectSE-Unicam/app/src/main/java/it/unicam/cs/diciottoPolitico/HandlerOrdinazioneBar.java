package it.unicam.cs.diciottoPolitico;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Rappresenta un gestore di ordinazioni bar.
 * In particolare esso si occupa di gestire le ordinazioni effettuate al bar da parte
 * dei clienti e di notificare gli addetti del bar per, a loro volta, gestire tali ordinazioni.
 */
public interface HandlerOrdinazioneBar {

    /**
     * Restituisce la mappa di tutte le ordinazioni: sia qulle prese in carico dall' associato addetto bar sia quelle ancora da prendere in carico.
     * La mappa consiste in una coppia (ordinazione bar, addetto bar) come di seguito:
     * <p>
     * (o1, a1): ordinazione bar o1 presa in carico dall' addetto a1
     * <p>
     * (o1, null): ordinazione bar o1 ancora da prendere in carico
     * <p>
     * Nella mappa sono presenti sia tutte le ordinazioni prese in carico che non.
     * Nel momento in cui un' ordinazione viene consegnata, viene rimossa dalla mappa.
     *
     * @return la mappa di tutte le ordinazioni da gestire, ovvero tutte quelle ordinazioni da prendere in carico, prese in carico e da consegnare
     */
    Map<OrdinazioneBar, AddettoBar> getOrdinazioniDaGestire();

    /**
     * Restituisce l' insieme di righe catalogo bar.
     *
     * @return l' insieme di righe catalogo bar
     */
    Set<RigaCatalogoBar> getRigheArticoliDisponibili();

    /**
     * Crea un' ordinazione bar secondo l' ordinazione bar ed il cliente specificati.
     * Precisamente il cliente specificato &egrave; colui che ha effettuato un' ordinazione.
     * Restituisce {@code true} se la creazione dell' ordinazione bar va a buon fine, {@code false} altrimenti.
     *
     * @param ordinazioneBar l' ordinazione bar da creare
     * @param cliente        il cliente che ha effettuato l' ordinazione bar
     * @return {@code true} se la creazione dell' ordinazione va a buon fine, {@code false} altrimenti
     */
    boolean creaOrdinazione(OrdinazioneBar ordinazioneBar, Cliente cliente);

    /**
     * Restituisce la lista di tutte le ordinazioni bar ancora da consegnare ai clienti.
     *
     * @return la lista di tutte le ordinazioni non consegnate
     */
    List<OrdinazioneBar> getOrdinazioniNonPreseInCarico();

    /**
     * Aggiunge l' addetto bar specificato all' insieme di tutti gli addetti bar.
     * Restituisce {@code true} se l' addetto bar specificato iene aggiunto, altrimenti {@code false}.
     *
     * @param addettoBar l' addetto bar da aggiungere all' insieme di tutti gli addetti bar
     * @return {@code true} se l' addetto bar specificato viene aggiunto, altrimenti {@code false}
     * @throws NullPointerException se l' addetto bar specificato &egrave; null
     */
    boolean addAddetto(AddettoBar addettoBar);  // TODO: Fa un po' caca addAddetto come nome

    /**
     * Rimuove l' addetto bar avente l' id specificato.
     * Restitusice {@code true} se l' addetto bar viene rimosso, altrimenti {@code false}.
     *
     * @param id l' id dell' addetto bar da rimuovere dall' insieme degli addetti bar
     * @return {@code true} se l' addetto bar viene rimosso, altrimenti {@code false}
     */
    boolean removeAddetto(long id);

    /**
     * Restituisce un {@link Optional} che descrive l' addetto bar in base all' id specificato.
     * Se non viene trovato nessun addetto bar con l' id specificato viene restituito un empty {@code Optional}.
     *
     * @param id l'id dell' addetto bar da restituire
     * @return un {@code Optional} che descrive l' addetto bar con quell' id specificato, altrimenti un empty {@code Optional} se non viene trovato nessun addetto bar con quell' id
     */
    Optional<AddettoBar> getAddettoBy(long id);
}
