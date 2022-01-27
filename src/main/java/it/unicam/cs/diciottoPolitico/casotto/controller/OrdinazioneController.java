package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.OrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.StatusOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.OrdinazioneBarRepository;
import it.unicam.cs.diciottoPolitico.casotto.service.OrdinazioneBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * RestController delle ordinazioni bar che effettuano i clienti.
 * Esso si occupa di gestire le richieste HTTP per aggiungere, modificare, rimuovere e leggere un' {@link OrdinazioneBar}.
 * Questo RestController avr&agrave; un' istanza di {@link OrdinazioneBarService} che si occuper&agrave; di eseguire operazioni
 * CRUD interagendo con il relativo {@link OrdinazioneBarRepository}.
 *
 * @see OrdinazioneBar
 * @see OrdinazioneBarService
 */
@RestController
@RequestMapping("/bar/ordinazioni")
public class OrdinazioneController {

    @Autowired
    private OrdinazioneBarService ordinazioneBarService;

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le ordinazioni bar effettuate dai clienti.
     *
     * @return la lista di tutte le ordinazioni bar effettuate dai clienti
     */
    @GetMapping("/all")
    public List<SimpleOrdinazioneBar> getAllOrdinazioni() {
        return this.ordinazioneBarService.getAll();
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le ordinazioni bar effettuate dai clienti che si trovano nello {@link StatusOrdinazioneBar} specificato nel {@link RequestParam}.
     *
     * @param status lo status in cui si devono trovare le ordinazioni bar
     * @return la lista di tutte le ordinazioni bar che si trovano nello {@code StatusOrdinazioneBar} specificato
     */
    @GetMapping(params = "status")
    public List<SimpleOrdinazioneBar> filtraByStatus(@RequestParam(value = "status") StatusOrdinazioneBar status) {
        return this.filtraByStatus(status);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le ordinazioni bar effettuate dai clienti che hanno ordinato il {@link SimpleArticoloBar} specificato nel {@link RequestParam}.
     *
     * @param articoloBar il {@code SimpleArticoloBar} che devono contenere le ordinazioni bar
     * @return la lista di tutte le ordinazioni bar dei clienti che hanno ordinato il {@code SimpleArticoloBar} specificato
     */
    @GetMapping(params = "articolo_bar")
    public List<SimpleOrdinazioneBar> filtraByArticoloBar(@RequestParam(value = "articolo_bar") SimpleArticoloBar articoloBar) {
        return this.filtraByArticoloBar(articoloBar);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le ordinazioni bar effettuate dai clienti che hanno ordinato il {@link SimpleArticoloBar} con nome specificato nel {@link RequestParam}.
     *
     * @param nomeArticoloBar il nome del {@code SimpleArticoloBar} che devono contenere le ordinazioni bar
     * @return la lista di tutte le ordinazioni bar dei clienti che hanno ordinato il {@code SimpleArticoloBar} aventi nome specificato
     */
    @GetMapping(params = "nome_articolo_bar")
    public List<SimpleOrdinazioneBar> filtraByNomeArticoloBar(@RequestParam(value = "nome_articolo_bar") String nomeArticoloBar) {
        return this.filtraByNomeArticoloBar(nomeArticoloBar);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#POST}.
     * Aggiunge la {@link SimpleOrdinazioneBar} contenuta nel {@link RequestBody} della richiesta HTTP alle ordinazioni effettuate dai clienti dello chalet.
     * Restituisce la {@code SimpleOrdinazioneBar} aggiunta.
     *
     * @param ordinazione la {@code SimpleOrdinazioneBar} da aggiungere alle ordinazioni bar dello chalet
     * @return la {@code SimpleOrdinazioneBar} aggiunta
     * @throws ResponseStatusException con {@link HttpStatus#BAD_REQUEST} se si tenta di aggiungere
     *                                 una {@code SimpleOrdinazioneBar} riferita a un {@link SimpleArticoloBar} non presente nel catalogo bar dello chalet
     */
    @PostMapping
    public SimpleOrdinazioneBar addOrdinazione(@RequestBody SimpleOrdinazioneBar ordinazione) {
        Optional<SimpleOrdinazioneBar> foundOrdinazione = this.ordinazioneBarService.checkAndSave(ordinazione);
        return this.getOrdinazioneOrThrownException(foundOrdinazione, HttpStatus.BAD_REQUEST);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce una {@link SimpleOrdinazioneBar} avente id specificato.
     *
     * @param id l' id di cui ricavare una {@code SimpleOrdinazioneBar}
     * @return l' ordinazione bar avente id specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna {@code SimpleOrdinazioneBar} con id specificato
     */
   /* @GetMapping("/ordinazioni/{id}")
    public SimpleOrdinazioneBar getOrdinazioneBy(@PathVariable UUID id) {
        if (this.ordinazioneBarService.getOrdinazioneBy(id).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return this.ordinazioneBarService.getOrdinazioneBy(id).get();
    }

    */

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#POST}.
     * Aggiunge la {@link SimpleOrdinazioneBar} contenuta nel {@link RequestBody} della richiesta HTTP all dello chalet.
     * Restituisce l' {@code AreaInfrastruttura} aggiunta all' infrastruttura dello chalet.
     *
     * @param ordinazioneBar l' area da aggiungere all' infrastruttura dello chalet
     * @return l' {@code AreaInfrastruttura} aggiunta all' infrastruttura dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#BAD_REQUEST} se si tenta di aggiungere
     *                                 un' {@code AreaInfrastruttura} gi&agrave; presente nell' infrastruttura dello chalet
     *//*
    @PostMapping("/ordinazioni/{id}")
    public SimpleOrdinazioneBar addOrdinazione(@PathVariable UUID id, @RequestBody SimpleOrdinazioneBar ordinazioneBar) {
        Optional<SimpleOrdinazioneBar> foundOrdinazione = this.ordinazioneBarService.addOrdinazione(ordinazioneBar);
        if (foundOrdinazione.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return foundOrdinazione.get();
    }*/
    private SimpleOrdinazioneBar getOrdinazioneOrThrownException(Optional<SimpleOrdinazioneBar> ordinazione, HttpStatus status) {
        if (ordinazione.isEmpty())
            throw new ResponseStatusException(status);
        return ordinazione.get();
    }

}
