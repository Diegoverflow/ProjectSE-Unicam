package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.service.RigaCatalogoOmbrelloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/catalogo")
public class RigaCatalogoOmbrelloneController {

    @Autowired
    private RigaCatalogoOmbrelloneService rigaCatalogoOmbrelloneService;

    @GetMapping("/ombrelloni")
    public List<SimpleRigaCatalogoOmbrellone> getRigheCatalogoOmbrellone(){
        List<SimpleRigaCatalogoOmbrellone> o = this.rigaCatalogoOmbrelloneService.getAll();
        if (o.size()==0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return o;
    }
/*
    @GetMapping("/ombrelloni/disponibili")
    public List<SimpleRigaCatalogoOmbrellone> getOmbrelloniDisponibili(@RequestParam Date data, @RequestParam FasciaOraria fasciaOraria){
        List<SimpleRigaCatalogoOmbrellone> o = this.rigaCatalogoOmbrelloneService.getOmbrelloniDisponibili(data,fasciaOraria);
        if (o.size()==0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return o;
    }

    @PostMapping("/ombrelloni")
    public SimpleRigaCatalogoOmbrellone addRigaCatalogoOmbrellone(@RequestBody SimpleRigaCatalogoOmbrellone rigaCatalogoOmbrellone){
        SimpleRigaCatalogoOmbrellone r = this.rigaCatalogoOmbrelloneService.addRiga(rigaCatalogoOmbrellone);

    }

    @DeleteMapping("/ombrelloni")
    public void removeOmbrellone(@PathVariable UUID id){
        this.rigaCatalogoOmbrelloneService.removeBy(id);
    }

    @PutMapping("/ombrelloni")
    public boolean updateOmbrellone(@RequestBody SimpleRigaCatalogoOmbrellone rigaCatalogoOmbrellone){
        return this.rigaCatalogoOmbrelloneService.updateRiga(rigaCatalogoOmbrellone);
    }*/

}
