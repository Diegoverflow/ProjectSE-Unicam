package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.AreaInfrastruttura;
import it.unicam.cs.diciottoPolitico.casotto.service.InfrastrutturaService;
import it.unicam.cs.diciottoPolitico.casotto.repository.InfrastrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * RestController dell' infrastruttura dello chalet.
 * Esso si occupa di gestire le richieste HTTP per aggiungere, modificare, rimuovere e leggere un' {@link AreaInfrastruttura}.
 * Questo RestController avr&agrave; un' istanza di {@link InfrastrutturaService} che si occuper&agrave; di eseguire operazioni
 * CRUD interagendo con il relativo {@link InfrastrutturaRepository}.
 *
 * @see AreaInfrastruttura
 * @see InfrastrutturaService
 */
@RestController
@RequestMapping("/infrastruttura/aree")
public class InfrastrutturaController {

    @Autowired
    private InfrastrutturaService infrastrutturaService;

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le aree dell' infrastruttura presenti nello chalet.
     *
     * @return la lista di tutte le aree presenti nello chalet
     */
    @GetMapping("/all")
    public List<AreaInfrastruttura> getAllAree() {
        return this.infrastrutturaService.getAll();
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce un' {@link AreaInfrastruttura} avente id specificato.
     *
     * @param id l' id di cui ricavare l' area
     * @return l' area avente id specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessun' {@code AreaInfrastruttura} con id specificato
     */
    @GetMapping("/{id}")
    public AreaInfrastruttura getAreaBy(@PathVariable UUID id) {
        Optional<AreaInfrastruttura> foundArea = this.infrastrutturaService.getBy(id);
        return this.getAreaOrThrownException(foundArea);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce un' {@link AreaInfrastruttura} avente il nome specificato nel {@link RequestParam}.
     *
     * @param nome il nome di cui ricavare l' area
     * @return l' area avente il nome specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessun' {@code AreaInfrastruttura} con il nome specificato
     */
    @GetMapping(params = "nome")
    public AreaInfrastruttura getAreaBy(@RequestParam String nome) {
        Optional<AreaInfrastruttura> foundArea = this.infrastrutturaService.getAreaBy(nome);
        return this.getAreaOrThrownException(foundArea);
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#POST}.
     * Aggiunge l' {@link AreaInfrastruttura} contenuta nel {@link RequestBody} della richiesta HTTP all' infrastruttura dello chalet.
     * Restituisce l' {@code AreaInfrastruttura} aggiunta all' infrastruttura dello chalet.
     *
     * @param areaInfrastruttura l' area da aggiungere all' infrastruttura dello chalet
     * @return l' {@code AreaInfrastruttura} aggiunta all' infrastruttura dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#BAD_REQUEST} se si tenta di aggiungere
     *                                 un' {@code AreaInfrastruttura} gi&agrave; presente nell' infrastruttura dello chalet
     */
    @PostMapping
    public AreaInfrastruttura addArea(@RequestBody AreaInfrastruttura areaInfrastruttura) {
        Optional<AreaInfrastruttura> foundArea = this.infrastrutturaService.checkAndSave(areaInfrastruttura);
        if (foundArea.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return areaInfrastruttura;
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#PUT}.
     * Aggiorna l' {@link AreaInfrastruttura} specificata contenuta nel {@link RequestBody}.
     * Restituisce l' {@code AreaInfrastruttura} aggiornata nell' infrastruttura dello chalet.
     *
     * @param areaInfrastruttura l' {@code AreaInfrastruttura} da aggiornare
     * @return l' {@code AreaInfrastruttura} aggiornata nell' infrastruttura dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se l' {@code AreaInfrastruttura} non viene trovata
     */
    @PutMapping
    public AreaInfrastruttura updateArea(@RequestBody AreaInfrastruttura areaInfrastruttura) {
        Optional<AreaInfrastruttura> foundArea = this.infrastrutturaService.checkAndUpdate(areaInfrastruttura);
        if (foundArea.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return foundArea.get();
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#DELETE}.
     * Rimuove dall' infrastruttura dello chalet, l' {@link AreaInfrastruttura} avente l' id specificato come {@link PathVariable}.
     * Restituisce l' {@code AreaInfrastruttura} rimossa dall' infrastruttura dello chalet.
     *
     * @param id l' id dell' {@code AreaInfrastruttura} da eliminare
     * @return l' {@code AreaInfrastruttura} rimossa dall' infrastruttura dello chalet
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se si specifica un id inesistente
     */
    @DeleteMapping("/{id}")
    public AreaInfrastruttura removeArea(@PathVariable UUID id) {
        Optional<AreaInfrastruttura> foundArea = this.infrastrutturaService.removeBy(id);
        return this.getAreaOrThrownException(foundArea);
    }

    private AreaInfrastruttura getAreaOrThrownException(Optional<AreaInfrastruttura> area) {
        if (area.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return area.get();
    }

}
