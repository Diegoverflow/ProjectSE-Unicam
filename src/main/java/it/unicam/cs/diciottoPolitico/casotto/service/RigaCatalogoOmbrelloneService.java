package it.unicam.cs.diciottoPolitico.casotto.service;


import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoOmbrelloneRepository;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RigaCatalogoOmbrelloneService {

    @Autowired
    private RigaCatalogoOmbrelloneRepository rigaCatalogoOmbrelloneRepository;

    public List<SimpleRigaCatalogoOmbrellone> getRighe() {
        return rigaCatalogoOmbrelloneRepository.findAll();
    }

    public List<SimpleRigaCatalogoOmbrellone> getOmbrelloniDisponibili(Date data, FasciaOraria fasciaOraria) {
        return this.getRighe().stream()
                .filter(r->r.getPrenotazioni().stream().noneMatch(p->p.getDataPrenotazione().equals(data) && p.getFasciaOraria().equals(fasciaOraria)))
                .collect(Collectors.toList());
    }

    public SimpleRigaCatalogoOmbrellone addRiga(SimpleRigaCatalogoOmbrellone rigaCatalogoOmbrellone){
        return this.rigaCatalogoOmbrelloneRepository.save(rigaCatalogoOmbrellone);
    }

    public void removeRiga(SimpleRigaCatalogoOmbrellone rigaCatalogoOmbrellone){
        this.rigaCatalogoOmbrelloneRepository.delete(rigaCatalogoOmbrellone);
    }

    public boolean updateRiga (SimpleRigaCatalogoOmbrellone rigaCatalogoOmbrelloneAggiornata){
        if (this.rigaCatalogoOmbrelloneRepository.findById(rigaCatalogoOmbrelloneAggiornata.getId()).isPresent()){
            this.rigaCatalogoOmbrelloneRepository.save(rigaCatalogoOmbrelloneAggiornata);
            return true;
        }
        return false;
    }
}
