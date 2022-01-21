package it.unicam.cs.diciottoPolitico.casotto.service;


import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoOmbrelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RigaCatalogoOmbrelloneService {
    private final RigaCatalogoOmbrelloneRepository rigaCatalogoOmbrelloneRepository;

    @Autowired
    public RigaCatalogoOmbrelloneService(RigaCatalogoOmbrelloneRepository rigaCatalogoOmbrelloneRepository){
        this.rigaCatalogoOmbrelloneRepository = rigaCatalogoOmbrelloneRepository;
    }

    public List<RigaCatalogoOmbrellone> getRighe() {
        return rigaCatalogoOmbrelloneRepository.findAll();
    }

    public List<RigaCatalogoOmbrellone> getOmbrelloniDisponibili(GregorianCalendar data, FasciaOraria fasciaOraria) {
        return this.getRighe().stream()
                .filter(r->r.getPrenotazioni().stream().noneMatch(p->p.getDataPrenotazione().equals(data) && p.getFasciaOraria().equals(fasciaOraria)))
                .collect(Collectors.toList());
    }

    public RigaCatalogoOmbrellone addRiga(RigaCatalogoOmbrellone rigaCatalogoOmbrellone){
        return this.rigaCatalogoOmbrelloneRepository.save(rigaCatalogoOmbrellone);
    }

    public void removeRiga(RigaCatalogoOmbrellone rigaCatalogoOmbrellone){
        this.rigaCatalogoOmbrelloneRepository.delete(rigaCatalogoOmbrellone);
    }

    public boolean updateRiga (RigaCatalogoOmbrellone rigaCatalogoOmbrelloneAggiornata){
        if (this.rigaCatalogoOmbrelloneRepository.findById(rigaCatalogoOmbrelloneAggiornata.getId()).isPresent()){
            this.rigaCatalogoOmbrelloneRepository.save(rigaCatalogoOmbrelloneAggiornata);
            return true;
        }
        return false;
    }
}
