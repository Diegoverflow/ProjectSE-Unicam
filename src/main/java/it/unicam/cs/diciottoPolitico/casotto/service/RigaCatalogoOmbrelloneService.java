package it.unicam.cs.diciottoPolitico.casotto.service;


import it.unicam.cs.diciottoPolitico.casotto.entity.Categoria;
import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimplePrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoOmbrelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RigaCatalogoOmbrelloneService extends AbstractService<SimpleRigaCatalogoOmbrellone, RigaCatalogoOmbrelloneRepository> {

    @Autowired
    public RigaCatalogoOmbrelloneService(RigaCatalogoOmbrelloneRepository repository) {
        super(repository);
    }

    public List<Ombrellone> getAllOmbrelloni() {
        return super.getAll()
                .stream()
                .map(SimpleRigaCatalogoOmbrellone::getValore)
                .collect(Collectors.toList());
    }

    public Optional<SimpleRigaCatalogoOmbrellone> getRigaBy(UUID id){
        return super.getBy(id);
    }

    public Optional<SimpleRigaCatalogoOmbrellone> getRigaBy(Ombrellone ombrellone) {
        return super.getBy(riga->riga.getValore().equals(ombrellone))
                .stream()
                .findFirst();
    }

    public List<SimpleRigaCatalogoOmbrellone> filterBy(Categoria categoria) {
        return super.getBy(riga -> riga.getValore().getCategoria().equals(categoria));
    }

    public List<SimpleRigaCatalogoOmbrellone> filterBy(double prezzoLimite) {
        return super.getBy(riga -> riga.getPrezzoOmbrellone() <= prezzoLimite);
    }

    public List<SimpleRigaCatalogoOmbrellone> filterBy(String codiceSpiaggia) {
        return super.getBy(riga -> riga.getValore().getCodiceSpiaggia().equals(codiceSpiaggia));
    }

}
