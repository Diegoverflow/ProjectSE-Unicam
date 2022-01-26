package it.unicam.cs.diciottoPolitico.casotto.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Classe che fornisce uno scheletro per l' implementazione del Service che estende questa classe.
 *
 * @param <T> il tipo parametrico per l' entit&agrave; del repository da gestire
 * @param <R> il tipo parametrico per l' id dell' entit&agrave; del repository da gestire
 */
public abstract class AbstractService<T, R extends JpaRepository<T, UUID>> {

    protected final R repository;

    /**
     * Inizializza il repository di questo service astratto con quello specificato.
     *
     * @param repository il repository che sar&agrave; assegnato al repository di questo service astratto
     */
    public AbstractService(R repository) {
        this.repository = repository;
    }

    /**
     * Restituisce la lista di tutte le entit&agrave; contenute nel repository di questo service.
     *
     * @return la lista di tutte le entit&agrave;
     */
    public List<T> getAll() {
        return repository.findAll();
    }

    /**
     * Cerca all' interno del repository di questo service e estituisce un {@link Optional} che descrive un entit&agrave; avente id specificato.
     *
     * @param id l' id di cui ricavare l' entit&agrave;
     * @return un {@code Optional} che descrive un' entit&agrave; avente id specificato
     * oppure un empty {@code Optional} se non viene trovata nessun' entit&agrave; con id specificato all' interno del repository di questo service
     */
    public Optional<T> getBy(UUID id) {
        return this.repository.findById(id);
    }

    /**
     * Salva l' entit&agrave; specificata all' interno del repository di questo service.
     *
     * @param t l' entit&agrave; da salvare all' interno del repository
     * @return l' entit&agrave; salvata all' interno del repository
     */
    public T save(T t) {
        return this.repository.save(t);
    }

    /**
     * Rimuove dal repository l' entit&agrave; avente id specificato.
     * Restituisce un {@link Optional} che descrive l' entit&agrave; rimossa oppure un empty {@code Optional} se non viene trovata nessun' entit&agrave;
     * con id specificato all' interno del repository di questo service
     *
     * @param id l' id di cui ricavare l' entit&agrave; da rimuovere dal repository
     * @return un {@code Optional} che descrive l' entit&agrave; rimossa oppure un empty {@code Optional} se non viene trovata nessun' entit&agrave;
     * con id specificato all' interno del repository di questo service
     */
    public Optional<T> removeBy(UUID id) {
        Optional<T> o = this.repository.findById(id);
        o.ifPresent(this.repository::delete);
        return o;
    }

    /**
     * Restituisce la lista delle entit&agrave; del repository di questo service che soddisfano il predicato specificato.
     *
     * @param predicate il predicato da applicare ad ogni entit&agrave; per verificarne la soddisfazione
     * @return la lista delle entit&agrave; che soddisfano il predicato specificato
     */
    public List<T> getBy(Predicate<T> predicate) {
        return this.getAll().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

}
