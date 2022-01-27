package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.StatusOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.ArticoloBarRepository;
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

    private final ArticoloBarRepository articoloBarRepository;

    /**
     * Crea un service per le ordinazioni in base al repository degli articoli bar e iniettando il repository degli articoli bar specificati.
     *
     * @param articoloBarRepository il repository degli articoli bar
     * @param repository            il repository delle ordinazioni bar
     */
    @Autowired
    public OrdinazioneBarService(ArticoloBarRepository articoloBarRepository, OrdinazioneBarRepository repository) {
        super(repository);
        this.articoloBarRepository = articoloBarRepository;
    }

    /**
     * Restituisce la lista di tutte le ordinazioni effettuate dai clienti che si trovano nello {@link StatusOrdinazioneBar} specificato.
     *
     * @param status lo status in cui si devono trovare le ordinazioni
     * @return la lista di tutte le ordinazioni che si trovano nello {@code StatusOrdinazioneBar} specificato
     */
    public List<SimpleOrdinazioneBar> filtraBy(StatusOrdinazioneBar status) {
        return super.getBy(o -> o.getStatusOrdinazioneBar().equals(status));
    }

    /**
     * Restituisce la lista di tutte le ordinazioni effettuate dai clienti per il {@link SimpleArticoloBar} specificato.
     *
     * @param articoloBar l' articolo bar che devono avere le ordinazioni
     * @return la lista di tutte le ordinazioni che riguardano il {@code SimpleArticoloBar}
     */
    public List<SimpleOrdinazioneBar> filtraBy(SimpleArticoloBar articoloBar) {
        return super.getBy(o -> o.getArticoloBar().equals(articoloBar));
    }

    /**
     * Restituisce la lista delle ordinazioni effettuate dai clienti per il nome specificato del {@link SimpleArticoloBar}.
     *
     * @param nomeArticoloBar il nome dell' articolo bar del {@code SimpleArticoloBar} della {@link SimpleOrdinazioneBar}
     * @return la lista di tutte le ordinazioni che riguardano il nome del {@code SimpleArticoloBar}
     */
    public List<SimpleOrdinazioneBar> filtraBy(String nomeArticoloBar) {
        return super.getBy(o -> o.getArticoloBar().getNome().equals(nomeArticoloBar));
    }

    /**
     * Esegue un controllo sulla presenza del {@link SimpleArticoloBar} nella {@link SimpleOrdinazioneBar} specificata.
     * Restituisce un empty {@link Optional} se non viene trovato nessun {@code SimpleArticoloBar} specificato nel database, altrimenti memorizza l' ordinazione
     * specificata nel database e restituisce un {@code Optional} che descrive la {@code SimpleOrdinazioneBar} memorizzata.
     *
     * @param ordinazione l' ordinazione di cui eseguire il controllo e memorizzarla nel database
     * @return un empty {@link Optional} se non viene trovato nessun articolo della {@code SimpleOrdinazioneBar} specificata nel database, altrimenti memorizza l' ordinazione
     * specificata nel database e restituisce un {@code Optional} che descrive la {@code SimpleOrdinazioneBar} memorizzata.
     */
    public Optional<SimpleOrdinazioneBar> checkAndSave(SimpleOrdinazioneBar ordinazione) {
        if (this.checkArticolo(ordinazione.getArticoloBar()).isEmpty())
            return Optional.empty();
        return Optional.of(super.save(ordinazione));
    }

    /*/** // TODO: inserire update?
     * Esegue un controllo sulla presenza della {@link SimpleOrdinazioneBar} specificata in base al proprio id.
     * Restituisce un empty {@link Optional} se non viene trovata nessuna ordinazione con id dell' ordinazione specificata nel database, altrimenti aggiorna l' ordinazione
     * specificata nel database e restituisce un {@code Optional} che descrive la {@code SimpleOrdinazioneBar} aggiornata.
     *
     * @param ordinazione l' ordinazione di cui eseguire il controllo e aggiornarla nel database
     * @return un empty {@code Optional} se non viene trovata nessuna ordinazione con id dell' ordinazione specificata nel database, altrimenti aggiorna l' ordinazione
     * specificata nel database e restituisce un {@code Optional} che descrive la {@code SimpleOrdinazioneBar} aggiornata.
     */
    /*public Optional<SimpleOrdinazioneBar> checkAndUpdate(SimpleOrdinazioneBar ordinazione) {
        if (super.getBy(ordinazione.getId()).isPresent() && riga.getPrezzo() >= 0 && riga.getQuantita() >= 0)
            return Optional.of(super.save(riga));
        return Optional.empty();
    }*/

    private Optional<SimpleArticoloBar> checkArticolo(SimpleArticoloBar articoloBar) {
        return this.articoloBarRepository.findById(articoloBar.getId());
    }


}
