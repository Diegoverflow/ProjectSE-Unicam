package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimplePrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.service.PrenotazioneOmbrelloneService;
import it.unicam.cs.diciottoPolitico.casotto.service.RigaCatalogoOmbrelloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneOmbrelloneController {

    @Autowired
    private PrenotazioneOmbrelloneService prenotazioneOmbrelloneService;

    @GetMapping("/ombrelloni/disponibili")
    public List<SimpleRigaCatalogoOmbrellone> getOmbrelloniDisponibili(@RequestParam Date data, @RequestParam FasciaOraria fasciaOraria) {
        return this.prenotazioneOmbrelloneService.getRigheDisponibiliBy(data, fasciaOraria);
    }

    @GetMapping("/ombrelloni/all")
    public List<SimplePrenotazioneOmbrellone> getPrenotazioniOmbrellone() {
        return this.prenotazioneOmbrelloneService.getAll();
    }

    @GetMapping("/ombrelloni/{id}")
    public SimplePrenotazioneOmbrellone getPrenotazioneOmbrelloneById(@PathVariable UUID id) {
        return this.prenotazioneOmbrelloneService.getBy(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/ombrelloni")
    public SimplePrenotazioneOmbrellone addPrenotazioneOmbrellone(@RequestBody SimplePrenotazioneOmbrellone prenotazioneOmbrellone) {
        var prenotazione = this.prenotazioneOmbrelloneService.save(prenotazioneOmbrellone);
        if (prenotazione == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return prenotazione;
    }

    @DeleteMapping("/ombrelloni/{id}")
    public SimplePrenotazioneOmbrellone removePrenotazioneOmbrellone(@PathVariable UUID id) {
        return this.prenotazioneOmbrelloneService.removeBy(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}