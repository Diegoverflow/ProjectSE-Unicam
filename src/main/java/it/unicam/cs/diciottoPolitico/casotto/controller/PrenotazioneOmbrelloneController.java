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
    @Autowired
    private RigaCatalogoOmbrelloneService rigaCatalogoOmbrelloneService;

    //todo ho messo path perche` non so come mettere il param sull'uri xd
    @GetMapping("/righe-disponibili/{data}/{fasciaOraria}")
    public List<SimpleRigaCatalogoOmbrellone> getOmbrelloniDisponibili(@PathVariable("data") @DateTimeFormat(pattern = "yyyy-MM-dd")Date data, @PathVariable FasciaOraria fasciaOraria){
        return this.prenotazioneOmbrelloneService.getRigheOmbrelloniDisponibili(data, fasciaOraria);
    }

    @GetMapping("/ombrelloni/all")
    public List<SimplePrenotazioneOmbrellone> getPrenotazioniOmbrellone(){
        return this.prenotazioneOmbrelloneService.getAll();
    }

    @GetMapping("/ombrelloni/{id}")
    public SimplePrenotazioneOmbrellone getPrenotazioneOmbrelloneById(@PathVariable UUID id) {
        return this.prenotazioneOmbrelloneService.getBy(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/ombrelloni")
    public SimplePrenotazioneOmbrellone addPrenotazioneOmbrellone(@RequestBody SimplePrenotazioneOmbrellone prenotazioneOmbrellone){
        if (this.prenotazioneOmbrelloneService.getBy(prenotazioneOmbrellone.getId()).isEmpty() && checkPrenotazione(prenotazioneOmbrellone))
            return this.prenotazioneOmbrelloneService.save(prenotazioneOmbrellone);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/ombrelloni")
    public SimplePrenotazioneOmbrellone updatePrenotazioneOmbrellone(@RequestBody SimplePrenotazioneOmbrellone prenotazioneOmbrellone){
        if (this.prenotazioneOmbrelloneService.getBy(prenotazioneOmbrellone.getId()).isPresent())
            return this.prenotazioneOmbrelloneService.save(prenotazioneOmbrellone);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/ombrelloni/{id}")
    public SimplePrenotazioneOmbrellone removePrenotazioneOmbrellone(@PathVariable UUID id){
        return this.prenotazioneOmbrelloneService.removeBy(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private boolean checkPrenotazione(SimplePrenotazioneOmbrellone prenotazioneOmbrellone){
        var r =this.rigaCatalogoOmbrelloneService.getRigaCatalogoOmbrelloneBy(prenotazioneOmbrellone.getOmbrellone());
        return r.filter(rigaCatalogoOmbrellone -> prenotazioneOmbrellone.getVendita().getCosto() == rigaCatalogoOmbrellone.getPrezzoOmbrellone()).isPresent();
    }

}