package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.*;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimplePrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneOmbrelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrenotazioneOmbrelloneService extends AbstractService<SimplePrenotazioneOmbrellone,PrenotazioneOmbrelloneRepository>{

    private final RigaCatalogoOmbrelloneService catalogoOmbrelloni;

    @Autowired
    public PrenotazioneOmbrelloneService(PrenotazioneOmbrelloneRepository repository, RigaCatalogoOmbrelloneService catalogoOmbrelloni) {
        super(repository);
        this.catalogoOmbrelloni = catalogoOmbrelloni;
    }

    public List<SimpleRigaCatalogoOmbrellone> getRigheOmbrelloniDisponibili(Date data, FasciaOraria fasciaOraria) {
        return catalogoOmbrelloni.getAll()
                .stream()
                .filter(riga -> this.filtraBy(data, fasciaOraria).stream().noneMatch(p -> p.getOmbrellone().equals(riga.getValore())))
                .collect(Collectors.toList());
    }

    public List<SimplePrenotazioneOmbrellone> filtraBy(Date data, FasciaOraria fasciaOraria) {
        return super.getAll().stream()
                .filter(p -> p.getDataPrenotazione().equals(data) && p.getFasciaOraria().equals(fasciaOraria))
                .collect(Collectors.toList());
    }

    public List<SimplePrenotazioneOmbrellone> filtraBy(boolean statoPagamento) {
        return super.getBy(p -> p.getVendita().isPagata() == statoPagamento);
    }

    public List<SimplePrenotazioneOmbrellone> filtraBy(Utente utente) {
        return super.getBy(p -> p.getVendita().getUtente().equals(utente));
    }


}
