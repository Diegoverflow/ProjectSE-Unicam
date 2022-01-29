package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service del catalogo bar.
 * Esso si occupa di gestire le operazioni CRUD riguardanti la {@link SimpleRigaCatalogoBar} interagendo con il relativo
 * {@link RigaCatalogoBarRepository}.
 *
 * @see SimpleRigaCatalogoBar
 * @see RigaCatalogoBarRepository
 */
@Service
public class RigaCatalogoBarService extends AbstractService<SimpleRigaCatalogoBar, RigaCatalogoBarRepository> {

    @Autowired
    public RigaCatalogoBarService(RigaCatalogoBarRepository repository) {
        super(repository);
    }

    /**
     * Restituisce la lista di tutte le righe bar aventi quantit&agrave; minore o uguale alla quantit&agrave; specificata.
     *
     * @param quantitaLimite la quantit&agrave; limite inclusa
     * @return la lista di tutte le righe bar aventi quantit&agrave; minore o uguale alla quantit&agrave; specificata
     */
    public List<SimpleRigaCatalogoBar> filtraBy(int quantitaLimite) {
        return super.getBy(p -> p.getQuantita() <= quantitaLimite);
    }

    /**
     * Restituisce la lista di tutte le righe bar aventi prezzo minore o uguale al prezzo specificato.
     *
     * @param prezzoLimite il prezzo limite incluso
     * @return la lista di tutte le righe bar aventi prezzo minore o uguale al prezzo specificato
     */
    public List<SimpleRigaCatalogoBar> filtraBy(double prezzoLimite) {
        return super.getBy(p -> p.getPrezzo() <= prezzoLimite);
    }

    /**
     * Restituisce un {@link Optional} che descrive una {@link SimpleRigaCatalogoBar} avente come {@link SimpleArticoloBar} l' articolo bar specificato
     * oppure un empty {@code Optional} se non viene trovata nessuna riga avente l' articolo bar specificato nel database.
     *
     * @param articoloBar l' articolo bar di cui ricavare la riga
     * @return un {@code Optional} che descrive una {@code SimpleRigaCatalogoBar} avente l' articolo bar specificato
     * oppure un empty {@code Optional} se non viene trovata nessuna riga con l' articolo bar specificato
     */
    public Optional<SimpleRigaCatalogoBar> getRigaBy(SimpleArticoloBar articoloBar) {
        return super.getBy(p -> p.getValore().equals(articoloBar)).stream().findFirst();
    }

    /**
     * Restituisce un {@link Optional} che descrive una {@link SimpleRigaCatalogoBar} avente come nome del {@link SimpleArticoloBar} il nome specificato
     * oppure un empty {@code Optional} se non viene trovata nessuna riga avente il nome dell' articolo bar specificato nel database.
     *
     * @param nomeArticolo il nome dell' articolo bar di cui ricavare la riga
     * @return un {@code Optional} che descrive una {@code SimpleRigaCatalogoBar} avente il nome dell' articolo bar specificato
     * oppure un empty {@code Optional} se non viene trovata nessuna riga con il nome dell' articolo bar specificato
     */
    public Optional<SimpleRigaCatalogoBar> getRigaBy(String nomeArticolo) {
        return super.getBy(riga -> riga.getValore().getNome().equals(nomeArticolo)).stream().findFirst();
    }

    /**
     * Esegue un controllo sulla presenza della {@link SimpleRigaCatalogoBar} specificata in base al proprio id e il proprio {@link SimpleArticoloBar} contenuto.
     * Restituisce un empty {@link Optional} se non viene trovata nessuna riga con id e articolo bar della riga specificata nel database, altrimenti memorizza la riga
     * specificata nel database e restituisce un {@code Optional} che descrive la {@code SimpleRigaCatalogoBar} memorizzata.
     *
     * @param riga la riga di cui eseguire il controllo e memorizzarla nel database
     * @return un empty {@link Optional} se non viene trovata nessuna riga con id e articolo bar della riga specificata nel database, altrimenti memorizza la riga
     * specificata nel database e restituisce un {@code Optional} che descrive la {@code SimpleRigaCatalogoBar} memorizzata.
     */
    public Optional<SimpleRigaCatalogoBar> checkAndSave(SimpleRigaCatalogoBar riga) {
        if (super.getBy(riga.getId()).isEmpty() && this.getRigaBy(riga.getValore()).isEmpty() && riga.getPrezzo() >= 0 && riga.getQuantita() >= 0)
            return Optional.of(super.save(riga));
        return Optional.empty();
    }

    /**
     * Esegue un controllo sulla presenza della {@link SimpleRigaCatalogoBar} specificata in base al proprio id.
     * Restituisce un empty {@link Optional} se non viene trovata nessuna riga con id della riga specificata nel database, altrimenti aggiorna la riga
     * specificata nel database e restituisce un {@code Optional} che descrive la {@code SimpleRigaCatalogoBar} aggiornata.
     *
     * @param riga la riga di cui eseguire il controllo e aggiornarla nel database
     * @return un empty {@code Optional} se non viene trovata nessuna riga con id della riga specificata nel database, altrimenti aggiorna la riga
     * specificata nel database e restituisce un {@code Optional} che descrive la {@code SimpleRigaCatalogoBar} aggiornata.
     */
    public Optional<SimpleRigaCatalogoBar> checkAndUpdate(SimpleRigaCatalogoBar riga) {
        if (super.getBy(riga.getId()).isPresent() && riga.getPrezzo() >= 0 && riga.getQuantita() >= 0)
            return Optional.of(super.save(riga));
        return Optional.empty();
    }

}
