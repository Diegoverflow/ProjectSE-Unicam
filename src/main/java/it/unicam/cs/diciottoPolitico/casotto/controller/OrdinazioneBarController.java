package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.OrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.StatusOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.OrdinazioneBarRepository;
import it.unicam.cs.diciottoPolitico.casotto.service.OrdinazioneBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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
@RequestMapping("/bar/ordinazioni")
public class OrdinazioneBarController {

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
     * Restituisce una {@link SimpleOrdinazioneBar} avente id specificato nel {@link PathVariable}.
     *
     * @param id l' id di cui ricavare una {@code SimpleOrdinazioneBar}
     * @return l' ordinazione bar avente id specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna {@code SimpleOrdinazioneBar} con id specificato
     */
    @GetMapping("/{id}")
    public SimpleOrdinazioneBar getOrdinazioneBy(@PathVariable UUID id) {
        return this.ordinazioneBarService.getBy(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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
        return this.ordinazioneBarService.filtraBy(status);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le ordinazioni bar effettuate dai clienti che hanno ordinato il {@link SimpleArticoloBar} specificato nel {@link RequestParam}.
     *
     * @param articoloBar il {@code SimpleArticoloBar} che devono contenere le ordinazioni bar
     * @return la lista di tutte le ordinazioni bar dei clienti che hanno ordinato il {@code SimpleArticoloBar} specificato
     */
    @GetMapping(params = "articolo-bar")
    public List<SimpleOrdinazioneBar> filtraByArticoloBar(@RequestParam(value = "articolo_bar") SimpleArticoloBar articoloBar) {
        return this.ordinazioneBarService.filtraBy(articoloBar);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le ordinazioni bar effettuate dai clienti che hanno ordinato il {@link SimpleArticoloBar} con nome specificato nel {@link RequestParam}.
     *
     * @param nomeArticoloBar il nome del {@code SimpleArticoloBar} che devono contenere le ordinazioni bar
     * @return la lista di tutte le ordinazioni bar dei clienti che hanno ordinato il {@code SimpleArticoloBar} aventi nome specificato
     */
    @GetMapping(params = "nome-articolo-bar")
    public List<SimpleOrdinazioneBar> filtraByNomeArticoloBar(@RequestParam(value = "nome_articolo_bar") String nomeArticoloBar) {
        return this.ordinazioneBarService.filtraBy(nomeArticoloBar);
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
    @PostMapping("/{nomeQRCode}")
    public SimpleOrdinazioneBar addOrdinazione(@PathVariable String nomeQRCode, @RequestBody SimpleOrdinazioneBar ordinazione) {
        return this.ordinazioneBarService.checkAndSave(nomeQRCode, ordinazione).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#DELETE}.
     * Rimuove dalle ordinazioni bar dello chalet, la {@link SimpleOrdinazioneBar} avente l' id specificato nel {@link PathVariable}.
     * Restituisce la {@code SimpleOrdinazioneBar} rimossa dalle ordinazioni bar dello chalet.
     *
     * @param id l' id della {@code SimpleOrdinazioneBar} da eliminare
     * @return la {@code SimpleOrdinazioneBar} rimossa dalle ordinazioni bar dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se si specifica un id inesistente
     */
    @DeleteMapping("/{id}")
    public SimpleOrdinazioneBar removeOrdinazione(@PathVariable UUID id) {
        return this.ordinazioneBarService.removeBy(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
