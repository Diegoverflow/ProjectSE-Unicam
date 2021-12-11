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
    private final Catalogo<ArticoloBar, RigaCatalogoBar> catalogoBar;
    private final Map<OrdinazioneBar, Optional<AddettoBar>> ordinazioniDaGestire;
    private final HandlerNotifica handlerNotifica;

    /**
     * Crea un semplice gestore di ordinazioni bar.
     */
    public SimpleHandlerOrdinazioneBar() {
        this.addettiBar = new HashSet<>();
        this.catalogoBar = new SimpleCatalogo<>();
        this.ordinazioniDaGestire = new HashMap<>();
        this.handlerNotifica = new SimpleHandlerNotifica();
    }

    @Override
    public Map<OrdinazioneBar, Optional<AddettoBar>> getOrdinazioniDaGestire() {
        return this.ordinazioniDaGestire;
    }

    @Override
    public List<ArticoloBar> getArticoliDisponibili() {
        List<RigaCatalogoBar> righeCatalogoBar = this.catalogoBar.getAllRighe();
        List<ArticoloBar> articoliBar = new LinkedList<>();
        for (RigaCatalogoBar rigaCatalogoBar : righeCatalogoBar)
            articoliBar.add(rigaCatalogoBar.getValore());
        return articoliBar;
    }

    @Override
    public Optional<OrdinazioneBar> getOrdinazioneBarBy(long idOrdinazione) {
        return this.ordinazioniDaGestire.keySet().stream().filter(o -> o.getId() == idOrdinazione).findFirst();
    }

    @Override
    public boolean creaOrdinazione(OrdinazioneBar ordinazioneBar, Cliente cliente) {
        this.ordinazioniDaGestire.put(ordinazioneBar, Optional.empty());
        this.notificaTuttiGliAddetti(new SimpleNotifica(ordinazioneBar.getId(), ordinazioneBar.toString()));
        return Objects.requireNonNull(cliente, "Cliente null!").addOrdinazioneBar(ordinazioneBar);
    }

    @Override
    public List<OrdinazioneBar> getOrdinazioniNonPreseInCarico() {
        List<OrdinazioneBar> ordinazioniDaConsegnare = new LinkedList<>();
        this.ordinazioniDaGestire.forEach((ordinazioneBar, addettoBar) -> {
            if (addettoBar.isEmpty())
                this.aggiungiOrdinazione(ordinazioneBar, ordinazioniDaConsegnare);
        });
        return ordinazioniDaConsegnare;
    }

    private void aggiungiOrdinazione(OrdinazioneBar ordinazioneBar, List<OrdinazioneBar> ordinazioni) {
        ordinazioni.add(ordinazioneBar);
    }

    @Override
    public boolean addAddetto(AddettoBar addettoBar) {
        return this.addettiBar.add(Objects.requireNonNull(addettoBar, "Addetto bar null!");
);
    }


    @Override
    public boolean removeAddetto(long id) {
        Optional<AddettoBar> addettoBar = this.getAddettoBy(id);
        return addettoBar.isPresent() && this.addettiBar.remove(addettoBar.get());
    }

    @Override
    public Optional<AddettoBar> getAddettoBy(long id) {
        return this.addettiBar.stream().filter(a -> a.getId() == id).findFirst();
    }

    private void notificaTuttiGliAddetti(Notifica notifica) {
        this.addettiBar.forEach(a -> this.handlerNotifica.notifica(notifica, a));
    }

}
