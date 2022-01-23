package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.service.RigaCatalogoOmbrelloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catolo/ombrelloni")
public class RigaCatalogoOmbrelloneController {

    @Autowired
    private RigaCatalogoOmbrelloneService rigaCatalogoOmbrelloneService;

    @PostMapping("/riga-catalogo-ombrellone")
    public SimpleRigaCatalogoOmbrellone addRigaCatalogoOmbrellone(@RequestBody SimpleRigaCatalogoOmbrellone rigaCatalogoOmbrellone){
        return this.rigaCatalogoOmbrelloneService.addRiga(rigaCatalogoOmbrellone);
    }

    @GetMapping("/riga-catalogo-ombrellone")
    public List<SimpleRigaCatalogoOmbrellone> getRigheCatalogoOmbrellone(){
        return this.rigaCatalogoOmbrelloneService.getRighe();
    }


}
