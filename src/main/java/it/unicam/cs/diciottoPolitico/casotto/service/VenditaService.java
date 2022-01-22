package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimplePrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimplePrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.repository.OrdinazioneBarRepository;
import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneAttivitaRepository;
import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneOmbrelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenditaService {

    private final PrenotazioneAttivitaRepository prenotazioneAttivitaRepository;
    private final PrenotazioneOmbrelloneRepository prenotazioneOmbrelloneRepository;
    private final OrdinazioneBarRepository ordinazioneBarRepository;

    @Autowired
    public VenditaService(PrenotazioneAttivitaRepository prenotazioneAttivitaRepository, PrenotazioneOmbrelloneRepository prenotazioneOmbrelloneRepository, OrdinazioneBarRepository ordinazioneBarRepository) {
        this.prenotazioneAttivitaRepository = prenotazioneAttivitaRepository;
        this.prenotazioneOmbrelloneRepository = prenotazioneOmbrelloneRepository;
        this.ordinazioneBarRepository = ordinazioneBarRepository;
    }

    public List<SimplePrenotazioneOmbrellone> getPrenotazioniOmbrelloneDaPagare(){
        return prenotazioneOmbrelloneRepository.findAll().stream()
                .filter(vendita -> !vendita.isPagata())
                .collect(Collectors.toList());
    }

    public SimplePrenotazioneOmbrellone saldaPrenotazioneOmbrellone(SimplePrenotazioneOmbrellone prenotazioneOmbrellone){
        return this.prenotazioneOmbrelloneRepository.save(prenotazioneOmbrellone);
    }

    public List<SimplePrenotazioneAttivita> getPrenotazioniAttivitaDaPagare(){
        return prenotazioneAttivitaRepository.findAll().stream()
                .filter(vendita -> !vendita.isPagata())
                .collect(Collectors.toList());
    }

    public SimplePrenotazioneAttivita saldaPrenotazioneAttivita(SimplePrenotazioneAttivita prenotazioneAttivita){
        return this.prenotazioneAttivitaRepository.save(prenotazioneAttivita);
    }
    public List<SimpleOrdinazioneBar> getOrdinazioniBarDaPagare(){
        return ordinazioneBarRepository.findAll().stream()
                .filter(vendita -> !vendita.isPagata())
                .collect(Collectors.toList());
    }

    public SimpleOrdinazioneBar saldaOrdinazioneBar(SimpleOrdinazioneBar ordinazioneBar){
        return this.ordinazioneBarRepository.save(ordinazioneBar);
    }

}