package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.service.RigaCatalogoOmbrelloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo/ombrelloni")
public class RigaCatalogoOmbrelloneController {

    @Autowired
    private RigaCatalogoOmbrelloneService rigaCatalogoOmbrelloneService;

    @GetMapping("/tutti")
    public List<SimpleRigaCatalogoOmbrellone> getRigheCatalogoOmbrellone(){
        return this.rigaCatalogoOmbrelloneService.getRighe();
    }

    @GetMapping("/disponibili")
    public List<SimpleRigaCatalogoOmbrellone> getOmbrelloniDisponibili(){
        return this.rigaCatalogoOmbrelloneService.getRighe();
    }

    @PostMapping("/aggiungi-nuovo")
    public SimpleRigaCatalogoOmbrellone addRigaCatalogoOmbrellone(@PathVariable SimpleRigaCatalogoOmbrellone rigaCatalogoOmbrellone){
        return this.rigaCatalogoOmbrelloneService.addRiga(rigaCatalogoOmbrellone);
    }

    @DeleteMapping("/elimina")
    public void removeOmbrellone(@RequestBody SimpleRigaCatalogoOmbrellone rigaCatalogoOmbrellone){
        this.rigaCatalogoOmbrelloneService.removeRiga(rigaCatalogoOmbrellone);
    }

    @PutMapping("/aggiorna")
    public boolean updateOmbrellone(@RequestBody SimpleRigaCatalogoOmbrellone rigaCatalogoOmbrellone){
        return this.rigaCatalogoOmbrelloneService.updateRiga(rigaCatalogoOmbrellone);
    }

}
