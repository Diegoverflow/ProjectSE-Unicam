package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.OrdinazioneBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Service delle ordinazioni bar.
 * Esso si occupa di gestire le operazioni CRUD riguardanti la {@link SimpleOrdinazioneBar} interagendo con il relativo
 * {@link OrdinazioneBarRepository}.
 *
 * @see SimpleOrdinazioneBar
 * @see OrdinazioneBarRepository
 */
@Service
public class OrdinazioneBarService extends AbstractService<SimpleOrdinazioneBar, OrdinazioneBarRepository> {

    @Autowired
    public OrdinazioneBarService(OrdinazioneBarRepository repository) {
        super(repository);
    }

    /**
     * Restituisce un {@link Optional} che descrive una {@link SimpleOrdinazioneBar} avente id specificato
     * oppure un empty {@code Optional} se non viene trovata nessuna ordinazione con id specificato nel database.
     *
     * @param id l' id di cui ricavare la {@code SimpleOrdinazioneBar}
     * @return un {@code Optional} che descrive una {@code SimpleOrdinazioneBar} avente id specificato
     * oppure un empty {@code Optional} se non viene trovata nessuna ordinazione con id specificato
     */
    public Optional<SimpleOrdinazioneBar> getOrdinazioneBy(UUID id) {
        return super.repository.findAll()
                .stream()
                .filter(o -> o.getId().equals(id))
                .findFirst();
    }

}
