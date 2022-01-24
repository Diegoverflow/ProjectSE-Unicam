package it.unicam.cs.diciottoPolitico.casotto.service;


import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
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

    public List<SimpleRigaCatalogoOmbrellone> getOmbrelloniDisponibili(Date data, FasciaOraria fasciaOraria) {
        return this.getRighe().
                stream().
                filter(r->r.getPrenotazioni().stream().noneMatch(p->p.getDataPrenotazione().equals(data) && p.getFasciaOraria().equals(fasciaOraria)))
                .collect(Collectors.toList());
    }

    public List<SimplePrenotazioneOmbrellone> getPrenotazioniOmbrelloneBy(UUID idOmbrellone){
        return super.repository.
                findAll().
                stream().
                parallel().
                filter(rigaCatalogoOmbrellone ->
                        rigaCatalogoOmbrellone.
                                getValore().
                                getId().
                                equals(idOmbrellone)).
                map(SimpleRigaCatalogoOmbrellone::getPrenotazioni).
                findFirst().
                orElse(null);
    }

    /*List<SimplePrenotazioneOmbrellone> prenotazioni = new ArrayList<>();
        this.rigaCatalogoOmbrelloneRepository.
                findAll().
                stream().
                parallel().
                filter(rigaCatalogoOmbrellone ->
                        rigaCatalogoOmbrellone.
                                getValore().
                                getId().
                                equals(idOmbrellone)).
                                findFirst().
                                ifPresent(rigaCatalogoOmbrellone ->
                                        prenotazioni.
                                        addAll(rigaCatalogoOmbrellone.getPrenotazioni()));
        return prenotazioni;*/

}
