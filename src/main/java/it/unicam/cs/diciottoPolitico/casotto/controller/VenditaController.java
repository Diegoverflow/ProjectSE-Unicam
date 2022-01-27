package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleVendita;
import it.unicam.cs.diciottoPolitico.casotto.service.VenditaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vendite")
public class VenditaController {

    @Autowired
    private VenditaService venditaService;

    @GetMapping("/all")
    public List<SimpleVendita> getAllVendite(){
        return this.venditaService.getAll();
    }

    @GetMapping("/{id}")
    public SimpleVendita getVenditaBy(@PathVariable UUID id) {
        return this.venditaService.getBy(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}/{isPagato}")
    public SimpleVendita updatePartially(@PathVariable UUID id, @PathVariable boolean isPagato){
        var v =this.venditaService.getBy(id);
        if (v.isPresent()){
            v.get().setPagata(isPagato);
            this.venditaService.save(v.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
