package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.AreaInfrastruttura;
import it.unicam.cs.diciottoPolitico.casotto.repository.InfrastrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// TODO: completare javadoc
@Service
public class InfrastrutturaService {

    @Autowired
    private InfrastrutturaRepository infrastrutturaRepository;

    /**
     * Restituisce la lista di tutte le aree presenti nella tabella relativa alle aree infrastruttura del database.
     *
     * @return la lista di tutte le aree presenti nel database
     */
    public List<AreaInfrastruttura> getAllAree() {
        return this.infrastrutturaRepository.findAll();
    }

    /**
     * Restituisce un {@link Optional} che descrive un' {@link AreaInfrastruttura} avente il nome specificato
     * oppure un empty {@code Optional} se non viene trovata nessun' area con il nome specificato.
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

    public Optional<AreaInfrastruttura> addArea(AreaInfrastruttura areaInfrastruttura) {
        if (this.infrastrutturaRepository.findAll().stream().noneMatch(a -> a.equals(areaInfrastruttura)))
            return Optional.of(this.infrastrutturaRepository.save(areaInfrastruttura));
        return Optional.empty();
    }

    public Optional<AreaInfrastruttura> removeAreaBy(UUID id) {
        Optional<AreaInfrastruttura> foundArea = this.infrastrutturaRepository.findById(id);
        foundArea.ifPresent(areaInfrastruttura -> this.infrastrutturaRepository.delete(areaInfrastruttura));
        return foundArea;
    }

    public Optional<AreaInfrastruttura> updateArea(AreaInfrastruttura areaInfrastruttura) {
        if (this.infrastrutturaRepository.findById(areaInfrastruttura.getId()).isPresent())
            return Optional.of(this.infrastrutturaRepository.save(areaInfrastruttura));
        return Optional.empty();
    }

}
