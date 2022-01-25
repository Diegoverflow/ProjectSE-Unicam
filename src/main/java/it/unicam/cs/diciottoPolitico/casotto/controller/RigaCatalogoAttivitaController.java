package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.service.RigaCatalogoAttivitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/catalogo")
public class RigaCatalogoAttivitaController {

    @Autowired
    private final RigaCatalogoAttivitaService rigaCatalogoAttivitaService;

    public RigaCatalogoAttivitaController(RigaCatalogoAttivitaService rigaCatalogoAttivitaService) {
        this.rigaCatalogoAttivitaService = rigaCatalogoAttivitaService;
    }

    @GetMapping("/attivita")
    public List<SimpleRigaCatalogoAttivita> getRigheCatalogoAttivita(){
        return this.rigaCatalogoAttivitaService.getAll();
    }

    @GetMapping("/attivita/{idRiga}")
    public SimpleRigaCatalogoAttivita getRiga(@PathVariable UUID idRiga){
        Optional<SimpleRigaCatalogoAttivita> riga = this.rigaCatalogoAttivitaService.getBy(idRiga);
        if (riga.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else
            return riga.get();
    }



}
