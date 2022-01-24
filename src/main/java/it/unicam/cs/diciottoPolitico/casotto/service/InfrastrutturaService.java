package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.AreaInfrastruttura;
import it.unicam.cs.diciottoPolitico.casotto.repository.InfrastrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service dell' infrastruttura dello chalet.
 * Esso si occupa di gestire le operazioni CRUD riguardanti l' {@link AreaInfrastruttura} interagendo con il relativo
 * {@link InfrastrutturaRepository}.
 *
 * @see AreaInfrastruttura
 * @see InfrastrutturaRepository
 */
@Service
public class InfrastrutturaService {

    @Autowired
    private InfrastrutturaRepository infrastrutturaRepository;

    /**
     * Restituisce la lista di tutte le aree presenti nel database.
     *
     * @return la lista di tutte le aree presenti nel database
     */
    public List<AreaInfrastruttura> getAllAree() {
        return this.infrastrutturaRepository.findAll();
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
        return this.infrastrutturaRepository.findAll()
                .stream()
                .filter(a -> a.getNome().equals(nome))
                .findFirst();
    }

    /**
     * Aggiunge l' {@link AreaInfrastruttura} specificata al database.
     * Restituisce un {@link Optional} che descrive l' {@code AreaInfrastruttura}
     * oppure un empty {@code Optional} se l' area &egrave; gi&agrave; presente nel database.
     *
     * @param areaInfrastruttura l' area da aggiungere al database
     * @return un {@code Optional} che descrive l' {@code AreaInfrastruttura} da aggiungere al database
     * oppure un empty {@code Optional} se l' area &egrave; gi&agrave; presente nel database
     */
    public Optional<AreaInfrastruttura> addArea(AreaInfrastruttura areaInfrastruttura) {
        if (this.infrastrutturaRepository.findAll().stream().noneMatch(a -> a.equals(areaInfrastruttura)))
            return Optional.of(this.infrastrutturaRepository.save(areaInfrastruttura));
        return Optional.empty();
    }

    /**
     * Aggiorna l' {@link AreaInfrastruttura} specificata nel database.
     * Restituisce un {@link Optional} che descrive l' {@code AreaInfrastruttura} aggiornata nel database
     * oppure un empty {@code Optional} se l' area non &egrave; presente nel database.
     *
     * @param areaInfrastruttura l'{@code AreaInfrastruttura} da aggiornare dal database
     * @return un {@code Optional} che descrive l' {@code AreaInfrastruttura} aggiornata nel database
     * oppure un empty {@code Optional} se l' area non &egrave; presente nel database
     */
    public Optional<AreaInfrastruttura> updateArea(AreaInfrastruttura areaInfrastruttura) {
        if (this.infrastrutturaRepository.findById(areaInfrastruttura.getId()).isPresent())
            return Optional.of(this.infrastrutturaRepository.save(areaInfrastruttura));
        return Optional.empty();
    }

    /**
     * Rimuove l' {@link AreaInfrastruttura} avente id specificato dal database.
     * Restituisce un {@link Optional} che descrive l' {@code AreaInfrastruttura} rimossa dal database
     * oppure un empty {@code Optional} se l' area non &egrave; presente nel database.
     *
     * @param id l' id dell' {@code AreaInfrastruttura} da rimuovere dal database
     * @return un {@code Optional} che descrive l' {@code AreaInfrastruttura} rimossa dal database
     * oppure un empty {@code Optional} se l' area non &egrave; presente nel database
     */
    public Optional<AreaInfrastruttura> removeAreaBy(UUID id) {
        Optional<AreaInfrastruttura> foundArea = this.infrastrutturaRepository.findById(id);
        foundArea.ifPresent(areaInfrastruttura -> this.infrastrutturaRepository.delete(areaInfrastruttura));
        return foundArea;
    }

}
