package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.service.RigaCatalogoAttivitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/catalogo-attivita")
public class RigaCatalogoAttivitaController {

    @Autowired
    private final RigaCatalogoAttivitaService rigaCatalogoAttivitaService;

    public RigaCatalogoAttivitaController(RigaCatalogoAttivitaService rigaCatalogoAttivitaService) {
        this.rigaCatalogoAttivitaService = rigaCatalogoAttivitaService;
    }

    @GetMapping("/all")
    public List<SimpleRigaCatalogoAttivita> getRigheCatalogoAttivita(){
        return this.rigaCatalogoAttivitaService.getAll();
    }

    @GetMapping("/attivita-{idRiga}")
    public SimpleRigaCatalogoAttivita getRigaBy(@PathVariable UUID idRiga) {
        return this.rigaCatalogoAttivitaService.getBy(idRiga).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public SimpleRigaCatalogoAttivita addRiga(@RequestBody SimpleRigaCatalogoAttivita rigaCatalogo){
        var riga = this.rigaCatalogoAttivitaService.getBy(rigaCatalogo.getId());
        var attivita = this.rigaCatalogoAttivitaService.getRigaBy(rigaCatalogo.getValore().getNome());
        if (riga.isPresent() || attivita.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return this.rigaCatalogoAttivitaService.save(rigaCatalogo);
    }

    @PutMapping
    public SimpleRigaCatalogoAttivita updateRiga(@RequestBody SimpleRigaCatalogoAttivita rigaCatalogoAttivita){
        var riga = this.rigaCatalogoAttivitaService.getBy(rigaCatalogoAttivita.getId());
        if (riga.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return this.rigaCatalogoAttivitaService.save(rigaCatalogoAttivita);
    }

    @DeleteMapping("/attivita-{idRiga}")
    public SimpleRigaCatalogoAttivita deleteRigaBy(@PathVariable UUID idRiga){
        return this.rigaCatalogoAttivitaService.removeBy(idRiga).
                orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
