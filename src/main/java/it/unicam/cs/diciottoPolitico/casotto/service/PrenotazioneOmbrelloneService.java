package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneOmbrelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneOmbrelloneService {

    private final PrenotazioneOmbrelloneRepository repository;

    @Autowired
    public PrenotazioneOmbrelloneService(PrenotazioneOmbrelloneRepository repository) {
        this.repository = repository;
    }
    // TODO: 24/01/22 completare 
}
