package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatologoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoAttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RigaCatalogoAttivitaService {

    private final RigaCatalogoAttivitaRepository repository;

    @Autowired
    public RigaCatalogoAttivitaService(RigaCatalogoAttivitaRepository repository) {
        this.repository = repository;
    }

    public List<SimpleRigaCatologoAttivita> getRighe() {
        return repository.findAll();
    }

    public SimpleRigaCatologoAttivita addRiga(SimpleRigaCatologoAttivita rigaCatologoAttivita){
        return this.repository.save(rigaCatologoAttivita);
    }

    public void removeRiga(SimpleRigaCatologoAttivita rigaCatologoAttivita){
        this.repository.delete(rigaCatologoAttivita);
    }

    public boolean updateRiga (double prezzo, SimpleRigaCatologoAttivita rigaCatologoAttivita){
        if (this.repository.findById(rigaCatologoAttivita.getId()).isPresent()){
            rigaCatologoAttivita.setPrezzo(prezzo);
            this.repository.save(rigaCatologoAttivita);
            return true;
        }
        return false;
    }

    public boolean updateRiga (SimpleRigaCatologoAttivita rigaCatologoAttivita){
        rigaCatologoAttivita.getValore().
        return false;
    }
}
