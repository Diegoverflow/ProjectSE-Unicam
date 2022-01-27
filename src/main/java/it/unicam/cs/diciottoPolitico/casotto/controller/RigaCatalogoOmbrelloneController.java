package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.service.RigaCatalogoOmbrelloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/catalogo")
public class RigaCatalogoOmbrelloneController {

    @Autowired
    private RigaCatalogoOmbrelloneService service;

    @GetMapping("/ombrelloni/all")
    public List<SimpleRigaCatalogoOmbrellone> getRigheCatalogoOmbrellone(){
        return this.service.getAll();
    }

    @GetMapping("/ombrelloni/{id}")
    public SimpleRigaCatalogoOmbrellone getRigaCatalogoOmbrelloneById(@PathVariable UUID id) {
        return this.service.getBy(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/ombrelloni")
    public SimpleRigaCatalogoOmbrellone addRigaCatalogoOmbrellone(@RequestBody SimpleRigaCatalogoOmbrellone riga){
        var r = this.service.save(riga);
        if (r != null)
            return r;
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/ombrelloni")
    public SimpleRigaCatalogoOmbrellone updateRigaCatalogoOmbrellone(@RequestBody SimpleRigaCatalogoOmbrellone riga){
        var r = this.service.save(riga);
        if (r != null)
            return r;
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/ombrelloni/{id}")
    public SimpleRigaCatalogoOmbrellone removeRigaCatalogoOmbrellone(@PathVariable UUID id){
        return this.service.removeBy(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}