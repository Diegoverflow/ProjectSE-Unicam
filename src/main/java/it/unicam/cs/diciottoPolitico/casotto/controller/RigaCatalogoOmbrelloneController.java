package it.unicam.cs.diciottoPolitico.casotto.controller;

import com.google.zxing.WriterException;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.service.RigaCatalogoOmbrelloneService;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoOmbrelloneRepository;
import it.unicam.cs.diciottoPolitico.casotto.utils.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.awt.image.RenderedImage;
import java.util.List;
import java.util.UUID;

/**
 * RestController delle righe del catalogo ombrelloni dello chalet.
 * Esso si occupa di gestire le richieste HTTP per aggiungere, modificare, rimuovere e leggere una {@link SimpleRigaCatalogoOmbrellone}.
 * Questo RestController avr&agrave; un' istanza di {@link RigaCatalogoOmbrelloneService} che si occuper&agrave; di eseguire operazioni
 * CRUD interagendo con il relativo {@link RigaCatalogoOmbrelloneRepository}.
 *
 * @see SimpleRigaCatalogoOmbrellone
 * @see RigaCatalogoOmbrelloneService
 */
@RestController
@RequestMapping("/catalogo/ombrelloni")
public class RigaCatalogoOmbrelloneController {

    @Autowired
    private RigaCatalogoOmbrelloneService service;

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le righe del catalogo ombrelloni dello chalet.
     *
     * @return la lista di tutte le righe del catalogo ombrelloni dello chalet
     */
    @GetMapping("/all")
    public List<SimpleRigaCatalogoOmbrellone> getRigheCatalogoOmbrellone() {
        return this.service.getAll();
    }


    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce una {@link SimpleRigaCatalogoOmbrellone} avente id specificato nel {@link PathVariable}.
     *
     * @param id l' id di cui ricavare una {@code SimpleRigaCatalogoOmbrellone}
     * @return la riga catalogo ombrellone avente id specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna {@code SimpleRigaCatalogoOmbrellone} con id specificato
     */
    @GetMapping("/{id}")
    public SimpleRigaCatalogoOmbrellone getRigaCatalogoOmbrelloneById(@PathVariable UUID id) {
        return this.service.getBy(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#POST}.
     * Aggiunge la {@link SimpleRigaCatalogoOmbrellone} contenuta nel {@link RequestBody} della richiesta HTTP al catalogo ombrelloni dello chalet.
     * Restituisce la {@code SimpleRigaCatalogoOmbrellone} aggiunta.
     *
     * @param riga la {@code SimpleRigaCatalogoOmbrellone} da aggiungere al catalogo ombrelloni dello chalet
     * @return la {@code SimpleRigaCatalogoOmbrellone} aggiunta
     * @throws ResponseStatusException con {@link HttpStatus#BAD_REQUEST} se si tenta di aggiungere
     *                                 una {@code SimpleRigaCatalogoOmbrellone} gi&agrave; esistente
     *                                 oppure se contiene un {@link SimpleOmbrellone} gi&agrave; contenuto in un' altra riga
     *                                 oppure il codice spiaggia dell' ombrellone non &egrave; valido
     */
    @PostMapping
    public SimpleRigaCatalogoOmbrellone addRigaCatalogoOmbrellone(@Valid @RequestBody SimpleRigaCatalogoOmbrellone riga) {
        var r = this.service.save(riga);
        if (r != null)
            return r;
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#PUT}.
     * Aggiorna la {@link SimpleRigaCatalogoOmbrellone} specificata contenuta nel {@link RequestBody}.
     * Restituisce la {@code SimpleRigaCatalogoOmbrellone} aggiornata nel catalogo ombrelloni dello chalet.
     *
     * @param riga la {@code SimpleRigaCatalogoOmbrellone} da aggiornare
     * @return la {@code SimpleRigaCatalogoOmbrellone} aggiornata nel catalogo ombrelloni dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se la {@code SimpleRigaCatalogoOmbrellone} non viene trovata
     */
    @PutMapping
    public SimpleRigaCatalogoOmbrellone updateRigaCatalogoOmbrellone(@Valid @RequestBody SimpleRigaCatalogoOmbrellone riga) {
        var r = this.service.update(riga);
        if (r != null)
            return r;
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#DELETE}.
     * Rimuove dal catalogo ombrelloni dello chalet, la {@link SimpleRigaCatalogoOmbrellone} avente l' id specificato nel {@link PathVariable}.
     * Restituisce la {@code SimpleRigaCatalogoOmbrellone} rimossa dal catalogo ombrelloni dello chalet.
     *
     * @param id l' id della {@code SimpleRigaCatalogoOmbrellone} da eliminare
     * @return la {@code SimpleRigaCatalogoOmbrellone} rimossa dal catalogo ombrelloni dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se si specifica un id inesistente
     */
    @DeleteMapping("/{id}")
    public SimpleRigaCatalogoOmbrellone removeRigaCatalogoOmbrellone(@PathVariable UUID id) {
        return this.service.removeBy(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/qrcode/{nome}")
    public RenderedImage generateQRCode(@PathVariable String nome) throws WriterException {
        return QRCodeGenerator.setQRCodeSize(nome,500,500);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<SimpleRigaCatalogoOmbrellone> handleDataIntegrityViolation() {
        return ResponseEntity.badRequest().build();
    }

}