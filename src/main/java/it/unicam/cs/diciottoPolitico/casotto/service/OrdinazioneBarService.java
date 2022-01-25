package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.StatusOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.OrdinazioneBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service delle ordinazioni bar.
 * Esso si occupa di gestire le operazioni CRUD riguardanti la {@link SimpleOrdinazioneBar} interagendo con il relativo
 * {@link OrdinazioneBarRepository}.
 *
 * @see SimpleOrdinazioneBar
 * @see OrdinazioneBarRepository
 */
@Service
public class OrdinazioneBarService extends AbstractService<SimpleOrdinazioneBar, OrdinazioneBarRepository> {

    @Autowired
    public OrdinazioneBarService(OrdinazioneBarRepository repository) {
        super(repository);
    }

    public List<SimpleOrdinazioneBar> filtraBy(StatusOrdinazioneBar status) {
        return super.getBy(o -> o.getStatusOrdinazioneBar().equals(status));
    }

    public List<SimpleOrdinazioneBar> filtraBy(SimpleArticoloBar articoloBar){
        return super.getBy(o->o.getArticoloBar().equals(articoloBar));
    }

    public List<SimpleOrdinazioneBar> filtraBy(String nomeArticoloBar){
        return super.getBy(o->o.getArticoloBar().getNome().equals(nomeArticoloBar));
    }

}
