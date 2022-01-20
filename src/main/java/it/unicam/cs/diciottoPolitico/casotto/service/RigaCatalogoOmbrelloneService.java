package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoOmbrelloneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RigaCatalogoOmbrelloneService {
    private final RigaCatalogoOmbrelloneRepository rigaCatalogoOmbrelloneRepository;

    public RigaCatalogoOmbrelloneService(RigaCatalogoOmbrelloneRepository rigaCatalogoOmbrelloneRepository){
        this.rigaCatalogoOmbrelloneRepository = Objects.requireNonNull(rigaCatalogoOmbrelloneRepository);
    }

    public List<RigaCatalogoOmbrellone> getRighe() {
        return rigaCatalogoOmbrelloneRepository.findAll();
    }


}
