package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleUtente;
import it.unicam.cs.diciottoPolitico.casotto.service.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class UtenteController {

    @Autowired
    private UtentiService utentiService;

    @GetMapping("/utenti")
    public List<SimpleUtente> getAllUtenti(){
        return this.utentiService.getAll();
    }

    @GetMapping("/utenti/{id}")
    public SimpleUtente getUtentiById(@PathVariable UUID id) {
        return this.utentiService.getBy(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/utenti")
    public SimpleUtente addUtente(@RequestBody SimpleUtente utente){
        var u = this.utentiService.getBy(utente.getId());
        if (u.isEmpty())
            return this.utentiService.save(utente);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/utenti")
    public SimpleUtente updateUtente(@RequestBody SimpleUtente utente){
        var u = this.utentiService.getBy(utente.getId());
        if (u.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return this.utentiService.save(utente);
    }

    @DeleteMapping("/utenti/{id}")
    public SimpleUtente removeUtente(@PathVariable UUID id){
        return this.utentiService.removeBy(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}
