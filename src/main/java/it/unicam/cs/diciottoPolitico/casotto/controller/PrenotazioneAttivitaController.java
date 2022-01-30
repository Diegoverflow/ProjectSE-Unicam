package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.model.SimplePrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneAttivitaRepository;
import it.unicam.cs.diciottoPolitico.casotto.service.PrenotazioneAttivitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

/**
 * RestController delle prenotazioni attivit&agrave; che effettuano i clienti.
 * Esso si occupa di gestire le richieste HTTP per aggiungere, modificare, rimuovere e leggere una {@link SimplePrenotazioneAttivita}.
 * Questo RestController avr&agrave; un' istanza di {@link PrenotazioneAttivitaService} che si occuper&agrave; di eseguire operazioni
 * CRUD interagendo con il relativo {@link PrenotazioneAttivitaRepository}.
 *
 * @see SimplePrenotazioneAttivita
 * @see PrenotazioneAttivitaService
 */
// TODO: finire javadoc
@RestController
@RequestMapping("/prenotazioni/attivita")
public class PrenotazioneAttivitaController {

    @Autowired
    private PrenotazioneAttivitaService prenotazioneAttivitaService;

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le prenotazioni attivit&agrave; attualmente disponibili.
     *
     * @return la lista di tutte le prenotazioni attivit&agrave; attualmente disponibili
     */
    @GetMapping("/disponibili")
    public List<SimpleRigaCatalogoAttivita> getAttivitaDisponibili() {
        var r = this.prenotazioneAttivitaService.getAttivitaDisponibili();
        if (r.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return r;
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce una {@link SimpleRigaCatalogoAttivita} avente nome specificato nel {@link PathVariable}.
     *
     * @param nomeAttivita il nome di cui ricavare una {@code SimpleRigaCatalogoAttivita}
     * @return la {@code SimpleRigaCatalogoAttivita} avente nome specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna {@code SimpleRigaCatalogoAttivita} con nome specificato
     */
    @GetMapping("/disponibili/{nomeAttivita}")
    public SimpleRigaCatalogoAttivita getAttivitaDisponibiliBy(@PathVariable String nomeAttivita) {
        var r = this.prenotazioneAttivitaService.getAttivitaDisponibiliBy(nomeAttivita);
        if (r == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return r;
    }

    // TODO: cosa fa questo metodo? ritorna tutte le prenotazioni che sono nel repository...
    @GetMapping("/all")
    public List<SimplePrenotazioneAttivita> getPrenotazioni() {
        var r = this.prenotazioneAttivitaService.getAll();
        if (r.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return r;
    }

    @GetMapping("/{idPrenotazione}")
    public SimplePrenotazioneAttivita getPrenotazioneBy(@PathVariable UUID idPrenotazione) {
        return this.prenotazioneAttivitaService.getBy(idPrenotazione).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{nomeAttivitaPrenotata}")
    public SimplePrenotazioneAttivita getPrenotazioniBy(@PathVariable String nomeAttivitaPrenotata) {
        return this.prenotazioneAttivitaService.filtraBy(nomeAttivitaPrenotata).stream().findFirst().
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public SimplePrenotazioneAttivita addPrenotazione(@RequestBody SimplePrenotazioneAttivita prenotazioneAttivita) {
        var v = this.prenotazioneAttivitaService.save(prenotazioneAttivita);
        if (v == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return v;
    }

    @PutMapping
    public SimplePrenotazioneAttivita updatePrenotazione(@RequestBody SimplePrenotazioneAttivita prenotazioneAttivita) {
        var v = this.prenotazioneAttivitaService.update(prenotazioneAttivita);
        if (v == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return v;
    }

    @DeleteMapping("/{idPrenotazione}")
    public SimplePrenotazioneAttivita deletePrenotazione(@PathVariable UUID idPrenotazione) {
        return this.prenotazioneAttivitaService.removeBy(idPrenotazione).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}
