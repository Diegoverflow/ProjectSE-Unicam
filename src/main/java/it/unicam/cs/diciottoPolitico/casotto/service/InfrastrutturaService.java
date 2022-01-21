package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.AreaInfrastruttura;
import it.unicam.cs.diciottoPolitico.casotto.repository.InfrastrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfrastrutturaService {

    private final InfrastrutturaRepository infrastrutturaRepository;

    @Autowired
    public InfrastrutturaService(InfrastrutturaRepository infrastrutturaRepository) {
        this.infrastrutturaRepository = infrastrutturaRepository;
    }

    public List<AreaInfrastruttura> getAllAree() {
        return this.infrastrutturaRepository.findAll();
    }

    public Optional<AreaInfrastruttura> getAreaByName(String nameArea) {
        return this.infrastrutturaRepository.findAll()
                .stream()
                .filter(a -> a.getNome().equals(nameArea))
                .findFirst();
    }

    public AreaInfrastruttura addArea(AreaInfrastruttura areaInfrastruttura) {
        return this.infrastrutturaRepository.save(areaInfrastruttura);
    }

    public void removeArea(AreaInfrastruttura areaInfrastruttura) {
        this.infrastrutturaRepository.delete(areaInfrastruttura);
    }

    public boolean updateArea(AreaInfrastruttura areaInfrastruttura) {
        if (this.infrastrutturaRepository.findById(areaInfrastruttura.getId()).isPresent()) {
            this.infrastrutturaRepository.save(areaInfrastruttura);
            return true;
        }
        return false;
    }

}
