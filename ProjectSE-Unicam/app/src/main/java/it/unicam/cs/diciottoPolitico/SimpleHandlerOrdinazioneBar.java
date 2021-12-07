package it.unicam.cs.diciottoPolitico;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementazione di un semplice gestore per le ordinazioni bar effettuate da parte dei clienti.
 * Questo gestore ha un insieme di addetti bar, che a loro volta si occupano di gestire le ordinazioni
 * bar effettuate.
 * Il gestore tiene traccia esclusivamente di tutte le ordinazioni ancora da consegnare.
 */
public class SimpleHandlerOrdinazioneBar implements HandlerOrdinazioneBar {

    private final Set<AddettoBar> addettiBar;
    private final Set<RigaCatalogoBar> articoliDisponibili;
    private final Catalogo<OrdinazioneBar, RigaCatalogo<OrdinazioneBar>> catalogoBar;
    private final Map<OrdinazioneBar, AddettoBar> ordinazioniDaGestire;

    /**
     * Crea un semplice gestore di ordinazioni bar.
     */
    public SimpleHandlerOrdinazioneBar() {
        this.addettiBar = new HashSet<>();
        this.articoliDisponibili = new HashSet<>();
        this.catalogoBar = null;    // TODO: inizializzare a new SimpleCatalogoBar
        this.ordinazioniDaGestire = new HashMap<>();
    }

    @Override
    public Map<OrdinazioneBar, AddettoBar> getOrdinazioniDaGestire() {
        return this.ordinazioniDaGestire;
    }

    @Override
    public Set<RigaCatalogoBar> getRigheArticoliDisponibili() {
        return this.articoliDisponibili;
    }

    @Override
    public boolean creaOrdinazione(OrdinazioneBar ordinazioneBar, Cliente cliente) {
        // TODO: Chiedere come fare
        // TODO: implementare   Cliente conosce la lista delle sue ordinazioni (ci pensa Dieghito babe)
        return false;
    }

    @Override
    public List<OrdinazioneBar> getOrdinazioniDaConsegnare() {
        List<OrdinazioneBar> ordinazioniDaConsegnare = new LinkedList<>();
        this.ordinazioniDaGestire.forEach((ordinazioneBar, addettoBar) -> this.aggiungiOrdinazione(ordinazioneBar, addettoBar, ordinazioniDaConsegnare));
        return ordinazioniDaConsegnare;
    }

    private void aggiungiOrdinazione(OrdinazioneBar ordinazioneBar, AddettoBar addettoBar, List<OrdinazioneBar> ordinazioni) {
        if (addettoBar == null)
            ordinazioni.add(ordinazioneBar);
    }

    @Override
    public boolean addAddetto(AddettoBar addettoBar) {
        Objects.requireNonNull(addettoBar, "Addetto bar null!");
        return this.addettiBar.add(addettoBar);
    }

    @Override
    public boolean modifyAddetto(long id, String nome, String cognome, String password) {
        // TODO: da testare perchè non sono sicurissimo che funzioni
        AddettoBar addettoModificato = new SimpleAddettoBar(id, nome, cognome, password, this);
        return this.addettiBar.addAll(
                this.addettiBar.stream()
                        .filter(a -> a.equals(addettoModificato))
                        .map(a -> addettoModificato)
                        .collect(Collectors.toSet())
        );
    }

    @Override
    public boolean removeAddetto(long id) {
        Optional<AddettoBar> addettoBar = this.getAddettoBy(id);
        return addettoBar.isPresent() && this.addettiBar.remove(addettoBar.get());
    }

    @Override
    public Optional<AddettoBar> getAddettoBy(long id) {
        return this.addettiBar.stream()
                .filter(a -> a.getId() == id).findFirst();
    }

    private void notificaTuttiGliAddetti(String messaggio) {
        // TODO: implementare
    }

}
