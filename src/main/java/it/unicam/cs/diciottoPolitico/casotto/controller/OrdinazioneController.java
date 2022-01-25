package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.OrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.OrdinazioneBarRepository;
import it.unicam.cs.diciottoPolitico.casotto.service.OrdinazioneBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
@RequestMapping("/bar")
public class OrdinazioneController {

    @Autowired
    private OrdinazioneBarService ordinazioneBarService;

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le ordinazioni bar effettuate dai clienti.
     *
     * @return la lista di tutte le ordinazioni bar effettuate dai clienti
     */
    @GetMapping("/ordinazioni")
    public List<SimpleOrdinazioneBar> getAllOrdinazioni() {
        return this.ordinazioneBarService.getAll();
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce una {@link SimpleOrdinazioneBar} avente id specificato.
     *
     * @param id l' id di cui ricavare una {@code SimpleOrdinazioneBar}
     * @return l' ordinazione bar avente id specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna {@code SimpleOrdinazioneBar} con id specificato
     */
    @GetMapping("/ordinazioni/{id}")
    public SimpleOrdinazioneBar getOrdinazioneBy(@PathVariable UUID id) {
        if (this.ordinazioneBarService.getOrdinazioneBy(id).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return this.ordinazioneBarService.getOrdinazioneBy(id).get();
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#POST}.
     * Aggiunge la {@link SimpleOrdinazioneBar} contenuta nel {@link RequestBody} della richiesta HTTP all dello chalet.
     * Restituisce l' {@code AreaInfrastruttura} aggiunta all' infrastruttura dello chalet.
     *
     * @param ordinazioneBar l' area da aggiungere all' infrastruttura dello chalet
     * @return l' {@code AreaInfrastruttura} aggiunta all' infrastruttura dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#BAD_REQUEST} se si tenta di aggiungere
     *                                 un' {@code AreaInfrastruttura} gi&agrave; presente nell' infrastruttura dello chalet
     */
    @PostMapping("/ordinazioni/{id}")
    public SimpleOrdinazioneBar addOrdinazione(@PathVariable UUID id, @RequestBody SimpleOrdinazioneBar ordinazioneBar) {
        Optional<SimpleOrdinazioneBar> foundOrdinazione = this.ordinazioneBarService.addOrdinazione(ordinazioneBar);
        if (foundOrdinazione.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return foundOrdinazione.get();
    }
}
