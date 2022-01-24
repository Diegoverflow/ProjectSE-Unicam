package it.unicam.cs.diciottoPolitico.casotto.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class AbstractService<C, R extends JpaRepository<C, UUID>> {

    protected final R repository;

    public AbstractService(R repository) {
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

    public Optional<C> removeRiga(UUID id){
        Optional<C> o = this.repository.findById(id);
        o.ifPresent(this.repository::delete);
        return o;
    }

}
