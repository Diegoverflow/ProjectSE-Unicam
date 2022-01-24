package it.unicam.cs.diciottoPolitico.casotto.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class RigheCataloghiService<C, R extends JpaRepository<C, UUID>> {

    private final R repository;

    public RigheCataloghiService(R repository) {
        this.repository = repository;
    }

    public List<C> getRighe() {
        return repository.findAll();
    }

    public Optional<C> getRiga(UUID id){
        return this.repository.findById(id);
    }

    public C saveRiga(C rigaCatalogo){
        return this.repository.save(rigaCatalogo);
    }

    public void removeRiga(UUID id){
        this.repository.delete(this.repository.getById(id));
    }

}
