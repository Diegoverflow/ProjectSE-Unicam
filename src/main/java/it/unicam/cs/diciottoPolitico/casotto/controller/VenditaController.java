package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleVendita;
import it.unicam.cs.diciottoPolitico.casotto.repository.VenditaRepository;
import it.unicam.cs.diciottoPolitico.casotto.service.VenditaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

/**
 * RestController delle vendite degli acquisti effettuati dai clienti dello chalet.
 * Esso si occupa di gestire le richieste HTTP per aggiungere, modificare, rimuovere e leggere una {@link SimpleVendita}.
 * Questo RestController avr&agrave; un' istanza di {@link VenditaService} che si occuper&agrave; di eseguire operazioni
 * CRUD interagendo con il relativo {@link VenditaRepository}.
 *
 * @see SimpleVendita
 * @see VenditaService
 */
@RestController
@RequestMapping("/vendite")
public class VenditaController {

    @Autowired
    private VenditaService venditaService;

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce la lista di tutte le vendite degli acquisti effettuati dai clienti dello chalet.
     *
     * @return la lista di tutte le vendite degli acquisti effettuati dai clienti dello chalet
     */
    @GetMapping("/all")
    public List<SimpleVendita> getAllVendite() {
        return this.venditaService.getAll();
    }

    /**
     * Gestisce una richiesta HTTP con metodo {@link RequestMethod#GET}.
     * Restituisce una {@link SimpleVendita} avente id specificato nel {@link PathVariable}.
     *
     * @param id l' id di cui ricavare la vendita
     * @return la vendita avente id specificato
     * @throws ResponseStatusException con {@link HttpStatus#NOT_FOUND} se non viene trovata nessuna {@code SimpleVendita} con id specificato
     */
    @GetMapping("/{id}")
    public SimpleVendita getVenditaBy(@PathVariable UUID id) {
        return this.venditaService.getBy(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // TODO: javadoc
    @PatchMapping("/{id}/{isPagato}")
    public SimpleVendita updatePartially(@PathVariable UUID id, @PathVariable boolean isPagato) {
        var v = this.venditaService.getBy(id);
        if (v.isPresent()) {
            v.get().setPagata(isPagato);
            this.venditaService.save(v.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
