package it.unicam.cs.diciottoPolitico.casotto.service;

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

    public List<SimpleRigaCatologoAttivita> getRighe() {
        return repository.findAll();
    }

    public SimpleRigaCatologoAttivita addRiga(SimpleRigaCatologoAttivita rigaCatologoAttivita){
        return this.repository.save(rigaCatologoAttivita);
    }

    public void removeRiga(SimpleRigaCatologoAttivita rigaCatologoAttivita){
        this.repository.delete(rigaCatologoAttivita);
    }

    public boolean updateRiga (SimpleRigaCatologoAttivita rigaCatologoAttivitaAggiornata){
        if (this.repository.findById(rigaCatologoAttivitaAggiornata.getId()).isPresent()){
            this.repository.save(rigaCatologoAttivitaAggiornata);
            return true;
        }
        return false;
    }

}