package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimplePrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneAttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneAttivitaService extends AbstractService<SimplePrenotazioneAttivita,PrenotazioneAttivitaRepository>{

    private final RigaCatalogoAttivitaService catalogoAttivita;

    @Autowired
    public PrenotazioneAttivitaService(PrenotazioneAttivitaRepository repository, RigaCatalogoAttivitaService catalogoAttivita) {
        super(repository);
        this.catalogoAttivita = catalogoAttivita;
    }

    public List<SimplePrenotazioneAttivita> filtraBy(SimpleAttivita attivita){
        return super.getBy(prenotazioneAttivita->
                prenotazioneAttivita.getAttivita().equals(attivita));
    }

    public List<SimplePrenotazioneAttivita> filtraBy(String nomeAttivita){
        return super.getBy(prenotazioneAttivita->
                prenotazioneAttivita.getAttivita().getNome().equals(nomeAttivita));
    }

    @Override
    public SimplePrenotazioneAttivita save(SimplePrenotazioneAttivita prenotazioneAttivita){
        this.catalogoAttivita.
                getBy(prenotazioneAttivita.getAttivita().getId()).ifPresent(r->
                r.setPostiOccupati(r.getPostiOccupati()+1));
        return super.save(prenotazioneAttivita);
    }


}
