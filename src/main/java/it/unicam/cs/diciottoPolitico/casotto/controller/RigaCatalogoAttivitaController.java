package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoAttivitaRepository;
import it.unicam.cs.diciottoPolitico.casotto.service.RigaCatalogoAttivitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.UUID;

/**
 * RestController del catalogo attivit&agrave; dello chalet.
 * Esso si occupa di gestire le richieste HTTP per aggiungere, modificare, rimuovere e leggere una {@link SimpleRigaCatalogoAttivita}.
 * Questo RestController avr&agrave; un' istanza di {@link RigaCatalogoAttivitaService} che si occuper&agrave; di eseguire operazioni
 * CRUD interagendo con il relativo {@link RigaCatalogoAttivitaRepository}.
 *
 * @see SimpleRigaCatalogoAttivita
 * @see RigaCatalogoAttivitaService
 */
@RestController
@RequestMapping("/catalogo/attivita")
public class RigaCatalogoAttivitaController {

    @Autowired
    private RigaCatalogoAttivitaService rigaCatalogoAttivitaService;

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le righe presenti nel catalogo attivit&agrave; dello chalet.
     *
     * @return la lista di tutte le righe presenti nel catalogo attivit&agrave; dello chalet.
     */
    @GetMapping("/all")
    public List<SimpleRigaCatalogoAttivita> getRigheCatalogoAttivita() {
        return this.rigaCatalogoAttivitaService.getAll();
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce una {@link SimpleRigaCatalogoAttivita} avente id specificato nel {@link PathVariable}.
     *
     * @param idRiga l' id di cui ricavare la riga dal catalogo attivit&agrave;
     * @return la riga avente id specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna {@code SimpleRigaCatalogoAttivita} con id specificato
     */
    @GetMapping("/{idRiga}")
    public SimpleRigaCatalogoAttivita getRigaBy(@PathVariable UUID idRiga) {
        return this.rigaCatalogoAttivitaService.getBy(idRiga).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#POST}.
     * Aggiunge la {@link SimpleRigaCatalogoAttivita} contenuta nel {@link RequestBody} della richiesta HTTP al catalogo attivit&agrave; dello chalet.
     * Restituisce la {@code SimpleRigaCatalogoAttivita} aggiunta al catalogo attivit&agrave; dello chalet.
     *
     * @param rigaCatalogo la riga da aggiungere al catalogo attivit&agrave; dello chalet
     * @return la {@code SimpleRigaCatalogoAttivita} aggiunta al catalogo attivit&agrave; dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#BAD_REQUEST} se si tenta di aggiungere
     *                                 una {@code SimpleRigaCatalogoAttivita} gi&agrave; presente nel catalogo attivit&agrave; dello chalet
     *                                 oppure se la {@code SimpleRigaCatalogoAttivita} non &egrave; valida
     */
    @PostMapping
    public SimpleRigaCatalogoAttivita addRiga(@RequestBody SimpleRigaCatalogoAttivita rigaCatalogo) {
        var r = this.rigaCatalogoAttivitaService.save(rigaCatalogo);
        if (r == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return r;
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#PUT}.
     * Aggiorna la {@link SimpleRigaCatalogoAttivita} specificata contenuta nel {@link RequestBody}.
     * Restituisce la {@code SimpleRigaCatalogoAttivita} aggiornata nel catalogo attivit&agrave; dello chalet.
     *
     * @param rigaCatalogoAttivita la {@code SimpleRigaCatalogoAttivita} da aggiornare
     * @return la {@code SimpleRigaCatalogoAttivita} aggiornata nel catalogo attivit&agrave; dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se la {@code SimpleRigaCatalogoAttivita} non viene trovata
     */
    @PutMapping
    public SimpleRigaCatalogoAttivita updateRiga(@RequestBody SimpleRigaCatalogoAttivita rigaCatalogoAttivita) {
        var r = this.rigaCatalogoAttivitaService.save(rigaCatalogoAttivita);
        if (r == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return r;
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#DELETE}.
     * Rimuove dal catalogo attivit&agrave; dello chalet, la {@link SimpleRigaCatalogoAttivita} avente l' id specificato nel {@link PathVariable}.
     * Restituisce la {@code SimpleRigaCatalogoBar} rimossa dal catalogo attivit&agrave; dello chalet.
     *
     * @param idRiga l' id della {@code SimpleRigaCatalogoAttivita} da eliminare
     * @return la {@code SimpleRigaCatalogoAttivita} rimossa dal catalogo attivit&agrave; dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se si specifica un id inesistente
     */
    @DeleteMapping("/{idRiga}")
    public SimpleRigaCatalogoAttivita deleteRigaBy(@PathVariable UUID idRiga) {
        return this.rigaCatalogoAttivitaService.removeBy(idRiga).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<Object> handleConstraintViolation() {
        return ResponseEntity.badRequest().build();
    }


}
