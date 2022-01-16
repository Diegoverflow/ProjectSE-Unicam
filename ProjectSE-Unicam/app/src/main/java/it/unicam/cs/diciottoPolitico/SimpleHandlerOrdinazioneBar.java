package it.unicam.cs.diciottoPolitico;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementazione di un semplice gestore per le ordinazioni bar effettuate da parte dei clienti.
 * Questo gestore ha un insieme di addetti bar, che a loro volta si occupano di gestire le ordinazioni
 * bar effettuate.
 * Il gestore tiene traccia esclusivamente di tutte le ordinazioni ancora da consegnare.
 *
 * @see OrdinazioneBar
 * @see ArticoloBar
 * @see Catalogo
 * @see RigaCatalogoBar
 */
public class SimpleHandlerOrdinazioneBar implements HandlerOrdinazioneBar {

    private final Catalogo<ArticoloBar, RigaCatalogoBar> catalogoBar;
    private final List<OrdinazioneBar> ordinazioniBar;

    /**
     * Crea un semplice gestore di ordinazioni bar.
     */
    public SimpleHandlerOrdinazioneBar() {
        this.catalogoBar = new SimpleCatalogo<>();
        this.ordinazioniBar = new ArrayList<>();
    }

    @Override
    public List<ArticoloBar> getArticoliDisponibili() {
        return this.catalogoBar.getAllRighe().stream()
                .filter(riga -> riga.getQuantita()>0)
                .map(RigaCatalogo::getValore)
                .collect(Collectors.toList());
    }

    @Override
    public boolean prendiInCaricoOrdinazioneBar(OrdinazioneBar ordinazioneBar) {
        return cambiaStatusOrdinazioneBar(ordinazioneBar, StatusOrdinazioneBar.DA_PRENDERE_IN_CARICO,StatusOrdinazioneBar.PRESO_IN_CARICO);
    }

    @Override
    public boolean consegnaOrdinazioneBar(OrdinazioneBar ordinazioneBar) {
        return cambiaStatusOrdinazioneBar(ordinazioneBar, StatusOrdinazioneBar.PRESO_IN_CARICO, StatusOrdinazioneBar.CONSEGNATO);
    }

    @Override
    public boolean creaOrdinazioneBar(RigaCatalogoBar rigaCatalogoBar, Utente utente) {
        if (rigaCatalogoBar == null || utente == null)
            throw new NullPointerException("Nessun parametro puo' essere nullo");
        if(this.catalogoBar.getAllRighe().contains(rigaCatalogoBar) && rigaCatalogoBar.getQuantita() >0){
            rigaCatalogoBar.setQuantita(rigaCatalogoBar.getQuantita()-1);
            return this.ordinazioniBar.add(new SimpleOrdinazioneBar(rigaCatalogoBar.getValore(),rigaCatalogoBar.getPrezzo(),utente));
        }
        return false;
        //todo manca notificare i clienti
    }

    @Override
    public List<OrdinazioneBar> getOrdinazioniBar() {
        return this.ordinazioniBar;
    }

    @Override
    public List<OrdinazioneBar> getOrdinazioniDaPrendereInCarico() {
        return this.ordinazioniBar.stream()
                .filter(ordinazione -> ordinazione.getStatus() == StatusOrdinazioneBar.DA_PRENDERE_IN_CARICO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrdinazioneBar> getOrdinazioniDaConsegnare() {
        return this.ordinazioniBar.stream()
                .filter(ordinazione -> ordinazione.getStatus() == StatusOrdinazioneBar.PRESO_IN_CARICO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeOrdinazioneBar(OrdinazioneBar ordinazioneBar) {
        Objects.requireNonNull(ordinazioneBar,"L'ordinazione bar non puo' essere nulla");
        return this.ordinazioniBar.removeIf(prenotazione -> prenotazione.equals(ordinazioneBar));
    }

    private boolean cambiaStatusOrdinazioneBar(OrdinazioneBar ordinazioneBar,StatusOrdinazioneBar vecchioStatus, StatusOrdinazioneBar nuovoStatus){
        if(!this.ordinazioniBar.contains(Objects.requireNonNull(ordinazioneBar,"L'ordinazione bar non puo' essere nulla")))
            throw new IllegalArgumentException("L'ordinazione bar non e' presente");
        if(ordinazioneBar.getStatus() == vecchioStatus){
            ordinazioneBar.setStatus(nuovoStatus);
            return true;
        }
        return false;
    }

    //todo
    private void notificaTuttiGliAddetti(String messaggio){};
}
