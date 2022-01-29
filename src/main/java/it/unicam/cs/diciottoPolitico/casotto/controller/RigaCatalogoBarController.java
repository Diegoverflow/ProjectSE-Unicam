package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoBarRepository;
import it.unicam.cs.diciottoPolitico.casotto.service.RigaCatalogoBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * RestController del catalogo bar dello chalet.
 * Esso si occupa di gestire le richieste HTTP per aggiungere, modificare, rimuovere e leggere una {@link SimpleRigaCatalogoBar}.
 * Questo RestController avr&agrave; un' istanza di {@link RigaCatalogoBarService} che si occuper&agrave; di eseguire operazioni
 * CRUD interagendo con il relativo {@link RigaCatalogoBarRepository}.
 *
 * @see SimpleRigaCatalogoBar
 * @see RigaCatalogoBarService
 */
@RestController
@RequestMapping("/bar/righe")
public class RigaCatalogoBarController {

    @Autowired
    private RigaCatalogoBarService rigaCatalogoBarService;

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le righe presenti nel catalogo bar dello chalet.
     *
     * @return la lista di tutte le righe presenti nel catalogo bar dello chalet.
     */
    @GetMapping("/all")
    public List<SimpleRigaCatalogoBar> getAllRighe() {
        return this.rigaCatalogoBarService.getAll();
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce una {@link SimpleRigaCatalogoBar} avente id specificato nel {@link PathVariable}.
     *
     * @param id l' id di cui ricavare la riga dal catalogo bar
     * @return la riga avente id specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna {@code SimpleRigaCatalogoBar} con id specificato
     */
    @GetMapping("/{id}")
    public SimpleRigaCatalogoBar getRigaBy(@PathVariable UUID id) {
        Optional<SimpleRigaCatalogoBar> foundRiga = this.rigaCatalogoBarService.getBy(id);
        return this.getRigaOrThrownException(foundRiga, HttpStatus.NOT_FOUND);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le righe aventi quantit&agrave; minore o uguale alla quantit&agrave; specificata nel {@link RequestParam}.
     *
     * @param quantitaLimite la quantit&agrave; limite inclusa
     * @return la lista di tutte le righe aventi quantit&agrave; minore o uguale alla quantit&agrave; specificata
     */
    @GetMapping(params = "quantita")
    public List<SimpleRigaCatalogoBar> filtraByQuantita(@RequestParam(value = "quantita") int quantitaLimite) {
        return this.rigaCatalogoBarService.filtraBy(quantitaLimite);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le righe aventi prezzo minore o uguale al prezzo specificato nel {@link RequestParam}.
     *
     * @param prezzoLimite il prezzo limite inclusa
     * @return la lista di tutte le righe aventi prezzo minore o uguale al prezzo specificato
     */
    @GetMapping(params = "prezzo")
    public List<SimpleRigaCatalogoBar> filtraByPrezzo(@RequestParam(value = "prezzo") double prezzoLimite) {
        return this.rigaCatalogoBarService.filtraBy(prezzoLimite);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce una {@link SimpleRigaCatalogoBar} avente come {@link SimpleArticoloBar} l' articolo bar specificato nel {@link PathVariable}
     *
     * @param articoloBar l' articolo bar di cui ricavare la riga
     * @return un {@code Optional} che descrive una {@code SimpleRigaCatalogoBar} avente l' articolo bar specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna riga con l' articolo bar specificato
     */
    @GetMapping(value = "/riga")
    public SimpleRigaCatalogoBar getRigaByArticolo(@RequestBody SimpleArticoloBar articoloBar) {
        Optional<SimpleRigaCatalogoBar> foundRiga = this.rigaCatalogoBarService.getRigaBy(articoloBar);
        return this.getRigaOrThrownException(foundRiga, HttpStatus.NOT_FOUND);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce una {@link SimpleRigaCatalogoBar} avente come nome del {@link SimpleArticoloBar} il nome specificato nel {@link RequestParam}
     *
     * @param nomeArticolo il nome dell' articolo bar di cui ricavare la riga
     * @return una {@code SimpleRigaCatalogoBar} avente il nome dell' articolo bar specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna riga con il nome dell' articolo bar specificato
     */
    @GetMapping(value = "/riga", params = "nome-articolo-bar")
    public SimpleRigaCatalogoBar getRigaByNomeArticoloBar(@RequestParam(value = "nome-articolo-bar") String nomeArticolo) {
        Optional<SimpleRigaCatalogoBar> foundRiga = this.rigaCatalogoBarService.getRigaBy(nomeArticolo);
        return this.getRigaOrThrownException(foundRiga, HttpStatus.NOT_FOUND);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#POST}.
     * Aggiunge la {@link SimpleRigaCatalogoBar} contenuta nel {@link RequestBody} della richiesta HTTP al catalogo bar dello chalet.
     * Restituisce la {@code SimpleRigaCatalogoBar} aggiunta al catalogo bar dello chalet.
     *
     * @param riga la riga da aggiungere al catalogo bar dello chalet
     * @return la {@code SimpleRigaCatalogoBar} aggiunta al catalogo bar dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#BAD_REQUEST} se si tenta di aggiungere
     *                                 una {@code SimpleRigaCatalogoBar} gi&agrave; presente nel catalogo bar dello chalet
     */
    @PostMapping
    public SimpleRigaCatalogoBar addRiga(@RequestBody SimpleRigaCatalogoBar riga) {
        Optional<SimpleRigaCatalogoBar> foundRiga = this.rigaCatalogoBarService.checkAndSave(riga);
        return this.getRigaOrThrownException(foundRiga, HttpStatus.BAD_REQUEST);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#PUT}.
     * Aggiorna la {@link SimpleRigaCatalogoBar} specificata contenuta nel {@link RequestBody}.
     * Restituisce la {@code SimpleRigaCatalogoBar} aggiornata nel catalogo bar dello chalet.
     *
     * @param riga la {@code SimpleRigaCatalogoBar} da aggiornare
     * @return la {@code SimpleRigaCatalogoBar} aggiornata nel catalogo bar dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se la {@code SimpleRigaCatalogoBar} non viene trovata
     */
    @PutMapping
    public SimpleRigaCatalogoBar updateRiga(@RequestBody SimpleRigaCatalogoBar riga) {
        Optional<SimpleRigaCatalogoBar> foundRiga = this.rigaCatalogoBarService.checkAndUpdate(riga);
        return this.getRigaOrThrownException(foundRiga, HttpStatus.NOT_FOUND);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#DELETE}.
     * Rimuove dal catalogo bar dello chalet, la {@link SimpleRigaCatalogoBar} avente l' id specificato nel {@link PathVariable}.
     * Restituisce la {@code SimpleRigaCatalogoBar} rimossa dal catalogo bar dello chalet.
     *
     * @param id l' id della {@code SimpleRigaCatalogoBar} da eliminare
     * @return la {@code SimpleRigaCatalogoBar} rimossa dal catalogo bar dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se si specifica un id inesistente
     */
    @DeleteMapping("/{id}")
    public SimpleRigaCatalogoBar removeRiga(@PathVariable UUID id) {
        Optional<SimpleRigaCatalogoBar> foundRiga = this.rigaCatalogoBarService.removeBy(id);
        return this.getRigaOrThrownException(foundRiga, HttpStatus.NOT_FOUND);
    }

    private SimpleRigaCatalogoBar getRigaOrThrownException(Optional<SimpleRigaCatalogoBar> riga, HttpStatus status) {
        if (riga.isEmpty())
            throw new ResponseStatusException(status);
        return riga.get();
    }

}
