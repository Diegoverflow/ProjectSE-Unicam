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
@RequestMapping("/catalogo")
public class RigaCatalogoAttivitaController {

    @Autowired
    private final RigaCatalogoAttivitaService rigaCatalogoAttivitaService;

    public RigaCatalogoAttivitaController(RigaCatalogoAttivitaService rigaCatalogoAttivitaService) {
        this.rigaCatalogoAttivitaService = rigaCatalogoAttivitaService;
    }

    @GetMapping("/attivita/all")
    public List<SimpleRigaCatalogoAttivita> getRigheCatalogoAttivita(){
        return this.rigaCatalogoAttivitaService.getAll();
    }

    @GetMapping("/attivita/{idRiga}")
    public SimpleRigaCatalogoAttivita getRigaBy(@PathVariable UUID idRiga) {
        return this.rigaCatalogoAttivitaService.getBy(idRiga).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
