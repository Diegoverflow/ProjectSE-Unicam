package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RigaCatalogoBarService {

    private final RigaCatalogoBarRepository repository;

    @Autowired
    public RigaCatalogoBarService(RigaCatalogoBarRepository repository) {
        this.repository = repository;
    }

    public List<SimpleRigaCatalogoBar> getRighe() {
        return repository.findAll();
    }

    public SimpleRigaCatalogoBar getRiga(UUID id){
        return null;
    }

    public SimpleRigaCatalogoBar addRiga(SimpleRigaCatalogoBar rigaCatalogoBar){
        return this.repository.save(rigaCatalogoBar);
    }

    public void removeRiga(UUID idArticoloBar){
        this.repository.delete(this.repository.getById(idArticoloBar));
    }

}
