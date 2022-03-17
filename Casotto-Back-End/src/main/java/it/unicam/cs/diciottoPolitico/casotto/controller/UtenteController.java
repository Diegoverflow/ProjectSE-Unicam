package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.model.RuoloUtente;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleNotifica;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleUtente;
import it.unicam.cs.diciottoPolitico.casotto.repository.UtenteRepository;
import it.unicam.cs.diciottoPolitico.casotto.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * RestController degli utenti che vogliono usufruire dei servizi dello chalet.
 * Esso si occupa di gestire le richieste HTTP per aggiungere, modificare, rimuovere e leggere un {@link SimpleUtente}.
 * Questo RestController avr&agrave; un' istanza di {@link UtenteService} che si occuper&agrave; di eseguire operazioni
 * CRUD interagendo con il relativo {@link UtenteRepository}.
 *
 * @see SimpleUtente
 * @see UtenteService
 */
@RestController
@RequestMapping("/utenti")
public class UtenteController{

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutti gli utenti registrati nello chalet.
     *
     * @return la lista di tutti gli utenti registrati nello chalet
     */
    @GetMapping("/all")
    public List<SimpleUtente> getAllUtenti() {
        return this.utenteService.getAll();
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce una {@link SimpleUtente} avente id specificato nel {@link PathVariable}.
     *
     * @return l' utente avente id specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovato nessun {@code SimpleUtente} con id specificato
     */
    @GetMapping("utente")
    public ResponseEntity<SimpleUtente> getUtentiById() {
        var utente = this.utenteService.getLoggedUser();
        return ResponseEntity.ok(utente);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#POST}.
     * Aggiunge il {@link SimpleUtente} contenuto nel {@link RequestBody} della richiesta HTTP allo chalet.
     * Restituisce il {@code SimpleUtente} aggiunto.
     *
     * @param utente il {@code SimpleUtente} da aggiungere allo chalet
     * @return il {@code SimpleUtente} aggiunto
     * @throws ResponseStatusException con {@link HttpStatus#BAD_REQUEST} se si tenta di aggiungere
     *                                 un {@code SimpleUtente} gi&agrave; presente nello chalet oppure un {@code SimpleUtente} non valido
     */
    @PostMapping
    public SimpleUtente addUtente(@Valid @RequestBody SimpleUtente utente){
        var u = this.utenteService.getBy(utente.getId());
        utente.setPassword(bCryptPasswordEncoder.encode(utente.getPassword()));
        utente.setRuoloUtente(RuoloUtente.CLIENTE);
        if (u.isEmpty())
            return this.utenteService.save(utente);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#PUT}.
     * Aggiorna il {@link SimpleUtente} specificato contenuto nel {@link RequestBody}.
     * Restituisce il {@code SimpleUtente} aggiornato nello chalet.
     *
     * @param utente il {@code SimpleUtente} da aggiornare
     * @return il {@code SimpleUtente} aggiornato nello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se il {@code SimpleUtente} non viene trovato
     */
    @PatchMapping
    public SimpleUtente updateUtente(@RequestBody SimpleUtente utente) {
        var u = this.utenteService.getBy(utente.getId());
        if (u.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return this.utenteService.save(utente);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#DELETE}.
     * Rimuove dallo chalet, il {@link SimpleUtente} avente l' id specificato nel {@link PathVariable}.
     * Restituisce il {@code SimpleUtente} rimosso dallo chalet.
     *
     * @param id l' id del {@code SimpleUtente} da eliminare
     * @return il {@code SimpleUtente} rimosso dallo chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se si specifica un id inesistente
     */
    @DeleteMapping("/{id}")
    public SimpleUtente removeUtente(@PathVariable UUID id) {
        return this.utenteService.removeBy(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/ruolo")
    public RuoloUtente getRuoloUtente(){
        var email = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var utente = this.utenteService.getBy(email);
        return utente.getRuoloUtente();
    }

    @GetMapping("/notifiche")
    public List<SimpleNotifica> getNotificheByLoggedUser(){
        return this.utenteService.getAllNotificheLoggedUser();
    }

}
