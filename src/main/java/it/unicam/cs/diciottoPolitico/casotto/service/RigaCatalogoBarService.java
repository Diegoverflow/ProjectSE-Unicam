package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RigaCatalogoBarService extends AbstractService<SimpleRigaCatalogoBar, RigaCatalogoBarRepository> {

    @Autowired
    public RigaCatalogoBarService(RigaCatalogoBarRepository repository) {
        super(repository);
    }

}
