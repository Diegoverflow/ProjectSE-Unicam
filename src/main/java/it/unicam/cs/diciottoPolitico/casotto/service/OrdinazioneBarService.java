package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.repository.OrdinazioneBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdinazioneBarService {

    private final OrdinazioneBarRepository repository;

    @Autowired
    public OrdinazioneBarService(OrdinazioneBarRepository repository) {
        this.repository = repository;
    }


}
