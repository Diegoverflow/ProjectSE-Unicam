package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimplePrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.service.PrenotazioneAttivitaService;
import it.unicam.cs.diciottoPolitico.casotto.service.RigaCatalogoAttivitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni-attivita")
public class PrenotazioneAttivitaController {

    private final PrenotazioneAttivitaService prenotazioneAttivitaService;

    @Autowired
    public PrenotazioneAttivitaController(PrenotazioneAttivitaService prenotazioneAttivitaService) {
        this.prenotazioneAttivitaService = prenotazioneAttivitaService;
    }

    @GetMapping("/attivita-disponibili")
    public List<SimpleRigaCatalogoAttivita> getAttivitaDisponibili(){
        var r = this.prenotazioneAttivitaService.getAttivitaDisponibili();
        if (r.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return r;
    }

    @GetMapping("/attivita-disponibili/{nomeAttivita}")
    public SimpleRigaCatalogoAttivita getAttivitaDisponibiliBy(@PathVariable String nomeAttivita){
        var r = this.prenotazioneAttivitaService.getAttivitaDisponibiliBy(nomeAttivita);
        if (r==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return r;
    }

    @GetMapping("/le-mie-prenotazioni")
    public List<SimplePrenotazioneAttivita> getPrenotazioni(){
        var r = this.prenotazioneAttivitaService.getAll();
        if (r.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return r;
    }

    @GetMapping("/le-mie-prenotazioni/{idPrenotazione}")
    public SimplePrenotazioneAttivita getPrenotazioneBy(@PathVariable UUID idPrenotazione){
        return this.prenotazioneAttivitaService.getBy(idPrenotazione).
                orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/le-mie-prenotazioni/{nomeAttivitaPrenotata}")
    public SimplePrenotazioneAttivita getPrenotazioniBy(@PathVariable String nomeAttivitaPrenotata){
        return this.prenotazioneAttivitaService.filtraBy(nomeAttivitaPrenotata).stream().findFirst().
                orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public SimplePrenotazioneAttivita addPrenotazione(@RequestBody SimplePrenotazioneAttivita prenotazioneAttivita){
        var v = this.prenotazioneAttivitaService.save(prenotazioneAttivita);
        if (v==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return v;
    }

    @PutMapping
    public SimplePrenotazioneAttivita updatePrenotazione(@RequestBody SimplePrenotazioneAttivita prenotazioneAttivita){
        var v = this.prenotazioneAttivitaService.update(prenotazioneAttivita);
        if (v==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return v;
    }

    @DeleteMapping("/le-mie-prenotazioni/{idPrenotazione}")
    public SimplePrenotazioneAttivita deletePrenotazione(@PathVariable UUID idPrenotazione){
        return this.prenotazioneAttivitaService.removeBy(idPrenotazione).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}
