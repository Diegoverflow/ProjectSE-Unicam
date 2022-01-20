package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatologoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoAttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RigaCatalogoAttivitaService {

    private final RigaCatalogoAttivitaRepository repository;

    @Autowired
    public RigaCatalogoAttivitaService(RigaCatalogoAttivitaRepository repository) {
        this.repository = repository;
    }

    public List<SimpleRigaCatologoAttivita> getRighe() {
        return repository.findAll();
    }

    public SimpleRigaCatologoAttivita addRiga(SimpleRigaCatologoAttivita rigaCatologoAttivita){
        return this.repository.save(rigaCatologoAttivita);
    }

    public void removeRiga(SimpleRigaCatologoAttivita rigaCatologoAttivita){
        this.repository.delete(rigaCatologoAttivita);
    }

    public boolean updateRiga (double prezzo, SimpleRigaCatologoAttivita rigaCatologoAttivita){
        if (this.repository.findById(rigaCatologoAttivita.getId()).isPresent()){
            rigaCatologoAttivita.setPrezzo(prezzo);
            this.repository.save(rigaCatologoAttivita);
            return true;
        }
        return false;
    }

    public boolean updateRiga (PrenotazioneAttivita prenotazioneAttivita, SimpleRigaCatologoAttivita rigaCatologoAttivita){
        if (this.repository.findById(rigaCatologoAttivita.getId()).isPresent()){
            rigaCatologoAttivita.getPrenotazioniAttivita().add(prenotazioneAttivita);
            this.repository.save(rigaCatologoAttivita);
            return true;
        }
        return false;
    }
}
