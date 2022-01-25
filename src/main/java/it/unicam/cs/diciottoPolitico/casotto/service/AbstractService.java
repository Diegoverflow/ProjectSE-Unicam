package it.unicam.cs.diciottoPolitico.casotto.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractService<T, R extends JpaRepository<T, UUID>> {

    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public Optional<T> getBy(UUID id){
        return this.repository.findById(id);
    }

    public T save(T t){
        return this.repository.save(t);
    }

    public Optional<T> removeBy(UUID id){
        Optional<T> o = this.repository.findById(id);
        o.ifPresent(this.repository::delete);
        return o;
    }

    public List<T> getBy(Predicate<T> predicate){
        return this.getAll().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    //todo
    /*public Optional<T> getBy(Predicate<T> predicate){
        return this.getBy(predicate).
    }*/

}
