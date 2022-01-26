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
    public Optional<AreaInfrastruttura> getAreaBy(String nome) {
        return super.getBy(a -> a.getNome().equals(nome)).stream().findFirst();
    }

    /**
     * Esegue un controllo seulla presenza dell' {@link AreaInfrastruttura} specificata in base al proprio id e il proprio nome.
     * Restituisce un empty {@link Optional} se non viene trovata nessun' area con id e nome dell' area specificata nel database, altrimenti memorizza l' area
     * specificata nel database e restituisce un {@code Optional} che descrive l' {@code AreaInfrastruttura} memorizzata.
     *
     * @param areaInfrastruttura l' area di cui eseguire il controllo e memorizzarla nel database
     * @return un empty {@code Optional} se non viene trovata nessun' area con id e nome specificati nel database, altrimenti memorizza l' area
     * specificata nel database e restituisce un {@code Optional} che descrive l' {@code AreaInfrastruttura} memorizzata.
     */
    public Optional<AreaInfrastruttura> checkAndSave(AreaInfrastruttura areaInfrastruttura) {
        if (super.getBy(areaInfrastruttura.getId()).isEmpty() && this.getAreaBy(areaInfrastruttura.getNome()).isEmpty())
            return Optional.of(super.save(areaInfrastruttura));
        return Optional.empty();
    }

    /**
     * Esegue un controllo sulla presenza dell' {@link AreaInfrastruttura} specificata in base al proprio id.
     * Restituisce un empty {@link Optional} se non viene trovata nessun' area con id dell' area specificata nel database, altrimenti aggiorna l' area
     * specificata nel database e restituisce un {@code Optional} che descrive l' {@code AreaInfrastruttura} aggiornata.
     *
     * @param areaInfrastruttura l' area di cui eseguire il controllo e aggiornarla nel database
     * @return un empty {@code Optional} se non viene trovata nessun' area con id dell' area specificata nel database, altrimenti aggiorna l' area
     * specificata nel database e restituisce un {@code Optional} che descrive l' {@code AreaInfrastruttura} aggiornata.
     */
    public Optional<AreaInfrastruttura> checkAndUpdate(AreaInfrastruttura areaInfrastruttura) {
        if (super.getBy(areaInfrastruttura.getId()).isPresent())
            return Optional.of(super.save(areaInfrastruttura));
        return Optional.empty();
    }
}
