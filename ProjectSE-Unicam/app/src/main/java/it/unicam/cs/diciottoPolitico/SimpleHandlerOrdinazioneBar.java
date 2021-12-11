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

    /**
     * Crea un semplice gestore di ordinazioni bar.
     */
    public SimpleHandlerOrdinazioneBar() {
        this.addettiBar = new HashSet<>();
        this.catalogoBar = new SimpleCatalogo<>();
        this.ordinazioniDaGestire = new HashMap<>();
    }

    @Override
    public Map<OrdinazioneBar, Optional<AddettoBar>> getOrdinazioniDaGestire() {
        return this.ordinazioniDaGestire;
    }

    @Override
    public List<ArticoloBar> getArticoliDisponibili() {
        return this.catalogoBar.getAllRighe().stream()
                .map(RigaCatalogo::getValore)
                .collect(Collectors.toList());
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
        return this.ordinazioniDaGestire.entrySet().stream()
                .filter(entry -> entry.getValue().isEmpty())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public boolean addAddetto(AddettoBar addettoBar) {
        return this.addettiBar.add(Objects.requireNonNull(addettoBar, "Addetto bar null!"));
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
        this.addettiBar.forEach(a -> HandlerNotifica.notifica(notifica, a));
    }

}
