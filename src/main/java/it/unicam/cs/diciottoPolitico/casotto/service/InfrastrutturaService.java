package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.AreaInfrastruttura;
import it.unicam.cs.diciottoPolitico.casotto.repository.InfrastrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service dell' infrastruttura dello chalet.
 * Esso si occupa di gestire le operazioni CRUD riguardanti l' {@link AreaInfrastruttura} interagendo con il relativo
 * {@link InfrastrutturaRepository}.
 *
 * @see AreaInfrastruttura
 * @see InfrastrutturaRepository
 */
@Service
public class InfrastrutturaService extends AbstractService<AreaInfrastruttura, InfrastrutturaRepository> {

    @Autowired
    public InfrastrutturaService(InfrastrutturaRepository repository) {
        super(repository);
    }

    /**
     * Restituisce un {@link Optional} che descrive un' {@link AreaInfrastruttura} avente il nome specificato
     * oppure un empty {@code Optional} se non viene trovata nessun' area con il nome specificato nel database.
     *
     * @param nome il nome di cui ricavare l' area
     * @return un {@code Optional} che descrive un' {@code AreaInfrastruttura} avente il nome specificato
     * oppure un empty {@code Optional} se non viene trovata nessun' area con il nome specificato
     */
    public Optional<AreaInfrastruttura> getAreaByName(String nome) {
        // TODO: completare
        /*return this.infrastrutturaRepository.findAll()
                .stream()
                .filter(a -> a.getNome().equals(nome))
                .findFirst();*/
        return Optional.empty();
    }

}
