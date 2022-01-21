package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatologoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoAttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RigaCatalogoAttivitaService {

    private final RigaCatalogoAttivitaRepository repository;

    @Autowired
    public RigaCatalogoAttivitaService(RigaCatalogoAttivitaRepository repository) {
        this.repository = repository;
    }

    public List<RigaCatalogoAttivita> getRighe() {
        return repository.findAll();
    }

    public RigaCatalogoAttivita addRiga(RigaCatalogoAttivita rigaCatologoAttivita){
        return this.repository.save(rigaCatologoAttivita);
    }

    public void removeRiga(RigaCatalogoAttivita rigaCatologoAttivita){
        this.repository.delete(rigaCatologoAttivita);
    }

    public boolean updateRiga (RigaCatalogoAttivita rigaCatologoAttivitaAggiornata){
        if (this.repository.findById(rigaCatologoAttivitaAggiornata.getId()).isPresent()){
            this.repository.save(rigaCatologoAttivitaAggiornata);
            return true;
        }
        return false;
    }

}
