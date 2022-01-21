package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.OrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneOmbrellone;
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

    public List<PrenotazioneOmbrellone> getPrenotazioniOmbrelloneDaPagare(){
        return prenotazioneOmbrelloneRepository.findAll().stream()
                .filter(vendita -> !vendita.isPagata())
                .collect(Collectors.toList());
    }

    public PrenotazioneOmbrellone saldaPrenotazioneOmbrellone(PrenotazioneOmbrellone prenotazioneOmbrellone){
        return this.prenotazioneOmbrelloneRepository.save(prenotazioneOmbrellone);
    }

    public List<PrenotazioneAttivita> getPrenotazioniAttivitaDaPagare(){
        return prenotazioneAttivitaRepository.findAll().stream()
                .filter(vendita -> !vendita.isPagata())
                .collect(Collectors.toList());
    }

    public PrenotazioneAttivita saldaPrenotazioneAttivita(PrenotazioneAttivita prenotazioneAttivita){
        return this.prenotazioneAttivitaRepository.save(prenotazioneAttivita);
    }
    public List<OrdinazioneBar> getOrdinazioniBarDaPagare(){
        return ordinazioneBarRepository.findAll().stream()
                .filter(vendita -> !vendita.isPagata())
                .collect(Collectors.toList());
    }

    public OrdinazioneBar saldaOrdinazioneBar(OrdinazioneBar ordinazioneBar){
        return this.ordinazioneBarRepository.save(ordinazioneBar);
    }

}