package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.model.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.model.SimplePrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.service.PrenotazioneOmbrelloneService;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneOmbrelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * RestController delle prenotazioni degli ombrelloni che effettuano i clienti.
 * Esso si occupa di gestire le richieste HTTP per aggiungere, modificare, rimuovere e leggere una {@link SimplePrenotazioneOmbrellone}.
 * Questo RestController avr&agrave; un' istanza di {@link PrenotazioneOmbrelloneService} che si occuper&agrave; di eseguire operazioni
 * CRUD interagendo con il relativo {@link PrenotazioneOmbrelloneRepository}.
 *
 * @see SimplePrenotazioneOmbrellone
 * @see PrenotazioneOmbrelloneService
 */
@RestController
@RequestMapping("/prenotazioni/ombrelloni")
public class PrenotazioneOmbrelloneController{

    @Autowired
    private PrenotazioneOmbrelloneService prenotazioneOmbrelloneService;

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le righe del catalogo degli ombrelloni disponibili in base alla data e alla {@link FasciaOraria} specificate nei {@link RequestParam}.
     *
     * @param data         la data in cui cercare il {@link SimpleOmbrellone} disponibile
     * @param fasciaOraria la fascia oraria in cui cercare il {@link SimpleOmbrellone} disponibile
     * @return la lista di tutte le righe del catalogo degli ombrelloni disponibili in base alla data e alla {@code FasciaOraria} specificate.
     */
    @GetMapping("/disponibili/{data}/{fasciaOraria}")
    public List<SimpleRigaCatalogoOmbrellone> getOmbrelloniDisponibili(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date data, @PathVariable FasciaOraria fasciaOraria) {
        return this.prenotazioneOmbrelloneService.getRigheDisponibiliBy(data, fasciaOraria);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le prenotazioni degli ombrelloni effettuate dai clienti.
     *
     * @return la lista di tutte le prenotazioni degli ombrelloni effettuate dai clienti
     */
    @GetMapping("/all")
    public List<SimplePrenotazioneOmbrellone> getPrenotazioniOmbrellone() {
        return this.prenotazioneOmbrelloneService.getAll();
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la {@link SimplePrenotazioneOmbrellone} avente id specificato nel {@link PathVariable}.
     *
     * @return la {@code SimplePrenotazioneOmbrellone} avente id specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna{@code SimplePrenotazioneOmbrellone} con id specificato
     */
    @GetMapping("/{id}")
    public SimplePrenotazioneOmbrellone getPrenotazioneOmbrelloneById(@PathVariable UUID id) {
        return this.prenotazioneOmbrelloneService.getBy(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#POST}.
     * Aggiunge la {@link SimplePrenotazioneOmbrellone} contenuta nel {@link RequestBody} della richiesta HTTP alle prenotazioni degli ombrelloni effettuate dai clienti.
     * Restituisce la {@code SimplePrenotazioneOmbrellone} aggiunta.
     *
     * @param prenotazioneOmbrellone la {@code SimplePrenotazioneOmbrellone} da aggiungere alle prenotazioni degli ombrelloni dello chalet
     * @return la {@code SimplePrenotazioneOmbrellone} aggiunta
     * @throws ResponseStatusException con {@link HttpStatus#BAD_REQUEST} se si tenta di aggiungere
     *                                 una {@code SimplePrenotazioneOmbrellone} riferita a un {@link SimpleOmbrellone} non presente nel catalogo bar dello chalet oppure se il {@code SimpleOmbrellone} &egrave; gi&agrave; prenotato
     */
    @PostMapping
    public SimplePrenotazioneOmbrellone addPrenotazioneOmbrellone(@Valid @RequestBody SimplePrenotazioneOmbrellone prenotazioneOmbrellone) {
        var prenotazione = this.prenotazioneOmbrelloneService.save(prenotazioneOmbrellone);
        if (prenotazione == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return prenotazione;
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#DELETE}.
     * Rimuove dalle prenotazioni degli ombrelloni dello chalet, la {@link SimplePrenotazioneOmbrellone} avente l' id specificato nel {@link PathVariable}.
     * Restituisce la {@code SimplePrenotazioneOmbrellone} rimossa dalle prenotazioni degli ombrelloni dello chalet.
     *
     * @param id l' id della {@code SimplePrenotazioneOmbrellone} da eliminare
     * @return la {@code SimplePrenotazioneOmbrellone} rimossa dalle prenotazioni degli ombrelloni dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se si specifica un id inesistente
     */
    @DeleteMapping("/{id}")
    public SimplePrenotazioneOmbrellone removePrenotazioneOmbrellone(@PathVariable UUID id) {
        return this.prenotazioneOmbrelloneService.removeBy(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<Object> handleConstraintViolation() {
        return ResponseEntity.badRequest().build();
    }

}