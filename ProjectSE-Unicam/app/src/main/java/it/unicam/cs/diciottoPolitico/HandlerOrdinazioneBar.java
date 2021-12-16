package it.unicam.cs.diciottoPolitico;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Rappresenta un gestore di ordinazioni bar.
 * In particolare esso si occupa di gestire le ordinazioni effettuate al bar da parte
 * dei clienti e di notificare gli addetti bar per, a loro volta, gestire tali ordinazioni.
 *
 * @see OrdinazioneBar
 * @see ArticoloBar
 * @see AddettoBar
 * @see Cliente
 */
public interface HandlerOrdinazioneBar {

    /**
     * Restituisce la mappa di tutte le ordinazioni: sia qulle prese in carico dall' associato addetto bar sia quelle ancora da prendere in carico.
     * La mappa mappa un {@link OrdinazioneBar} a un {@link AddettoBar} come di seguito:
     * <ul>
     * <li>
     * (o1, a1): ordinazione bar o1 presa in carico dall' addetto a1
     * </li>
     * <li>
     * (o1, empty {@link Optional}): ordinazione bar o1 ancora da prendere in carico
     * </li>
     * </ul>
     * Nella mappa sono presenti sia tutte le ordinazioni prese in carico che non.
     * Nel momento in cui un' ordinazione viene consegnata, viene rimossa dalla mappa.
     *
     * @return la mappa di tutte le ordinazioni da gestire, ovvero tutte quelle ordinazioni da prendere in carico, prese in carico e da consegnare
     * @see OrdinazioneBar
     * @see AddettoBar
     * @see Optional
     */
    Map<OrdinazioneBar, Optional<AddettoBar>> getOrdinazioniDaGestire();

    /**
     * Restituisce una lista degli articoli bar disponibili.
     *
     * @return la lista degli articoli bar disponibili
     * @see ArticoloBar
     */
    List<ArticoloBar> getArticoliDisponibili();

    /**
     * Restituisce un {@link Optional} che descrive l' {@link OrdinazioneBar} associata all' id specificato.
     *
     * @param idOrdinazione l' id dell' ordinazione bar che si vuole cercare
     * @return un {@link Optional} che descrive l' {@link OrdinazioneBar} trovata tramite l' id specificato, un empty {@link Optional} altrimenti
     * @see OrdinazioneBar
     */
    Optional<OrdinazioneBar> getOrdinazioneBarBy(long idOrdinazione);

    /**
     * Crea {@link OrdinazioneBar} secondo l' ordinazione bar ed il {@link Cliente} specificati.
     * Precisamente il cliente specificato &egrave; colui che ha effettuato l' ordinazione bar specificata.
     * Restituisce {@code true} se la creazione dell' ordinazione bar va a buon fine, {@code false} altrimenti.
     *
     * @param ordinazioneBar l' ordinazione bar da creare
     * @param cliente        il cliente che ha effettuato l' ordinazione bar
     * @return {@code true} se la creazione dell' ordinazione va a buon fine, {@code false} altrimenti
     * @see OrdinazioneBar
     * @see Cliente
     */
    boolean creaOrdinazione(OrdinazioneBar ordinazioneBar, Cliente cliente);

    /**
     * Restituisce la lista di tutte le ordinazioni bar ancora da consegnare ai clienti.
     * Questa lista contiene tutte le ordinazioni bar che nessun {@link AddettoBar} ha per il momento preso in carico.
     *
     * @return la lista di tutte le ordinazioni non consegnate
     * @see OrdinazioneBar
     * @see AddettoBar
     */
    List<OrdinazioneBar> getOrdinazioniNonPreseInCarico();

    /**
     * Aggiunge l' addetto bar specificato all' insieme di tutti gli addetti bar.
     * Restituisce {@code true} se l' addetto bar specificato viene aggiunto, altrimenti {@code false}.
     *
     * @param addettoBar l' addetto bar da aggiungere all' insieme di tutti gli addetti bar
     * @return {@code true} se l' addetto bar specificato viene aggiunto, altrimenti {@code false}
     * @throws NullPointerException se l' addetto bar specificato &egrave; {@code null}
     * @see AddettoBar
     * @see #getAddettoBy(long)
     */
    boolean addAddetto(AddettoBar addettoBar);

    /**
     * Rimuove l' addetto bar avente l' id specificato.
     * Restitusice {@code true} se l' addetto bar viene rimosso, altrimenti {@code false}.
     *
     * @param id l' id dell' addetto bar da rimuovere dall' insieme degli addetti bar
     * @return {@code true} se l' addetto bar viene rimosso, altrimenti {@code false}
     * @see AddettoBar
     */
    boolean removeAddetto(long id);

    /**
     * Restituisce un {@link Optional} che descrive l' addetto bar in base all' id specificato.
     * Se non viene trovato nessun addetto bar con l' id specificato viene restituito un empty {@code Optional}.
     *
     * @param id l'id dell' addetto bar da restituire
     * @return un {@code Optional} che descrive l' addetto bar con quell' id specificato, altrimenti un empty {@code Optional} se non viene trovato nessun addetto bar con quell' id
     * @see AddettoBar
     */
    Optional<AddettoBar> getAddettoBy(long id);
}
