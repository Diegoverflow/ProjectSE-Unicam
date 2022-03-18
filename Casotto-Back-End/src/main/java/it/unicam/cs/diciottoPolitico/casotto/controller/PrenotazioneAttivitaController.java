package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.model.SimplePrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.model.SimplePrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneAttivitaRepository;
import it.unicam.cs.diciottoPolitico.casotto.service.PrenotazioneAttivitaService;
import it.unicam.cs.diciottoPolitico.casotto.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
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
@RestController
@RequestMapping("/prenotazioni/attivita")
public class PrenotazioneAttivitaController {

    @Autowired
    private PrenotazioneAttivitaService prenotazioneAttivitaService;

    @Autowired
    private UtenteService utenteService;

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

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le prenotazioni delle attivit&agrave; effettuate dai clienti.
     *
     * @return la lista di tutte le prenotazioni delle attivit&agrave; effettuate dai clienti
     */
    @GetMapping("/all")
    public List<SimplePrenotazioneAttivita> getPrenotazioni() {
        var r = this.prenotazioneAttivitaService.getAll();
        if (r.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return r;
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la {@link SimplePrenotazioneAttivita} avente id specificato nel {@link PathVariable}.
     *
     * @return la {@code SimplePrenotazioneAttivita} avente id specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna{@code SimplePrenotazioneAttivita} con id specificato
     */
    @GetMapping("/{idPrenotazione}")
    public SimplePrenotazioneAttivita getPrenotazioneBy(@PathVariable UUID idPrenotazione) {
        return this.prenotazioneAttivitaService.getBy(idPrenotazione).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la {@link SimplePrenotazioneAttivita} avente nome specificato nel {@link PathVariable}.
     *
     * @return la {@code SimplePrenotazioneAttivita} avente nome specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna{@code SimplePrenotazioneAttivita} con nome specificato
     */
    @GetMapping("/{nomeAttivitaPrenotata}")
    public SimplePrenotazioneAttivita getPrenotazioniBy(@PathVariable String nomeAttivitaPrenotata) {
        return this.prenotazioneAttivitaService.filtraBy(nomeAttivitaPrenotata).stream().findFirst().
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/loggedUser")
    public List<SimplePrenotazioneAttivita> getPrenotazioniOmbrelloniByUserId(){
        return this.prenotazioneAttivitaService.filtraBy(this.utenteService.getLoggedUser());
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#POST}.
     * Aggiunge la {@link SimplePrenotazioneAttivita} contenuta nel {@link RequestBody} della richiesta HTTP alle prenotazioni delle attivit&agrave; effettuate dai clienti.
     * Restituisce la {@code SimplePrenotazioneAttivita} aggiunta.
     *
     * @param prenotazioneAttivita la {@code SimplePrenotazioneAttivita} da aggiungere alle prenotazioni delle attivit&agrave; dello chalet
     * @return la {@code SimplePrenotazioneAttivita} aggiunta
     * @throws ResponseStatusException con {@link HttpStatus#BAD_REQUEST} se si tenta di aggiungere
     *                                 una {@code SimplePrenotazioneAttivita} non presente nel catalogo attivit&agrave; dello chalet oppure se la {@code SimplePrenotazioneAttivita} non &egrave; valida
     */
    @PostMapping
    public SimplePrenotazioneAttivita addPrenotazione(@RequestBody SimplePrenotazioneAttivita prenotazioneAttivita) {
        var v = this.prenotazioneAttivitaService.save(prenotazioneAttivita);
        if (v == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return v;
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#PUT}.
     * Aggiorna la {@link SimplePrenotazioneAttivita} specificata contenuta nel {@link RequestBody}.
     * Restituisce la {@code SimplePrenotazioneAttivita} aggiornata nelle prenotazioni attivit&agrave; dello chalet.
     *
     * @param prenotazioneAttivita la {@code SimplePrenotazioneAttivita} da aggiornare
     * @return la {@code SimplePrenotazioneAttivita} aggiornata nelle prenotazioni attivit&agrave; dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se la {@code SimplePrenotazioneAttivita} non viene trovata
     */
    @PutMapping
    public SimplePrenotazioneAttivita updatePrenotazione(@RequestBody SimplePrenotazioneAttivita prenotazioneAttivita) {
        var v = this.prenotazioneAttivitaService.update(prenotazioneAttivita);
        if (v == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return v;
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#DELETE}.
     * Rimuove dalle prenotazioni delle attivit&agrave; dello chalet, la {@link SimplePrenotazioneAttivita} avente l' id specificato nel {@link PathVariable}.
     * Restituisce la {@code SimplePrenotazioneAttivita} rimossa dalle prenotazioni delle attivit&agrave; dello chalet.
     *
     * @param id l' id della {@code SimplePrenotazioneAttivita} da eliminare
     * @return la {@code SimplePrenotazioneAttivita} rimossa dalle prenotazioni delle attivit&agrave; dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se si specifica un id inesistente
     */
    @DeleteMapping("/{id}")
    public SimplePrenotazioneAttivita deletePrenotazione(@PathVariable UUID id) {
        return this.prenotazioneAttivitaService.removeBy(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }




}
