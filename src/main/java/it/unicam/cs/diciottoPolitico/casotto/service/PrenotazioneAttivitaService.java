package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneAttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneAttivitaService {

    private final PrenotazioneAttivitaRepository repository;

    @Autowired
    public PrenotazioneAttivitaService(PrenotazioneAttivitaRepository repository) {
        this.repository = repository;
    }

    // TODO: 24/01/22 completare
}
