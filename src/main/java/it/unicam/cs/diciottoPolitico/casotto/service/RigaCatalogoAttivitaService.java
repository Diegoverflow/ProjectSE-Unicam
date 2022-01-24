package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoAttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RigaCatalogoAttivitaService extends AbstractService<SimpleRigaCatalogoAttivita, RigaCatalogoAttivitaRepository>{

    @Autowired
    private RigaCatalogoAttivitaRepository repository;

    public RigaCatalogoAttivitaService(RigaCatalogoAttivitaRepository repository) {
        super(repository);
    }

    public List<SimpleRigaCatalogoAttivita> getAttivitaLibereDa_A_(Date Da_, Date A_){
        return this.repository.findAll().
                stream().
                filter(r->r.getValore().getDataOrarioInizio().after(Da_)&&
                        r.getValore().getDataOrarioFine().before(A_)).collect(Collectors.toList());
    }


}
