package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RigaCatalogoBarService {

    private final RigaCatalogoBarRepository repository;

    @Autowired
    public RigaCatalogoBarService(RigaCatalogoBarRepository repository) {
        this.repository = repository;
    }

    public List<RigaCatalogoBar> getRighe() {
        return repository.findAll();
    }

    public RigaCatalogoBar addRiga(RigaCatalogoBar rigaCatalogoBar){
        return this.repository.save(rigaCatalogoBar);
    }

    public void removeRiga(RigaCatalogoBar rigaCatalogoBar){
        this.repository.delete(rigaCatalogoBar);
    }

    public boolean updateRiga (RigaCatalogoBar rigaCatalogoBar){
        if (this.repository.findById(rigaCatalogoBar.getId()).isPresent()){
            this.repository.save(rigaCatalogoBar);
            return true;
        }
        return false;
    }
}
